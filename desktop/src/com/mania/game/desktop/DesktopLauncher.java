package com.mania.game.desktop;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.mania.game.Mania;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		new LwjglApplication(new Mania(), config);

		config.width = Gdx.graphics.getWidth();
		config.height = Gdx.graphics.getHeight();
		config.resizable = false;
	}
}
