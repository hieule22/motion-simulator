package edu.truman.leh.graphics;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import edu.truman.leh.interfaces.Space2D;

/**
 * The ClearButton class defines a button that allows users to clear all the
 * circles present in a 2-dimensional space.
 * @author hieule
 *
 */
public class ClearButton extends JButton
{
   
   public static final String CLEAR_BUTTON_TEXT = "Clear";
   
   /**
    * Constructs a ClearButton object with a specified space to clear circles
    * @param space the Space2D to clear all circles
    */
   public ClearButton(Space2D space)
   {
      super(CLEAR_BUTTON_TEXT);
      addActionListener(new ActionListener()
      {
         @Override
         public void actionPerformed(ActionEvent e)
         {
            space.clear();
         }
      });
   }
}
