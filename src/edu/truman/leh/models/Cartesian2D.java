package edu.truman.leh.models;

import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.util.ArrayList;
import java.util.List;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import edu.truman.leh.interfaces.Circle2D;
import edu.truman.leh.interfaces.CollisionResolver;
import edu.truman.leh.interfaces.Space2D;

/**
 * The Cartesian2D class defines a two-dimensional region specified by the
 * Cartesian coordinate system.The interactions between circles in this region
 * are determined by an engine of type CollisionResolver.
 * @author Hieu Le
 * @version November 17th, 2015
 */
public class Cartesian2D implements Space2D
{
   
   private CollisionResolver resolver;
   private List<Circle2D> circles;
   private List<Line2D> edges;
   private List<ChangeListener> listeners;
   
   /**
    * Constructs a Cartesian2D region with the specified dimension and 
    * collision resolving engine.
    * @param height the height of the region
    * @param width the width of the region
    * @param resolver the collision resolving engine
    */
   public Cartesian2D(double height, double width, CollisionResolver resolver)
   {
      this.resolver = resolver;
      circles = new ArrayList<Circle2D>();
      listeners = new ArrayList<ChangeListener>();
      edges = new ArrayList<Line2D>();
      // Left edge
      edges.add(new Line2D.Double(0, 0, 0, height));
      // Bottom edge
      edges.add(new Line2D.Double(0, height, width, height));
      // Right edge
      edges.add(new Line2D.Double(width, height, width, 0));
      // Top edge
      edges.add(new Line2D.Double(width, 0, 0, 0));
   }
   
   @Override
   public void draw(Graphics2D g2)
   {
      for (Circle2D c : circles)
      {
         c.draw(g2);
      }
   }

   @Override
   public void add(Circle2D c)
   {
      for (Circle2D c1 : circles)
      {
         if (c.intersects(c1) || c.contains(c1) || c1.contains(c))
         {
            return;
         }
      }
      circles.add(c);
      notifyListeners();
   }

   @Override
   public void remove()
   {
      if (circles.isEmpty())
         return;
      circles.remove(circles.size() - 1);
      notifyListeners();
   }

   @Override
   public void clear()
   {
      circles.clear();
      notifyListeners();
   }

   @Override
   public void update()
   {
      for (Circle2D c : circles)
         c.updateLocation();
      // Resolve any resulting collision, under the assumption that collisions
      // are strictly bilateral
      for (int i = 0; i < circles.size(); i++)
      {
         boolean collide = false;
         // Resolve collisions between current circle with any other circle
         for (int j = i + 1; !collide && j < circles.size(); j++)
         {
            if (circles.get(i).intersects(circles.get(j)) 
                  || circles.get(i).contains(circles.get(j))
                  || circles.get(j).contains(circles.get(i)))
            {
               collide = true;
               resolver.resolve(circles.get(i), circles.get(j));
            }
         }
         // Resolve collisions between current circle with any edge
         for (int j = 0; !collide && j < edges.size(); j++)
         {
            if (circles.get(i).intersects(edges.get(j)))
            {
               collide = true;
               resolver.resolve(circles.get(i), edges.get(j));
            }
         }
      }
      notifyListeners();
   }

   @Override
   public void addChangeListener(ChangeListener l)
   {
      listeners.add(l);
   }

   @Override
   public void notifyListeners()
   {
      for (ChangeListener l : listeners)
      {
         l.stateChanged(new ChangeEvent(this));
      }
   }
   
   @Override
   public List<Circle2D> listCircles()
   {
      return circles;
   }
   
}
