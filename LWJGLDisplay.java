package konnorscomputers;

import org.lwjgl.LWJGLException;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
/**
 * Created by konnor on 6/9/14.
 */
public class LwjglDisplay {
    //I create a constructor with the height of the window and width as prams
    LwjglDisplay(int width,int height) {
        try {
            //i try to create the display
            Display.setTitle("MyGame");
            Display.setDisplayMode(new DisplayMode(width, height));
            Display.create();
        } catch (LWJGLException e) {
            // if the display can't be created i print the error and exit the program
            e.printStackTrace();
            System.exit(0);
        }
        //i call the init of the app & openGL
        Main.initApp();
        //while esc & display is not trying to be closed i call the update loop in main
        while (!Display.isCloseRequested() && !Keyboard.isKeyDown(Keyboard.KEY_ESCAPE)) {
            Main.updateApp();
            }
        //if esc or someone calls to close this code will exec
        System.out.println("Quitting to launcher.");
        Display.destroy();
        Main.launcher.setVisible(true);
        }
    }
