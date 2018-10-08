/**
 * Andrew Stake
 */

package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.assets.AssetErrorListener;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.utils.Disposable;
import com.mygdx.game.util.Constants;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;

/**
 * @author Jeff
 * Class for managing the various game assets and handing them as objects
 * to the appropriate classes
 *
 */
public class Assets implements Disposable, AssetErrorListener
{
	public static final String TAG = Assets.class.getName();
	
	public static final Assets instance = new Assets();
	
	private AssetManager assetManager;
	
	public AssetSounds sounds;
	public AssetMusic music;
	
	/**
	 * @author Jeff
	 * Class to manage all ingame sounds
	 */
	public class AssetSounds 
	{
		 public final Sound jump;
		 public final Sound jumpWithFeather;
		 public final Sound pickupCoin;
		 public final Sound pickupFeather;
		 public final Sound liveLost;
		 public AssetSounds (AssetManager am) 
		 {
			 jump = am.get("sounds/jump.wav", Sound.class);
			 jumpWithFeather = am.get("sounds/jump_with_feather.wav",Sound.class);
			 pickupCoin = am.get("sounds/pickup_coin.wav", Sound.class);
			 pickupFeather = am.get("sounds/pickup_feather.wav",Sound.class);
			 liveLost = am.get("sounds/live_lost.wav", Sound.class);
		 }
	}
	/**
	 * @author Jeff
	 * Class to manage all in-game music files
	 */
	public class AssetMusic 
	{
		public final Music song01;
		public AssetMusic (AssetManager am) 
		{
			song01 = am.get("music/keith303_-_brand_new_highscore.mp3",Music.class);
		}
	}
	
	//singleton: prevent instantiation from other classes
	private Assets() {}
	
	 public AssetBunny bunny;
	 public AssetRock rock;
	 public AssetGoldCoin goldCoin;
	 public AssetFeather feather;
	 public AssetLevelDecoration levelDecoration;
	 public AssetFonts fonts;
	 public class AssetFonts {
	 public final BitmapFont defaultSmall;
	 public final BitmapFont defaultNormal;
	 public final BitmapFont defaultBig;
	 
	 public AssetFonts () {
		 // create three fonts using Libgdx's 15px bitmap font
		 defaultSmall = new BitmapFont(new FileHandle("../core/assets/arial-15.fnt"), true);
		 defaultNormal = new BitmapFont(new FileHandle("../core/assets/arial-15.fnt"), true);
		 defaultBig = new BitmapFont(new FileHandle("../core/assets/arial-15.fnt"), true);
		 // set font sizes
		 defaultSmall.getData().setScale(0.75f);
		 defaultNormal.getData().setScale(1.0f);
		 defaultBig.getData().setScale(2.0f);
		 
		 // enable linear texture filtering for smooth fonts
		 defaultSmall.getRegion().getTexture().setFilter(
		 TextureFilter.Linear, TextureFilter.Linear);
		 defaultNormal.getRegion().getTexture().setFilter(
		 TextureFilter.Linear, TextureFilter.Linear);
		 defaultBig.getRegion().getTexture().setFilter(
		 TextureFilter.Linear, TextureFilter.Linear);
		 }
	 }
	
	public void init(AssetManager assetManager)
	{
		this.assetManager = assetManager;
		//set assent manager error handler
		assetManager.setErrorListener(this);
		//load texture atlas
		assetManager.load(Constants.TEXTURE_ATLAS_OBJECTS, TextureAtlas.class);
		//start loading assets and wait until finished
		assetManager.finishLoading();
		Gdx.app.debug(TAG, "# of assets loaded: " + assetManager.getAssetNames());
		
		for (String a : assetManager.getAssetNames())
			Gdx.app.debug(TAG, "asset: " + a);
		
		TextureAtlas atlas = new TextureAtlas(Constants.TEXTURE_ATLAS_OBJECTS);
		// load sounds
		 assetManager.load("sounds/jump.wav", Sound.class);
		 assetManager.load("sounds/jump_with_feather.wav", Sound.class);
		 assetManager.load("sounds/pickup_coin.wav", Sound.class);
		 assetManager.load("sounds/pickup_feather.wav", Sound.class);
		 assetManager.load("sounds/live_lost.wav", Sound.class);
		 // load music
		 assetManager.load("music/keith303_-_brand_new_highscore.mp3",Music.class);
		
		//enable texture filtering for pixel smoothing
		for(Texture t : atlas.getTextures())
		{
			t.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		}
		
		//create game resource objects
		fonts = new AssetFonts();
		bunny = new AssetBunny(atlas);
		rock = new AssetRock(atlas);
		goldCoin = new AssetGoldCoin(atlas);
		feather = new AssetFeather(atlas);
		levelDecoration = new AssetLevelDecoration(atlas);
		sounds = new AssetSounds(assetManager);
		music = new AssetMusic(assetManager);
	}
	
	@Override
	public void dispose()
	{
		assetManager.dispose();
		fonts.defaultSmall.dispose();
		fonts.defaultNormal.dispose();
		fonts.defaultBig.dispose();
	}
	
	//Removed @Override due to no error method with these parameter is AssetErrorListener interface
	public void error(String filename, Class type, Throwable throwable)
	{
		Gdx.app.error(TAG, "Couldn't load asset '" + filename + "'", (Exception)throwable);
	}
	
	@Override
	public void error(AssetDescriptor asset, Throwable throwable)
	{
		Gdx.app.error(TAG, "Couldn't load asset '" + asset.fileName + "'", (Exception)throwable);
	}
	
	public class AssetLevelDecoration
	{
		public final AtlasRegion cloud01;
		public final AtlasRegion cloud02;
		public final AtlasRegion cloud03;
		public final AtlasRegion mountainLeft;
		public final AtlasRegion mountainRight;
		public final AtlasRegion waterOverlay;
		
		public AssetLevelDecoration(TextureAtlas atlas)
		{
			cloud01 = atlas.findRegion("cloud01");
			cloud02 = atlas.findRegion("cloud02");
			cloud03 = atlas.findRegion("cloud03");
			mountainLeft = atlas.findRegion("mountain_left");
			mountainRight = atlas.findRegion("mountain_right");
			waterOverlay = atlas.findRegion("water_overlay");
		}
	}
	
	public class AssetBunny
	{
		//The actual asset to be used for this object
		public final AtlasRegion head;
		
		//Create the object and give it's sprite the proper image
		public AssetBunny(TextureAtlas atlas)
		{
			head = atlas.findRegion("bunny_head");
		}
	}
	
	public class AssetRock
	{
		//The two different types of rocks are edges and the middle
		public final AtlasRegion edge;
		public final AtlasRegion middle;
		
		//Create the object and give it's sprites their proper image
		public AssetRock (TextureAtlas atlas)
		{
			edge = atlas.findRegion("rock_edge");
			middle = atlas.findRegion("rock_middle");
		}
	}
	
	public class AssetGoldCoin
	{
		//The actual asset to be used for this object
		public final AtlasRegion goldCoin;
		
		//Create the object and give it's sprite the proper image
		public AssetGoldCoin(TextureAtlas atlas)
		{
			goldCoin = atlas.findRegion("item_gold_coin");
		}
	}
	
	public class AssetFeather
	{
		//The actual asset to be used for this object
		public final AtlasRegion feather;
		
		//Create the object and give it's sprite the proper image
		public AssetFeather(TextureAtlas atlas)
		{
			feather = atlas.findRegion("item_feather");
		}
	}
}







