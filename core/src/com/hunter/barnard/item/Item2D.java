package com.hunter.barnard.item;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.hunter.barnard.loaders.TextureLoader;

public class Item2D {
	
	private TextureLoader textureLoader;
	private Texture texture;
	private String name;
	private float xPos = 0;
	private float yPos = 0;
	
	public Item2D(String name, String path) {
		textureLoader = new TextureLoader();
			this.texture = textureLoader.loadTexture(path);	
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
		return xPos;
	}
	public void setxPos(float xPos) {
		this.xPos = xPos;
	}
	public float getyPos() {
		return yPos;
	}
	public void setyPos(float yPos) {
		this.yPos = yPos;
	}
	
	public void draw(Batch batch) {
		batch.draw(this.getTexture(), this.xPos, this.yPos);
	}
	
}
