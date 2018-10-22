/*
 * File: PPPythonSyntaxColorer.java
 * --------------------------------
 * This file implements the syntax coloring for Python.
 */

package edu.stanford.cs.pptx.code;

import java.awt.Color;
import java.awt.Graphics2D;

/**
 * This class implements the syntax coloring for the Python book.
 */

public class PPPythonSyntaxColorer extends PPSyntaxColorer {

   public PPPythonSyntaxColorer() {
      setCommentColor(COMMENT_COLOR);
      setKeywordColor(KEYWORD_COLOR);
      setStringColor(STRING_COLOR);
      setNumberColor(NUMBER_COLOR);
      setErrorColor(ERROR_COLOR);
      setCodeColor(CODE_COLOR);
      defineKeyword("and");
      defineKeyword("as");
      defineKeyword("assert");
      defineKeyword("break");
      defineKeyword("class");
      defineKeyword("continue");
      defineKeyword("def");
      defineKeyword("del");
      defineKeyword("elif");
      defineKeyword("else");
      defineKeyword("except");
      defineKeyword("False");
      defineKeyword("finally");
      defineKeyword("for");
      defineKeyword("from");
      defineKeyword("global");
      defineKeyword("if");
      defineKeyword("import");
      defineKeyword("in");
      defineKeyword("is");
      defineKeyword("lambda");
      defineKeyword("None");
      defineKeyword("nonlocal");
      defineKeyword("not");
      defineKeyword("or");
      defineKeyword("pass");
      defineKeyword("raise");
      defineKeyword("return");
      defineKeyword("True");
      defineKeyword("try");
      defineKeyword("while");
      defineKeyword("with");
      defineKeyword("yield");
   }

   @Override
   public void setCode(String[] code) {
      super.setCode(code);
      docStringTerminator = '\0';
   }

   @Override
   public String getNextToken(Graphics2D g) {
      char ch = getChar();
      if (ch == '\0') return "";
      if (ch == '\n') return "\n";
      if (docStringTerminator != '\0') {
         saveChar(ch);
         String token = readDocString();
         g.setColor(getStringColor());
         return token;
      }
      if (ch == '#') {
         g.setColor(getCommentColor());
         return "#" + readSlashSlashComment();
      }
      if (Character.isLetter(ch) || ch == '_') {
         saveChar(ch);
         String token = readIdentifier();
         Color color = getKeywordColor(token);
         if (color == null) color = getCodeColor();
         g.setColor(color);
         return token;
      } else if (Character.isDigit(ch)) {
         saveChar(ch);
         String token = readNumber();
         g.setColor(getNumberColor());
         return token;
      } else if (ch == '"' || ch == '\'') {
         char nch = getChar();
         if (nch == ch) {
            nch = getChar();
            if (nch == ch) {
               docStringTerminator = ch;
               g.setColor(getStringColor());
               return "" + ch + ch + ch + readDocString();
            } else {
               saveChar(nch);
               saveChar(ch);
            }
         } else {
            saveChar(nch);
         }
         String token = readString(ch);
         g.setColor(getStringColor());
         return token;
      } else {
         g.setColor(getCodeColor());
         return "" + ch;
      }
   }

   private String readDocString() {
      String str = "";
      while (true) {
         char ch = getChar();
         if (ch == '\n') saveChar(ch);
         if (ch == '\0' || ch == '\n') return str;
         if (ch == docStringTerminator) {
            char nch = getChar();
            if (nch == ch) {
               nch = getChar();
               if (nch == ch) {
                  docStringTerminator = '\0';
                  return str + ch + ch + ch;
               } else {
                  saveChar(nch);
                  saveChar(ch);
               }
            } else {
               saveChar(nch);
            }
         }
         str += ch;
      }
   }

/* Private instance variables */

   private char docStringTerminator;

/* Private constants */

   private static final Color COMMENT_COLOR = new Color(0x009999);
   private static final Color KEYWORD_COLOR = new Color(0xCC6600);
   private static final Color STRING_COLOR = new Color(0x006600);
   private static final Color NUMBER_COLOR = new Color(0x000000);
   private static final Color ERROR_COLOR = new Color(0xFF0000);
   private static final Color PROMPT_COLOR = new Color(0x660000);
   private static final Color CODE_COLOR = Color.BLACK;

}
