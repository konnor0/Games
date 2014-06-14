package konnorscomputers;

import konnorscomputers.Entitys.Entity;
import static org.lwjgl.opengl.GL11.*;

public class Cube implements Entity {
	float x;
	float y;
	float z;
	public Cube(float x,float y,float z){
		this.x = x;
		this.y = y;
		this.z = z;
	}
	public float getX() {
		return x;
	}

	public float getY() {
		return y;
	}

	public float getZ() {
		return z;
	}

	public void setX(float x) {
		this.x = x;

	}

	public void setY(float y) {
		this.y  =   y;

	}

	public void setZ(float z) {
		this.z = z;

	}

	public void setLocation(float x, float y, float z) {
		this.x =x;
		this.y =y;
		this.z = z;

	}

	public void setUp() {
		//setup

	}
	public void destroy() {
		//destroy the cube
	}

	public void draw() {
		//draw the cube
		glBegin(GL_QUADS);
		//top of cube!
			glVertex3f(x,y,z-2);
			glVertex3f(x-2,y,z-2);
			glVertex3f(x-2,y,z);
			glVertex3f(x-2,y,z);
			//bottom!!
			glVertex3f(x,y-2,z);
			glVertex3f(x-2,y-2,z);
			glVertex3f(x-2,y-2,z-2);
			glVertex3f(x,y-2,z-2);
			//front
			glVertex3f(x,y,z);
			glVertex3f(x-2,y,z);
			glVertex3f(x-2,y-2,z);
			glVertex3f(x,y-2,z);
			//back
			glVertex3f(x,y-2,z-2);
			glVertex3f(x-2,y-2,z-2);
			glVertex3f(x-2,y,z);
			glVertex3f(x,y,z-2);
			//left
			glVertex3f(x-2,y,z);
			glVertex3f(x-2,y,z-2);
			glVertex3f(x-2,y-2,z-2);
			glVertex3f(x-2,y-2,z);
			//right
			glVertex3f(x,y,z-2);
			glVertex3f(x,y,z);
			glVertex3f(x,y-2,z);
			glVertex3f(x,y-2,z-2);
		glEnd();
	}

}
