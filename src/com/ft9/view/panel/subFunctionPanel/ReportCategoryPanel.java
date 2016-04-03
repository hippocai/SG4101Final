package com.ft9.view.panel.subFunctionPanel;


import com.ft9.service.ICategoryService;
import com.ft9.service.ServiceManager;
import com.ft9.service.ServiceNotFoundException;
import com.ft9.service.impl.CategoryService;
import com.ft9.util.ViewUtil;
import com.ft9.view.ViewManager;


/**
*
* @author apple
*/
/**
 * class name:ReportCategoryPanel <BR>
 * class description: Report Category Panel <BR>
 * Remark: <BR>
 * @version 1.00 
 * @author Guo Qi
 */
public class ReportCategoryPanel extends javax.swing.JPanel {

   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ICategoryService categoryService=null;
/**
    * Creates new form ReportCategoryPanel
 * @throws ServiceNotFoundException 
    */
   public ReportCategoryPanel() throws ServiceNotFoundException {
	   categoryService = (CategoryService) ServiceManager.getService("Category");
       initComponents();
       initDatas();
   }

   /**
 * Method name: initDatas <BR>
 * Description: Init Datas <BR>
 * Remark: <BR>  void<BR>
 */
   private void initDatas() {
	jTable1.setModel(ViewUtil.transferBeanList2DefaultTableModel(categoryService.getAllCategorys(), "Category"));
}

   /**
 * Method name: initComponents <BR>
 * Description: Init Components <BR>
 * Remark: <BR>  void<BR>
 */
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
               .addContainerGap(182, Short.MAX_VALUE)
               .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                   .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                       .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                       .addGap(166, 166, 166))
                   .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                       .addComponent(jButtonPrint, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                       .addGap(18, 18, 18)
                       .addComponent(jButtonBack, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                       .addGap(37, 37, 37))))
       );
       layout.setVerticalGroup(
           layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
           .addGroup(layout.createSequentialGroup()
               .addGap(62, 62, 62)
               .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
               .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
               .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                   .addComponent(jButtonPrint, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                   .addComponent(jButtonBack, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
               .addGap(34, 34, 34))
       );
   }                      


   private javax.swing.JButton jButtonPrint;
   private javax.swing.JButton jButtonBack;
   private javax.swing.JScrollPane jScrollPane1;
   private javax.swing.JTable jTable1;
   // End of variables declaration                   
}
