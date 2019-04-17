/*
 * File: PPOrbitalMechanics.java
 * -----------------------------
 * This program animates an orbiting planet.
 */

import edu.stanford.cs.pptx.PPFreeform;
import edu.stanford.cs.pptx.PPOval;
import edu.stanford.cs.pptx.PPPath;
import edu.stanford.cs.pptx.PPShape;
import edu.stanford.cs.pptx.PPShow;
import edu.stanford.cs.pptx.PPSlide;
import edu.stanford.cs.pptx.code.PPConsole;

public class PPOrbitalMechanics {

   public void run() {
      ppt = new PPShow();
      slide = new PPSlide();
      ppt.add(slide);
      slide.addTitle("PPOrbitalMechanics");
      cx = slide.getWidth() / 2;
      cy = slide.getHeight() / 2 + 30;
      a = ELLIPSE_WIDTH / 2;
      b = Math.sqrt(a * a - SUN_DX * SUN_DX);
      sx = cx + SUN_DX;
      sy = cy;
      double sr = SUN_RADIUS;
      sun = new PPOval(sx - sr, sy - sr, 2 * sr, 2 * sr);
      sun.setColor(SUN_COLOR);
      slide.add(sun);
      double px = cx + a;
      double py = cy;
      double pr = PLANET_RADIUS;
      planet = new PPOval(px - pr, py - pr, 2 * pr, 2 * pr);
      planet.setColor(PLANET_COLOR);
      slide.add(planet);
      double dt = 360.0 / N_SEGMENTS;
      double v0 = orbitalVelocity(0);
      PPPath p0 = new PPPath();
      addSegment(p0, -dt, 0);
      addSegment(p0, 0, dt);
      p0.lineTo(sx, sy);
      PPFreeform ff0 = new PPFreeform(p0);
      slide.add(ff0);
      double v1 = orbitalVelocity(180);
      PPPath p1 = new PPPath();
      double vf = v1 / v0 * V_FUDGE;
      addSegment(p1, 180 - dt * v1 / v0, 180);
      addSegment(p1, 180, 180 + dt * v1 / v0);
      p1.lineTo(sx, sy);
      PPFreeform ff1 = new PPFreeform(p1);
      slide.add(ff1);
      String trigger = "/onClick";
      for (int i = 0; i < 2 * N_SEGMENTS; i++) {
         double angle = i * dt;
         double speed = orbitalVelocity(angle + dt / 2);
         String options = trigger + "/speed:" + speed;
         addSegment(planet, angle, angle + dt, options);
         if (i == N_SEGMENTS) ff0.appear("/afterPrev");
         if (i == 3 * N_SEGMENTS / 2 + 2) ff1.appear("/afterPrev");
         trigger = "/afterPrev";
      }
      ppt.save("PPOrbitalMechanics.pptx");
      System.out.println("PPOrbitalMechanics.pptx");
   }

   private double sectorArea(double a0, double a1) {
      return f(a1) - f(a0);
   }

   private double f(double angle) {
      double theta = Math.toRadians(angle);
      double num = (b - a) * Math.sin(2 * theta);
      double den = b + a + (b - a) * Math.cos(2 * theta);
      return a * b / 2 * (theta - Math.atan2(num, den));
   }

   private double orbitalVelocity(double angle) {
      return Math.sqrt(GM * (2 / planetDistance(angle) - 1 / a));
   }

   private double planetDistance(double angle) {
      double theta = Math.toRadians(angle);
      double x = cx + a * Math.cos(theta);
      double y = cy + b * Math.sin(theta);
      return Math.sqrt((sx - x) * (sx - x) + (sy - y) * (sy - y));
   }

   private void addSegment(PPPath path, double a0, double a1) {
      addSegment(null, path, a0, a1, "");
   }

   private void addSegment(PPShape s, double a0, double a1,
                             String options) {
      addSegment(s, null, a0, a1, options);
   }

   private void addSegment(PPShape s, PPPath path, double a0, double a1,
                           String options) {
      double t0 = Math.toRadians(a0);
      double t1 = Math.toRadians(a1);
      double dt = t1 - t0;
      double x0 = cx + a * Math.cos(t0);
      double y0 = cy + b * Math.sin(t0);
      double x3 = cx + a * Math.cos(t1);
      double y3 = cy + b * Math.sin(t1);
      double th = Math.tan(dt / 2);
      double alpha = Math.sin(t1 - t0) * (Math.sqrt(4 + 3 * th * th) - 1) / 3;
      double x1 = x0 - alpha * a * Math.sin(t0);
      double y1 = y0 + alpha * b * Math.cos(t0);
      double x2 = x3 + alpha * a * Math.sin(t1);
      double y2 = y3 - alpha * b * Math.cos(t1);
      if (s != null) {
         double r = s.getWidth() / 2;
         s.curveTo(x1 - r, y1 - r, x2 - r, y2 - r, x3 - r, y3 - r, options);
      }
      if (path != null) {
         if (path.isEmpty()) {
            path.moveTo(sx, sy);
            path.lineTo(x0, y0);
         }
         path.curveTo(x1, y1, x2, y2, x3, y3);
      }
   }

/* Constants */

   public static final String SUN_COLOR = "#FF9900";
   public static final String PLANET_COLOR = "#0033FF";

   public static final double GM = 4000000;
   public static final double ELLIPSE_WIDTH = 450;
   public static final double SUN_DX = -120;
   public static final double SUN_RADIUS = 24;
   public static final double PLANET_RADIUS = 8;
   public static final double V_FUDGE = 0.9;

   public static final int N_SEGMENTS = 36;

/* Private instance variables */

   private PPShow ppt;
   private PPSlide slide;
   private PPOval sun;
   private PPOval planet;
   private double cx;                 /* The center of the ellipse */
   private double cy;
   private double sx;                 /* The coordinates of the sun */
   private double sy;
   private double a;                  /* The semimajor axis */
   private double b;                  /* The semiminor axis */

/* Startup code */

   public static void main(String[] args) {
      new PPOrbitalMechanics().run();
   }

}
