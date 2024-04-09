package com.czareg;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import com.czareg.game.BucketGame;
import com.czareg.game.config.ConfigurationFactory;

public class Main {

    public static void main(String[] args) {
        Lwjgl3ApplicationConfiguration configuration = new ConfigurationFactory().create();
        new Lwjgl3Application(new BucketGame(), configuration);
    }
}