package com.ft9.view.panel.actionListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 * class name:PrintListener <BR>
 * class description: Print Button Function <BR>
 * Remark: <BR>
 * @version 1.00
 * @author Guo Qi
 */
public class PrintListener implements ActionListener {

	/**
	 * @Override
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent) <BR>
	 * Method name: actionPerformed <BR>
	 * Description: Print <BR>
	 * Remark: Because No Other Interfaces To Use, So There Is Only An Error Message In The Function<BR>
	 * @param arg0  <BR>
	*/
	@Override
	public void actionPerformed(ActionEvent arg0) {
		JOptionPane.showMessageDialog(null, "Cannot find printer", "Error", JOptionPane.ERROR_MESSAGE);
	}

}
