package com.mania.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.mania.game.Constants;
import com.mania.game.Mania;

/**
 * Created by PC on 9/7/2016.
 */
public class SplashScreen implements Screen {

    private Mania game;

    public SplashScreen(Mania game){
        this.game = game;

        this.game.cam.setToOrtho(false, Constants.WIDTH/2, Constants.HEIGHT/2);
    }


    @Override
    public void show() {

        game.assets.load();
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0,1,0,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        game.batch.setProjectionMatrix(game.cam.combined);
        game.batch.begin();
        game.batch.end();
        if(game.assets.assetManager.update()){
            game.setScreen(new MenuScreen(game));
        }
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
