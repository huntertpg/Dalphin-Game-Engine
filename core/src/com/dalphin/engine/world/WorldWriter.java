package com.dalphin.engine.world;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;

import box2dLight.PointLight;

public class WorldWriter {

	private WorldDef worldDef;
	private String worldDirectory;
	private BufferedWriter writer;
	private FileWriter fileWriter;

	public WorldWriter(String wolrdDirectory, WorldDef world) {
		this.worldDef = world;
		this.worldDirectory = wolrdDirectory;

	}

	public void writeWorld() {
		writeBlocks();
		writeLights();
	}

	public void writeBlocks() {

		try {
			new File("../core/worlds/" + worldDirectory).mkdirs();
			fileWriter = new FileWriter("../core/worlds/" + worldDirectory + "/blocks.dat");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		writer = new BufferedWriter(fileWriter);
		for (int i = 0; i < worldDef.getWorldBlocks().size(); i++) {
			try {
				writer.write(worldDef.getWorldBlocks().get(i).getBlockID() + ":B ");
				writer.append(Float.toString(worldDef.getWorldBlocks().get(i).getxPos()) + ":X ");
				writer.append(Float.toString(worldDef.getWorldBlocks().get(i).getyPos()) + ":Y ");
				if (worldDef.getWorldBlocks().get(i).getBody() != null) {
					writer.append("T:P ");

					if (worldDef.getWorldBlocks().get(i).getBody().getType() == BodyType.DynamicBody) {
						writer.append("D:BT ");
					} else if (worldDef.getWorldBlocks().get(i).getBody().getType() == BodyType.StaticBody) {
						writer.append("S:BT ");
					} else if (worldDef.getWorldBlocks().get(i).getBody().getType() == BodyType.KinematicBody) {
						writer.append("L:BT ");
					}

				} else {
					writer.append("F:P ");
					writer.append("S:BT ");
				}

				if (worldDef.getWorldBlocks().get(i).getCanRotate()) {
					writer.append("T:R ");
				} else {
					writer.append("F:R ");
				}

				writer.append(Float.toString(worldDef.getWorldBlocks().get(i).getRotation()) + ":RV");
				writer.append("\n");

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		try {
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void writeLights() {
		try {
			new File("../core/worlds/" + worldDirectory).mkdirs();
			fileWriter = new FileWriter("../core/worlds/" + worldDirectory + "/lights.dat");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		writer = new BufferedWriter(fileWriter);
		for (int i = 0; i < worldDef.getLights().size(); i++) {
			try {
				if (worldDef.getLights().get(i) instanceof PointLight) {
					writer.write("p:T ");
				}
				writer.append(Integer.toString(worldDef.getLights().get(i).getRayNum()) + ":RS ");
				writer.append(Float.toString(worldDef.getLights().get(i).getColor().r) + ":R ");
				writer.append(Float.toString(worldDef.getLights().get(i).getColor().g) + ":G ");
				writer.append(Float.toString(worldDef.getLights().get(i).getColor().b) + ":B ");
				writer.append(Float.toString(worldDef.getLights().get(i).getColor().a) + ":A ");
				writer.append(Float.toString(worldDef.getLights().get(i).getDistance()) + ":D ");
				writer.append(Float.toString(worldDef.getLights().get(i).getPosition().x) + ":X ");
				writer.append(Float.toString(worldDef.getLights().get(i).getPosition().y) + ":Y");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		try {
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
