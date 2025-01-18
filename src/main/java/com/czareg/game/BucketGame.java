package com.czareg.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;
import com.czareg.game.screen.GameScreen;
import com.czareg.game.screen.MenuScreen;

public class BucketGame extends Game {

    private Screen currentScreen;

    @Override
    public void create() {
        currentScreen = new MenuScreen(this);
        setScreen(currentScreen);
    }

    @Override
    public void dispose() {
        currentScreen.dispose();
    }

    public void setMenuScreen() {
        setNewScreen(new MenuScreen(this));
    }

    public void setGameScreen() {
        setNewScreen(new GameScreen(this));
    }

    private void setNewScreen(Screen newScreen) {
        setScreen(newScreen);
        currentScreen.dispose();
        currentScreen = newScreen;
    }
}