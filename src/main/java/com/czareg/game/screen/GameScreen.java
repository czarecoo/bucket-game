package com.czareg.game.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.czareg.game.BucketGame;
import com.czareg.game.control.BucketControl;
import com.czareg.game.control.DropControl;

public class GameScreen extends ScreenAdapter {

    private final BucketGame game;
    private final Music rainMusic;
    private final OrthographicCamera camera;
    private final SpriteBatch batch;
    private final BucketControl bucketControl;
    private final DropControl dropControl;

    public GameScreen(final BucketGame game) {
        this.game = game;

        rainMusic = Gdx.audio.newMusic(Gdx.files.internal("rain.mp3"));
        rainMusic.setLooping(true);

        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 480);

        batch = new SpriteBatch();

        bucketControl = new BucketControl();
        dropControl = new DropControl(bucketControl);
    }

    @Override
    public void render(float delta) {
        // clear the screen with a dark blue color. The
        // arguments to clear are the red, green
        // blue and alpha component in the range [0,1]
        // of the color to be used to clear the screen.
        ScreenUtils.clear(0, 0, 0.2f, 1);

        // tell the camera to update its matrices.
        camera.update();

        // tell the SpriteBatch to render in the
        // coordinate system specified by the camera.
        batch.setProjectionMatrix(camera.combined);

        batch.begin();
        bucketControl.draw(batch);
        dropControl.draw(batch);
        batch.end();

        if (Gdx.input.isKeyPressed(Input.Keys.ESCAPE)) {
            game.setMenuScreen();
            return;
        }

        bucketControl.update(camera);
        dropControl.update();
    }

    @Override
    public void show() {
        rainMusic.play();
    }

    @Override
    public void hide() {
        rainMusic.stop();
    }

    @Override
    public void dispose() {
        dropControl.dispose();
        bucketControl.dispose();
        rainMusic.dispose();
        batch.dispose();
    }
}
