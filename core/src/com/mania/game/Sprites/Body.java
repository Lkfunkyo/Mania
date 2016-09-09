package com.mania.game.Sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;

/**
 * Created by PC on 9/9/2016.
 */
public class Body {
    private Vector3 pos;
    private Vector3 vel;
    private Vector3 accel;

    private float size;

    private float w, h;

    private Texture img;

    public Body(Vector3 pos, float size, Texture img){
        this.pos = pos;
        this.vel = new Vector3(0, 0, 0);
        this.accel = new Vector3(0, 0, 0);

        this.size = size;
        this.img = img;

        this.w = img.getWidth();
        this.h = img.getHeight();
    }

    public void display(SpriteBatch batch){
        batch.draw(this.img, this.pos.x-this.w/2-this.size, this.pos.y-this.h/2-this.size, this.pos.x-this.w/2+this.size, this.pos.y-this.h/2+this.size);
    }

    public void run(){
        this.vel.add(this.accel);
        this.pos.add(this.vel);

        this.accel.scl(0);
    }

    public void applyForce(Vector3 force){
        this.accel.add(force);
    }
}
