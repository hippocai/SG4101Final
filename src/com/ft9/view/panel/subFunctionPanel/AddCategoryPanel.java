package com.ft9.view.panel.subFunctionPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import com.ft9.bean.CategoryBean;
import com.ft9.service.ICategoryService;
import com.ft9.service.ServiceManager;
import com.ft9.service.ServiceNotFoundException;
import com.ft9.service.impl.CategoryService;
import com.ft9.util.ViewUtil;
import com.ft9.view.ViewManager;


/**
 * class name:AddCategoryPanel <BR>
 * class description: Category Addition Panel <BR>
 * Remark: <BR>
 * @version 1.00
 * @author Guo Qi
 */
public class AddCategoryPanel extends javax.swing.JPanel implements ActionListener {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2986216337832363954L;
	private ICategoryService categoryService=null;
   /**
    * Creates new form AddCategoryPanel
 * @throws ServiceNotFoundException 
    */
   public AddCategoryPanel() throws ServiceNotFoundException {
	   categoryService=(CategoryService)ServiceManager.getService("Category");
       initComponents();
   }

   /**
 * Method name: initComponents <BR>
 * Description: Init Components In AddCategoryPanel <BR>
 * Remark: <BR>  void<BR>
 */
private void initComponents() {
	   
       goBackBtn = ViewManager.createGoBackButton();
       goHomeBtn = ViewManager.createGoHomeButton();
       jLabel1 = new javax.swing.JLabel();
       codeTxtArea = new javax.swing.JTextField();
       nameTxtField = new javax.swing.JTextField();
       jLabel2 = new javax.swing.JLabel();
       submitBtn = new javax.swing.JButton();
       clearBtn = new javax.swing.JButton();


       jLabel1.setText("Code(3 Letters):");

       jLabel2.setText("Name:");

       submitBtn.setText("Submit");
       submitBtn.addActionListener(this);
       clearBtn.setText("Clear");
       clearBtn.addActionListener(this);

       javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
       this.setLayout(layout);
       layout.setHorizontalGroup(
           layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
           .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
               .addContainerGap(268, Short.MAX_VALUE)
               .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                   .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                       .addComponent(goBackBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                       .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                       .addComponent(goHomeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                       .addGap(19, 19, 19))
                   .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                       .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                           .addGroup(layout.createSequentialGroup()
                               .addComponent(submitBtn)
                               .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                               .addComponent(clearBtn))
                           .addGroup(layout.createSequentialGroup()
                               .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                   .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                   .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                               .addGap(18, 18, 18)
                               .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                   .addComponent(nameTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                   .addComponent(codeTxtArea, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))))
                       .addGap(316, 316, 316))))
       );
       layout.setVerticalGroup(
           layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
           .addGroup(layout.createSequentialGroup()
               .addContainerGap()
               .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                   .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                       .addComponent(codeTxtArea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                       .addComponent(jLabel1))
                   .addGroup(layout.createSequentialGroup()
                       .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                           .addComponent(goHomeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                           .addComponent(goBackBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                       .addGap(146, 146, 146)))
               .addGap(18, 18, 18)
               .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                   .addComponent(nameTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                   .addComponent(jLabel2))
               .addGap(43, 43, 43)
               .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                   .addComponent(clearBtn)
                   .addComponent(submitBtn))
               .addContainerGap(306, Short.MAX_VALUE))
       );
   }                   


   /**
 * Method name: clearAllTextArea <BR>
 * Description: Clear All TextFields <BR>
 * Remark: <BR>  void<BR>
 */
private void clearAllTextArea() {                                         
	   codeTxtArea.setText("");
	   nameTxtField.setText("");
       this.clearAllTextError();
       
   }      
   
   
   /**
 * Method name: generateDataBean <BR>
 * Description: Check All TextFields And Get Inputs <BR>
 * Remark: <BR>
 * @return  CategoryBean<BR>
 */
private CategoryBean generateDataBean(){
   	if(!checkIfAllTxtFulfilled()){
   		JOptionPane.showMessageDialog(null, "Every column can't be null", "Error", JOptionPane.ERROR_MESSAGE);
   		return null;
   	}else{
   		if(!categoryService.checkIfCategoryCodeExisted(codeTxtArea.getText())){
   			ViewUtil.setJTextError(codeTxtArea);
   			JOptionPane.showMessageDialog(null, "The Category Code Has Already Existed", "Error", JOptionPane.ERROR_MESSAGE);
   			return null;
   		}else{
   			if(codeTxtArea.getText().length() != 3){
   			ViewUtil.setJTextError(codeTxtArea);
   			JOptionPane.showMessageDialog(null, "The Category Code Need To Be 3 Characters!", "Error", JOptionPane.ERROR_MESSAGE);
   			return null;
   			}
   		}
   	}
    CategoryBean categoryBean=new CategoryBean();
    categoryBean.setCode(codeTxtArea.getText());
    categoryBean.setName(nameTxtField.getText());
   	return categoryBean;
   }
   
   /**
 * Method name: submitExec <BR>
 * Description: Submit Execute <BR>
 * Remark: <BR>  void<BR>
 */
public void submitExec(){
   	this.clearAllTextError();
   	CategoryBean categoryBean=this.generateDataBean();
   	if(categoryBean==null){
   		return;
   	}
   	if(categoryService.addCategoryByBean(categoryBean)){
   		JOptionPane.showMessageDialog(null, "Your Information Added Successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
   	}else{
   		JOptionPane.showMessageDialog(null, "OOPs,Something was wrong!", "Error", JOptionPane.ERROR_MESSAGE);
   	}
   	
   	}
   	
    /**
     * Method name: checkIfAllTxtFulfilled <BR>
     * Description: Check If All Text Fulfilled <BR>
     * Remark: <BR>
     * @return  boolean<BR>
     */
    private boolean checkIfAllTxtFulfilled(){
    	
    	if(ViewUtil.isJTextEmpty(codeTxtArea)){
    		ViewUtil.setJTextError(codeTxtArea);
    		return false;
    	}else if(ViewUtil.isJTextEmpty(nameTxtField)){
    		ViewUtil.setJTextError(nameTxtField);
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
    	ViewUtil.clearJTextError(codeTxtArea);
    	ViewUtil.clearJTextError(nameTxtField);
    	
    }

   private javax.swing.JButton goHomeBtn;
   private javax.swing.JButton goBackBtn;
   private javax.swing.JButton submitBtn;
   private javax.swing.JButton clearBtn;
   private javax.swing.JLabel jLabel1;
   private javax.swing.JLabel jLabel2;
   private javax.swing.JTextField codeTxtArea;
   private javax.swing.JTextField nameTxtField;
   // End of variables declaration       
   
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
	if(arg0.getSource()==submitBtn){
		submitExec();
	}else if(arg0.getSource()==clearBtn){
		clearAllTextArea();
	}
	
}
}
