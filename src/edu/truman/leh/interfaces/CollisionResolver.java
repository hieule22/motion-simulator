package edu.truman.leh.interfaces;

import java.awt.geom.Line2D;

/**
 * The CollisionResolver interface defines an engine capable of resolving
 * collisions in a two-dimensional region. 
 * Collisions encompass those occuring when two circles collide against
 * each other or when a circle collides against a stationary wall.
 * @author Hieu Le
 * @version November 17th, 2015
 */
public interface CollisionResolver
{
   
   /**
    * Resolves collision between two circles by updating their velocities in
    * the wake of the collision. 
    * @param c0 the first circle
    * @param c1 the second circle
    */
   void resolve(Circle2D c0, Circle2D c1);
   
   /**
    * Resolves collision between a circle and a stationary wall by updating
    * the circle's velocity in the wake of the collision.
    * @param c the circle
    * @param w a Line2D representing the wall
    */
   void resolve(Circle2D c, Line2D w);
   
}
