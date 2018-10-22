/*
 * File: PPPieChart.java
 * ---------------------
 * This file defines a class that represents a pie chart on a PowerPoint
 * slide.
 */

package edu.stanford.cs.pptx.chart;

import edu.stanford.cs.pptx.PPPie;
import edu.stanford.cs.pptx.PPSlide;
import java.awt.Color;
import java.awt.geom.Rectangle2D;

/**
 * This class defines a pie chart on a PowerPoint slide.
 */

public class PPPieChart extends PPChart {

/**
 * Creates a new pie chart centered at (<code>x</code>, <code>y</code>)
 * with the specified radius.
 *
 * @param slide The <code>PPSlide</code> object on which this chart appears
 * @param x The <i>x</i> coordinate of the center
 * @param y The <i>y</i> coordinate of the center
 * @param r The radius of the pie chart
 */

   public PPPieChart(PPSlide slide, double x, double y, double r) {
      this(slide, x - r, y - r, 2 * r, 2 * r);
   }

/**
 * Creates a new pie chart within the specified bounds.
 *
 * @param slide The <code>PPSlide</code> object on which this chart appears
 * @param x The left side of the bounding box
 * @param y The top side of the bounding box
 * @param width The width of the bounding box
 * @param height The height of the bounding box
 */

   public PPPieChart(PPSlide slide, double x, double y,
                                    double width, double height) {
      super(slide, x, y, width, height);
      startAngle = 90;
   }

/**
 * Sets the starting angle for the pie chart.
 *
 * @param start The starting angle for the pie chart
 */

   public void setStartAngle(double start) {
      startAngle = start;
   }

/**
 * Gets the starting angle for the pie chart.
 *
 * @return The starting angle for the pie chart
 */

   public double getStartAngle() {
      return startAngle;
   }

/**
 * Adds an array of wedges for the pie chart using the data values in
 * the specified array.  The <code>colors</code> are chosen from a
 * standard nine-color palette designed to offer good visual separation.
 *
 * @param data The array of data values
 * @return An array of pie wedges for the chart
 */

   public PPPie[] addWedges(double[] data) {
      PPPie[] wedges = createWedges(data);
      PPSlide slide = getSlide();
      for (PPPie pie : wedges) {
         slide.add(pie);
      }
      return wedges;
   }

/**
 * Creates an array of wedges for the pie chart using the data values in
 * the specified array.  The <code>colors</code> are chosen from a
 * standard nine-color palette designed to offer good visual separation.
 *
 * @param data The array of data values
 * @return An array of pie wedges for the chart
 */

   public PPPie[] createWedges(double[] data) {
      return createWedges(data, STANDARD_PALETTE);
   }

/**
 * Adds an array of wedges for the pie chart using the data values in
 * the specified array.  The <code>colors</code> array is used to set the
 * fill color of the wedges.  The wedges are laid out counterclockwise
 * starting at the angle set by the <code>setStart</code> method.
 *
 * @param data The array of data values
 * @param colors The array of colors
 * @return An array of pie wedges for the chart
 */

   public PPPie[] addWedges(double[] data, Color[] colors) {
      PPPie[] wedges = createWedges(data, colors);
      PPSlide slide = getSlide();
      for (PPPie pie : wedges) {
         slide.add(pie);
      }
      return wedges;
   }

/**
 * Creates an array of wedges for the pie chart using the data values in
 * the specified array.  The <code>colors</code> array is used to set the
 * fill color of the wedges.  The wedges are laid out counterclockwise
 * starting at the angle set by the <code>setStart</code> method.
 *
 * @param data The array of data values
 * @param colors The array of colors
 * @return An array of pie wedges for the chart
 */

   public PPPie[] createWedges(double[] data, Color[] colors) {
      Rectangle2D bb = getBounds();
      double r = Math.min(bb.getWidth(), bb.getHeight()) / 2;
      double x = bb.getX() + bb.getWidth() / 2 - r;
      double y = bb.getY() + bb.getHeight() / 2 - r;
      int n = data.length;
      int nc = colors.length;
      PPPie[] wedges = new PPPie[n];
      double total = 0;
      for (int i = 0; i < n; i++) {
         total += data[i];
      }
      double start = startAngle;
      for (int i = 0; i < n; i++) {
         double sweep = 360 * data[i] / total;
         PPPie wedge = new PPPie(x, y, 2 * r, 2 * r, start, sweep);
         wedge.setFillColor(colors[i % nc]);
         wedges[i] = wedge;
         start += sweep;
      }
      return wedges;
   }

/* Private constants */

   private Color[] STANDARD_PALETTE = {
      new Color(0xFF6666),    /* red */
      new Color(0xFFFF33),    /* yellow */
      new Color(0xCC66CC),    /* purple */
      new Color(0xCC9933),    /* brown */
      new Color(0xFF6699),    /* pink */
      new Color(0x66CC66),    /* green */
      new Color(0xFFCC33),    /* orange */
      new Color(0x6699FF),    /* blue */
      new Color(0x666666)     /* gray */
   };

/* Private instance variables */

   private double startAngle;

}
