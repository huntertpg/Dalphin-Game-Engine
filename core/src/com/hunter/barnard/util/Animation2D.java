package com.hunter.barnard.util;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Animation2D {
	
	private Animation animation;
	private TextureRegion[] animationFrames;
	private Texture spriteSheet;
	private float elapsedTime;
	private int spriteWidth;
	private int spriteHeight;
	private int rows;
	private int columns;
	private float xPos;
	private float yPos;
	
	public Animation2D(Texture spriteSheet, int startRow, int rows, int columns, int spriteWidth, int spriteHeight, boolean flipX, boolean flipY) {
		this.spriteSheet = spriteSheet;
		this.spriteHeight = spriteHeight;
		this.spriteWidth = spriteWidth;
		this.rows = rows;
		this.columns = columns;
		this.xPos = 0;
		this.yPos = 0;
		
		TextureRegion[][] tempFrames = TextureRegion.split(spriteSheet, spriteWidth, spriteHeight);
		
		animationFrames = new TextureRegion[rows * columns];
		
		int index = 0;
		
			for(int j = 0; j < columns; j++) {
				tempFrames[startRow][j].flip(flipX, flipY);
				animationFrames[index++] = tempFrames[startRow][j];
			}
		
		animation = new Animation(1f/10f, animationFrames);
	}

	public Animation2D(Texture spriteSheet, int rows, 
		int columns, int spriteWidth, int spriteHeight, float xPos, float yPos) {
		this.spriteSheet = spriteSheet;
		this.spriteHeight = spriteHeight;
		this.spriteWidth = spriteWidth;
		this.rows = rows;
		this.columns = columns;
		this.xPos = xPos;
		this.yPos = yPos;
		
		TextureRegion[][] tempFrames = TextureRegion.split(spriteSheet, spriteWidth, spriteHeight);
		
		animationFrames = new TextureRegion[rows * columns];
		
		int index = 0;
		
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < columns; j++) {
				animationFrames[index++] = tempFrames[i][j];
			}
		}
		
		animation = new Animation(1f/4f, animationFrames);
	}
	
	public Animation2D(Texture spriteSheet, int rows, int columns, int spriteWidth, int spriteHeight) {
		this.spriteSheet = spriteSheet;
		this.spriteHeight = spriteHeight;
		this.spriteWidth = spriteWidth;
		this.rows = rows;
		this.columns = columns;
		this.xPos = 0;
		this.yPos = 0;
		
		TextureRegion[][] tempFrames = TextureRegion.split(spriteSheet, spriteWidth, spriteHeight);
		
		animationFrames = new TextureRegion[rows * columns];
		
		int index = 0;
		
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < columns; j++) {
				animationFrames[index++] = tempFrames[i][j];
			}
		}
		
		animation = new Animation(1f/4f, animationFrames);
	}
	
	public void draw(Batch batch, float elapsedTime) {
		batch.draw((TextureRegion) animation.getKeyFrame(elapsedTime, true), xPos, yPos);
	}
	
	public void draw(Batch batch, float elapsedTime, float width, float height) {
		batch.draw((TextureRegion) animation.getKeyFrame(elapsedTime, true), xPos, yPos, width, height);
	}
	public void draw(Batch batch, float elapsedTime, float width, float height, float xPos, float yPos) {
		batch.draw((TextureRegion) animation.getKeyFrame(elapsedTime, true), xPos, yPos, width, height);
	}
}
