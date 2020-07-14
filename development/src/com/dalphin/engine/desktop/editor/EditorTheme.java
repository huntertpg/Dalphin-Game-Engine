package com.dalphin.engine.desktop.editor;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JComponent;
import javax.swing.JFrame;

public class EditorTheme {
	
	private Color lightTheme;
	private Color darkTheme = new Color(43,43,43);
	private boolean enableDarkTheme = false;
	private ArrayList<Object> objects = new ArrayList<Object>();
	
	public EditorTheme(boolean enableDarkTheme) {
		this.enableDarkTheme = enableDarkTheme;
		if(enableDarkTheme) {
			for(int i = 0; i < objects.size(); i++) {
				setDarkTheme(objects.get(i));
			}
		}
	}
	
	public void setTheme(boolean enableDarkTheme) {
		this.enableDarkTheme = enableDarkTheme;
		if(enableDarkTheme) {
			for(int i = 0; i < objects.size(); i++) {
				setDarkTheme(objects.get(i));
			}
		}
	}
	
	public void setDarkTheme(Object comp) {
		if(comp instanceof JFrame) {
			((JFrame) comp).setBackground(darkTheme);
		}
		if(comp instanceof JComponent) {
			((JComponent) comp).setBackground(darkTheme);
		}
	}
	
	public void setLightTheme(Object comp) {
		if(comp instanceof JFrame) {
			((JFrame) comp).setBackground(new Color(1,1,1));
		}
	}
	
	public void addObject(Object o) {
		this.objects.add(o);
	}
	
}
