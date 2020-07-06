/* Author: Hunter Barnard
 * 
 * This class will be used for loading all of the asset managers and their contents
 * This will be the goto manager for loading and unloading textures to make thing simple
 * 
 */

package com.dalphin.engine.managers;

import com.dalphin.engine.debug.DebugUtil;

public class AssetManager {
	
	private TextureManager textureManager;
	private ItemManager itemManager;
	private BlockManager blockManager;
	private DebugUtil debug;
	/**
	 * 
	 * @param debug
	 */
	public AssetManager(DebugUtil debug) {
		this.debug = debug;
	}
	/**
	 * 
	 */
	public void InitManagers() {
		textureManager = new TextureManager(debug);
		textureManager.loadAllTextures();
		itemManager = new ItemManager(textureManager, debug);
		blockManager = new BlockManager(textureManager, debug);
	}
	/**
	 * 
	 */
	public void dispose() {
		textureManager.disposeAllTextures();
	}
	/**
	 * 
	 * @return textureManager
	 */
	public TextureManager textureManager() {
		return this.textureManager;
	}
	/**
	 * 
	 * @return itemManager
	 */
	public ItemManager itemManager() {
		return this.itemManager;
	}
	/**
	 * 
	 * @return blockManager
	 */
	public BlockManager blockManager() {
		return this.blockManager;
	}

}
