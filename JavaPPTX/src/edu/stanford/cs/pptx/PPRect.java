/*
 * File: PPRect.java
 * -----------------
 * This class represents a rectangular box in a PowerPoint slide.
 */

package edu.stanford.cs.pptx;

import edu.stanford.cs.pptx.util.PPOutputStream;
import edu.stanford.cs.pptx.util.PPUtil;
import java.awt.geom.Rectangle2D;
import java.awt.Color;
import java.awt.Font;


/**
 * This class represents a rectangular box in a PowerPoint slide.
 * The usual approach to working with a <code>PPRect</code>
 * shape is to create a new <code>PPRect</code> object and
 * then to add that object to a slide, as illustrated in the
 * following code, which creates a 100x100-pixel solid red square
 * whose upper left corner is at the point (200, 100):
 *
 *<pre>
 *    PPSlide slide = new PPSlide();
 *    PPRect square = new PPRect(100, 100);
 *    square.setColor(Color.RED);
 *    slide.add(square, 200, 100);
 *</pre>
 *
 * It is also possible to set properties of the <code>PPRect</code> shape,
 * either by passing an option string to the constructor or by invoking
 * methods in the class.
 */

public class PPRect extends PPAutoShape {

/**
 * Creates a new <code>PPRect</code> shape with the specified
 * coordinates and size.  Coordinates and distances are consistent with
 * the Java graphics model.  All distances are measured in pixels, and
 * the origin for the coordinate system is in the upper left corner of
 * the screen.
 *
 * @param x The <i>x</i> coordinate of the upper left corner
 * @param y The <i>y</i> coordinate of the upper left corner
 * @param width The width of the rectangle
 * @param height The height of the rectangle
 */

   public PPRect(double x, double y, double width, double height) {
      setBounds(x, y, width, height);
   }

/**
 * Creates a new <code>PPRect</code> shape from the specified coordinates
 * and size.  This version of the constructor operates in much the same manner
 * as the standard {@link #PPRect(double,double,double,double) PPRect}
 * constructor, but allows the caller to specify an option string.  The
 * advantage of embedding the option string in the constructor is that doing
 * so often makes it possible to add the shape to the slide immediately
 * without storing it in a temporary variable.
 *
 * @param x The <i>x</i> coordinate of the upper left corner
 * @param y The <i>y</i> coordinate of the upper left corner
 * @param width The width of the rectangle
 * @param height The height of the rectangle
 * @param options The options string
 */

   public PPRect(double x, double y, double width, double height,
                 String options) {
      this(x, y, width, height);
      setOptions(options);
   }

/**
 * Creates a new <code>PPRect</code> shape from its dimensions.
 * This version of the constructor is useful when you want to create the shape
 * and then add it to the slide at a position computed subsequently.
 *
 * @param width The width of the rectangle
 * @param height The height of the rectangle
 */

   public PPRect(double width, double height) {
      this(0, 0, width, height);
   }

/**
 * Creates a new <code>PPRect</code> shape from its dimensions and an options
 * string.
 *
 * @param width The width of the rectangle
 * @param height The height of the rectangle
 * @param options The options string
 */

   public PPRect(double width, double height, String options) {
      this(width, height);
      setOptions(options);
   }

/**
 * Creates a new <code>PPRect</code> shape from its bounding rectangle.
 *
 * @param bb A <code>Rectangle2D</code> that bounds the rectangle
 */

   public PPRect(Rectangle2D bb) {
      this(bb.getX(), bb.getY(), bb.getWidth(), bb.getHeight());
   }

/**
 * Creates a new <code>PPRect</code> shape from its bounding rectangle and
 * an option string.
 *
 * @param bb A <code>Rectangle2D</code> that bounds the rectangle
 * @param options The options string
 */

   public PPRect(Rectangle2D bb, String options) {
      this(bb);
      setOptions(options);
   }

  protected void dumpRectJS(PPOutputStream os){

    Color lineColor = getLineColor();

  }

/* Protected methods */

   @Override
   protected String presetGeometry() {
      return "rect";
   }

   protected PPRect() {
      /* Empty */
   }
}
