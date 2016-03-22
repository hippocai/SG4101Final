package com.ft9.view.panel.actionListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import com.ft9.view.ViewManager;

public class GoBackListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO 自动生成的方法存根
		int options=JOptionPane.showConfirmDialog(null, "Are you ready to Go Back?", "Info",JOptionPane.YES_NO_OPTION);
		if(options==0){
			ViewManager.goBack();
		}
	}

}
