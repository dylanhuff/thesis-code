/*
 * File: FadeOutEffect.java
 * ------------------------
 * This class implements the fade-out effect.
 */

package edu.stanford.cs.pptx.effect;

import edu.stanford.cs.pptx.util.PPOutputStream;

/**
 * This exit effect causes the shape to disappear gradually from the window.
 * The legal options are:
 *
 * <table border=0>
 * <tr><td style="padding-left:2em; width:10em;">
 *     <code>/onClick</code></td>
 *     <td>Effect takes place after a mouse click</td></tr>
 * <tr><td style="padding-left:2em; width:10em;">
 *     <code>/afterPrev</code></td>
 *     <td>Effect takes place after the previous one</td></tr>
 * <tr><td style="padding-left:2em; width:10em;">
 *     <code>/withPrev</code></td>
 *     <td>Effect takes place with the previous one</td></tr>
 * <tr><td style="padding-left:2em; width:10em;">
 *     <code>/delay:</code><i>time</i></td>
 *     <td>Effect is delayed by <i>time</i> seconds</td></tr>
 * <tr><td style="padding-left:2em; width:10em;">
 *     <code>/duration:</code><i>time</i></td>
 *     <td>Effect lasts <i>time</i> seconds</td></tr>
 * </table>
 */

public class FadeOutEffect extends AnimationEffect {

   public FadeOutEffect() {
      super("FadeOut");
   }

   @Override
   public String getPresetTag() {
      return "presetID='10' presetClass='exit' presetSubtype='10'";
   }

   @Override
   public void dumpBehavior(PPOutputStream os, String delayTag) {
      os.print("<p:animEffect transition='out' filter='fade'>");
      os.print("<p:cBhvr>");
      os.print("<p:cTn id='" + os.getNextSequenceId() + "' " +
               getDurationTag() + ">");
      os.print("<p:stCondLst>");
      os.print("<p:cond " + delayTag + "/>");
      os.print("</p:stCondLst>");
      os.print("</p:cTn>");
      os.print("<p:tgtEl>");
      os.print("<p:spTgt spid='" + getShape().getShapeId() + "'/>");
      os.print("</p:tgtEl>");
      os.print("</p:cBhvr>");
      os.print("</p:animEffect>");
      os.print("<p:set>");
      os.print("<p:cBhvr>");
      os.print("<p:cTn id='" + os.getNextSequenceId() + "' " +
               "dur='1' fill='hold'>");
      os.print("<p:stCondLst>");
      os.print("<p:cond delay='" + Math.round(1000 * getDuration() - 1) +
               "'/>");
      os.print("</p:stCondLst>");
      os.print("</p:cTn>");
      os.print("<p:tgtEl>");
      os.print("<p:spTgt spid='" + getShape().getShapeId() + "'/>");
      os.print("</p:tgtEl>");
      os.print("<p:attrNameLst>");
      os.print("<p:attrName>style.visibility</p:attrName>");
      os.print("</p:attrNameLst>");
      os.print("</p:cBhvr>");
      os.print("<p:to><p:strVal val='hidden'/></p:to>");
      os.print("</p:set>");
   }

   public void preOptionHook() {
      setDuration("medium");
      setDirection("across");
   }

   public void acrossKey(String value) {
      setDirection("across");
   }

   public void downKey(String value) {
      setDirection("down");
   }

}
