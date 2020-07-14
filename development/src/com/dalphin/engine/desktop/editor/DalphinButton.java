package com.dalphin.engine.desktop.editor;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class DalphinButton extends JButton{
	
	EditorTheme editorTheme;
	
	public DalphinButton(EditorTheme editorTheme) {
		this.editorTheme = editorTheme;
	}
	
	DalphinButton(String text, ImageIcon icon, EditorTheme editorTheme){
		this.editorTheme = editorTheme;
		if(editorTheme != null) {
			editorTheme.addObject(this);
		}
		this.setText(text);
		this.setIcon(icon);
	}
	
	public void setEditorTheme(EditorTheme editorTheme) {
		editorTheme.addObject(this);
		this.updateUI();
	}

}
