package com.ft9.view.frame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import com.ft9.bean.ProductBean;
import com.ft9.service.IProductService;
import com.ft9.service.ServiceManager;
import com.ft9.service.ServiceNotFoundException;
import com.ft9.service.impl.ProductService;
import com.ft9.view.ViewManager;


/**
 *
 * @author hippo
 */
public class ReplenishDiagram extends javax.swing.JFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = -434084484747154379L;
	IProductService productService=null;
	ProductBean productBean=null;
	/**
     * Creates new form ReplenishDiagram
	 * @throws ServiceNotFoundException 
     */
    public ReplenishDiagram(ProductBean productBean) throws ServiceNotFoundException {
    	productService=(ProductService)ServiceManager.getService("Product");
    	this.productBean=productBean;
        initComponents();
        setDatas();
    }

    private void setDatas(){
    	jTextField1.setText(productBean.getOrderQuantity());
    	jTextField1.setEnabled(false);;
    	defaultCheckBox.setSelected(true);
    	
    }
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        defaultCheckBox = new javax.swing.JCheckBox();
        okBtn = new javax.swing.JButton();
        cancelBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        this.setResizable(false);
        this.setLocationByPlatform(true);

        jLabel1.setText("Reorder Quantity:");

        defaultCheckBox.setText("Default");
        defaultCheckBox.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent arg0) {
				if(defaultCheckBox.isSelected()){
					setDatas();
				}else{
					jTextField1.setEnabled(true);;
				}
			}
		});

        okBtn.setText("OK");
        okBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				replenishExec();
			}
		});
        
        cancelBtn.setText("Cancel");
        cancelBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				
			}
		});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(okBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cancelBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE)
                    .addComponent(defaultCheckBox, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(68, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(76, 76, 76)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(defaultCheckBox))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(okBtn)
                    .addComponent(cancelBtn))
                .addGap(44, 44, 44))
        );

        pack();
    }                        
    
    private void replenishExec(){
    	String replenishNum=jTextField1.getText();
    	String quantity=productBean.getQuantityAvailable();
    	productBean.setQuantityAvailable((Integer.parseInt(quantity)+Integer.parseInt(replenishNum))+"");
    	productService.updateProductByBean(productBean);
    	ViewManager.callRefreshCurrentPanel();
    	dispose();
    }
                                       

    private javax.swing.JButton okBtn;
    private javax.swing.JButton cancelBtn;
    private javax.swing.JCheckBox defaultCheckBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration                   
}
