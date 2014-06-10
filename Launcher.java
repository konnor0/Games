package konnorscomputers;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by konnor on 6/9/14.
 */
public class Launcher extends JFrame implements ActionListener {
    //this is where i can put text in the launcher
    JTextField jText;
    //this is the exit button
    JButton startButton;
    JButton exit;
    boolean startGame = false;
    Launcher( int scale){
        //create button label
        startButton = new JButton("Start");
        //add an action listener
        startButton.addActionListener(this);
        //label
        exit = new JButton("Exit");
        //listener
        exit.addActionListener(this);
        //set the text of the text in launcher
        jText = new JTextField("Click start to start my game!");
        //make it so the user can't change the text
        jText.setEditable(false);
        //add a flow layout
        setLayout(new FlowLayout());
        //add comps to JFrame
        add(startButton);
        add(exit);
        add(jText);
        //title the frame
        setTitle("MyGame");
        //size of the frame
        setSize(200 * scale, 100 * scale);
        //what should the program do on close?
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        //make launcher visible
        setVisible(true);
    }
    //action listener
    public void actionPerformed(ActionEvent evt) {
        Object source = new Object();
        //get source of event
        source = evt.getSource();
        //if the source is my start button start the game
        if (source == startButton) {
            System.out.print("Game has started!\n");
            setVisible(false);
            startGame = true;
            Main.start();
        }
        //if source is exit quit the program
        else if(source == exit) {
            System.out.print("Exiting the program. \n");
            System.exit(0);
        }
        //this should not exec
        else System.out.print("error!\n");
    }
}
