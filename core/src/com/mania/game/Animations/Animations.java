package com.mania.game.Animations;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

public class Animations {
    private TextureAtlas atlas;
    private int x, y, width, height;
    private float framesPerSecond, stateTime = 0;
    private Animation animation;
    boolean loop;

    public Animations(TextureAtlas atlas, int x, int y, int width, int height, float framesPerSecond, boolean loop) {
        this.atlas = atlas;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.framesPerSecond = framesPerSecond;
        this.loop = loop;
        createAnimations();
    }

    public void createAnimations() {

        animation = new Animation(framesPerSecond, atlas.getRegions());

    }

    public void render(SpriteBatch batch) {
        stateTime += Gdx.graphics.getDeltaTime();
        if (!animation.isAnimationFinished(stateTime)) {
            batch.draw(animation.getKeyFrame(stateTime, loop), x, y, width, height);
        }
    }

    public void resetAnimation() {
        stateTime = 0;
    }


}
