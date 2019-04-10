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

    public static void save(PPShow show, String filename){
        
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
            
            PPDumpShapeJS dump = new PPDumpShapeJS();
            fop.write("import canvas from './classes.js';\n".getBytes()); 
            fop.write("import {ctx,window,OvalObj,TextObj,RectObj,LineObj} from './classes.js';\n".getBytes());
            fop.write("window.renderWindow();\n".getBytes());
            dump.fileInit(show);
            for(int i = 1;i<=show.getSlideCount();i++){
                PPSlide slide = show.getSlide(i);
                PPShape[] shapes = slide.getShapes();
                dump.objInit(fop, shapes, slide, show);
            }
            //better function name then testSave (change in test.html as well)
            fop.write("function testSave(){\n".getBytes()); //I set the canvas side to the slide size, maybe should be GWindow size? 
            //gwindow could be added as a sepearte smaller window
            //third param is in this id
            fop.write("\tdocument.removeEventListener('load',testSave);\n".getBytes());
            dump.writeAnimationsWrapper(fop);
            //add a couple objects then start adding animations
            //add move animations, along curves
            for(int i = 1;i<=show.getSlideCount();i++){
                PPSlide slide = show.getSlide(i);
                PPShape[] shapes = slide.getShapes();
                dump.writeShapes(fop, shapes, slide, i);
                if(show.getSlideCount()>1 & !(show.getSlideCount()==i)) {
                    dump.writeOnClick(fop);
                    fop.write("\t\t\twindow.derenderAllObjects();\n".getBytes());
                    fop.write("\t\t\twindow.renderOrder = [];\n".getBytes());
                    fop.write(("\t\t\tslide"+Integer.toString(i+1)+"()\n").getBytes());
                    dump.closeEvent(fop);
                }
            }
            //it will be in the order of the display list
            //go throught the object list backl to front, then calls something to display
            
            fop.write("\tctx.stroke();\n".getBytes());
            fop.write("}\n".getBytes());
            fop.write("document.addEventListener('load', testSave());\n".getBytes());
            fop.flush();
            fop.close();

            System.out.println(filename);

         } catch (IOException ex) {
            throw new RuntimeException(ex.toString());
         } 

    }

}
//do as much with css as possible