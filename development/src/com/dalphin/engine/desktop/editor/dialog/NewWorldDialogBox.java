package com.dalphin.engine.desktop.editor.dialog;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.dalphin.engine.desktop.editor.childpane.MapPane;
import com.dalphin.engine.desktop.editor.mapEditor.MapTabbedPane;
import com.dalphin.engine.desktop.editor.childpane.MapPane;

public class NewWorldDialogBox extends JDialog{
	
	private JLabel worldNameLabel;
	public JTextField worldName;
	private JPanel worldPanel;
	private JButton create;
	private MapTabbedPane mapEditorPane;
	public NewWorldDialogBox(final MapTabbedPane mapEditorPane) {
		this.mapEditorPane = mapEditorPane;
		worldPanel = new JPanel();
		worldNameLabel = new JLabel("World name:");
		worldName = new JTextField("", 20);
		create = new JButton("Create");

		worldPanel.add(worldNameLabel);
		worldPanel.add(worldName);
		add(worldPanel, BorderLayout.WEST);
		add(create, BorderLayout.SOUTH);
		setSize(300, 500);
		setTitle("New World");
		
		create.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				mapEditorPane.addMap(worldName.getText());
				dispose();
			}
		});
	}

}
