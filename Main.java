package konnorscomputers;

/**
 * Created by konnor on 6/9/14.
 */

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.lwjgl.Sys;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import  org.lwjgl.opengl.*;
import org.lwjgl.util.vector.Vector3f;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;

import static org.lwjgl.util.glu.GLU.gluPerspective;
import static  org.lwjgl.opengl.GL11.*;
public class Main 
{
	//this is totally a contribution
	static Cube test;
	static long currentTime;
	public enum State 
	{
		INTRO, GAME, MAIN_MENU;
	}
	//time since last frame
	private static long lastFrame;
	//get the time
	private static long getTime() 
	{
		return (Sys.getTime() * 1000) / Sys.getTimerResolution();
	}
	//get the delta
	private static int getDelta()
	{
		currentTime = getTime();
		int delta = (int) (currentTime - lastFrame);
		lastFrame = getTime();
		return delta;
	}
	static Camera cam = new Camera(0,0,0);
    static int mouseDx;
    static  int mouseDy;
    static Inventory inv;
    static float mouseSensitivity = 0.05f;
    static float movementSpeed = 10 * .001f;
    static LwjglDisplay display;
    public static void start() {
        display = new LwjglDisplay(1280,720);

    }

    public static void main(String[] args) {
        start();
    }
    static //is under Display not close requested
  	float dt  = 0.0f;
    static long lastFPS = getTime();
    static void updateApp()
    { 
    	Mouse.setGrabbed(true);
        glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
   	    updateFPS();
    	int delta = getDelta();
        inv.itemIDSelected();
        GL11.glLoadIdentity();  
         cam.lookThrough();
        GL11.glTranslatef(0f,0.0f,-15f);    
        test.draw();
        Display.update();
        Display.sync(20000);

        mouse();
        keys();
    }
    //is before close not requested in the class LwjglDisplay
	static Texture texture;
    static void initApp()
    {
    	test  = new Cube(0,3,0);
        initGL();
    	System.out.println("OpenGL version: " + GL11.glGetString(GL11.GL_VERSION));
    	lastFrame = getTime();
        inv = new Inventory();
    }
    static void initGL()
    {
        GL11.glMatrixMode(GL_PROJECTION);
        GL11.glLoadIdentity(); // Resets any previous projection matrices
        gluPerspective((float) 90f, 1280f/720f,0.01f,100f);
        GL11.glMatrixMode(GL_MODELVIEW);
    }
    static void keys()
    {
        if(Keyboard.isKeyDown((Keyboard.KEY_M))){
            //create jframe for settings
        	// change game state to pause(MAIN_MENU)

        }
        if (Keyboard.isKeyDown(Keyboard.KEY_W))//move forward
        {
            cam.walkForward(movementSpeed*getDelta());
        }
        if (Keyboard.isKeyDown(Keyboard.KEY_S))//move backwards
        {
            cam.walkBackwards(movementSpeed*getDelta());
        }
        if (Keyboard.isKeyDown(Keyboard.KEY_A))//strafe left
        {
           cam.strafeLeft(movementSpeed*getDelta());
        }
        if (Keyboard.isKeyDown(Keyboard.KEY_D))//strafe right
        {
            cam.strafeRight(movementSpeed*getDelta());
        }
    }
    static void mouse()
    {
            //i get input from the mouse wheel and use it to switch states
            int wheelState = Mouse.getDWheel();
            if (wheelState < 0) 
            {
                inv.itemSlotSelected -= 1;
                if(inv.itemSlotSelected < inv.maxItemSlots - inv.maxItemSlots +1)
                {
                    inv.itemSlotSelected = 1;
                }
                //System.out.println("the item selected:"+inv.itemSlotSelected);
            }
            if (wheelState > 0)
            {
                inv.itemSlotSelected += 1;
                if(inv.itemSlotSelected > inv.maxItemSlots){
                    inv.itemSlotSelected = inv.maxItemSlots;
                }
                //System.out.println("the item selected:"+inv.itemSlotSelected);
            }
        //mouse coordinates
            mouseDx = Mouse.getDX();
            mouseDy = -Mouse.getDY();
          //control camera yaw from x movement from the mouse
            cam.yaw(mouseDx * mouseSensitivity);
            //control camera pitch from y movement from the mouse
            cam.pitch(mouseDy * mouseSensitivity);

     

    }
    /**
     * Calculate the FPS and set it in the title bar
     */
   static  long fps;
    public static void updateFPS() 
    {
        if (getTime() - lastFPS > 1000)
        {
            Display.setTitle("Welcome to my Game! Your fps is:" + fps); 
            fps = 0; //reset the FPS counter
           lastFPS += 1000; //add one second
        }
        fps++;
    }
}
