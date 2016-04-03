package com.ft9.view.panel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import com.ft9.annotation.Menu;
import com.ft9.bean.ProductBean;
import com.ft9.common.Session;
import com.ft9.service.IProductService;
import com.ft9.service.ServiceManager;
import com.ft9.service.ServiceNotFoundException;
import com.ft9.service.impl.ProductService;
import com.ft9.util.BeanUtil;
import com.ft9.util.ViewUtil;
import com.ft9.view.NameConverter;
import com.ft9.view.ViewManager;
import com.ft9.view.frame.ReplenishDiagram;
import com.ft9.view.panel.subFunctionPanel.PrintPanel;


/**
 * class name:ProductsReplenishPanel <BR>
 * class description: Product Replenish Panel <BR>
 * Remark: <BR>
 * @version 1.00
 * @author caiyicheng
 */
@Menu(name="Products Replenish",fatherName="Entry&Replenish")
public class ProductsReplenishPanel extends javax.swing.JPanel implements PropertyChangeListener {

	private static final long serialVersionUID = -7738644575952449822L;
	IProductService productService=null;
	
   /**
 * Method name: ProductsReplenishPanel<BR>
 * Description: Product Replenish Panel constructor<BR>
 * Remark: <BR>
 * @throws ServiceNotFoundException <BR>
 */
public ProductsReplenishPanel() throws ServiceNotFoundException {
	   productService=(ProductService)ServiceManager.getService("Product");
       initComponents();
       initDatas();
   }
   
   /**
 * Method name: initDatas <BR>
 * Description: Init All The Datas In The Form <BR>
 * Remark: <BR>  void<BR>
 */
	private void initDatas(){
	   jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(NameConverter.getTitleArr("Product")));
	   jTable1.setModel(ViewUtil.transferBeanList2DefaultTableModel(productService.getProductsBelowThreshold(),"Product"));
   }

	/**
	 * Method name: initComponents <BR>
	 * Description: Init All The Components In The Panel <BR>
	 * Remark: <BR>  void<BR>
	 */
	private void initComponents() {
	   this.addPropertyChangeListener("Refresh", this);
       jScrollPane1 = new javax.swing.JScrollPane();
       jTable1 = ViewUtil.createUneditableTable();
       goHomeButton = ViewManager.createGoHomeButton();
       jScrollPane2 = new javax.swing.JScrollPane();
       searchTxtField = new javax.swing.JTextField();
       jComboBox2 = new javax.swing.JComboBox<>();
       searchBtn = new javax.swing.JButton();
       jLabel1 = new javax.swing.JLabel();
       replenishBtn = new javax.swing.JButton();
       purchaseOrderBtn = new javax.swing.JButton();
       jScrollPane1.setViewportView(jTable1);
       jScrollPane2.setViewportView(jTable1);
       searchBtn.setText("Search");
       searchBtn.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			searchExec();
			}
       	});

       jLabel1.setText("Search Keyword:");
       replenishBtn.setText("Replenish");
       replenishBtn.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			replenishExec();
		}
	});
       purchaseOrderBtn.setText("Purchase Order");
       purchaseOrderBtn.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			generateOrderExec();
		}
	});
       javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
       this.setLayout(layout);
       layout.setHorizontalGroup(
           layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
           .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
               .addContainerGap(74, Short.MAX_VALUE)
               .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                   .addGroup(layout.createSequentialGroup()
                       .addComponent(jLabel1)
                       .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                       .addComponent(searchTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                       .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                       .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                       .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                       .addComponent(searchBtn)
                       .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                       .addComponent(replenishBtn)
                       .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                       .addComponent(purchaseOrderBtn)
                       .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                   .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                       .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                           .addComponent(goHomeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                           .addContainerGap())
                       .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                           .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 664, javax.swing.GroupLayout.PREFERRED_SIZE)
                           .addGap(62, 62, 62)))))
       );
       layout.setVerticalGroup(
           layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
           .addGroup(layout.createSequentialGroup()
               .addContainerGap()
               .addComponent(goHomeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
               .addGap(74, 74, 74)
               .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                   .addComponent(searchTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                   .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                   .addComponent(searchBtn)
                   .addComponent(jLabel1)
                   .addComponent(replenishBtn)
                   .addComponent(purchaseOrderBtn))
               .addGap(6, 6, 6)
               .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 403, javax.swing.GroupLayout.PREFERRED_SIZE)
               .addGap(18, 51, Short.MAX_VALUE))
       );
   }                    
                                      
	/**
	 * Method name: searchExec <BR>
	 * Description: Execute the search <BR>
	 * Remark: <BR>  void<BR>
	 */
	private void searchExec(){
		String key=jComboBox2.getSelectedItem().toString();
		key=NameConverter.convertViewName2PhysicName("Product", key);
		String valueLike=searchTxtField.getText();
		List<ProductBean>searchResult=productService.searchProductByKey(key, valueLike);
		List<ProductBean>reorderProductsList=productService.getProductsBelowThreshold();

		List<ProductBean>reorderSearchResult=new ArrayList<ProductBean>();
		for(ProductBean productBean:reorderProductsList){
			if(listContains(searchResult, productBean)){
				reorderSearchResult.add(productBean);
			}
		}
		jTable1.setModel(ViewUtil.transferBeanList2DefaultTableModel(reorderSearchResult,"Product"));
	}
	
	/**
	 * Method name: listContains <BR>
	 * Description: Check if the Product List contains the Product <BR>
	 * Remark: <BR>
	 * @param searchResult
	 * @param productBean
	 * @return  boolean<BR>
	 */
	private boolean listContains(List<ProductBean>searchResult,ProductBean productBean){
		boolean contains=false;
		for(ProductBean resultBean:searchResult){
			if(resultBean.getId().equals(productBean.getId())){
				return true;
			}
		}
		return contains;
	}
	
	/**
	 * Method name: replenishExec <BR>
	 * Description: Execute the replenish <BR>
	 * Remark: <BR>  void<BR>
	 */
	private void replenishExec(){
		try {
			List<HashMap<String,String>> selectedDatas=ViewUtil.getSelectedData(jTable1);
			if(selectedDatas.size()!=1){
				JOptionPane.showMessageDialog(null, "Please select 1 item to Replenish", "Error", JOptionPane.ERROR_MESSAGE);
				return;
			}
			Map<String,String>selectedMap=NameConverter.convertViewMap2PhysicMap(selectedDatas.get(0), "Product");
			ProductBean selectedProductBean=new ProductBean();
			BeanUtil.transMap2Bean(selectedMap, selectedProductBean);
			
			JFrame jframe=new ReplenishDiagram(selectedProductBean);
			jframe.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Method name: generateOrderExec <BR>
	 * Description: Generate the purchase order <BR>
	 * Remark: <BR>  void<BR>
	 */
	private void generateOrderExec(){
		List<String>header=new ArrayList<String>();
		header.add("Name");
		header.add("Order");
		List<HashMap<String,String>> selectedDatas=ViewUtil.getSelectedData(jTable1);
		if(selectedDatas.size()<1){
			JOptionPane.showMessageDialog(null, "Please select At Least 1 item to Replenish", "Error", JOptionPane.ERROR_MESSAGE);
			return;
		}
		Entry<String,String>addInfo=new AbstractMap.SimpleEntry<String,String>("Store Keeper:",Session.getSession("UserName"));
		ViewManager.goToSubFunctionScreen(new PrintPanel(header,selectedDatas,addInfo));
	}

   private javax.swing.JButton goHomeButton;
   private javax.swing.JButton purchaseOrderBtn;
   private javax.swing.JButton searchBtn;
   private javax.swing.JButton replenishBtn;
   private javax.swing.JComboBox<String> jComboBox2;
   private javax.swing.JLabel jLabel1;
   private javax.swing.JScrollPane jScrollPane1;
   private javax.swing.JScrollPane jScrollPane2;
   private javax.swing.JTable jTable1;
   private javax.swing.JTextField searchTxtField;

	/**
	 * @Override
	 * @see java.beans.PropertyChangeListener#propertyChange(java.beans.PropertyChangeEvent) <BR>
	 * Method name: propertyChange <BR>
	 * Description: Refresh the Panel <BR>
	 * Remark: <BR>
	 * @param arg0  <BR>
	*/
	@Override
	public void propertyChange(PropertyChangeEvent arg0) {
		if(this.getClientProperty("Refresh")!=null&&this.getClientProperty("Refresh").equals("True")){
			 initDatas();
			 putClientProperty("Refresh", "False");
		}
}
}
