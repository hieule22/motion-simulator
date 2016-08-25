package edu.truman.leh.graphics;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.Timer;

/**
 * The ControlButton class defines a button that allows users to pause 
 * or resume an ongoing animation.
 * @author Hieu Le
 * @version November 19th, 2015
 */
public class ControlButton extends JButton
{

   public static final String START_MESSAGE = "Start";
   public static final String PAUSE_MESSAGE = "Pause";
   public static final String RESUME_MESSAGE = "Resume";
   
   /**
    * Constructs a ControlButton object to control a given timer.
    * @param timer the Timer to control
    */
   public ControlButton(Timer timer)
   {
      super(START_MESSAGE);
      addActionListener(new ActionListener()
      {
         @Override
         public void actionPerformed(ActionEvent e)
         {
            if (timer.isRunning())
            {
               setText(RESUME_MESSAGE);
               timer.stop();
            }
            else 
            {
               setText(PAUSE_MESSAGE);
               timer.start();
            }
         }
      });
   }
   
}
