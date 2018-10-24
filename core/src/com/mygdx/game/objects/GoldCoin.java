/**
 * Andrew Stake
 * The object class for the gold coin
 */
package com.mygdx.game.objects;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx.game.Assets;
import com.badlogic.gdx.math.MathUtils;

public class GoldCoin extends AbstractGameObject
{	
	public boolean collected;
	
	public GoldCoin()
	{
		init();
	}
	
	/**
	 * Initializes the object, setting the animation and collision bounds
	 */
	private void init()
	{
		dimension.set(0.5f, 0.5f);
		
		setAnimation(Assets.instance.goldCoin.animGoldCoin);
		stateTime = MathUtils.random(0.0f, 1.0f);
				
		//Set bounding box for collision detection
		bounds.set(0, 0, dimension.x, dimension.y);
		
		collected = false;
	}
	
	/**
	 * Draws the coin to the screen
	 */
	public void render (SpriteBatch batch)
	{
		if(collected) return;
		
		TextureRegion reg = null;
		reg = (TextureRegion) animation.getKeyFrame(stateTime, true);
		
		batch.draw(reg.getTexture(), position.x, position.y, origin.x, origin.y, 
				dimension.x, dimension.y, scale.x, scale.y, rotation, reg.getRegionX(),
				reg.getRegionY(), reg.getRegionWidth(), reg.getRegionHeight(), false, false);
	}
	
	/**
	 * Returns an integer value for the amount of points gained for 
	 * picking up the coin
	 * @return 100
	 */
	public int getScore()
	{
		return 100;
	}
}
