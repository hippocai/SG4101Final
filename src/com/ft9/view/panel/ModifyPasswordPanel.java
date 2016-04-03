package com.ft9.view.panel;

import javax.swing.JOptionPane;
import com.ft9.annotation.Menu;
import com.ft9.common.Session;
import com.ft9.service.IStoreKeeperService;
import com.ft9.service.ServiceManager;
import com.ft9.service.ServiceNotFoundException;
import com.ft9.service.impl.StoreKeeperService;
import com.ft9.util.ViewUtil;
import com.ft9.view.ViewManager;


/**
 * class name:ModifyPasswordPanel <BR>
 * class description: Modify Password Panel <BR>
 * Remark: <BR>
 * @version 1.00
 * @author Cai Yicheng
 */

//Set The JTree Name
@Menu(name="ModifyPassword",fatherName="StoreKeeper")
/**
*
* @author hippo
*/
public class ModifyPasswordPanel extends javax.swing.JPanel {

   /**  
	 * define a field serialVersionUID which type is long
	 */
	private static final long serialVersionUID = 1L;
/**
    * Creates new form ModifyPasswordPanel
    */
	IStoreKeeperService storeKeeperService;
	
   public ModifyPasswordPanel() throws ServiceNotFoundException {
	   storeKeeperService=(StoreKeeperService)ServiceManager.getService("StoreKeeper");
       initComponents();
   }

   
   /**
 * Method name: initComponents <BR>
 * Description: Init Components In ModifyPasswordPanel<BR>
 * Remark: <BR>  void<BR>
 */
   private void initComponents() {

       jButton1 = new javax.swing.JButton();
       oldPwdTxtField = new javax.swing.JPasswordField();
       jLabel1 = new javax.swing.JLabel();
       newPwdTxtField = new javax.swing.JPasswordField();
       jLabel2 = new javax.swing.JLabel();
       confirmPwdTxtField = new javax.swing.JPasswordField();
       jLabel3 = new javax.swing.JLabel();
       jButton2 = ViewManager.createGoHomeButton();

       setPreferredSize(new java.awt.Dimension(800, 610));

       jButton1.setText("OK");
       jButton1.addActionListener(new java.awt.event.ActionListener() {
           public void actionPerformed(java.awt.event.ActionEvent evt) {
               okBtnActionPerformed(evt);
           }
       });

       oldPwdTxtField.setText("");

       jLabel1.setText("Original Password:");

       newPwdTxtField.setText("");

       jLabel2.setText("New Password:");

       confirmPwdTxtField.setText("");

       jLabel3.setText("Confirm New Password:");

      

       javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
       this.setLayout(layout);
       layout.setHorizontalGroup(
           layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
           .addGroup(layout.createSequentialGroup()
               .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                   .addGroup(layout.createSequentialGroup()
                       .addGap(203, 203, 203)
                       .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                           .addComponent(jLabel2)
                           .addGroup(layout.createSequentialGroup()
                               .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                   .addComponent(jLabel3)
                                   .addComponent(jLabel1))
                               .addGap(40, 40, 40)
                               .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                   .addComponent(newPwdTxtField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE)
                                   .addComponent(oldPwdTxtField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                                   .addComponent(confirmPwdTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)))))
                   .addGroup(layout.createSequentialGroup()
                       .addGap(361, 361, 361)
                       .addComponent(jButton1)))
               .addContainerGap(314, Short.MAX_VALUE))
           .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
               .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
       );
       layout.setVerticalGroup(
           layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
           .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
               .addContainerGap()
               .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
               .addGap(96, 96, 96)
               .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                   .addComponent(jLabel1)
                   .addComponent(oldPwdTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
               .addGap(18, 18, 18)
               .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                   .addComponent(newPwdTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                   .addComponent(jLabel2))
               .addGap(18, 18, 18)
               .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                   .addComponent(confirmPwdTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                   .addComponent(jLabel3))
               .addGap(18, 18, 18)
               .addComponent(jButton1)
               .addContainerGap(399, Short.MAX_VALUE))
       );
   }                   
                                       
   /**
 * Method name: okBtnActionPerformed <BR>
 * Description: OK Button ActionPerformed <BR>
 * Remark: <BR>
 * @param evt  void<BR>
 */
   @SuppressWarnings("deprecation")
   private void okBtnActionPerformed(java.awt.event.ActionEvent evt) {                                         
   	this.clearAllTxtError();
   	if(!storeKeeperService.userLogin(Session.getSession("UserName"), oldPwdTxtField.getText())){
   		JOptionPane.showMessageDialog(null, "Old Password Error.", "Error", JOptionPane.ERROR_MESSAGE);
   		ViewUtil.setJTextError(oldPwdTxtField);
   		return;
   	}
   	if(!newPwdTxtField.getText().equals(confirmPwdTxtField.getText())){
   		JOptionPane.showMessageDialog(null, "The Password Not Equal.", "Error", JOptionPane.ERROR_MESSAGE);
   		ViewUtil.setJTextError(newPwdTxtField);
   		ViewUtil.setJTextError(confirmPwdTxtField);
   		return;
   	}
   	
   	if(!storeKeeperService.updatePassword(Session.getSession("UserName"), oldPwdTxtField.getText(), newPwdTxtField.getText())){
   		JOptionPane.showMessageDialog(null, "Something Error.", "Error", JOptionPane.ERROR_MESSAGE);
   	}else{
   		JOptionPane.showMessageDialog(null, "Modify Successful.", "Success", JOptionPane.OK_OPTION);
   		this.clearAllTxt();
   		ViewManager.goToHomePanel();
   		return;
   	}
   
   }                
   
   /**
 * Method name: clearAllTxtError <BR>
 * Description: Clear All Text Error <BR>
 * Remark: <BR>  void<BR>
 */
   private void clearAllTxtError(){
   	ViewUtil.clearJTextError(confirmPwdTxtField);
   	ViewUtil.clearJTextError(newPwdTxtField);
   	ViewUtil.clearJTextError(oldPwdTxtField);
   }
   
   /**
 * Method name: clearAllTxt <BR>
 * Description: Clear All TextField <BR>
 * Remark: <BR>  void<BR>
 */
   private void clearAllTxt(){
   	confirmPwdTxtField.setText("");
   	newPwdTxtField.setText("");
   	oldPwdTxtField.setText("");
   }

   private javax.swing.JButton jButton1;
   private javax.swing.JButton jButton2;
   private javax.swing.JLabel jLabel1;
   private javax.swing.JLabel jLabel2;
   private javax.swing.JLabel jLabel3;
   private javax.swing.JPasswordField oldPwdTxtField;
   private javax.swing.JPasswordField newPwdTxtField;
   private javax.swing.JPasswordField confirmPwdTxtField;
   // End of variables declaration                   
}
