/*
 * File: PPSaveJS.java
 * ---------------------
 * This package class encapsulates the extensive code necessary to save a
 * PowerPoint show to a .js and .html file.
 */

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
        // please work

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
            PPDumpShapeJS dump = new PPDumpShapeJS();
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
            //add a couple objects then start adding animations
            //add move animations, along curves
            dump.writeShapes(fop, shapes);
            
            //it will be in the order of the display list
            //go throught the object list backl to front, then calls something to display
            
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