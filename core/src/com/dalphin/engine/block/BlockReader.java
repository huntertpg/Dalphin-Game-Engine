package com.dalphin.engine.block;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.FileTextureData;
import com.dalphin.engine.managers.BlockManager;
import com.dalphin.engine.managers.TextureManager;

public class BlockReader {

	private String blockFilePath;
	private Scanner scanner = null;
	private String blockName;
	private Texture texture;
	private TextureRegion textureRegion;
	private TextureManager textureManager;
	private BlockManager blockManger;
	private int blockWidth;
	private int blockHeight;

	public BlockReader(TextureManager textureManager, BlockManager blockManager) {
		this.textureManager = textureManager;
		this.blockManger = blockManager;
	}

	public Block2D readBlock(String blockFilePath) {
		File blockFile = new File("../core/assets/blocks/" + blockFilePath + ".block");
		String blockDat = "";

		try {
			scanner = new Scanner(blockFile);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		while (scanner.hasNext()) {
			blockDat = blockDat.concat(scanner.nextLine());
		}
		
		String[] blockInfo = blockDat.split(":");
		this.blockName = blockInfo[1];
		if(blockInfo[3].equals("null")) {
			this.texture = null;
		}else {
			for(int i = 0; i < textureManager.textureList.size(); i++) {
				if(blockInfo[3].equals(((FileTextureData)textureManager.textureList.get(i).getTextureData()).getFileHandle().path())) {
					this.texture = textureManager.textureList.get(i);

				}
			}
			if(this.texture == null) {
				texture = textureManager.textureLoader.loadTexture(blockInfo[3]);
				textureManager.textureList.add(texture);
			}
		}
		
		if(blockInfo[5].equals("null")) {
			this.textureRegion = null;
		}else {
			String[] regionInfo = blockInfo[5].split(",");
			int indexOne = Integer.parseInt(regionInfo[1]);
			int indexTwo = Integer.parseInt(regionInfo[2]);
			for(int i = 0; i < textureManager.textureRegionList.size(); i++) {
				if(regionInfo[0].equals(((FileTextureData)textureManager.textureRegionList.get(i)[0][0].getTexture().getTextureData()).getFileHandle().path())) {
					this.textureRegion = textureManager.textureRegionList.get(i)[indexOne][indexTwo];
				}
			}
			if(this.textureRegion == null) {
				//textureRegion = textureManager.textureLoader.loadTexture(blockInfo[3]);
				//textureManager.textureList.add(texture);
			}
		}
		
		blockWidth = Integer.parseInt(blockInfo[7]);
		blockHeight = Integer.parseInt(blockInfo[9]);
		
		//System.out.println(this.texture);
		if(texture == null) {
			return new Block2D(blockName, blockManger.blockListSize(), textureRegion, blockWidth, blockHeight, blockManger.getDebug());
		}else if(textureRegion == null) {
			return new Block2D(blockName, blockManger.blockListSize(), texture, blockWidth, blockHeight, blockManger.getDebug());
		}else {
			return null;
		}
		
	}

}
