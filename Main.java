package konnorscomputers;

/**
 * Created by konnor on 6/9/14.
 */

import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import  org.lwjgl.opengl.*;
import org.lwjgl.util.vector.Vector3f;

import  static  org.lwjgl.opengl.GL11.*;

public class Main {
    static Vector3f camLocation = new Vector3f(0,0,0);
    static Camera cam = new Camera();
    static int mouseDx;
    static  int mouseDy;
    static Inventory inv;
    //creates a launcher that runs start() when the start button on the launcher is pressed
    public static Launcher launcher;
    static LwjglDisplay display;
    public static void start() {
        display = new LwjglDisplay(800,600);

    }

    public static void main(String[] args) {
        launcher = new Launcher(1);
    }
    //is under Display not close requested
    static void updateApp(){
        glClear(GL_COLOR_BUFFER_BIT);
        draw();
        cam.location = camLocation;
        inv.itemIDSelected();
        Display.update();
        Display.sync(60);
        keys();
        mouse();
    }
    //is before close not requested in the class LwjglDisplay
    static void initApp(){
        cam.setDefaultLocation(new Vector3f(0,0,0));
        inv = new Inventory();
        initGL();
    }
    static void initGL(){
        glMatrixMode(GL_PROJECTION);
        glLoadIdentity(); // Resets any previous projection matrices
        glOrtho(0, 800, 600, 0, 1, -1);
        glMatrixMode(GL_MODELVIEW);
    }
    static void keys(){
        if(Keyboard.isKeyDown((Keyboard.KEY_M))){
            //create jframe for settings

        }
        if(Keyboard.isKeyDown(Keyboard.KEY_W)){
            cam.location = cam.moveForward();
        }
        if(Keyboard.isKeyDown(Keyboard.KEY_A)){
            cam.location = cam.moveLeft();
        }
        if(Keyboard.isKeyDown(Keyboard.KEY_S)){
            cam.location = cam.moveBackward();
        }
        if(Keyboard.isKeyDown(Keyboard.KEY_D)){
            cam.location = cam.moveRight();
        }
    }
    static void mouse(){
            //i get input from the mouse wheel and use it to switch states
            int wheelState = Mouse.getDWheel();
            if (wheelState < 0) {
                inv.itemSlotSelected -= 1;
                if(inv.itemSlotSelected < inv.maxItemSlots - inv.maxItemSlots +1){
                    inv.itemSlotSelected = 1;
                }
                //System.out.println("the item selected:"+inv.itemSlotSelected);
            }
            if (wheelState > 0){
                inv.itemSlotSelected += 1;
                if(inv.itemSlotSelected > inv.maxItemSlots){
                    inv.itemSlotSelected = inv.maxItemSlots;
                }
                //System.out.println("the item selected:"+inv.itemSlotSelected);
            }
        //mouse coordinates
        mouseDx = Mouse.getDX();
        mouseDy = Mouse.getDY();
    }
    static void draw(){
        glBegin(GL_LINES);
            glVertex2f(100,100);
            glVertex2f(500,500);
        glEnd();
    }



}
