package com.czareg.game.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public class Bucket {

    private final Texture texture;
    private final Rectangle rectangle;

    public Bucket() {
        texture = new Texture(Gdx.files.internal("bucket.png"));

        // create a Rectangle to logically represent the bucket
        rectangle = new Rectangle();
        rectangle.x = 800 / 2 - 64 / 2; // center the bucket horizontally
        rectangle.y = 20; // bottom left corner of the bucket is 20 pixels above
        // the bottom screen edge
        rectangle.width = 64;
        rectangle.height = 64;
    }

    public void draw(SpriteBatch batch) {
        batch.draw(texture, rectangle.x, rectangle.y, rectangle.width, rectangle.height);
    }

    public void dispose() {
        texture.dispose();
    }

    public Rectangle getRectangle() {
        return rectangle;
    }

    public void setX(float x) {
        rectangle.setX(x);
    }

    public void setY(float y) {
        rectangle.setY(y);
    }

    public float getX() {
        return rectangle.getX();
    }

    public float getY() {
        return rectangle.getY();
    }
}
