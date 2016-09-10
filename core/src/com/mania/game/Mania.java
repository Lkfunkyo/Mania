package com.mania.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g3d.utils.shapebuilders.ConeShapeBuilder;
import com.mania.game.Screens.Assets;
import com.mania.game.Screens.MenuScreen;
import com.mania.game.Screens.SplashScreen;

public class Mania extends Game {

	public OrthographicCamera cam;

	public SpriteBatch batch;
	public Assets assets;

	@Override
	public void create () {
		assets = new Assets();
		batch = new SpriteBatch();
		cam = new OrthographicCamera();
		cam.setToOrtho(false, Constants.WIDTH, Constants.HEIGHT);
		
		setScreen(new SplashScreen(this));
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		assets.dispose();
	}
}
