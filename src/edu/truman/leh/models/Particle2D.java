package edu.truman.leh.models;

import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

import edu.truman.leh.interfaces.Circle2D;
import edu.truman.leh.math.Vector2D;

/**
 * The Particle2D class defines a two-dimensional circle in accordance with the
 * Circle2D interface.
 * @author Hieu Le
 * @version November 17th, 2015
 */
public class Particle2D implements Circle2D
{

   private Point2D center;
   private double radius;
   private Vector2D velocity;
   
   /**
    * Constructs a Particle2D object from the its center position, its radius
    * and its velocity.
    * @param center the particle's center
    * @param radius the particle's radius
    * @param velocity the particule's velocity
    */
   public Particle2D(Point2D center, double radius, Vector2D velocity)
   {
      this.center = center;
      this.radius = radius;
      this.velocity = velocity;
   }
   
   @Override
   public void draw(Graphics2D g2)
   {
      Ellipse2D.Double boundary = new Ellipse2D.Double(center.getX() - radius, 
            center.getY() - radius, 2 * radius, 2 * radius);
      g2.draw(boundary);
   }

   @Override
   public Vector2D getVelocity()
   {
      return velocity;
   }

   @Override
   public void setVelocity(Vector2D v)
   {
      velocity = v;
   }

   @Override
   public void updateLocation()
   {
      double x = center.getX() + velocity.getX();
      double y = center.getY() + velocity.getY();
      center.setLocation(x, y);
   }

   @Override
   public Point2D getCenter()
   {
      return center;
   }

   @Override
   public double getRadius()
   {
      return radius;
   }

   @Override
   public boolean contains(Point2D p)
   {
      // p lies in the interior of this particle if the distance from p to
      // the particle's center does not exceed the radius of the particle
      return center.distance(p) <= radius;
   }

   @Override
   public boolean contains(Circle2D c)
   {
      // c lies in the interior of this particle if the sum of the distance 
      // between the two centers and the radius of c does not exceed the radius
      // of this particle
      return center.distance(c.getCenter()) + c.getRadius() <= radius;
   }

   @Override
   public boolean intersects(Circle2D c)
   {
      // c shares a common point with this particle if the distance between the
      // two centers does not exceed the sum of the two radii
      return center.distance(c.getCenter()) <= radius + c.getRadius();
   }

   @Override
   public boolean intersects(Line2D l)
   {
      // l shares a common point with this instance if the minimum distance 
      // between l and the circle's center does not exceed its radius
      return l.ptLineDist(center) <= radius;
   }
   
}
