package com.ft9.view.panel.actionListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.ft9.view.ViewManager;

public class GoHomeListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO �Զ����ɵķ������
		ViewManager.goToHomePanel();
		
	}

}
