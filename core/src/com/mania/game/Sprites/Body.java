package com.mania.game.Sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;
import com.mania.game.Constants;
import com.mania.game.Math;

/**
 * Created by PC on 9/9/2016.
 */
public class Body {
    private Vector3 pos;
    private Vector3 vel;
    private Vector3 accel;

    private float size;

    private float w, h;

    public int type;

    private Texture img;

    public Body(Vector3 pos, float size, Texture img){
        this.pos = pos;
        this.vel = new Vector3(0, 0, 0);
        this.accel = new Vector3(0, 0, 0);

        this.size = size;
        this.img = img;

        this.w = img.getWidth();
        this.h = img.getHeight();

        this.type = 0;

        System.out.println(this.type);
    }

    public void setType(int type){
        this.type = type;
    }

    public void display(SpriteBatch batch){
        batch.draw(this.img, this.pos.x-this.w/2-this.size, this.pos.y-this.h/2-this.size, this.pos.x-this.w/2+this.size, this.pos.y-this.h/2+this.size);
    }

    public void run(){
        this.vel.add(this.accel);
        this.pos.add(this.vel);

        this.accel.scl(0);

        this.applyForce(this.forceList(this.type));
    }

    public boolean outOfScreen(){
        if(this.pos.x > Constants.WIDTH + this.w/2 || this.pos.x < -this.w/2 || this.pos.y > Constants.HEIGHT + this.h/2 || this.pos.y < -this.h/2){
            return true;
        } else{
            return false;
        }
    }

    public void stayInScreen(){
        if(this.pos.x > Constants.WIDTH - this.w/2 || this.pos.x < this.w/2){
            this.vel.x *= -1;
        }

        if(this.pos.y > Constants.HEIGHT - this.h/2 || this.pos.y < this.h/2){
            this.vel.y *= -1;
        }



        this.pos = new Vector3(Math.constrain(this.pos.x, 0, Constants.WIDTH), Math.constrain(this.pos.y, 0, Constants.HEIGHT), 0);
    }

    public void applyForce(Vector3 force){
        this.accel.add(force);
    }

    public Vector3 forceList(int num){
        switch(num){
            case 0: return this.runStraight();
            case 1: return this.runCircle();
            case 2: return this.runWave();
            case 3: return this.runBackAndForth();

            default: return new Vector3(0, 0, 0);
        }
    }

    public Vector3 runStraight(){
        Vector3 force = new Vector3(1, 0, 0);
        force.nor();

        return force;
    }

    public Vector3 runCircle(){
        Vector3 force = new Vector3(0, 0, 0);
        force.nor();

        return force;
    }

    public Vector3 runWave(){
        Vector3 force = new Vector3(1, 0, 0);
        force.nor();

        return force;
    }

    public Vector3 runBackAndForth(){
        Vector3 force = new Vector3(1, 0, 0);
        force.nor();

        return force;
    }
}
