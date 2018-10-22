/*
 * File: PPShow.java
 * -----------------
 * This class encapsulates a PowerPoint slide show.
 */

package edu.stanford.cs.pptx;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.geom.Dimension2D;
import java.util.ArrayList;

/**
 * This class represents a complete PowerPoint slide show, which consists of
 * a sequence of slides.  To ensure that the numbering of slides in the data
 * structure matches the conventional numbering scheme of a PowerPoint
 * presentation, the numbering begins at 1.
 */

public class PPShow {

/**
 * Creates an empty PowerPoint slide show using the default 4:3 aspect ratio.
 */

   public PPShow() {
      this(PPShow.WIDTH, PPShow.HEIGHT);
   }

/**
 * Creates a slide show with the specified dimensions.
 *
 * @param width The width of the slide show
 * @param height The height of the slide show
 */

   public PPShow(int width, int height) {
      this.width = width;
      this.height = height;
      slides = new ArrayList<PPSlide>();
      slides.add(null);
      title = "SlideShow";
      int g = gcd(width, height);
      format = "On-screen Show (" + (width / g) + ":" + (height / g) + ")";
      setBackground(DEFAULT_BACKGROUND);
   }

/**
 * Sets the title of the entire show.
 *
 * @param title The title of the show
 */

   public void setTitle(String title) {
      this.title = title;
   }

/**
 * Gets the title of the entire show.
 *
 * @return The title of the show
 */

   public String getTitle() {
      return title;
   }

/**
 * Sets the format of the entire show.
 *
 * @param format The format of the show
 */

   public void setFormat(String format) {
      this.format = format;
   }

/**
 * Gets the format of the entire show.
 *
 * @return The format of the show
 */

   public String getFormat() {
      return format;
   }

/**
 * Saves this slide show to the specified file.
 *
 * @param filename The pathname to which the <code>.pptx</code> file is saved
 */

   public void save(String filename) {
      new PPSavePPTX(this).save(filename);
   }

/**
 * Returns the number of slides in this presentation.
 *
 * @return The number of slides in this presentation
 */

   public int getSlideCount() {
      return slides.size() - 1;
   }

/**
 * Gets the slide at the specified index, where slide numbering begins at 1.
 *
 * @param index The index of the slide
 * @return The <code>PPSlide</code> object for the desired slide
 */

   public PPSlide getSlide(int index) {
      if (index < 1 || index >= slides.size()) {
         throw new RuntimeException("getSlide: Index " + index +
                                    " is out of bounds");
      }
      return slides.get(index);
   }

/**
 * Returns the size of the window used for the slide show, where the
 * size is measured in pixel units.
 *
 * @return The size of the PowerPoint window
 */

   public Dimension2D getWindowSize() {
      return new Dimension(width, height);
   }

/**
 * Returns the width of the window in pixels.
 *
 * @return The width of the PowerPoint window in pixels
 */

   public double getWidth() {
      return width;
   }

/**
 * Returns the height of the window in pixels.
 *
 * @return The height of the PowerPoint window in pixels
 */

   public double getHeight() {
      return height;
   }

/**
 * Returns the width of the window in pixels. This version of the method
 * is included for backward compatibility. The preferred name of this
 * method is <code>getWidth</code>.
 *
 * @return The width of the PowerPoint window in pixels
 */

   public double getWindowWidth() {
      return width;
   }

/**
 * Returns the height of the window in pixels. This version of the method
 * is included for backward compatibility. The preferred name of this
 * method is <code>getHeight</code>.
 *
 * @return The height of the PowerPoint window in pixels
 */

   public double getWindowHeight() {
      return height;
   }

/**
 * Sets the background color for the slide show.
 *
 * @param color The background color for the slide show
 */

   public void setBackground(Color color) {
      bgColor = color;
   }

/**
 * Returns the background color used in the slide show.
 *
 * @return The background color
 */

   public Color getBackground() {
      return bgColor;
   }

/**
 * Returns a printable string representation for this PowerPoint show.
 *
 * @return The string representation for this show
 */

   public String toString() {
      return "PPShow (" + getSlideCount() + " slides)";
   }

/**
 * Adds the slide to this show.
 *
 * @param slide The slide to be added
 */

   public void add(PPSlide slide) {
      slides.add(slide);
      if (slide != null) slide.setShow(this);
   }

/* Private methods */

/*
 * Returns the greatest common divisor (gcd) of the two integers,
 * x and y.  This implementation of the gcd method uses Euclid's
 * algorithm.
 */

   private int gcd(int x, int y) {
      int r = x % y;
      while (r != 0) {
         x = y;
         y = r;
         r = x % y;
      }
      return y;
   }

/* Public constants */

/**
 * The width of the standard slide show in pixels.
 */

   public static final int WIDTH = 716;

/**
 * The height of the standard slide show in pixels.
 */

   public static final int HEIGHT = 537;

/**
 * The default background color.
 */

   public static final Color DEFAULT_BACKGROUND = new Color(0xCCFFFF);

/* Private instance variables */

   private ArrayList<PPSlide> slides;
   private Color bgColor;
   private String format;
   private String title;
   private int width;
   private int height;

}
