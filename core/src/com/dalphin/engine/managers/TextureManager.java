/** @author: Hunter Barnard
 * 
 * The Purpose of this class is to load textures into memory and manage them
 * It does this by using a get method (currently not in use). It also disposes them
 * when the game closes
 * 
 * To-Do:
 * Add ID system used for texture identification
 * Add Error excepting for missing textures (If a texture isn't found use Missing Texture)
 * 
 */

package com.dalphin.engine.managers;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.dalphin.engine.debug.DebugUtil;
import com.dalphin.engine.loaders.TextureLoader;
import com.dalphin.engine.util.SpriteSheetLoader;

public class TextureManager {
	
	private DebugUtil debugUtil;
	
	//declare texture loader for actually loading the textures
	private TextureLoader textureLoader;
	
	//declare an ArrayList of textures for holding all the textures(Might be used for ID system later)
	private ArrayList<Texture> textureList;
	
	//Declare the texture brick
	public Texture brick;
	
	//Declare the texture Star
	public Texture star;
	
	//Declare the texture Missing Texture
	public Texture missingTexture;
	
	public Texture playerSheet;
	
	public TextureRegion[][] dungeonSpriteSheet;
	
	SpriteSheetLoader spriteLoader;
	
	/**
	 * for debugging purposes this needs to be passed in will be deprecated
	 * @param DebugUtil
	 */
	public TextureManager(DebugUtil debugUtil) {
		
		this.debugUtil = debugUtil;
		
		//Init the Texture ArrayList
		textureList = new ArrayList<Texture>();
		
		//Init the Texture Loader
		textureLoader = new TextureLoader(debugUtil);
		
		spriteLoader  = new SpriteSheetLoader(textureLoader);
	}
	
	/**
	 * Method for loading all the textures into memory. This needs to be done or a null pointer will be thrown
	 */
	public void loadAllTextures() {
		
		//load the missing texture texture and add it to the texture arraylist
		missingTexture = textureLoader.loadTexture("MissingTexture.png");
		textureList.add(missingTexture);
		
		
		//load the brick texture and add it to the texture arraylist
		brick = textureLoader.loadTexture("Brick.png");
		textureList.add(brick);
		
		//load the star texture (it's just a white block because I haven't gotten pixel editing to work
		//lol) and add it to the texture arraylist
		star = textureLoader.loadTexture("Star.png");
		textureList.add(star);
		
		playerSheet = new Texture("TestSheet.png");
		textureList.add(playerSheet);
		
		dungeonSpriteSheet = spriteLoader.loadSpriteSheet("DunTile.png", 8, 13, 16, 16);
		
		
	}
	
	/**
	 * This method for getting a texture
	 * @return texture
	 */
	public Texture getTexture() {
		return this.brick;
	}
	
	/**
	 * This method properly disposes of all textures - do this or else there will be a memory leak
	 */
	public void disposeAllTextures() {
		for(int i = 0; i < textureList.size(); i++) {
			textureList.get(i).dispose();
		}
	}

}
