package edu.truman.leh.interfaces;

import edu.truman.leh.math.Vector2D;

/**
 * The Movable2D interface defines a moving object with a changeable velocity
 * in two-dimensional space.
 * @author Hieu Le
 * @version November 17th, 2015
 */
public interface Movable2D
{
   
   /**
    * Returns the velocity of this instance.
    * @return a Vector2D representing the velocity
    */
   Vector2D getVelocity();
   
   /**
    * Sets the velocity of this instance to a new value v.
    * @param v the new velocity to be set to
    */
   void setVelocity(Vector2D v);
   
   /**
    * Updates the location of this instance after a unit of time.
    */
   void updateLocation();
   
}
