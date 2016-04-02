package com.ft9.view.panel.actionListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.ft9.view.ViewManager;

/**
 * class name:GoBackListener <BR>
 * class description: Go Back Function <BR>
 * Remark: <BR>
 * @version 1.00
 * @author Guo Qi
 */
public class GoBackListener implements ActionListener {

	/**
	 * @Override
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent) <BR>
	 * Method name: actionPerformed <BR>
	 * Description: Go Back <BR>
	 * Remark: <BR>
	 * @param arg0  <BR>
	*/
	@Override
	public void actionPerformed(ActionEvent arg0) {
		ViewManager.goBack();
	}

}
