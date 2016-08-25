package edu.truman.leh.interfaces;

import java.util.List;

import javax.swing.event.ChangeListener;

/**
 * The Space2D interface defines a two-dimensional region composed of circles.
 * @author Hieu Le
 * @version November 17th, 2015
 */
public interface Space2D extends Drawable2D
{
   
   /**
    * Adds a circle c to this region.
    * This method does nothing if c either contains, in contained inside or
    * intersects with an existing circle in the region.
    * @param c a Circle2D representing the circle to add
    */
   void add(Circle2D c);
   
   /**
    * Removes the last circle to be added.
    * This method does nothing if the region is empty.
    */
   void remove();
   
   /**
    * Removes all circles from the region.
    */
   void clear();
   
   /**
    * Updates the state of this region after a unit of time.
    */
   void update();
   
   /**
    * Attaches a listener l to this region.
    * @param l the ChangeListener to attach
    */
   void addChangeListener(ChangeListener l);
   
   /**
    * Notifies all attached listeners of any change to the region.
    */
   void notifyListeners();
   
   /**
    * Returns a list containing all the circles existing in this region.
    * @return a list of Circle2D objects
    */
   List<Circle2D> listCircles();
   
}
