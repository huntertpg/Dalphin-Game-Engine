package com.dalphin.engine.desktop.editor;

import javax.swing.Icon;

public class EditorBlock {
	
	private int x;
	private int y;
	private String name;
	private Icon icon;
	
	public EditorBlock(Icon icon, String name, int x, int y) {
		this.x = x;
		this.y = y;
		this.name = name;
		this.icon = icon;
	}

	/**
	 * @return the x
	 */
	public int getX() {
		return x;
	}

	/**
	 * @param x the x to set
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * @return the y
	 */
	public int getY() {
		return y;
	}

	/**
	 * @param y the y to set
	 */
	public void setY(int y) {
		this.y = y;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the icon
	 */
	public Icon getIcon() {
		return icon;
	}

	/**
	 * @param icon the icon to set
	 */
	public void setIcon(Icon icon) {
		this.icon = icon;
	}
	
	
}
