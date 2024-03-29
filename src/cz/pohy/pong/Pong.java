package cz.pohy.pong;

import com.badlogic.gdx.Game;

import cz.pohy.pong.screens.GameScreen;

public class Pong extends Game {
	
	public static final String VERSION = "0.0.1";
	public static final String LOG = "Pong";
	
	@Override
	public void create() {		
		setScreen(new GameScreen(this));
	}

	@Override
	public void dispose() {
		super.dispose();
	}

	@Override
	public void render() {		
		super.render();
	}

	@Override
	public void resize(int width, int height) {
		super.resize(width, height);
	}

	@Override
	public void pause() {
		super.pause();
	}

	@Override
	public void resume() {
		super.resume();
	}
}
