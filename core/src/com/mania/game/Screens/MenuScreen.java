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
import com.mania.game.Animations.Fire.FireAnimations;
import com.mania.game.Constants;
import com.mania.game.Handlers.Assets;
import com.mania.game.Handlers.SpriteAccessor;
import com.mania.game.Mania;

import aurelienribon.tweenengine.Tween;
import aurelienribon.tweenengine.TweenManager;

public class MenuScreen implements Screen {
    private Mania game;

    public MenuScreen(Mania game) {
        this.game = game;
    }

    private TextureAtlas atlas;
    private Stage stage;
    private Skin skin;
    private TextButton startButton, leaderBoardButton, rateButton;
    private Sprite title, background;
    private TweenManager manager;

    @Override
    public void show() {
        stage = new Stage();
        atlas = game.assets.assetManager.get(Assets.menuAtlas);
        skin = new Skin(Gdx.files.internal("Menu/menu.json"), atlas);

        title = new Sprite((Texture) game.assets.assetManager.get(Assets.Title));
        background = new Sprite((Texture) game.assets.assetManager.get(Assets.menuBackground));
        background.setBounds(0, 0, game.cam.viewportWidth, game.cam.viewportHeight);

        createButtons();
        setupTween();

        stage.addActor(startButton);
        stage.addActor(leaderBoardButton);
        stage.addActor(rateButton);

        Gdx.input.setInputProcessor(stage);

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 0);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        update(delta);
        game.batch.begin();
        background.draw(game.batch);
        game.batch.draw(title, game.cam.viewportWidth / 2 - game.cam.viewportWidth * .63f / 2,
                game.cam.viewportHeight * .7f, game.cam.viewportWidth * .63f, game.cam.viewportHeight * .23f);
        game.batch.end();
        stage.draw();

    }

    public void update(float delta) {
        manager.update(delta);
        stage.act(delta);
        game.batch.setProjectionMatrix(game.cam.combined);
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

    public void createButtons() {
        startButton = new TextButton("", skin, "button");
        startButton.setSize(Constants.WIDTH * .3f, Constants.HEIGHT * .14f);
        startButton.setPosition(Constants.WIDTH / 2 - startButton.getWidth() / 2, Constants.HEIGHT * .40f);

        startButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                Gdx.input.setInputProcessor(null);
                game.setScreen(new PlayScreen(game));
            }
        });

        leaderBoardButton = new TextButton("", skin, "button");
        leaderBoardButton.setSize(Constants.WIDTH * .3f, Constants.HEIGHT * .14f);
        leaderBoardButton.setPosition(Constants.WIDTH * .18f, Constants.HEIGHT * .20f);
        leaderBoardButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {

            }
        });


        rateButton = new TextButton("", skin, "button");
        rateButton.setSize(Constants.WIDTH * .3f, Constants.HEIGHT * .14f);
        rateButton.setPosition(Constants.WIDTH * .52f, Constants.HEIGHT * .20f);
        rateButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {

            }
        });


    }

    public void setupTween() {
        Tween.registerAccessor(Sprite.class, new SpriteAccessor());
        manager = new TweenManager();
        Tween.set(background, SpriteAccessor.COLOR).target(0, 0, 0).start(manager);
        Tween.to(background, SpriteAccessor.COLOR, 5).target(1, 1, 1).repeatYoyo(-1, 1).start(manager);
    }
}
