/*Author: Hunter Barnard
 * 
 * The purpose of this class is to render everything in 2D space
 * This will be called on by the main class to render, and in turn will call the world renderer class
 * to render the world, and so on. This classes main purpose is to really manage rendering rather than actually
 * render
 * 
 * This class also creates an orhtographic camera for 2D rendering
 */

package com.dalphin.engine.render;

import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.dalphin.engine.managers.TextureManager;
import com.dalphin.engine.player.TestPlayer;
import com.dalphin.engine.util.Animation2D;
import com.dalphin.engine.util.RandomUtil;

public class Basic2DRenderer {
	
	//the default viewport width for camera
	private int DEFAULTVIEWPORTWIDTH = 1280;
	
	//default viewport height for camera
	private int DEFAULTVIEWPORTHEIGHT = 720;
	
	//Viewport width and height used for creating camera
	private int viewPortWidth;
	private int viewPortHeight;
	
	
	//declare the camera
	private OrthographicCamera camera;
	
	//declare a spritebatch(currently it is the passed in sprite batch but will be changed later)
	private SpriteBatch batch;	
	
	//declare the texture manager(passed in by the main class)
	private TextureManager textureManager;
	
	//declare the random util for random numbers
	private RandomUtil randomUtil;
	
	float elapsedTime = 0;
	
	//create the basic 2d renderer from constructor that takes in a sprite batch and a texture manager
	public Basic2DRenderer(SpriteBatch batch, TextureManager textureManager) {
		
		//sets the class batch to the passed in batch
		this.batch = batch;
		
		//sets the texture manager to the passed in manager
		this.textureManager = textureManager;
		
		//sets the cameras viewport width and height to default values as none are provided
		this.viewPortWidth = DEFAULTVIEWPORTWIDTH;
		this.viewPortHeight = DEFAULTVIEWPORTHEIGHT;
		
		//init the random util
		randomUtil = new RandomUtil();
		
		//init the camera using the default width and height values
		camera = new OrthographicCamera(viewPortWidth, viewPortHeight);
		
		
	}
	
	//Create the basic 2d renderer by passing in a sprite batch, texture manager, and a port width and height for the camera
	public Basic2DRenderer(SpriteBatch batch, TextureManager textureManager, int viewPortWidth, int viewPortHeight) {
		
		//set the local texture manager to the passed in texture manager
		this.textureManager = textureManager;
		
		//set the viewport for the camera to the passed in values
		this.viewPortWidth = viewPortWidth;
		this.viewPortHeight = viewPortHeight;
		
		//set the local sprite batch to the passed in one
		this.batch = batch;
		
		//init the random util
		randomUtil = new RandomUtil();
		
		//create the camera using the passed in viewport values
		camera = new OrthographicCamera(viewPortWidth, viewPortHeight);
		
	}
	
	//get the camera from this class
	public OrthographicCamera getCamera() {
		return this.camera;
	}
	
	//this method is what actually renders stuff to the screen, it will use other rendering functions in other classes such as
	//the world renderer to render things to the screen
	public void render() {
		batch.setProjectionMatrix(camera.combined);
		elapsedTime += Gdx.graphics.getDeltaTime();
		camera.update();
		batch.begin();
		batch.end();
	}
}
