package edu.truman.leh;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

import edu.truman.leh.graphics.ClearButton;
import edu.truman.leh.graphics.CommandListener;
import edu.truman.leh.graphics.ControlButton;
import edu.truman.leh.graphics.RemoveButton;
import edu.truman.leh.graphics.SpaceDisplay;
import edu.truman.leh.interfaces.CircleCreator;
import edu.truman.leh.interfaces.Space2D;
import edu.truman.leh.math.ElasticResolver;
import edu.truman.leh.math.ParticleCreator;
import edu.truman.leh.models.Cartesian2D;

/**
 * This class defines the entry point for the program.
 * Solves assignment 1120.
 * @author Hieu Le
 * @version November 19th, 2015
 */
public class App implements Runnable
{
   
   private Space2D space;
   private CircleCreator creator;
   private Timer timer;
   private SpaceDisplay display;
   private KeyListener commandListener;
   private ControlButton controlButton;
   private ClearButton clearButton;
   private RemoveButton removeButton;
   private JFrame mainFrame;
   
   private final double HEIGHT = 500;
   private final double WIDTH = 500;
   private final int UPDATE_DELAY = 10;
   
   /**
    * Constructs an object of this class.
    */
   public App()
   {
      space = new Cartesian2D(HEIGHT, WIDTH, new ElasticResolver());
      creator = new ParticleCreator();
      timer = new Timer(UPDATE_DELAY, new ActionListener()
      {
         @Override
         public void actionPerformed(ActionEvent e)
         {
            space.update();
         }
      });
      display = new SpaceDisplay(HEIGHT, WIDTH, space, creator);
      space.addChangeListener(display);
      commandListener = new CommandListener(space);
      clearButton = new ClearButton(space);
      clearButton.addKeyListener(commandListener);
      controlButton = new ControlButton(timer);
      controlButton.addKeyListener(commandListener);
      removeButton = new RemoveButton(space);
      removeButton.addKeyListener(commandListener);
      mainFrame = new JFrame();
      setUpGUI();
   }
   
   /**
    * Sets up the graphic components.
    */
   private void setUpGUI()
   {
      JPanel buttonPanel = new JPanel(new GridLayout(1, 3));
      buttonPanel.add(controlButton);
      buttonPanel.add(removeButton);
      buttonPanel.add(clearButton);
      
      final int heightOffset = 50;
      mainFrame.setSize((int)WIDTH, (int)HEIGHT + heightOffset);
      mainFrame.add(buttonPanel, BorderLayout.NORTH);
      mainFrame.add(display, BorderLayout.CENTER);
      mainFrame.addKeyListener(commandListener);
      mainFrame.requestFocusInWindow();
      mainFrame.setFocusable(true);
      mainFrame.setResizable(false);
      mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }
   
   @Override
   public void run()
   {
      mainFrame.setVisible(true);
   }
   
   public static void main(String[] args)
   {
      App animator = new App();
      animator.run();
   }
}
