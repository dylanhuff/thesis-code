/*
 * File: PPJSSyntaxColorer.java
 * ----------------------------
 * This file implements the syntax coloring for the JavaScript book.
 */

package edu.stanford.cs.pptx.code;

import java.awt.Color;

/**
 * This class implements the syntax coloring for the JavaScript book.
 */

public class PPJSSyntaxColorer extends PPSyntaxColorer {

   public PPJSSyntaxColorer() {
      setCommentColor(COMMENT_COLOR);
      setKeywordColor(KEYWORD_COLOR);
      setStringColor(STRING_COLOR);
      setNumberColor(NUMBER_COLOR);
      setErrorColor(ERROR_COLOR);
      setCodeColor(CODE_COLOR);
      defineKeyword("abstract");
      defineKeyword("arguments");
      defineKeyword("await");
      defineKeyword("boolean");
      defineKeyword("break");
      defineKeyword("byte");
      defineKeyword("case");
      defineKeyword("catch");
      defineKeyword("char");
      defineKeyword("class");
      defineKeyword("const");
      defineKeyword("continue");
      defineKeyword("debugger");
      defineKeyword("default");
      defineKeyword("delete");
      defineKeyword("do");
      defineKeyword("double");
      defineKeyword("else");
      defineKeyword("enum");
      defineKeyword("eval");
      defineKeyword("export");
      defineKeyword("extends");
      defineKeyword("false");
      defineKeyword("final");
      defineKeyword("finally");
      defineKeyword("float");
      defineKeyword("for");
      defineKeyword("function");
      defineKeyword("goto");
      defineKeyword("if");
      defineKeyword("implements");
      defineKeyword("import");
      defineKeyword("in");
      defineKeyword("instanceof");
      defineKeyword("int");
      defineKeyword("interface");
      defineKeyword("let");
      defineKeyword("long");
      defineKeyword("native");
      defineKeyword("new");
      defineKeyword("null");
      defineKeyword("package");
      defineKeyword("private");
      defineKeyword("protected");
      defineKeyword("public");
      defineKeyword("repeat");
      defineKeyword("return");
      defineKeyword("short");
      defineKeyword("static");
      defineKeyword("super");
      defineKeyword("switch");
      defineKeyword("synchronized");
      defineKeyword("this");
      defineKeyword("throw");
      defineKeyword("throws");
      defineKeyword("transient");
      defineKeyword("true");
      defineKeyword("try");
      defineKeyword("typeof");
      defineKeyword("var");
      defineKeyword("void");
      defineKeyword("volatile");
      defineKeyword("while");
      defineKeyword("with");
      defineKeyword("yield");
   }

/* Private constants */

   private static final Color COMMENT_COLOR = new Color(0x009900);
   private static final Color KEYWORD_COLOR = new Color(0x0000CC);
   private static final Color STRING_COLOR = new Color(0x009999);
   private static final Color NUMBER_COLOR = new Color(0x000000);
   private static final Color ERROR_COLOR = new Color(0x990000);
   private static final Color CODE_COLOR = Color.BLACK;

}

      