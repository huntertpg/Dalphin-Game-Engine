package com.dalphin.engine.desktop.editor.components;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import com.dalphin.engine.desktop.editor.EditorTheme;

public class DalphinButton extends JButton{
	
	EditorTheme editorTheme;
	
	public DalphinButton(EditorTheme editorTheme) {
		this.editorTheme = editorTheme;
	}
	
	public DalphinButton(String text, ImageIcon icon, EditorTheme editorTheme){
		this.editorTheme = editorTheme;
		if(editorTheme != null) {
			editorTheme.addObject(this);
		}
		this.setText(text);
		this.setIcon(icon);
	}
	
	public DalphinButton(String text){
		this.setText(text);
	}
	
	
	public void setEditorTheme(EditorTheme editorTheme) {
		editorTheme.addObject(this);
		this.updateUI();
	}

}
