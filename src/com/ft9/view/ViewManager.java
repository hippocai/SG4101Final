package com.ft9.view;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JPanel;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeSelectionModel;

import org.apache.log4j.Logger;

import com.ft9.annotation.Menu;
import com.ft9.common.StructConst;
import com.ft9.util.ClassUtils;

public class ViewManager {
	private static Logger log = Logger.getLogger(ViewManager.class);
	@SuppressWarnings("rawtypes")
	private static Map<String,HashMap<String,Class>>panelMap=new HashMap<String,HashMap<String,Class>>();
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void initViews(){
		log.info("Initialing Panels...");
		List<Class> allPanels=ClassUtils.getAllClassByFatherClass(javax.swing.JPanel.class, StructConst.PanelPackage);
		for(int i=0;i<allPanels.size();++i){
			Class cls=allPanels.get(i);
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
				//Do Nothing...
			}
		}
		log.info("Initial Successful");
	}
	
	@SuppressWarnings("rawtypes")
	public static Map<String,ArrayList<String>>getMenuList(){
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
	
	@SuppressWarnings("rawtypes")
	public static JPanel getPanelByNodeName(String fatherNodeName,String childNodeName) throws InstantiationException, IllegalAccessException{
		if(!panelMap.containsKey(fatherNodeName)){
			return null;
		}
		
		Map<String,Class> childNodePanelMap=panelMap.get(fatherNodeName);
		if(!childNodePanelMap.containsKey(childNodeName)){
			return null;
		}
		return (JPanel)childNodePanelMap.get(childNodeName).newInstance();
	}
	
	public static JTree createJTree(TreeSelectionListener treeSelectionListener){
		log.info("Creating Tree....");
		 DefaultMutableTreeNode top = new DefaultMutableTreeNode("root");
         Map<String,ArrayList<String>> nodeNameMap=ViewManager.getMenuList();
         for(String fatherNodeName:nodeNameMap.keySet()){
       	  DefaultMutableTreeNode node = new DefaultMutableTreeNode(fatherNodeName);
       	  List<String>childNodeNameList=nodeNameMap.get(fatherNodeName);
       	  for(String childNodeName:childNodeNameList){
       		  node.add(new DefaultMutableTreeNode(childNodeName));
       	  }
       	 top.add(node);
         }
         JTree jTree1 = new JTree(top);
         //jTree1.setSelectionModel(new TreeSelectionModel);;
         jTree1.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
         jTree1.setDragEnabled(false);
         jTree1.addTreeSelectionListener(treeSelectionListener);
         jTree1.setRootVisible(false);
         jTree1.putClientProperty("Quaqua.Tree.style", "sourceList");
         log.info("Successful");
         return jTree1;
	}
}
