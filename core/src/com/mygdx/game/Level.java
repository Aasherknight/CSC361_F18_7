package com.mygdx.game;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Level 
{
	public static final String TAG = Level.class.getName();
	
	public enum BLOCK_TYPE
	{
		EMPTY(0,0,0), 					//Black
		ROCK(0,255,0), 					//Green
		PLAYER_SPAWNPOINT(255,255,255),	//White
		ITEM_FEATHER(255,0,255),		//Purple
		ITEM_GOLD_COIN(255,255,0);		//Yellow
		
		private int color;
		
		private BLOCK_TYPE(int r, int g, int b)
		{
			color = r << 24 | g << 16 | b << 8 | 0xff;
		}
		
		public boolean sameColor(int color)	
		{
			return this.color == color;
		}
		
		public int getColor()
		{
			return color;
		}
	}
	
	//objects
	public Array<Rock> rocks;
	
	decoration
	public Clouds clouds;
	public Mountains mountains;
	public WaterOverlay waterOverlay;
	
	public Level (String filename)
	{
		init(filename);
	}
	
	private void init(String filename)
	{

	}
	
	public void render(SpriteBatch batch)
	{
		
	}
	
}
