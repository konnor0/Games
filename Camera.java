package konnorscomputers;

import org.lwjgl.opengl.GL11;
import org.lwjgl.util.vector.Vector3f;

public class Camera {
    private Vector3f    location    = null;
    private float       yaw         = 0.0f;
    private float       pitch       = 0.0f;
    public Camera(float x, float y, float z)
    {
        location = new Vector3f(x, y, z);
    }
    public void yaw(float amount)
    {
        yaw += amount;
    }
     
    public void pitch(float amount)
    {
        pitch += amount;
    }
    public void walkForward(float distance)
    {
        location.x -= distance * (float)Math.sin(Math.toRadians(yaw));
        location.z += distance * (float)Math.cos(Math.toRadians(yaw));
    }
     
    public void walkBackwards(float distance)
    {
        location.x += distance * (float)Math.sin(Math.toRadians(yaw));
       location.z -= distance * (float)Math.cos(Math.toRadians(yaw));
    }
     
    public void strafeLeft(float distance)
    {
        location.x -= distance * (float)Math.sin(Math.toRadians(yaw-90));
        location.z += distance * (float)Math.cos(Math.toRadians(yaw-90));
    }
     
    public void strafeRight(float distance)
    {
        location.x -= distance * (float)Math.sin(Math.toRadians(yaw+90));
       location.z += distance * (float)Math.cos(Math.toRadians(yaw+90));
    }
    public void lookThrough()
    {
        GL11.glRotatef(pitch, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(yaw, 0.0f, 1.0f, 0.0f);
        GL11.glTranslatef(location.x, location.y, location.z);
    }
 
}
