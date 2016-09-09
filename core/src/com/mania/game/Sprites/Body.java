package com.mania.game.Sprites;

import com.badlogic.gdx.math.Vector3;

/**
 * Created by PC on 9/9/2016.
 */
public class Body {
    private Vector3 pos;
    private Vector3 vel;
    private Vector3 accel;

    private float size;


    public Body(Vector3 pos, float size){
        this.pos = pos;
        this.vel = new Vector3(0, 0, 0);
        this.accel = new Vector3(0, 0, 0);

        this.size = size;
    }

    public void run(){

    }


}
