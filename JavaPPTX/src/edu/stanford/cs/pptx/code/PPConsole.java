/*
 * File: PPConsole.java
 * --------------------
 * This class represents a console window in a PowerPoint slide.
 */

package edu.stanford.cs.pptx.code;

import edu.stanford.cs.pptx.PPGroup;
import edu.stanford.cs.pptx.PPSlide;
import edu.stanford.cs.pptx.PPTextBox;
import edu.stanford.cs.pptx.util.PPUtil;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;

/**
 * This class represents a console window in the <code>pptx.code</code>
 * package.
 */

public class PPConsole extends PPGroup {

/**
 * Creates a <code>PPConsole</code> with the specified title and size.
 *
 * @param title The title for the console window
 * @param width The width of the console in pixels
 * @param height The height of the console in pixels
 */

   public PPConsole(String title, double width, double height) {
      this(title, 0, 0, width, height);
   }

/**
 * Creates a <code>PPConsole</code> with the specified title and size.
 * This version allows the client to determine whether to show the Macintosh
 * controls.
 *
 * @param title The title for the console window
 * @param width The width of the console in pixels
 * @param height The height of the console in pixels
 * @param showControls A boolean that controls whether the controls appear
 */

   public PPConsole(String title, double width, double height,
                    boolean showControls) {
      this(title, 0, 0, width, height, showControls);
   }

/**
 * Creates a <code>PPConsole</code> with the specified title and bounds.
 *
 * @param title The title for the console window
 * @param x The x coordinate of the left edge of the console
 * @param y The x coordinate of the top edge of the console
 * @param width The width of the console in pixels
 * @param height The height of the console in pixels
 */

   public PPConsole(String title, double x, double y,
                    double width, double height) {
      this(title, x, y, width, height, true);
   }

/**
 * Creates a <code>PPConsole</code> with the specified title and bounds.
 * This version allows the client to determine whether to show the Macintosh
 * controls.
 *
 * @param title The title for the console window
 * @param x The x coordinate of the left edge of the console
 * @param y The x coordinate of the top edge of the console
 * @param width The width of the console
 * @param height The height of the console
 * @param showControls A boolean that controls whether the controls appear
 */

   public PPConsole(String title, double x, double y,
                                  double width, double height,
                                  boolean showControls) {
      this.width = width;
      this.height = height;
      add(new PPWindowImage(title, width, height, showControls));
      setFont(DEFAULT_FONT);
      setLeftMargin(DEFAULT_LEFT_MARGIN);
      setTopMargin(DEFAULT_TOP_MARGIN);
      setInitialLocation(x, y);
      inputSpeed = 0;
      cy = -1;
   }

/**
 * Prints a line to the console.
 *
 * @param obj The object to be printed
 */

   public void println(Object obj) {
      println(obj, "Appear/afterPrev");
   }

/**
 * Advances the console to the next line.
 */

   public void println() {
      println("");
   }

/**
 * Prints a line to the console.  This version allows the client to specify
 * the animation options.
 *
 * @param obj The object to be printed
 * @param options The animation options
 */

   public void println(Object obj, String options) {
      if (cy == -1) cy = PPWindowImage.getTitleBarHeight() + topMargin;
      PPSlide slide = getSlide();
      PPTextBox tb = new PPTextBox();
      tb.setFont(font);
      FontMetrics fm = tb.getFontMetrics();
      String str = obj.toString();
      tb.setText(str);
      tb.setBounds(getX() + leftMargin, getY() + cy, width, fm.getHeight());
      cy += fm.getHeight();
      slide.add(tb);
      if (options != null && !options.isEmpty()) {
         tb.addAnimation(options);
      }
   }

/**
 * Simulates reading an input line on the console.
 *
 * @param prompt The prompt string
 * @param input The user input
 */

   public void readLine(String prompt, String input) {
      readLine(prompt, input, "Appear/afterPrev");
   }

/**
 * Simulates reading an input line on the console.  This version allows
 * the client to specify the animation options for the prompt.
 *
 * @param prompt The prompt string
 * @param input The user input
 * @param options The options before the prompt
 */

   public void readLine(String prompt, String input, String options) {
      if (cy == -1) cy = PPWindowImage.getTitleBarHeight() + topMargin;
      PPSlide slide = getSlide();
      PPTextBox tb = new PPTextBox();
      tb.setFont(font);
      FontMetrics fm = tb.getFontMetrics();
      tb.setText(prompt);
      double x0 = leftMargin;
      double x1 = x0 + fm.stringWidth(prompt);
      double pWidth = WIDTH_FUDGE * (x1 - x0);
      tb.setBounds(getX() + x0, getY() + cy, pWidth, fm.getHeight());
      slide.add(tb);
      if (options != null && !options.isEmpty()) {
         tb.addAnimation(options);
      }
      if (inputSpeed == 0) {
         tb = new PPTextBox();
         tb.setFont(font);
         tb.setFontColor(INPUT_COLOR);
         tb.setText(input);
         pWidth = WIDTH_FUDGE * fm.stringWidth(input);
         tb.setBounds(getX() + x1, getY() + cy, pWidth, fm.getHeight());
         slide.add(tb);
         tb.appear("/onClick");
      } else {
         String trigger = "/onClick";
         double delay = 1.0 / inputSpeed;
         double x = getX() + x1;
         for (int i = 0; i < input.length(); i++) {
            String ch = input.substring(i, i + 1);
            tb = new PPTextBox();
            tb.setFont(font);
            tb.setFontColor(INPUT_COLOR);
            tb.setText(ch);
            pWidth = WIDTH_FUDGE * fm.stringWidth(ch);
            tb.setBounds(x, getY() + cy, pWidth, fm.getHeight());
            slide.add(tb);
            tb.appear(trigger);
            x += fm.stringWidth(ch);
            trigger = "/afterPrev/delay:" + delay;
         }
      }
      cy += fm.getHeight();
   }

/**
 * Creates a sample run on the console from an array of strings.
 *
 * @param lines The lines to be displayed
 * @param marker The marker indicating the input prompt
 */

   public void createSampleRun(String[] lines, String marker) {
      String trigger = "/onClick";
      for (int i = 0; i < lines.length; i++) {
         String line = lines[i];
         int markIndex = line.indexOf(marker);
         if (markIndex == -1) {
            println(line, "Appear" + trigger);
            trigger = "/afterPrev";
         } else {
            String response = line.substring(markIndex + marker.length());
            if (marker.equals("@")) markIndex--;
            String prompt = line.substring(0, markIndex + marker.length());
            readLine(prompt, response, "Appear" + trigger);
            if (inputSpeed == 0) {
               trigger = "/afterPrev";
            } else {
               trigger = "/afterPrev/delay:" + (1.0 / inputSpeed);
            }
         }
      }
   }

/**
 * Sets the font for the console.
 *
 * @param font The font for the console
 */

   public void setFont(Font font) {
      this.font = font;
   }

/**
 * Sets the font for the console.  In this version of <code>setFont</code>,
 * the font is expressed as a string in the form
 *
 *<pre>
 *    "<i>family</i>-<i>style</i>-<i>size</i>"
 *</pre>
 *
 * @param str A string representing the font
 */

   public void setFont(String str) {
      setFont(Font.decode(str));
   }

/**
 * Sets the left margin for the console.
 *
 * @param margin The left margin
 */

   public void setLeftMargin(double margin) {
      leftMargin = margin;
   }

/**
 * Sets the top margin for the console.
 *
 * @param margin The top margin
 */

   public void setTopMargin(double margin) {
      topMargin = margin;
   }

/**
 * Sets the speed at which input text appears on the screen in characters
 * per second.  By default, this value is 0, which means the the characters
 * appear immediately.
 *
 * @param speed The character speed in characters per second.
 */

   public void setInputSpeed(double speed) {
      inputSpeed = speed;
   }

/* Private constants */

   private static final Color INPUT_COLOR = Color.BLUE;
   private static final String DEFAULT_FONT = "Courier New-Bold-14";
   private static final double DEFAULT_LEFT_MARGIN = 3;
   private static final double DEFAULT_TOP_MARGIN = 3;
   private static final double WIDTH_FUDGE = 1.05;

/* Private instance variables */

   private Font font;
   private double width;
   private double height;
   private double leftMargin;
   private double topMargin;
   private double cy;
   private double inputSpeed;

}
