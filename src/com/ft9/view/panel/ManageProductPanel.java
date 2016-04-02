package com.ft9.view.panel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JOptionPane;

import com.ft9.annotation.Menu;
import com.ft9.bean.ProductBean;
import com.ft9.service.IProductService;
import com.ft9.service.ServiceManager;
import com.ft9.service.ServiceNotFoundException;
import com.ft9.service.impl.ProductService;
import com.ft9.util.BeanUtil;
import com.ft9.util.ViewUtil;
import com.ft9.view.NameConverter;
import com.ft9.view.ViewManager;
import com.ft9.view.panel.subFunctionPanel.AddProductPanel;

/**
 * class name:ManageProductPanel <BR>
 * class description: Manage The Product Datas Panel <BR>
 * Remark: <BR>
 * @version 1.00
 * @author Cai Yicheng
 */

//Set The JTree Name
@Menu(name = "Product", fatherName = "Manage")

/**
 *
 * @author hippo
 */
public class ManageProductPanel extends javax.swing.JPanel implements ActionListener,PropertyChangeListener{

    /**  
	 * define a field serialVersionUID which type is long
	 */
	private static final long serialVersionUID = 1L;
	/**
     * Creates new form ManageProductPanel
     */
	IProductService productService=null;
    public ManageProductPanel() throws ServiceNotFoundException {
    	productService=(ProductService)ServiceManager.getService("Product");
        initComponents();
        initDatas();
        setActionListener();
    }
    
    /**
     * Method name: initDatas <BR>
     * Description: Put The Product Datas Into The Table <BR>
     * Remark: <BR>  void<BR>
     */
    private void initDatas(){
    	jTable1.setModel(ViewUtil.transferBeanList2DefaultTableModel(productService.getAllProducts(),"Product"));
    }
    
    /**
     * Method name: setActionListener <BR>
     * Description: Set ActionListener <BR>
     * Remark: <BR>  void<BR>
     */
    private void setActionListener(){
    	this.addPropertyChangeListener("Refresh", this);
    	deleteBtn.addActionListener(this);
    	addBtn.addActionListener(this);
    	searchBtn.addActionListener(this);
    	modifyBtn.addActionListener(this);
    }
    
    /**
     * Method name: initComponents <BR>
     * Description: Init Components In The Product Panel <BR>
     * Remark: <BR>  void<BR>
     */
    private void initComponents() {

        goHomeButton = ViewManager.createGoHomeButton();
        searchTxtField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        searchBtn = new javax.swing.JButton();
        addBtn = new javax.swing.JButton();
        deleteBtn = new javax.swing.JButton();
        modifyBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = ViewUtil.createUneditableTable();
        jComboBox1 = new javax.swing.JComboBox<>();


        searchTxtField.setText("");
        searchTxtField.setSize(72, 21);
        jLabel1.setText("Key Word:");

        searchBtn.setText("Search");
    

        addBtn.setText("Add");

        deleteBtn.setText("Delete");

        modifyBtn.setText("Modify");

        jScrollPane1.setViewportView(jTable1);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(NameConverter.getTitleArr("Product")));
   

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
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(goHomeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(23, 23, 23))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(addBtn)
                                .addGap(53, 53, 53)
                                .addComponent(deleteBtn)
                                .addGap(53, 53, 53)
                                .addComponent(modifyBtn))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(10, 10, 10)
                                .addComponent(searchTxtField, 77, 77, 77)
                                .addGap(18, 18, 18)
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(searchBtn)))
                        .addGap(400, 400, 400))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(goHomeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(searchBtn)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addBtn)
                    .addComponent(deleteBtn)
                    .addComponent(modifyBtn))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 415, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );
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
		Object source=arg0.getSource();
		if(source==deleteBtn){
			deleteExec();
		}else if(source==addBtn){
			try {
				ViewManager.goToSubFunctionScreen(new AddProductPanel());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(source==searchBtn){
			searchExec();
		}else if(source==modifyBtn){
			modifyExec();
		}
		
	}
	
	/**
	 * Method name: modifyExec <BR>
	 * Description: Modify Execute <BR>
	 * Remark: <BR>  void<BR>
	 */
	private void modifyExec(){
		try {
			List<HashMap<String,String>> selectedDatas=ViewUtil.getSelectedData(jTable1);
			if(selectedDatas.size()!=1){
				JOptionPane.showMessageDialog(null, "Please select 1 item to Modify", "Error", JOptionPane.ERROR_MESSAGE);
				return;
			}
			Map<String,String>selectedMap=NameConverter.convertViewMap2PhysicMap(selectedDatas.get(0), "Product");
			ProductBean selectedProductBean=new ProductBean();
			BeanUtil.transMap2Bean(selectedMap, selectedProductBean);
			ViewManager.goToSubFunctionScreen(new AddProductPanel(selectedProductBean,AddProductPanel.MODIFY_DISCOUNT));
		} catch (ServiceNotFoundException e) {
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
			
			productService.deleteProductByMap(NameConverter.convertViewMap2PhysicMap(map, "Product"));
		}
		this.initDatas();
	}
	
	/**
	 * Method name: searchExec <BR>
	 * Description: Search Execute <BR>
	 * Remark: <BR>  void<BR>
	 */
	private void searchExec(){
		String key=jComboBox1.getSelectedItem().toString();
		key=NameConverter.convertViewName2PhysicName("Product", key);
		String valueLike=searchTxtField.getText();
		List<ProductBean>searchResult=productService.searchProductByKey(key, valueLike);
		jTable1.setModel(ViewUtil.transferBeanList2DefaultTableModel(searchResult,"Product"));
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

    private javax.swing.JButton goHomeButton;
    private javax.swing.JButton searchBtn;
    private javax.swing.JButton addBtn;
    private javax.swing.JButton deleteBtn;
    private javax.swing.JButton modifyBtn;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField searchTxtField;
    // End of variables declaration                   
}
