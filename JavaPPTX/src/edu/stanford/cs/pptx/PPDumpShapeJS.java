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
import java.awt.Font;


import edu.stanford.cs.pptx.effect.AnimationEffect;
import edu.stanford.cs.pptx.effect.LinearMotionEffect;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;
import java.awt.geom.Point2D;

public class PPDumpShapeJS {

    private ArrayList<AnimationEffect> animations = new ArrayList<AnimationEffect>();
    private Hashtable<String,Integer> renderIDs;
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
            classInit.put("oval",false);
            fop.write("export {RectObj as default};\n".getBytes());
            fop.write("export {canvas,ctx,window,OvalObj,TextObj};\n".getBytes());
            fop.write("var canvas = document.createElement('canvas');\n".getBytes());
            fop.write("var ctx = canvas.getContext('2d');\n".getBytes());
            fop.write("var body = document.getElementsByTagName('body')[0];\n".getBytes());
            fop.write("class GWindow{\n".getBytes());
            fop.write("\tconstructor(width,height,borderStyle){\n".getBytes());
            fop.write("\t\tthis.width = width;\n".getBytes());
            fop.write("\t\tthis.height = height;\n".getBytes());
            fop.write("\t\tthis.borderStyle = borderStyle;\n".getBytes());
            fop.write("\t\tthis.renderOrder = []; //list of obj ids in render order\n".getBytes());
            fop.write("\t\tthis.objects = [];\n\t}\n".getBytes());
            fop.write("\trenderWindow(){\n".getBytes());
            fop.write("\t//renders the window without objects\n".getBytes());
            fop.write("\t\tcanvas.width = this.width;\n".getBytes());
            fop.write("\t\tcanvas.height = this.height;\n".getBytes());
            fop.write("\t\tcanvas.style.border = this.borderStyle;\n".getBytes());
            fop.write("\t\tbody.appendChild(canvas);\n\t}\n".getBytes());
            fop.write("\trenderObject(id){\n".getBytes());
            fop.write("\t\t//renders one object based on its id. should call the render method of the object\n".getBytes());
            fop.write("\t\tthis.objects.forEach(obj => {\n".getBytes());
            fop.write("\t\t\tif(obj.id == id){\n".getBytes());
            fop.write("\t\t\t\tobj.render();\n".getBytes());
            fop.write("\t\t\t\tthis.renderOrder.push(id);\n\t\t\t}\n".getBytes());
            fop.write("\t\t});\n\t}\n".getBytes());
            fop.write("\tderenderObject(id){\n".getBytes());
            fop.write("\t\tvar index = this.renderOrder.indexOf(id);\n".getBytes());
            fop.write("\t\tthis.renderOrder.splice(index,1);\n".getBytes());
            fop.write("\t\tthis.derenderAllObjects();\n".getBytes());
            fop.write("\t\tthis.renderAllObjects();\n".getBytes());
            fop.write("\t}\n".getBytes());
            fop.write("\taddObjects(objs){\n".getBytes());
            fop.write("\t\tobjs.forEach(element => {\n".getBytes());
            fop.write("\t\t\tthis.objects.push(element)\n".getBytes());
            fop.write("\t\t});\n\t}\n".getBytes());
            fop.write("\trenderAllObjects(){\n".getBytes());
            fop.write("\t\tthis.renderOrder.forEach(id => {\n".getBytes());
            fop.write("\t\t\tthis.objects.forEach(obj => {\n".getBytes());
            fop.write("\t\t\t\tif(obj.id==id){\n".getBytes());
            fop.write("\t\t\t\t\tobj.render();\n".getBytes());
            fop.write("\t\t\t\t}\n".getBytes());
            fop.write("\t\t\t});\n".getBytes());
            fop.write("\t\t});\n".getBytes());
            fop.write("\t}\n".getBytes());
            fop.write("\tderenderAllObjects(){\n".getBytes());
            fop.write("\t\tctx.clearRect(0, 0, this.width, this.height);\n".getBytes());
            fop.write("\t\t//iterate through all objects and change its renderBool to false\n".getBytes());
            fop.write("\t}\n".getBytes());
            fop.write("}\n".getBytes());
            fop.write("class ObjectType{\n".getBytes());
            fop.write("\tconstructor(id,x,y){\n".getBytes());
            fop.write("\t\tthis.x = x;\n".getBytes());
            fop.write("\t\tthis.y = y;\n".getBytes());
            fop.write("\t\tthis.id = id;\n".getBytes());
            fop.write("\t}\n".getBytes());
            fop.write("\tmoveHelper(xOffset,yOffset){\n".getBytes());
            fop.write("\t\twindow.derenderAllObjects();\n".getBytes());
            fop.write("\t\tthis.x +=xOffset\n".getBytes()); //change here for moving
            fop.write("\t\tthis.y +=yOffset;\n".getBytes());
            fop.write("\t\twindow.renderAllObjects();\n".getBytes());
            fop.write("\t}\n".getBytes());
            fop.write("\tmove(endX,endY,duration){\n".getBytes());
            fop.write("\t\tvar _this = this;\n".getBytes());
            fop.write("\t\tvar xOffset = ((endX-this.x)/duration)/60; //px/refresh\n".getBytes());
            fop.write("\t\tvar yOffset = ((endY-this.y)/duration)/60;\n".getBytes());
            fop.write("\t\tvar threshold = (endX-this.x)/xOffset;\n".getBytes());
            fop.write("\t\tvar refreshCounter = 0;\n".getBytes());
            fop.write("\t\tvar intervalID = setInterval(function(){\n".getBytes());
            fop.write("\t\t\twrap();\n".getBytes());
            fop.write("\t\t},1000/60);\n".getBytes());
            fop.write("\t\tvar wrap = function(){\n".getBytes());
            fop.write("\t\t\tif(refreshCounter<threshold){\n".getBytes());
            fop.write("\t\t\t\t_this.moveHelper(xOffset,yOffset);\n".getBytes());
            fop.write("\t\t\t\trefreshCounter+=1;\n".getBytes());
            fop.write("\t\t\t} else {\n".getBytes());
            fop.write("\t\t\t\tclearInterval(intervalID)\n".getBytes());
            fop.write("\t\t\t}\n\t\t}\n".getBytes());
            fop.write("\t}\n".getBytes());
            fop.write("}\n".getBytes());
            fop.write("class TextObj extends ObjectType{\n".getBytes());
            fop.write("\tconstructor(x,y,id,string,color,fontDesc){\n".getBytes());
            fop.write("\t\tsuper(id,x,y);\n".getBytes());
            fop.write("\t\tthis.string = string;\n".getBytes());
            fop.write("\t\tthis.color = color;\n".getBytes());
            fop.write("\t\tthis.fontDesc = fontDesc;\n".getBytes());
            fop.write("\t}\n".getBytes());
            fop.write("\trender(){\n".getBytes());
            fop.write("\t\tctx.font = this.fontDesc;\n".getBytes());
            fop.write("\t\tctx.fillStyle = this.color;\n".getBytes());
            fop.write("\t\tctx.textAlign = 'center';\n".getBytes());
            fop.write("\t\tctx.fillText(this.string, this.x, this.y); \n".getBytes());
            fop.write("\t}\n".getBytes());
            fop.write("}\n".getBytes());
            for(PPShape shape: shapes){
                if(shape.getTypeName().equals("PPRect")){
                    if (classInit.get("rect").equals(false)) {
                        classInit.put("rect",true);
                        fop.write("class RectObj extends ObjectType{\n".getBytes());
                        fop.write("\tconstructor(x,y,height,width,color,id){\n".getBytes());
                        fop.write("\t\tsuper(id,x,y);\n".getBytes());
                        fop.write("\t\tthis.width = width;\n".getBytes());
                        fop.write("\t\tthis.height = height;\n".getBytes());
                        fop.write("\t\tthis.color = color;\n".getBytes());
                        fop.write("\t}\n".getBytes());
                        fop.write("\trender(){\n".getBytes());
                        fop.write("\t\tctx.rect(this.x,this.y,this.height,this.width);\n".getBytes());
                        fop.write("\t\tctx.fillStyle = this.color;\n".getBytes());
                        fop.write("\t\tctx.fillRect(this.x,this.y,this.height,this.width);\n".getBytes());
                        fop.write("\t}\n".getBytes());
                        fop.write("}\n".getBytes());
                    }
                } else if(shape.getTypeName().equals("PPOval")){
                    if (classInit.get("oval").equals(false)) {
                        classInit.put("oval",true);
                        fop.write("class OvalObj extends ObjectType{\n".getBytes());
                        fop.write("\tconstructor(x,y,radiusX, radiusY, rotation, startAngle, endAngle ,color,id){\n".getBytes());
                        fop.write("\t\tsuper(id,x,y);\n".getBytes());
                        fop.write("\t\tthis.radiusX = radiusX;\n".getBytes());
                        fop.write("\t\tthis.radiusY = radiusY;\n".getBytes());
                        fop.write("\t\tthis.rotation = rotation;\n".getBytes());
                        fop.write("\t\tthis.startAngle = startAngle;\n".getBytes());
                        fop.write("\t\tthis.endAngle = endAngle;\n".getBytes());
                        fop.write("\t\tthis.color = color;\n".getBytes());
                        fop.write("\t}\n".getBytes());
                        fop.write("\trender(){\n".getBytes());
                        fop.write("\t\tctx.beginPath();\n".getBytes());
                        fop.write("\t\tctx.ellipse(this.x,this.y,this.radiusX,this.radiusY,this.rotation,this.startAngle,this.endAngle);\n".getBytes());
                        fop.write("\t\tctx.fillStyle = this.color;\n".getBytes());
                        fop.write("\t\tctx.fill();\n".getBytes());
                        fop.write("\t}\n".getBytes());
                        fop.write("}\n".getBytes());
                    }
                }
            }
            fop.write("var window = new GWindow(".getBytes());
            fop.write(String.valueOf((int)show.getWidth()).getBytes());
            fop.write(",".getBytes());
            fop.write(String.valueOf((int)show.getHeight()).getBytes());
            fop.write(",'1px solid');\n".getBytes());
            fop.flush();
            fop.close();

        } catch (IOException ex) {
            throw new RuntimeException(ex.toString());
        }
    }

    public void objInit(FileOutputStream fop, PPShape[] shapes, PPSlide slide,PPShow show){
        for(PPShape shape: shapes){
            System.out.println(shape.getTypeName());
            System.out.println(shape.getShapeId());
            if(shape.getTypeName().equals("PPRect")){
                writeRect(fop,(PPRect)shape);
            } else if(shape.getTypeName().equals("PPOval")) {
                writeOval(fop,(PPOval)shape);
            } else if(shape.getTypeName().equals("PPTextShape") || shape.getTypeName().equals("PPTitle")) {
                writeTextObject(fop,(PPTextShape)shape);
            }
        }
        
    }

    public void writeShapes(FileOutputStream fop, PPShape[] shapes, PPSlide slide){

        this.animations = slide.getAnimationList();
        this.renderIDs = new Hashtable<String,Integer>(shapes.length+1);
        for(int i = 0;i<shapes.length;i++){
            this.renderIDs.put(Integer.toString(shapes[i].getShapeId()),0);
        }
        boolean startPath = true;
        writeAnimationsWrapper(fop);
        for(PPShape shape: shapes){
            if(shape.getTypeName().equals("PPRect")){
                if((int)(this.renderIDs.get(Integer.toString(shape.getShapeId()))) == 0){ //this checks that the shape hasn't been written yet
                    renderRect(fop,(PPRect)shape);
                    this.renderIDs.put(Integer.toString(shape.getShapeId()),1);
                }
            } else if(shape.getTypeName().equals("PPOval")){
                if((int)(this.renderIDs.get(Integer.toString(shape.getShapeId()))) == 0){ //this checks that the shape hasn't been written yet
                    renderOval(fop,(PPOval)shape);
                    this.renderIDs.put(Integer.toString(shape.getShapeId()),1);
                }
            } else if(shape.getTypeName().equals("PPTitle") || shape.getTypeName().equals("PPTextShape")){
                if((int)(this.renderIDs.get(Integer.toString(shape.getShapeId()))) == 0){ //this checks that the shape hasn't been written yet
                    renderTextObject(fop,(PPTitle)shape);
                    this.renderIDs.put(Integer.toString(shape.getShapeId()),1);
                }
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
                System.out.println(animation.getClass().getName().toString());
                if (animation.getClass().getName().toString() == "edu.stanford.cs.pptx.effect.AppearEffect"){
                    if (animation.getTrigger() == "withPrev"){
                        try{
                            if(shape.getTypeName().equals("PPRect")){
                                renderRect(fop,(PPRect)shape);
                            } else if(shape.getTypeName().equals("PPOval")){
                                renderOval(fop,(PPOval)shape);
                            }
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
                            if(shape.getTypeName().equals("PPRect")){
                                renderRect(fop,(PPRect)shape);
                            } else if(shape.getTypeName().equals("PPOval")){
                                renderOval(fop,(PPOval)shape);
                            }
                            AnimationEffect nextAnimation = animations.get(index+1);
                            if (nextAnimation.getTrigger() == "withPrev"){
                                offset+=1+writeAnimation(fop, index+1);
                            } else if (nextAnimation.getTrigger() == "afterPrev"){
                                offset+=1+writeAnimation(fop, index+1);
                            }
                        } catch (IndexOutOfBoundsException ex){}
                    } else {
                        writeOnClick(fop);
                        if(shape.getTypeName().equals("PPRect")){
                            renderRect(fop,(PPRect)shape);
                        } else if(shape.getTypeName().equals("PPOval")){
                            renderOval(fop,(PPOval)shape);
                        }
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
                            
                    }
                } else if (animation.getClass().getName().toString() == "edu.stanford.cs.pptx.effect.LinearMotionEffect"){
                    Point2D loc = ((LinearMotionEffect)animation).dumpJS();
                    double speed = ((LinearMotionEffect)animation).dumpSpeed(); //speed is px/sec
                    if (animation.getTrigger() == "onClick"){
                        writeOnClick(fop);
                        fop.write("\trect".getBytes());
                        fop.write(String.valueOf((int)shape.getShapeId()).getBytes());
                        fop.write(".move(".getBytes());
                        fop.write(String.valueOf(loc.getX()).getBytes());
                        fop.write(",".getBytes());
                        fop.write(String.valueOf(loc.getY()).getBytes());
                        fop.write(",".getBytes());
                        fop.write(String.valueOf(animation.getDuration()).getBytes());
                        fop.write(");\n".getBytes());
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
                            fop.write(".move(".getBytes());
                            fop.write(String.valueOf(loc.getX()).getBytes());
                            fop.write(",".getBytes());
                            fop.write(String.valueOf(loc.getY()).getBytes());
                            fop.write(",".getBytes());
                            fop.write(String.valueOf(animation.getDuration()).getBytes());
                            fop.write(");\n".getBytes());
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
                            fop.write(".move(".getBytes());
                            fop.write(String.valueOf(loc.getX()).getBytes());
                            fop.write(",".getBytes());
                            fop.write(String.valueOf(loc.getY()).getBytes());
                            fop.write(",".getBytes());
                            fop.write(String.valueOf(animation.getDuration()).getBytes());
                            fop.write(");\n".getBytes());
                            AnimationEffect nextAnimation = animations.get(index+1);
                            if (nextAnimation.getTrigger() == "withPrev"){
                                offset+=1+writeAnimation(fop, index+1);
                            } else if (nextAnimation.getTrigger() == "afterPrev"){
                                offset+=1+writeAnimation(fop, index+1);
                            }
                        } catch (IndexOutOfBoundsException ex){}
                    }
                } else if (animation.getClass().getName().toString() == "edu.stanford.cs.pptx.effect.DisappearEffect"){
                    if (animation.getTrigger() == "withPrev"){
                        try{
                            derenderObject(fop, shape);
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
                            derenderObject(fop, shape);
                            AnimationEffect nextAnimation = animations.get(index+1);
                            if (nextAnimation.getTrigger() == "withPrev"){
                                offset+=1+writeAnimation(fop, index+1);
                            } else if (nextAnimation.getTrigger() == "afterPrev"){
                                offset+=1+writeAnimation(fop, index+1);
                            }
                        } catch (IndexOutOfBoundsException ex){}
                    } else {
                        writeOnClick(fop);
                        derenderObject(fop, shape);
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
            Point2D initLoc = rect.getInitialLocation();
            fop.write(String.valueOf((int)rect.getShapeId()).getBytes());
            fop.write(" = new RectObj(".getBytes());
            fop.write(String.valueOf((int)initLoc.getX()).getBytes());
            fop.write(",".getBytes());
            fop.write(String.valueOf((int)initLoc.getY()).getBytes());
            fop.write(",".getBytes());
            fop.write(String.valueOf((int)rect.getWidth()).getBytes());
            fop.write(",".getBytes());
            fop.write(String.valueOf((int)rect.getHeight()).getBytes());
            fop.write(",\"".getBytes());
            String hex = "#"+Integer.toHexString(rect.getFillColor().getRGB()).substring(2);
            fop.write(hex.getBytes());
            fop.write("\",".getBytes());
            fop.write(String.valueOf((int)rect.getShapeId()).getBytes());
            fop.write(");\n".getBytes());
            fop.write("window.addObjects([rect".getBytes());
            fop.write(String.valueOf((int)rect.getShapeId()).getBytes());
            fop.write("]);\n".getBytes());

        } catch (IOException ex) {
            throw new RuntimeException(ex.toString());
        } 
    }

    private void renderRect(FileOutputStream fop, PPRect rect){
        try{ 
            fop.write("\twindow.renderObject(".getBytes());
            fop.write(String.valueOf((int)rect.getShapeId()).getBytes());
            fop.write(");\n".getBytes());
            this.renderIDs.put(Integer.toString(rect.getShapeId()),1);
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
            
            fop.write("var oval".getBytes()); //params: x, y, radiusX, radiusY, rotation, startAngle, endAngle
            fop.write(String.valueOf((int)oval.getShapeId()).getBytes());
            fop.write(" = new OvalObj(".getBytes());
            fop.write(String.valueOf((double)oval.getX()+(double)oval.getWidth()/2).getBytes());
            fop.write(",".getBytes());
            fop.write(String.valueOf((double)oval.getY()+(double)oval.getHeight()/2).getBytes());
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
            fop.write(",\"".getBytes());
            String hex = "#"+Integer.toHexString(oval.getFillColor().getRGB()).substring(2);
            fop.write(hex.getBytes());
            fop.write("\",".getBytes());
            fop.write(String.valueOf((int)oval.getShapeId()).getBytes());
            fop.write(");\n".getBytes());
            fop.write("window.addObjects([oval".getBytes());
            fop.write(String.valueOf((int)oval.getShapeId()).getBytes());
            fop.write("]);\n".getBytes());

        } catch (IOException ex) {
            throw new RuntimeException(ex.toString());
        } 
    }

    private void renderOval(FileOutputStream fop, PPOval oval){
        try{ 
            fop.write("\twindow.renderObject(".getBytes());
            fop.write(String.valueOf((int)oval.getShapeId()).getBytes());
            fop.write(");\n".getBytes());
            this.renderIDs.put(Integer.toString(oval.getShapeId()),1);
        } catch (IOException ex) {
            throw new RuntimeException(ex.toString());
        } 
    }

    private void writeTextObject(FileOutputStream fop, PPTextShape text){
        try{
            Point2D pt = text.getCenter();
            Font font = text.getFont();
            String fontDesc = Double.toString((font.getSize()*1.25)) + "px " + font.getName();
            fop.write("var text".getBytes()); 
            fop.write(String.valueOf((int)text.getShapeId()).getBytes());
            fop.write(" = new TextObj(".getBytes());
            fop.write(String.valueOf((double)pt.getX()).getBytes());
            fop.write(",".getBytes());
            fop.write(String.valueOf((double)pt.getY()).getBytes());
            fop.write(",".getBytes());
            fop.write(String.valueOf((int)text.getShapeId()).getBytes());
            fop.write(",'".getBytes());
            fop.write(text.getText().getBytes());
            fop.write("',\"".getBytes());
            String hex = "#"+Integer.toHexString(text.getFillColor().getRGB()).substring(2);
            fop.write(hex.getBytes());
            fop.write("\", '".getBytes());
            fop.write(fontDesc.getBytes());
            fop.write("');\n".getBytes());
            fop.write("window.addObjects([text".getBytes());
            fop.write(String.valueOf((int)text.getShapeId()).getBytes());
            fop.write("]);\n".getBytes());
        } catch (IOException ex) {
            throw new RuntimeException(ex.toString());
        } 
    }

    private void renderTextObject(FileOutputStream fop, PPTextShape text) {
        try{ 
            fop.write("\twindow.renderObject(".getBytes());
            fop.write(String.valueOf((int)text.getShapeId()).getBytes());
            fop.write(");\n".getBytes());
            this.renderIDs.put(Integer.toString(text.getShapeId()),1);
        } catch (IOException ex) {
            throw new RuntimeException(ex.toString());
        } 
    }

    private void writeOnClick(FileOutputStream fop){

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

    private void derenderObject(FileOutputStream fop, PPShape shape){
        try{ 
            fop.write("\twindow.derenderObject(".getBytes());
            fop.write(String.valueOf((int)shape.getShapeId()).getBytes());
            fop.write(");\n".getBytes());
        } catch (IOException ex) {
            throw new RuntimeException(ex.toString());
        } 
    }

    private void writeWithPrev(FileOutputStream fop){
        try{
            fop.write("".getBytes());
        } catch (IOException ex) {
            throw new RuntimeException(ex.toString());
        } 
    }
}