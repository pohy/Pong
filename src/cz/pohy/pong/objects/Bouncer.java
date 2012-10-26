package cz.pohy.pong.objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

import cz.pohy.pong.Pong;

public class Bouncer {
	private float x, y;
	private float width, height;
	private float velocity, prevY;
	
	private ShapeRenderer shapeRenderer;
	private Color color;
	
	private int collisionState;
	
	public Bouncer(float width, float height) {
		this.width = width;
		this.height = height;
		
		shapeRenderer = new ShapeRenderer();
		color = new Color(1.0f, 1.0f, 1.0f, 1.0f);
	}
	
	public void setColor(float r, float g, float b, float a) {
		color.set(r, g, b, a);
	}
	
	public float getX() {
		return x;
	}
	
	public float getY() {
		return y;
	}
	
	public void move(float x, float y, Ball ball) {
		if(y >= Gdx.graphics.getHeight() - height / 2)
			y = Gdx.graphics.getHeight() - height / 2;
		if(y <= 0 + height / 2)
			y = 0 + height / 2;
		
		if(ball.getY() < y + height / 2 && ball.getY() + ball.getHeight() > y - height / 2) {
			collisionState = 1;
			if(ball.getX() + ball.getWidth() > x) {
				ball.collision(velocity);
				collisionState = 2;
			}
		} else {
			collisionState = 0;
		}
		
		velocity = prevY - y;
		
		Gdx.app.log(Pong.LOG, "Velocity: " + velocity);
		
		this.x = x;
		this.y = y - height / 2;
		
		prevY = y;
	}
	
	public void render() {
		shapeRenderer.begin(ShapeType.FilledRectangle);
			shapeRenderer.setColor(color);
			shapeRenderer.filledRect(x, y, width, height);
		shapeRenderer.end();
		
		shapeRenderer.begin(ShapeType.Rectangle);
			switch(collisionState) {
			case 0:
				shapeRenderer.setColor(0.0f, 0.0f, 1.0f, 1.0f);
				break;
			case 1:
				shapeRenderer.setColor(0.0f, 1.0f, 0.0f, 1.0f);
				break;
			case 2:
				shapeRenderer.setColor(1.0f, 0.0f, 0.0f, 1.0f);
				break;
			}
			shapeRenderer.rect(x, y, width, height);
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
