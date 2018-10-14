package com.mygdx.game;
import com.badlogic.gdx.Application;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.Game;
import com.mygdx.game.Assets;
import com.mygdx.game.screens.MenuScreen;
import com.mygdx.game.util.AudioManager;
import com.mygdx.game.util.GamePreferences;

/**
 * @author Jeff and Andrew
 * Class for initializing the game and Managing 
 * the game loop
 *
 */
public class CanyonBunnyMain extends Game
{
	@Override
	public void create()
	{
		// Set Libgdx log level
		Gdx.app.setLogLevel(Application.LOG_DEBUG);
		
		// Load assets
		Assets.instance.init(new AssetManager());
		
		//Load preferences for audio settings and start playing music
		GamePreferences.instance.load();
		AudioManager.instance.play(Assets.instance.music.song01);
		
		// Start game at menu screen
		setScreen(new MenuScreen(this));
	}
}
