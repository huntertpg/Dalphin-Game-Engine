package com.dalphin.engine.managers;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import com.dalphin.engine.block.Block2D;
import com.dalphin.engine.block.BlockReader;
import com.dalphin.engine.debug.DebugUtil;

public class BlockManager {
	
	public ArrayList<Block2D> blocks = new ArrayList<Block2D>();
	private DebugUtil debug;
	private BlockReader blockReader;
	
	/**
	 * 
	 * @param textureManager
	 * @param debug
	 */
	public BlockManager(TextureManager textureManager, DebugUtil debug) {
		this.debug = debug;
		blockReader = new BlockReader(textureManager, this);
		
		readBlockManifest("BlockManifest");
	}
	/**
	 *  
	 * @param index
	 * @return block
	 */
	public Block2D getBlock(int index) {
		return this.blocks.get(index);
	}
	
	public Block2D getBlock(String name) {
		Block2D block = null;
		for(int i = 0; i < blocks.size(); i++) {
			if(blocks.get(i).getName().equals(name)) {
				block = this.blocks.get(i);
			}
		}
		return block;
	}	
	
	public int blockListSize() {
		return this.blocks.size();
	}
	
	public DebugUtil getDebug() {
		return this.debug;
	}
	
	public void readBlockManifest(String blockManifest) {
		File blockManifestFile = new File("../core/assets/blocks/" + blockManifest + ".manifest");
		Scanner scanner = null;
		try {
			scanner = new Scanner(blockManifestFile);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		while(scanner.hasNextLine()) {
			blocks.add(blockReader.readBlock(scanner.nextLine()));
		}
	}

	
}
