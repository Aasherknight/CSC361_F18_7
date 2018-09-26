package com.mygdx.game.objects;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx.game.Assets;

public class Feather extends AbstractGameObject
{
	private TextureRegion regFeather;
	
	//Tracks if the object has been collected by the player
	public boolean collected;
	
	public Feather()
	{
		init();
	}
	
	private void init()
	{
		//sets the dimensions of the object
		dimension.set(0.5f,0.5f);
		
		//sets the texture for the object
		regFeather = Assets.instance.feather.feather;
		
		//sets bounding box for collision detection
		bounds.set(0,0,dimension.x,dimension.y);
	}
	
	@Override
	public void render(SpriteBatch batch) 
	{
		//do not render if the item has been collected already
		if(collected) return;
		
		TextureRegion reg = null;
		reg = regFeather;
		batch.draw(reg.getTexture(), position.x, position.y, origin.x, origin.y,
				dimension.x, dimension.y, scale.x, scale.y, rotation, reg.getRegionX(),
				reg.getRegionY(), reg.getRegionWidth(), reg.getRegionHeight(), false, false);
	}
	
	public int getScore()
	{
		return 250;
	}
}
