package com.ft9.view;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;
import javax.swing.tree.TreeSelectionModel;

import org.apache.log4j.Logger;

import com.ft9.annotation.Menu;
import com.ft9.common.StructConst;
import com.ft9.service.ServiceNotFoundException;
import com.ft9.util.ClassUtils;
import com.ft9.view.panel.DiscountManagePanel;
import com.ft9.view.panel.HelpPanel;
import com.ft9.view.panel.ManageCategoryPanel;
import com.ft9.view.panel.ManageMemberPanel;
import com.ft9.view.panel.ManageProductPanel;
import com.ft9.view.panel.ManageVendorPanel;
import com.ft9.view.panel.ModifyPasswordPanel;
import com.ft9.view.panel.PaymentPanel;
import com.ft9.view.panel.PrintReportPanel;
import com.ft9.view.panel.ProductsEntryPanel;
import com.ft9.view.panel.ProductsReplenishPanel;
import com.ft9.view.panel.StartupPanel;
import com.ft9.view.panel.StorekeeperManagePanel;
import com.ft9.view.panel.actionListener.GoBackListener;
import com.ft9.view.panel.actionListener.GoHomeListener;
import com.ft9.view.panel.actionListener.PrintListener;
import com.icon.IconManager;

public class ViewManager {
	private static Logger log = Logger.getLogger(ViewManager.class);
	private static String[] treeSeq={"Payment","Entry & Replenish","Manage","StoreKeeper","Print","Help"};
	@SuppressWarnings("rawtypes")
	private static Map<String,HashMap<String,Class>>panelMap=new HashMap<String,HashMap<String,Class>>();

	private static JTree jTree;
	private static JScrollPane rightPanel=null;
	private static JScrollPane leftPanel=null;
	private static Stack<JPanel> panelStack;
	/**
	 * Init Views
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void initViews()throws Exception{
		log.info("Initialing Panels...");
		checkAllPanels();
		//Put all panel classes into the list
		panelStack=new Stack<JPanel>();
		List<Class> allPanels=ClassUtils.getAllClassByFatherClass(JPanel.class, StructConst.PanelPackage);
		
		for(int i=0;i<allPanels.size();++i){
			Class cls=allPanels.get(i);
			//check if the panel class has the annotation
			if(cls.isAnnotationPresent(Menu.class)){
				Menu pnAnnotation=(Menu)cls.getAnnotation(Menu.class);
				String name=pnAnnotation.name();
				String fatherNodeName=pnAnnotation.fatherName();
				if(panelMap.containsKey(fatherNodeName)){
					panelMap.get(fatherNodeName).put(name, cls);
				}else{
					panelMap.put(fatherNodeName, new HashMap<String,Class>());
					panelMap.get(fatherNodeName).put(name, cls);
				}
			}else{
			}
		}
		IconManager.initIcon();
		log.info("Initial Successful");
	}
	
	public static JButton createGoHomeButton(){
		JButton goHomeButton=new JButton();
		goHomeButton.addActionListener(new GoHomeListener());
		 //ImageIcon image = new ImageIcon("src/com/icon/home.png"); 
		//goHomeButton.setText("home");
		goHomeButton.setIcon(IconManager.getIcon("home"));
		goHomeButton.setBounds(5, 5, 500, 200);
		return goHomeButton;
	}
	
	public static JButton createGoBackButton(){
		JButton goBackButton=new JButton();
		
		goBackButton.setIcon(IconManager.getIcon("back"));
        goBackButton.addActionListener(new GoBackListener());
        return goBackButton;
	}
	
	public static JButton createPrintButton(){
		JButton printButton=new JButton();
		printButton.setIcon(IconManager.getIcon("print"));
		printButton.addActionListener(new PrintListener());
		return printButton;
	}
	//Expend the father tree by father tree name
	public static void expandFatherTree(String fatherTreeName){
		DefaultMutableTreeNode top=(DefaultMutableTreeNode)jTree.getModel().getRoot();
		for(int treeIndex=0;treeIndex<top.getChildCount();++treeIndex){
			DefaultMutableTreeNode treeNode=(DefaultMutableTreeNode)top.getChildAt(treeIndex);
			String treeName=treeNode.getUserObject().toString();
			if(treeName.equals(fatherTreeName)){
				if(!jTree.isExpanded(treeIndex)){
					jTree.expandRow(treeIndex);
					return;
				}
			}
		}
	}
	
	//Expand all the trees
	public static void expandAllTrees(){
		for(int i=0;i<jTree.getRowCount();++i){
			if(!jTree.isExpanded(i)){
				jTree.expandRow(i);
			}
		}
	}
	
	//Collapse the father tree by name
	public static void collapseFatherTree(String fatherTreeName){
		DefaultMutableTreeNode top=(DefaultMutableTreeNode)jTree.getModel().getRoot();
		for(int treeIndex=0;treeIndex<top.getChildCount();++treeIndex){
			DefaultMutableTreeNode treeNode=(DefaultMutableTreeNode)top.getChildAt(treeIndex);
			String treeName=treeNode.getUserObject().toString();
			if(treeName.equals(fatherTreeName)){
				if(!jTree.isCollapsed(treeIndex)){
					jTree.collapseRow(treeIndex);
					return;
				}
			}
		}
	}
	
	//collapse all the tree
	public static void collapseAllTree(){
		for(int i=0;i<jTree.getRowCount();++i){
			if(!jTree.isCollapsed(i)){
				jTree.collapseRow(i);
			}
		}
	}
	
	
	public static JScrollPane getLeftPanel(){
		if(leftPanel==null){
			leftPanel=new JScrollPane();
			leftPanel.setViewportView(getJTree());
		}
		return leftPanel;
	}
	
	public static JScrollPane  getRightPanel(){
		if(rightPanel==null){
			rightPanel=new JScrollPane();
			rightPanel.setViewportView(new StartupPanel());
		}
		
		return rightPanel;
	}
	
	public static void goToHomePanel(){
		panelStack.clear();
		clearTreeSelection();
		rightPanel.setViewportView(new StartupPanel());
	}
	
	public static void goToSubFunctionScreen(JPanel subFunctionPanel){
		panelStack.push((JPanel)rightPanel.getViewport().getView());
		rightPanel.setViewportView(subFunctionPanel);
	}
	
	public static void goBack(){
		if(!panelStack.isEmpty()){
			JPanel jpanel=panelStack.pop();
			rightPanel.setViewportView(jpanel);
			jpanel.putClientProperty("Refresh", "True");
			
			
		}
	}
	
	public static void callRefreshCurrentPanel(){
		JPanel jPanel=(JPanel)rightPanel.getViewport().getView();
		jPanel.putClientProperty("Refresh", "True");
	}
	
	public static void refreshCurrentPanel() throws InstantiationException, IllegalAccessException{
		JPanel jPanel=(JPanel)rightPanel.getViewport().getView();
		rightPanel.setViewportView(jPanel.getClass().newInstance());
	}

	
	//select tree node by node name and father node name
	public static void selectTreeNodeByName(String nodeName,String fatherName){
		
		DefaultMutableTreeNode top=(DefaultMutableTreeNode)jTree.getModel().getRoot();
		for(int treeIndex=0;treeIndex<top.getChildCount();++treeIndex){
			DefaultMutableTreeNode treeNode=(DefaultMutableTreeNode)top.getChildAt(treeIndex);
			String treeName=treeNode.getUserObject().toString();
			if(treeName.equals(fatherName)){
				for(int childIndex=0;childIndex<treeNode.getChildCount();++childIndex){
					DefaultMutableTreeNode childNode=(DefaultMutableTreeNode)treeNode.getChildAt(childIndex);
					String childNodeName=childNode.getUserObject().toString();
					if(childNodeName.equals(nodeName)){
						TreePath treePath=new TreePath(childNode.getPath());
						jTree.setSelectionPath(treePath);
					}
				}
			}
		}
	}
	
	//clear any selections of the tree
	public static void clearTreeSelection(){
		jTree.clearSelection();
	}

	//Create a JTree By the configuration
	public static JTree getJTree(){
		if(jTree!=null){
			return jTree;
		}
		log.info("Creating Tree....");
		 DefaultMutableTreeNode top = new DefaultMutableTreeNode("root");
         Map<String,ArrayList<String>> nodeNameMap=ViewManager.getMenuList();
         for(int i=0;i<treeSeq.length;++i){
        	 String fatherNodeName=treeSeq[i];
        	 if(!nodeNameMap.containsKey(fatherNodeName)){
        		 continue;
        	 }
	       	  DefaultMutableTreeNode node = new DefaultMutableTreeNode(fatherNodeName);
	       	  List<String>childNodeNameList=nodeNameMap.get(fatherNodeName);
	       	  for(String childNodeName:childNodeNameList){
	       		  node.add(new DefaultMutableTreeNode(childNodeName));
	       	  }
	       	 top.add(node);
         }
         JTree jTree1 = new JTree(top);
         jTree1.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
         jTree1.setDragEnabled(false);
         jTree1.addTreeSelectionListener(new TreeSelectionListener() {
			
			@Override
			public void valueChanged(TreeSelectionEvent arg0) {
				dealWithTreeEvent(arg0);
				
			}
		});
         jTree1.setRootVisible(false);
         jTree1.putClientProperty("Quaqua.Tree.style", "sourceList");
         jTree=jTree1;
         log.info("Successful");
         return jTree1;
	}
	
	private static void dealWithTreeEvent(TreeSelectionEvent arg0){
		if(arg0==null||arg0.getNewLeadSelectionPath()==null){
			return;
		}
		try {
			DefaultMutableTreeNode node=(DefaultMutableTreeNode)arg0.getNewLeadSelectionPath().getLastPathComponent();
			DefaultMutableTreeNode fatherNode=(DefaultMutableTreeNode)(node.getParent());
			String fatherNodeName=fatherNode.getUserObject().toString();
			String childNodeName=node.getUserObject().toString();
			ViewManager.goToFunction(childNodeName, fatherNodeName);
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} 
	}
	//Get the menu list by panelMap
	@SuppressWarnings("rawtypes")
	private static Map<String,ArrayList<String>>getMenuList(){
			Map<String,ArrayList<String>> menuList=new HashMap<String,ArrayList<String>>();
			for(String fatherNode:panelMap.keySet()){
				Map<String,Class> childNodeMap=panelMap.get(fatherNode);
				ArrayList<String> childNodeStrList=new ArrayList<String>();
				for(String childNodeStr:childNodeMap.keySet()){
					childNodeStrList.add(childNodeStr);
				}
				menuList.put(fatherNode, childNodeStrList);
			}
			return menuList;
		}
		
	//Create a new panel object by Node name and father node name
	@SuppressWarnings("rawtypes")
	private static JPanel getPanelByNodeName(String fatherNodeName,String childNodeName) throws InstantiationException, IllegalAccessException{
			if(!panelMap.containsKey(fatherNodeName)){
				return null;
			}
			
			Map<String,Class> childNodePanelMap=panelMap.get(fatherNodeName);
			if(!childNodePanelMap.containsKey(childNodeName)){
				return null;
			}
			return (JPanel)childNodePanelMap.get(childNodeName).newInstance();
	}
	
	//Go to panel by node name(Clear the panel stack)
	private static void goToFunction(String childNodeName,String fatherNodeName) throws InstantiationException, IllegalAccessException{
		panelStack.clear();
		JPanel panel=ViewManager.getPanelByNodeName(fatherNodeName, childNodeName);
		if(panel!=null){
			if(!rightPanel.getViewport().getView().getClass().getName().equals(panel.getClass().getName())){
				rightPanel.setViewportView(panel);
			}
		}
	}
	
	private static void checkAllPanels() throws ServiceNotFoundException{
		new DiscountManagePanel();
		new HelpPanel();
		new ManageCategoryPanel();
		new ManageMemberPanel();
		new ManageProductPanel();
		new ManageVendorPanel();
		new ModifyPasswordPanel();
		new PaymentPanel();
		new PrintReportPanel();
		new ProductsEntryPanel();
		new ProductsReplenishPanel();
		new StorekeeperManagePanel();
		new StartupPanel();
	}
	
}
