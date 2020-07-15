package com.dalphin.engine.desktop.editor.menubar;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.dalphin.engine.desktop.editor.childpane.MapEditorPane;
import com.dalphin.engine.desktop.editor.dialog.NewWorldDialogBox;


public class NewWorldMenuItem implements ActionListener{
	
	private MapEditorPane mapEditor;
	
	public NewWorldMenuItem(MapEditorPane mapEditor) {
		this.mapEditor = mapEditor;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		NewWorldDialogBox newWorldDialog = new NewWorldDialogBox(mapEditor);
		newWorldDialog.setVisible(true);
	}

}
