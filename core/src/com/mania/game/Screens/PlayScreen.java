package com.mania.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.math.Vector3;
import com.mania.game.Constants;
import com.mania.game.Mania;
import com.mania.game.Math;
import com.mania.game.Sprites.Body;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by PC on 9/7/2016.
 */
public class PlayScreen implements Screen {
    public Mania game;
    public ArrayList<Body> bodies;
    public Random random;
    public Vector3 mouse;

    public PlayScreen(Mania game){
        this.game = game;

        this.game.cam.setToOrtho(false, Constants.WIDTH, Constants.HEIGHT);
        this.bodies = new ArrayList<Body>();

        this.random = new Random();

        for(int i = 0; i < 10; i++){
            this.bodies.add(new Body(new Vector3(this.random.nextInt((int) game.cam.viewportWidth), this.random.nextInt((int) game.cam.viewportHeight), 0), (float) 1, game.body, game.cam));
        }

        for(Body body: this.bodies){
            //body.type = random.nextInt(4);
        }
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(Math.map(0, 0, 255, 0, 1), Math.map(200, 0, 255, 0, 1), Math.map(240, 0, 255, 0, 1), 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);


        for(Body body: this.bodies){
            mouse = new Vector3((float) Gdx.input.getX(), (float) (game.cam.viewportHeight-Gdx.input.getY()), (float) 0);
            mouse.sub(body.pos);
            mouse.nor();

            body.applyForce(mouse);
            body.vel.limit(15);

            body.run();
            body.stayInScreen();

            if(body.outOfScreen()){
                this.bodies.remove(body);
            }
        }
        game.batch.setProjectionMatrix(game.cam.combined);
        game.batch.begin();


        for(Body body: this.bodies){
            body.display(game.batch);
        }

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
