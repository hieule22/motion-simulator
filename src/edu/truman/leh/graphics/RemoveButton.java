package edu.truman.leh.graphics;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import edu.truman.leh.interfaces.Space2D;

/**
 * The RemoveButton class defines a button that allows users to remove the last
 * added circle from a displayed space.
 * @author Hieu Le
 * @version November 17th, 2015
 */
public class RemoveButton extends JButton
{

   public static final String BUTTON_TEXT = "Remove";
   
   /**
    * Constructs a RemoveButton object with a specified space to remove circle.
    * @param space the Space2D to remove circles from
    */
   public RemoveButton(Space2D space)
   {
      super(BUTTON_TEXT);
      addActionListener(new ActionListener()
      {
         @Override
         public void actionPerformed(ActionEvent e)
         {
            space.remove();
         }
      });
   }
}
