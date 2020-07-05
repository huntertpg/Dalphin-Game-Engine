package com.dalphin.engine.block;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.dalphin.engine.debug.DebugUtil;
import com.dalphin.engine.loaders.TextureLoader;

public class Block2D {
	private TextureLoader textureLoader;
	private Texture texture;
	private TextureRegion textureRegion;
	private String name;
	private Vector2 pos;
	private int blockWidth = 32;
	private int blockHeight = 32;
	private DebugUtil debugUtil;

	public Block2D(String name, String path, DebugUtil debug) {
		debugUtil = new DebugUtil();
		this.texture = textureLoader.loadTexture(path);
		this.name = name;
		pos = new Vector2();
		if(debug.isEnabled()) {
			debug.printAssetLoading(this);
		}
	}
	
	public Block2D(String name, Texture texture, DebugUtil debug) {
		debugUtil = new DebugUtil();
		this.texture = texture;
		this.name = name;
		pos = new Vector2();
		if(debug.isEnabled()) {
			debug.printAssetLoading(this);
		}
	}
	
	public Block2D(String name, TextureRegion texture, DebugUtil debug) {
		debugUtil = new DebugUtil();
		this.textureRegion = texture;
		this.name = name;
		pos = new Vector2();
		if(debug.isEnabled()) {
			debug.printAssetLoading(this);
		}
	}
	
	public Block2D(String name, String path, int blockWidth, int blockHeight, DebugUtil debug) {
		debugUtil = new DebugUtil();
		this.texture = textureLoader.loadTexture(path);
		this.blockWidth = blockWidth;
		this.blockHeight = blockHeight;
		this.name = name;
		pos = new Vector2();
		if(debug.isEnabled()) {
			debug.printAssetLoading(this);
		}
	}
	
	public Block2D(String name, Texture texture, int blockWidth, int blockHeight, DebugUtil debug) {
		debugUtil = new DebugUtil();
		this.name = name;
		this.texture = texture;
		this.blockWidth = blockWidth;
		this.blockHeight = blockHeight;
		pos = new Vector2();
		if(debug.isEnabled()) {
			debug.printAssetLoading(this);
		}
	}
	
	public Block2D(String name, TextureRegion texture, int blockWidth, int blockHeight) {
		debugUtil = new DebugUtil();
		this.textureRegion = texture;
		this.name = name;
		this.blockWidth = blockWidth;
		this.blockHeight = blockHeight;
		pos = new Vector2();
	}
	
	public Block2D(String name, TextureRegion texture, int blockWidth, int blockHeight, DebugUtil debug) {
		debugUtil = new DebugUtil();
		this.textureRegion = texture;
		this.name = name;
		this.blockWidth = blockWidth;
		this.blockHeight = blockHeight;
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
		return pos.y;
	}
	
	public Vector2 getPos() {
		return this.pos;
	}
	
	public void setyPos(float yPos) {
		this.pos.y = yPos;
	}
	
	public void setPos(Vector2 pos) {
		this.pos = pos;
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
			batch.draw(textureRegion, pos.x, pos.y);	
		}else {
			batch.draw(texture, pos.x, pos.y);
		}
		
	}
	
	public void draw(Batch batch, float scale) {
		if(texture == null) {
			batch.draw(textureRegion, pos.x, pos.y, blockWidth * scale, blockHeight * scale);	
		}else {
			batch.draw(texture, pos.x, pos.y);
		}
		
	}
	
	
}
