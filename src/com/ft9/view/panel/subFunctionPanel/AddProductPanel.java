package com.ft9.view.panel.subFunctionPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import org.apache.log4j.Logger;
import com.ft9.bean.ProductBean;
import com.ft9.service.IProductService;
import com.ft9.service.ServiceManager;
import com.ft9.service.ServiceNotFoundException;
import com.ft9.service.impl.ProductService;
import com.ft9.util.ViewUtil;
import com.ft9.view.ViewManager;
/**
 *
 * @author apple
 */
public class AddProductPanel extends javax.swing.JPanel {

    /**  
	 * define a field serialVersionUID which type is long
	 */
	private static final long serialVersionUID = 1L;
	private static Logger log = Logger.getLogger(AddProductPanel.class);
	private IProductService productService=null;
	public final static int ADD_NEW_DISCOUNT=0x01;
	public final static int MODIFY_DISCOUNT=0x02;
	
	private int type=ADD_NEW_DISCOUNT; 
	private ProductBean productBean=null;
   public AddProductPanel() throws ServiceNotFoundException {
	   productService=(ProductService)ServiceManager.getService("Product");
       initComponents();
   }
   public AddProductPanel(ProductBean productBean,int _type) throws ServiceNotFoundException {
	   productService=(ProductService)ServiceManager.getService("Product");
       initComponents();
       this.productBean=productBean;
       this.type=_type;
       setDatas();
       
   }

   private void setDatas(){
   	if(productBean==null){
   		return;
   	}
    descTxtArea.setText(productBean.getDescription());;
    nameTxtField.setText(productBean.getName());
    quantityTxtField.setText(productBean.getQuantityAvailable());
    priceTxtField.setText(productBean.getPrice());
    barcodeTxtField.setText(productBean.getBarCode());
    thresholdTxtField.setText(productBean.getReorderQuantity());
    orderQuantityTxtField.setText(productBean.getOrderQuantity());
    String categoryName=productBean.getId().substring(0,productBean.getId().indexOf("/"));
    jComboBox1.setSelectedItem(categoryName);
    jComboBox1.setEnabled(false);
    if(type==AddProductPanel.MODIFY_DISCOUNT){
    	submitBtn.setText("Modify");
    }
   }
   
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        nameTxtField = new javax.swing.JTextField();
        quantityTxtField = new javax.swing.JTextField();
        priceTxtField = new javax.swing.JTextField();
        barcodeTxtField = new javax.swing.JTextField();
        thresholdTxtField = new javax.swing.JTextField();
        orderQuantityTxtField = new javax.swing.JTextField();
        backBtn = ViewManager.createGoBackButton();
        homeBtn = ViewManager.createGoHomeButton();
        submitBtn = new javax.swing.JButton();
        clearBtn = new javax.swing.JButton();
        printBtn = ViewManager.createPrintButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        descTxtArea = new javax.swing.JTextArea();

        jLabel1.setText("Category:");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(productService.getAllCategory()));

        jLabel2.setText("Price:");

        jLabel3.setText("Name:");

        jLabel4.setText("Quantity:");

        jLabel5.setText("Order:");

        jLabel6.setText("Description:");

        jLabel7.setText("Threshold:");
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

        jLabel8.setText("Barcode");
        descTxtArea.setColumns(20);
        descTxtArea.setRows(5);
        jScrollPane1.setViewportView(descTxtArea);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(homeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(backBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(189, 189, 189)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(78, 78, 78)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(nameTxtField, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)))
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(78, 78, 78)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(orderQuantityTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(clearBtn)
                                        .addGap(118, 118, 118)
                                        .addComponent(printBtn))
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(78, 78, 78)
                                    .addComponent(quantityTxtField))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(78, 78, 78)
                                    .addComponent(priceTxtField))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(barcodeTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(78, 78, 78)
                                        .addComponent(thresholdTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(144, 144, 144)
                        .addComponent(submitBtn)))
                .addContainerGap(153, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(homeBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                    .addComponent(backBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(nameTxtField)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(quantityTxtField, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(priceTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(barcodeTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(thresholdTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(orderQuantityTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(110, 110, 110)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(submitBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(clearBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(printBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47))
        );
    }// </editor-fold>  

    private void clearAllTextArea() {                                         
        // TODO add your handling code here:
        descTxtArea.setText("");
        nameTxtField.setText("");
        quantityTxtField.setText("");
        priceTxtField.setText("");
        barcodeTxtField.setText("");
        thresholdTxtField.setText("");
        orderQuantityTxtField.setText("");
        this.clearAllTextError();
        
    }      
    
    public void submitExec(){
 	   log.info("submitExec");
    	this.clearAllTextError();
    	this.productBean=this.generateDataBean();
    	if(productBean==null){
    		return;
    	}
    	
    	if(this.type==AddDiscountPanel.ADD_NEW_DISCOUNT){
    		if(productService.addProductByBean(productBean)){
        		JOptionPane.showMessageDialog(null, "Your Information Added Successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
        	}else{
        		JOptionPane.showMessageDialog(null, "OOPs,Something error!", "Error", JOptionPane.ERROR_MESSAGE);
        	}
    	}else{
    		if(productService.updateProductByBean(productBean)){
    			JOptionPane.showMessageDialog(null, "Your Information updated Successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
    			ViewManager.goBack();
    		}else{
    			JOptionPane.showMessageDialog(null, "OOPs,Something error!", "Error", JOptionPane.ERROR_MESSAGE);
    		}
    	}
    	
    	
    }
    
    private ProductBean generateDataBean(){
 	   log.info("Generate Bean");
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
    if(type==ADD_NEW_DISCOUNT){
 	   String productId=jComboBox1.getSelectedItem().toString()+"/"+productService.getMaxProductNumerOfCategory(jComboBox1.getSelectedItem().toString());
 	   newProductBean.setId(productId);
    }else{
 	   newProductBean.setId(this.productBean.getId());
    }
    	return newProductBean;
    }
    
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
    
    private void clearAllTextError(){
    	ViewUtil.clearJTextError(nameTxtField);
    	ViewUtil.clearJTextError(descTxtArea);
    	ViewUtil.clearJTextError(quantityTxtField);
    	ViewUtil.clearJTextError(priceTxtField);
    	ViewUtil.clearJTextError(barcodeTxtField);
  	ViewUtil.clearJTextError(thresholdTxtField);
    	ViewUtil.clearJTextError(orderQuantityTxtField);
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton backBtn;
    private javax.swing.JButton homeBtn;
    private javax.swing.JButton submitBtn;
    private javax.swing.JButton clearBtn;
    private javax.swing.JButton printBtn;
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
