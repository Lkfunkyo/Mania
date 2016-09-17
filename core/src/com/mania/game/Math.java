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

    public static float map(float value, float min1, float max1, float newMin, float newMax){
        float ans;

        float dist1 = max1-min1;
        float dist2 = newMax-newMax;

        float ratio = value/dist1;

        ans = newMin + dist2*ratio;

        return ans;
    }
}
