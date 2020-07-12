package com.dalphin.engine.world;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;

import box2dLight.PointLight;

public class WorldParser {
	
	private String worldDirectory;
	private Scanner scanner = null;
	private WorldDef worldDef;
	
	public WorldParser(WorldDef worldDef, String worldDirectory) {
		this.worldDirectory = worldDirectory;
		this.worldDef = worldDef;
		
		worldDef.getRayHandler().setAmbientLight(1f);
		if(worldDef.getRayHandler() != null) {
			//parseLightProfile();
		}
	}
	
	public void parseWorld() {
		parseBlocks();
		parseLights();
	}
	
	private void parseLightProfile() {
		File profileFile = new File("../core/worlds/" + worldDirectory + "/lightingProfile.dat");
		String profileWorldDat = "";
		try {
			scanner = new Scanner(profileFile);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		if(scanner != null) {
			while(scanner.hasNext()) {
				
				profileWorldDat = profileWorldDat.concat(scanner.nextLine());
			}
		}
	}

	public void parseBlocks() {
		File blockFile = new File("../core/worlds/" + worldDirectory + "/blocks.dat");
		String blockWorldDat = "";

		try {
			scanner = new Scanner(blockFile);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		if(scanner != null) {
			while(scanner.hasNext()) {
				
				blockWorldDat = blockWorldDat.concat(scanner.nextLine());
			}
		}
		
		String[] blocks = blockWorldDat.split(":B |:X |:Y |:P |:BT |:R |:RV");
		int index = 0;
		for(int i = 0; i < blocks.length; i+=7) {
			worldDef.getWorldBlocks().add(worldDef.getBlockManager()
					.getBlock(Integer.parseInt(blocks[i])).createBlock());
			worldDef.getWorldBlocks().get(index).setPos(new Vector2(Float.parseFloat(blocks[i+1]), Float.parseFloat(blocks[i+2])));
			if(blocks[i+3].equals("t") | blocks[i+3].equals("T")){
				if(blocks[i+4].equals("D") | blocks[i+4].equals("d")) {
					worldDef.getWorldBlocks().get(index).createBody(worldDef.getWorld(), BodyType.DynamicBody);
				} else if(blocks[i+4].equals("S") | blocks[i+4].equals("s")) {
					worldDef.getWorldBlocks().get(index).createBody(worldDef.getWorld(), BodyType.StaticBody);
				} else if(blocks[i+4].equals("K") | blocks[i+4].equals("k")) {
					worldDef.getWorldBlocks().get(index).createBody(worldDef.getWorld(), BodyType.KinematicBody);
				}
			}
			if(blocks[i+5].equals("t") | blocks[i+3].equals("T")){
				worldDef.getWorldBlocks().get(index).canRotate(true);
				worldDef.getWorldBlocks().get(index).setRotation(Float.parseFloat(blocks[i+6]));
			}
			index++;
		}
	}
	
	public void parseLights() {
		File lightFile = new File("../core/worlds/" + worldDirectory + "/lights.dat");
		String lightWorldDat = "";
		
		
		try {
			scanner = new Scanner(lightFile);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		if(scanner != null) {
			while(scanner.hasNext()) {
				
				lightWorldDat = lightWorldDat.concat(scanner.nextLine());
			}
		}
		String[] lights = lightWorldDat.split(":T |:RS |:R |:G |:B |:A |:D |:X |:Y");
		
		
		for(int i = 0; i < lights.length; i+=9) {
			if(lights[i].equals("P") | lights[i].equals("p") ) {
				worldDef.getLights().add(new PointLight(worldDef.getRayHandler(), Integer.parseInt(lights[i+1]), 
						new Color(Float.parseFloat(lights[i+2]), Float.parseFloat(lights[i+3]), 
								Float.parseFloat(lights[i+4]), Float.parseFloat(lights[i + 5])),
						Float.parseFloat(lights[i+6]), Float.parseFloat(lights[i+7]), Float.parseFloat(lights[i+8])));
			}
		}
	}
	
}
