package com.czareg.game;

import com.badlogic.gdx.Game;
import com.czareg.game.screen.GameScreen;
import com.czareg.game.screen.MenuScreen;

public class BucketGame extends Game {

    private MenuScreen menuScreen;
    private GameScreen gameScreen;

    @Override
    public void create() {
        menuScreen = new MenuScreen(this);
        gameScreen = new GameScreen(this);
        setMenuScreen();
    }

    @Override
    public void dispose() {
        menuScreen.dispose();
        gameScreen.dispose();
    }

    public void setMenuScreen() {
        setScreen(menuScreen);
    }

    public void setGameScreen() {
        setScreen(gameScreen);
    }
}