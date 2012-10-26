package cz.pohy.pong.other;

public class Point {
	private float x, y;
	
	public Point() {
		
	}
	
	public float getX() {
		return x;
	}
	
	public float getY() {
		return y;
	}
	
	public void setX(float x) {
		this.x = x;
	}
	
	public void setY(float y) {
		this.y = y;
	}
	
	public void move(float x, float y) {
		this.x = x;
		this.y = y;
	}
}
