/*
 * File: PPPieChartTest.java
 * -------------------------
 * This program tests the operation of the PPPieChart class.
 */

import edu.stanford.cs.pptx.chart.PPPieChart;
import edu.stanford.cs.pptx.PPShape;
import edu.stanford.cs.pptx.PPShow;
import edu.stanford.cs.pptx.PPSlide;
import java.awt.Color;

/**
 * This class creates a simple pie chart showing the number of pages
 * in the Harry Potter books.
 */

public class PPPieChartTest {

   public static void main(String[] args) {
      PPShow ppt = new PPShow();
      PPSlide slide = new PPSlide();
      slide.addTitle("Line Graph Test");
      double cx = ppt.getWindowWidth() / 2;
      double cy = ppt.getWindowHeight() / 2;
      PPPieChart graph = new PPPieChart(slide, cx - GRAPH_WIDTH / 2,
                                        cy - GRAPH_HEIGHT / 2,
                                        GRAPH_WIDTH, GRAPH_HEIGHT);
      graph.addWedges(POTTER_PAGES);
      ppt.add(slide);
      ppt.save("PPPieChartTest.pptx");
      System.out.println("PPPieChartTest.pptx");
   }

/* Constants */

   private static double[] POTTER_PAGES = {
      223, 251, 317, 636, 766, 607, 607
   };

   private static final double GRAPH_WIDTH = 500;
   private static final double GRAPH_HEIGHT = 300;

}
