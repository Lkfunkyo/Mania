package com.mania.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mania.game.Screens.Assets;
import com.mania.game.Screens.MenuScreen;
import com.mania.game.Screens.PlayScreen;
import com.mania.game.Screens.SplashScreen;

public class Mania extends Game {

	public SpriteBatch batch;
	public Assets assets;

	@Override
	public void create () {
		assets = new Assets();
		batch = new SpriteBatch();
		setScreen(new MenuScreen(this));
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		assets.dispose();
	}
}
