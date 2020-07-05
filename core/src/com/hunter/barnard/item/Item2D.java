package com.hunter.barnard.item;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;
import com.hunter.barnard.debug.DebugUtil;
import com.hunter.barnard.loaders.TextureLoader;

public class Item2D {
	
	private TextureLoader textureLoader;
	private Texture texture;
	private String name;
	private Vector2 pos;
	public Item2D(String name, Texture texture, DebugUtil debug) {
		this.texture = texture;
		this.name = name;
		pos = new Vector2();
		if(debug.isEnabled()) {
			debug.printAssetLoading(this);
		}
	}
	
	public Texture getTexture() {
		return texture;
	}
	public void setTexture(Texture texture) {
		this.texture = texture;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getxPos() {
		return pos.x;
	}
	public void setxPos(float xPos) {
		this.pos.x = xPos;
	}
	public float getyPos() {
		return this.pos.y;
	}
	public void setyPos(float yPos) {
		this.pos.y = yPos;
	}
	public Vector2 getPos() {
		return this.pos;
	}
	public void setPos(Vector2 pos) {
		this.pos = pos;
	}
	
	public void draw(Batch batch) {
		batch.draw(this.getTexture(), this.pos.x, this.pos.y);
	}
	
}
