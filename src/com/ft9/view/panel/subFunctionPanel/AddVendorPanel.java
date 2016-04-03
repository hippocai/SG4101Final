package com.ft9.view.panel.subFunctionPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JOptionPane;

import com.ft9.bean.CategoryBean;
import com.ft9.bean.VendorBean;
import com.ft9.service.ICategoryService;
import com.ft9.service.IVendorService;
import com.ft9.service.ServiceManager;
import com.ft9.service.ServiceNotFoundException;
import com.ft9.service.impl.CategoryService;
import com.ft9.service.impl.VendorService;
import com.ft9.util.ViewUtil;
import com.ft9.view.ViewManager;

/**
 *
 * @author hippo
 */
/**
 * class name:AddVendorPanel <BR>
 * class description: Add Vendor Panel <BR>
 * Remark: <BR>
 * @version 1.00
 * @author Cai Yicheng
 */
public class AddVendorPanel extends javax.swing.JPanel {

	public static final int ADD_NEW_VENDOR = 0X01;
	public static final int UPDATE_VENDOR = 0X02;

	private int type = ADD_NEW_VENDOR;
    /**  
	 * define a field serialVersionUID which type is long
	 */
	private static final long serialVersionUID = 235902691640932831L;
	IVendorService vendorService;
	ICategoryService categoryService;
	List<CategoryBean>categories=new ArrayList<CategoryBean>();
    public AddVendorPanel() throws ServiceNotFoundException {
    	initService();
        initComponents();
    }
    public AddVendorPanel(VendorBean vendorBean,int _type) throws ServiceNotFoundException {
    	this.type=_type;
    	initService();
        initComponents();
        if(type==UPDATE_VENDOR){
        	submitBtn.setText("Update");
        	initDatas(vendorBean);
        	nameTxtField.setEnabled(false);
        }
    }
    
    /**
     * Method name: initDatas <BR>
     * Description: Init Datas <BR>
     * Remark: <BR>
     * @param vendorBean  void<BR>
     */
    public void initDatas(VendorBean vendorBean){
    	nameTxtField.setText(vendorBean.getName());
    	descTxtField.setText(vendorBean.getDescription());
    	categories=vendorService.getAllCategoriesByVendorName(vendorBean.getName());
    	setTable();
    }
    public void initService() throws ServiceNotFoundException{
    	vendorService=(VendorService)ServiceManager.getService("Vendor");
    	categoryService=(CategoryService)ServiceManager.getService("Category");
    }

    /**
     * Method name: initComponents <BR>
     * Description: Init Components <BR>
     * Remark: <BR>  void<BR>
     */
    private void initComponents() {

        goBackBtn = ViewManager.createGoBackButton();
        goHomeBtn = ViewManager.createGoHomeButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        nameTxtField = new javax.swing.JTextField();
        descTxtField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        categoryBox = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        submitBtn = new javax.swing.JButton();
        clearBtn = new javax.swing.JButton();
        deleteCategoryBtn = new javax.swing.JButton();
        addCategoryBtn = new javax.swing.JButton();

        jLabel1.setText("Name:");

        jLabel2.setText("Description:");

        nameTxtField.setText("");

        descTxtField.setText("");

        jLabel3.setText("Category:");
        categoryBox.setModel(new javax.swing.DefaultComboBoxModel<>(this.getAllCategory()));
        setTable();
        jScrollPane1.setViewportView(jTable1);

        submitBtn.setText("Add");
        submitBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				submitExec();
			}
		});
        clearBtn.setText("Clear");
        clearBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				clearAllTheData();
			}
		});
        deleteCategoryBtn.setText("Delete");
        deleteCategoryBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				deleteCategoryExec();
			}
		});
        addCategoryBtn.setText("Add");
        addCategoryBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				addCategoryExec();
				
			}
		});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(goBackBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(goHomeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
            .addGroup(layout.createSequentialGroup()
                .addGap(274, 274, 274)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(submitBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(clearBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel3)
                            .addGap(18, 18, 18)
                            .addComponent(categoryBox, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(addCategoryBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(deleteCategoryBtn))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(descTxtField)
                                .addComponent(nameTxtField))))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(174, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(goBackBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(goHomeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(103, 103, 103)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(nameTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(descTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(categoryBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deleteCategoryBtn)
                    .addComponent(addCategoryBtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(submitBtn)
                    .addComponent(clearBtn))
                .addGap(74, 74, 74))
        );
    }                        


    private javax.swing.JButton goBackBtn;
    private javax.swing.JButton goHomeBtn;
    private javax.swing.JButton submitBtn;
    private javax.swing.JButton clearBtn;
    private javax.swing.JButton deleteCategoryBtn;
    private javax.swing.JButton addCategoryBtn;
    private javax.swing.JComboBox<String> categoryBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField nameTxtField;
    private javax.swing.JTextField descTxtField;
    // End of variables declaration      
    
    /**
     * Method name: getAllCategory <BR>
     * Description: Get All Category <BR>
     * Remark: <BR>
     * @return  String[]<BR>
     */
    private String[] getAllCategory() {
		List<CategoryBean>categoryList=categoryService.getAllCategorys();
		List<String>categoryIdList=new ArrayList<String>();
		for(CategoryBean categoryBean:categoryList){
			categoryIdList.add(categoryBean.getCode());
		}
		String[] stringArr=new String[categoryIdList.size()];
		return categoryIdList.toArray(stringArr);
	}
    
    /**
     * Method name: setTable <BR>
     * Description: Put All Datas Into The table <BR>
     * Remark: <BR>  void<BR>
     */
    private void setTable(){
    	jTable1.setModel(ViewUtil.transferBeanList2DefaultTableModel(categories,"Category"));
    }
    
    /**
     * Method name: addCategoryExec <BR>
     * Description: Add Category Execute <BR>
     * Remark: <BR>  void<BR>
     */
    private void addCategoryExec(){
    	String categoryCode=categoryBox.getSelectedItem().toString();
    	Map<String,String>map=new HashMap<String,String>();
    	map.put("code", categoryCode);
    	CategoryBean categoryBean=categoryService.getCategoryByMap(map).get(0);
    	if(this.categoryListContains(categories, categoryBean)){
    		JOptionPane.showMessageDialog(null, "This Category Is Already Added", "Error", JOptionPane.ERROR_MESSAGE);
    		return;
    	}
    	categories.add(categoryBean);
    	setTable();
    }
    /**
     * Method name: deleteCategoryExec <BR>
     * Description: Delete Category Execute <BR>
     * Remark: <BR>  void<BR>
     */
    private void deleteCategoryExec(){
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
			String categoryCode=map.get("Code");
			for(CategoryBean categoryBean:categories){
				if(categoryBean.getCode().equals(categoryCode)){
					categories.remove(categoryBean);
					break;
				}
			}
		}
		setTable();
    }
     
    /**
     * Method name: clearAllTheData <BR>
     * Description: Clear All Data <BR>
     * Remark: <BR>  void<BR>
     */
    private void clearAllTheData(){
    	descTxtField.setText("");
    	if(type==ADD_NEW_VENDOR){
    		nameTxtField.setText("");
    	}
    	
    	categories=new ArrayList<CategoryBean>();
    	setTable();
    }
    
    /**
     * Method name: submitExec <BR>
     * Description: Submit Execute <BR>
     * Remark: <BR>  void<BR>
     */
    private void submitExec(){
    	VendorBean vendorBean=null;
    	if(!checkIfAllFulfilled()){
    		JOptionPane.showMessageDialog(null, "All Column should be fulfilled", "Error", JOptionPane.ERROR_MESSAGE);
    	}else{
    		vendorBean=this.generateVendorBean();
    	}
    	if(categories.size()==0){
    		JOptionPane.showMessageDialog(null, "You need to add at least one category", "Error", JOptionPane.ERROR_MESSAGE);
    		return;
    	}
    	if(type==ADD_NEW_VENDOR){
    		if(!checkIfVendorNameExisted()){
    			JOptionPane.showMessageDialog(null, "Vendor name has already existed", "Error", JOptionPane.ERROR_MESSAGE);
    		}else{
    			addExec(vendorBean);
    		}
    		
    	}else{
    		modifyExec(vendorBean);
    	}
    	
    }
    
    /**
     * Method name: modifyExec <BR>
     * Description: Modify Execute <BR>
     * Remark: <BR>
     * @param vendorBean  void<BR>
     */
    private void modifyExec(VendorBean vendorBean){
    	if(vendorService.updateVendorByCategoryList(vendorBean, categories)){
    		JOptionPane.showMessageDialog(null, "Modify Successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
    	}else{
    		JOptionPane.showMessageDialog(null, "OOPs,Sth is wrong", "Error", JOptionPane.ERROR_MESSAGE);
    	}
    	goBackBtn.doClick();
    }
    
    /**
     * Method name: addExec <BR>
     * Description: Add Execute <BR>
     * Remark: <BR>
     * @param vendorBean  void<BR>
     */
    private void addExec(VendorBean vendorBean){
    	if(vendorService.addNewVendorInCategoryBeanList(vendorBean, categories)){
    		JOptionPane.showMessageDialog(null, "Add Successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
    	}else{
    		JOptionPane.showMessageDialog(null, "OOPs,Sth is wrong", "Error", JOptionPane.ERROR_MESSAGE);
    	}
    	goBackBtn.doClick();
    }
    
    /**
     * Method name: checkIfAllFulfilled <BR>
     * Description: Check If All Fulfilled <BR>
     * Remark: <BR>
     * @return  boolean<BR>
     */
    private boolean checkIfAllFulfilled(){
 	   if (ViewUtil.isJTextEmpty(nameTxtField)){
 		   ViewUtil.setJTextError(nameTxtField);
 		   return false;
 	   }else if (ViewUtil.isJTextEmpty(descTxtField)){
 		   ViewUtil.setJTextError(descTxtField);
 		   return false;
 	   }
 	   return true;
    }
    
    /**
     * Method name: checkIfVendorNameExisted <BR>
     * Description: Check If Vendor Name Existed <BR>
     * Remark: <BR>
     * @return  boolean<BR>
     */
    private boolean checkIfVendorNameExisted(){
    	if(vendorService.isNameExisted(nameTxtField.getText())){
    		ViewUtil.setJTextError(nameTxtField);
    		return false;
    	}
    	return true;
    }
    
    /**
     * Method name: generateVendorBean <BR>
     * Description: Check Data <BR>
     * Remark: <BR>
     * @return  VendorBean<BR>
     */
    private VendorBean generateVendorBean(){
    	VendorBean vendorBean=new VendorBean();
    	vendorBean.setName(nameTxtField.getText());
    	vendorBean.setDescription(descTxtField.getText());
    	return vendorBean;
    }
    
	/**
	 * Method name: categoryListContains <BR>
	 * Description: Check Category List Contains <BR>
	 * Remark: <BR>
	 * @param categoryList
	 * @param categoryBean
	 * @return  boolean<BR>
	 */
	private boolean categoryListContains(List<CategoryBean>categoryList,CategoryBean categoryBean){
		for(CategoryBean categoryBeanInList:categoryList){
			if(categoryBeanInList.getCode().equals(categoryBean.getCode())){
				return true;
			}
		}
		return false;
	}
}
