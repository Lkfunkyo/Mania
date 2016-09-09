package com.mania.game.Screens;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.mania.game.Mania;
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

/**
 * Created by Registered User on 9/8/2016.
 */
public class MenuScreen implements Screen {
    private Mania game;

    public MenuScreen(Mania game){
        this.game = game;
    }

    private TextureAtlas atlas;
    private Stage stage;
    private Skin skin;
    private TextButton startButton, leaderBoardButton, achievementButton, rateButton, shareButton, socialMediaButton;


    @Override
    public void show() {

    }

    public void createButtons(){
        startButton = new TextButton("",skin);

        startButton.addListener( new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {

            }
        });

        leaderBoardButton = new TextButton("",skin);

        leaderBoardButton.addListener( new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {

            }
        });

        startButton = new TextButton("",skin);

        startButton.addListener( new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {

            }
        });

        startButton = new TextButton("",skin);

        startButton.addListener( new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {

            }
        });

        startButton = new TextButton("",skin);

        startButton.addListener( new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {

            }
        });
    }


    @Override
    public void render(float delta) {

    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
