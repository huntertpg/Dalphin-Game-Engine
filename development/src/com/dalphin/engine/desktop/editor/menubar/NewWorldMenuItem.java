package com.dalphin.engine.desktop.editor.menubar;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.dalphin.engine.desktop.editor.dialog.NewWorldDialogBox;
import com.dalphin.engine.desktop.editor.mapEditor.MapTabbedPane;


public class NewWorldMenuItem implements ActionListener{
	
	private MapTabbedPane mapEditor;
	
	public NewWorldMenuItem(MapTabbedPane mapEditor) {
		this.mapEditor = mapEditor;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		NewWorldDialogBox newWorldDialog = new NewWorldDialogBox(mapEditor);
		newWorldDialog.setVisible(true);
	}

}
