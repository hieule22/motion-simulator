package edu.truman.leh.graphics;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Point2D;

import javax.swing.JComponent;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import edu.truman.leh.interfaces.Circle2D;
import edu.truman.leh.interfaces.CircleCreator;
import edu.truman.leh.interfaces.Space2D;
import edu.truman.leh.math.Vector2D;
import edu.truman.leh.models.ColoredCircle;

/**
 * The SpaceDisplay class defines a JComponent capable of displaying and
 * updating the content of an associated Space2D.
 * @author Hieu Le
 * @version November 17th, 2015
 */
public class SpaceDisplay extends JComponent implements ChangeListener
{

   private Space2D space;
   private CircleCreator creator;
   
   /**
    * Constructs a SpaceDisplay object with specified dimension, a space to
    * display and a circle creator.
    * @param height the height of the display
    * @param width the width of the display
    * @param space the Space2D to update and display
    * @param creator the CircleCreator to generate particles for the space
    */
   public SpaceDisplay(double height, double width, Space2D space, 
         CircleCreator creator)
   {
      this.space = space;
      this.creator = creator;
      setSize((int)width, (int)height);
      configureMouseListener();
   }
   
   private void configureMouseListener()
   {
      addMouseListener(new MouseAdapter()
      {
         // The point where the mouse is last pressed
         private Point2D lastPressPoint;
         
         @Override
         public void mousePressed(MouseEvent e)
         {
            lastPressPoint = e.getPoint();
         }
         
         @Override
         public void mouseReleased(MouseEvent e)
         {
            // In the event of a mouse click, a new circle with random initial
            // direction will be added to space. Otherwise, the direction of 
            // the circle will align with the direction of the mouse drag
            Circle2D circle;
            if (e.getPoint().equals(lastPressPoint))
            {
               circle = creator.createRandomCircle(lastPressPoint);
            }
            else 
            {
               double dx = e.getX() - lastPressPoint.getX();
               double dy = e.getY() - lastPressPoint.getY();
               Vector2D direction = new Vector2D(dx, dy);
               circle = creator.createCircle(e.getPoint(), direction);
            }
            space.add(new ColoredCircle(circle));
         }
      });
   }
   
   @Override
   public void stateChanged(ChangeEvent e)
   {
      repaint();
   }

   @Override
   protected void paintComponent(Graphics g)
   {
      Graphics2D g2 = (Graphics2D)g;
      space.draw(g2);
   }
}
