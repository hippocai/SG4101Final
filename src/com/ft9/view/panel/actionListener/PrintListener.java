package com.ft9.view.panel.actionListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class PrintListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO 自动生成的方法存根
		JOptionPane.showMessageDialog(null, "Can not find printer", "Error", JOptionPane.ERROR_MESSAGE);
	}

}
