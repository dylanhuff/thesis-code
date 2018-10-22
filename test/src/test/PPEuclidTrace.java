/*
 * File: PPEuclidTrace.java
 * ------------------------
 * This file creates a PowerPoint slide showing a stack trace of a recursive
 * implementation of Euclid's Algorithm. 
 * 
 * what is PPConsole?
 */

package test;

import edu.stanford.cs.pptx.*;
import edu.stanford.cs.pptx.code.PPCodeTraceSlide;
import edu.stanford.cs.pptx.code.PPConsole;
import edu.stanford.cs.pptx.code.PPFunction;
import edu.stanford.cs.pptx.code.PPValueTag;
import edu.stanford.cs.pptx.code.PPVar;
import java.awt.geom.Rectangle2D;


public class PPEuclidTrace {

	public static void main(String args[]) {
		new PPEuclidTrace().run();
		System.out.println(gcd(X,Y));
		System.out.println("PPEuclidTrace.pptx saved");
		
	}
	
	public void run() {
		PPShow ppt = new PPShow();
		PPCodeTraceSlide slide = new EuclidSlide();
		ppt.add(slide);
		ppt.save("PPEuclidTrace.pptx");
		System.out.println("PPEuclidTrace.pptx saved!!");
		
	}
	
	private static int gcd(int localX, int localY) {
		if (localY == 0) {
			return localX;
		} else {
			return gcd(localY, localX % localY);
		}
	}
	
	private static final int X = 714;
	private static final int Y = 210;
}

class EuclidSlide extends PPCodeTraceSlide {
	
	public EuclidSlide() {
		setMaxStackDepth(MAX_STACK_DEPTH);
		addTitle("PPEuclidTrace");
		double xPadding = (getWidth() - CONSOLE_WIDTH) / 2;
		double yPadding = getHeight() - CONSOLE_HEIGHT - 20;
		addConsole("TestFactorial", xPadding, yPadding, CONSOLE_WIDTH, CONSOLE_HEIGHT);
	    setFrameHeight(200);
	    defineFunction("run", new Run());
	    defineFunction("fact", new Fact());
	    call("run");
	}

	public PPConsole getConsole() {
		return console;
	}

	/* Constants */

	private static final double CONSOLE_WIDTH = 350;
	private static final double CONSOLE_HEIGHT = 100;
	private static final int MAX_STACK_DEPTH = 10;

	/* Private instance variables */

	private PPConsole console;
	
}

class Run extends PPFunction {

   public Run() {
      setCode(CODE);
   }

   @Override
   public Object stepThrough() { //this entire block is confusing
      startDeclarations(); //is this declaring variables on the screen?
      PPVar<Integer> n = new PPVar<Integer>("n");
      addLocalVariable(n);
      endDeclarations();
      highlightLine("let n");
      n.set(4); 
      highlightLine("console.log");
      highlight("fact(n)");
      int result = (Integer) call("fact", n.get()); //kinda lost after this
      Rectangle2D bb = getCodeBounds("console.log", "fact(n)");
      PPValueTag tag = new PPValueTag(bb, result);
      getSlide().add(tag);
      tag.appear("/afterPrev");
      tag.disappear();
      println(n.get() + "! = " + result);
      return null;
   }

   private static final String[] CODE = {
      "function TestFactorial() {",
      "   let n = 4;",
      "   console.log(n + \"! = \" + fact(n));",
      "}"
   };

}

class Fact extends PPFunction {

   public Fact() {
      setCode(CODE);
   }

   @Override
   public Object stepThrough() {
      startDeclarations();
      PPVar<Integer> n = new PPVar<Integer>("n");
      addParameter(n);
      endDeclarations();
      highlightLine("if");
      if (n.get() == 0) {
         highlightLine("return 1");
         return 1;
      } else {
         highlightLine("return n");
         highlight("fact(n - 1)");
         int result = (Integer) call("fact", n.get() - 1);
         Rectangle2D bb = getCodeBounds("return n", "fact(n - 1)");
         PPValueTag tag = new PPValueTag(bb, result);
         getSlide().add(tag);
         tag.appear("/afterPrev");
         tag.disappear();
         return n.get() * result;
      }
   }

   private static final String[] CODE = {
      "function fact(n) {",
      "   if (n === 0) {",
      "      return 1;",
      "   } else {",
      "      return n * fact(n - 1);",
      "   }",
      "}"
   };

}
