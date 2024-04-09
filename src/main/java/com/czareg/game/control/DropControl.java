package com.czareg.game.control;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.TimeUtils;
import com.czareg.game.entities.Drop;

import java.util.Iterator;

public class DropControl {

    private final BucketControl bucketControl;
    private final Texture texture;
    private final Sound dropSound;
    private final BitmapFont font;
    private final Array<Drop> drops;
    private long lastDropTime;
    private int dropsGathered;

    public DropControl(BucketControl bucketControl) {
        this.bucketControl = bucketControl;
        texture = new Texture(Gdx.files.internal("droplet.png"));
        dropSound = Gdx.audio.newSound(Gdx.files.internal("drop.wav"));
        font = new BitmapFont();
        drops = new Array<>();
    }

    public void draw(SpriteBatch batch) {
        for (Drop drop : drops) {
            drop.draw(batch);
        }
        font.draw(batch, "Drops Collected: " + dropsGathered, 50, 430);
    }

    public void update() {
        if (TimeUtils.nanoTime() - lastDropTime > 1000000000) {
            drops.add(new Drop(texture));
            lastDropTime = TimeUtils.nanoTime();
        }

        Iterator<Drop> dropIterator = drops.iterator();
        while (dropIterator.hasNext()) {
            Drop drop = dropIterator.next();
            drop.update();
            if (drop.getY() + 64 < 0) {
                dropIterator.remove();
            }
            if (drop.overlaps(bucketControl.getBucketRectangle())) {
                dropsGathered++;
                dropSound.play();
                dropIterator.remove();
            }
        }
    }

    public void dispose() {
        texture.dispose();
        dropSound.dispose();
        font.dispose();
    }
}
