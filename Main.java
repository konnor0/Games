package konnorscomputers;

/**
 * Created by konnor on 6/9/14.
 */

import static org.lwjgl.opengl.GL11.*;

import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import  org.lwjgl.opengl.*;

public class Main {
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
        Display.update();
        Display.sync(60);
        keys();
        mouse();
    }
    //is before close not requested in the class LwjglDisplay
    static void initApp(){
        inv = new Inventory();
        initGL();
    }
    static void initGL(){

    }
    static void keys(){
        if(Keyboard.isKeyDown(Keyboard.KEY_W)){

        }
        if(Keyboard.isKeyDown(Keyboard.KEY_A)){

        }
        if(Keyboard.isKeyDown(Keyboard.KEY_S)){

        }
        if(Keyboard.isKeyDown(Keyboard.KEY_D)){

        }
    }
    static void mouse(){
            int wheelState = Mouse.getDWheel();
            if (wheelState < 0) {
                inv.itemSlotSelected -= 1;
                if(inv.itemSlotSelected < inv.maxItemSlots - inv.maxItemSlots +1){
                    inv.itemSlotSelected = 1;
                }
                System.out.println("the item selected:"+inv.itemSlotSelected);
                //System.out.println("Down");
            }
            if (wheelState > 0){
                inv.itemSlotSelected += 1;
                if(inv.itemSlotSelected > inv.maxItemSlots){
                    inv.itemSlotSelected = inv.maxItemSlots;
                }
                System.out.println("the item selected:"+inv.itemSlotSelected);
                //System.out.println("Up");
            }
    }
}
