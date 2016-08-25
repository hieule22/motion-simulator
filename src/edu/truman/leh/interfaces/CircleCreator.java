package edu.truman.leh.interfaces;

import java.awt.geom.Point2D;

import edu.truman.leh.math.Vector2D;

/**
 * The CircleCreator interface defines a generator capable of creating Circle2D
 * objects deterministically or randomly.
 * @author Hieu Le
 * @version November 17th, 2015
 */
public interface CircleCreator
{

   /**
    * Creates a circle with specified center c which moves at direction d.
    * @param c the circle's center
    * @param d a Vector2D representing the circle's direction
    * @return a Circle2D object
    */
   Circle2D createCircle(Point2D c, Vector2D d);
   
   /**
    * Creates a circle with a specified center which moves at random direction.
    * @param c the circle's center
    * @return a Circle2D object
    */
   Circle2D createRandomCircle(Point2D c);
}
