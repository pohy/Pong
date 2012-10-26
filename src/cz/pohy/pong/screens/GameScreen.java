package cz.pohy.pong.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import cz.pohy.pong.Pong;
import cz.pohy.pong.objects.Ball;
import cz.pohy.pong.objects.Bouncer;
import cz.pohy.pong.other.Point;

public class GameScreen implements Screen {
	
	private Pong game;
	
	private SpriteBatch batch;
	private BitmapFont font;
	private ShapeRenderer shapeRenderer;
	
	private float width, height;
	
	private Point cursor;
	
	private Bouncer pBouncer;
	private Ball ball;
	
	private String textToDisplay;
	
	public GameScreen(Pong game) {
		this.game = game;
	}

	@Override
	public void render(float delta) {
		textToDisplay = 
				"Ball speed: " + ball.getHSpeed() 
				+ " FPS: " + Gdx.graphics.getFramesPerSecond();
		
		width = Gdx.graphics.getWidth();
		height = Gdx.graphics.getHeight();
		
		cursor.setX(Gdx.input.getX());
		cursor.setY(Math.abs(Gdx.input.getY()-height));
		
		pBouncer.move(440.0f, cursor.getY(), ball);
		ball.move();
		
		Gdx.gl.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		
		batch.begin();
			pBouncer.render();
			ball.render();
			
//			font.setColor(1.0f, 1.0f, 1.0f, 1.0f);
//			font.draw(batch, textToDisplay, 5, Gdx.graphics.getHeight() - 5);
		batch.end();
	}

	@Override
	public void resize(int width, int height) {
	}

	@Override
	public void show() {
		shapeRenderer = new ShapeRenderer();
		batch = new SpriteBatch();
		font = new BitmapFont(Gdx.files.internal("data/calibri.fnt"), Gdx.files.internal("data/calibri.png"), false);
		
		cursor = new Point();
		
		pBouncer = new Bouncer(20, 80);
		ball = new Ball(20, 20, 1);
	}

	@Override
	public void hide() {
	}

	@Override
	public void pause() {
	}

	@Override
	public void resume() {
	}

	@Override
	public void dispose() {
		pBouncer.dispose();
		ball.dispose();
		
		batch.dispose();
		shapeRenderer.dispose();
		game.dispose();
	}

}
