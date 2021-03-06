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
/**
 * class name:AddMemberPanel <BR>
 * class description: Add Member Panel <BR>
 * Remark: <BR>
 * @version 1.00
 * @author Guo Qi
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
	   this.clearAllTxtArea();
	   memberService = (MemberService) ServiceManager.getService("Member");
	   this.memberBean = _memberBean;
	   this.type = _type;
	   this.setData();
	   if (type == AddMemberPanel.UPDATE_NEW_MEMBER){
		   jButton3.setText("Modify");
	   }
   }
   /**
 * Method name: setData <BR>
 * Description: Set Textfield <BR>
 * Remark: <BR>  void<BR>
 */
private void setData() {
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
   
	


private void clearAllTxtArea() {
	
}

   /**
 * Method name: initComponents <BR>
 * Description: Init Components <BR>
 * Remark: <BR>  void<BR>
 */
private void initComponents() {

       jButton1 = ViewManager.createGoBackButton();
       jButton2 = ViewManager.createGoHomeButton();
       jTextField1 = new javax.swing.JTextField();
       jTextField2 = new javax.swing.JTextField();
       jTextField3 = new javax.swing.JTextField();
       jLabel1 = new javax.swing.JLabel();
       jLabel2 = new javax.swing.JLabel();
       jLabel3 = new javax.swing.JLabel();
       jButton3 = new javax.swing.JButton();
       jButton4 = new javax.swing.JButton();

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
   }                      

   	/**
   	 * Method name: checkTxtNumberical <BR>
   	 * Description: Check Text Is Integer <BR>
   	 * Remark: <BR>
   	 * @return  boolean<BR>
   	 */
   	private boolean checkTxtNumberical(){
   		if (!ViewUtil.isJTextNumberical(jTextField3)){
   			ViewUtil.setJTextError(jTextField3);
   			return false;
   		}
   		return true;
   	}
   
   	/**
   	 * Method name: clearAllTextAreaError <BR>
   	 * Description: Clear All Text Area Error <BR>
   	 * Remark: <BR>  void<BR>
   	 */
   	private void clearAllTextAreaError(){
   		ViewUtil.clearJTextError(jTextField1);
   		ViewUtil.clearJTextError(jTextField2);
   		ViewUtil.clearJTextError(jTextField3);
   	}
   	
   	/**
   	 * Method name: checkIfAllTxtFullfilled <BR>
   	 * Description: Check If All Text Fullfilled <BR>
   	 * Remark: <BR>
   	 * @return  boolean<BR>
   	 */
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
   	
	/**
	 * Method name: clearAllTextArea <BR>
	 * Description: Clear All TextArea <BR>
	 * Remark: <BR>  void<BR>
	 */
	private void clearAllTextArea() {
		if (type == ADD_NEW_MEMBER){
			jTextField1.setText("");
			jTextField3.setText("-1");
		}else{
			jTextField3.setText("");
		}
		jTextField2.setText("");
		
		this.clearAllTextAreaError();
	}

    /**
     * Method name: checkTxtContentsValid <BR>
     * Description: Check Text Contents Contains Comma <BR>
     * Remark: <BR>
     * @return  boolean<BR>
     */
    private  boolean checkTxtContentsValid(){
    	if(jTextField1.getText().contains(",")){
    		ViewUtil.setJTextError(jTextField1);
    		return false;
    	}
    	if(jTextField2.getText().contains(",")){
    		ViewUtil.setJTextError(jTextField2);
    		return false;
    	}
    	if(jTextField3.getText().contains(",")){
    		ViewUtil.setJTextError(jTextField3);
    		return false;
    	}
    	return true;
    }
    
   private javax.swing.JButton jButton1;
   private javax.swing.JButton jButton2;
   private javax.swing.JButton jButton3;
   private javax.swing.JButton jButton4;
   private javax.swing.JLabel jLabel1;
   private javax.swing.JLabel jLabel2;
   private javax.swing.JLabel jLabel3;
   private javax.swing.JTextField jTextField1;
   private javax.swing.JTextField jTextField2;
   private javax.swing.JTextField jTextField3;
   
   
	/**
	 * Method name: submitExcu <BR>
	 * Description: Submit Execute <BR>
	 * Remark: <BR>  void<BR>
	 */
	private void submitExcu() {
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
			}
		}
		else {
			if (memberService.updateMember(memberBean)){
				JOptionPane.showMessageDialog(null, "Your Information updated Successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
				ViewManager.goBack();
			}
		}
		
	}
	
	/**
	 * Method name: generateDataBean <BR>
	 * Description: Check Datas <BR>
	 * Remark: <BR>
	 * @return  MemberBean<BR>
	 */
	private MemberBean generateDataBean(){
		if (!checkIfAllTxtFullfilled()){
			JOptionPane.showInternalMessageDialog(null, "Every column can't be null", "Error", JOptionPane.ERROR_MESSAGE);
		    return null;
		}else{
			if(type == ADD_NEW_MEMBER && memberService.isCodeExist(jTextField1.getText())){
				ViewUtil.setJTextError(jTextField1);
				JOptionPane.showMessageDialog(null, "The Member Name Has Already Existed", "Error", JOptionPane.ERROR_MESSAGE);
				return null;
			}else{
				if(!checkTxtNumberical()){
					JOptionPane.showMessageDialog(null, "The Loyalty Number Must Be Integer!", "Error", JOptionPane.ERROR_MESSAGE);
					return null;
				}else{
					if(Integer.parseInt(jTextField3.getText()) < -1){
						ViewUtil.setJTextError(jTextField3);
						JOptionPane.showMessageDialog(null, "The Loyalty Number Can't Be Less Than -1!", "Error", JOptionPane.ERROR_MESSAGE);
						return null;
					}
				}
			}
			if(!this.checkTxtContentsValid()){
				JOptionPane.showMessageDialog(null, "The TextField Cannot Contain comma", "Error", JOptionPane.ERROR_MESSAGE);
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





















