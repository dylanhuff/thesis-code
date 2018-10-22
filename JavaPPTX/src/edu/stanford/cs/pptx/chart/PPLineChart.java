/*
 * File: PPLineChart.java
 * ----------------------
 * This file defines a class that represents a line chart on a slide.
 */

package edu.stanford.cs.pptx.chart;

import edu.stanford.cs.pptx.PPFreeform;
import edu.stanford.cs.pptx.PPGroup;
import edu.stanford.cs.pptx.PPPath;
import edu.stanford.cs.pptx.PPShape;
import edu.stanford.cs.pptx.PPShapeFactory;
import edu.stanford.cs.pptx.PPSlide;
import java.awt.Color;

/**
 * This class represents a line graph on a slide.
 */

public class PPLineChart extends PPChart {

/**
 * Creates a new PPLineChart object with the specified bounds.
 *
 * @param slide The <code>PPSlide</code> object on which this chart appears
 * @param x The left side of the bounding box
 * @param y The top side of the bounding box
 * @param width The width of the bounding box
 * @param height The height of the bounding box
 */

   public PPLineChart(PPSlide slide, double x, double y,
                                     double width, double height) {
      super(slide, x, y, width, height);
      lineWidth = 2.0;
   }

/**
 * Adds a <code>PPGroup</code> shape that contains a complete data
 * series in the line chart.  Data points are not indicated with this
 * version of the call.
 *
 * @param values An array of values in chart space
 * @param color The color of the line
 * @return The shape corresponding to the data series
 */

   public PPGroup addDataSeries(double[] values, Color color) {
      PPGroup shape = createDataSeries(values, color);
      getSlide().add(shape);
      return shape;
   }

/**
 * Creates a <code>PPGroup</code> shape that contains a complete data
 * series in the line chart.  Data points are not indicated with this
 * version of the call.
 *
 * @param values An array of values in chart space
 * @param color The color of the line
 * @return The shape corresponding to the data series
 */

   public PPGroup createDataSeries(double[] values, Color color) {
      return createDataSeries(values, color, (PPShapeFactory) null);
   }

/**
 * Adds a <code>PPGroup</code> shape that contains a complete data
 * series in the line chart.  The points are indicated by shapes created
 * by the <code>markerFactory</code> parameter, which should return a
 * shape whose origin is at the center of the figure.
 *
 * @param values An array of values in chart space
 * @param color The color of the line
 * @param markerFactory The factory that create the marker shape
 * @return The shape corresponding to the data series
 */

   public PPGroup addDataSeries(double[] values, Color color,
                                PPShapeFactory markerFactory) {
      PPGroup shape = createDataSeries(values, color, markerFactory);
      getSlide().add(shape);
      return shape;
   }

/**
 * Creates a <code>PPGroup</code> shape that contains a complete data
 * series in the line chart.  The points are indicated by shapes created
 * by the <code>markerFactory</code> parameter, which should return a
 * shape whose origin is at the center of the figure.
 *
 * @param values An array of values in chart space
 * @param color The color of the line
 * @param markerFactory The factory that create the marker shape
 * @return The shape corresponding to the data series
 */

   public PPGroup createDataSeries(double[] values, Color color,
                                   PPShapeFactory markerFactory) {
      PPGroup group = new PPGroup();
      PPPath path = new PPPath();
      int n = values.length;
      for (int i = 0; i < n; i++) {
         if (!Double.isNaN(values[i])) {
            double x = getChartX(i);
            double y = getChartY(values[i]);
            if (i == 0) {
               path.moveTo(x, y);
            } else {
               path.lineTo(x, y);
            }
         }
      }
      PPFreeform line = new PPFreeform(path);
      line.setColor(color);
      line.setLineWidth(lineWidth);
      group.add(line);
      if (markerFactory != null) {
         for (int i = 0; i < n; i++) {
            if (!Double.isNaN(values[i])) {
               PPShape marker = markerFactory.createShape();
               double x = getChartX(i) + marker.getX();
               double y = getChartY(values[i]) + marker.getY();
               marker.setInitialLocation(x, y);
               group.add(marker);
            }
         }
      }
      return group;
   }

/**
 * Adds a <code>PPGroup</code> shape that contains a complete data
 * series in the line chart.  The points are indicated by shapes created
 * using the option string, which consists of a marker name followed by
 * an option string used to set other properties.
 *
 * @param values An array of values in chart space
 * @param color The color of the line
 * @param options The options string used to construct the mark
 * @return The shape corresponding to the data series
 */

   public PPGroup addDataSeries(double[] values, Color color, String options) {
      PPGroup shape = createDataSeries(values, color, options);
      getSlide().add(shape);
      return shape;
   }

/**
 * Creates a <code>PPGroup</code> shape that contains a complete data
 * series in the line chart.  The points are indicated by shapes created
 * using the option string, which consists of a marker name followed by
 * an option string used to set other properties.
 *
 * @param values An array of values in chart space
 * @param color The color of the line
 * @param options The options string used to construct the mark
 * @return The shape corresponding to the data series
 */

   public PPGroup createDataSeries(double[] values, Color color,
                                   String options) {
      return createDataSeries(values, color,
                              createMarkerFactory(options, color));
   }

/**
 * Sets the width of the data lines in the chart.
 *
 * @param width The width of the data lines in the chart
 */

   public void setLineWidth(double width) {
      lineWidth = width;
   }

/**
 * Gets the width of the data lines in the chart.
 *
 * @return The width of the data lines in the chart
 */

   public double getLineWidth() {
      return lineWidth;
   }

/* Private instance variables */

   private double lineWidth;

}
