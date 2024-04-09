package com.czareg.game.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;

public class Drop {
    private final Texture texture;
    private final Rectangle rectangle;

    public Drop(Texture texture) {
        this.texture = texture;

        rectangle = new Rectangle();
        rectangle.x = MathUtils.random(0, 800 - 64);
        rectangle.y = 480;
        rectangle.width = 64;
        rectangle.height = 64;
    }

    public void draw(SpriteBatch batch) {
        batch.draw(texture, rectangle.x, rectangle.y, rectangle.width, rectangle.height);
    }

    public void update() {
        rectangle.y -= 200 * Gdx.graphics.getDeltaTime();
    }

    public boolean overlaps(Rectangle rectangle) {
        return this.rectangle.overlaps(rectangle);
    }

    public float getY() {
        return rectangle.getY();
    }
}
