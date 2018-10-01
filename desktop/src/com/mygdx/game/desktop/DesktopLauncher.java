package com.mygdx.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.mygdx.game.CanyonBunnyMain;
import com.badlogic.gdx.tools.texturepacker.TexturePacker;
import com.badlogic.gdx.tools.texturepacker.TexturePacker.Settings;

public class DesktopLauncher 
{
	private static boolean rebuildAtlas = true;
	private static boolean drawDebugOutline = false;
	
	public static void main (String[] arg) 
	{
		if (rebuildAtlas) 
	 	{
		 	Settings settings = new Settings();
		 	settings.maxWidth = 1024;
			 settings.maxHeight = 1024;
			 settings.duplicatePadding = false;
			 settings.debug = drawDebugOutline;
			 TexturePacker.process(settings, "assets-raw/images","../core/assets","canyonbunny.atlas");
			 /**
			  * Aaron Gerber
			  * Adds the atlas for the UI images on the title screen of the game.
			  */
			 TexturePacker.process(settings, "assets-raw/images-ui","../core/assets","canyonbunny-ui.atlas");
		 }
	 		LwjglApplicationConfiguration cfg = new
	 		LwjglApplicationConfiguration();
	 		cfg.title = "CanyonBunny";
	 		cfg.width = 800;
	 		cfg.height = 480;
	 		new LwjglApplication(new CanyonBunnyMain(), cfg);
	 	
	}
}
