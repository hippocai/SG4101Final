package com.ft9.view.frame;

import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JRootPane;
import javax.swing.JScrollPane;
import org.apache.log4j.Logger;
import com.ft9.view.ViewManager;

public class MainFrame extends JFrame {
	
	/**
	 * 
	 */
	 private static final long serialVersionUID = -4948868798098674170L;
	 private static Logger log = Logger.getLogger(MainFrame.class);
	 private JScrollPane jScrollPane2;
	 private JScrollPane jScrollPane1;
	 public MainFrame() {  
		 	log.info("Initialing MainFrame...");
	        initComponent();  
	    	super.dispose();
			super.setUndecorated(true);
			this.setLocationByPlatform(true);
			log.info("Initial Successful");
	        rootPane.setWindowDecorationStyle(JRootPane.FRAME);
			rootPane.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
			rootPane.putClientProperty("Quaqua.RootPane.isVertical", Boolean.FALSE);
			pack();  
	        setVisible(true);  
	        
	    }  
	 	
	    public void initComponent() {  
	    	  setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
	          jScrollPane1 = ViewManager.getLeftPanel();
	          jScrollPane2 = ViewManager.getRightPanel();
	          super.setSize(1024, 768);
	          javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
	          getContentPane().setLayout(layout);
	          layout.setHorizontalGroup(
	              layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	              .addGroup(layout.createSequentialGroup()
	                  .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
	                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                  .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 844, Short.MAX_VALUE))
	          );
	          layout.setVerticalGroup(
	              layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	              .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
	              .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 700, Short.MAX_VALUE)
	          );
	          pack();
	    }

 
 
}
