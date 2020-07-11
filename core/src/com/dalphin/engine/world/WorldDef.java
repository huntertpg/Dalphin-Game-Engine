package com.dalphin.engine.world;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.dalphin.engine.block.Block2D;
import com.dalphin.engine.debug.DebugUtil;
import com.dalphin.engine.item.Item2D;
import com.dalphin.engine.managers.AnimationManager;
import com.dalphin.engine.managers.BlockManager;
import com.dalphin.engine.player.Player2D;

import box2dLight.Light;
import box2dLight.RayHandler;

public class WorldDef {

	private BlockManager blockManager;
	private AnimationManager animationManager;

	private OrthographicCamera camera;
	private DebugUtil debugUtil;
	private Vector2 gravity;
	private ArrayList<Item2D> items;
	private ArrayList<Light> lights;
	private ArrayList<Player2D> players;
	private ArrayList<Block2D> worldBlocks;
	private RayHandler rayHandler;
	private World world;
	

	public WorldDef(BlockManager blockManager) {
		gravity = new Vector2(0, 0);
		worldBlocks = new ArrayList<Block2D>();
		players = new ArrayList<Player2D>();
		items = new ArrayList<Item2D>();
		world = new World(new Vector2(gravity.x, gravity.y), true);
		lights = new ArrayList<Light>();

		this.blockManager = blockManager;
	}

	public WorldDef(BlockManager blockManager, float gravityX, float gravityY) {
		gravity = new Vector2(gravityX, gravityY);
		worldBlocks = new ArrayList<Block2D>();
		players = new ArrayList<Player2D>();
		items = new ArrayList<Item2D>();
		world = new World(new Vector2(gravityX, gravityY), true);
		lights = new ArrayList<Light>();

		this.blockManager = blockManager;
	}

	public WorldDef(BlockManager blockManager, float gravityX, float gravityY, RayHandler rayHandler) {
		gravity = new Vector2(gravityX, gravityY);
		worldBlocks = new ArrayList<Block2D>();
		players = new ArrayList<Player2D>();
		items = new ArrayList<Item2D>();
		world = new World(new Vector2(gravityX, gravityY), true);
		lights = new ArrayList<Light>();

		this.rayHandler = rayHandler;
		this.blockManager = blockManager;
	}

	public WorldDef(BlockManager blockManager, Vector2 gravity) {
		gravity = new Vector2(gravity);
		worldBlocks = new ArrayList<Block2D>();
		players = new ArrayList<Player2D>();
		items = new ArrayList<Item2D>();
		lights = new ArrayList<Light>();

		world = new World(new Vector2(gravity.x, gravity.y), true);

		this.blockManager = blockManager;
	}

	public WorldDef(BlockManager blockManager, Vector2 gravity, RayHandler rayHandler) {
		gravity = new Vector2(gravity);
		worldBlocks = new ArrayList<Block2D>();
		players = new ArrayList<Player2D>();
		items = new ArrayList<Item2D>();
		lights = new ArrayList<Light>();
		world = new World(new Vector2(gravity.x, gravity.y), true);

		this.rayHandler = rayHandler;
		this.blockManager = blockManager;
	}

	public void createRayHandler() {
		rayHandler = new RayHandler(world);
	}

	public void genWorld(DebugUtil debugUtil) {

	}
	

	/**
	 * @return the worldBlocks
	 */
	public ArrayList<Block2D> getWorldBlocks() {
		return worldBlocks;
	}

	public void renderWorld(Batch batch, float elapsedTime) {
		if (worldBlocks.size() >= 0) {
			for (int i = 0; i < worldBlocks.size(); i++) {
				worldBlocks.get(i).draw(batch);
			}
		}

		if (players.size() >= 0) {
			for (int i = 0; i < players.size(); i++) {
				players.get(i).draw(batch, elapsedTime);
			}
		}

		if (rayHandler != null) {
			batch.end();
			if(camera != null) {
				rayHandler.setCombinedMatrix(camera);
			}
			rayHandler.render();
			batch.begin();
		}

		if (items.size() >= 0) {
			for (int i = 0; i < items.size(); i++) {
				items.get(i).draw(batch);
			}
		}
		updateWorld();

	}

	public void updateWorld() {
		rayHandler.update();
		world.step(Gdx.graphics.getDeltaTime(), 6, 2);
	}
	
	public void dispose() {
		
		
		
		if(rayHandler != null) {
			rayHandler.dispose();
		}
		if(world != null) {
			world.dispose();
		}
	}

	/**
	 * @return the blockManager
	 */
	public BlockManager getBlockManager() {
		return blockManager;
	}

	/**
	 * @return the camera
	 */
	public OrthographicCamera getCamera() {
		return camera;
	}

	/**
	 * @return the debugUtil
	 */
	public DebugUtil getDebugUtil() {
		return debugUtil;
	}

	/**
	 * @return the gravity
	 */
	public Vector2 getGravity() {
		return gravity;
	}

	/**
	 * @return the items
	 */
	public ArrayList<Item2D> getItems() {
		return items;
	}

	/**
	 * @return the lights
	 */
	public ArrayList<Light> getLights() {
		return lights;
	}

	/**
	 * @return the players
	 */
	public ArrayList<Player2D> getPlayers() {
		return players;
	}

	/**
	 * @return the rayHandler
	 */
	public RayHandler getRayHandler() {
		return rayHandler;
	}

	/**
	 * @return the world
	 */
	public World getWorld() {
		return world;
	}

	/**
	 * @param blockManager the blockManager to set
	 */
	public void setBlockManager(BlockManager blockManager) {
		this.blockManager = blockManager;
	}

	/**
	 * @param camera the camera to set
	 */
	public void setCamera(OrthographicCamera camera) {
		this.camera = camera;
	}

	/**
	 * @param debugUtil the debugUtil to set
	 */
	public void setDebugUtil(DebugUtil debugUtil) {
		this.debugUtil = debugUtil;
	}

	/**
	 * @param gravity the gravity to set
	 */
	public void setGravity(Vector2 gravity) {
		this.gravity = gravity;
		world.setGravity(gravity);
	}

	/**
	 * @param items the items to set
	 */
	public void setItems(ArrayList<Item2D> items) {
		this.items = items;
	}

	/**
	 * @param lights the lights to set
	 */
	public void setLights(ArrayList<Light> lights) {
		this.lights = lights;
	}

	/**
	 * @param players the players to set
	 */
	public void setPlayers(ArrayList<Player2D> players) {
		this.players = players;
	}

	/**
	 * @param rayHandler the rayHandler to set
	 */
	public void setRayHandler(RayHandler rayHandler) {
		this.rayHandler = rayHandler;
	}

	/**
	 * @param world the world to set
	 */
	public void setWorld(World world) {
		this.world = world;
	}

	/**
	 * @param worldBlocks the worldBlocks to set
	 */
	public void setWorldBlocks(ArrayList<Block2D> worldBlocks) {
		this.worldBlocks = worldBlocks;
	}
	
	/**
	 * @return the animationManager
	 */
	public AnimationManager getAnimationManager() {
		return animationManager;
	}

	/**
	 * @param animationManager the animationManager to set
	 */
	public void setAnimationManager(AnimationManager animationManager) {
		this.animationManager = animationManager;
	}

}
