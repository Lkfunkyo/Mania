//Have to arrange bodies by z-value. Further objects get shown behind closer ones
// consider adding bodyHandler class?

//Make targetDestroyed animation

package com.mania.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mania.game.Screens.SplashScreen;
import com.mania.game.Handlers.Assets;

public class Mania extends Game {

	public OrthographicCamera cam;

	public SpriteBatch batch;
	public Assets assets;
	public Texture target, projectile;

	@Override
	public void create () {
		assets = new Assets();
		batch = new SpriteBatch();
		cam = new OrthographicCamera();
		cam.setToOrtho(false, Constants.WIDTH, Constants.HEIGHT);
		

		target = new Texture(Gdx.files.internal("bluetarget.png"));
		projectile = new Texture(Gdx.files.internal("bullet.png"));

		setScreen(new SplashScreen(this));
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		target.dispose();
		assets.dispose();
	}
}
