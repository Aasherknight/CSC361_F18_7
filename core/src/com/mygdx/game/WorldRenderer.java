package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Disposable;
import com.mygdx.game.util.Constants;

public class WorldRenderer implements Disposable
{
	private OrthographicCamera camera;
	private OrthographicCamera cameraGUI;
	private SpriteBatch batch;
	private WorldController worldController;
	
	public WorldRenderer (WorldController wc)
	{
		worldController = wc;
		init();
	}
	
	private void init ()
	{
		batch = new SpriteBatch();
		camera = new OrthographicCamera(Constants.VIEWPORT_WIDTH, Constants.VIEWPORT_HEIGHT);
		camera.position.set(0, 0, 0);
		camera.update();
	
		cameraGUI = new OrthographicCamera(Constants.VIEWPORT_GUI_WIDTH, Constants.VIEWPORT_GUI_HEIGHT);
		cameraGUI.position.set(0,0,0);
		cameraGUI.setToOrtho(true); // flip y-axis
		cameraGUI.update();
	}
	
	public void render ()
	{
		renderWorld(batch);
		renderGui(batch);
		//renderTestObjects();
	}
	
	private void renderWorld(SpriteBatch batch)
	{
		//setting the camera to follow the logic of the camera helper
		worldController.cameraHelper.applyTo(camera);
		batch.setProjectionMatrix(camera.combined);
		batch.begin();
		
		//load up the level
		worldController.level.render(batch);
		batch.end();
	}
	
	private void renderGui(SpriteBatch batch)
	{
		batch.setProjectionMatrix(cameraGUI.combined);
		batch.begin();
		
		//draw collected gold coins icon and text on top left edge
		renderGuiScore(batch);
		
		//draw extra lives icon and text on top right edge
		renderGuiExtraLive(batch);
		
		//draw fps text on bottom right edge
		renderGuiFpsCounter(batch);
		batch.end();
	}
	
	private void renderGuiExtraLive(SpriteBatch batch)
	{
		float x = cameraGUI.viewportWidth-50-Constants.LIVES_START * 50;
		float y = -15;
		
		for(int i = 0; i<Constants.LIVES_START; i++)
		{
			if(worldController.lives <=i)
				batch.setColor(0.5f,0.5f,0.5f,0.5f);
			batch.draw(Assets.instance.bunny.head, x+i * 50, y, 50,50,120,100,0.35f,-0.35f,0);
			batch.setColor(1,1,1,1);
		}
	}
	
	private void renderGuiScore(SpriteBatch batch)
	{
		float x = -15;
		float y = -15;
		batch.draw(Assets.instance.goldCoin.goldCoin, x, y, 50, 50, 100, 100, 0.35f, -0.35f, 0);
		Assets.instance.fonts.defaultBig.draw(batch,"" + worldController.score, x+75, y+37);
	}
	
	private void renderGuiFpsCounter(SpriteBatch batch)
	{
		float x = cameraGUI.viewportWidth - 55;
		float y = cameraGUI.viewportHeight - 15;
		int fps = Gdx.graphics.getFramesPerSecond();
		
		BitmapFont fpsFont = Assets.instance.fonts.defaultNormal;
		
		if(fps>=45)
			fpsFont.setColor(0,1,0,1);		//45+ fps shows up in green
		else if (fps>=30)
			fpsFont.setColor(1,1,0,1);		//30+ fps shows up in yellow
		else
			fpsFont.setColor(1,0,0,1);		//less than 30 fps shows up in red
		
		fpsFont.draw(batch, "FPS: " + fps,  x, y);
		fpsFont.setColor(1,1,1,1);			//white
	}
	
	private void renderTestObjects()
	{
		worldController.cameraHelper.applyTo(camera);
		batch.setProjectionMatrix(camera.combined);
		batch.begin();
		for(Sprite sprite : worldController.testSprites)
		{
			sprite.draw(batch);
		}
		batch.end();
	}
	
	public void resize (int width, int height)
	{
		camera.viewportWidth = (Constants.VIEWPORT_HEIGHT/height) * width;
		camera.update();
		
		cameraGUI.viewportHeight = Constants.VIEWPORT_GUI_HEIGHT;
		cameraGUI.viewportWidth = Constants.VIEWPORT_GUI_HEIGHT / (float)height * (float)width;
		cameraGUI.position.set(cameraGUI.viewportWidth/2, cameraGUI.viewportHeight/2, 0);
		cameraGUI.update();
	}
	
	@Override public void dispose()
	{
		batch.dispose();
	}
	
}
