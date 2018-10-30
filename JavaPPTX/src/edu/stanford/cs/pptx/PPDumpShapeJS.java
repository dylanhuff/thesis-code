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

public class PPDumpShapeJS {

    public PPDumpShapeJS(){

    }

    public void writeShapes(FileOutputStream fop, PPShape[] shapes){
        boolean startPath = true;
        for(PPShape shape: shapes){
            if(shape.getTypeName().equals("PPRect")){
                writeRect(fop,(PPRect)shape);
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
                fop.write("\tctx.fill();".getBytes());

            }

        } catch (IOException ex) {
            throw new RuntimeException(ex.toString());
        } 
    }
}