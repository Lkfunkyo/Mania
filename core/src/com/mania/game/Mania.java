package com.mania.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mania.game.Screens.SplashScreen;

public class Mania extends Game {

	public OrthographicCamera cam;

	public SpriteBatch batch;

	@Override
	public void create () {
		batch = new SpriteBatch();
		cam = new OrthographicCamera();

		setScreen(new SplashScreen(this));
	}
	
	@Override
	public void dispose () {
		batch.dispose();
	}
}
