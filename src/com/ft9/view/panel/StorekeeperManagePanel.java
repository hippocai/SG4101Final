package com.ft9.view.panel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.HashMap;
import java.util.List;

import javax.swing.JOptionPane;

import com.ft9.annotation.Menu;
import com.ft9.service.IStoreKeeperService;
import com.ft9.service.ServiceManager;
import com.ft9.service.ServiceNotFoundException;
import com.ft9.service.impl.StoreKeeperService;
import com.ft9.util.ViewUtil;
import com.ft9.view.ViewManager;
import com.ft9.view.panel.subFunctionPanel.AddStorekeeperPanel;

/**
*
* @author apple
*/

/**
 * class name:StorekeeperManagePanel <BR>
 * class description: Manage StoreKeeper Information Panel <BR>
 * Remark: <BR>
 * @version 1.00
 * @author Guo Qi
 */

//Set JTree Name
@Menu(name = "Manage", fatherName = "StoreKeeper")

public class StorekeeperManagePanel extends javax.swing.JPanel implements PropertyChangeListener, ActionListener {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private IStoreKeeperService storekeeperService = null;
	/**
     * Creates new form StorekeeperManagePanel
	 * @throws ServiceNotFoundException 
     */
    public StorekeeperManagePanel() throws ServiceNotFoundException {
        storekeeperService = (StoreKeeperService) ServiceManager.getService("StoreKeeper");
    	initComponents();
    	initDatas();
    	setActionListener();
    }
    
    /**
     * Method name: initDatas <BR>
     * Description: Get the Storekeeper info into the table <BR>
     * Remark: <BR>  void<BR>
     */
    public void initDatas(){
    	jTable1.setModel(ViewUtil.transferBeanList2DefaultTableModel(storekeeperService.getAllStoreKeeper(), "StoreKeeper"));
    }
    
    /**
     * Method name: setActionListener <BR>
     * Description: Set ActionListener <BR>
     * Remark: <BR>  void<BR>
     */
    private void setActionListener(){
    	this.addPropertyChangeListener("Refresh",this);
    	jButtonAdd.addActionListener(this);
    	jButtonDelete.addActionListener(this);
    	
    }
    
    
    /**
     * Method name: initComponents <BR>
     * Description: Init Components Into StoreKeeperPanel <BR>
     * Remark: <BR>  void<BR>
     */
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        //make the table uneditable
        jTable1 = ViewUtil.createUneditableTable();
        jButtonBack = ViewManager.createGoHomeButton();
        jButtonAdd = new javax.swing.JButton();
        jButtonDelete = new javax.swing.JButton();

        jScrollPane1.setViewportView(jTable1);

        jButtonAdd.setText("Add");

        jButtonDelete.setText("Delete");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(152, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jButtonAdd)
                            .addGap(45, 45, 45)
                            .addComponent(jButtonDelete)
                            .addContainerGap())
                        .addGroup(layout.createSequentialGroup()
                            .addGap(547, 547, 547)
                            .addComponent(jButtonBack, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(31, 31, 31)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 527, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(121, 121, 121))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jButtonBack, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButtonDelete, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                    .addComponent(jButtonAdd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 408, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(62, Short.MAX_VALUE))
        );
    }                     

    private javax.swing.JButton jButtonBack;
    private javax.swing.JButton jButtonAdd;
    private javax.swing.JButton jButtonDelete;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration    
    
	/**
	 * @Override
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent) <BR>
	 * Method name: actionPerformed <BR>
	 * Description: Judge Which Button Is Pressed <BR>
	 * Remark: <BR>
	 * @param arg0  <BR>
	*/
	@Override
	public void actionPerformed(ActionEvent arg0) {
		Object source = arg0.getSource();
		// if user presses the "Add button", the screen skip to the AddStorekeeper screen,
		// if user presses other buttons, excute the corresponding functions
		if (source == jButtonAdd){
			try {
				ViewManager.goToSubFunctionScreen(new AddStorekeeperPanel());
			} catch (ServiceNotFoundException e) {
				e.printStackTrace();
			}
		}else if(source == jButtonDelete){
			deleteExcu();
		}
		
		
	}

	/**
	 * Method name: deleteExcu <BR>
	 * Description: Delete Execute <BR>
	 * Remark: <BR>  void<BR>
	 */
	private void deleteExcu() {
		int option;
		List<HashMap<String, String>> selectedData = ViewUtil.getSelectedData(jTable1);
		if (selectedData.size() < 1){
			JOptionPane.showMessageDialog(null, "Please at least choose one storekeeper to delete !", "Error", JOptionPane.ERROR_MESSAGE);
			return;
		}
		option = 1;
		if(selectedData.size() == 1){
			option = JOptionPane.showConfirmDialog(null, "Are you sure to delete this " + selectedData.size() + " storekeeper ?", "Confirm", JOptionPane.YES_NO_OPTION);
		}else{
			option = JOptionPane.showConfirmDialog(null, "Are you sure to delete these " + selectedData.size() + " storekeepers ?", "Confirm", JOptionPane.YES_NO_OPTION);
		}
		if (option == 1){
			return;
		}else{
			for (HashMap<String, String> map: selectedData){
				storekeeperService.deleteUserByName(map.get("Name"));
				
			}
		}
		initDatas();
	}

	/**
	 * @Override
	 * @see java.beans.PropertyChangeListener#propertyChange(java.beans.PropertyChangeEvent) <BR>
	 * Method name: propertyChange <BR>
	 * Description: Refresh <BR>
	 * Remark: <BR>
	 * @param evt  <BR>
	*/
	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		if (this.getClientProperty("Refresh") != null && this.getClientProperty("Refresh").equals("True")){
			initDatas();
			putClientProperty("Refresh", "False");
		}
		
	}
}
