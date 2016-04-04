package com.ft9.view.panel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JOptionPane;

import com.ft9.annotation.Menu;
import com.ft9.bean.MemberBean;
import com.ft9.service.IMemberService;
import com.ft9.service.ServiceManager;
import com.ft9.service.ServiceNotFoundException;
import com.ft9.service.impl.MemberService;
import com.ft9.util.BeanUtil;
import com.ft9.util.ViewUtil;
import com.ft9.view.NameConverter;
import com.ft9.view.ViewManager;
import com.ft9.view.panel.subFunctionPanel.AddMemberPanel;


/**
 * class name:ManageMemberPanel <BR>
 * class description: Manage Member Information Panel <BR>
 * Remark: <BR>
 * @version 1.00
 * @author Guo Qi
 */

//Set The JTree Name
@Menu(name = "Member", fatherName = "Manage")

public class ManageMemberPanel extends javax.swing.JPanel implements ActionListener, PropertyChangeListener {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private IMemberService memberService = null;
	/**
     * Creates new form ManageProductPanel
	 * @throws ServiceNotFoundException 
     */
    public ManageMemberPanel() throws ServiceNotFoundException {
    	memberService = (MemberService)ServiceManager.getService("Member");
        initComponents();
        initDatas();
        setActionListener();
    }
    
    /**
     * Method name: initDatas <BR>
     * Description: Put The Member Information Into Table <BR>
     * Remark: <BR>  void<BR>
     */
    private void initDatas(){
        jTable1.setModel(ViewUtil.transferBeanList2DefaultTableModel(memberService.getAllMemberInfo(), "Member"));
    }
    
    /**
     * Method name: setActionListener <BR>
     * Description: Set ActionListener <BR>
     * Remark: <BR>  void<BR>
     */
    private void setActionListener(){
    	this.addPropertyChangeListener("Refresh", this);
    	jButtonDelete.addActionListener(this);
    	jButtonAdd.addActionListener(this);
    	jButtonUpdate.addActionListener(this);
    	jButtonSearch.addActionListener(this);
    }
    
    
    /**
     * Method name: initComponents <BR>
     * Description: Init Components In Member Panel <BR>
     * Remark: <BR>  void<BR>
     */
    private void initComponents() {

        jButton1 = ViewManager.createGoHomeButton();
        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jButtonSearch = new javax.swing.JButton();
        jButtonAdd = new javax.swing.JButton();
        jButtonDelete = new javax.swing.JButton();
        jButtonUpdate = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = ViewUtil.createUneditableTable();
        jComboBox1 = new javax.swing.JComboBox<>();

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            }
        });

        jLabel1.setText("Key Word:");

        jButtonSearch.setText("Search");
        jButtonSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            }
        });

        jButtonAdd.setText("Add");

        jButtonDelete.setText("Delete");

        jButtonUpdate.setText("Modify");


        jScrollPane1.setViewportView(jTable1);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(NameConverter.getTitleArr("Member")));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(23, 23, 23))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButtonAdd)
                                .addGap(31, 31, 31)
                                .addComponent(jButtonDelete)
                                .addGap(33, 33, 33)
                                .addComponent(jButtonUpdate))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(10, 10, 10)
                                .addComponent(jTextField1)
                                .addGap(18, 18, 18)
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(jButtonSearch)))
                        .addGap(350, 350, 350))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jButtonSearch)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAdd)
                    .addComponent(jButtonDelete)
                    .addComponent(jButtonUpdate))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 415, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );
    }                     

    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonSearch;
    private javax.swing.JButton jButtonAdd;
    private javax.swing.JButton jButtonDelete;
    private javax.swing.JButton jButtonUpdate;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration  
    
	/**
	 * @Override
	 * @see java.beans.PropertyChangeListener#propertyChange(java.beans.PropertyChangeEvent) <BR>
	 * Method name: propertyChange <BR>
	 * Description: Refresh <BR>
	 * Remark: <BR>
	 * @param arg0  <BR>
	*/
	@Override
	public void propertyChange(PropertyChangeEvent arg0) {
		// TODO Auto-generated method stub
		if(this.getClientProperty("Refresh")!=null&&this.getClientProperty("Refresh").equals("True")){
			 initDatas();
			 putClientProperty("Refresh", "False");
		}
	}

	/**
	 * @Override
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent) <BR>
	 * Method name: actionPerformed <BR>
	 * Description: Judge Which Button Is Pressed <BR>
	 * Remark: <BR>
	 * @param e  <BR>
	*/
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object source = e.getSource();
		if(source == jButtonDelete){
			deleteExcu();
		}else if(source == jButtonAdd){
			try {
				ViewManager.goToSubFunctionScreen(new AddMemberPanel());
			} catch (ServiceNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}else if(source == jButtonSearch){
			searchExcu();
		}else if(source == jButtonUpdate){
			updateExcu();
		}
	}

	/**
	 * Method name: updateExcu <BR>
	 * Description: Update Excute <BR>
	 * Remark: <BR>  void<BR>
	 */
	private void updateExcu(){
		// TODO Auto-generated method stub
		List<HashMap<String, String>> selectedData = ViewUtil.getSelectedData(jTable1);
		if (selectedData.size() != 1){
			JOptionPane.showMessageDialog(null, "Please at least select 1 item to modify.", "Error", JOptionPane.ERROR_MESSAGE);
			return;
		}
		Map<String, String> selectedMap = NameConverter.convertViewMap2PhysicMap(selectedData.get(0), "Member");
		MemberBean selectedMemberBean = new MemberBean();
		BeanUtil.transMap2Bean(selectedMap, selectedMemberBean);
		try {
			ViewManager.goToSubFunctionScreen(new AddMemberPanel(selectedMemberBean, AddMemberPanel.UPDATE_NEW_MEMBER));
		} catch (ServiceNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	/**
	 * Method name: searchExcu <BR>
	 * Description: Search Excute <BR>
	 * Remark: <BR>  void<BR>
	 */
	private void searchExcu() {
		// TODO Auto-generated method stub
		String key = jComboBox1.getSelectedItem().toString();
		key = NameConverter.convertViewName2PhysicName("Member", key);
		String valuelike = jTextField1.getText();
		List<MemberBean> searchResult = memberService.searchMemberByKey(key, valuelike);
		jTable1.setModel(ViewUtil.transferBeanList2DefaultTableModel(searchResult, "Member"));
		
	}

	/**
	 * Method name: deleteExcu <BR>
	 * Description: Delete Excute <BR>
	 * Remark: <BR>  void<BR>
	 */
	private void deleteExcu() {
		// TODO Auto-generated method stub
		List<HashMap<String, String>> selectedData = ViewUtil.getSelectedData(jTable1);
		if (selectedData.size() < 1){
			JOptionPane.showMessageDialog(null, "Please at least choose one member to delete !", "Error", JOptionPane.ERROR_MESSAGE);
			return;
		}
		int option = 1;
		if(selectedData.size() == 1){
			option = JOptionPane.showConfirmDialog(null, "Are you sure to delete this item ?", "info", JOptionPane.YES_NO_OPTION);
		}else{
			option = JOptionPane.showConfirmDialog(null, "Are you sure to delete these " + selectedData.size() + " items ?", "info", JOptionPane.YES_NO_OPTION);
		}
		if (option == 1){
			return;
		}else{
			for(HashMap<String, String> map:selectedData){
				memberService.deleteMemberByMap(NameConverter.convertViewMap2PhysicMap(map, "Member"));
			}
		}
		this.initDatas();
		
	}


}















