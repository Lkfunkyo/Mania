package com.mania.game.Handlers;

import com.badlogic.gdx.graphics.g2d.Sprite;

import aurelienribon.tweenengine.TweenAccessor;

/**
 * Created by Registered User on 9/17/2016.
 */
public class SpriteAccessor implements TweenAccessor<Sprite> {
    public static final int ALPHA = 0, COLOR = 0;
    @Override
    public int getValues(Sprite target, int tweenType, float[] returnValues) {
        switch (tweenType){
            case COLOR:
                returnValues[0] = target.getColor().r;
                returnValues[1] = target.getColor().g;
                returnValues[2] = target.getColor().b;
                return 3;
            default:
                assert false;
                return -1;

        }
    }

    @Override
    public void setValues(Sprite target, int tweenType, float[] newValues) {
        switch (tweenType){
            case COLOR:
                target.setColor(newValues[0], newValues[1], newValues[2], target.getColor().a);

                break;
            default:
                assert false;
        }
    }
}
