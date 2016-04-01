package com.ft9.view.panel.subFunctionPanel;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import com.ft9.service.IDiscountService;
import com.ft9.service.ServiceManager;
import com.ft9.service.ServiceNotFoundException;
import com.ft9.service.impl.DiscountService;
import com.ft9.util.ClientMainCalendar;
import com.ft9.util.TimeUtil;
import com.ft9.util.ViewUtil;
import com.ft9.view.ViewManager;
import com.ft9.view.panel.actionListener.GoBackListener;
import com.ft9.view.panel.actionListener.GoHomeListener;
import com.ft9.bean.*;
public class AddDiscountPanel extends javax.swing.JPanel {

    /**
	 * 
	 */
	private static final long serialVersionUID = 7459983321187070197L;
	public final static int ADD_NEW_DISCOUNT=0x01;
	public final static int MODIFY_DISCOUNT=0x02;
	
	private int type=ADD_NEW_DISCOUNT; 
	private DiscountBean discountBean=null;
	private IDiscountService discountService=null;
	/**
     * Creates new form AddDiscountPanel
	 * @throws ServiceNotFoundException 
     */
    public AddDiscountPanel() throws ServiceNotFoundException {
        initComponents();
        this.clearAllTextArea();
        discountService=(DiscountService)ServiceManager.getService("Discount");
    }
    
    public AddDiscountPanel(DiscountBean _discountBean,int _type) throws ServiceNotFoundException {
        initComponents();
        this.clearAllTextArea();
        discountService=(DiscountService)ServiceManager.getService("Discount");
        this.discountBean=_discountBean;
        this.type=_type;
        this.setDatas();
        if(_type==AddDiscountPanel.MODIFY_DISCOUNT){
        	submitBtn.setText("Modify");
        }
    }
    
    private void setDatas(){
    	if(discountBean==null){
    		return;
    	}
    	if(discountBean.getCode()!=null){
    		codeTxtField.setText(discountBean.getCode());;
    	}
    	if(discountBean.getDescription()!=null){
    		descTxtArea.setText(discountBean.getDescription());
    	}
    	if(discountBean.getDiscountPercentage()!=null){
            percentageTxtField.setText(discountBean.getDiscountPercentage());
    	}
    	if(discountBean.getDiscountPeriod()!=null){
    		periodTxtField.setText(discountBean.getDiscountPeriod());
    	}
    	if(discountBean.getStartDate()!=null){
    		startDateTxtField.setText(discountBean.getStartDate());
    	}
    	if(discountBean.getMemberApplicable()!=null){
    		if(discountBean.getMemberApplicable().equals("M")){
    			aplicableCombo.setSelectedItem("Member");
    		}else{
    			aplicableCombo.setSelectedItem("All");
    		}
    	}
    	codeTxtField.setEnabled(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")                      
    private void initComponents() {

        goHomeButton = ViewManager.createGoHomeButton();
        goBackButton = ViewManager.createGoBackButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        descTxtArea = new javax.swing.JTextArea();
        codeTxtField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        startDateTxtField = new javax.swing.JTextField();
        ClientMainCalendar calendar=ClientMainCalendar.getInstance();
        calendar.register(startDateTxtField);
        jSeparator1 = null;
        jLabel4 = new javax.swing.JLabel();
        periodTxtField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        percentageTxtField = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        aplicableCombo = new javax.swing.JComboBox<>();
        submitBtn = new javax.swing.JButton();
        clearBtn = new javax.swing.JButton();
        alwaysCheckBox=new JCheckBox();
        alwaysCheckBox.setText("Always");
        alwaysCheckBox.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
				// TODO 自动生成的方法存根
				if(alwaysCheckBox.isSelected()){
					startDateTxtField.setText("ALWAYS");
					periodTxtField.setText("ALWAYS");
					periodTxtField.setEnabled(false);
					startDateTxtField.setEnabled(false);
				}else{
					startDateTxtField.setText("");
					periodTxtField.setText("");
					periodTxtField.setEnabled(true);
					startDateTxtField.setEnabled(true);
				}
			}
		});
        jLabel1.setText("Discount Code:");

        jLabel2.setText("Description:");

        descTxtArea.setColumns(20);
        descTxtArea.setRows(5);
        jScrollPane2.setViewportView(descTxtArea);

        codeTxtField.setText("codeTxtField");

        jLabel3.setText("Start Date:");
        startDateTxtField.setText("codeTxtField");

        jLabel4.setText("Period:");

        periodTxtField.setText("codeTxtField");

        jLabel5.setText("Applicable:");

        percentageTxtField.setText("codeTxtField");

        jLabel6.setText("Percentage:");

        aplicableCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Member", "All" }));

        submitBtn.setText("Add");

        submitBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				submitExec();
			}
		});
        clearBtn.setText("Clear");
        
        clearBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
               clearAllTextArea();
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(goBackButton, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(goHomeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
           // .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addGap(162, 162, 162)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(67, 67, 67)
                        .addComponent(periodTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel5)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel6))
                            .addComponent(jLabel3))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                		
                                    .addComponent(startDateTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    
                                    .addComponent(codeTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                                   .addGap(17, 17, 17) .addComponent(alwaysCheckBox,100,100,100))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            		.addGap(17, 17, 17)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(aplicableCombo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(percentageTxtField, javax.swing.GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)))))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(submitBtn)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(clearBtn))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                           // .addGap(18, 18, 18)
                            
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE))))
                           //.addGap(18, 18, 18)
                            
                .addContainerGap(214, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(goHomeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(goBackButton, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
             //   .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(codeTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                		
                		.addComponent(startDateTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    
                    .addComponent(jLabel3)
                    .addComponent(alwaysCheckBox,30,30,30)
                    )
                   
                    
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(periodTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addGap(30, 30, 30)
                    .addComponent(jLabel4))
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(percentageTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(aplicableCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE,javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(submitBtn)
                    .addComponent(clearBtn))
                .addGap(92, 92, 92))
        );
    }// </editor-fold>                        
                                     

    private void clearAllTextArea() {                                         
        // TODO add your handling code here:
        descTxtArea.setText("");
        if(type==ADD_NEW_DISCOUNT){
        	codeTxtField.setText("");
        }
        
        startDateTxtField.setText("");
        periodTxtField.setText("");
        percentageTxtField.setText("");
        this.clearAllTextError();
        
    }      
    
    public void submitExec(){
    	this.clearAllTextError();
    	this.discountBean=this.generateDataBean();
    	if(discountBean==null){
    		return;
    	}
    	
    	if(this.type==AddDiscountPanel.ADD_NEW_DISCOUNT){
    		if(discountService.addNewDiscount(discountBean)){
        		JOptionPane.showMessageDialog(null, "Your Information Added Successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
        	}else{
        		//TODO:........
        	}
    	}else{
    		if(discountService.updateDiscount(discountBean)){
    			JOptionPane.showMessageDialog(null, "Your Information updated Successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
    			ViewManager.goBack();
    		}else{
    			//TODO....
    		}
    	}
    	
    	
    }
    
    private DiscountBean generateDataBean(){
    	if(!checkIfAllTxtFulfilled()){
    		JOptionPane.showMessageDialog(null, "Every column can't be null", "Error", JOptionPane.ERROR_MESSAGE);
    		return null;
    	}else if(!checkAllDataValid()){
    		JOptionPane.showMessageDialog(null, "The Data is not valid", "Error", JOptionPane.ERROR_MESSAGE);
    		return null;
    	}else{
    		if(type==ADD_NEW_DISCOUNT&&discountService.isCodeExist(codeTxtField.getText())){
    			ViewUtil.setJTextError(codeTxtField);
    			JOptionPane.showMessageDialog(null, "The Discount Code Has Already Existed", "Error", JOptionPane.ERROR_MESSAGE);
    			return null;
    		}
    	}
    	DiscountBean discountBean=new DiscountBean();
    	discountBean.setCode(this.codeTxtField.getText());
    	discountBean.setDescription(this.descTxtArea.getText());
    	discountBean.setDiscountPercentage(this.percentageTxtField.getText());
    	discountBean.setDiscountPeriod(this.periodTxtField.getText());
    	String applicable=null;
    	if(this.aplicableCombo.getSelectedItem().toString().equals("Member")){
    		applicable="M";
    	}else{
    		applicable="A";
    	}
    	
    	discountBean.setMemberApplicable(applicable);
    	discountBean.setStartDate(this.startDateTxtField.getText());
    	return discountBean;
    }
    
    private boolean checkAllDataValid(){
    	if(!ViewUtil.isJTextDecimal(percentageTxtField)){
    		ViewUtil.setJTextError(percentageTxtField);
    		return false;
    	}
    	
    	if(alwaysCheckBox.isSelected()){
    		return true;
    	}else{
    		if(!ViewUtil.isJTextNumberical(periodTxtField)){
    			ViewUtil.setJTextError(periodTxtField);
    			return false;
    		}
    		
    		if(!TimeUtil.checkIfDateFormatValid(startDateTxtField.getText())){
    			ViewUtil.setJTextError(startDateTxtField);
    			return false;
    		}
    	}
    	return true;
    }
    private boolean checkIfAllTxtFulfilled(){
    	
    	if(ViewUtil.isJTextEmpty(codeTxtField)){
    		ViewUtil.setJTextError(codeTxtField);
    		return false;
    	}else if(ViewUtil.isJTextEmpty(descTxtArea)){
    		ViewUtil.setJTextError(descTxtArea);
    		return false;
    	}else if(ViewUtil.isJTextEmpty(startDateTxtField)){
    		ViewUtil.setJTextError(startDateTxtField);
    		return false;
    	}else if(ViewUtil.isJTextEmpty(periodTxtField)){
    		ViewUtil.setJTextError(periodTxtField);
    		return false;
    	}else if(ViewUtil.isJTextEmpty(percentageTxtField)){
    		ViewUtil.setJTextError(percentageTxtField);
    		return false;
    	}
    	return true;
    }
    
    private void clearAllTextError(){
    	ViewUtil.clearJTextError(codeTxtField);
    	ViewUtil.clearJTextError(descTxtArea);
    	ViewUtil.clearJTextError(startDateTxtField);
    	ViewUtil.clearJTextError(periodTxtField);
    	ViewUtil.clearJTextError(percentageTxtField);
    }


    // Variables declaration - do not modify                     
    private javax.swing.JButton goHomeButton;
    private javax.swing.JButton goBackButton;
    private javax.swing.JButton submitBtn;
    private javax.swing.JButton clearBtn;
    private javax.swing.JComboBox<String> aplicableCombo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextArea descTxtArea;
    private javax.swing.JTextField codeTxtField;
    private javax.swing.JTextField startDateTxtField;
    private javax.swing.JTextField periodTxtField;
    private javax.swing.JTextField percentageTxtField;
    private JCheckBox alwaysCheckBox;
    // End of variables declaration                   
}
