package edu.truman.leh.interfaces;

import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

/**
 * The Circle2D interface defines a drawable circle moving in two-dimensional
 * space.
 * @author Hieu Le
 * @version November 17th, 2015
 */
public interface Circle2D extends Drawable2D, Movable2D
{
   
   /**
    * Returns the location of the circle's center.
    * @return a Point2D representing the center
    */
   Point2D getCenter();
   
   /**
    * Returns the circle's radius
    * @return the radius
    */
   double getRadius();
   
   /**
    * Tests if this circle contains a point p.
    * @param p a Point2D representing the point to check
    * @return true if this circle contains p; false otherwise
    */
   boolean contains(Point2D p);
   
   /**
    * Tests if this instance contains another circle c.
    * @param c a Circle2D representing the circle to check
    * @return true if this circle contains c; false otherwise
    */
   boolean contains(Circle2D c);
   
   /**
    * Tests if this instance intersects another circle c.
    * @param c a Circle2D representing the circle to check
    * @return true if this circle has at least one point in common with c; 
    * false otherwise
    */
   boolean intersects(Circle2D c);
   
   /**
    * Tests if this circle intersects a line l.
    * @param l a Line2D representing the line to check
    * @return true if this circle has at least one point in common with l;
    * false otherwise
    */
   boolean intersects(Line2D l);
   
}
