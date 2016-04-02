package com.ft9.view.panel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.ft9.annotation.Menu;
import com.ft9.view.ViewManager;
import com.ft9.view.panel.subFunctionPanel.ReportTransactionPanel;
import com.ft9.service.ServiceNotFoundException;
import com.ft9.view.panel.subFunctionPanel.ReportCategoryPanel;
import com.ft9.view.panel.subFunctionPanel.ReportMemberInfoPanel;
import com.ft9.view.panel.subFunctionPanel.ReportProductInfoPanel;
import com.icon.IconManager;

/**
 *
 * @author apple
 */

/**
 * class name:PrintReportPanel <BR>
 * class description: Print Report Panel <BR>
 * Remark: <BR>
 * @version 1.00
 * @author Guo Qi
 */

//Set The JTree Name
@Menu(name = "Report", fatherName = "Print")
public class PrintReportPanel extends javax.swing.JPanel {

    /**  
	 * define a field serialVersionUID which type is long
	 */
	private static final long serialVersionUID = 1L;
	/**
     * Creates new form PrintReportPanel
     */
    public PrintReportPanel() {
        initComponents();
    }
    
    /**
     * Method name: initComponents <BR>
     * Description: Init Components In PrintReport Panel <BR>
     * Remark: <BR>  void<BR>
     */
    private void initComponents() {

        goHomeBtn = ViewManager.createGoHomeButton();
        categoriesBtn = new javax.swing.JButton();
        availableProductBtn = new javax.swing.JButton();
        transactionBtn = new javax.swing.JButton();
        memberBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        categoriesBtn.setIcon(IconManager.getIcon("categoryInfo"));
        availableProductBtn.setIcon(IconManager.getIcon("productInfo"));
        transactionBtn.setIcon(IconManager.getIcon("transactionInfo"));
        memberBtn.setIcon(IconManager.getIcon("memberInfo"));
        categoriesBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					ViewManager.goToSubFunctionScreen(new ReportCategoryPanel());
				} catch (ServiceNotFoundException e) {
					e.printStackTrace();
				}
			}
		});
       
        availableProductBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					ViewManager.goToSubFunctionScreen(new ReportProductInfoPanel());
				} catch (ServiceNotFoundException e1) {
					e1.printStackTrace();
				}
			}
		});
        
        transactionBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ViewManager.goToSubFunctionScreen(new ReportTransactionPanel());
			}
		});
        
        memberBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					ViewManager.goToSubFunctionScreen(new ReportMemberInfoPanel());
				} catch (ServiceNotFoundException e1) {
					e1.printStackTrace();
				}
				
			}
		});

        jLabel1.setFont(new java.awt.Font("Arial", 0, 14));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Categories & Categories ID");

        jLabel2.setFont(new java.awt.Font("Arial", 0, 14)); 
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Available Product Info");

        jLabel3.setFont(new java.awt.Font("Arial", 0, 14)); 
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Transactions");

        jLabel4.setFont(new java.awt.Font("Arial", 0, 14)); 
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Members Info");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(goHomeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(20,20,20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
                        .addGap(286, 286, 286)
                        )
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(categoriesBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(transactionBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(availableProductBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(memberBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(133, 133, 133))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(goHomeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(availableProductBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(categoriesBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 67, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(transactionBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(memberBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addGap(50, 50, 50))
        );
    }                       
                                  
    private javax.swing.JButton goHomeBtn;
    private javax.swing.JButton categoriesBtn;
    private javax.swing.JButton availableProductBtn;
    private javax.swing.JButton transactionBtn;
    private javax.swing.JButton memberBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    // End of variables declaration                   
}


