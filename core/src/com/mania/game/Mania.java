//fix collision detection between projectile and target class (located in the target class: isHit())


package com.mania.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mania.game.Screens.PlayScreen;
import com.mania.game.Handlers.Assets;
import com.mania.game.Screens.SplashScreen;

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
		cam.setToOrtho(false, 1280, 720);
		

		target = new Texture("target.png");
		projectile = new Texture("bullet.png");

		setScreen(new SplashScreen(this));
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		target.dispose();
		assets.dispose();
	}
}
