/*
 * File: PPCodeDisplaySlide.java
 * -----------------------------
 * This class defines a slide that can display a multipage code display that
 * scrolls from one slide to the next.
 */

package edu.stanford.cs.pptx.code;

import edu.stanford.cs.pptx.PPRect;
import edu.stanford.cs.pptx.PPSlide;
import java.awt.Color;
import java.awt.Font;
import java.awt.geom.Rectangle2D;

/**
 * This class defines a slide that can display a step-by-step trace of
 * a program.
 */

public class PPCodeDisplaySlide extends PPSlide {

/**
 * Creates a new <code>PPCodeTraceSlide</code> object.
 */

   public PPCodeDisplaySlide() {
      width = getWidth() - 2 * SIDE_MARGIN;
      height = getHeight() - TOP_MARGIN - BOTTOM_MARGIN;
      oldCode = null;
      newCode = null;
      oldCodeImage = new PPCodeImage(width, height);
      newCodeImage = new PPCodeImage(width, height);
      hasBackgroundMasks = false;
      setFont(DEFAULT_CODE_FONT);
   }

/**
 * Sets a new syntax colorer for the display.
 *
 * @param sc The new <code>PPSyntaxColorer</code> object
 */

   public void setSyntaxColorer(PPSyntaxColorer sc) {
      oldCodeImage.setSyntaxColorer(sc);
      newCodeImage.setSyntaxColorer(sc);
   }

/**
 * Sets the font for the code box.
 *
 * @param font The font for the code box
 */

   public void setFont(Font font) {
      oldCodeImage.setFont(font);
      newCodeImage.setFont(font);
   }

/**
 * Sets the font for the code box.  In this version of <code>setFont</code>,
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
 * Sets the spacing for the code box.
 *
 * @param spacing The line spacing in points
 */

   public void setSpacing(double spacing) {
      oldCodeImage.setSpacing(spacing);
      newCodeImage.setSpacing(spacing);
   }

/**
 * Sets the old code.  If a slide contains both new and old code, the
 * old code must be set first.
 *
 * @param code The code from the old code page
 */

   public void setOldCode(String[] code) {
      oldCode = code;
      oldCodeImage.setCode(code);
   }

/**
 * Sets the new code.  If a slide contains both new and old code, the
 * old code must be set first.
 *
 * @param code The code from the new code page
 */

   public void setNewCode(String[] code) {
      newCode = code;
      newCodeImage.setCode(code);
      PPRect box = new PPRect(SIDE_MARGIN, TOP_MARGIN, width, height);
      box.setFillColor(Color.WHITE);
      box.setLineColor(Color.BLACK);
      box.setLineWidth(1);
      add(box);
      if (oldCode != null) {
         add(oldCodeImage, SIDE_MARGIN, TOP_MARGIN);
         oldCodeImage.addAnimation("FlyOut/toTop/afterPrev/fast");
      }
      add(newCodeImage, SIDE_MARGIN, TOP_MARGIN);
      if (oldCode != null) {
         newCodeImage.addAnimation("FlyIn/fromBottom/withPrev/fast");
         addBackgroundMasks();
      }
   }

/**
 * Gets the old code.
 *
 * @return The old code
 */

   public String[] getOldCode() {
      return oldCode;
   }

/**
 * Gets the new code.
 *
 * @return The new code
 */

   public String[] getNewCode() {
      return newCode;
   }

/**
 * Gets the old code image.
 *
 * @return The old code image
 */

   public PPCodeImage getOldCodeImage() {
      return oldCodeImage;
   }

/**
 * Gets the new code image.
 *
 * @return The new code image
 */

   public PPCodeImage getNewCodeImage() {
      return newCodeImage;
   }

/**
 * Highlights the specified line.
 *
 * @param line The line number
 */

   public void highlightLine(int line) {
      PPRect box = createHighlightBox(getCodeBounds(line));
      add(box);
      box.appear("/afterPrev");
      box.disappear("/onClick");
   }

/**
 * Highlights the line containing the specified string.
 *
 * @param str The string you're looking for
 */

   public void highlightLine(String str) {
      highlightLine(findCodeLine(str));
   }

/**
 * Highlights the specified region of the line.
 *
 * @param line The line number
 * @param p1 The starting index in the line
 * @param p2 The ending index in the line
 */

   public void highlight(int line, int p1, int p2) {
      PPRect box = createHighlightBox(getCodeBounds(line, p1, p2));
      add(box);
      box.appear("/afterPrev");
      box.disappear("/onClick");
   }

/**
 * Highlights the specified text.
 *
 * @param str The text you're looking for
 */

   public void highlight(String str) {
      int index = findCodeLine(str);
      String line = newCode[index];
      int p1 = line.indexOf(str);
      highlight(index, p1, p1 + str.length());
   }

/**
 * Highlights the specified text.
 *
 * @param context An identifier for the line
 * @param str The text you want to highlight
 */

   public void highlight(String context, String str) {
      int index = findCodeLine(context);
      String line = newCode[index];
      int p1 = line.indexOf(str);
      highlight(index, p1, p1 + str.length());
   }

/**
 * Creates a highlight box that encloses the specified region.
 *
 * @param bb The bounding box
 * @return A <code>PPRect</code> that encloses the box
 */

   public PPRect createHighlightBox(Rectangle2D bb) {
      PPRect box = new PPRect(bb);
      box.setFillColor("none");
      box.setLineColor(Color.RED);
      box.setLineWidth(2);
      return box;
   }

/**
 * Returns the rectangular region that bounds the specified line.
 *
 * @param line The line number
 * @return A <code>Rectangle2D</code> that encloses the entire line
 */

   public Rectangle2D getCodeBounds(int line) {
      return newCodeImage.getCodeBounds(line);
   }

/**
 * Returns the rectangular region that bounds the line containing the
 * specified string.
 *
 * @param str The string identifying the desired line
 * @return A <code>Rectangle2D</code> that encloses the entire line
 */

   public Rectangle2D getCodeBounds(String str) {
      return getCodeBounds(findCodeLine(str));
   }

/**
 * Returns the rectangular region that bounds the specified substring of
 * the code line.
 *
 * @param line The line number
 * @param p1 The index of the starting character
 * @param p2 The index of the character following the end
 * @return A <code>Rectangle2D</code> that encloses the code
 */

   public Rectangle2D getCodeBounds(int line, int p1, int p2) {
      return newCodeImage.getCodeBounds(line, p1, p2);
   }

/**
 * Returns the rectangular region that bounds the first occurrence of
 * <code>substring</code> on the specified line.
 *
 * @param line The line number
 * @param substring The substring you want to highlight
 * @return A <code>Rectangle2D</code> that encloses the code
 */

   public Rectangle2D getCodeBounds(int line, String substring) {
      String text = newCode[line];
      int p1 = text.indexOf(substring);
      return getCodeBounds(line, p1, p1 + substring.length());
   }

/**
 * Returns the rectangular region that bounds the first occurrence of
 * <code>substring</code> on the line containing <code>str</code>.
 *
 * @param str The string identifying the desired line
 * @param substring The substring you want to highlight
 * @return A <code>Rectangle2D</code> that encloses the code
 */

   public Rectangle2D getCodeBounds(String str, String substring) {
      int line = findCodeLine(str);
      String text = newCode[line];
      int p1 = text.indexOf(substring);
      return getCodeBounds(line, p1, p1 + substring.length());
   }

/**
 * Finds the code line containing the specified text.
 *
 * @param str The text you're looking for
 * @return Returns the line number from the code
 */

   public int findCodeLine(String str) {
      int nLines = newCode.length;
      for (int i = 0; i < nLines; i++) {
         if (newCode[i].contains(str)) return i;
      }
      return -1;
   }

/**
 * Adds background masks to the top and bottom of the slide.  These masks
 * make it possible to scroll code images out of the window without having
 * them appear on the screen.
 */

   public void addBackgroundMasks() {
      if (hasBackgroundMasks) return;
      PPRect topMask = new PPRect(0, 0, getWidth(), TOP_MARGIN);
      topMask.setFillColor("bg");
      topMask.setLineColor("none");
      add(topMask);
      PPRect bottomMask = new PPRect(0, getHeight() - BOTTOM_MARGIN,
                                     getWidth(), BOTTOM_MARGIN);
      bottomMask.setFillColor("bg");
      bottomMask.setLineColor("none");
      add(bottomMask);
      sendToFront(getTitleShape());
      PPRect frame = new PPRect(SIDE_MARGIN, TOP_MARGIN, width, height);
      frame.setFillColor("none");
      frame.setLineColor(Color.BLACK);
      frame.setLineWidth(1);
      add(frame);
      hasBackgroundMasks = true;
   }

/* Private constants */

   private static final String DEFAULT_CODE_FONT = "Courier New-Bold-14";
   private static final double BOTTOM_MARGIN = 32;
   private static final double SIDE_MARGIN = 24;
   private static final double TOP_MARGIN = 85;

/* Private instance variables */

   private PPCodeImage newCodeImage;
   private PPCodeImage oldCodeImage;
   private String[] newCode;
   private String[] oldCode;
   private boolean hasBackgroundMasks;
   private double width;
   private double height;

}
