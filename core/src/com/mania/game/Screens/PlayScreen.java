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

    public int r, g, b;

    public ArrayList<Target> targets;
    public ArrayList<Projectile> projectiles;

    public boolean pSwitch;

    public Random random;
    public Vector3 mouse;

    public PlayScreen(Mania game){
        this.game = game;
    }

    @Override
    public void show() {
        r = 0;
        g = 220;
        b = 240;


        this.game.cam.setToOrtho(false, Constants.WIDTH, Constants.HEIGHT);


        this.targets = new ArrayList<Target>();
        this.projectiles = new ArrayList<Projectile>();

        this.random = new Random();

        for(int i = 0; i < 150; i++){
            this.targets.add(new Target(new Vector3(this.random.nextInt((int) game.cam.viewportWidth), this.random.nextInt((int) game.cam.viewportHeight)+game.cam.viewportHeight/4, this.random.nextInt(Constants.DEPTH)), game.target, game.cam));
            //this.targets.add(new Target(new Vector3(game.cam.viewportWidth/2, game.cam.viewportHeight/2, Constants.DEPTH/2), game.target, game.cam));

        }

        for(Target target: this.targets){
            //target.setType(random.nextInt(4));
            target.setMaxDepth(Constants.DEPTH-5);
        }

        pSwitch = false;
    }

    @Override
    public void render(float delta) {



        Gdx.gl.glClearColor(Math.map(r, 0, 255, 0, 1), Math.map(g, 0, 255, 0, 1), Math.map(b, 0, 255, 0, 1), 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        b = 240;
        //projectile.vel.limit(3);

        for(Target target: this.targets){
            mouse = new Vector3((float) Gdx.input.getX(), (float) (game.cam.viewportHeight-Gdx.input.getY()), (float) (Constants.DEPTH*0.50));
            mouse.sub(target.pos.x, target.pos.y, target.pos.z);
            mouse.nor();
            mouse.z /= 5;

            //target.applyForce(mouse);
            target.vel.limit(15);

            target.run();
            target.stayInScreen();
            targetOut(target, targets.indexOf(target));
        }

        for(int i = targets.size()-1; i >= 0; i--){
            for(Projectile projectile: this.projectiles) {
                if (targets.get(i).isHit(projectile)) {
                    b = 240;
                    targets.remove(i);
                    b = 0;

                }
            }
        }

        if(Gdx.input.justTouched()){
            projectiles.add(new Projectile(new Vector3(Gdx.input.getX(), game.cam.viewportHeight-Gdx.input.getY(), 0), game.projectile, game.cam));
        }

        game.batch.setProjectionMatrix(game.cam.combined);
        game.batch.begin();


        for(Target target: this.targets){
            target.display(game.batch);
        }

        for(Projectile projectile: this.projectiles){
            if(projectile.outOfScreen() == false) {
                projectile.display(game.batch);
                projectile.launch();
            } else {

            }
        }



            for (int i = projectiles.size()-1; i > 0; i--) {
                if (projectiles.get(i).outOfScreen()) {
                    projectiles.remove(i);
                }
            }

        game.batch.end();
    }

    public void targetOut(Target t, int index){
        for(int i = 0; i < t.outOfScreen().size(); i++){
            if(t.outOfScreen().get(i) == "x"){

            }
            if(t.outOfScreen().get(i) == "y"){
                targets.remove(index);
            }
            if(t.outOfScreen().get(i) == "z"){

            }
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
