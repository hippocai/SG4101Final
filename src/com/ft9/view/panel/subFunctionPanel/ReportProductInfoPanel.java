package com.ft9.view.panel.subFunctionPanel;


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

/**
 * class name:ReportProductInfoPanel <BR>
 * class description: Report Product Panel <BR>
 * Remark: <BR>
 * @version 1.00
 * @author Guo Qi
 */
public class ReportProductInfoPanel extends javax.swing.JPanel {

	private static final long serialVersionUID = 1L;
	IProductService productService=null;
    public ReportProductInfoPanel() throws ServiceNotFoundException {
       productService=(ProductService)ServiceManager.getService("Product");
       
	   initComponents();
	   initDatas();
       
   }
   
   /**
 * Method name: initDatas <BR>
 * Description: Init Datas <BR>
 * Remark: <BR>  void<BR>
 */
    private void initDatas(){
	   jTable1.setModel(ViewUtil.transferBeanList2DefaultTableModel(productService.getAllProducts(), "Product"));;
   }

   /**
 * Method name: initComponents <BR>
 * Description: Init Components <BR>
 * Remark: <BR>  void<BR>
 */
    private void initComponents() {

       jScrollPane1 = new javax.swing.JScrollPane();
       jTable1 =ViewUtil.createUneditableTable();
       jButtonPrint = ViewManager.createPrintButton();
       jButtonBack = ViewManager.createGoBackButton();

       jScrollPane1.setViewportView(jTable1);



       javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
       this.setLayout(layout);
       layout.setHorizontalGroup(
           layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
           .addGroup(layout.createSequentialGroup()
               .addGap(129, 129, 129)
               .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 555, javax.swing.GroupLayout.PREFERRED_SIZE)
               .addContainerGap(116, Short.MAX_VALUE))
           .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
               .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
               .addComponent(jButtonPrint, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
               .addGap(31, 31, 31)
               .addComponent(jButtonBack, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
               .addGap(48, 48, 48))
       );
       layout.setVerticalGroup(
           layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
           .addGroup(layout.createSequentialGroup()
               .addGap(56, 56, 56)
               .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
               .addGap(42, 42, 42)
               .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                   .addComponent(jButtonPrint, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                   .addComponent(jButtonBack, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
               .addContainerGap(44, Short.MAX_VALUE))
       );
   }                       


   private javax.swing.JButton jButtonPrint;
   private javax.swing.JButton jButtonBack;
   private javax.swing.JScrollPane jScrollPane1;
   private javax.swing.JTable jTable1;
}
