/*
	*Make all measurements fit the orthographic camera instead of the Constants.WIDTH && Constants.HEIGHT for example:
	Body.stayInScreen(), or Body.outOfScreen()

	*Check for other occurrences of the Constant class dimensions being used instead of the cam dimensions
 */

package com.mania.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mania.game.Screens.PlayScreen;
import com.mania.game.Handlers.Assets;

public class Mania extends Game {

	public OrthographicCamera cam;

	public SpriteBatch batch;
	public Assets assets;
	public Texture body;

	@Override
	public void create () {
		assets = new Assets();
		batch = new SpriteBatch();
		cam = new OrthographicCamera();
		cam.setToOrtho(false, 1280, 720);
		

		body = new Texture("badlogic.jpg");

		setScreen(new PlayScreen(this));
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		body.dispose();
		assets.dispose();
	}
}
