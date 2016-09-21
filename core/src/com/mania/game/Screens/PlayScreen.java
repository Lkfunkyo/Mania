package com.mania.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.math.Vector3;
import com.mania.game.Constants;
import com.mania.game.Mania;
import com.mania.game.Math;
import com.mania.game.Sprites.Projectile;
import com.mania.game.Sprites.Target;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by PC on 9/7/2016.
 */
public class PlayScreen implements Screen {
    public Mania game;


    public ArrayList<Target> targets;
    public Projectile projectile;

    public boolean pSwitch;

    public Random random;
    public Vector3 mouse;

    public PlayScreen(Mania game){
        this.game = game;
    }

    @Override
    public void show() {
        this.game.cam.setToOrtho(false, Constants.WIDTH, Constants.HEIGHT);
        this.targets = new ArrayList<Target>();

        this.random = new Random();

        projectile = new Projectile(new Vector3(), game.projectile, game.cam);

        for(int i = 0; i < 100; i++){
            this.targets.add(new Target(new Vector3(this.random.nextInt((int) game.cam.viewportWidth), this.random.nextInt((int) game.cam.viewportHeight), this.random.nextInt(Constants.DEPTH)), game.target, game.cam));
        }

        for(Target target: this.targets){
            target.setType(random.nextInt(4));
            target.setMaxDepth(Constants.DEPTH-5);
        }

        pSwitch = false;
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(Math.map(0, 0, 255, 0, 1), Math.map(200, 0, 255, 0, 1), Math.map(240, 0, 255, 0, 1), 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);


        for(Target target: this.targets){
//            mouse = new Vector3((float) Gdx.input.getX(), (float) (game.cam.viewportHeight-Gdx.input.getY()), (float) (Constants.DEPTH*0.85));
//            mouse.sub(target.pos.x, target.pos.y, target.pos.z);
//            mouse.nor();
//            mouse.z /= 5;
//
//            target.applyForce(mouse);
            target.vel.limit(15);

            target.run();
            target.stayInScreen();

            if(target.outOfScreen()){
                this.targets.remove(target);
            }


        }

        if(Gdx.input.justTouched()){
            projectile = new Projectile(new Vector3(Gdx.input.getX(), game.cam.viewportHeight-Gdx.input.getY(), 0), game.projectile, game.cam);

            pSwitch = true;
        }

        game.batch.setProjectionMatrix(game.cam.combined);
        game.batch.begin();


        for(Target target: this.targets){
            target.display(game.batch);
        }

        if(pSwitch && projectile.outOfScreen() == false){
            projectile.display(game.batch);
            projectile.launch();
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
