package com.mania.game.Handlers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

/**
 * Created by Registered User on 9/9/2016.
 */
public class Assets {
    public AssetManager assetManager = new AssetManager();
    public final static String Title = "Title/title.png",
    menuAtlas = "Menu/Atlas/menu.atlas";

    public void load(){
        assetManager.load(menuAtlas, TextureAtlas.class);
        assetManager.load(Title, Texture.class);
    }

    public void dispose(){
        assetManager.dispose();
    }
}
