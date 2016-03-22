package com.ft9.view.panel;

import com.ft9.annotation.Menu;

/**
 *
 * @author apple
 */
@Menu(name = "Member", fatherName = "Manage")

public class ManageMemberPanel extends javax.swing.JPanel {

   /**
	 * 
	 */
	private static final long serialVersionUID = 8337890588741936219L;
/**
    * Creates new form ManageMemberPanel
    */
   public ManageMemberPanel() {
       initComponents();
   }

   /**
    * This method is called from within the constructor to initialize the form.
    * WARNING: Do NOT modify this code. The content of this method is always
    * regenerated by the Form Editor.
    */
   @SuppressWarnings("unchecked")
   // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
   private void initComponents() {

       button3 = new java.awt.Button();
       button4 = new java.awt.Button();
       button5 = new java.awt.Button();
       button6 = new java.awt.Button();
       jScrollPane2 = new javax.swing.JScrollPane();
       jTable2 = new javax.swing.JTable();
       button1 = new java.awt.Button();
       button2 = new java.awt.Button();

       button3.setLabel("button3");
       button3.addActionListener(new java.awt.event.ActionListener() {
           public void actionPerformed(java.awt.event.ActionEvent evt) {
               button3ActionPerformed(evt);
           }
       });

       button4.setLabel("button4");

       button5.setLabel("button5");

       button6.setLabel("button6");

       jTable2.setModel(new javax.swing.table.DefaultTableModel(
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
       jScrollPane2.setViewportView(jTable2);

       button1.setActionCommand("Return to main menu");
       button1.setLabel("MainMenu");
       button1.setName(""); // NOI18N
       button1.addActionListener(new java.awt.event.ActionListener() {
           public void actionPerformed(java.awt.event.ActionEvent evt) {
               button1ActionPerformed(evt);
           }
       });

       button2.setLabel("Back");

       javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
       this.setLayout(layout);
       layout.setHorizontalGroup(
           layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
           .addGroup(layout.createSequentialGroup()
               .addGap(68, 68, 68)
               .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                   .addGroup(layout.createSequentialGroup()
                       .addGap(520, 520, 520)
                       .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                       .addGap(29, 29, 29)
                       .addComponent(button2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                       .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                   .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 678, javax.swing.GroupLayout.PREFERRED_SIZE)
                   .addGroup(layout.createSequentialGroup()
                       .addGap(55, 55, 55)
                       .addComponent(button3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                       .addGap(115, 115, 115)
                       .addComponent(button4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                       .addGap(110, 110, 110)
                       .addComponent(button5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                       .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                       .addComponent(button6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                       .addGap(61, 61, 61)))
               .addGap(54, 54, 54))
       );
       layout.setVerticalGroup(
           layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
           .addGroup(layout.createSequentialGroup()
               .addGap(29, 29, 29)
               .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                   .addComponent(button3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                   .addComponent(button4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                   .addComponent(button5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                   .addComponent(button6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
               .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
               .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 479, Short.MAX_VALUE)
               .addGap(30, 30, 30)
               .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                   .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                   .addComponent(button2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
               .addContainerGap())
       );
   }// </editor-fold>                        

   private void button3ActionPerformed(java.awt.event.ActionEvent evt) {                                        
       // TODO add your handling code here:
   }                                       

   private void button1ActionPerformed(java.awt.event.ActionEvent evt) {                                        
       // TODO add your handling code here:
   }                                       


   // Variables declaration - do not modify                     
   private java.awt.Button button1;
   private java.awt.Button button2;
   private java.awt.Button button3;
   private java.awt.Button button4;
   private java.awt.Button button5;
   private java.awt.Button button6;
   private javax.swing.JScrollPane jScrollPane2;
   private javax.swing.JTable jTable2;
   // End of variables declaration                   
}