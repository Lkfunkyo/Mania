package com.mania.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.mania.game.Constants;
import com.mania.game.Mania;
import com.mania.game.Sprites.Body;

import java.util.ArrayList;

/**
 * Created by PC on 9/7/2016.
 */
public class PlayScreen implements Screen {
    public Mania game;
    public ArrayList<Body> bodies;

    public PlayScreen(Mania game){
        this.game = game;

        this.game.cam.setToOrtho(false, Constants.WIDTH/2, Constants.HEIGHT/2);
        this.bodies = new ArrayList<Body>();
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 0);
        Gdx.gl.glClear(0);


        for(Body body: this.bodies){
            body.run();

            if(body.outOfScreen()){
                this.bodies.remove(body);
            }
        }

        game.batch.begin();



        game.batch.end();
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
