package com.dalphin.engine.item;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.dalphin.engine.debug.DebugUtil;
import com.dalphin.engine.loaders.TextureLoader;

public class Item2D {
	
	private String name;
	private Vector2 pos;
	private Texture texture;
	private TextureLoader textureLoader;
	private TextureRegion textureRegion;
	/**
	 * 
	 * @param name
	 * @param texture
	 * @param debug
	 */
	public Item2D(String name, Texture texture, DebugUtil debug) {
		this.texture = texture;
		this.name = name;
		pos = new Vector2();
		if(debug.isEnabled()) {
			debug.printAssetLoading(this);
		}
	}
	/**
	 * 
	 * @param name
	 * @param texture
	 * @param debug
	 */
	public Item2D(String name, TextureRegion texture, DebugUtil debug) {
		this.textureRegion = texture;
		this.name = name;
		pos = new Vector2();
		if(debug.isEnabled()) {
			debug.printAssetLoading(this);
		}
	}
	/**
	 * 
	 * @param batch
	 */
	public void draw(Batch batch) {
		if(texture == null) {
			batch.draw(this.textureRegion, this.pos.x, this.pos.y);
		}else {
			batch.draw(this.getTexture(), this.pos.x, this.pos.y);
		}
		
	}
	/**
	 * 
	 * @return name
	 */
	public String getName() {
		return name;
	}
	/**
	 * 
	 * @return pos
	 */
	public Vector2 getPos() {
		return this.pos;
	}
	/**
	 * 
	 * @return texture
	 */
	public Texture getTexture() {
		return texture;
	}
	/**
	 * 
	 * @return pos.x
	 */
	public float getxPos() {
		return pos.x;
	}
	/**
	 * 
	 * @return pos.y
	 */
	public float getyPos() {
		return this.pos.y;
	}
	/**
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 
	 * @param pos
	 */
	public void setPos(Vector2 pos) {
		this.pos = pos;
	}
	/**
	 * 
	 * @param texture
	 */
	public void setTexture(Texture texture) {
		this.texture = texture;
	}
	/**
	 * 
	 * @param xPos
	 */
	public void setxPos(float xPos) {
		this.pos.x = xPos;
	}
	/**
	 * 
	 * @param yPos
	 */
	public void setyPos(float yPos) {
		this.pos.y = yPos;
	}
	
}
