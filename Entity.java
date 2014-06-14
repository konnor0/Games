package konnorscomputers.Entitys;

public interface Entity {
		public float getX();
		public float getY();
		public float getZ();
	    public void setX(float x);
	    public void setY(float y);
	    public void setZ(float z);
	    public void setLocation(float x, float y, float z);
		public void setUp();
		public void destroy();
		public void draw();
}
