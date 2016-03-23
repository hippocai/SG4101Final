package com.ft9.view.panel.subFunctionPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import com.ft9.bean.MemberBean;
import com.ft9.service.ServiceManager;
import com.ft9.service.ServiceNotFoundException;
import com.ft9.service.impl.MemberService;
import com.ft9.util.ViewUtil;
import com.ft9.view.ViewManager;

/**
*
* @author apple
*/
public class AddMemberPanel extends javax.swing.JPanel {

   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final int ADD_NEW_MEMBER = 0x01;
	public static final int UPDATE_NEW_MEMBER = 0x02;
	
	private int type = ADD_NEW_MEMBER;
	private MemberBean memberBean = null;
	private MemberService memberService = null;
	
	/**
    * Creates new form AddMemberPanel
	 * @throws ServiceNotFoundException 
    */
   public AddMemberPanel() throws ServiceNotFoundException {
       initComponents();
       this.clearAllTextArea();
       memberService = (MemberService) ServiceManager.getService("Member");
   }
   
   public AddMemberPanel(MemberBean _memberBean, int _type) throws ServiceNotFoundException{
	   initComponents();
	   this.clearAllTextArea();
	   memberService = (MemberService) ServiceManager.getService("Member");
	   this.memberBean = _memberBean;
	   this.type = _type;
	   this.setData();
	   if (type == AddMemberPanel.UPDATE_NEW_MEMBER){
		   jButton3.setText("Modify");
	   }
   }
   private void setData() {
	// TODO Auto-generated method stub
	    	if(memberBean==null){
	    		return;
	    	}
	    	if(memberBean.getId()!=null){
	    		jTextField1.setText(memberBean.getId());;
	    	}
	    	if(memberBean.getName()!=null){
	    		jTextField2.setText(memberBean.getName());
	    	}
	    	if(memberBean.getLoyaltyPoint()!=null){
	            jTextField3.setText(memberBean.getLoyaltyPoint());
	    	}
	    	jTextField1.setEnabled(false);
	    }
   
	

//
//private void clearAllTxtArea() {
//	// TODO Auto-generated method stub
//	
//}

/**
    * This method is called from within the constructor to initialize the form.
    * WARNING: Do NOT modify this code. The content of this method is always
    * regenerated by the Form Editor.
    */
   @SuppressWarnings("unchecked")
   // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
   private void initComponents() {

       jButton1 = ViewManager.createGoBackButton();
       jButton2 = ViewManager.createGoHomeButton();
       jSeparator1 = new javax.swing.JSeparator();
       jTextField1 = new javax.swing.JTextField();
       jTextField2 = new javax.swing.JTextField();
       jTextField3 = new javax.swing.JTextField();
       jLabel1 = new javax.swing.JLabel();
       jLabel2 = new javax.swing.JLabel();
       jLabel3 = new javax.swing.JLabel();
       jButton3 = new javax.swing.JButton();
       jButton4 = new javax.swing.JButton();

       jButton1.setText("jButton1");

       jButton2.setText("jButton2");

       jTextField1.setText("jTextField1");

       jTextField2.setText("jTextField2");

       jTextField3.setText("jTextField3");

       jLabel1.setText("Member ID");

       jLabel2.setText("Member Name");

       jLabel3.setText("Loyalty No.");

       jButton3.setText("Add");
       
       jButton3.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			submitExcu();
		}


	});

       jButton4.setText("Clear");
       
       jButton4.addActionListener(new java.awt.event.ActionListener() {
           public void actionPerformed(java.awt.event.ActionEvent evt) {
              clearAllTextArea();
           }

       });

       javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
       this.setLayout(layout);
       layout.setHorizontalGroup(
           layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
           .addComponent(jSeparator1)
           .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
               .addContainerGap(240, Short.MAX_VALUE)
               .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                   .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                       .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                       .addGap(18, 18, 18)
                       .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                       .addGap(18, 18, 18))
                   .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                       .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                           .addGroup(layout.createSequentialGroup()
                               .addComponent(jButton3)
                               .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                               .addComponent(jButton4))
                           .addGroup(layout.createSequentialGroup()
                               .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                   .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                   .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                   .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                               .addGap(36, 36, 36)
                               .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                   .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                   .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                   .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))))
                       .addGap(220, 220, 220))))
       );
       layout.setVerticalGroup(
           layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
           .addGroup(layout.createSequentialGroup()
               .addContainerGap()
               .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                   .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                   .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
               .addGap(31, 31, 31)
               .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
               .addGap(56, 56, 56)
               .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                   .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                   .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE))
               .addGap(26, 26, 26)
               .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                   .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                   .addComponent(jTextField2, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE))
               .addGap(30, 30, 30)
               .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                   .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                   .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
               .addGap(92, 92, 92)
               .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                   .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                   .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
               .addGap(153, 153, 153))
       );
   }// </editor-fold>                        

   	private void clearAllTextAreaError(){
   		ViewUtil.clearJTextError(jTextField1);
   		ViewUtil.clearJTextError(jTextField2);
   		ViewUtil.clearJTextError(jTextField3);
   	}
   	
   	private boolean checkIfAllTxtFullfilled(){
   		if (ViewUtil.isJTextEmpty(jTextField1)){
   			ViewUtil.setJTextError(jTextField1);
   			return false;
   		}else if(ViewUtil.isJTextEmpty(jTextField2)){
   			ViewUtil.setJTextError(jTextField2);
   			return false;
   		}else if (ViewUtil.isJTextEmpty(jTextField3)){
   			ViewUtil.setJTextError(jTextField3);
   			return false;
   		}
   		return true;
   	}
   	
	private void clearAllTextArea() {
		// TODO Auto-generated method stub
		if (type == ADD_NEW_MEMBER){
			jTextField1.setText("");
		}
		jTextField2.setText("");
		jTextField3.setText("");
		this.clearAllTextAreaError();
	}

   // Variables declaration - do not modify                     
   private javax.swing.JButton jButton1;
   private javax.swing.JButton jButton2;
   private javax.swing.JButton jButton3;
   private javax.swing.JButton jButton4;
   private javax.swing.JLabel jLabel1;
   private javax.swing.JLabel jLabel2;
   private javax.swing.JLabel jLabel3;
   private javax.swing.JSeparator jSeparator1;
   private javax.swing.JTextField jTextField1;
   private javax.swing.JTextField jTextField2;
   private javax.swing.JTextField jTextField3;
   // End of variables declaration  
   
   
	private void submitExcu() {
		// TODO Auto-generated method stub
		this.clearAllTextAreaError();
		this.memberBean = this.generateDataBean();
		if (memberBean == null){
			return;
		}
		if (type == AddMemberPanel.ADD_NEW_MEMBER){
			if(memberService.isCodeExist(jTextField1.getText())){
				JOptionPane.showMessageDialog(null, "This Member Already Exist!", "ERROR", JOptionPane.ERROR_MESSAGE);
				ViewUtil.setJTextError(jTextField1);
				return;
			}
			if (memberService.addNewMember(memberBean)){
				JOptionPane.showMessageDialog(null, "Your Information Added Successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
			//add else functions
			}
		}
		else {
			if (memberService.updateMember(memberBean)){
				JOptionPane.showMessageDialog(null, "Your Information updated Successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
				ViewManager.goBack();
				//add else functions
			}
		}
		
	}
	
	private MemberBean generateDataBean(){
		if (!checkIfAllTxtFullfilled()){
			JOptionPane.showMessageDialog(null, "Every column can't be null", "Error", JOptionPane.ERROR_MESSAGE);
		    return null;
		}else{
			if(type == ADD_NEW_MEMBER && memberService.isCodeExist(jTextField1.getText())){
				ViewUtil.setJTextError(jTextField1);
				JOptionPane.showMessageDialog(null, "The Discount Code Has Already Existed", "Error", JOptionPane.ERROR_MESSAGE);
				return null;
			}
		}
		MemberBean memberBean = new MemberBean();
		memberBean.setId(this.jTextField1.getText());
		memberBean.setName(this.jTextField2.getText());
		memberBean.setLoyaltyPoint(this.jTextField3.getText());
		return memberBean;
	}
	
	
	
}





















