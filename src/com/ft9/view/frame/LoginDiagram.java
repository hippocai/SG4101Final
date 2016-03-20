package com.ft9.view.frame;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JRootPane;

import org.apache.log4j.Logger;

import com.ft9.common.Session;
import com.ft9.dao.impl.BaseDao;
import com.ft9.service.IStoreKeeperService;
import com.ft9.service.ServiceManager;
import com.ft9.service.ServiceNotFoundException;
import com.ft9.service.impl.StoreKeeperService;

public class LoginDiagram extends javax.swing.JFrame implements ActionListener{
	private static Logger log = Logger.getLogger(LoginDiagram.class);
	private IStoreKeeperService storeKeeperService;
	private javax.swing.JButton jButton1;
	private javax.swing.JButton jButton2;
	private javax.swing.JDialog jDialog1;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JTextField jTextField1;
	private javax.swing.JTextField jTextField2;
	
	public static interface LoginSuccessfulEventListener{
		public void afterLoginSuccessful();
	}
	private LoginSuccessfulEventListener loginSuccessfulActionListener=null;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4451590344027162278L;
	public LoginDiagram() throws ServiceNotFoundException{
		storeKeeperService=(StoreKeeperService)ServiceManager.getService("StoreKeeper");
		initComponents();
		//setAlwaysOnTop(true);
		super.dispose();
		super.setUndecorated(true);
		//setFocusableWindowState(false);
		JRootPane rootPane = getRootPane();
		rootPane.setWindowDecorationStyle(JRootPane.FRAME);
		rootPane.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		rootPane.putClientProperty("Quaqua.RootPane.isVertical", Boolean.FALSE);
		//rootPane.putClientProperty("Quaqua.RootPane.isPalette", Boolean.TRUE);
	}
  
	private void initComponents() {
			log.info("Initialing Login Diagram...");
	        jDialog1 = new javax.swing.JDialog();
	        jButton1 = new javax.swing.JButton();
	        jTextField1 = new javax.swing.JTextField();
	        jLabel1 = new javax.swing.JLabel();
	        jTextField2 = new javax.swing.JPasswordField();
	        jLabel2 = new javax.swing.JLabel();
	        jButton2 = new javax.swing.JButton();
	        jButton1.addActionListener(this);
	        jButton2.addActionListener(this);
	        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
	        jDialog1.getContentPane().setLayout(jDialog1Layout);
	        jDialog1Layout.setHorizontalGroup(
	            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGap(0, 400, Short.MAX_VALUE)
	        );
	        jDialog1Layout.setVerticalGroup(
	            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGap(0, 300, Short.MAX_VALUE)
	        );

	        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

	        jButton1.setText("Confirm");

	        jTextField1.setText("");

	        jLabel1.setText("UserName");

	        jTextField2.setText("");
	        
	        jLabel2.setText("Password");

	        jButton2.setText("Exit");

	        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
	        getContentPane().setLayout(layout);
	        layout.setHorizontalGroup(
	            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(layout.createSequentialGroup()
	                .addGap(104, 104, 104)
	                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
	                    .addComponent(jLabel1)
	                    .addComponent(jLabel2))
	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
	                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
	                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
	                .addContainerGap(93, Short.MAX_VALUE))
	            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
	                .addGap(84, 84, 84)
	                .addComponent(jButton1)
	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                .addComponent(jButton2)
	                .addGap(64, 64, 64))
	        );
	        layout.setVerticalGroup(
	            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
	                .addGap(81, 81, 81)
	                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                    .addComponent(jLabel1)
	                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
	                .addGap(18, 18, 18)
	                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
	                    .addComponent(jLabel2))
	                .addGap(28, 28, 28)
	                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                    .addComponent(jButton1)
	                    .addComponent(jButton2))
	                .addContainerGap(55, Short.MAX_VALUE))
	        );

	        pack();
	        log.info("Initialing Successful");
	    }// </editor-fold>          
	@Override
	public void actionPerformed(ActionEvent arg0) {
		JButton button=(JButton)arg0.getSource();
		if(button==jButton1){
			String userName=jTextField1.getText();
			String password=jTextField2.getText();
			if(storeKeeperService.userLogin(userName, password)){
				// JOptionPane.showMessageDialog(null, "Login Successful", "Login Success", JOptionPane.INFORMATION_MESSAGE);
				log.info("Login Successful");
				Session.addSession("UserName", userName);
				if(loginSuccessfulActionListener!=null){
					 loginSuccessfulActionListener.afterLoginSuccessful();
					 this.setVisible(false);
				 }
			}else{
				 JOptionPane.showMessageDialog(null, "Username or password error", "Login Error", JOptionPane.ERROR_MESSAGE);
			}
		}else if(button.getText().equals("Exit")){
			System.exit(0);
		}
		
	}

	public void setLoginSuccessfulActionListener(
			LoginSuccessfulEventListener loginSuccessfulActionListener) {
		this.loginSuccessfulActionListener = loginSuccessfulActionListener;
	}
}
