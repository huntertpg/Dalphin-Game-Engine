package com.dalphin.engine.desktop.editor.components;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import com.dalphin.engine.desktop.editor.EditorTheme;
import com.dalphin.engine.desktop.editor.childpane.BlockPane;
import com.dalphin.engine.desktop.editor.childpane.ItemPane;

public class DalphinButton extends JButton {

	private EditorTheme editorTheme;
	private int buttonID;
	
	/**
	 * @return the buttonID
	 */
	public int getButtonID() {
		return buttonID;
	}

	/**
	 * @param buttonID the buttonID to set
	 */
	public void setButtonID(int buttonID) {
		this.buttonID = buttonID;
	}

	public DalphinButton(EditorTheme editorTheme) {
		this.editorTheme = editorTheme;
	}

	public DalphinButton(String text, ImageIcon icon, EditorTheme editorTheme, final BlockPane blockPane) {
		this.editorTheme = editorTheme;
		if (editorTheme != null) {
			editorTheme.addObject(this);
		}
		this.setText(text);
		this.setIcon(icon);
		addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				blockPane.setActiveButton(buttonID);
			}
		});
	}
	
	public DalphinButton(String text, ImageIcon icon, EditorTheme editorTheme, final ItemPane itemPane) {
		this.editorTheme = editorTheme;
		if (editorTheme != null) {
			editorTheme.addObject(this);
		}
		this.setText(text);
		this.setIcon(icon);
		addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				itemPane.setActiveButton(buttonID);
			}
		});
	}

	public DalphinButton(String text) {
		this.setText(text);

	}

	public void setEditorTheme(EditorTheme editorTheme) {
		editorTheme.addObject(this);
		this.updateUI();
	}

}
