package com.dalphin.engine.item;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.dalphin.engine.debug.DebugUtil;
import com.dalphin.engine.loaders.TextureLoader;

public class Item2D {
	
	private String name;
	private Vector2 pos;
	private Texture texture;
	private TextureLoader textureLoader;
	private TextureRegion textureRegion;
	private float itemWidth = 16;
	private float itemHeight = 32;
	private Body body;
	private BodyDef bodyDef;
	private FixtureDef fixtureDef;
	private Fixture fixture;
	private boolean physicsBody = false;
	private boolean rotateBlock = false;
	private float density = 1f*((itemWidth/64)*(itemHeight/128));

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
	 * @param name
	 * @param texture
	 * @param textureWidth
	 * @param textureHeight
	 * @param debug
	 */
	public Item2D(String name, TextureRegion texture, int textureWidth, int textureHeight, DebugUtil debug) {
		this.textureRegion = texture;
		this.textureRegion.setRegion(texture.getRegionX(), texture.getRegionY(), texture.getRegionWidth() + textureWidth, texture.getRegionHeight() + textureHeight);
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
	 * @param textureXOffset
	 * @param textureYOffset
	 * @param textureWidth
	 * @param textureHeight
	 * @param debug
	 */
	public Item2D(String name, TextureRegion texture, int textureXOffset, int textureYOffset, int textureWidth, int textureHeight, DebugUtil debug) {
		this.textureRegion = texture;
		this.textureRegion.setRegion(texture.getRegionX() + textureXOffset, texture.getRegionY() + textureYOffset, texture.getRegionWidth() + textureWidth, texture.getRegionHeight() + textureHeight);
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
			if(physicsBody) {
				this.pos = new Vector2(body.getPosition().x - (itemWidth / 2), body.getPosition().y - (itemHeight / 2));
				if(rotateBlock) {
					batch.draw(textureRegion, pos.x, pos.y, this.itemWidth/2, this.itemHeight/2, itemWidth, itemHeight, 1, 1, body.getTransform().getRotation() * 57);
				}else {
					batch.draw(textureRegion, pos.x, pos.y, itemWidth, itemHeight);	
				}
			}else {
				batch.draw(textureRegion, pos.x, pos.y, itemWidth, itemHeight);
			}
				
		}else if(texture != null){
			if(physicsBody) {
				this.pos = new Vector2(body.getPosition().x - (itemWidth / 2), body.getPosition().y - (itemHeight / 2));
				if(rotateBlock) {
					batch.draw(textureRegion, pos.x, pos.y, 1, 1, itemWidth, itemHeight, 1, 1, body.getTransform().getRotation());

				}else {
					batch.draw(textureRegion, pos.x, pos.y, itemWidth, itemHeight);	
				}
			}else {
				batch.draw(textureRegion, pos.x, pos.y, itemWidth, itemHeight);
			}
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
	
	public float getItemWidth() {
		return this.itemWidth;
	}
	
	public float getItemHeight() {
		return this.itemHeight;
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
	
	public void setItemWidth(float width) {
		this.itemWidth = width;
	}
	
	public void setItemHeight(float height) {
		this.itemHeight = height;
	}
	/**
	 * 
	 * @param world
	 * @param bodyType
	 */
	public void createBody(World world, BodyType bodyType) {
		bodyDef = new BodyDef();
		bodyDef.type = bodyType;
		bodyDef.position.set(this.pos.x + (itemWidth / 2), this.pos.y + (itemHeight / 2));
		this.body = world.createBody(bodyDef);
		PolygonShape shape = new PolygonShape();
		shape.setAsBox(itemWidth/2, itemHeight/2);
		fixtureDef = new FixtureDef();
		fixtureDef.shape = shape;
		fixtureDef.density = density;
		fixture = body.createFixture(fixtureDef);
		shape.dispose();
		physicsBody = true;
	}
	/**
	 * 
	 * @param rotate
	 */
	public void canRotate(boolean rotate) {
		this.rotateBlock = rotate;
	}
	
}
