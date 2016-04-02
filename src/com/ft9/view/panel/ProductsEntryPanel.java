package com.ft9.view.panel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import org.apache.log4j.Logger;

import com.ft9.annotation.Menu;
import com.ft9.bean.ProductBean;
import com.ft9.service.IProductService;
import com.ft9.service.ServiceManager;
import com.ft9.service.ServiceNotFoundException;
import com.ft9.service.impl.ProductService;
import com.ft9.util.ViewUtil;
import com.ft9.view.ViewManager;

/**
 * class name:ProductsEntryPanel <BR>
 * class description: When Under Threshold, Add New Product Panel <BR>
 * Remark: <BR>
 * @version 1.00
 * @author Cai Yicheng
 */

//Set The JTree Name
@Menu(name="New Product",fatherName="Entry&Replenish")
public class ProductsEntryPanel extends javax.swing.JPanel {

		private static final long serialVersionUID = -5839264665300237904L;
		private static Logger log = Logger.getLogger(ProductsEntryPanel.class);
		private IProductService productService=null;
	   public ProductsEntryPanel() throws ServiceNotFoundException {
		   productService=(ProductService)ServiceManager.getService("Product");
	       initComponents();
	   }
	
	   /**
	 * Method name: initComponents <BR>
	 * Description: Init Components In ProductEntryPanel <BR>
	 * Remark: <BR>  void<BR>
	 */
	private void initComponents() {
	       goHomeBtn = ViewManager.createGoHomeButton();
	       jLabel1 = new javax.swing.JLabel();
	       jComboBox1 = new javax.swing.JComboBox<>();
	       jLabel2 = new javax.swing.JLabel();
	       nameTxtField = new javax.swing.JTextField();
	       jLabel3 = new javax.swing.JLabel();
	       quantityTxtField = new javax.swing.JTextField();
	       jLabel4 = new javax.swing.JLabel();
	       priceTxtField = new javax.swing.JTextField();
	       jLabel5 = new javax.swing.JLabel();
	       barcodeTxtField = new javax.swing.JTextField();
	       jLabel6 = new javax.swing.JLabel();
	       thresholdTxtField = new javax.swing.JTextField();
	       jLabel7 = new javax.swing.JLabel();
	       orderQuantityTxtField = new javax.swing.JTextField();
	       submitBtn = new javax.swing.JButton();
	       clearBtn = new javax.swing.JButton();
	       jLabel8 = new javax.swing.JLabel();
	       jScrollPane1 = new javax.swing.JScrollPane();
	       descTxtArea = new javax.swing.JTextArea();

	       jLabel1.setText("Category:");

	       jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(productService.getAllCategory()));

	       jLabel2.setText("Name:");

	       jLabel3.setText("Quantity:");

	       jLabel4.setText("Price:");

	       jLabel5.setText("Barcode:");

	       jLabel6.setText("threshold:");

	       jLabel7.setText("Order Quanity:");
	       submitBtn.setText("Add");
	       submitBtn.addActionListener(new ActionListener() {
				
	    	@Override
	    	public void actionPerformed(ActionEvent e) {
	    		submitExec();
	    	}
	    	});
	       clearBtn.setText("Clear");
	            
	       clearBtn.addActionListener(new java.awt.event.ActionListener() {
	        public void actionPerformed(java.awt.event.ActionEvent evt) {
	                   clearAllTextArea();
	                }
	            });
	  

	       jLabel8.setText("Description:");

	       descTxtArea.setColumns(20);
	       descTxtArea.setRows(5);
	       jScrollPane1.setViewportView(descTxtArea);

	       javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
	       this.setLayout(layout);
	       layout.setHorizontalGroup(
	           layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	           .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
	               .addContainerGap()
	               .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
	                   .addGroup(layout.createSequentialGroup()
	                       .addGap(0, 0, Short.MAX_VALUE)
	                       .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
	                       .addComponent(goHomeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
	               .addGap(19, 19, 19))
	           .addGroup(layout.createSequentialGroup()
	               .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                   .addGroup(layout.createSequentialGroup()
	                       .addGap(266, 266, 266)
	                       .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                           .addComponent(jLabel3)
	                           .addComponent(jLabel4)
	                           .addComponent(jLabel5)
	                           .addComponent(jLabel6)
	                           .addComponent(jLabel1)
	                           .addComponent(jLabel2)
	                           .addComponent(jLabel7)
	                           .addComponent(jLabel8)))
	                   .addGroup(layout.createSequentialGroup()
	                       .addGap(167, 167, 167)
	                       .addComponent(submitBtn,90,90,90)))
	               .addGap(20, 20, 20)
	               .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                   .addGroup(layout.createSequentialGroup()
	                       .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                           .addComponent(barcodeTxtField,100,100,100)
	                           .addComponent(priceTxtField,100,100,100)
	                           .addComponent(quantityTxtField,100,100,100)
	                           .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
	                               .addComponent(thresholdTxtField,100,100,100)
	                               .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                               .addComponent(nameTxtField,100,100,100)
	                               .addComponent(orderQuantityTxtField,100,100,100)))
	                       .addGap(350, 350, 350))
	                   .addGroup(layout.createSequentialGroup()
	                       .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
	                           .addComponent(clearBtn,90,90,90)
	                           .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE))
	                       .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
	       );
	       layout.setVerticalGroup(
	           layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	           .addGroup(layout.createSequentialGroup()
	               .addContainerGap()
	               .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                   .addComponent(goHomeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
	                   )
	               .addGap(23, 23, 23)
	               .addGap(30, 30, 30)
	               .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                   .addGroup(layout.createSequentialGroup()
	                       .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
	                       .addGap(18, 18, 18)
	                       .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                           .addComponent(nameTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
	                           .addComponent(jLabel2))
	                       .addGap(18, 18, 18)
	                       .addComponent(quantityTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
	                   .addGroup(layout.createSequentialGroup()
	                       .addComponent(jLabel1)
	                       .addGap(63, 63, 63)
	                       .addComponent(jLabel3)))
	               .addGap(18, 18, 18)
	               .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                   .addComponent(priceTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
	                   .addComponent(jLabel4))
	               .addGap(18, 18, 18)
	               .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                   .addComponent(jLabel5)
	                   .addGroup(layout.createSequentialGroup()
	                       .addComponent(barcodeTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
	                       .addGap(18, 18, 18)
	                       .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                           .addComponent(thresholdTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
	                           .addComponent(jLabel6))))
	               .addGap(18, 18, 18)
	               .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                   .addComponent(orderQuantityTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
	                   .addComponent(jLabel7))
	               .addGap(18, 18, 18)
	               .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                   .addComponent(jLabel8)
	                   .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
	               .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
	               .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                   .addComponent(clearBtn,35,35,35)
	                   .addComponent(submitBtn,35,35,35))
	               .addGap(50, 50, 50))
	       );
	   }                                           


	   /**
	 * Method name: clearAllTextArea <BR>
	 * Description: Clear All TextField <BR>
	 * Remark: <BR>  void<BR>
	 */
	private void clearAllTextArea() {                                         
	       descTxtArea.setText("");
	       nameTxtField.setText("");
	       quantityTxtField.setText("");
	       priceTxtField.setText("");
	       barcodeTxtField.setText("");
	       thresholdTxtField.setText("");
	       orderQuantityTxtField.setText("");
	       this.clearAllTextError();
	       
	   }      
	   
	   /**
	 * Method name: submitExec <BR>
	 * Description: Submit Execute <BR>
	 * Remark: <BR>  void<BR>
	 */
	public void submitExec(){
		   log.info("submitExec");
	   	this.clearAllTextError();
	   	ProductBean productBean=this.generateDataBean();
	   	if(productBean==null){
	   		return;
	   	}
	   	if(productService.addProductByBean(productBean)){
       		JOptionPane.showMessageDialog(null, "Your Information Added Successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
       		int options=JOptionPane.showConfirmDialog(null, "Continue to add a new product?", "Info",JOptionPane.YES_NO_OPTION);
    		if(options==1){
    			ViewManager.goToHomePanel();;
    		}
       	}else{
       		JOptionPane.showMessageDialog(null, "Something Error", "Error", JOptionPane.ERROR_MESSAGE);
       	}

	   	
	   	
	   }
	   
	   /**
	 * Method name: generateDataBean <BR>
	 * Description: Collect All The Product Datas <BR>
	 * Remark: <BR>
	 * @return  ProductBean<BR>
	 */
	private ProductBean generateDataBean(){
			if(!checkIfAllTxtFulfilled()){
		   		JOptionPane.showMessageDialog(null, "Every column can't be null", "Error", JOptionPane.ERROR_MESSAGE);
		   		return null;
		   	}else if(!checkTxtNumberical()){
		   		JOptionPane.showMessageDialog(null, "Column must be number!", "Error", JOptionPane.ERROR_MESSAGE);
		   		return null;
		   	}
	   	ProductBean newProductBean=new ProductBean();
	   	newProductBean.setBarCode(barcodeTxtField.getText());
	   	newProductBean.setDescription(descTxtArea.getText());
	   	newProductBean.setName(nameTxtField.getText());
	   	newProductBean.setOrderQuantity(orderQuantityTxtField.getText());
	   	newProductBean.setPrice(priceTxtField.getText());
	   	newProductBean.setQuantityAvailable(quantityTxtField.getText());
	   	newProductBean.setReorderQuantity(thresholdTxtField.getText());
	    String productId=jComboBox1.getSelectedItem().toString()+"/"+productService.getMaxProductNumerOfCategory(jComboBox1.getSelectedItem().toString());
		newProductBean.setId(productId);
	   	return newProductBean;
	   }
	
	   /**
	 * Method name: checkTxtNumberical <BR>
	 * Description: Check If TextField Input Is Integer <BR>
	 * Remark: <BR>
	 * @return  boolean<BR>
	 */
	private boolean checkTxtNumberical(){
		   if(!ViewUtil.isJTextNumberical(orderQuantityTxtField)){
			   ViewUtil.setJTextError(orderQuantityTxtField);
			   return false;
		   }else if(!ViewUtil.isJTextNumberical(quantityTxtField)){
			   ViewUtil.setJTextError(quantityTxtField);
			   return false;
		   }else if(!ViewUtil.isJTextNumberical(thresholdTxtField)){
			   ViewUtil.setJTextError(thresholdTxtField);
			   return false;
		   }else if(!ViewUtil.isJTextDecimal(priceTxtField)){
			   ViewUtil.setJTextError(priceTxtField);
			   return false;
		   }
		   return true;
	   }
	
	   /**
	 * Method name: checkIfAllTxtFulfilled <BR>
	 * Description: Check If All TextField Fulfilled <BR>
	 * Remark: <BR>
	 * @return  boolean<BR>
	 */
	private boolean checkIfAllTxtFulfilled(){
	   	
	   	if(ViewUtil.isJTextEmpty(nameTxtField)){
	   		ViewUtil.setJTextError(nameTxtField);
	   		return false;
	   	}else if(ViewUtil.isJTextEmpty(descTxtArea)){
	   		ViewUtil.setJTextError(descTxtArea);
	   		return false;
	   	}else if(ViewUtil.isJTextEmpty(quantityTxtField)){
	   		ViewUtil.setJTextError(quantityTxtField);
	   		return false;
	   	}else if(ViewUtil.isJTextEmpty(priceTxtField)){
	   		ViewUtil.setJTextError(priceTxtField);
	   		return false;
	   	}else if(ViewUtil.isJTextEmpty(barcodeTxtField)){
	   		ViewUtil.setJTextError(barcodeTxtField);
	   		return false;
	   	}else if(ViewUtil.isJTextEmpty(thresholdTxtField)){
	   		ViewUtil.setJTextError(thresholdTxtField);
	   		return false;
	   	}else if(ViewUtil.isJTextEmpty(orderQuantityTxtField)){
	   		ViewUtil.setJTextError(orderQuantityTxtField);
	   		return false;
	   	}
	   	return true;
	   }
	   
	   /**
	 * Method name: clearAllTextError <BR>
	 * Description: Clear All Text Error <BR>
	 * Remark: <BR>  void<BR>
	 */
	private void clearAllTextError(){
	   	ViewUtil.clearJTextError(nameTxtField);
	   	ViewUtil.clearJTextError(descTxtArea);
	   	ViewUtil.clearJTextError(quantityTxtField);
	   	ViewUtil.clearJTextError(priceTxtField);
	   	ViewUtil.clearJTextError(barcodeTxtField);
	 	ViewUtil.clearJTextError(thresholdTxtField);
	   	ViewUtil.clearJTextError(orderQuantityTxtField);
	   }
	
	   private javax.swing.JButton goHomeBtn;
	   private javax.swing.JButton submitBtn;
	   private javax.swing.JButton clearBtn;
	   private javax.swing.JComboBox<String> jComboBox1;
	   private javax.swing.JLabel jLabel1;
	   private javax.swing.JLabel jLabel2;
	   private javax.swing.JLabel jLabel3;
	   private javax.swing.JLabel jLabel4;
	   private javax.swing.JLabel jLabel5;
	   private javax.swing.JLabel jLabel6;
	   private javax.swing.JLabel jLabel7;
	   private javax.swing.JLabel jLabel8;
	   private javax.swing.JScrollPane jScrollPane1;
	   private javax.swing.JTextArea descTxtArea;
	   private javax.swing.JTextField nameTxtField;
	   private javax.swing.JTextField quantityTxtField;
	   private javax.swing.JTextField priceTxtField;
	   private javax.swing.JTextField barcodeTxtField;
	   private javax.swing.JTextField thresholdTxtField;
	   private javax.swing.JTextField orderQuantityTxtField;
	   // End of variables declaration                   
	}
