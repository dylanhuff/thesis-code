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

import edu.stanford.cs.pptx.effect.AnimationEffect;
import java.util.ArrayList;

public class PPDumpShapeJS {

    private ArrayList<AnimationEffect> animations = new ArrayList<AnimationEffect>();
    private int[] writtenIDs;
    private int onClickCounter = 0; //keeps track of order for multiple onclick events 

    public PPDumpShapeJS(){
        
    }
    //Also, spend time researching JS best practices. I need to think about
    //the general structure here. Having everything output to a single func
    //might not be ideal. 
    public void writeShapes(FileOutputStream fop, PPShape[] shapes, PPSlide slide){

        this.animations = slide.getAnimationList();
        this.writtenIDs = new int[shapes.length+1];
        for(int i = 0;i<shapes.length+1;i++){
            writtenIDs[i] = 0;
        }
        boolean startPath = true;

        writeAnimationsWrapper(fop);
        for(PPShape shape: shapes){
            if(shape.getTypeName().equals("PPRect")){
                if(writtenIDs[shape.getShapeId()] == 0){ //this checks that the shape hasn't been written yet
                    writeRect(fop,(PPRect)shape);
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
                        writeRect(fop,(PPRect)shape);
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
                            writeRect(fop,(PPRect)shape);
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
                            writeRect(fop,(PPRect)shape);
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
            
            fop.write("\tctx.rect(".getBytes());
            fop.write(String.valueOf((int)rect.getX()).getBytes());
            fop.write(",".getBytes());
            fop.write(String.valueOf((int)rect.getY()).getBytes());
            fop.write(",".getBytes());
            fop.write(String.valueOf((int)rect.getWidth()).getBytes());
            fop.write(",".getBytes());
            fop.write(String.valueOf((int)rect.getHeight()).getBytes());
            fop.write(");\n".getBytes());
            
            if(!(rect.getFillColor().equals(null))){

                fop.write("\tctx.fillStyle = '".getBytes());
                String hex = "#"+Integer.toHexString(rect.getFillColor().getRGB()).substring(2);
                fop.write(hex.getBytes());
                fop.write("';\n".getBytes());
                fop.write("\tctx.fillRect(".getBytes());
                fop.write(String.valueOf((int)rect.getX()).getBytes());
                fop.write(",".getBytes());
                fop.write(String.valueOf((int)rect.getY()).getBytes());
                fop.write(",".getBytes());
                fop.write(String.valueOf((int)rect.getWidth()).getBytes());
                fop.write(",".getBytes());
                fop.write(String.valueOf((int)rect.getHeight()).getBytes());
                fop.write(");\n".getBytes());

            }
            writtenIDs[rect.getShapeId()] = 1;
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