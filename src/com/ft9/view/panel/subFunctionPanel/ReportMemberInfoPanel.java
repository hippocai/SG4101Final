package com.ft9.view.panel.subFunctionPanel;


import javax.swing.table.DefaultTableModel;

import com.ft9.service.IMemberService;
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
 * class name:ReportMemberInfoPanel <BR>
 * class description: Report Member Information Panel <BR>
 * Remark: <BR>
 * @version 1.00
 * @author Guo Qi
 */
public class ReportMemberInfoPanel extends javax.swing.JPanel {

   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	IMemberService memberService = null;
/**
    * Creates new form ReportMemberInfoPanel
 * @throws ServiceNotFoundException 
    */
   public ReportMemberInfoPanel() throws ServiceNotFoundException {
	   memberService = (MemberService) ServiceManager.getService("Member");
	   initComponents();
       initDatas();
      
   }
   private void initComponents() {

       jScrollPane1 = new javax.swing.JScrollPane();
       jTable1 = ViewUtil.createUneditableTable();
       jButtonPrint = ViewManager.createPrintButton();
       jButtonBack = ViewManager.createGoBackButton();

       jScrollPane1.setViewportView(jTable1);

       javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
       this.setLayout(layout);
       layout.setHorizontalGroup(
           layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
           .addGroup(layout.createSequentialGroup()
               .addGap(167, 167, 167)
               .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
               .addContainerGap(133, Short.MAX_VALUE))
           .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
               .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
               .addComponent(jButtonPrint, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
               .addGap(34, 34, 34)
               .addComponent(jButtonBack, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
               .addGap(86, 86, 86))
       );
       layout.setVerticalGroup(
           layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
           .addGroup(layout.createSequentialGroup()
               .addGap(62, 62, 62)
               .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
               .addGap(38, 38, 38)
               .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                   .addComponent(jButtonPrint, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                   .addComponent(jButtonBack, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
               .addContainerGap(42, Short.MAX_VALUE))
       );
   }                       


   public void initDatas(){
	  DefaultTableModel dft=ViewUtil.transferBeanList2DefaultTableModel(memberService.getAllMemberInfo(), "Member"); 
	  jTable1.setModel(dft);
   }
   
   private javax.swing.JButton jButtonPrint;
   private javax.swing.JButton jButtonBack;
   private javax.swing.JScrollPane jScrollPane1;
   private javax.swing.JTable jTable1;
}
