import java.awt.Color;

import edu.stanford.cs.pptx.*;

public class testRectSave {

	 public static void main(String[] args){
		 
        PPShow testShow = new PPShow();
        PPSlide slide = new PPSlide();
        slide.addTitle("Testing yo");
        PPRect testRect = new PPRect(400,0,100,100);
        PPRect testRect2 = new PPRect(100,100,100,100);
        PPRect testRect3 = new PPRect(300,200,300,100);
        PPRect testRect4 = new PPRect(000,200,300,100);
        testRect.setFillColor(Color.BLACK);
	    testRect3.setFillColor(Color.BLACK);
	    testRect4.setFillColor(Color.RED);

        slide.add(testRect);
        slide.add(testRect2);	
        slide.add(testRect3);
        slide.add(testRect4);
        testShow.add(slide);

        PPSaveJS testSave = new PPSaveJS(testShow);
        testSave.save("../example.js");
	 }
}
	 
