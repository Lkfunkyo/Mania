package com.mania.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

/**
 * Created by Registered User on 9/9/2016.
 */
public class Assets {
    public AssetManager assetManager = new AssetManager();


    public void load(){
        assetManager.load("Menu/menu.atlas", TextureAtlas.class);
    }

    public void dispose(){
        assetManager.dispose();
    }
}
