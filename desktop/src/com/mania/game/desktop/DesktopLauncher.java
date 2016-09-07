package com.mania.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.mania.game.Mania;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();

		config.width = Mania.WIDTH;
		config.height = Mania.HEIGHT;
		config.resizable = false;

		new LwjglApplication(new Mania(), config);
	}
}
