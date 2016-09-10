package com.mania.game.Screens;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.math.Vector3;
import com.mania.game.Constants;
import com.mania.game.Mania;
import com.mania.game.Sprites.Body;

/**
 * Created by PC on 9/7/2016.
 */
public class SplashScreen implements Screen {

    private Mania game;
    private Body body;

    public SplashScreen(Mania game){
        this.game = game;
        this.game.cam.setToOrtho(false, Constants.WIDTH/2, Constants.HEIGHT/2);
    }


    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {

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
