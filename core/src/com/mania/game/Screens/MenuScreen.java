package com.mania.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.mania.game.Constants;
import com.mania.game.Handlers.Assets;
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
    private TextButton startButton, leaderBoardButton, rateButton, shareButton;
    private Sprite title;


    @Override
    public void show() {
        stage = new Stage();
        atlas = game.assets.assetManager.get(Assets.menuAtlas);
        skin = new Skin(Gdx.files.internal("Menu/menu.json"),atlas);
        title = new Sprite((Texture) game.assets.assetManager.get(Assets.Title));

        title.setSize(game.cam.viewportWidth*.6f, game.cam.viewportHeight * .2f);
        title.setPosition(game.cam.viewportWidth/2 - title.getWidth()/2, game.cam.viewportHeight*.7f);
        createButtons();

        stage.addActor(startButton);
        stage.addActor(leaderBoardButton);
        stage.addActor(rateButton);

        Gdx.input.setInputProcessor(stage);
    }




    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0,0,0,0);
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
        startButton = new TextButton("",skin, "button");
        startButton.setSize(Constants.WIDTH*.4f, Constants.HEIGHT*.14f);
        startButton.setPosition(Constants.WIDTH/2 - startButton.getWidth()/2,Constants.HEIGHT*.45f);

        startButton.addListener( new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                game.setScreen(new PlayScreen(game));
            }
        });

        leaderBoardButton = new TextButton("",skin, "button");
        leaderBoardButton.setSize(Constants.WIDTH*.4f, Constants.HEIGHT*.14f);
        leaderBoardButton.setPosition(Constants.WIDTH/2 - leaderBoardButton.getWidth()/2,Constants.HEIGHT*.30f);
        leaderBoardButton.addListener( new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {

            }
        });


        rateButton = new TextButton("",skin, "button");
        rateButton.setSize(Constants.WIDTH*.4f, Constants.HEIGHT*.14f);
        rateButton.setPosition(Constants.WIDTH/2 - rateButton.getWidth()/2,Constants.HEIGHT*.15f);
        rateButton.addListener( new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {

            }
        });


    }
}
