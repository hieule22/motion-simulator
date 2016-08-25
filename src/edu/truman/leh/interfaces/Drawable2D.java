package edu.truman.leh.interfaces;

import java.awt.Graphics2D;

/**
 * The Drawable2D interface allows all implementing instances to be drawable
 * on a two-dimension graphic platform.
 * @author Hieu Le
 * @version November 17th, 2015
 */
public interface Drawable2D
{
   
   /**
    * Draws this instance on a two-dimensional graphic platform g2.
    * @param g2 the graphic platform
    */
   void draw(Graphics2D g2);
   
}
