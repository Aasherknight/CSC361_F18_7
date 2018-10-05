package com.mygdx.game;
import com.badlogic.gdx.Application;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.Game;
import com.mygdx.game.Assets;
import com.mygdx.game.screens.MenuScreen;

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
		// Start game at menu screen
		setScreen(new MenuScreen(this));
	}
}
