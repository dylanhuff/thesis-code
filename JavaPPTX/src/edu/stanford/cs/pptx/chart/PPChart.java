/*
 * File: PPChart.java
 * ------------------
 * This file defines the common superclass for all charts in the package.
 */

package edu.stanford.cs.pptx.chart;

import edu.stanford.cs.pptx.PPLine;
import edu.stanford.cs.pptx.PPOval;
import edu.stanford.cs.pptx.PPRect;
import edu.stanford.cs.pptx.PPShape;
import edu.stanford.cs.pptx.PPShapeFactory;
import edu.stanford.cs.pptx.PPSlide;
import edu.stanford.cs.pptx.PPTextBox;
import edu.stanford.cs.pptx.util.OptionParser;
import edu.stanford.cs.pptx.util.PPUtil;
import java.awt.Color;
import java.awt.Font;
import java.awt.geom.Rectangle2D;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * This class is the top of the abstract hierarchy for charts created using
 * the <code>pptx.chart</code> package.  Each of the chart subclasses export
 * methods for assembling charts on a slide.  In most cases, these methods
 * are exported in two forms: (1) an <code>add</code><i>xxx</i> method that
 * adds an element to a slide and (2) a <code>create</code><i>xxx</i> method
 * that creates the element so that the client can add it later.  Both
 * methods return the created shape so that the client can add animations
 * or change its properties.
 */

abstract public class PPChart {

/**
 * Creates a new chart object on the slide with the specified bounds.
 *
 * @param slide The <code>PPSlide</code> object on which this chart appears
 * @param x The left side of the bounding box
 * @param y The top side of the bounding box
 * @param width The width of the bounding box
 * @param height The height of the bounding box
 */

   public PPChart(PPSlide slide, double x, double y,
                                 double width, double height) {
      this.slide = slide;
      x0 = x;
      y0 = y;
      this.width = width;
      this.height = height;
      setChartLimits(0, 0, width, height);
      gridWeight = DEFAULT_GRID_WEIGHT;
      gridColor = DEFAULT_GRID_COLOR;
      tickColor = DEFAULT_TICK_COLOR;
      tickLength = DEFAULT_TICK_LENGTH;
      labelFont = DEFAULT_LABEL_FONT;
   }

/**
 * Gets the <code>PPSlide</code> object on which this chart appears.
 *
 * @return The <code>PPSlide</code> object on which this chart appears
 */

   public PPSlide getSlide() {
      return slide;
   }

/**
 * Gets the bounds of the chart on the slide.
 *
 * @return The bounds of the chart on the slide
 */

   public Rectangle2D getBounds() {
      return new Rectangle2D.Double(x0, y0, width, height);
   }

/**
 * Sets the limits of the chart area in units appropriate to the application.
 * Note that the coordinate system inside the chart is Cartesian, with the
 * origin in the lower left corner.
 *
 * @param xmin The minimum x value at the left
 * @param xmax The maximum x value at the right
 * @param ymin The minimum y value at the bottom
 * @param ymax The maximum y value at the top
 */

   public void setChartLimits(double xmin, double xmax,
                              double ymin, double ymax) {
      this.xmin = xmin;
      this.xmax = xmax;
      this.ymin = ymin;
      this.ymax = ymax;
   }

/**
 * Sets the limits of the chart area in units using parameters defining a
 * bounding box in the chart space.
 *
 * @param x The minimum x value at the left
 * @param y The minimum y value at the bottom
 * @param width The width in chart space
 * @param height The height in chart space
 */

   public void setChartBounds(double x, double y,
                              double width, double height) {
      xmin = x;
      ymin = y;
      xmax = x + width;
      ymax = y + height;
   }

/**
 * Gets the limits of the chart area in units appropriate to the application.
 * The result is returned as a Cartesian rectangle with the origin in the
 * lower left corner.
 *
 * @return A <code>Rectangle2D</code> describing the bounds in chart space
 */

   public Rectangle2D getChartBounds() {
      return new Rectangle2D.Double(xmin, ymin, xmax - xmin, ymax - ymin);
   }

/**
 * Adds the shape corresponding to the background to the slide.  With
 * no parameter, <code>addBackground</code> creates a white background.
 *
 * @return The background shape
 */

   public PPRect addBackground() {
      PPRect shape = createBackground();
      slide.add(shape);
      return shape;
   }

/**
 * Creates the shape corresponding to the background.  With no parameter,
 * <code>createBackground</code> creates a white background.
 *
 * @return The background shape
 */

   public PPRect createBackground() {
      return createBackground(Color.WHITE);
   }

/**
 * Adds the background shape with the specified color.
 *
 * @param color The color of the background
 * @return The background shape
 */

   public PPRect addBackground(Color color) {
      PPRect shape = createBackground(color);
      slide.add(shape);
      return shape;
   }

/**
 * Creates the background shape with the specified color.
 *
 * @param color The color of the background
 * @return The background shape
 */

   public PPRect createBackground(Color color) {
      PPRect frame = new PPRect(x0, y0, width, height);
      frame.setFillColor(color);
      return frame;
   }

/**
 * Adds a border frame for the chart.  This shape is typically added last
 * to ensure that the data does not overwrite the border.
 *
 * @return The shape representing the border
 */

   public PPRect addBorder() {
      PPRect shape = createBorder();
      slide.add(shape);
      return shape;
   }

/**
 * Creates a border frame for the chart.  This shape is typically added
 * last to ensure that the data does not overwrite the border.
 *
 * @return The shape representing the border
 */

   public PPRect createBorder() {
      PPRect border = new PPRect(x0, y0, width, height);
      border.setFillColor("none");
      return border;
   }

/**
 * Adds a vertical grid line at the specified x coordinate.
 *
 * @param x The <code>x</code> coordinate of the grid line
 * @return The grid line
 */

   public PPLine addXGridLine(double x) {
      PPLine shape = createXGridLine(x);
      slide.add(shape);
      return shape;
   }

/**
 * Creates a vertical grid line at the specified x coordinate.
 *
 * @param x The <code>x</code> coordinate of the grid line
 * @return The grid line
 */

   public PPLine createXGridLine(double x) {
      double xg = getChartX(x);
      PPLine line = new PPLine(xg, y0, xg, y0 + height);
      line.setColor(gridColor);
      line.setLineWidth(gridWeight);
      return line;
   }

/**
 * Adds a horizontal grid line at the specified y coordinate.
 *
 * @param y The <code>y</code> coordinate of the grid line
 * @return The grid line
 */

   public PPLine addYGridLine(double y) {
      PPLine shape = createYGridLine(y);
      slide.add(shape);
      return shape;
   }

/**
 * Creates a horizontal grid line at the specified y coordinate.
 *
 * @param y The <code>y</code> coordinate of the grid line
 * @return The grid line
 */

   public PPLine createYGridLine(double y) {
      double yg = getChartY(y);
      PPLine line = new PPLine(x0, yg, x0 + width, yg);
      line.setColor(gridColor);
      line.setLineWidth(gridWeight);
      return line;
   }

/**
 * Adds a vertical tick mark at the specified x coordinate along the
 * bottom of the chart.
 *
 * @param x The <code>x</code> coordinate of the tick mark
 * @return The tick mark
 */

   public PPLine addBottomTick(double x) {
      PPLine shape = createBottomTick(x);
      slide.add(shape);
      return shape;
   }

/**
 * Creates a vertical tick mark at the specified x coordinate along the
 * bottom of the chart.
 *
 * @param x The <code>x</code> coordinate of the tick mark
 * @return The tick mark
 */

   public PPLine createBottomTick(double x) {
      double xg = getChartX(x);
      PPLine line = new PPLine(xg, y0 + height, xg, y0 + height + tickLength);
      line.setColor(tickColor);
      line.setLineWidth(gridWeight);
      return line;
   }

/**
 * Adds a label to the tick mark at the bottom of the chart.
 * The label is centered underneath the tick mark.
 *
 * @param x The <code>x</code> coordinate of the tick mark
 * @param str The text for the label
 * @return The label
 */

   public PPTextBox addBottomLabel(double x, String str) {
      PPTextBox shape = createBottomLabel(x, str);
      slide.add(shape);
      return shape;
   }

/**
 * Creates a label to the tick mark at the bottom of the chart.
 * The label is centered underneath the tick mark.
 *
 * @param x The <code>x</code> coordinate of the tick mark
 * @param str The text for the label
 * @return The label
 */

   public PPTextBox createBottomLabel(double x, String str) {
      return createBottomLabel(x, str, 0);
   }

/**
 * Adds a label to the tick mark at the bottom of the chart.
 * If <code>theta</code> is 0, the label is centered under the tick mark;
 * otherwise the label is rotated by <code>theta</code> degrees so that
 * the end of the label is correctly oriented at the center of the tick.
 *
 * @param x The <code>x</code> coordinate of the tick mark
 * @param str The text for the label
 * @param theta The angle of rotation in degrees
 * @return The label
 */

   public PPTextBox addBottomLabel(double x, String str, double theta) {
      PPTextBox shape = createBottomLabel(x, str, theta);
      slide.add(shape);
      return shape;
   }

/**
 * Creates a label to the tick mark at the bottom of the chart.
 * If <code>theta</code> is 0, the label is centered under the tick mark;
 * otherwise the label is rotated by <code>theta</code> degrees so that
 * the end of the label is correctly oriented at the center of the tick.
 *
 * @param x The <code>x</code> coordinate of the tick mark
 * @param str The text for the label
 * @param theta The angle of rotation in degrees
 * @return The label
 */

   public PPTextBox createBottomLabel(double x, String str, double theta) {
      PPTextBox label = new PPTextBox(str);
      label.setFont(labelFont);
      double xc = getChartX(x);
      double yc = y0 + height + tickLength + STANDARD_LABEL_DY;
      double w = label.getWidth();
      double h = label.getHeight();
      double t = Math.toRadians(theta);
      if (theta == 0) {
         label.setInitialLocation(xc - w / 2, yc);
         label.setHorizontalAlignment("Center");
      } else if (theta > 0) {
         double xl = xc - w / 2 * Math.cos(t) - w / 2 - TILTED_LABEL_DX;
         double yl = yc + w / 2 * Math.sin(t) - h / 2 + TILTED_LABEL_DY;
         label.setInitialLocation(xl, yl);
         label.setRotation(theta);
         label.setHorizontalAlignment("Right");
      } else {
         double xl = xc + w / 2 * Math.cos(t) - w / 2 + TILTED_LABEL_DX;
         double yl = yc + w / 2 * Math.sin(t) - h / 2 + TILTED_LABEL_DY;
         label.setInitialLocation(xl, yl);
         label.setRotation(theta);
         label.setHorizontalAlignment("Left");
      }
      return label;
   }

/**
 * Adds a horizontal tick mark at the specified y coordinate along the
 * left edge of the chart.
 *
 * @param y The <code>y</code> coordinate of the tick mark
 * @return The tick mark
 */

   public PPLine addLeftTick(double y) {
      PPLine shape = createLeftTick(y);
      slide.add(shape);
      return shape;
   }

/**
 * Creates a horizontal tick mark at the specified y coordinate along the
 * left edge of the chart.
 *
 * @param y The <code>y</code> coordinate of the tick mark
 * @return The tick mark
 */

   public PPLine createLeftTick(double y) {
      double yg = getChartY(y);
      PPLine line = new PPLine(x0 - tickLength, yg, x0, yg);
      line.setColor(tickColor);
      line.setLineWidth(gridWeight);
      return line;
   }

/**
 * Adds a label to the tick mark at the left edge of the chart.
 *
 * @param y The <code>y</code> coordinate of the tick mark
 * @param str The text for the label
 * @return The label
 */

   public PPTextBox addLeftLabel(double y, String str) {
      PPTextBox shape = createLeftLabel(y, str);
      slide.add(shape);
      return shape;
   }

/**
 * Creates a label to the tick mark at the left edge of the chart.
 *
 * @param y The <code>y</code> coordinate of the tick mark
 * @param str The text for the label
 * @return The label
 */

   public PPTextBox createLeftLabel(double y, String str) {
      PPTextBox label = new PPTextBox(str);
      label.setFont(labelFont);
      double xc = x0 - tickLength + LEFT_LABEL_DX;
      double yc = getChartY(y) + LEFT_LABEL_DY;
      double w = label.getWidth();
      double h = label.getHeight();
      label.setInitialLocation(xc - w, yc - h / 2);
      label.setHorizontalAlignment("Right");
      return label;
   }

/**
 * Adds a horizontal tick mark at the specified y coordinate along the
 * left edge of the chart.
 *
 * @param y The <code>y</code> coordinate of the tick mark
 * @return The tick mark
 */

   public PPLine addRightTick(double y) {
      PPLine shape = createRightTick(y);
      slide.add(shape);
      return shape;
   }

/**
 * Creates a horizontal tick mark at the specified y coordinate along the
 * left edge of the chart.
 *
 * @param y The <code>y</code> coordinate of the tick mark
 * @return The tick mark
 */

   public PPLine createRightTick(double y) {
      double yg = getChartY(y);
      double x = getChartX(xmax);
      PPLine line = new PPLine(x, yg, x + tickLength, yg);
      line.setColor(tickColor);
      line.setLineWidth(gridWeight);
      return line;
   }

/**
 * Adds a label to the tick mark at the left edge of the chart.
 *
 * @param y The <code>y</code> coordinate of the tick mark
 * @param str The text for the label
 * @return The label
 */

   public PPTextBox addRightLabel(double y, String str) {
      PPTextBox shape = createRightLabel(y, str);
      slide.add(shape);
      return shape;
   }

/**
 * Creates a label to the tick mark at the left edge of the chart.
 *
 * @param y The <code>y</code> coordinate of the tick mark
 * @param str The text for the label
 * @return The label
 */

   public PPTextBox createRightLabel(double y, String str) {
      PPTextBox label = new PPTextBox(str);
      label.setFont(labelFont);
      double xc = getChartX(xmax) + tickLength + RIGHT_LABEL_DX;
      double yc = getChartY(y) + RIGHT_LABEL_DY;
      double h = label.getHeight();
      label.setInitialLocation(xc, yc - h / 2);
      return label;
   }

/**
 * Adds vertical shading between the specified x coordinates.
 *
 * @param x0 The leftmost x coordinate in user space
 * @param x1 The rightmost x coordinate in user space
 * @param color The color of the shaded rectangle
 * @return The shading rectangle
 */

   public PPRect addVerticalShading(double x0, double x1, Color color) {
      PPRect shading = createVerticalShading(x0, x1, color);
      slide.add(shading);
      return shading;
   }

/**
 * Creates a vertical shading rectangle between the specified x coordinates.
 *
 * @param x0 The leftmost x coordinate in user space
 * @param x1 The rightmost x coordinate in user space
 * @param color The color of the shaded rectangle
 * @return The shading rectangle
 */

   public PPRect createVerticalShading(double x0, double x1, Color color) {
      double cx0 = getChartX(x0);
      double cx1 = getChartX(x1);
      PPRect shading = new PPRect(cx0, y0, cx1 - cx0, height);
      shading.setFillColor(color);
      shading.setLineColor("none");
      return shading;
   }

/**
 * Adds horizontal shading between the specified y coordinates.
 *
 * @param y0 The bottom y coordinate in user space
 * @param y1 The top y coordinate in user space
 * @param color The color of the shaded rectangle
 * @return The shading rectangle
 */

   public PPRect addHorizontalShading(double y0, double y1, Color color) {
      PPRect shading = createHorizontalShading(y0, y1, color);
      slide.add(shading);
      return shading;
   }

/**
 * Creates a horizontal shading rectangle between the specified y coordinates.
 *
 * @param y0 The bottom y coordinate in user space
 * @param y1 The top y coordinate in user space
 * @param color The color of the shaded rectangle
 * @return The shading rectangle
 */

   public PPRect createHorizontalShading(double y0, double y1, Color color) {
      double cy0 = getChartY(y0);
      double cy1 = getChartY(y1);
      PPRect shading = new PPRect(x0, cy1, width, cy0 - cy1);
      shading.setFillColor(color);
      shading.setLineColor("none");
      return shading;
   }

/**
 * Adds a mask to the bottom of the slide. This method must be called
 * before adding the border or any annotations (ticks or labels) to the
 * bottom of the graph.
 *
 * @return The rectangle that covers the bottom of the window
 */

   public PPRect addBottomMask() {
      PPRect mask = createBottomMask();
      slide.add(mask);
      return mask;
   }

/**
 * Creates a mask for the bottom of the slide. This mask must be added
 * before adding the border or any annotations (ticks or labels) to the
 * bottom of the graph.
 *
 * @return The rectangle that covers the bottom of the window
 */

   public PPRect createBottomMask() {
      PPRect mask = new PPRect(0, y0 + height, slide.getWidth(),
                               slide.getHeight() - y0 - height);
      mask.setFillColor("bg");
      mask.setLineColor("none");
      return mask;
   }

/**
 * Adds a mask to the top of the slide. Adding a mask at the top
 * requires manual repositioning of the title so that it is not buried.
 *
 * @return The rectangle that covers the top of the window
 */

   public PPRect addTopMask() {
      PPRect mask = createTopMask();
      slide.add(mask);
      return mask;
   }

/**
 * Creates a mask for the top of the slide. Creating a mask at the top
 * requires manual repositioning of the title so that it is not buried.
 *
 * @return The rectangle that covers the top of the window
 */

   public PPRect createTopMask() {
      PPRect mask = new PPRect(0, 0, slide.getWidth(), y0);
      mask.setFillColor("bg");
      mask.setLineColor("none");
      return mask;
   }

/**
 * Adds a mask to the right side of the slide. This method must be called
 * before adding the border or any annotations (ticks or labels) to the
 * right side of the graph.
 *
 * @return The rectangle that covers the right side of the window
 */

   public PPRect addRightMask() {
      PPRect mask = createRightMask();
      slide.add(mask);
      return mask;
   }

/**
 * Creates a mask for the right side of the slide. This mask must be added
 * before adding the border or any annotations (ticks or labels) to the
 * right side of the graph.
 *
 * @return The rectangle that covers the right side of the window
 */

   public PPRect createRightMask() {
      PPRect mask = new PPRect(x0 + width, 0, slide.getWidth() - x0 - width,
                               slide.getHeight());
      mask.setFillColor("bg");
      mask.setLineColor("none");
      return mask;
   }

/**
 * Adds a mask to the left side of the slide. This mask must be added
 * before adding the border or any annotations (ticks or labels) to the
 * left side of the graph.
 *
 * @return The rectangle that covers the left side of the window
 */

   public PPRect addLeftMask() {
      PPRect mask = createLeftMask();
      slide.add(mask);
      return mask;
   }

/**
 * Creates a mask for the left side of the slide. This mask must be added
 * before adding the border or any annotations (ticks or labels) to the
 * left side of the graph.
 *
 * @return The rectangle that covers the left side of the window
 */

   public PPRect createLeftMask() {
      PPRect mask = new PPRect(0, 0, x0, slide.getHeight());
      mask.setFillColor("bg");
      mask.setLineColor("none");
      return mask;
   }

/**
 * Sets the weight of the grid lines in the chart.
 *
 * @param weight The weight of the grid lines in the chart
 */

   public void setGridWeight(double weight) {
      gridWeight = weight;
   }

/**
 * Gets the weight of the grid lines in the chart.
 *
 * @return The weight of the grid lines in the chart
 */

   public double getGridWeight() {
      return gridWeight;
   }

/**
 * Sets the color of the grid lines in the chart.
 *
 * @param color The color of the grid lines in the chart
 */

   public void setGridColor(Color color) {
      gridColor = color;
   }

/**
 * Gets the color of the grid lines in the chart.
 *
 * @return The color of the grid lines in the chart
 */

   public Color getGridColor() {
      return gridColor;
   }

/**
 * Sets the color of the tick lines in the chart.
 *
 * @param color The color of the tick lines in the chart
 */

   public void setTickColor(Color color) {
      tickColor = color;
   }

/**
 * Gets the color of the tick lines in the chart.
 *
 * @return The color of the tick lines in the chart
 */

   public Color getTickColor() {
      return tickColor;
   }

/**
 * Sets the font used for the labels.
 *
 * @param font The font used for the labels
 */

   public void setTickFont(Font font) {
      labelFont = font;
   }

/**
 * Sets the font used for the labels.
 *
 * @param str The string describing the font
 */

   public void setTickFont(String str) {
      labelFont = Font.decode(str);
   }

/**
 * Gets the font used for the labels.
 *
 * @return The font used for the labels
 */

   public Font getTickFont() {
      return labelFont;
   }

/**
 * Gets the pixel coordinate of the value <code>x</code>.
 *
 * @param x The x coordinate of the value in chart space
 * @return The corresponding pixel coordinate
 */

   public double getChartX(double x) {
      return x0 + width * (x - xmin) / (xmax - xmin);
   }

/**
 * Gets the pixel coordinate of the value <code>y</code>.
 *
 * @param y The y coordinate of the value in chart space
 * @return The corresponding pixel coordinate
 */

   public double getChartY(double y) {
      return y0 + height - height * (y - ymin) / (ymax - ymin);
   }

/**
 * Creates a <code>PPShapeFactory</code> that produces a data point marker
 * from an option string.
 *
 * @param options The string indicating the type of mark and its parameters
 * @return A <code>PPShapeFactory</code> that creates marks of that type
 */

   public PPShapeFactory createMarkerFactory(String options) {
      return createMarkerFactory(options, null);
   }

/**
 * Creates a <code>PPShapeFactory</code> that produces a data point marker
 * from an option string and a default color.
 *
 * @param options The string indicating the type of mark and its parameters
 * @param color The color of the marker
 * @return A <code>PPShapeFactory</code> that creates marks of that type
 */

   public PPShapeFactory createMarkerFactory(String options, Color color) {
      String name = options;
      String flags = "";
      int slash = options.indexOf("/");
      if (slash == 0) throw new RuntimeException("Missing marker type");
      if (slash > 0) {
         name = options.substring(0, slash);
         flags = options.substring(slash);
      }
      String className = "edu.stanford.cs.pptx.chart.PP" + name + "Marker";
      try {
         Class<?> type = Class.forName(className);
         PPMarker marker = (PPMarker) type.getConstructor().newInstance();
         if (color != null) {
            String cname = Integer.toHexString(color.getRGB());
            while (cname.length() < 8) {
               cname = "0" + cname;
            }
            marker.parseOptions("/color:#" + cname);
         }
         marker.parseOptions(flags);
         return marker;
      } catch (ClassNotFoundException ex) {
         throw new RuntimeException("No marker named " + name);
      } catch (InstantiationException ex) {
         throw new RuntimeException("Can't create marker named " + name);
      } catch (InvocationTargetException ex) {
         throw new RuntimeException("Can't create marker named " + name);
      } catch (NoSuchMethodException ex) {
         throw new RuntimeException("Can't create marker named " + name);
      } catch (IllegalAccessException ex) {
         throw new RuntimeException("Can't create marker named " + name);
      }
   }

/**
 * Sums an array of integers.
 *
 * @param array An array of type int
 * @return The sum of the array
 */

   public static int sumArray(int[] array) {
      int sum = 0;
      for (int i = 0; i < array.length; i++) {
         sum += array[i];
      }
      return sum;
   }

/**
 * Sums an array of doubles.
 *
 * @param array The array of type double
 * @return The sum of the array
 */

   public static double sumArray(double[] array) {
      double sum = 0;
      for (int i = 0; i < array.length; i++) {
         sum += array[i];
      }
      return sum;
   }

/* Private constants */

   private static final Color DEFAULT_GRID_COLOR = Color.GRAY;
   private static final Color DEFAULT_TICK_COLOR = Color.BLACK;
   private static final Font DEFAULT_LABEL_FONT = Font.decode("SansSerif-14");
   private static final double DEFAULT_GRID_WEIGHT = 1.0;
   private static final double DEFAULT_TICK_LENGTH = 6;
   private static final double STANDARD_LABEL_DY = -2;
   private static final double TILTED_LABEL_DX = 1.5;
   private static final double TILTED_LABEL_DY = 5;
   private static final double LEFT_LABEL_DX = -2;
   private static final double LEFT_LABEL_DY = -1;
   private static final double RIGHT_LABEL_DX = 1;
   private static final double RIGHT_LABEL_DY = -1;

/* Private instance variables */

   private PPSlide slide;
   private double x0;
   private double y0;
   private double width;
   private double height;
   private double xmin;
   private double xmax;
   private double ymin;
   private double ymax;
   private double gridWeight;
   private Color gridColor;
   private double tickLength;
   private Color tickColor;
   private Font labelFont;
}

/*
 * This abstract class is the superclass for all markers.
 */

abstract class PPMarker extends OptionParser implements PPShapeFactory {

/*
 * Invokes a key in the target class using reflection.  This method is
 * reimplemented here to ensure access to the package private classes.
 */

   @Override
   public void invokeKey(String key, String value) {
      Class<?>[] types = { String.class };
      Object[] args = { value };
      try {
         Method fn = getClass().getMethod(key + "Key", types);
         fn.invoke(this, args);
      } catch (NoSuchMethodException ex) {
         undefinedKey(key, value);
      } catch (InvocationTargetException ex) {
         throw new RuntimeException(ex);
      } catch (IllegalAccessException ex) {
         throw new RuntimeException(ex);
      }
   }

}

/*
 * This shape factory creates dots centered at the data point.
 */

class PPDotMarker extends PPMarker {

   public PPDotMarker() {
      size = DEFAULT_DOT_SIZE;
      color = Color.BLACK;
   }

   public void sizeKey(String str) {
      size = Double.parseDouble(str);
   }

   public void colorKey(String str) {
      if (!str.equals("none")) color = PPUtil.decodeColor(str);
   }

   @Override
   public PPShape createShape() {
      PPOval marker = new PPOval(-size / 2, -size / 2, size, size);
      marker.setColor(color);
      return marker;
   }

/* Private constants */

   private static final double DEFAULT_DOT_SIZE = 5;

/* Private instance variables */

   private Color color;
   private double size;

}
