package com.ft9.view.panel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import com.ft9.annotation.Menu;
import com.ft9.bean.VendorBean;
import com.ft9.service.IVendorService;
import com.ft9.service.ServiceManager;
import com.ft9.service.ServiceNotFoundException;
import com.ft9.service.impl.VendorService;
import com.ft9.util.BeanUtil;
import com.ft9.util.ViewUtil;
import com.ft9.view.NameConverter;
import com.ft9.view.ViewManager;
import com.ft9.view.frame.ShowCategoriesFrame;
import com.ft9.view.panel.subFunctionPanel.AddVendorPanel;

/**
*
* @author apple
*/
/**
 * class name:ManageVendorPanel <BR>
 * class description: Manage The Vendor Datas Panel <BR>
 * Remark: <BR>
 * @version 1.00
 * @author Guo Qi
 */

//Set The JTree Name
@Menu(name = "Vendor", fatherName = "Manage")

public class ManageVendorPanel extends javax.swing.JPanel implements ActionListener, PropertyChangeListener {

   /**
	 * 
	 */
	private static final long serialVersionUID = 2L;
/**
	 * 
	 */
	private IVendorService vendorService = null;
	/**
    * Creates new form ManageProductPanel
	 * @throws ServiceNotFoundException 
    */
   public ManageVendorPanel() throws ServiceNotFoundException {
       vendorService = (VendorService) ServiceManager.getService("Vendor");
	   initComponents();
	   initDatas();
	   setActionListener();
   }
   
   /**
 * Method name: initDatas <BR>
 * Description: Put The Datas Into The Table <BR>
 * Remark: <BR>  void<BR>
 */
   private void initDatas(){
	   jTable1.setModel(ViewUtil.transferBeanList2DefaultTableModel(vendorService.getAllVendorInfo(), "Vendor"));
	   
   }
   
   /**
 * Method name: setActionListener <BR>
 * Description: Set ActionListener <BR>
 * Remark: <BR>  void<BR>
 */
	private void setActionListener(){
   	this.addPropertyChangeListener("Refresh", this);
   	jButtonDelete.addActionListener(this);
   	jButtonAdd.addActionListener(this);
   	jButtonUpdate.addActionListener(this);
   	jButtonSearch.addActionListener(this);
   }
   

   /**
 * Method name: initComponents <BR>
 * Description: Inite Components In The Vendor Panel <BR>
 * Remark: <BR>  void<BR>
 */
	private void initComponents() {

       jButton1 = ViewManager.createGoHomeButton();
       jTextField1 = new javax.swing.JTextField();
       jLabel1 = new javax.swing.JLabel();
       jButtonSearch = new javax.swing.JButton();
       jButtonAdd = new javax.swing.JButton();
       jButtonDelete = new javax.swing.JButton();
       jButtonUpdate = new javax.swing.JButton();
       showCategoryBtn=new JButton();
       jScrollPane1 = new javax.swing.JScrollPane();
       jTable1 = ViewUtil.createUneditableTable();
       jComboBox1 = new javax.swing.JComboBox<>();

       jTextField1.addActionListener(new java.awt.event.ActionListener() {
           public void actionPerformed(java.awt.event.ActionEvent evt) {
           }
       });

       jLabel1.setText("Key Word:");

       jButtonSearch.setText("Search");
       jButtonSearch.addActionListener(new java.awt.event.ActionListener() {
           public void actionPerformed(java.awt.event.ActionEvent evt) {
           }
       });

       jButtonAdd.setText("Add");
       showCategoryBtn.setText("Show Categories");
       showCategoryBtn.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			List<HashMap<String, String>> selectedData = ViewUtil.getSelectedData(jTable1);
			if (selectedData.size() != 1){
				JOptionPane.showMessageDialog(null, "Please Choose 1 Vendor !", "Error", JOptionPane.ERROR_MESSAGE);
				return;
			}
			Map<String, String> selectedMap = NameConverter.convertViewMap2PhysicMap(selectedData.get(0), "Vendor");
			VendorBean selectedVendorBean = new VendorBean();
			BeanUtil.transMap2Bean(selectedMap, selectedVendorBean);
			new ShowCategoriesFrame(vendorService.getAllCategoriesByVendorName(selectedVendorBean.getName())).setVisible(true);
			
		}
	});
       jButtonDelete.setText("Delete");

       jButtonUpdate.setText("Modify");

       jScrollPane1.setViewportView(jTable1);

       jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(NameConverter.getTitleArr("Vendor")));
       jComboBox1.addActionListener(new java.awt.event.ActionListener() {
           public void actionPerformed(java.awt.event.ActionEvent evt) {
           }
       });

       javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
       this.setLayout(layout);
       layout.setHorizontalGroup(
           layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
           .addGroup(layout.createSequentialGroup()
               .addGap(59, 59, 59)
               .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                   .addGroup(layout.createSequentialGroup()
                       .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                           .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                           .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                       .addGap(23, 23, 23))
                   .addGroup(layout.createSequentialGroup()
                       .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                           .addGroup(layout.createSequentialGroup()
                               .addComponent(jButtonAdd)
                               .addGap(33, 33, 33)
                               .addComponent(jButtonDelete)
                               .addGap(33, 33, 33)
                               .addComponent(jButtonUpdate)
                               .addGap(33, 33, 33)
                               .addComponent(showCategoryBtn))
                               
                           .addGroup(layout.createSequentialGroup()
                               .addComponent(jLabel1)
                               .addGap(10, 10, 10)
                               .addComponent(jTextField1)
                               .addGap(18, 18, 18)
                               .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                               .addGap(10, 10, 10)
                               .addComponent(jButtonSearch)))
                       .addGap(300, 300, 300))))
       );
       layout.setVerticalGroup(
           layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
           .addGroup(layout.createSequentialGroup()
               .addContainerGap()
               .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
               .addGap(54, 54, 54)
               .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                   .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                   .addComponent(jLabel1)
                   .addComponent(jButtonSearch)
                   .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
               .addGap(18, 18, 18)
               .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                   .addComponent(jButtonAdd)
                   .addComponent(jButtonDelete)
                   .addComponent(jButtonUpdate)
                   .addComponent(showCategoryBtn))
               .addGap(18, 18, 18)
               .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 415, javax.swing.GroupLayout.PREFERRED_SIZE)
               .addGap(23, 23, 23))
       );
   }                     


   private javax.swing.JButton jButton1;
   private javax.swing.JButton jButtonSearch;
   private javax.swing.JButton jButtonAdd;
   private javax.swing.JButton jButtonDelete;
   private javax.swing.JButton jButtonUpdate;
   private javax.swing.JButton showCategoryBtn;
   private javax.swing.JComboBox<String> jComboBox1;
   private javax.swing.JLabel jLabel1;
   private javax.swing.JScrollPane jScrollPane1;
   private javax.swing.JTable jTable1;
   private javax.swing.JTextField jTextField1;
   // End of variables declaration  
   
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
	// TODO Auto-generated method stub
	if(this.getClientProperty("Refresh") != null && this.getClientProperty("Refresh").equals("True")){
		initDatas();
		putClientProperty("Refresh", "false");
	}
	
}

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
	// TODO Auto-generated method stub
	Object source = arg0.getSource();
	if (source == jButtonAdd){
		try {
			ViewManager.goToSubFunctionScreen(new AddVendorPanel());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}else if (source == jButtonDelete){
		deleteExcu();
	}else if (source == jButtonSearch){
		searchExcu();
	}else if (source == jButtonUpdate){
		modifyExcu();
	}
	
}

	/**
	 * Method name: modifyExcu <BR>
	 * Description: Modify Execute <BR>
	 * Remark: <BR>  void<BR>
	 */
	private void modifyExcu() {
	// TODO Auto-generated method stub
	List<HashMap<String, String>> selectedData = ViewUtil.getSelectedData(jTable1);
	if (selectedData.size() != 1){
		JOptionPane.showMessageDialog(null, "Please Choose 1 Vendor To Modify !", "Error", JOptionPane.ERROR_MESSAGE);
		return;
	}
	Map<String, String> selectedMap = NameConverter.convertViewMap2PhysicMap(selectedData.get(0), "Vendor");
	VendorBean selectedVendorBean = new VendorBean();
	BeanUtil.transMap2Bean(selectedMap, selectedVendorBean);
	try {
		ViewManager.goToSubFunctionScreen(new AddVendorPanel(selectedVendorBean, AddVendorPanel.UPDATE_VENDOR));
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}

	/**
	 * Method name: searchExcu <BR>
	 * Description: Search Execute <BR>
	 * Remark: <BR>  void<BR>
	 */
	private void searchExcu() {
	// TODO Auto-generated method stub
	String key, valuelike;
	key = (String) jComboBox1.getSelectedItem();
	key = NameConverter.convertViewName2PhysicName("Vendor", key);
	valuelike = jTextField1.getText();
	List<VendorBean> searchResult = vendorService.searchVendorByKey(key, valuelike);
	jTable1.setModel(ViewUtil.transferBeanList2DefaultTableModel(searchResult, "Vendor"));
	
}

	/**
	 * Method name: deleteExcu <BR>
	 * Description: Delete Execute <BR>
	 * Remark: <BR>  void<BR>
	 */
	private void deleteExcu() {
	// TODO Auto-generated method stub
	List<HashMap<String, String>> selectedData = ViewUtil.getSelectedData(jTable1);
	int option = 1;
	if (selectedData.size() < 1){
		JOptionPane.showMessageDialog(null, "Please At Least Choose One Vendor To Delete !", "Error", JOptionPane.ERROR_MESSAGE);
		return;
	}
	if(selectedData.size() == 1){
		option = JOptionPane.showConfirmDialog(null, "Are You Sure To Delete This Vendor ?", "Info", JOptionPane.YES_NO_OPTION);
	}else{
		option = JOptionPane.showConfirmDialog(null, "Are You Sure To Delete These " + selectedData.size() + " Vendors ?", "Info", JOptionPane.YES_NO_OPTION);
	}
	if (option == 1){
		return;
	}else {
		for (HashMap<String, String> map:selectedData){
			vendorService.deleteVendorByMap(NameConverter.convertViewMap2PhysicMap(map, "Vendor"));
		}
	}
	this.initDatas();
	
}
}


















