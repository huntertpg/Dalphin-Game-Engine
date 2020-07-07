/**
 * @author Hunter Barnard
 * This class is the base block class for creating all 2D Blocks.
 * This defines what a block is with its block Width, height, name, texture or texture
 * region. This also uses Vector2 for positioning data on the X and Y planes. 
 */
package com.dalphin.engine.block;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.dalphin.engine.debug.DebugUtil;
import com.dalphin.engine.loaders.TextureLoader;

public class Block2D {
	private int blockHeight = 32;
	private int blockWidth = 32;
	private DebugUtil debugUtil;
	private String name;
	private Vector2 pos;
	private Texture texture;
	private TextureLoader textureLoader;
	private TextureRegion textureRegion;
	private Body body;
	private BodyDef bodyDef;
	private FixtureDef fixtureDef;
	private Fixture fixture;
	private boolean physicsBody = false;
	private boolean rotateBlock = false;
	
	/**
	 * 
	 * @param name
	 * @param path
	 * @param debug
	 */
	public Block2D(String name, String path, DebugUtil debug) {
		debugUtil = new DebugUtil();
		this.texture = textureLoader.loadTexture(path);
		this.name = name;
		pos = new Vector2();
		if(debug.isEnabled()) {
			debug.printAssetLoading(this);
		}
	}
	/**
	 * 
	 * @param name
	 * @param path
	 * @param blockWidth
	 * @param blockHeight
	 * @param debug
	 */
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
	/**
	 * 
	 * @param name
	 * @param texture
	 * @param debug
	 */
	public Block2D(String name, Texture texture, DebugUtil debug) {
		debugUtil = new DebugUtil();
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
	 * @param blockWidth
	 * @param blockHeight
	 * @param debug
	 */
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
	/**
	 * 
	 * @param name
	 * @param texture
	 * @param debug
	 */
	public Block2D(String name, TextureRegion texture, DebugUtil debug) {
		debugUtil = new DebugUtil();
		this.textureRegion = texture;
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
	 * @param blockWidth
	 * @param blockHeight
	 */
	public Block2D(String name, TextureRegion texture, int blockWidth, int blockHeight) {
		debugUtil = new DebugUtil();
		this.textureRegion = texture;
		this.name = name;
		this.blockWidth = blockWidth;
		this.blockHeight = blockHeight;
		pos = new Vector2();
	}
	/**
	 * 
	 * @param name
	 * @param texture
	 * @param blockWidth
	 * @param blockHeight
	 * @param debug
	 */
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
	
	
	/**
	 * 
	 * @param batch
	 */
	public void draw(Batch batch) {
		if(texture == null) {
			batch.draw(textureRegion, pos.x, pos.y);	
		}else {
			batch.draw(texture, pos.x, pos.y);
			if(physicsBody) {
				this.pos = body.getPosition();
				if(rotateBlock) {
					batch.draw(textureRegion, pos.x, pos.y, 1, 1, blockWidth, blockHeight, 1, 1, body.getAngle()* 100);	
				}else {
					batch.draw(textureRegion, pos.x, pos.y, blockWidth, blockHeight);	
				}
			}else {
				batch.draw(textureRegion, pos.x, pos.y, blockWidth, blockHeight);
			}
				
		}else {
			if(physicsBody) {
				this.pos = body.getPosition();
				if(rotateBlock) {
					batch.draw(textureRegion, pos.x, pos.y, 1, 1, blockWidth, blockHeight, 1, 1, body.getAngle()* 100);	
				}else {
					batch.draw(textureRegion, pos.x, pos.y, blockWidth, blockHeight);	
				}
			}else {
				batch.draw(textureRegion, pos.x, pos.y, blockWidth, blockHeight);
			}
		}
		
	}
	/**
	 * 
	 * @param batch
	 * @param scale
	 */
	public void draw(Batch batch, float scale) {
		if(texture == null) {
			batch.draw(textureRegion, pos.x, pos.y, blockWidth * scale, blockHeight * scale);	
		}else {
			batch.draw(texture, pos.x, pos.y);
		}
		
	}
	/**
	 * 
	 * @return blockHeight
	 */
	public int getBlockHeight() {
		return blockHeight;
	}
	/**
	 * 
	 * @return blockWidth
	 */
	public int getBlockWidth() {
		return blockWidth;
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
	 * @return textureRegion
	 */
	public TextureRegion getTextureRegion() {
		return textureRegion;
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
		return pos.y;
	}
	public Body getBody() {
		return this.body;
	}
	/**
	 * 
	 * @param blockHeight
	 */
	public void setBlockHeight(int blockHeight) {
		this.blockHeight = blockHeight;
	}
	/**
	 * 
	 * @param blockWidth
	 */
	public void setBlockWidth(int blockWidth) {
		this.blockWidth = blockWidth;
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
	 * @param textureRegion
	 */
	public void setTextureRegion(TextureRegion textureRegion) {
		this.textureRegion = textureRegion;
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
	
	public void update() {
		
	}
	
	public void createBody(World world, BodyType bodyType) {
		bodyDef = new BodyDef();
		bodyDef.type = bodyType;
		bodyDef.position.set(this.pos);
		this.body = world.createBody(bodyDef);
		PolygonShape shape = new PolygonShape();
		shape.setAsBox(blockWidth/2, blockHeight/2);
		fixtureDef = new FixtureDef();
		fixtureDef.shape = shape;
		fixtureDef.density = density;
		fixture = body.createFixture(fixtureDef);
		shape.dispose();
		physicsBody = true;
	}
	
	public void canRotate(boolean rotate) {
		this.rotateBlock = rotate;
	}
	
}
