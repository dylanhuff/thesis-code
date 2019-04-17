import java.awt.Color;

import edu.stanford.cs.pptx.*;
import edu.stanford.cs.pptx.PPSaveJS;

public class testRectSave {

	 public static void main(String[] args){
		simpleExample(args);
     }
     
    public static PPSlide simpleText(PPShow ppt){
        PPSlide slide = new PPSlide();
        slide.addTitle("Simple Shapes");
        double x = (ppt.getWindowWidth() - SQUARE_SIZE) / 2;
        double y = (ppt.getWindowHeight() - SQUARE_SIZE) / 2;
        PPRect square = new PPRect(x, y, SQUARE_SIZE, SQUARE_SIZE);
        square.setColor(Color.RED);
        PPOval circle = new PPOval(75, 75, SQUARE_SIZE, SQUARE_SIZE);
        circle.setColor(Color.RED);
        slide.add(square);
        square.disappear();
        slide.add(circle);
        circle.appear();    
        return slide;
    }

    public static void simpleExample(String[] args) {
        PPShow ppt = new PPShow();
      //   ppt.add(simpleText(ppt));
      //   ppt.add(simplePPLineTest());
      //   ppt.add(simplePPRectTest());
      //   ppt.add(simplePPOvalTest());
      //   ppt.add(simplePPTextBoxTest());
      //   ppt.add(mainTest(ppt));
        ppt.add(sortTest(ppt));
        //ppt.add(simplePPPictureTest());
        //ppt.add(simplePPGroupTest());
        ppt.save("PPSimpleExamples.pptx");
        PPSaveJS.save(ppt,"../example.js");
        System.out.println("PPSimpleExamples.pptx");
     }

     public static PPSlide sortTest(PPShow ppt){
      PPSlide slide = new PPSlide();
      slide.addTitle("Insertion Sorting");
      double xc = slide.getWidth() / 2;
      PPTextBox text5 = new PPTextBox("5");
      slide.add(text5, xc-60, 150);
      PPTextBox text4 = new PPTextBox("4");
      slide.add(text4, xc-30, 150);
      PPTextBox text3 = new PPTextBox("3");
      slide.add(text3, xc, 150);
      PPTextBox text2 = new PPTextBox("2");
      slide.add(text2, xc+30, 150);
      PPTextBox text1 = new PPTextBox("1");
      slide.add(text1, xc+60, 150);
      text1.move(-120,0,"/onClick");
      text5.move(30,0,"/withPrev");
      text4.move(30,0,"/withPrev");
      text3.move(30,0,"/withPrev");
      text2.move(30,0,"/withPrev");
      return slide;
     }

    public static PPSlide mainTest(PPShow ppt){
        PPSlide slide = new PPSlide();
        slide.addTitle("Example Title");
        //PPRect testRect = new PPRect(400,300,100,100);
        PPRect testRect2 = new PPRect(100,100,100,100);
        PPRect testRect3 = new PPRect(300,200,300,100);
        PPRect testRect4 = new PPRect(200,400,100,100);
        //PPRect testRect5 = new PPRect(200,100,100,100);
        //PPRect testRect6 = new PPRect(400,300,200,100);
        //PPRect testRect7 = new PPRect(100,400,100,200);
        //PPLine testLine2 = new PPLine(100,300,200,300);
        PPOval testOval1 = new PPOval(300,300,200,100);

        //testRect.setFillColor(Color.BLACK);
        testRect2.setFillColor(Color.YELLOW);
	    testRect3.setFillColor(Color.BLUE);
        testRect4.setFillColor(Color.RED);
        //testRect5.setFillColor(Color.ORANGE);
        testOval1.setFillColor(Color.GREEN);
        //testRect6.setFillColor(Color.CYAN);
        //testRect7.setFillColor(Color.MAGENTA);

        
        
        PPLine testLine = new PPLine(0, 0, 300, 300);

        slide.add(testOval1);
        //slide.add(testRect);
        slide.add(testRect2);	
        slide.add(testRect3);
        slide.add(testRect4);
        //slide.add(testRect5);
        //slide.add(testRect6);
        //slide.add(testRect7);
        slide.add(testLine); //adding lines removes borders from other objs
        //slide.add(testLine2);

        //testRect.appear("/onClick");
        testRect2.appear("/onClick");
        testRect4.appear("/onClick");
        testRect3.appear("/afterPrev/delay:1");
        //testRect6.appear("/withPrev");
        //testRect5.appear("/afterPrev/delay:1");
        //testRect7.appear("/onClick");
        testRect2.move(500.0,100.0,"/withPrev"); //bug with multiple animations \
        return slide;
    }

    private static PPSlide simplePPLineTest() {
        PPSlide slide = new PPSlide();
        slide.addTitle("PPLineTest");
        double width = slide.getWidth();
        double height = slide.getHeight();
        PPLine diagonalNWtoSE = new PPLine(0, 0, width, height);
        PPLine diagonalSWtoNE = new PPLine(0, height, width, 0);
        slide.add(diagonalNWtoSE);
        slide.add(diagonalSWtoNE);
        return slide;
     }
  
     private static PPSlide simplePPRectTest() {
        PPSlide slide = new PPSlide();
        slide.addTitle("PPRectTest");
        PPRect square = new PPRect(100, 100);
        square.setColor(Color.RED);
        slide.add(square, 200, 100);
        return slide;
     }
  
     private static PPSlide simplePPOvalTest() {
        PPSlide slide = new PPSlide();
        slide.addTitle("PPOvalTest");
        double xc = slide.getWidth() / 2;
        double yc = slide.getHeight() / 2;
        PPOval circle = new PPOval(xc - 50, yc - 50, 100, 100);
        slide.add(circle);
        return slide;
     }
  
     private static PPSlide simplePPTextBoxTest() {
        PPSlide slide = new PPSlide();
        slide.addTitle("PPTextBoxTest");
        double xc = slide.getWidth() / 2;
        double yc = slide.getHeight() / 2;
        PPTextBox hello = new PPTextBox("hello, world");
        hello.setFont("Helvetica-Bold-36");
        slide.add(hello, xc - hello.getWidth() / 2, yc - hello.getHeight() / 2);
        return slide;
     }
  
     private static PPSlide simplePPPictureTest() {
        PPSlide slide = new PPSlide();
        slide.addTitle("PPPictureTest");
        double xc = slide.getWidth() / 2;
        double yc = slide.getHeight() / 2;
        PPPicture logo = new PPPicture("images/StanfordLogo.png");
        logo.setBounds(xc - 100, yc - 100, 200, 200);
        slide.add(logo);
        return slide;
     }
  
     private static PPSlide simplePPGroupTest() {
        PPSlide slide = new PPSlide();
        slide.addTitle("PPGroupTest");
        double xc = slide.getWidth() / 2;
        double yc = slide.getHeight() / 2;
        PPGroup group = new PPGroup();
        group.add(new PPRect(200, 100, "/color:red"));
        group.add(new PPOval(200, 100, "/color:green"));
        slide.add(group, xc - group.getWidth() / 2, yc - group.getHeight() / 2);
        group.appear();
        return slide;
     }
  

    private static final double SQUARE_SIZE = 200;
}
	 
