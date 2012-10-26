package cz.pohy.pong.objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

public class Ball {
	private float x, y;
	private float width, height;
	private float vSpeed, hSpeed;
	
	private ShapeRenderer shapeRenderer;
	private Color color;
	
	public Ball(float width, float height, float hSpeed) {
		this.width = width;
		this.height = height;
		this.hSpeed = hSpeed;
		vSpeed = hSpeed;
		
		x = Gdx.graphics.getWidth() / 2;
		y = Gdx.graphics.getHeight() / 2;
		
		shapeRenderer = new ShapeRenderer();
		color = new Color(0.8f, 0.8f, 1.0f, 1.0f);
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
	
	public float getWidth() {
		return width;
	}
	
	public float getHeight() {
		return height;
	}
	
	public float getHSpeed() {
		return hSpeed;
	}
	
	public float getVSpeed() {
		return vSpeed;
	}
	
	public void setHSpeed(float hSpeed) {
		this.hSpeed = hSpeed;
	}
	
	public void setVSpeed(float vSpeed) {
		this.vSpeed = vSpeed;
	}
	
	public void move() {
		if(x < 0) {
			x = 0;
			hSpeed = -hSpeed;
		}
		if(x + width > Gdx.graphics.getWidth()) {
			x = Gdx.graphics.getWidth() / 2;
			hSpeed = -1;
			vSpeed = -1;
		}
		if(y < 0) {
			y = 0;
			vSpeed = -vSpeed;
		}
		if(y + height > Gdx.graphics.getHeight()) {
			y = Gdx.graphics.getHeight() - height;
			vSpeed = -vSpeed;
		}
		
		x += hSpeed;
		y += vSpeed;
	}
	
	public void setColor(float r, float g, float b, float a) {
		color.set(r, g, b, a);
	}
	
	public void collision(float velocity) {
		vSpeed += velocity / 2;
		hSpeed = -hSpeed + velocity / 2;
		Gdx.input.vibrate(10);
	}
	
	public void render() {
		shapeRenderer.begin(ShapeType.FilledRectangle);
			shapeRenderer.setColor(color);
			shapeRenderer.filledRect(x, y, width, height);
		shapeRenderer.end();
		
		shapeRenderer.begin(ShapeType.FilledCircle);
			shapeRenderer.setColor(1.0f, 0.0f, 0.0f, 1.0f);
			shapeRenderer.filledCircle(x, y, 3);
		shapeRenderer.end();
	}
	
	public void dispose() {
		shapeRenderer.dispose();
	}
}
