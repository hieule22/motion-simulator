package edu.truman.leh.graphics;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import edu.truman.leh.interfaces.Circle2D;
import edu.truman.leh.interfaces.Space2D;
import edu.truman.leh.math.Vector2D;

/**
 * The CommandListener class defines a listener capable of accepting commands
 * from the keyboard and updating the space accordingly.
 * @author Hieu Le
 * @version November 17th, 2015
 */
public class CommandListener extends KeyAdapter
{
   
   private Space2D space;
   
   /**
    * Constructs a CommandListener to update a specified space.
    * @param space a Space2D object to update
    */
   public CommandListener(Space2D space)
   {
      this.space = space;
   }
   
   @Override
   public void keyPressed(KeyEvent e)
   {
      Vector2D direction;
      switch (e.getKeyCode())
      {
         case KeyEvent.VK_DOWN:
            direction = new Vector2D(0, 1);
            break;
         case KeyEvent.VK_UP:
            direction = new Vector2D(0, -1);
            break;
         case KeyEvent.VK_RIGHT:
            direction = new Vector2D(1, 0);
            break;
         case KeyEvent.VK_LEFT:
            direction = new Vector2D(-1, 0);
            break;
         case KeyEvent.VK_C:
            space.clear();
            return;
         case KeyEvent.VK_R:
            space.remove();
            return;
         case KeyEvent.VK_Q:
            System.exit(0);
         default:
            return;
      }
      
      for (Circle2D c : space.listCircles())
      {
         double speed = c.getVelocity().getLength();
         c.setVelocity(direction.scalarMultiply(speed));
      }
      space.notifyListeners();
   }
}
