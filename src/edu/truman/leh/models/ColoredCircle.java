package edu.truman.leh.models;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

import edu.truman.leh.interfaces.Circle2D;
import edu.truman.leh.math.Vector2D;

/**
 * The ColoredCircle class enhances the functionality of a Circle2D object by
 * allowing it to be colored when drawn. The filling color is random chosen if
 * unspecified.
 * @author Hieu Le
 * @version November 17th, 2015
 */
public class ColoredCircle implements Circle2D
{
   
   private Circle2D circle;
   private Color color;
   
   private static final int COLOR_RANGE = 256;
   
   /**
    * Constructs a ColoredCircle from the circle to be decorated and the 
    * filling color.
    * @param circle the circle whose functionlity needs enhancing
    * @param color the filling color
    */
   public ColoredCircle(Circle2D circle, Color color)
   {
      this.circle = circle;
      this.color = color;
   }
   
   /**
    * Constructs a ColoredCircle from the circle to be decorated.
    * The filling color will be randomly generated.
    * @param circle the circle whose functionality needs enhancing.
    */
   public ColoredCircle(Circle2D circle)
   {
      this.circle = circle;
      // Randomize the RBG blend
      color = new Color((int)(Math.random() * COLOR_RANGE), 
            (int)(Math.random() * COLOR_RANGE), 
            (int)(Math.random() * COLOR_RANGE)); 
   }
   
   @Override
   public void draw(Graphics2D g2)
   {
      Ellipse2D.Double boundary = 
            new Ellipse2D.Double(getCenter().getX() - getRadius(),
                  getCenter().getY() - getRadius(), 
                  2 * getRadius(), 2 * getRadius());
      g2.setColor(color);
      g2.draw(boundary);
      g2.fill(boundary);
   }
   
   @Override
   public Vector2D getVelocity()
   {
      return circle.getVelocity();
   }
   
   @Override
   public void setVelocity(Vector2D v)
   {
      circle.setVelocity(v);
   }
   
   @Override
   public void updateLocation()
   {
      circle.updateLocation();
   }
   
   @Override
   public Point2D getCenter()
   {
      return circle.getCenter();
   }
   
   @Override
   public double getRadius()
   {
      return circle.getRadius();
   }
   
   @Override
   public boolean contains(Point2D p)
   {
      return circle.contains(p);
   }
   
   @Override
   public boolean contains(Circle2D c)
   {
      return circle.contains(c);
   }
   
   @Override
   public boolean intersects(Circle2D c)
   {
      return circle.intersects(c);
   }
   
   @Override
   public boolean intersects(Line2D l)
   {
      return circle.intersects(l);
   }
   
}
