package edu.truman.leh.math;

import java.awt.geom.Line2D;

import edu.truman.leh.interfaces.Circle2D;
import edu.truman.leh.interfaces.CollisionResolver;

/**
 * The ElasticResolver defines an engine in accordance with the 
 * CollisionResolver interface.
 * The engine assumes all collisions are perfectly elastic and only affect
 * the velocities, not the shapes, of the colliding circles.
 * @author Hieu Le
 * @version November 17th, 2015
 */
public class ElasticResolver implements CollisionResolver
{

   @Override
   public void resolve(Circle2D c0, Circle2D c1)
   {
   // Find a unit vector normal to the line of contact
      double dx = c0.getCenter().getX() - c1.getCenter().getX();
      double dy = c0.getCenter().getY() - c1.getCenter().getY();
      Vector2D normal = new Vector2D(dx, dy).normalize();
      // Compute the relative velocity
      Vector2D relativeVelocity = 
            c0.getVelocity().add(c1.getVelocity().negate());
      // Compute the scalar component of the relative velocity normal
      // to the line of contact. Return if this value is positive, i.e.
      // the two circles are moving away from each other
      if (relativeVelocity.dotProduct(normal) > 0)
         return;
      // Find a unit vector tangent (parallel) to the line of contact by 
      // swapping the scalar components of the normal unit vector and then
      // negating the horizontal component. This is to ensure that their 
      // dot product equals zero
      Vector2D tangent = 
            new Vector2D(-normal.getY(), normal.getX()).normalize();
      // Decompose the velocities of c0 and c1 into scalar components tangent
      // and normal to the line of contact by taking the dot products with the
      // unit tangent vector and unit normal vector respectively
      double v0n = normal.dotProduct(c0.getVelocity());
      double v0t = tangent.dotProduct(c0.getVelocity());
      double v1n = normal.dotProduct(c1.getVelocity());
      double v1t = tangent.dotProduct(c1.getVelocity());
      // Since the collisions are perfectly elastic and the two circles 
      // identical, the post-collision normal components of their velocities
      // are simply swapped
      double temp = v0n;
      v0n = v1n;
      v1n = temp;
      // Determine the post-collision velocity of each circle from its updated
      // scalar components
      c0.setVelocity(normal.scalarMultiply(v0n).add(tangent.scalarMultiply(v0t)));
      c1.setVelocity(normal.scalarMultiply(v1n).add(tangent.scalarMultiply(v1t)));
   }

   @Override
   public void resolve(Circle2D c, Line2D w)
   {
   // Find the unit vectors tangent and normal to the line of contact
      Vector2D tangent = 
            new Vector2D(w.getX1() - w.getX2(), w.getY1() - w.getY2()).normalize();
      Vector2D normal = 
            new Vector2D(-tangent.getY(), tangent.getX()).normalize();
      // Compute the dot product of the velocity of the circle and the normal 
      // unit vector. Return if this value is positive, i.e. the circle is 
      // moving away from the wall
      if (c.getVelocity().dotProduct(normal) > 0)
         return;
      // Decompose velocity of c into scalar components tangent and normal to
      // the line of contact
      double vn = normal.dotProduct(c.getVelocity());
      double vt = tangent.dotProduct(c.getVelocity());
      // Since collision is perfectly elastic, the normal component is simply
      // negated. The post-collision velocity of c is determined by recomposing
      // the updated scalar components
      c.setVelocity(tangent.scalarMultiply(vt).add(normal.scalarMultiply(-vn)));
   }
   
}
