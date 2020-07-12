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
	private float density = 1f * ((blockHeight / 32) * (blockWidth / 32));
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
	private float rotation = 0;
	private int blockID;

	/**
	 * 
	 * @param name
	 * @param path
	 * @param debug
	 */
	public Block2D(String name, int blockID, String path, DebugUtil debug) {
		debugUtil = new DebugUtil();
		this.pos = new Vector2();
		this.blockID = blockID;

		this.texture = textureLoader.loadTexture(path);
		this.name = name;
		pos = new Vector2();
		if (debug.isEnabled()) {
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
	public Block2D(String name, int blockID, String path, int blockWidth, int blockHeight, DebugUtil debug) {
		debugUtil = new DebugUtil();
		this.pos = new Vector2();
		this.blockID = blockID;
		this.texture = textureLoader.loadTexture(path);
		this.blockWidth = blockWidth;
		this.blockHeight = blockHeight;
		this.name = name;
		pos = new Vector2();
		if (debug.isEnabled()) {
			debug.printAssetLoading(this);
		}
	}

	/**
	 * 
	 * @param name
	 * @param texture
	 * @param debug
	 */
	public Block2D(String name,int blockID, Texture texture, DebugUtil debug) {
		debugUtil = new DebugUtil();
		this.pos = new Vector2();
		this.blockID = blockID;
		this.texture = texture;
		this.name = name;
		pos = new Vector2();
		if (debug.isEnabled()) {
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
	public Block2D(String name, int blockID, Texture texture, int blockWidth, int blockHeight, DebugUtil debug) {
		debugUtil = new DebugUtil();
		this.pos = new Vector2();
		this.blockID = blockID;
		this.name = name;
		this.texture = texture;
		this.blockWidth = blockWidth;
		this.blockHeight = blockHeight;
		pos = new Vector2();
		if (debug.isEnabled()) {
			debug.printAssetLoading(this);
		}
	}

	/**
	 * 
	 * @param name
	 * @param texture
	 * @param debug
	 */
	public Block2D(String name, int blockID, TextureRegion texture, DebugUtil debug) {
		debugUtil = new DebugUtil();
		this.pos = new Vector2();
		this.blockID = blockID;
		this.textureRegion = texture;
		this.name = name;
		pos = new Vector2();
		if (debug.isEnabled()) {
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
	public Block2D(String name, int blockID, TextureRegion texture, int blockWidth, int blockHeight) {
		debugUtil = new DebugUtil();
		this.pos = new Vector2();
		this.blockID = blockID;
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
	public Block2D(String name, int blockID, TextureRegion texture, int blockWidth, int blockHeight, DebugUtil debug) {
		debugUtil = new DebugUtil();
		this.pos = new Vector2();
		this.blockID = blockID;
		this.textureRegion = texture;
		this.name = name;
		this.blockWidth = blockWidth;
		this.blockHeight = blockHeight;
		pos = new Vector2();
		if (debug.isEnabled()) {
			debug.printAssetLoading(this);
		}
	}

	/**
	 * 
	 * @param batch
	 */
	public void draw(Batch batch) {
		if (texture == null) {
			if (physicsBody) {
				this.pos = new Vector2(body.getPosition().x - (blockWidth / 2),
						body.getPosition().y - (blockHeight / 2));
				if (rotateBlock) {
					batch.draw(textureRegion, pos.x, pos.y, this.blockWidth / 2, this.blockHeight / 2, blockWidth,
							blockHeight, 1, 1, body.getTransform().getRotation() * 57);
				} else {
					// batch.draw(textureRegion, pos.x, pos.y, blockWidth, blockHeight);
					batch.draw(textureRegion, pos.x, pos.y, 1, 1, blockWidth, blockHeight, 1, 1, rotation);
				}
			} else {
				if (rotateBlock) {
					batch.draw(textureRegion, pos.x, pos.y, 1, 1, blockWidth, blockHeight, 1, 1, rotation);

				} else {
					batch.draw(textureRegion, pos.x, pos.y, blockWidth, blockHeight);
				}

			}

		} else if (texture != null) {
			if (physicsBody) {
				this.pos = new Vector2(body.getPosition().x - (blockWidth / 2),
						body.getPosition().y - (blockHeight / 2));
				if (rotateBlock) {
					batch.draw(textureRegion, pos.x, pos.y, 1, 1, blockWidth, blockHeight, 1, 1,
							body.getTransform().getRotation());

				} else {
					batch.draw(textureRegion, pos.x, pos.y, blockWidth, blockHeight);
				}
			} else {
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
		if (texture == null) {
			batch.draw(textureRegion, pos.x, pos.y, blockWidth * scale, blockHeight * scale);
		} else {
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

	/**
	 * This is the update method for the block - probably doesn't need to be updated
	 */
	public void update() {

	}

	/**
	 * This function creates the physical body of the block. This is for floors and
	 * other tiles that don't need physical reaction (this is optional for right now
	 * but layered rendering might be a thing later on so light doesn't get blocked
	 * by the floor).
	 * 
	 * @param world
	 * @param bodyType
	 */
	public void createBody(World world, BodyType bodyType) {
		bodyDef = new BodyDef();
		bodyDef.type = bodyType;
		bodyDef.position.set(this.pos.x + (blockWidth / 2), this.pos.y + (blockHeight / 2));
		this.body = world.createBody(bodyDef);
		PolygonShape shape = new PolygonShape();
		shape.setAsBox(blockWidth / 2, blockHeight / 2);
		fixtureDef = new FixtureDef();
		fixtureDef.shape = shape;
		fixtureDef.density = density;
		fixture = body.createFixture(fixtureDef);
		shape.dispose();
		physicsBody = true;
	}

	/**
	 * This is method that simply sets the block to rotate to the physical body of
	 * the block.
	 * 
	 * @param rotate
	 */
	public void canRotate(boolean rotate) {
		this.rotateBlock = rotate;
	}
	
	public boolean getCanRotate() {
		return this.rotateBlock;
	}

	/**
	 * This method returns a new block. This is mainly for world gen right now.
	 * 
	 * @return Block2D
	 */
	public Block2D createBlock() {
		return new Block2D(this.getName(), this.blockID, this.getTextureRegion(), this.getBlockWidth(), this.getBlockHeight(),
				this.getDebug());
	}

	/**
	 * This gets the debugUtil for the class
	 * 
	 * @return debugUtil
	 */
	public DebugUtil getDebug() {
		return this.debugUtil;
	}

	public void setRotation(float rotation) {
		this.rotation = rotation;
		if (body != null) {
			body.setTransform(body.getTransform().getPosition(), rotation);
		}
	}
	
	public float getRotation() {
		if(body != null) {
			return this.body.getTransform().getRotation();
		}else {
			return this.rotation;	
		}
		
	}
	
	public int getBlockID() {
		return this.blockID;
	}

}
