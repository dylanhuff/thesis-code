/*
 * File: PPPolygon.java
 * --------------------
 * This class represents a polygon on a PowerPoint slide.
 */

package edu.stanford.cs.pptx;

import edu.stanford.cs.pptx.util.PPOutputStream;
import edu.stanford.cs.pptx.util.PPUtil;
import java.awt.Color;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

/**
 * The <code>PPPolygon</code> class is a simple shape whose appearance
 * consists of a polygon.  A <code>PPPolygon</code> starts as an empty
 * shape.  The edges of the polygon are added using some combination of
 * the methods <code>addVertex</code>, <code>addEdge</code>, and
 * <code>addPolarEdge</code>.
 */

public class PPPolygon extends PPAutoShape {

/**
 * Creates an empty <code>PPPolygon</code> at the origin.
 */

   public PPPolygon() {
      path = new PPPath();
      setBounds(0, 0, 0, 0);
   }

/**
 * Creates an empty <code>PPPolygon</code> at the origin.  This version
 * allows the client to specify the shape options.
 *
 * @param options The formatting options for the shape
 */

   public PPPolygon(String options) {
      this();
      setOptions(options);
   }

/**
 * Adds a vertex at (<code>x</code>, <code>y</code>) relative to the
 * polygon origin.
 *
 * @param x The x-coordinate of the vertex relative to the polygon origin
 * @param y The y-coordinate of the vertex relative to the polygon origin
 */

   public void addVertex(double x, double y) {
      if (path.isEmpty()) {
         path.moveTo(x, y);
      } else {
         path.lineTo(x, y);
      }
      Rectangle2D bb = path.getBounds();
      setBounds(bb.getX(), bb.getY(), bb.getWidth(), bb.getHeight());
   }

/**
 * Adds an edge to the polygon whose components are given by the displacements
 * <code>dx</code> and <code>dy</code> from the last vertex.
 *
 * @param dx The x displacement through which the edge moves
 * @param dy The y displacement through which the edge moves
 */

   public void addEdge(double dx, double dy) {
      Point2D pt = path.getLastPoint();
      addVertex(pt.getX() + dx, pt.getY() + dy);
   }

/**
 * Adds an edge to the polygon specified in polar coordinates.  The
 * length of the edge is given by <code>r</code>, and the edge extends in
 * direction <code>theta</code>, measured in degrees counterclockwise from
 * the +<i>x</i> axis.
 *
 * @param r The length of the edge
 * @param theta The angle at which the edge extends measured in degrees
 */

   public final void addPolarEdge(double r, double theta) {
      double radians = Math.toRadians(theta);
      addEdge(r * Math.cos(radians), -r * Math.sin(radians));
   }

/* Protected methods */

   @Override
   protected String presetGeometry() {
      return "ignored";
   }

   @Override
   protected void dumpShape(PPOutputStream os) {
      os.print("<p:sp>");
      os.print("<p:nvSpPr>");
      os.print("<p:cNvPr id='" + getShapeId() + "' " +
               "name='" + getName() + "'/>");
      os.print("<p:cNvSpPr/>");
      os.print("<p:nvPr/>");
      os.print("</p:nvSpPr>");
      os.print("<p:spPr bwMode='auto'>");
      Rectangle2D bb = path.getBounds();
      os.print(getFrameTag());
      os.print("<a:off " + os.getOffsetTag(bb.getX(), bb.getY()) + "/>");
      os.print("<a:ext cx='" + PPUtil.pointsToUnits(bb.getWidth()) +
               "' cy='" + PPUtil.pointsToUnits(bb.getHeight()) + "'/>");
      os.print("</a:xfrm>");
      os.adjustOffset(-bb.getX(), -bb.getY());
      os.print("<a:custGeom>");
      path.dumpPath(os);
      os.print("</a:custGeom>");
      os.adjustOffset(bb.getX(), bb.getY());
      Color fillColor = getFillColor();
      if (fillColor == null) {
         os.print("<a:noFill/>");
      } else if (!PPUtil.isBackgroundFill(fillColor)) {
         os.print("<a:solidFill>");
         os.print(PPUtil.getColorTag(fillColor));
         os.print("</a:solidFill>");
      }
      Color color = getLineColor();
      os.print("<a:ln w='" + PPUtil.pointsToUnits(getLineWeight()) + "'>");
      os.print("<a:solidFill>");
      if (color == null) {
         os.print("<a:schemeClr val='tx1'/>");
      } else {
         os.print(PPUtil.getColorTag(color));
      }
      os.print("</a:solidFill>");
      os.print("<a:prstDash val='" + getDashMode() + "'/>");
      os.print("<a:round/>");
      os.print("<a:headEnd" + getArrowTag(getStartArrow()) + "/>");
      os.print("<a:tailEnd" + getArrowTag(getEndArrow()) + "/>");
      os.print("</a:ln>");
      os.print("<a:effectLst/>");
      os.print("</p:spPr>");
      os.print("</p:sp>");
   }

/* Private instance variables */

   private PPPath path;

}
