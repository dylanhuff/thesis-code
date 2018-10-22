/*
 * File: PPEuclid.java
 * ------------------------
 * This file creates a PowerPoint slide animating Euclid's algorithm
 * Is there anyway to take inputs form PowerPoint? Some way to make
 * this program but have x and y inputs form ppt
 * 
 * Not do-able in the ppt version but very do able in html version
 * Have default or add in for html 
 * 
 * https://support.office.com/en-us/article/start-a-program-during-your-presentation-3854cb18-fcf0-4a18-a990-71c5149667df
 *
 * jsanimation form Eric
 * 
 * in a canvas on a webpage (css file) 
 * what else do I want to add with all JS,HTML? 
 * Save at the end of the show, write a current JS or HTML instead of PPT
 * add overwritten method that can save to JS 
 * Load save from query string 
 * no way 	
 * writing images in ppt
 * 
 */


import java.awt.Color;

import edu.stanford.cs.pptx.*;

public class PPEuclid{
	
	public static void main(String[] args) {
		PPShow ppt = new PPShow();
	    ppt.add(euclidAnimation());
	    ppt.save("PPEuclid.pptx");
	    System.out.println("PPEuclid.pptx saved");
	}
	
	private static PPSlide euclidAnimation() {
		//Initialize slide 
		PPSlide slide = new PPSlide();
	    slide.addTitle("Euclid's Algorithm");
	    PPRect background = new PPRect(PPShow.WIDTH, PPShow.HEIGHT);
	    background.setFillColor(Color.WHITE);
	    slide.add(background);
	    
	    //Set default values for loop and initialize step 1 rectangles
		boolean done = false;
		int currentX=X;
		int currentY=Y;
		int currentHeight = 30; //keeps track of next height to place rectangle
		int r = 0;
		PPRect intialXRect = new PPRect((slide.getWidth()*.9),rectHeight);
		double yRectWidth = ((slide.getWidth()*.9)*((double)currentY/(double)currentX)); //width of x * y/x
		PPRect intialYRect = new PPRect(yRectWidth,rectHeight);
		intialXRect.setFillColor(Color.WHITE);
		intialYRect.setFillColor(Color.WHITE);
		intialXRect.setText(String.valueOf(X));
		intialYRect.setText(String.valueOf(Y));
		slide.add(intialXRect,rectWidthOffset,currentHeight);
		currentHeight+=(5+rectHeight);
		slide.add(intialYRect,rectWidthOffset,currentHeight);
		currentHeight+=(5+rectHeight+rectGapHeight);
		
		//Run through Euclid's Algorithm, making the slide as well
		while(!done) {
			
			PPRect xRect = new PPRect((slide.getWidth()*.9*currentX/X),rectHeight);
			xRect.setFillColor(Color.WHITE);
			xRect.setText(String.valueOf(currentX));
			slide.add(xRect,rectWidthOffset,currentHeight);
			xRect.appear();
			currentHeight+=(5+rectHeight);
			int numberOfYs = Math.floorDiv(currentX, currentY);
			
			for(int i = 1;i<=numberOfYs;i++) { //adds rectangles of currentY
				
				double yWidth = (slide.getWidth()*.9)*((double)currentY/(double)currentX)*((double)currentX/(double)X);
				PPRect yRect = new PPRect(yWidth,rectHeight);
				yRect.setFillColor(Color.WHITE);
				yRect.setText(String.valueOf(currentY));
				
				slide.add(yRect,(rectWidthOffset+((i-1)*yWidth)),currentHeight);
				if(i==1){
					yRect.appear();
				} else {
					yRect.addAnimation("Appear/afterPrev/delay:0.2");
				}
			}
			
			
			r = currentX%currentY;
			System.out.println(r);
			
			if (r==0) {
				System.out.println("Done!");
				System.out.println(currentY); //this is the GCD
				done=true;
			} else {
				//adding remainder rectangle
				double oldYWidth = (slide.getWidth()*.9)*((double)currentY/(double)currentX)*((double)currentX/(double)X); //yWidth from for loop
				double yWidth = (slide.getWidth()*.9)*((double)currentX/(double)X)*((currentX%currentY)/(double)currentX);
				PPRect yRectEnd = new PPRect(yWidth,rectHeight);
				yRectEnd.setFillColor(Color.GRAY);
				yRectEnd.setText(String.valueOf(currentX%currentY));
				slide.add(yRectEnd,(rectWidthOffset+(oldYWidth*numberOfYs)),currentHeight);
				yRectEnd.addAnimation("Appear/afterPrev/delay:0.2");
				currentHeight+=(5+rectHeight+rectGapHeight);
				
				currentX=currentY;
				currentY=r;
			}
			
		}
		
		return slide;
		
	}
	//the numbers used in the GCD calculator
	//x should be larger then y for the animations to work
	private static final int X = 90;
	private static final int Y = 33;
	
	private static final int rectHeight = 30;
	private static final int rectWidthOffset = 30; //offset from left of slide
	private static final int rectGapHeight = 10; //height between groups of rectangles
}