package com.dalphin.engine.util;

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
	private float animationSpeed = 10f;
	/**
	 * 
	 * @param spriteSheet This is the Texture where the player sprites are held 
	 * @param startRow
	 * @param rows
	 * @param columns
	 * @param spriteWidth
	 * @param spriteHeight
	 * @param flipX
	 * @param flipY
	 */
	public Animation2D(Texture spriteSheet, int startRow, int rows, int columns, int spriteWidth, int spriteHeight,
			boolean flipX, boolean flipY) {
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

		for (int j = 0; j < columns; j++) {
			tempFrames[startRow][j].flip(flipX, flipY);
			animationFrames[index++] = tempFrames[startRow][j];
		}

		animation = new Animation(1f / animationSpeed, animationFrames);
	}
	/**
	 * 
	 * @param spriteSheet
	 * @param startRow
	 * @param startColumn
	 * @param rows
	 * @param columns
	 * @param spriteWidth
	 * @param spriteHeight
	 * @param flipX
	 * @param flipY
	 */
	public Animation2D(Texture spriteSheet, int startRow, int startColumn, int rows, int columns, int spriteWidth,
			int spriteHeight, boolean flipX, boolean flipY) {
		this.spriteSheet = spriteSheet;
		this.spriteHeight = spriteHeight;
		this.spriteWidth = spriteWidth;
		this.rows = rows;
		this.columns = columns;
		this.xPos = 0;
		this.yPos = 0;

		TextureRegion[][] tempFrames = TextureRegion.split(spriteSheet, spriteWidth, spriteHeight);

		animationFrames = new TextureRegion[rows * columns - startColumn];

		int index = 0;

		for (int j = startColumn; j < columns; j++) {
			tempFrames[startRow][j].flip(flipX, flipY);
			System.out.println(animationFrames.length);
			animationFrames[index++] = tempFrames[startRow][j];
		}

		animation = new Animation(1f / animationSpeed, animationFrames);
	}
	/**
	 * 
	 * @param spriteSheet
	 * @param startRow
	 * @param startColumn
	 * @param rows
	 * @param columns
	 * @param spriteWidth
	 * @param spriteHeight
	 * @param flipX
	 * @param flipY
	 * @param expansionX
	 * @param expansionY
	 */
	public Animation2D(Texture spriteSheet, int startRow, int startColumn, int rows, int columns, int spriteWidth,
			int spriteHeight, boolean flipX, boolean flipY, int expansionX, int expansionY) {
		this.spriteSheet = spriteSheet;
		this.spriteHeight = spriteHeight;
		this.spriteWidth = spriteWidth;
		this.rows = rows;
		this.columns = columns;
		this.xPos = 0;
		this.yPos = 0;

		TextureRegion[][] tempFrames = TextureRegion.split(spriteSheet, spriteWidth, spriteHeight);

		animationFrames = new TextureRegion[rows * columns - startColumn];

		int index = 0;

		for (int j = startColumn; j < columns; j++) {
			tempFrames[startRow][j].setRegion(tempFrames[startRow][j].getRegionX() - expansionX,
					tempFrames[startRow][j].getRegionY() - expansionY, spriteWidth + expansionX,
					spriteHeight + expansionY);
			tempFrames[startRow][j].flip(flipX, flipY);
			System.out.println(animationFrames.length);
			animationFrames[index++] = tempFrames[startRow][j];
		}

		animation = new Animation(1f / animationSpeed, animationFrames);
	}
	/**
	 * 
	 * @param spriteSheet
	 * @param animationSpeed
	 * @param startRow
	 * @param startColumn
	 * @param rows
	 * @param columns
	 * @param spriteWidth
	 * @param spriteHeight
	 * @param flipX
	 * @param flipY
	 * @param expansionX
	 * @param expansionY
	 */
	public Animation2D(Texture spriteSheet, float animationSpeed, int startRow, int startColumn, int rows, int columns,
			int spriteWidth, int spriteHeight, boolean flipX, boolean flipY, int expansionX, int expansionY) {
		this.spriteSheet = spriteSheet;
		this.spriteHeight = spriteHeight;
		this.spriteWidth = spriteWidth;
		this.rows = rows;
		this.columns = columns;
		this.xPos = 0;
		this.yPos = 0;

		TextureRegion[][] tempFrames = TextureRegion.split(spriteSheet, spriteWidth, spriteHeight);

		animationFrames = new TextureRegion[rows * columns - startColumn];

		int index = 0;

		for (int j = startColumn; j < columns; j++) {
			tempFrames[startRow][j].setRegion(tempFrames[startRow][j].getRegionX() - expansionX,
					tempFrames[startRow][j].getRegionY() - expansionY, spriteWidth + expansionX,
					spriteHeight + expansionY);
			tempFrames[startRow][j].flip(flipX, flipY);
			System.out.println(animationFrames.length);
			animationFrames[index++] = tempFrames[startRow][j];
		}

		animation = new Animation(1f / animationSpeed, animationFrames);
	}
	/**
	 * 
	 * @param spriteSheet
	 * @param rows
	 * @param columns
	 * @param spriteWidth
	 * @param spriteHeight
	 * @param xPos
	 * @param yPos
	 */
	public Animation2D(Texture spriteSheet, int rows, int columns, int spriteWidth, int spriteHeight, float xPos,
			float yPos) {
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

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				animationFrames[index++] = tempFrames[i][j];
			}
		}

		animation = new Animation(1f / animationSpeed, animationFrames);
	}
	/**
	 * 
	 * @param spriteSheet
	 * @param rows
	 * @param columns
	 * @param spriteWidth
	 * @param spriteHeight
	 */
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

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				animationFrames[index++] = tempFrames[i][j];
			}
		}

		animation = new Animation(1f / animationSpeed, animationFrames);
	}
	/**
	 * 
	 * @return animation
	 */
	public Animation getAnimation() {
		return animation;
	}
	/**
	 * 
	 * @param animation
	 */
	public void setAnimation(Animation animation) {
		this.animation = animation;
	}
	/**
	 * 
	 * @return animationFrames
	 */
	public TextureRegion[] getAnimationFrames() {
		return animationFrames;
	}
	/**
	 * 
	 * @param animationFrames
	 */
	public void setAnimationFrames(TextureRegion[] animationFrames) {
		this.animationFrames = animationFrames;
	}
	/**
	 * 
	 * @return spriteSheet
	 */
	public Texture getSpriteSheet() {
		return spriteSheet;
	}
	/**
	 * 
	 * @param spriteSheet
	 */
	public void setSpriteSheet(Texture spriteSheet) {
		this.spriteSheet = spriteSheet;
	}
	/**
	 * 
	 * @return elapsedTime
	 */
	public float getElapsedTime() {
		return elapsedTime;
	}
	/**
	 * 
	 * @param elapsedTime
	 */
	public void setElapsedTime(float elapsedTime) {
		this.elapsedTime = elapsedTime;
	}
	/**
	 * 
	 * @return spriteWidth
	 */
	public int getSpriteWidth() {
		return spriteWidth;
	}
	/**
	 * 
	 * @param spriteWidth
	 */
	public void setSpriteWidth(int spriteWidth) {
		this.spriteWidth = spriteWidth;
	}
	/**
	 * 
	 * @return spriteHeight
	 */
	public int getSpriteHeight() {
		return spriteHeight;
	}
	/**
	 * 
	 * @param spriteHeight
	 */
	public void setSpriteHeight(int spriteHeight) {
		this.spriteHeight = spriteHeight;
	}
	/**
	 * 
	 * @return rows
	 */
	public int getRows() {
		return rows;
	}
	/**
	 * 
	 * @param rows
	 */
	public void setRows(int rows) {
		this.rows = rows;
	}
	/**
	 * 
	 * @return columns
	 */
	public int getColumns() {
		return columns;
	}
	/**
	 * 
	 * @param columns
	 */
	public void setColumns(int columns) {
		this.columns = columns;
	}
	/**
	 * 
	 * @return xPos
	 */
	public float getxPos() {
		return xPos;
	}
	/**
	 * 
	 * @param xPos
	 */
	public void setxPos(float xPos) {
		this.xPos = xPos;
	}
	/**
	 * 
	 * @return yPos
	 */
	public float getyPos() {
		return yPos;
	}
	/**
	 * 
	 * @param yPos
	 */
	public void setyPos(float yPos) {
		this.yPos = yPos;
	}
	/**
	 * 
	 * @return animationSpeed
	 */
	public float getAnimationSpeed() {
		return animationSpeed;
	}
	/**
	 * 
	 * @param animationSpeed
	 */
	public void setAnimationSpeed(float animationSpeed) {
		this.animationSpeed = animationSpeed;
	}
	/**
	 * 
	 * @param batch
	 * @param elapsedTime
	 */
	public void draw(Batch batch, float elapsedTime) {
		batch.draw((TextureRegion) animation.getKeyFrame(elapsedTime, true), xPos, yPos);
	}
	/**
	 * 
	 * @param batch
	 * @param elapsedTime
	 * @param width
	 * @param height
	 */
	public void draw(Batch batch, float elapsedTime, float width, float height) {
		batch.draw((TextureRegion) animation.getKeyFrame(elapsedTime, true), xPos, yPos, width, height);
	}
	/**
	 * 
	 * @param batch
	 * @param elapsedTime
	 * @param width
	 * @param height
	 * @param xPos
	 * @param yPos
	 */
	public void draw(Batch batch, float elapsedTime, float width, float height, float xPos, float yPos) {
		batch.draw((TextureRegion) animation.getKeyFrame(elapsedTime, true), xPos, yPos, width, height);
	}
}
