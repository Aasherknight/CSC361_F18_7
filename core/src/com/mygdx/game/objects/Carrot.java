package com.mygdx.game.objects;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx.game.Assets;

/**
 * Class to manage the carrot as an ingame object
 * @author Jeff
 *
 */
public class Carrot extends AbstractGameObject 
{
	private TextureRegion regCarrot;
	public Carrot () 
	{
		init();
	}
	
	/**
	 * Initilaize carrot object 
	 */
	private void init () 
	{
		dimension.set(0.25f, 0.5f);
		regCarrot = Assets.instance.levelDecoration.carrot;
		 // Set bounding box for collision detection
		bounds.set(0, 0, dimension.x, dimension.y);
		origin.set(dimension.x / 2, dimension.y / 2);
	}
	
	/**
	 * Method to draw carrot object 
	 */
	public void render (SpriteBatch batch) 
	{
		TextureRegion reg = null;
		reg = regCarrot;
		batch.draw(reg.getTexture(), position.x - origin.x, position.y - origin.y, origin.x, origin.y, 
		dimension.x, dimension.y, scale.x, scale.y, rotation, reg.getRegionX(), reg.getRegionY(), 
		reg.getRegionWidth(),reg.getRegionHeight(), false, false);
	}
}
	
