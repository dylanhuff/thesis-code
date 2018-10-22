/*
 * File: PPSlide.java
 * ------------------
 * This class encapsulates a single PowerPoint slide.
 */

package edu.stanford.cs.pptx;

import edu.stanford.cs.pptx.effect.AnimationEffect;
import edu.stanford.cs.pptx.effect.SlideTransition;
import edu.stanford.cs.pptx.util.PPOutputStream;
import edu.stanford.cs.pptx.util.PPUtil;
import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;

/**
 * This class corresponds to a single PowerPoint slide.  Each slide consists
 * primarily of a list of shapes and an animation timeline.
 */

public class PPSlide {

/**
 * Creates a new empty slide. This form of the constructor is included
 * primarily for backward compatibility. The preferred form of the
 * constructor takes the slide show and automatically adds the slide.
 */

   public PPSlide() {
      contents = new ArrayList<PPShape>();
      animationList = new ArrayList<AnimationEffect>();
      updateNeeded = true;
      transition = "";
      id = nextId++;
   }

/**
 * Creates an empty slide and adds it to the end of the slide show.
 *
 * @param ppt The slide show to which this slide belongs
 */

   public PPSlide(PPShow ppt) {
      this();
      ppt.add(this);
   }

/**
 * Adds a title to this slide.
 *
 * @param title The title for the slide
 * @return The title shape
 */

   public PPShape addTitle(String title) {
      this.title = title;
      titleBox = new PPTitle(title);
      titleBox.setFont(TITLE_FONT);
      titleBox.setFontColor(TITLE_COLOR);
      titleBox.setHorizontalAlignment("Center");
      titleBox.setVerticalAlignment("Middle");
      titleBox.setBounds(0, 0, getWidth(), TITLE_HEIGHT);
      add(titleBox);
      return titleBox;
   }

/**
 * Returns the width of this slide in pixels.
 *
 * @return The width of this slide
 */

   public double getWidth() {
      return (show == null) ? PPShow.WIDTH : show.getWidth();
   }

/**
 * Returns the height of this slide in pixels.
 *
 * @return The height of this slide
 */

   public double getHeight() {
      return (show == null) ? PPShow.HEIGHT : show.getHeight();
   }

/**
 * Returns the title of this slide.
 *
 * @return The title of this slide
 */

   public String getTitle() {
      return title;
   }

/**
 * Returns the text shape containing the title.
 *
 * @return The text shape containing the title
 */

   public PPTextShape getTitleShape() {
      return titleBox;
   }

/**
 * Returns an array of the shapes contained in this slide, arranged from
 * back to front in terms of the <i>z</i>-axis ordering.
 *
 * @return An array of the shapes contained in this slide
 */

   public PPShape[] getShapes() {
      return contents.toArray(new PPShape[0]);
   }

/**
 * Adds the specified shape to the slide at the top of the <i>z</i>-axis
 * ordering.
 *
 * @param shape The shape to be added
 */

   public void add(PPShape shape) {
      shape.setSlide(this);
      contents.add(shape);
   }

/**
 * Adds the specified shape to this slide and sets its location to the
 * point (<code>x</code>, <code>y</code>).
 *
 * @param shape The shape to add
 * @param x The <i>x</i>-coordinate of the shape
 * @param y The <i>y</i>-coordinate of the shape
 */

   public void add(PPShape shape, double x, double y) {
      shape.setInitialLocation(x, y);
      add(shape);
   }

/**
 * Sends the specified shape to the front of the z-ordering.
 *
 * @param shape The shape to be moved to the front
 */

   public void sendToFront(PPShape shape) {
      contents.remove(shape);
      contents.add(shape);
   }

/**
 * Sends the specified shape to the back of the z-ordering.
 *
 * @param shape The shape to be moved to the back
 */

   public void sendToBack(PPShape shape) {
      contents.remove(shape);
      contents.add(0, shape);
   }

/**
 * Sets the transition string for this slide.
 *
 * @param transition The transition string
 */

   public void setTransition(String transition) {
      this.transition = transition;
   }

/**
 * Sets the background color for this slide. If this value is
 * <code>null</code>, the slide inherits the background color for the
 * slide show.
 *
 * @param color The background color for the slide show
 */

   public void setBackground(Color color) {
      bgColor = color;
   }

/**
 * Returns the background color used in this slide. If this value is
 * <code>null</code>, the slide inherits the background color for the
 * slide show.
 *
 * @return The background color
 */

   public Color getBackground() {
      return bgColor;
   }

/**
 * Returns a printable string representation of this slide.
 *
 * @return A printable string representation of this slide
 */

   public String toString() {
      String str = "PPSlide: ";
      String title = getTitle();
      if (title != null) str += '"' + title + '"';
      str += " (" + contents.size() + " objects)";
      return str;
   }

/**
 * Gets the slide show in which this slide appears.
 *
 * @return The slide show in which this slide appears
 */

   public PPShow getShow() {
      return show;
   }

/* Protected methods */

   protected int getSlideId() {
      return id;
   }

   protected void dumpSlide(PPOutputStream os) {
      os.resetIdSequence();
      os.println("<?xml version='1.0' encoding='UTF-8' standalone='yes'?>");
      os.print("<p:sld ");
      os.print("xmlns:a='http://schemas.openxmlformats.org/" +
               "drawingml/2006/main' ");
      os.print("xmlns:r='http://schemas.openxmlformats.org/" +
               "officeDocument/2006/relationships' ");
      os.print("xmlns:mc='http://schemas.openxmlformats.org/" +
               "markup-compatibility/2006' ");
      os.print("xmlns:mv='urn:schemas-microsoft-com:mac:vml' ");
      os.print("mc:Ignorable='mv' mc:PreserveAttributes='mv:*' ");
      os.print("xmlns:p='http://schemas.openxmlformats.org/" +
               "presentationml/2006/main'>");
      os.print("<p:cSld>");
      if (bgColor != null) {
         os.print("<p:bg>");
         os.print("<p:bgPr>");
         os.print("<a:solidFill>");
         os.print(PPUtil.getColorTag(bgColor));
         os.print("</a:solidFill>");
         os.print("<a:effectLst/>");
         os.print("</p:bgPr>");
         os.print("</p:bg>");
      }
      os.print("<p:spTree>");
      os.print("<p:nvGrpSpPr>");
      os.print("<p:cNvPr id='1' name='title'/>");
      os.print("<p:cNvGrpSpPr/>");
      os.print("<p:nvPr/>");
      os.print("</p:nvGrpSpPr>");
      os.print("<p:grpSpPr>");
      os.print("<a:xfrm>");
      os.print("<a:off x='0' y='0'/>");
      os.print("<a:ext cx='0' cy='0'/>");
      os.print("<a:chOff x='0' y='0'/>");
      os.print("<a:chExt cx='0' cy='0'/>");
      os.print("</a:xfrm>");
      os.print("</p:grpSpPr>");
      for (PPShape shape : contents) {
         shape.dumpShape(os);
      }
      os.print("</p:spTree>");
      os.print("</p:cSld>");
      os.print("<p:clrMapOvr><a:masterClrMapping/></p:clrMapOvr>");
      if (transition != null) {
         SlideTransition.createTransition(transition).dumpTransition(os);
      }
      dumpTiming(os);
      os.println("</p:sld>");
   }

   protected void dumpSlideRels(PPOutputStream os) {
      for (PPShape shape : contents) {
         shape.dumpShapeRels(os);
      }
   }

   protected ArrayList<AnimationEffect> getAnimationList() {
      return animationList;
   }

   protected void updateAnimations() {
      AnimationEffect.updateAnimations(this, animationList);
      updateNeeded = false;
   }

   protected void addAnimation(AnimationEffect animation) {
      animationList.add(animation);
      updateNeeded = true;
   }

   protected void preSaveHook() {
      if (updateNeeded) updateAnimations();
   }

   protected void setShow(PPShow ppt) {
      show = ppt;
   }

/* Private methods */

   private void dumpTiming(PPOutputStream os) {
      os.resetIdSequence();
      os.print("<p:timing>");
      os.print("<p:tnLst>");
      os.print("<p:par>");
      os.print("<p:cTn id='" + os.getNextSequenceId() + "' " +
               "dur='indefinite' restart='never' nodeType='tmRoot'>");
      if (!animationList.isEmpty()) {
         os.print("<p:childTnLst>");
         os.print("<p:seq concurrent='1' nextAc='seek'>");
         os.print("<p:cTn id='" + os.getNextSequenceId() + "' " +
                  "dur='indefinite' nodeType='mainSeq'>");
         os.print("<p:childTnLst>");
         AnimationEffect.dumpAnimationList(os, animationList);
         os.print("</p:childTnLst>");
         os.print("</p:cTn>");
         os.print("<p:prevCondLst>");
         os.print("<p:cond evt='onPrev' delay='0'>");
         os.print("<p:tgtEl>");
         os.print("<p:sldTgt/>");
         os.print("</p:tgtEl>");
         os.print("</p:cond>");
         os.print("</p:prevCondLst>");
         os.print("<p:nextCondLst>");
         os.print("<p:cond evt='onNext' delay='0'>");
         os.print("<p:tgtEl>");
         os.print("<p:sldTgt/>");
         os.print("</p:tgtEl>");
         os.print("</p:cond>");
         os.print("</p:nextCondLst>");
         os.print("</p:seq>");
         os.print("</p:childTnLst>");
      }
      os.print("</p:cTn>");
      os.print("</p:par>");
      os.print("</p:tnLst>");
      AnimationEffect.dumpBuildList(os, animationList);
      os.print("</p:timing>");
   }

/* Private constants */

   private static final Font TITLE_FONT = Font.decode("Times New Roman-40");
   private static final Color TITLE_COLOR = Color.RED;
   private static final double TITLE_HEIGHT = 90;

/* Private instance variables */

   private ArrayList<AnimationEffect> animationList;
   private ArrayList<PPShape> contents;
   private Color bgColor;
   private PPShow show;
   private PPTextShape titleBox;
   private String title;
   private String transition;
   private boolean updateNeeded;
   private int id;

/* Static variables */

   private static int nextId = 1;

}
