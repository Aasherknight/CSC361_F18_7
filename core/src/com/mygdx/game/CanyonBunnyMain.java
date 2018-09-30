package com.mygdx.game;
import com.badlogic.gdx.Application;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.GL30;

import com.badlogic.gdx.Game;
import com.mygdx.game.Assets;
import com.mygdx.game.MenuScreen;

/**
 * @author Jeff
 * Class for initializing the game and Managing 
 * the game loop
 *
 */
public class CanyonBunnyMain extends Game
{
	private final static String TAG = CanyonBunnyMain.class.getName();
	private WorldController worldController;
	private WorldRenderer worldRenderer;
	private boolean paused;
	
	@Override
	public void create() {	
		//Set libgdx log level to debug
		Gdx.app.setLogLevel(Application.LOG_DEBUG);
		 // Load assets
		 Assets.instance.init(new AssetManager());
		 //Start Game at menuscreen
		 setScreen(new MenuScreen(this));
		
	}

	public void resize(int width, int height) {
		worldRenderer.resize(width,height);
	}

	public void render() {
		if(!paused)
		{
			worldController.update(Gdx.graphics.getDeltaTime());
		}
		Gdx.gl.glClearColor(0x64/255.0f, 0x95/255.0f, 0xed/255.0f, 0xff/255.0f);
		Gdx.gl.glClear(GL30.GL_COLOR_BUFFER_BIT);
		worldRenderer.render();
		
	}
	
	public void pause() {
		paused = true;
	}

	public void resume() {
		Assets.instance.init(new AssetManager());
		paused = false;
	}

	public void dispose() {
		worldRenderer.dispose();
		Assets.instance.dispose();
	}
	
}
