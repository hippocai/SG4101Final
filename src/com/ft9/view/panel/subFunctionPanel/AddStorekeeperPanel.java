package com.ft9.view.panel.subFunctionPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import com.ft9.bean.StoreKeeperBean;
import com.ft9.service.ServiceManager;
import com.ft9.service.ServiceNotFoundException;
import com.ft9.service.impl.StoreKeeperService;
import com.ft9.util.ViewUtil;
import com.ft9.view.ViewManager;

/**
	 *
	 * @author apple
	 */
	/**
	 * class name:AddStorekeeperPanel <BR>
	 * class description: Add StoreKeeper Panel <BR>
	 * Remark: <BR>
	 * @version 1.00
	 * @author Guo Qi
	 */
	public class AddStorekeeperPanel extends javax.swing.JPanel {

	    /**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private StoreKeeperBean storekeeperBean = null;
		private StoreKeeperService storekeeperService = null;
		
		
	    public AddStorekeeperPanel() throws ServiceNotFoundException {
	        initComponents();
	        this.clearAllTxtField();
	        storekeeperService = (StoreKeeperService) ServiceManager.getService("StoreKeeper");
	    }
	    
	    /**
	     * Method name: initComponents <BR>
	     * Description: Init Components <BR>
	     * Remark: <BR>  void<BR>
	     */
	    private void initComponents() {

	        jLabel1 = new javax.swing.JLabel();
	        jLabel2 = new javax.swing.JLabel();
	        jLabel3 = new javax.swing.JLabel();
	        jTextField1 = new javax.swing.JTextField();
	        jTextField2 = new javax.swing.JTextField();
	        jTextField3 = new javax.swing.JTextField();
	        jButton1 = new javax.swing.JButton();
	        jButton2 = ViewManager.createGoBackButton();

	        jLabel1.setText("Login Name");
	        
	        jLabel2.setText("Password:");
	        
	        jLabel3.setText("Confirm Password:");
	        
	        jTextField1.setText("jTextField1");

	        jTextField2.setText("jTextField2");

	        jTextField3.setText("jTextField3");

	        jButton1.setText("Confirm");
	        
	        jButton1.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					confirmExcu();
				}
	        });


	        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
	        this.setLayout(layout);
	        layout.setHorizontalGroup(
	            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(layout.createSequentialGroup()
	                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                    .addGroup(layout.createSequentialGroup()
	                        .addGap(225, 225, 225)
	                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
	                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
	                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
	                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
	                        .addGap(56, 56, 56)
	                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
	                            .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE)
	                            .addComponent(jTextField2)
	                            .addComponent(jTextField3)))
	                    .addGroup(layout.createSequentialGroup()
	                        .addGap(256, 256, 256)
	                        .addComponent(jButton1)
	                        .addGap(117, 117, 117)
	                        .addComponent(jButton2)))
	                .addContainerGap(172, Short.MAX_VALUE))
	        );
	        layout.setVerticalGroup(
	            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(layout.createSequentialGroup()
	                .addGap(115, 115, 115)
	                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
	                    .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE))
	                .addGap(18, 18, 18)
	                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
	                    .addComponent(jTextField2, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE))
	                .addGap(18, 18, 18)
	                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
	                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
	                .addGap(60, 60, 60)
	                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
	                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
	                .addContainerGap(237, Short.MAX_VALUE))
	        );
	    }                       

	    /**
	     * Method name: clearAllTxtFieldError <BR>
	     * Description: Clear All Text Field Error <BR>
	     * Remark: <BR>  void<BR>
	     */
	    private void clearAllTxtFieldError(){
	    	ViewUtil.clearJTextError(jTextField1);
	    	ViewUtil.clearJTextError(jTextField2);
	    	ViewUtil.clearJTextError(jTextField3);
	    }
	    
	    /**
	     * Method name: clearAllTxtField <BR>
	     * Description: Clear All Text Field <BR>
	     * Remark: <BR>  void<BR>
	     */
	    private void clearAllTxtField(){
	    	jTextField1.setText("");
	    	jTextField2.setText("");
	    	jTextField3.setText("");
	    	clearAllTxtFieldError();
	    }
	    
	    /**
	     * Method name: checkIfAllFieldFulfilled <BR>
	     * Description: Check If All Field Fulfilled <BR>
	     * Remark: <BR>
	     * @return  boolean<BR>
	     */
	    private boolean checkIfAllFieldFulfilled(){
	    	if (ViewUtil.isJTextEmpty(jTextField1)){
	    		ViewUtil.setJTextError(jTextField1);
	    		return false;
	    	}else if (ViewUtil.isJTextEmpty(jTextField2)){
	    		ViewUtil.setJTextError(jTextField2);
	    		return false;
	    	}else if(ViewUtil.isJTextEmpty(jTextField3)){
	    		ViewUtil.setJTextError(jTextField3);
	    		return false;
	    	}
	    	return true;
	    }
	    
	    /**
	     * Method name: checkIfTxtContentsValid <BR>
	     * Description: Check If Text Contents Contain Comma <BR>
	     * Remark: <BR>
	     * @return  boolean<BR>
	     */
	    private boolean checkIfTxtContentsValid(){
			if(jTextField1.getText().contains(",")){
				ViewUtil.setJTextError(jTextField1);
				return false;
			}
			if(jTextField2.getText().contains(",")){
				ViewUtil.setJTextError(jTextField2);
				return false;
			}
			if (jTextField3.getText().contains(",")){
				ViewUtil.setJTextError(jTextField3);
				return false;
			}
			return true;
	    }
	    

	    private javax.swing.JButton jButton1;
	    private javax.swing.JButton jButton2;
	    private javax.swing.JLabel jLabel1;
	    private javax.swing.JLabel jLabel2;
	    private javax.swing.JLabel jLabel3;
	    private javax.swing.JTextField jTextField1;
	    private javax.swing.JTextField jTextField2;
	    private javax.swing.JTextField jTextField3;
	    

	    
	    
	    /**
	     * Method name: generateDataBean <BR>
	     * Description: Check Datas <BR>
	     * Remark: <BR>
	     * @return  StoreKeeperBean<BR>
	     */
	    private StoreKeeperBean generateDataBean(){
	    	if (!checkIfAllFieldFulfilled()){
	    		JOptionPane.showMessageDialog(null, "Every column can't be null", "ERROR", JOptionPane.ERROR_MESSAGE);
	    		return null;
	    	}else if (storekeeperService.isUserNameExisted(jTextField1.getText())){
	    		ViewUtil.setJTextError(jTextField1);
	    		JOptionPane.showMessageDialog(null, "This Storekeeper Has Already Existed!");
	    		return null;
	    	}
	    	if(!checkIfTxtContentsValid()){
	    		JOptionPane.showMessageDialog(null, "The TextField Cannot Contain comma", "Error", JOptionPane.ERROR_MESSAGE);
	    		return null;
	    	}
	    	StoreKeeperBean storekeeperBean = new StoreKeeperBean();
	    	storekeeperBean.setName(jTextField1.getText());
	    	storekeeperBean.setPassword(jTextField2.getText());
	    	return storekeeperBean;
	    }
	   

	    
	    
	/**
	 * Method name: confirmExcu <BR>
	 * Description: Confirm Execute <BR>
	 * Remark: <BR>  void<BR>
	 */
	private void confirmExcu() {
		clearAllTxtFieldError();
		storekeeperBean = this.generateDataBean();
		if (storekeeperBean == null){
			return;
		}
		if (storekeeperService.isUserNameExisted(jTextField1.getText())){
			JOptionPane.showMessageDialog(null, "This Storekeeper Already Existed!", "Error", JOptionPane.ERROR_MESSAGE);
			ViewUtil.setJTextError(jTextField1);
			return;
		}else if (!jTextField2.getText().equals(jTextField3.getText())){
			JOptionPane.showMessageDialog(null, "The Password And The Confirm Password doesn't match", "Error", JOptionPane.ERROR_MESSAGE);
			ViewUtil.setJTextError(jTextField3);
			return;
		}
		if (storekeeperService.addStoreKeeper(storekeeperBean.getName(),storekeeperBean.getPassword())){
			JOptionPane.showMessageDialog(null, "Your Information Added Sucessfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
		}
		clearAllTxtField();
		
	}
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	}


