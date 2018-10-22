/*
 * File: PPLineChartTest.java
 * --------------------------
 * This program tests the operation of the PPLineChart class.
 */

import edu.stanford.cs.pptx.chart.PPLineChart;
import edu.stanford.cs.pptx.PPFreeform;
import edu.stanford.cs.pptx.PPGroup;
import edu.stanford.cs.pptx.PPShape;
import edu.stanford.cs.pptx.PPShow;
import edu.stanford.cs.pptx.PPSlide;
import java.awt.Color;

/**
 * This class creates a simple line graph of the number of pages
 * showing the number of pages in the Harry Potter books.
 */

public class PPLineChartTest {

   public static void main(String[] args) {
      PPShow ppt = new PPShow();
      PPSlide slide = new PPSlide();
      slide.addTitle("Line Chart Test");
      double cx = ppt.getWindowWidth() / 2;
      double cy = ppt.getWindowHeight() / 2;
      PPLineChart graph = new PPLineChart(slide, cx - GRAPH_WIDTH / 2,
                                          cy - GRAPH_HEIGHT / 2,
                                          GRAPH_WIDTH, GRAPH_HEIGHT);
      graph.setChartLimits(-0.5, 6.5, 0, 800);
      graph.addBackground();
      for (int p = 100; p < 800; p += 100) {
         graph.addYGridLine(p);
         graph.addLeftTick(p);
         graph.addLeftLabel(p, Integer.toString(p));
      }
      for (int i = 0; i < 7; i++) {
         graph.addBottomTick(i);
         graph.addBottomLabel(i, "Volume " + (i + 1), 50);
      }
      PPGroup group = graph.addDataSeries(POTTER_PAGES, Color.RED, "Dot");
      PPFreeform line = (PPFreeform) group.getShapes()[0];
      line.setDashMode("dot");
      graph.addBorder();
      group.addAnimation("WipeIn/fromLeft/medium");
      ppt.add(slide);
      ppt.save("PPLineChartTest.pptx");
      System.out.println("PPLineChartTest.pptx");
   }

/* Constants */

   private static double[] POTTER_PAGES = {
      223, 251, 317, 636, 766, 607, 607
   };

   private static final double GRAPH_WIDTH = 500;
   private static final double GRAPH_HEIGHT = 300;

}
