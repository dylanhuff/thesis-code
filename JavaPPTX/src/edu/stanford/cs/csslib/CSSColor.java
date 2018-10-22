/*
 * File: CSSColor.java
 * -------------------
 * This class exports static methods for converting CSS color names
 * to Java colors.
 */

package edu.stanford.cs.csslib;

import java.awt.Color;
import java.util.HashMap;

/**
 * This class exports static methods for converting CSS color names
 * to Java colors.
 */

public class CSSColor {

/**
 * Returns the standard CSS color corresponding to the specified name.
 *
 * @param name The name of the color (case-insensitive)
 * @return The corresponding Java color
 */

   public static Color decode(String name) {
      if (name.startsWith("#")) {
         return decodeHexColor(name.substring(1));
      } else if (name.startsWith("0x")) {
         return decodeHexColor(name.substring(2));
      } else {
         if (cssColors == null) initCSSColors();
         Color color = cssColors.get(name.toLowerCase());
         if (color == null) {
            throw new RuntimeException("No color named " + name);
         }
         return color;
      }
   }

/**
 * Encodes the Java color as a string.  The string has the form
 * <code>"#rrggbb"</code> for opaque colors and <code>"#aarrggbb"</code>
 * for translucent colors.  The component colors are specified as two
 * hexadecimal digits in uppercase.
 *
 * @param color The Java color
 * @return The corresponding color string
 */

   public static String encode(Color color) {
      int argb = color.getRGB();
      int aa = (argb >> 24) & 0xFF;
      int digits = 8;
      if (aa == 0xFF) {
         argb = argb & 0xFFFFFF;
         digits = 6;
      }
      String str = Integer.toHexString(argb).toUpperCase();
      while (str.length() < digits) {
         str = "0" + str;
      }
      return "#" + str;
   }

/*
 * Creates a color from a string allowing for transparency.  A string
 * containing more than six hex digits is treated as included transparency;
 * strings of six characters or less are assumed to be opaque.
 */

   private static Color decodeHexColor(String str) {
      return new Color(Integer.parseInt(str, 16), str.length() > 6);
   }

/*
 * Initializes the CSS color table.
 */

   private static void initCSSColors() {
      cssColors = new HashMap<String,Color>();
      cssColors.put("aliceblue", new Color(0xF0F8FF));
      cssColors.put("antiquewhite", new Color(0xFAEBD7));
      cssColors.put("aqua", new Color(0x00FFFF));
      cssColors.put("aquamarine", new Color(0x7FFFD4));
      cssColors.put("azure", new Color(0xF0FFFF));
      cssColors.put("beige", new Color(0xF5F5DC));
      cssColors.put("bisque", new Color(0xFFE4C4));
      cssColors.put("black", new Color(0x000000));
      cssColors.put("blanchedalmond", new Color(0xFFEBCD));
      cssColors.put("blue", new Color(0x0000FF));
      cssColors.put("blueviolet", new Color(0x8A2BE2));
      cssColors.put("brown", new Color(0xA52A2A));
      cssColors.put("burlywood", new Color(0xDEB887));
      cssColors.put("cadetblue", new Color(0x5F9EA0));
      cssColors.put("chartreuse", new Color(0x7FFF00));
      cssColors.put("chocolate", new Color(0xD2691E));
      cssColors.put("coral", new Color(0xFF7F50));
      cssColors.put("cornflowerblue", new Color(0x6495ED));
      cssColors.put("cornsilk", new Color(0xFFF8DC));
      cssColors.put("crimson", new Color(0xDC143C));
      cssColors.put("cyan", new Color(0x00FFFF));
      cssColors.put("darkblue", new Color(0x00008B));
      cssColors.put("darkcyan", new Color(0x008B8B));
      cssColors.put("darkgoldenrod", new Color(0xB8860B));
      cssColors.put("darkgray", new Color(0xA9A9A9));
      cssColors.put("darkgrey", new Color(0xA9A9A9));
      cssColors.put("darkgreen", new Color(0x006400));
      cssColors.put("darkkhaki", new Color(0xBDB76B));
      cssColors.put("darkmagenta", new Color(0x8B008B));
      cssColors.put("darkolivegreen", new Color(0x556B2F));
      cssColors.put("darkorange", new Color(0xFF8C00));
      cssColors.put("darkorchid", new Color(0x9932CC));
      cssColors.put("darkred", new Color(0x8B0000));
      cssColors.put("darksalmon", new Color(0xE9967A));
      cssColors.put("darkseagreen", new Color(0x8FBC8F));
      cssColors.put("darkslateblue", new Color(0x483D8B));
      cssColors.put("darkslategray", new Color(0x2F4F4F));
      cssColors.put("darkslategrey", new Color(0x2F4F4F));
      cssColors.put("darkturquoise", new Color(0x00CED1));
      cssColors.put("darkviolet", new Color(0x9400D3));
      cssColors.put("deeppink", new Color(0xFF1493));
      cssColors.put("deepskyblue", new Color(0x00BFFF));
      cssColors.put("dimgray", new Color(0x696969));
      cssColors.put("dimgrey", new Color(0x696969));
      cssColors.put("dodgerblue", new Color(0x1E90FF));
      cssColors.put("firebrick", new Color(0xB22222));
      cssColors.put("floralwhite", new Color(0xFFFAF0));
      cssColors.put("forestgreen", new Color(0x228B22));
      cssColors.put("fuchsia", new Color(0xFF00FF));
      cssColors.put("gainsboro", new Color(0xDCDCDC));
      cssColors.put("ghostwhite", new Color(0xF8F8FF));
      cssColors.put("gold", new Color(0xFFD700));
      cssColors.put("goldenrod", new Color(0xDAA520));
      cssColors.put("gray", new Color(0x808080));
      cssColors.put("grey", new Color(0x808080));
      cssColors.put("green", new Color(0x008000));
      cssColors.put("greenyellow", new Color(0xADFF2F));
      cssColors.put("honeydew", new Color(0xF0FFF0));
      cssColors.put("hotpink", new Color(0xFF69B4));
      cssColors.put("indianred", new Color(0xCD5C5C));
      cssColors.put("indigo", new Color(0x4B0082));
      cssColors.put("ivory", new Color(0xFFFFF0));
      cssColors.put("khaki", new Color(0xF0E68C));
      cssColors.put("lavender", new Color(0xE6E6FA));
      cssColors.put("lavenderblush", new Color(0xFFF0F5));
      cssColors.put("lawngreen", new Color(0x7CFC00));
      cssColors.put("lemonchiffon", new Color(0xFFFACD));
      cssColors.put("lightblue", new Color(0xADD8E6));
      cssColors.put("lightcoral", new Color(0xF08080));
      cssColors.put("lightcyan", new Color(0xE0FFFF));
      cssColors.put("lightgoldenrodyellow", new Color(0xFAFAD2));
      cssColors.put("lightgray", new Color(0xD3D3D3));
      cssColors.put("lightgrey", new Color(0xD3D3D3));
      cssColors.put("lightgreen", new Color(0x90EE90));
      cssColors.put("lightpink", new Color(0xFFB6C1));
      cssColors.put("lightsalmon", new Color(0xFFA07A));
      cssColors.put("lightseagreen", new Color(0x20B2AA));
      cssColors.put("lightskyblue", new Color(0x87CEFA));
      cssColors.put("lightslategray", new Color(0x778899));
      cssColors.put("lightslategrey", new Color(0x778899));
      cssColors.put("lightsteelblue", new Color(0xB0C4DE));
      cssColors.put("lightyellow", new Color(0xFFFFE0));
      cssColors.put("lime", new Color(0x00FF00));
      cssColors.put("limegreen", new Color(0x32CD32));
      cssColors.put("linen", new Color(0xFAF0E6));
      cssColors.put("magenta", new Color(0xFF00FF));
      cssColors.put("maroon", new Color(0x800000));
      cssColors.put("mediumaquamarine", new Color(0x66CDAA));
      cssColors.put("mediumblue", new Color(0x0000CD));
      cssColors.put("mediumorchid", new Color(0xBA55D3));
      cssColors.put("mediumpurple", new Color(0x9370DB));
      cssColors.put("mediumseagreen", new Color(0x3CB371));
      cssColors.put("mediumslateblue", new Color(0x7B68EE));
      cssColors.put("mediumspringgreen", new Color(0x00FA9A));
      cssColors.put("mediumturquoise", new Color(0x48D1CC));
      cssColors.put("mediumvioletred", new Color(0xC71585));
      cssColors.put("midnightblue", new Color(0x191970));
      cssColors.put("mintcream", new Color(0xF5FFFA));
      cssColors.put("mistyrose", new Color(0xFFE4E1));
      cssColors.put("moccasin", new Color(0xFFE4B5));
      cssColors.put("navajowhite", new Color(0xFFDEAD));
      cssColors.put("navy", new Color(0x000080));
      cssColors.put("oldlace", new Color(0xFDF5E6));
      cssColors.put("olive", new Color(0x808000));
      cssColors.put("olivedrab", new Color(0x6B8E23));
      cssColors.put("orange", new Color(0xFFA500));
      cssColors.put("orangered", new Color(0xFF4500));
      cssColors.put("orchid", new Color(0xDA70D6));
      cssColors.put("palegoldenrod", new Color(0xEEE8AA));
      cssColors.put("palegreen", new Color(0x98FB98));
      cssColors.put("paleturquoise", new Color(0xAFEEEE));
      cssColors.put("palevioletred", new Color(0xDB7093));
      cssColors.put("papayawhip", new Color(0xFFEFD5));
      cssColors.put("peachpuff", new Color(0xFFDAB9));
      cssColors.put("peru", new Color(0xCD853F));
      cssColors.put("pink", new Color(0xFFC0CB));
      cssColors.put("plum", new Color(0xDDA0DD));
      cssColors.put("powderblue", new Color(0xB0E0E6));
      cssColors.put("purple", new Color(0x800080));
      cssColors.put("rebeccapurple", new Color(0x663399));
      cssColors.put("red", new Color(0xFF0000));
      cssColors.put("rosybrown", new Color(0xBC8F8F));
      cssColors.put("royalblue", new Color(0x4169E1));
      cssColors.put("saddlebrown", new Color(0x8B4513));
      cssColors.put("salmon", new Color(0xFA8072));
      cssColors.put("sandybrown", new Color(0xF4A460));
      cssColors.put("seagreen", new Color(0x2E8B57));
      cssColors.put("seashell", new Color(0xFFF5EE));
      cssColors.put("sienna", new Color(0xA0522D));
      cssColors.put("silver", new Color(0xC0C0C0));
      cssColors.put("skyblue", new Color(0x87CEEB));
      cssColors.put("slateblue", new Color(0x6A5ACD));
      cssColors.put("slategray", new Color(0x708090));
      cssColors.put("slategrey", new Color(0x708090));
      cssColors.put("snow", new Color(0xFFFAFA));
      cssColors.put("springgreen", new Color(0x00FF7F));
      cssColors.put("steelblue", new Color(0x4682B4));
      cssColors.put("tan", new Color(0xD2B48C));
      cssColors.put("teal", new Color(0x008080));
      cssColors.put("thistle", new Color(0xD8BFD8));
      cssColors.put("tomato", new Color(0xFF6347));
      cssColors.put("turquoise", new Color(0x40E0D0));
      cssColors.put("violet", new Color(0xEE82EE));
      cssColors.put("wheat", new Color(0xF5DEB3));
      cssColors.put("white", new Color(0xFFFFFF));
      cssColors.put("whitesmoke", new Color(0xF5F5F5));
      cssColors.put("yellow", new Color(0xFFFF00));
      cssColors.put("yellowgreen", new Color(0x9ACD32));

      cssColors.put("color.black", Color.BLACK);
      cssColors.put("color.blue", Color.BLUE);
      cssColors.put("color.cyan", Color.CYAN);
      cssColors.put("color.dark_gray", Color.DARK_GRAY);
      cssColors.put("color.darkgray", Color.DARK_GRAY);
      cssColors.put("color.gray", Color.GRAY);
      cssColors.put("color.green", Color.GREEN);
      cssColors.put("color.light_gray", Color.LIGHT_GRAY);
      cssColors.put("color.lightgray", Color.LIGHT_GRAY);
      cssColors.put("color.magenta", Color.MAGENTA);
      cssColors.put("color.orange", Color.ORANGE);
      cssColors.put("color.pink", Color.PINK);
      cssColors.put("color.red", Color.RED);
      cssColors.put("color.white", Color.WHITE);
      cssColors.put("color.yellow", Color.YELLOW);
   }

/* Private static variables */

   private static HashMap<String,Color> cssColors = null;

}
