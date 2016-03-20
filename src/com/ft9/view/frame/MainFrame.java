package com.ft9.view.frame;

import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;

import org.apache.log4j.Logger;

import com.ft9.view.ViewManager;
import com.ft9.view.panel.StartupPanel;

public class MainFrame extends JFrame implements TreeSelectionListener {
	
	/**
	 * 
	 */
	 private static final long serialVersionUID = -4948868798098674170L;
	 private static Logger log = Logger.getLogger(MainFrame.class);
	 private JScrollPane jScrollPane2;
	 private JScrollPane jScrollPane1;
	 private JTree jTree;
	 public MainFrame() {  
		 	log.info("Initialing MainFrame...");
		 	jTree=ViewManager.createJTree(this);
		 	//jTree.expandRow(0);
		 	
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
	        ViewManager.expandFatherTree("StoreKeeper");;
	    }  
	
	    public void initComponent() {  
	    	  setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
	          jScrollPane1 = new javax.swing.JScrollPane();
	          jScrollPane2 = new javax.swing.JScrollPane();
	          jScrollPane1.setViewportView(jTree);
	          jScrollPane2.setViewportView(new StartupPanel());
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

		@Override
		public void valueChanged(TreeSelectionEvent arg0) {
			// TODO 自动生成的方法存根
			if(arg0==null||arg0.getNewLeadSelectionPath()==null){
				return;
			}
			try {
				DefaultMutableTreeNode node=(DefaultMutableTreeNode)arg0.getNewLeadSelectionPath().getLastPathComponent();
				DefaultMutableTreeNode fatherNode=(DefaultMutableTreeNode)(node.getParent());
				String fatherNodeName=fatherNode.getUserObject().toString();
				String childNodeName=node.getUserObject().toString();
				JPanel panel=ViewManager.getPanelByNodeName(fatherNodeName, childNodeName);
				if(panel!=null){
					if(!jScrollPane2.getViewport().getView().getClass().getName().equals(panel.getClass().getName())){
						jScrollPane2.setViewportView(panel);
					}
					
				}
			} catch (Exception e) {
				// TODO 自动生成的 catch 块
				
				e.printStackTrace();
			} 
		}  
	      
	  
 
}
