package com.mygdx.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

import csakennijottunk.Game.InGameGame;
import csakennijottunk.Menu.MenuGame;

public class DesktopLauncherTest {
    public static void main (String[] arg) {
        LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();

        config.width = 1280;
        config.height = 720;
        new LwjglApplication(new InGameGame(true), config);

    }
}
