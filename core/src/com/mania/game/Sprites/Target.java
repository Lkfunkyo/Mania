package com.mania.game.Sprites;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;
import com.mania.game.Constants;
import com.mania.game.Math;

import java.util.ArrayList;

/**
 * Created by PC on 9/9/2016.
 */
public class Target {
    public Vector3 pos;
    public Vector3 vel;
    public Vector3 accel;

    private float scale;

    private float w, h, d;

    public int type;
    private OrthographicCamera cam;

    private Texture img;
    private ArrayList history;

    public Target(Vector3 pos, Texture img, OrthographicCamera cam){
        this.pos = pos;
        this.vel = new Vector3(0, 0, 0);
        this.accel = new Vector3(0, 0, 0);

        this.img = img;

        this.cam = cam;

        this.w = img.getWidth();
        this.h = img.getHeight();
        this.d = 200;

        this.type = 0;
        this.history = new ArrayList<Vector3>();

        //System.out.println(this.type);
    }

    public void setType(int type){
        this.type = type;
        //System.out.println(this.type);
    }

    public void setMaxDepth(int depth){
        this.d = Constants.DEPTH-depth;
    }

    public void display(SpriteBatch batch){
        batch.draw(this.img, this.pos.x-this.w*this.scale/2, this.pos.y-this.h*this.scale/2, this.w*this.scale, this.h*this.scale);
    }

    public void run() {
        this.vel.add(this.accel);
        this.pos.add(this.vel);

        this.accel.scl(0);

        this.applyForce(this.forceList(this.type));

        this.scale = Math.map(this.pos.z, 0, Constants.DEPTH, 1, 0);
    }

    public boolean outOfScreen(){
        if(this.pos.x > cam.viewportWidth + this.w * this.scale / 2 || this.pos.x < -this.w * this.scale / 2 || this.pos.y > cam.viewportHeight + this.h * this.scale / 2 || this.pos.y < -this.h * this.scale / 2 || this.pos.z < 0 || this.pos.z > Constants.DEPTH-this.d){
            return true;
        } else{
            return false;
        }
    }

    public void stayInScreen(){
        if(this.pos.x > cam.viewportWidth - this.w*this.scale/2 || this.pos.x < this.w*this.scale/2){
            this.vel.x *= -0.8;
        }

        if(this.pos.y > cam.viewportHeight - this.h*this.scale/2 || this.pos.y < this.h*this.scale/2){
            this.vel.y *= -0.8;
        }

        if(this.pos.z > Constants.DEPTH-this.d || this.pos.z < this.d){
            this.vel.z *= -0.8;
        }



        this.pos = new Vector3(Math.constrain(this.pos.x, (int) (this.w*this.scale/2), (int) (cam.viewportWidth - this.w*this.scale/2)), Math.constrain(this.pos.y, (int) (this.h*this.scale/2), (int) (cam.viewportHeight - this.h*this.scale/2)), Math.constrain(this.pos.z, (int) (this.d*this.scale/2), (int) (Constants.DEPTH-this.d)) );
    }

    public void applyForce(Vector3 force){
        this.accel.add(force);
    }

    public Vector3 forceList(int num){
        switch(num){
            case 0: return new Vector3(0, 0, 0);
            case 1: return this.runStraight();
            case 2: return this.runCircle();
            case 3: return this.runWave();
            case 4: return this.runBackAndForth();

            default: return new Vector3(0, 0, 0);
        }
    }

    public Vector3 runStraight(){
        Vector3 force = new Vector3(1, 0, 0);
        force.nor();

        return force;
    }

    public Vector3 runCircle(){
        Vector3 force = new Vector3(-1, 0, 0);
        force.nor();

        return force;
    }

    public Vector3 runWave(){
        Vector3 force = new Vector3(1, 1, 0);
        force.nor();

        return force;
    }

    public Vector3 runBackAndForth(){
        Vector3 force = new Vector3(1, -1, 0);
        force.nor();

        return force;
    }
}