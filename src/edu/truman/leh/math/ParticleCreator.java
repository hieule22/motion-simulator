package edu.truman.leh.math;

import java.awt.geom.Point2D;

import edu.truman.leh.interfaces.CircleCreator;
import edu.truman.leh.models.Particle2D;

/**
 * The ParticleCreator defines a particle generator in accordance with the 
 * CircleCreator interface.
 * @author Hieu Le
 * @version November 17th, 2015
 */
public class ParticleCreator implements CircleCreator
{

   private double radius;
   private double speed;
   
   public static final double DEFAULT_RADIUS = 5;  
   public static final double DEFAULT_SPEED = 3;
   private static final double RNG_OFFSET = 0.5;
   
   /**
    * Constructs a ParticleCreator with specified particle's radius and inital
    * speed.
    * @param radius the particle's radius
    * @param speed the particle's speed
    */
   public ParticleCreator(double radius, double speed)
   {
      this.radius = radius;
      this.speed = speed;
   }
   
   /**
    * Constructs a ParticleCreator with the default particle's radius and 
    * initial speed.
    */
   public ParticleCreator()
   {
      this(DEFAULT_RADIUS, DEFAULT_SPEED);
   }
   
   @Override
   public Particle2D createCircle(Point2D c, Vector2D d)
   {
      Vector2D velocity = d.normalize().scalarMultiply(speed);
      return new Particle2D(c, radius, velocity);
   }

   @Override
   public Particle2D createRandomCircle(Point2D c)
   {
      double dx = Math.random() - RNG_OFFSET;
      double dy = Math.random() - RNG_OFFSET;
      return createCircle(c, new Vector2D(dx, dy));
   }

}
