package com.mygdx.game.util;

public class Constants 
{

	// Visible game world is 5 meters wide
	public static final float VIEWPORT_WIDTH = 5.0f;
	
	// Visible game world is 5 meters tall
	public static final float VIEWPORT_HEIGHT = 5.0f;
	 
	// GUI Width
	 public static final float VIEWPORT_GUI_WIDTH = 800.0f;
	 // GUI Height
	 public static final float VIEWPORT_GUI_HEIGHT = 480.0f;

	//Location of description file for the texture atlas
	public static final String TEXTURE_ATLAS_OBJECTS =  "../core/assets/canyonbunny.atlas";
	
	public static final String LEVEL_01 = "../core/assets/levels/level-01.png";
	
	 // Amount of extra lives at level start
	 public static final int LIVES_START = 3;
	 
	 //Duration of feather power-up in seconds
	 public static final float ITEM_FEATHER_POWERUP_DURATION = 9;
	 
	 //Delay after game over
	 public static final float TIME_DELAY_GAME_OVER = 3;
	 
	 /**
	  * Aaron Gerber
	  * location of atlas for the ui textures
	  */
	 public static final String TEXTURE_ATLAS_UI = "../core/assets/canyonbunny-ui.atlas";
	 
	 /**
	  * Aaron Gerber
	  * location of atlas for the libgdx ui textures
	  */
	 public static final String TEXTURE_ATLAS_LIBGDX_UI = "../core/assets/uiskin.atlas";
	 
	 /**
	  * Aaron Gerber
	  * location of json for the libgdx ui textures
	  */
	 public static final String SKIN_LIBGDX_UI = "../core/assets/uiskin.json";
	 
	 /**
	  * Aaron Gerber
	  * location of json for the canyonbunny ui textures
	  */
	 public static final String SKIN_CANYONBUNNY_UI = "../core/assets/canyonbunny-ui.json";

	 /**
	  * Aaron Gerber
	  * looked throughout the chapter, this doesn't exist?
	  */
	 public static final String PREFERENCES = "preferences";
}
