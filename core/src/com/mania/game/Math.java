package com.mania.game;

/**
 * Created by PC on 9/9/2016.
 */
public class Math {
    public static float constrain(float value, int low, int high){
        float h = high;
        float l = low;

        if(value > high){
            return h;
        } else if(value < low){
            return l;
        } else {
            return value;
        }
    }


}
