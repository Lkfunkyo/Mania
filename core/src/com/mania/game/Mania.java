package com.mania.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mania.game.Screens.PlayScreen;
import com.mania.game.Screens.SplashScreen;

public class Mania extends Game {
	public static final int WIDTH = 480;
	public static final int HEIGHT = 800;

	public Texture img;
	public SpriteBatch batch;

	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("badlogic.jpg");

		setScreen(new SplashScreen(this));
	}

	public Mania() {
		super();
	}

	public void render(){
		super.render();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}
