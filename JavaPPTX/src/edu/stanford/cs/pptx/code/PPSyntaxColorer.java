/*
 * File: PPSyntaxColorer.java
 * --------------------------
 * This file implements the base class of a facility to support syntax
 * coloring in the PPCodeImage class.
 */

package edu.stanford.cs.pptx.code;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.HashMap;

/**
 * This class implements a simple syntax-coloring facility.  By default, the
 * only coloring is that Java-style comments appear in blue and all other code
 * appears in black.  Clients, however, can substitute more sophisticated
 * coloring models by overriding the <code>getNextToken</code> method.
 */

public class PPSyntaxColorer {

/**
 * Creates a new syntax colorer.
 */

   public PPSyntaxColorer() {
      keywordTable = new HashMap<String,Color>();
      setCommentColor(Color.BLUE);
      setKeywordColor(Color.BLACK);
      setStringColor(Color.BLACK);
      setNumberColor(Color.BLACK);
      setErrorColor(Color.BLACK);
      setCodeColor(Color.BLACK);
      savedChars = "";
   }

/**
 * Sets the code block for the syntax colorer.
 *
 * @param code An array of code lines
 */

   public void setCode(String[] code) {
      this.code = code;
      nLines = code.length;
      lx = 0;
      cx = 0;
      inComment = false;
   }

/**
 * Returns the next token from the code stream and sets the color of the
 * graphics context appropriately.  This method returns the token "\n" at
 * the end of a line and the token "" at the end of the input.  Clients
 * override this method to change the syntax-coloring algorithm.
 *
 * Client versions of this method should build up a token by calling
 * <code>getChar</code>, where the only requirement for a token is that
 * it be rendered in a single color.  Before returning the token, the
 * implementation of <code>getNextToken</code> must also set the correct
 * color in the <code>Graphics2D</code> context.
 *
 * @param g The <code>Graphics2D</code> object used to set the color
 * @return The next token
 */

   public String getNextToken(Graphics2D g) {
      char ch = getChar();
      if (ch == '\0') return "";
      if (ch == '\n') return "\n";
      if (inComment) {
         String token = readSlashStarComment();
         g.setColor(getCommentColor());
         return token;
      }
      if (ch == '/') {
         char nch = getChar();
         if (nch == '/') {
            g.setColor(getCommentColor());
            return "//" + readSlashSlashComment();
         } else if (nch == '*') {
            inComment = true;
            g.setColor(getCommentColor());
            return "/*" + readSlashStarComment();
         }
         saveChar(nch);
      }
      if (Character.isLetter(ch) || ch == '_' || ch == '$') {
         saveChar(ch);
         String token = readIdentifier();
         Color color = keywordTable.get(token);
         if (color == null) color = codeColor;
         g.setColor(color);
         return token;
      } else if (Character.isDigit(ch)) {
         saveChar(ch);
         String token = readNumber();
         g.setColor(getNumberColor());
         return token;
      } else if (ch == '"' || ch == '\'') {
         String token = readString(ch);
         g.setColor(getStringColor());
         return token;
      } else {
         g.setColor(getCodeColor());
         return "" + ch;
      }
   }

/**
 * Read a comment up to a closing star-slash combination.  The read
 * terminates at the end of a line but leaves the inComment flag set.
 */

   public String readSlashStarComment() {
      String token = "";
      while (true) {
         char ch = getChar();
         if (ch == '\0' || ch == '\n') return token;
         if (ch == '*') {
            char nch = getChar();
            if (nch == '/') {
               inComment = false;
               return token + ch + nch;
            }
            saveChar(nch);
         }
         token += ch;
      }
   }

/**
 * Read a comment up to the end of a line.
 */

   public String readSlashSlashComment() {
      String token = "";
      while (true) {
         char ch = getChar();
         if (ch == '\0' || ch == '\n') {
            if (ch == '\n') saveChar(ch);
            return token;
         }
         token += ch;
      }
   }

/**
 * Read a standard identifier token.
 */

   public String readIdentifier() {
      String token = "";
      while (true) {
         char ch = getChar();
         if (!Character.isLetterOrDigit(ch) && ch != '_' && ch != '$') {
            saveChar(ch);
            return token;
         }
         token += ch;
      }
   }

/**
 * Read a number.
 */

// Fix for hex numbers

   public String readNumber() {
      String token = "";
      while (true) {
         char ch = getChar();
         if (!Character.isDigit(ch) && ch != '.' && ch != 'E') {
            saveChar(ch);
            return token;
         }
         token += ch;
      }
   }

/**
 * Read a string up to the terminator.
 */

   public String readString(char term) {
      String token = "" + term;
      while (true) {
         char ch = getChar();
         if (ch == term && !token.endsWith("\\")) {
            return token + ch;
         } else if (ch == -1 || ch == '\n') {
            return token;
         }
         token += ch;
      }
   }

/**
 * Returns the next character from the code stream.  The end of the input
 * is signified by the character '\0', which is not legal in a file.
 *
 * @return The next character from the code stream
 */

   public char getChar() {
      if (savedChars.length() > 0) {
         char ch = savedChars.charAt(0);
         savedChars = savedChars.substring(1);
         return ch;
      }
      if (lx == nLines) return '\0';
      if (cx == code[lx].length()) {
         lx++;
         cx = 0;
         return '\n';
      }
      return code[lx].charAt(cx++);
   }

/**
 * Saves the character in the code stream so that it is read again on
 * the next call to <code>getChar</code>.
 *
 * @param ch The character to be saved
 */

   public void saveChar(char ch) {
      savedChars = ch + savedChars;
   }

/**
 * Sets the color used for comments.
 *
 * @param color The color used for comments
 */

   public void setCommentColor(Color color) {
      commentColor = color;
   }

/**
 * Returns the color used for comments.
 *
 * @return The color used for comments
 */

   public Color getCommentColor() {
      return commentColor;
   }

/**
 * Sets the color used for keywords.
 *
 * @param color The color used for keywords
 */

   public void setKeywordColor(Color color) {
      keywordColor = color;
   }

/**
 * Returns the color used for keywords.
 *
 * @return The color used for keywords
 */

   public Color getKeywordColor() {
      return keywordColor;
   }

/**
 * Sets the color used for strings.
 *
 * @param color The color used for strings
 */

   public void setStringColor(Color color) {
      stringColor = color;
   }

/**
 * Returns the color used for strings.
 *
 * @return The color used for strings
 */

   public Color getStringColor() {
      return stringColor;
   }

/**
 * Sets the color used for numbers.
 *
 * @param color The color used for numbers
 */

   public void setNumberColor(Color color) {
      numberColor = color;
   }

/**
 * Returns the color used for numbers.
 *
 * @return The color used for numbers
 */

   public Color getNumberColor() {
      return numberColor;
   }

/**
 * Sets the color used for errors.
 *
 * @param color The color used for errors
 */

   public void setErrorColor(Color color) {
      errorColor = color;
   }

/**
 * Returns the color used for errors.
 *
 * @return The color used for errors
 */

   public Color getErrorColor() {
      return errorColor;
   }

/**
 * Sets the color used for codes.
 *
 * @param color The color used for codes
 */

   public void setCodeColor(Color color) {
      codeColor = color;
   }

/**
 * Returns the color used for codes.
 *
 * @return The color used for codes
 */

   public Color getCodeColor() {
      return codeColor;
   }

/**
 * Adds a new keyword to the keyword table, which is rendered in the
 * keyword color.
 *
 * @param keyword The new keyword
 */

   public void defineKeyword(String keyword) {
      defineKeyword(keyword, getKeywordColor());
   }

/**
 * Adds a new keyword to the keyword table, which is rendered in the
 * specified color.
 *
 * @param keyword The new keyword
 * @param color The color to use for that keyword
 */

   public void defineKeyword(String keyword, Color color) {
      keywordTable.put(keyword, color);
   }

/**
 * Tests whether the specified string is defined as a keyword.
 *
 * @param str The string being tested
 * @return The value <code>true</code> if the string is a keyword
 */

   public boolean isKeyword(String str) {
      return keywordTable.containsKey(str);
   }

/**
 * Returns the color associated with the keyword.
 *
 * @param keyword The keyword string
 * @return The color used for that keyword
 */

   public Color getKeywordColor(String keyword) {
      return keywordTable.get(keyword);
   }

/* Private instance variables */

   private PPCodeImage cimage;
   private String[] code;
   private int nLines;
   private int lx;
   private int cx;
   private String savedChars;
   private boolean inComment;

   private Color commentColor;
   private Color keywordColor;
   private Color stringColor;
   private Color numberColor;
   private Color errorColor;
   private Color codeColor;

   private HashMap<String,Color> keywordTable;

}
