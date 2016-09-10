package com.mania.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.mania.game.Constants;
import com.mania.game.Mania;

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
    private Sprite title;


    @Override
    public void show() {
        stage = new Stage();
        Gdx.input.setInputProcessor(stage);
        atlas = game.assets.assetManager.get("Menu/menu.atlas");
        skin = new Skin(Gdx.files.internal("Menu/menu.json"),atlas);
        title = new Sprite(atlas.findRegion("title"));

        title.setSize(game.cam.viewportWidth*.6f, game.cam.viewportHeight * .2f);
        title.setPosition(game.cam.viewportWidth/2 - title.getWidth()/2, game.cam.viewportHeight*.7f);
        createButtons();

        stage.addActor(startButton);
        stage.addActor(leaderBoardButton);
        stage.addActor(achievementButton);
        stage.addActor(rateButton);
        stage.addActor(shareButton);
        stage.addActor(socialMediaButton);

    }




    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1,1,1,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act(delta);
        stage.draw();
        game.batch.setProjectionMatrix(game.cam.combined);
        game.batch.begin();
        title.draw(game.batch);
        game.batch.end();


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
    public void createButtons(){
        startButton = new TextButton("",skin, "greenButton");
        startButton.setSize(Constants.WIDTH*.5f, Constants.HEIGHT*.18f);
        startButton.setPosition(Constants.WIDTH/2 - startButton.getWidth()/2,Constants.HEIGHT*.45f);

        startButton.addListener( new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {

            }
        });

        leaderBoardButton = new TextButton("",skin, "blueButton");
        leaderBoardButton.setSize(Constants.WIDTH*.25f, Constants.HEIGHT*.14f);
        leaderBoardButton.setPosition(Constants.WIDTH*.244f,Constants.HEIGHT*.28f);
        leaderBoardButton.addListener( new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {

            }
        });

        achievementButton = new TextButton("",skin, "blueButton");
        achievementButton.setSize(Constants.WIDTH*.25f, Constants.HEIGHT*.14f);
        achievementButton.setPosition(Constants.WIDTH*.507f,Constants.HEIGHT*.28f);

        achievementButton.addListener( new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {

            }
        });

        rateButton = new TextButton("",skin, "greenButton");
        rateButton.setSize(Constants.WIDTH*.125f, Constants.HEIGHT*.12f);
        rateButton.setPosition(Constants.WIDTH*.244f,Constants.HEIGHT*.13f);
        rateButton.addListener( new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {

            }
        });

        shareButton = new TextButton("",skin, "greenButton");
        shareButton.setSize(Constants.WIDTH*.125f, Constants.HEIGHT*.12f);
        shareButton.setPosition(Constants.WIDTH*.37f,Constants.HEIGHT*.13f);
        shareButton.addListener( new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {

            }
        });

        socialMediaButton = new TextButton("",skin,"greenButton");
        socialMediaButton.setSize(Constants.WIDTH*.25f, Constants.HEIGHT*.13f);
        socialMediaButton.setPosition(Constants.WIDTH*.507f,Constants.HEIGHT*.12f);
        socialMediaButton.addListener( new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {

            }
        });
    }
}
