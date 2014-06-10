package konnorscomputers;

import org.lwjgl.util.vector.Vector3f;

/**
 * Created by konnor on 6/10/14.
 */
public class Camera {
    Vector3f defaultLocation;
    Vector3f location;
    Vector3f setDefaultLocation(Vector3f defLoc){
        defaultLocation = new Vector3f(defLoc);
        return defaultLocation;
    }
    Camera(){
        returnToDefaultLocation();
    }

    Vector3f returnToDefaultLocation(){
        location = defaultLocation;
        return location;
    }
    Vector3f getLocation(){
        return location;
    }
    Vector3f moveLeft(){
        return location;
    }
    Vector3f moveRight(){
        return location;
    }
    Vector3f moveForward(){
        return location;
    }
    Vector3f moveBackward(){
        return location;
    }

}
