package com.czareg.game.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.czareg.game.BucketGame;

public class MenuScreen extends ScreenAdapter {

    private final BucketGame game;
    private final OrthographicCamera camera;
    private final BitmapFont font;
    private final SpriteBatch batch;

    public MenuScreen(final BucketGame game) {
        this.game = game;

        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 480);
        font = new BitmapFont();
        batch = new SpriteBatch();
    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(0, 0, 0.2f, 1);

        camera.update();

        batch.setProjectionMatrix(camera.combined);

        batch.begin();
        font.draw(batch, "Welcome to Drop!!! ", 100, 150);
        font.draw(batch, "Click anywhere to begin!", 100, 100);
        font.draw(batch, "Press escape to quit!", 100, 50);
        batch.end();

        if (Gdx.input.isTouched()) {
            game.setGameScreen();
            return;
        }
        if (Gdx.input.isKeyJustPressed(Input.Keys.ESCAPE)) {
            Gdx.app.exit();
        }
    }

    @Override
    public void dispose() {
        batch.dispose();
        font.dispose();
    }
}