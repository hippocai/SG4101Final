package com.ft9.view.frame;

import java.util.List;

import com.ft9.bean.CategoryBean;
import com.ft9.util.ViewUtil;

/**
*
* @author hippo
*/
public class ShowCategoriesFrame extends javax.swing.JFrame {

   /**  
	 * define a field serialVersionUID which type is long
	 */
	private static final long serialVersionUID = 1117858071577994409L;
/**
    * Creates new form ShowCategoriesFrame
    */
   public ShowCategoriesFrame(List<CategoryBean>categoryBeanList) {
       initComponents();
       this.setResizable(false);
       jTable1.setModel(ViewUtil.transferBeanList2DefaultTableModel(categoryBeanList,"Category"));
   }

   private void initComponents() {

       jScrollPane1 = new javax.swing.JScrollPane();
       jTable1 = new javax.swing.JTable();

       setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

       jTable1.setModel(new javax.swing.table.DefaultTableModel(
           new Object [][] {
               {null, null, null, null},
               {null, null, null, null},
               {null, null, null, null},
               {null, null, null, null}
           },
           new String [] {
               "Title 1", "Title 2", "Title 3", "Title 4"
           }
       ));
       jScrollPane1.setViewportView(jTable1);

       javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
       getContentPane().setLayout(layout);
       layout.setHorizontalGroup(
           layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
           .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
               .addContainerGap(15, Short.MAX_VALUE)
               .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
               .addContainerGap())
               .addGap(50)
       );
       layout.setVerticalGroup(
           layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
           .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
               .addContainerGap(15, Short.MAX_VALUE)
               .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
               .addContainerGap()).addGap(50)
       );

       pack();
   }                        

   private javax.swing.JScrollPane jScrollPane1;
   private javax.swing.JTable jTable1;
   // End of variables declaration                   
}
