/*
 * File: PPShapeAnimator.java
 * --------------------------
 * This class supports animating a list of shapes in parallel.
 */

package edu.stanford.cs.pptx.animation;

import edu.stanford.cs.pptx.PPShape;
import java.util.ArrayList;
import java.util.List;

public class PPShapeAnimator {

/**
 * Creates a new shape animator for the specified shape.
 *
 * @param shape The shape to be animated
 * @param timeStep The time step in seconds
 */

   public PPShapeAnimator(PPShape shape, double timeStep, double delay) {
      this.shape = shape;
      this.timeStep = timeStep;
      this.delay = delay;
      animations = new ArrayList<PPShapeAnimation>();
   }

/**
 * Adds an appear animation in the current time step.
 */

   public void appear() {
      animations.add(new PPAppearAnimation());
   }

/**
 * Adds a move animation in the current time step.
 */

   public void move(double dx, double dy) {
      animations.add(new PPMoveAnimation(dx, dy));
   }

/**
 * Returns <code>true</code> if the animation is finished.
 *
 * @return The value <code>true</code> if the animation is finished
 */

   public boolean isFinished() {
      return animations.isEmpty();
   }

/**
 * Executes the next animation step for this animator.
 *
 * @param trigger The trigger applied to this animation
 * @return The value <code>true</code> if this animation is real
 */

   public void executeAnimationStep(String trigger) {
      animations.remove(0).apply(shape, trigger, timeStep);
   }

/**
 * Executes animations for each of the listed animators in parallel.
 * The trigger is applied only to the very first animation.  The list
 * is emptied by the call.
 *
 * @param list A list of the animators
 * @param trigger The trigger for the first animation
 */

   public static void animate(List<PPShapeAnimator> list, String trigger) {
      for (int t = 0; !list.isEmpty(); t++) {
         for (int i = 0; i < list.size(); i++) {
            PPShapeAnimator animator = list.get(i);
            if (t >= animator.delay) {
               animator.executeAnimationStep(trigger);
               trigger = "/withPrev";
            }
         }
         for (int i = list.size() - 1; i >= 0; i--) {
            if (list.get(i).isFinished()) list.remove(i);
         }
         trigger = "/afterPrev";
      }
   }
      
/* Private instance variables */

   private ArrayList<PPShapeAnimation> animations;
   private PPShape shape;
   private double delay;
   private double timeStep;

}

/*
 * This class represents an animation action performed in a single time step.
 */

abstract class PPShapeAnimation {

   public abstract void apply(PPShape shape, String trigger, double timeStep);

}

/*
 * This class animates an appear transition.
 */

class PPAppearAnimation extends PPShapeAnimation {

   @Override
   public void apply(PPShape shape, String trigger, double timeStep) {
      shape.appear(trigger);
      shape.move(0, 0, "/withPrev/dur:" + timeStep);
   }

}

/*
 * This class animates a move transition.
 */

class PPMoveAnimation extends PPShapeAnimation {

   public PPMoveAnimation(double dx, double dy) {
      this.dx = dx;
      this.dy = dy;
   }

   @Override
   public void apply(PPShape shape, String trigger, double timeStep) {
      shape.move(dx, dy, trigger + "/dur:" + timeStep);
   }

/* Private instance variables */

   private double dx;
   private double dy;

}
