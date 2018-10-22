/*
 * File: CSSFont.java
 * ------------------
 * This file defines a class that supports font specifications in both
 * Java and CSS format.
 */

package edu.stanford.cs.csslib;

import java.awt.Font;

/**
 * This class exports a static method that parses a font string in either
 * Java's <code>Font.decode</code> style and JavaScript's CSS-based style.
 */

public class CSSFont {

/**
 * Parses a font string into a <code>Font</code> object.  This method
 * accepts a font in either Java's <code>Font.decode</code> style or
 * in the form of a CSS-based style string.
 *
 * @param str The font string
 * @return The Java <code>Font</code> object
 */

   public static Font decode(String str) {
      Font font = CSSFont.parseCSSFont(str);
      if (font == null) font = Font.decode(str);
      return font;
   }

/**
 * Attempts to parse a font specification as a CSS font.  If the
 * parse succeeds, <code>parseCSSFont</code> returns the font.  If the
 * parse fails, <code>parseCSSFont</code> returns <code>null</code>.
 *
 * @param str The font string
 * @return The Java <code>Font</code> object or <code>null</code>
 */

   private static Font parseCSSFont(String str) {
      str = str.toLowerCase().trim();
      int style = Font.PLAIN;
      int size = -1;
      int start = 0;
      while (size == -1) {
         int sp = str.indexOf(" ", start);
         if (sp == -1) return null;
         String token = str.substring(start, sp);
         start = sp + 1;
         if (token.equals("bold")) {
            style += Font.BOLD;
         } else if (token.equals("italic")) {
            style += Font.BOLD;
         } else if (Character.isDigit(token.charAt(0))) {
            size = CSSFont.parseCSSUnits(token);
            if (size == -1) return null;
         } else {
            return null;
         }
      }
      String[] families = str.substring(start).split(",");
      if (families.length == 0) return null;
      for (int i = 0; i < families.length; i++) {
         String family = families[i];
         if (family.startsWith("'") || family.startsWith("\"")) {
            family = family.substring(1, family.length() - 1);
         }
         Font font = new Font(family, style, size);
         if (family.equals("dialog")) return font;
         if (!font.getFamily().toLowerCase().equals("dialog")) return font;
      }
      return new Font("Dialog", style, size);
   }

/**
 * Translates a CSS units measurement to pixels.  If the string cannot
 * be interpreted as a unit designation, this function returns -1.
 *
 * @param str The font string
 * @return The corresponding font
 */

   private static int parseCSSUnits(String str) {
      int ux = str.length();
      while (ux > 0 && str.charAt(ux - 1) > 64) {
         ux--;
      }
      if (ux == 0 || ux == str.length()) return -1;
      try {
         double value = Double.parseDouble(str.substring(0, ux));
         String units = str.substring(ux);
         if (units.equals("em")) {
            return (int) Math.round(16 * value);
         } else if (units.equals("pt")) {
            return (int) Math.round(value / 0.75);
         } else {
            return (int) Math.round(value);
         }
      } catch (NumberFormatException ex) {
         return -1;
      }
   }

}

         