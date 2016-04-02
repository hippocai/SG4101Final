package com.ft9.view.panel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.HashMap;
import java.util.List;

import javax.swing.JOptionPane;

import com.ft9.annotation.Menu;
import com.ft9.service.ICategoryService;
import com.ft9.service.ServiceManager;
import com.ft9.service.ServiceNotFoundException;
import com.ft9.service.impl.CategoryService;
import com.ft9.util.ViewUtil;
import com.ft9.view.NameConverter;
import com.ft9.view.ViewManager;
import com.ft9.view.panel.subFunctionPanel.AddCategoryPanel;


/**
 * class name:ManageCategoryPanel <BR>
 * class description: Manage Category Information Panel <BR>
 * Remark: <BR>
 * @version 1.00
 * @author Cai Yicheng
 */

//Set The Jtree Name
@Menu(name = "Category", fatherName = "Manage")

/**
 *
 * @author hippo
 */
public class ManageCategoryPanel extends javax.swing.JPanel implements ActionListener,PropertyChangeListener {

    /**
	 * 
	 */
	private static final long serialVersionUID = 9098970512592162357L;
	private ICategoryService categoryService=null;
	/**
     * Creates new form ManageCategoryPanel
	 * @throws ServiceNotFoundException 
     */
    public ManageCategoryPanel() throws ServiceNotFoundException {
    	categoryService=(CategoryService)ServiceManager.getService("Category");
        initComponents();
        initDatas();
    }

    /**
     * Method name: initComponents <BR>
     * Description: Init The Components In Category panel <BR>
     * Remark: <BR>  void<BR>
     */
    private void initComponents() {
    	this.addPropertyChangeListener("Refresh", this);
        goHomeBtn = ViewManager.createGoHomeButton();
        addBtn = new javax.swing.JButton();
        deleteBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        
        addBtn.setText("Add");
        addBtn.addActionListener(this);
        deleteBtn.setText("Delete");
        deleteBtn.addActionListener(this);
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(goHomeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 756, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(addBtn)
                                .addGap(31, 31, 31)
                                .addComponent(deleteBtn)
                                .addGap(525, 525, 525)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(goHomeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addBtn)
                    .addComponent(deleteBtn))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 482, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
        );
    }                       

    /**
     * Method name: initDatas <BR>
     * Description: Put The Category Datas Into The Table <BR>
     * Remark: <BR>  void<BR>
     */
    private void initDatas(){
    	jTable1.setModel(ViewUtil.transferBeanList2DefaultTableModel(categoryService.getAllCategorys(),"Category"));
    }
    
    private javax.swing.JButton goHomeBtn;
    private javax.swing.JButton addBtn;
    private javax.swing.JButton deleteBtn;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration    
    
	/**
	 * @Override
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent) <BR>
	 * Method name: actionPerformed <BR>
	 * Description: Judge Which Button Is Pressed <BR>
	 * Remark: <BR>
	 * @param e  <BR>
	*/
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==deleteBtn){
			deleteExec();
		}else if(e.getSource()==addBtn){
			goToAddPanel();
		}
		
	}
	
	/**
	 * Method name: goToAddPanel <BR>
	 * Description: Add Button Excute <BR>
	 * Remark: <BR>  void<BR>
	 */
	private void goToAddPanel(){
		try {
			ViewManager.goToSubFunctionScreen(new AddCategoryPanel());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Method name: deleteExec <BR>
	 * Description: Delete Execute <BR>
	 * Remark: <BR>  void<BR>
	 */
	private void deleteExec(){
		List<HashMap<String,String>> selectedDatas=ViewUtil.getSelectedData(jTable1);
		if(selectedDatas.size()<1){
			JOptionPane.showMessageDialog(null, "Please select at least 1 item to delete", "Error", JOptionPane.ERROR_MESSAGE);
			return;
		}
		int options=JOptionPane.showConfirmDialog(null, "Are you ready to delete this "+selectedDatas.size()+"Items?", "Info",JOptionPane.YES_NO_OPTION);
		if(options==1){
			return;
		}
		for(HashMap<String,String> map:selectedDatas){
			
			categoryService.deleteCategoryByMap(NameConverter.convertViewMap2PhysicMap(map, "Category"));
		}
		this.initDatas();
	}
	
	/**
	 * @Override
	 * @see java.beans.PropertyChangeListener#propertyChange(java.beans.PropertyChangeEvent) <BR>
	 * Method name: propertyChange <BR>
	 * Description: Refresh <BR>
	 * Remark: <BR>
	 * @param arg0  <BR>
	*/
	@Override
	public void propertyChange(PropertyChangeEvent arg0) {
		if(this.getClientProperty("Refresh")!=null&&this.getClientProperty("Refresh").equals("True")){
			 initDatas();
			 putClientProperty("Refresh", "False");
		}
		
		
	}
}
