package com.ft9.view.panel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.EventObject;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.event.CellEditorListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;

import com.ft9.annotation.Menu;
import com.ft9.bean.DiscountBean;
import com.ft9.common.FileConst;
import com.ft9.service.IDiscountService;
import com.ft9.service.ServiceManager;
import com.ft9.service.ServiceNotFoundException;
import com.ft9.service.impl.DiscountService;
import com.ft9.util.BeanUtil;
import com.ft9.util.ViewUtil;
import com.ft9.view.NameConverter;
import com.ft9.view.ViewManager;
import com.ft9.view.panel.actionListener.GoHomeListener;
import com.ft9.view.panel.subFunctionPanel.AddDiscountPanel;

/**
*
* @author hippo
*/
@Menu(name = "Discount", fatherName = "Manage")
public class DiscountManagePanel extends javax.swing.JPanel implements ActionListener,PropertyChangeListener {

    /**
	 * 
	 */
	private static final long serialVersionUID = 3144601764860760802L;
	private IDiscountService discountService=null;
	/**
     * Creates new form DiscountManagePanel
	 * @throws ServiceNotFoundException 
     */
    public DiscountManagePanel() throws ServiceNotFoundException {
    	discountService=(DiscountService)ServiceManager.getService("Discount");
        initComponents();
        initDatas();
        setActionListener();
    }

    private void initDatas(){
    	
    	jTable1.setModel(ViewUtil.transferBeanList2DefaultTableModel(discountService.getAllDiscountInfo(),"Discount"));
    }
    
    private void setActionListener(){
    	this.addPropertyChangeListener("Refresh", this);
    	deleteButton.addActionListener(this);
    	addNewButton.addActionListener(this);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        goHomeButton = ViewManager.createGoHomeButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = ViewUtil.createUneditableTable();
        addNewButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        modifyButton = new javax.swing.JButton();
        searchButton = new javax.swing.JButton();
        searchTxtArea = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox<>();
        
        jScrollPane1.setViewportView(jTable1);

        addNewButton.setText("Add");

        deleteButton.setText("Delete");

        modifyButton.setText("Modify");
        
        modifyButton.addActionListener(this);
        
        searchButton.setText("Search");
        
        searchButton.addActionListener(this);
        searchTxtArea.setText("");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(NameConverter.getTitleArr("Discount")));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(70, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 664, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(searchTxtArea, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(addNewButton)
                                        .addGap(33, 33, 33)
                                        .addComponent(deleteButton)))
                                .addGap(37, 37, 37)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(modifyButton, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(searchButton, javax.swing.GroupLayout.Alignment.TRAILING))))
                        .addGap(66, 66, 66))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(goHomeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(goHomeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                //.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 84, Short.MAX_VALUE)
                .addGap(30,30,30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchTxtArea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchButton)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addNewButton)
                    .addComponent(deleteButton)
                    .addComponent(modifyButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49))
        );

        searchButton.getAccessibleContext().setAccessibleName("searchButton");
    }// </editor-fold>                        


    // Variables declaration - do not modify                     
    private javax.swing.JButton goHomeButton;
    private javax.swing.JButton addNewButton;
    private javax.swing.JButton deleteButton;
    private javax.swing.JButton modifyButton;
    private javax.swing.JButton searchButton;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField searchTxtArea;
    // End of variables declaration                   
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO 自动生成的方法存根
		Object source=arg0.getSource();
		if(source==deleteButton){
			deleteExec();
		}else if(source==addNewButton){
			try {
				ViewManager.goToSubFunctionScreen(new AddDiscountPanel());
			} catch (ServiceNotFoundException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}else if(source==searchButton){
			searchExec();
		}else if(source==modifyButton){
			modifyExec();
		}
		
	}
	
	private void modifyExec(){
		try {
			List<HashMap<String,String>> selectedDatas=ViewUtil.getSelectedData(jTable1);
			if(selectedDatas.size()!=1){
				JOptionPane.showMessageDialog(null, "Please select 1 item to Modify", "Error", JOptionPane.ERROR_MESSAGE);
				return;
			}
			Map<String,String>selectedMap=NameConverter.convertViewMap2PhysicMap(selectedDatas.get(0), "Discount");
			DiscountBean selectedDiscountBean=new DiscountBean();
			BeanUtil.transMap2Bean(selectedMap, selectedDiscountBean);
			ViewManager.goToSubFunctionScreen(new AddDiscountPanel(selectedDiscountBean,AddDiscountPanel.MODIFY_DISCOUNT));
		} catch (ServiceNotFoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
	private void deleteExec(){
		List<HashMap<String,String>> selectedDatas=ViewUtil.getSelectedData(jTable1);
		if(selectedDatas.size()<1){
			JOptionPane.showMessageDialog(null, "Please select at least 1 item to delete", "Error", JOptionPane.ERROR_MESSAGE);
			return;
		}
		int options=JOptionPane.showConfirmDialog(null, "Are you ready to delete this "+selectedDatas.size()+"Items?", "Info",JOptionPane.YES_NO_OPTION);
		if(options==1){
			return;
		}
		for(HashMap<String,String> map:selectedDatas){
			
			discountService.deleteDiscountByMap(NameConverter.convertViewMap2PhysicMap(map, "Discount"));
		}
		this.initDatas();
	}
	
	private void searchExec(){
		String key=jComboBox1.getSelectedItem().toString();
		key=NameConverter.convertViewName2PhysicName("Discount", key);
		String valueLike=searchTxtArea.getText();
		List<DiscountBean>searchResult=discountService.searchDiscountByKey(key, valueLike);
		jTable1.setModel(ViewUtil.transferBeanList2DefaultTableModel(searchResult,"Discount"));
	}

	@Override
	public void propertyChange(PropertyChangeEvent arg0) {
		// TODO 自动生成的方法存根
		if(this.getClientProperty("Refresh")!=null&&this.getClientProperty("Refresh").equals("True")){
			 initDatas();
			 putClientProperty("Refresh", "False");
		}
		
		
	}
}

