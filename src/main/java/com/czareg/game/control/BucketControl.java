package com.czareg.game.control;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.czareg.game.entities.Bucket;

public class BucketControl {
    private final Bucket bucket;

    public BucketControl() {
        bucket = new Bucket();
    }

    public void draw(SpriteBatch batch) {
        bucket.draw(batch);
    }

    public void update(OrthographicCamera camera) {
        // process user input
        if (Gdx.input.isTouched()) {
            Vector3 touchPos = new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0);
            camera.unproject(touchPos);
            bucket.setX(touchPos.x - 64 / 2);
        }

        if (Gdx.input.isKeyPressed(Input.Keys.LEFT) || Gdx.input.isKeyPressed(Input.Keys.A)) {
            bucket.setX(bucket.getX() - 400 * Gdx.graphics.getDeltaTime());
        }
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT) || Gdx.input.isKeyPressed(Input.Keys.D)) {
            bucket.setX(bucket.getX() + 400 * Gdx.graphics.getDeltaTime());
        }

        // make sure the bucket stays within the screen bounds
        if (bucket.getX() < 0) {
            bucket.setX(0);
        }
        if (bucket.getY() > 800 - 64) {
            bucket.setY(800 - 64);
        }
    }

    public void dispose() {
        bucket.dispose();
    }

    public Rectangle getBucketRectangle() {
        return bucket.getRectangle();
    }
}
