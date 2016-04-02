package com.ft9.view.panel;

import com.ft9.annotation.Menu;
import com.ft9.view.ViewManager;

/**
 * class name:HelpPanel <BR>
 * class description: The Help Panel(Developers' Information) <BR>
 * Remark: <BR>
 * @version 1.00
 * @author Guo Qi
 */

//Define The Jtree Name
@Menu(name = "About Us", fatherName = "Help")
/**
*
* @author apple
*/
public class HelpPanel extends javax.swing.JPanel {

   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
/**
    * Creates new form HelpPanel
    */
   public HelpPanel() {
       initComponents();
   }

   /**
 * Method name: initComponents <BR>
 * Description: Init All The Information In This Panel <BR>
 * Remark: <BR>  void<BR>
 */
private void initComponents() {

       jLabel1 = new javax.swing.JLabel();
       jScrollPane1 = new javax.swing.JScrollPane();
       jTable1 = new javax.swing.JTable();
       //Create Go Home Button
       jButton1 = ViewManager.createGoHomeButton();

       jLabel1.setText("This Application Is Developed By FT Group 9");

       jTable1.setModel(new javax.swing.table.DefaultTableModel(
           new Object [][] {
               {"INDRONEEL MUKHERJEE", "A0150425R"},
               {"YICHENG CAI", "A0148553Y"},
               {"GUO QI", "A0150319M"},
               {"SIDDHARTH SAXENA", "A0148630H"},
               {"PRASAN SHETTY", "A0148397M"},

           },
           new String [] {
               "Name", "ID"
           }
       ));
       
       jScrollPane1.setViewportView(jTable1);
       javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
       this.setLayout(layout);
       layout.setHorizontalGroup(
           layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
           .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
               .addGap(0, 0, Short.MAX_VALUE)
               .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
               .addGap(45, 45, 45))
           .addGroup(layout.createSequentialGroup()
               .addGap(153, 153, 153)
               .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                   .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                   .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE))
               .addContainerGap(195, Short.MAX_VALUE))
       );
       layout.setVerticalGroup(
           layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
           .addGroup(layout.createSequentialGroup()
               .addContainerGap()
               .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
               .addGap(13, 13, 13)
               .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
               .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
               .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE)
               .addContainerGap(133, Short.MAX_VALUE))
       );
   }                     


   private javax.swing.JButton jButton1;
   private javax.swing.JLabel jLabel1;
   private javax.swing.JScrollPane jScrollPane1;
   private javax.swing.JTable jTable1;
}
