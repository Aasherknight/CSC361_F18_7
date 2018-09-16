package com.mygdx.game;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Application;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.GL30;


public class CanyonBunnyMain implements ApplicationListener
{
	private final static String TAG = CanyonBunnyMain.class.getName();
	private WorldController worldController;
	private com.mygdx.game.WorldRenderer worldRenderer;
	private boolean paused;
	
	@Override
	public void create() {	
		//Set libgdx log level to debug
		Gdx.app.setLogLevel(Application.LOG_DEBUG);
		 // Load assets
		 Assets.instance.init(new AssetManager());
		//Initialize controller and renderer
		worldController = new WorldController();
		worldRenderer = new WorldRenderer(worldController);
		paused = false;
		
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
		paused = false;
	}

	public void dispose() {
		worldRenderer.dispose();
		Assets.instance.dispose();
	}
	
}
