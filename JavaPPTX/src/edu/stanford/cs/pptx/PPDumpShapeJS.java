/*
 * File: PPSaveJS.java
 * ---------------------
 * This package class encapsulates the extensive code necessary to save a
 * PowerPoint show to a .js and .html file.
 */

package edu.stanford.cs.pptx;

//import java.io.File;
import java.io.IOException;
import java.io.FileOutputStream;
import java.lang.Math;
import java.io.File;


import edu.stanford.cs.pptx.effect.AnimationEffect;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;

public class PPDumpShapeJS {

    private ArrayList<AnimationEffect> animations = new ArrayList<AnimationEffect>();
    private int[] renderIDs;
    private int onClickCounter = 0; //keeps track of order for multiple onclick events 

    public PPDumpShapeJS(){
        
    }
    //need moving to get data from the animation class
    //need moving to not delete things below it
    //look into x`
    //stop being a schmo

    //this method creates the classes.js file
    public void fileInit(PPShape[] shapes, PPSlide slide,PPShow show){
        try{ //haven't redone line or oval also since clearRect is done, disappear is done
            File file = new File("../classes.js");
            FileOutputStream fop = new FileOutputStream(file);
            Dictionary classInit = new Hashtable<>();
            classInit.put("rect",false);
            classInit.put("line",false);
            fop.write("export {RectObj as default};\nimport ctx from './example.js'\n".getBytes());
            for(PPShape shape: shapes){
                if(shape.getTypeName().equals("PPRect")){
                    if (classInit.get("rect").equals(false)) {
                        classInit.put("rect",true);
                        fop.write("class RectObj{\n".getBytes());
                        fop.write("\tconstructor(x,y,height,width,color){\n".getBytes());
                        fop.write("\t\tthis.x = x;\n".getBytes());
                        fop.write("\t\tthis.y = y;\n".getBytes());
                        fop.write("\t\tthis.width = width;\n".getBytes());
                        fop.write("\t\tthis.height = height;\n".getBytes());
                        fop.write("\t\tthis.color = color;\n".getBytes());
                        fop.write("\t}\n".getBytes());
                        fop.write("\trenderRect(){\n".getBytes());
                        fop.write("\t\tctx.rect(this.x,this.y,this.height,this.width);\n".getBytes());
                        fop.write("\t\tctx.fillStyle = this.color;\n".getBytes());
                        fop.write("\t\tctx.fillRect(this.x,this.y,this.height,this.width);\n".getBytes());
                        fop.write("\t}\n".getBytes());
                        fop.write("\tclearRect(){\n".getBytes());
                        fop.write("\t\tctx.clearRect(this.x, this.y, this.height, this.width);\n".getBytes());
                        fop.write("\t}\n".getBytes());
                        fop.write("\tmove(){\n".getBytes());
                        fop.write("\t\tthis.clearRect();\n".getBytes());
                        fop.write("\t\tthis.x = this.x;\n".getBytes()); //change here for moving
                        fop.write("\t\tthis.y -=1;\n".getBytes());
                        fop.write("\t\tthis.renderRect();\n".getBytes());
                        fop.write("\t}\n".getBytes());
                        fop.write("\tmoveWrapper(interval){\n".getBytes());
                        fop.write("\t\tvar _this = this;\n".getBytes());
                        fop.write("\t\tsetInterval(function(){\n".getBytes());
                        fop.write("\t\t\t_this.move();\n".getBytes());
                        fop.write("\t\t},interval);\n".getBytes());
                        fop.write("\t}\n".getBytes());
                        fop.write("}\n".getBytes());
                    }
                }
            }
            fop.flush();
            fop.close();

        } catch (IOException ex) {
            throw new RuntimeException(ex.toString());
        }
    }

    public void objInit(FileOutputStream fop, PPShape[] shapes, PPSlide slide,PPShow show){
        for(PPShape shape: shapes){
            if(shape.getTypeName().equals("PPRect")){
                writeRect(fop,(PPRect)shape);
            }
        }
        
    }

    
    //Also, spend time researching JS best practices. I need to think about
    //the general structure here. Having everything output to a single func
    //might not be ideal. 
    //grect and gwindow 
    //spline motion paths   
    //fade would be good, look into global alphas (transperency)
    public void writeShapes(FileOutputStream fop, PPShape[] shapes, PPSlide slide){

        this.animations = slide.getAnimationList();
        this.renderIDs = new int[shapes.length+1];
        for(int i = 0;i<shapes.length+1;i++){
            renderIDs[i] = 0;
        }
        boolean startPath = true;
        writeAnimationsWrapper(fop);
        for(PPShape shape: shapes){
            if(shape.getTypeName().equals("PPRect")){
                if(renderIDs[shape.getShapeId()] == 0){ //this checks that the shape hasn't been written yet
                    renderRect(fop,(PPRect)shape);
                }
            } else if(shape.getTypeName().equals("PPLine")) {
                if(startPath){ //maybe should be small method
                    try{
                        fop.write("\tctx.beginPath();\n".getBytes());
                        startPath = false;
                    } catch (IOException ex) {
                        throw new RuntimeException(ex.toString());
                    }
                }
                writeLine(fop,(PPLine)shape);
            } else if(shape.getTypeName().equals("PPOval")) {
                if(startPath){
                    try{
                        fop.write("\tctx.beginPath();\n".getBytes());
                        startPath = false;
                    } catch (IOException ex) {
                        throw new RuntimeException(ex.toString());
                    }
                }
                writeOval(fop,(PPOval)shape);
            }
        }
    }

    private void writeAnimationsWrapper(FileOutputStream fop){
        try{
            fop.write("\tfunction sleep(s)\n \t{return new Promise(resolve => setTimeout(resolve, s*1000));\n\t}\n".getBytes());
        } catch (IOException ex) {
            throw new RuntimeException(ex.toString());
        }
        
        for(int i = 0;i<animations.size();i++){
            i+=writeAnimation(fop, i);
        }
    }   

    private int writeAnimation(FileOutputStream fop,int index){
        try{
            AnimationEffect animation = animations.get(index);
            int offset = 0;
            PPShape shape = animation.getShape();
            if (shape.getTypeName().equals("PPRect")){
                if (animation.getClass().getName().toString() == "edu.stanford.cs.pptx.effect.AppearEffect"){
                    if (animation.getTrigger() == "onClick"){
                        writeOnClick(fop);
                        renderRect(fop,(PPRect)shape);
                        try{
                            AnimationEffect nextAnimation = animations.get(index+1);
                            if (nextAnimation.getTrigger() == "withPrev"){
                                offset+=1+writeAnimation(fop, index+1);
                            } else if (nextAnimation.getTrigger() == "afterPrev"){
                                offset+=1+writeAnimation(fop, index+1);
                            }
                        } catch (IndexOutOfBoundsException ex){}

                        fop.write("\tcounter+=1;\n".getBytes());
                        fop.write("\tcanvas.addEventListener('click', click".getBytes());
                        fop.write(String.valueOf(onClickCounter).getBytes());
                        fop.write(");\n".getBytes());
                        fop.write("\t}}\n".getBytes());
                            
                    } else if (animation.getTrigger() == "withPrev"){
                        try{
                            renderRect(fop,(PPRect)shape);
                            AnimationEffect nextAnimation = animations.get(index+1);
                            if (nextAnimation.getTrigger() == "withPrev"){
                                offset+=1+writeAnimation(fop, index+1);
                            } else if (nextAnimation.getTrigger() == "afterPrev"){
                                offset+=1+writeAnimation(fop, index+1);
                            }
                        } catch (IndexOutOfBoundsException ex){}
                    } else if (animation.getTrigger() == "afterPrev"){
                        try{
                            fop.write("\tawait sleep(".getBytes());
                            fop.write(String.valueOf((int)(animation.getDelay())).getBytes());
                            fop.write(");\n".getBytes());
                            renderRect(fop,(PPRect)shape);
                            AnimationEffect nextAnimation = animations.get(index+1);
                            if (nextAnimation.getTrigger() == "withPrev"){
                                offset+=1+writeAnimation(fop, index+1);
                            } else if (nextAnimation.getTrigger() == "afterPrev"){
                                offset+=1+writeAnimation(fop, index+1);
                            }
                        } catch (IndexOutOfBoundsException ex){}
                    }
                } else if (animation.getClass().getName().toString() == "edu.stanford.cs.pptx.effect.LinearMotionEffect"){
                    if (animation.getTrigger() == "onClick"){
                        writeOnClick(fop);
                        fop.write("\trect".getBytes());
                        fop.write(String.valueOf((int)shape.getShapeId()).getBytes());
                        fop.write(".moveWrapper(1000/60);".getBytes());
                        try{
                            AnimationEffect nextAnimation = animations.get(index+1);
                            if (nextAnimation.getTrigger() == "withPrev"){
                                offset+=1+writeAnimation(fop, index+1);
                            } else if (nextAnimation.getTrigger() == "afterPrev"){
                                offset+=1+writeAnimation(fop, index+1);
                            }
                        } catch (IndexOutOfBoundsException ex){}

                        fop.write("\tcounter+=1;\n".getBytes());
                        fop.write("\tcanvas.addEventListener('click', click".getBytes());
                        fop.write(String.valueOf(onClickCounter).getBytes());
                        fop.write(");\n".getBytes());
                        fop.write("\t}}\n".getBytes());
                            
                    } else if (animation.getTrigger() == "withPrev"){
                        try{
                            fop.write("\trect".getBytes());
                            fop.write(String.valueOf((int)shape.getShapeId()).getBytes());
                            fop.write(".moveWrapper(1000/60);".getBytes());
                            AnimationEffect nextAnimation = animations.get(index+1);
                            if (nextAnimation.getTrigger() == "withPrev"){
                                offset+=1+writeAnimation(fop, index+1);
                            } else if (nextAnimation.getTrigger() == "afterPrev"){
                                offset+=1+writeAnimation(fop, index+1);
                            }
                        } catch (IndexOutOfBoundsException ex){}
                    } else if (animation.getTrigger() == "afterPrev"){
                        try{
                            fop.write("\tawait sleep(".getBytes());
                            fop.write(String.valueOf((int)(animation.getDelay())).getBytes());
                            fop.write(");\n".getBytes());
                            fop.write("\trect".getBytes());
                            fop.write(String.valueOf((int)shape.getShapeId()).getBytes());
                            fop.write(".moveWrapper(1000/60);".getBytes());
                            AnimationEffect nextAnimation = animations.get(index+1);
                            if (nextAnimation.getTrigger() == "withPrev"){
                                offset+=1+writeAnimation(fop, index+1);
                            } else if (nextAnimation.getTrigger() == "afterPrev"){
                                offset+=1+writeAnimation(fop, index+1);
                            }
                        } catch (IndexOutOfBoundsException ex){}
                    }
                } 
                
            }
            return offset; //return should be amount of withPrev called from this one
        }  catch (IOException ex) {
            throw new RuntimeException(ex.toString());
        } 
    }

    private void writeRect(FileOutputStream fop, PPRect rect){
        try{ 
            fop.write("var rect".getBytes());
            fop.write(String.valueOf((int)rect.getShapeId()).getBytes());
            fop.write(" = new RectObj(".getBytes());
            fop.write(String.valueOf((int)rect.getX()).getBytes());
            fop.write(",".getBytes());
            fop.write(String.valueOf((int)rect.getY()).getBytes());
            fop.write(",".getBytes());
            fop.write(String.valueOf((int)rect.getWidth()).getBytes());
            fop.write(",".getBytes());
            fop.write(String.valueOf((int)rect.getHeight()).getBytes());
            fop.write(",\"".getBytes());
            String hex = "#"+Integer.toHexString(rect.getFillColor().getRGB()).substring(2);
            fop.write(hex.getBytes());
            fop.write("\");\n".getBytes());
        } catch (IOException ex) {
            throw new RuntimeException(ex.toString());
        } 
    }

    private void renderRect(FileOutputStream fop, PPRect rect){
        try{ 
            fop.write("\trect".getBytes());
            fop.write(String.valueOf((int)rect.getShapeId()).getBytes());
            fop.write(".renderRect();\n".getBytes());
            renderIDs[rect.getShapeId()] = 1;
        } catch (IOException ex) {
            throw new RuntimeException(ex.toString());
        } 
    }



    private void writeLine(FileOutputStream fop, PPLine line){

        try {
            
            fop.write("\tctx.moveTo(".getBytes());
            fop.write(String.valueOf((int)line.getWidth()).getBytes());
            fop.write(",".getBytes());
            fop.write(String.valueOf((int)line.getHeight()).getBytes());
            fop.write(");\n".getBytes());
            fop.write("\tctx.lineTo(".getBytes());
            fop.write(String.valueOf((int)line.getX()).getBytes()); //need help with this, not sure how to get second set of coords for the line
            fop.write(",".getBytes());
            fop.write(String.valueOf((int)line.getY()).getBytes()); 
            fop.write(");\n".getBytes());
            

        } catch (IOException ex) {
            throw new RuntimeException(ex.toString());
        } 

    }

    private void writeOval(FileOutputStream fop, PPOval oval){ //weird oval behavior, different from pptx
        try {
            
            fop.write("\tctx.ellipse(".getBytes()); //params: x, y, radiusX, radiusY, rotation, startAngle, endAngle
            fop.write(String.valueOf((double)oval.getX()).getBytes());
            fop.write(",".getBytes());
            fop.write(String.valueOf((double)oval.getY()).getBytes());
            fop.write(",".getBytes());
            fop.write(String.valueOf((double)oval.getWidth()/2).getBytes()); 
            fop.write(",".getBytes());
            fop.write(String.valueOf((double)oval.getHeight()/2).getBytes());
            fop.write(",".getBytes());
            fop.write(String.valueOf(0).getBytes()); //rotation
            fop.write(",".getBytes());
            fop.write(String.valueOf(0).getBytes()); //startAngle
            fop.write(",".getBytes());
            fop.write(String.valueOf((double)Math.PI*2).getBytes()); //endAngle
            fop.write(");\n".getBytes());

            if(!(oval.getFillColor().equals(null))){

                fop.write("\tctx.fillStyle = '".getBytes());
                String hex = "#"+Integer.toHexString(oval.getFillColor().getRGB()).substring(2);
                fop.write(hex.getBytes());
                fop.write("';\n".getBytes());
                fop.write("\tctx.fill();\n".getBytes());

            }

        } catch (IOException ex) {
            throw new RuntimeException(ex.toString());
        } 
    }

    public void writeOnClick(FileOutputStream fop){

        try{
            if(onClickCounter == 0){
                fop.write("\tvar counter = 0;\n".getBytes());
                fop.write("\tcanvas.addEventListener('click', click0);\n".getBytes());
            }
            fop.write("\tasync function click".getBytes());
            fop.write(String.valueOf(onClickCounter).getBytes());
            fop.write("(){\n".getBytes());
            fop.write("\t\tif (counter==".getBytes());
            fop.write(String.valueOf(onClickCounter).getBytes());
            fop.write("){\n".getBytes());
            onClickCounter+=1;

            //at this point return to calling program, but calling program needs to deal with closing parentheses
            //and with adding the next event listener. Currently there will be one eronious event listener

        } catch (IOException ex) {
            throw new RuntimeException(ex.toString());
        } 
    }

    public void writeWithPrev(FileOutputStream fop){
        try{
            fop.write("".getBytes());
        } catch (IOException ex) {
            throw new RuntimeException(ex.toString());
        } 
    }
}