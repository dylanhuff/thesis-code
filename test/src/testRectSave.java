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
        PPRect testRect5 = new PPRect(200,100,100,100);
        PPRect testRect6 = new PPRect(400,300,200,100);
        PPRect testRect7 = new PPRect(100,400,100,200);
        //PPLine testLine2 = new PPLine(100,300,200,300);
        PPOval testOval1 = new PPOval(300,300,200,100);

        testRect.setFillColor(Color.BLACK);
        testRect2.setFillColor(Color.YELLOW);
	    testRect3.setFillColor(Color.BLUE);
        testRect4.setFillColor(Color.RED);
        testRect5.setFillColor(Color.ORANGE);
        testOval1.setFillColor(Color.WHITE);
        testRect6.setFillColor(Color.CYAN);
        testRect7.setFillColor(Color.MAGENTA);

        
        
        PPLine testLine = new PPLine(0, 0, 300, 300);

        slide.add(testOval1);
        slide.add(testRect);
        slide.add(testRect2);	
        slide.add(testRect3);
        slide.add(testRect4);
        slide.add(testRect5);
        slide.add(testRect6);
        slide.add(testRect7);
        slide.add(testLine); //adding lines removes borders from other objs
        //slide.add(testLine2);
        testShow.add(slide);

        testRect.appear("/onClick");
        testRect2.appear("/withPrev");
        testRect4.appear("/onClick");
        testRect3.appear("/afterPrev/delay:2.0");
        testRect6.appear("/withPrev");
        testRect5.appear("/afterPrev/delay:4.0");
        testRect7.appear("/onClick");
        PPSaveJS testSave = new PPSaveJS(testShow);
        testSave.save("../example.js");

        testShow.save("../example.pptx");
	 }
}
	 
