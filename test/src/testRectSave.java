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
        PPRect testRect4 = new PPRect(200,400,100,100);
        testRect.setFillColor(Color.BLACK);
        testRect2.setFillColor(Color.YELLOW);
	    testRect3.setFillColor(Color.BLUE);
        testRect4.setFillColor(Color.RED);
        
        PPLine testLine = new PPLine(0, 0, 300, 300);
        PPLine testLine2 = new PPLine(100, 300, 100, 300);

        slide.add(testRect);
        slide.add(testRect2);	
        slide.add(testRect3);
        slide.add(testRect4);
        slide.add(testLine);
        slide.add(testLine2);
        testShow.add(slide);

        PPSaveJS testSave = new PPSaveJS(testShow);
        testSave.save("../example.js");
	 }
}
	 
