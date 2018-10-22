/*
 * File: ChangeFontColorEffect.java
 * --------------------------------
 * This class implements the ChangeFontColor effect.
 */

/**
 * This emphasis effect change the font color of the shape gradually over
 * the duration of the effect.  The legal options are:
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
 * <tr><td style="padding-left:2em; width:10em;">
 *     <code>/color:</code><i>color</i></td>
 *     <td>Specifies the target color</td></tr>
 * </table>
 */

package edu.stanford.cs.pptx.effect;

import edu.stanford.cs.pptx.util.PPOutputStream;
import edu.stanford.cs.pptx.util.PPUtil;

public class ChangeFontColorEffect extends AnimationEffect {

   public ChangeFontColorEffect() {
      super("ChangeFontColor");
   }

   public void preOptionHook() {
      setDuration("0.001");
   }

   public void colorKey(String value) {
      colorName = value;
   }

   @Override
   public String getPresetTag() {
      return "presetID='3' presetClass='emph' presetSubtype='2'";
   }

   @Override
   public void dumpBehavior(PPOutputStream os, String delayTag) {
      os.print("<p:animClr clrSpc='rgb'>");
      os.print("<p:cBhvr override='childStyle'>");
      os.print("<p:cTn id='" + os.getNextSequenceId() + "' " +
               getDurationTag() + " fill='hold'>");
      os.print("<p:stCondLst>");
      os.print("<p:cond " + delayTag + "/>");
      os.print("</p:stCondLst>");
      os.print("</p:cTn>");
      os.print("<p:tgtEl>");
      os.print("<p:spTgt spid='" + getShape().getShapeId() + "'/>");
      os.print("</p:tgtEl>");
      os.print("<p:attrNameLst>");
      os.print("<p:attrName>style.color</p:attrName>");
      os.print("</p:attrNameLst>");
      os.print("</p:cBhvr>");
      os.print("<p:to>" + PPUtil.getColorTag(colorName) + "</p:to>");
      os.print("</p:animClr>");
   }

/* Private instance variables */

   private String colorName;

}
