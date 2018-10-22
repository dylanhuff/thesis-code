/*
 * File: PPSaveJS.java
 * ---------------------
 * This package class encapsulates the extensive code necessary to save a
 * PowerPoint show to a .js and .html file.
 */

 //should be comitting this to github 
package edu.stanford.cs.pptx;

import java.io.File;
import java.io.IOException;
import java.io.FileOutputStream;


public class PPSaveJS {

    public PPSaveJS(PPShow show) {
       this.show = show;
    }

    public void save(String filename){
        
        // assuming one slide for now
        //int nSlides = show.getSlideCount();

        if (filename.startsWith("~/")) {
            filename = System.getProperty("user.home") + filename.substring(1);
        }
        try {
            //there should be an html file made as well
            
            File file = new File(filename);
            FileOutputStream fop = new FileOutputStream(file);
            
            file.createNewFile();
            
            PPSlide slide = new PPSlide();
            slide = show.getSlide(1); //currently assuming only 1 slide
            PPShape[] shapes = new PPShape[slide.getShapes().length];
            shapes = slide.getShapes();
            //better function name then testSave (change in test.html as well)
            fop.write("function testSave(){\n".getBytes()); //I set the canvas side to the slide size, maybe should be GWindow size? 
            //gwindow could be added as a sepearte smaller window
            //third param is in this id
            fop.write("\tvar canvas = document.createElement('canvas');\n".getBytes());
            fop.write("\tcanvas.width = '".getBytes());
            fop.write(String.valueOf((int)this.show.getWidth()).getBytes());
            fop.write("';\n\tcanvas.height = '".getBytes());
            fop.write(String.valueOf((int)this.show.getHeight()).getBytes());
            fop.write("';\n".getBytes());
            fop.write("\tcanvas.style.border = '1px solid';\n".getBytes());
            fop.write("\tvar body = document.getElementsByTagName('body')[0];\n".getBytes());
            fop.write("\tbody.appendChild(canvas);\n".getBytes());
            fop.write("\tvar ctx = canvas.getContext('2d');\n".getBytes());
            //how about
            //not sure if there is a better way to get correct length for rectShapes array
            //add a couple objects then start adding animations
            //add move animations, along curves
            int i = 0;
            for(PPShape shape : shapes){
                if(shape.getTypeName().equals("PPRect")){
                    i+=1;
                }
            }

            PPRect[] rectShapes = new PPRect[i];

            i = 0;
            for(PPShape shape : shapes){
                if(shape.getTypeName().equals("PPRect")){
                    rectShapes[i] = (PPRect)shape;
                    i+=1;
                }
            }
            //it will be in the order of the display list
            //go throught the object list backl to front, then calls something to display
            //
            //this should be broken out into a seperate file
            //should be a shapesDump file with differnet methods for every shape (?)
            //methods take fop, no return
            for(PPRect shape : rectShapes){
                fop.write("\tctx.rect(".getBytes());
                fop.write(String.valueOf((int)shape.getX()).getBytes());
                fop.write(",".getBytes());
                fop.write(String.valueOf((int)shape.getY()).getBytes());
                fop.write(",".getBytes());
                fop.write(String.valueOf((int)shape.getWidth()).getBytes());
                fop.write(",".getBytes());
                fop.write(String.valueOf((int)shape.getHeight()).getBytes());
                fop.write(");\n".getBytes());
                
                if(!(shape.getFillColor().equals(null))){ //this is a problem because black is the default but could also be set

                    fop.write("\tctx.fillStyle = '".getBytes());
                    String hex = "#"+Integer.toHexString(shape.getFillColor().getRGB()).substring(2);
                    fop.write(hex.getBytes());
                    fop.write("';\n".getBytes());
                    fop.write("\tctx.fillRect(".getBytes());
                    fop.write(String.valueOf((int)shape.getX()).getBytes());
                    fop.write(",".getBytes());
                    fop.write(String.valueOf((int)shape.getY()).getBytes());
                    fop.write(",".getBytes());
                    fop.write(String.valueOf((int)shape.getWidth()).getBytes());
                    fop.write(",".getBytes());
                    fop.write(String.valueOf((int)shape.getHeight()).getBytes());
                    fop.write(");\n".getBytes());

                }
                
            }

            fop.write("\tctx.stroke();\n".getBytes());

            fop.write("}".getBytes());

            fop.flush();
            fop.close();

            System.out.println(filename);

         } catch (IOException ex) {
            throw new RuntimeException(ex.toString());
         } 

    }

    private PPShow show;

}
//do as much with css as possible