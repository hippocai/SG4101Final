package com.ft9.view.panel.actionListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.ft9.view.ViewManager;

/**
 * class name:GoHomeListener <BR>
 * class description: Go Home Function<BR>
 * Remark: <BR>
 * @version 1.00
 * @author Guo Qi
 */
public class GoHomeListener implements ActionListener{

	/**
	 * @Override
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent) <BR>
	 * Method name: actionPerformed <BR>
	 * Description: Go To The Main Panel <BR>
	 * Remark: <BR>
	 * @param arg0  <BR>
	*/
	@Override
	public void actionPerformed(ActionEvent arg0) {
		ViewManager.goToHomePanel();
		
	}

}
