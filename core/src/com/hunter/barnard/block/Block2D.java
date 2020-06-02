package com.hunter.barnard.block;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.hunter.barnard.loaders.TextureLoader;

public class Block2D {
	private TextureLoader textureLoader;
	private Texture texture;
	private TextureRegion textureRegion;
	private String name;
	private float xPos;
	private float yPos;
	private int blockWidth = 32;
	private int blockHeight = 32;
	

	public Block2D(String name, String path) {
		textureLoader = new TextureLoader();
		this.texture = textureLoader.loadTexture(path);
		this.name = name;
	}
	
	public Block2D(String name, Texture texture) {
		this.texture = texture;
		this.name = name;
	}
	
	public Block2D(String name, TextureRegion texture) {
		this.textureRegion = texture;
		this.name = name;
	}
	
	public Block2D(String name, String path, int blockWidth, int blockHeight) {
		textureLoader = new TextureLoader();
		this.texture = textureLoader.loadTexture(path);
		this.blockWidth = blockWidth;
		this.blockHeight = blockHeight;
		this.name = name;
	}
	
	public Block2D(String name, Texture texture, int blockWidth, int blockHeight) {
		this.name = name;
		this.texture = texture;
		this.blockWidth = blockWidth;
		this.blockHeight = blockHeight;
	}
	
	public Block2D(String name, TextureRegion texture, int blockWidth, int blockHeight) {
		this.textureRegion = texture;
		this.name = name;
		this.blockWidth = blockWidth;
		this.blockHeight = blockHeight;
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
	
	public TextureRegion getTextureRegion() {
		return textureRegion;
	}

	public void setTextureRegion(TextureRegion textureRegion) {
		this.textureRegion = textureRegion;
	}

	public int getBlockWidth() {
		return blockWidth;
	}

	public void setBlockWidth(int blockWidth) {
		this.blockWidth = blockWidth;
	}

	public int getBlockHeight() {
		return blockHeight;
	}

	public void setBlockHeight(int blockHeight) {
		this.blockHeight = blockHeight;
	}

	
	public void draw(Batch batch) {
		if(texture == null) {
			batch.draw(textureRegion, xPos, yPos);	
		}else {
			batch.draw(texture, xPos, yPos);
		}
		
	}
	
	public void draw(Batch batch, float scale) {
		if(texture == null) {
			batch.draw(textureRegion, xPos, yPos, blockWidth * scale, blockHeight * scale);	
		}else {
			batch.draw(texture, xPos, yPos);
		}
		
	}
	
	
}
