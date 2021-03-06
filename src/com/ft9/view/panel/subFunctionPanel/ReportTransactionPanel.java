package com.ft9.view.panel.subFunctionPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import com.ft9.bean.ProductBean;
import com.ft9.bean.TransactionBean;
import com.ft9.service.IProductService;
import com.ft9.service.ITransactionService;
import com.ft9.service.ServiceManager;
import com.ft9.service.ServiceNotFoundException;
import com.ft9.service.impl.ProductService;
import com.ft9.service.impl.TransactionService;
import com.ft9.util.ClientMainCalendar;
import com.ft9.util.StringUtil;
import com.ft9.util.ViewUtil;
import com.ft9.view.ViewManager;


/**
 *
 * @author apple
 */

/**
 * class name:ReportTransactionPanel <BR>
 * class description: Report Transaction Panel <BR>
 * Remark: <BR>
 * @version 1.00
 * @author Guo Qi
 */
public class ReportTransactionPanel extends javax.swing.JPanel {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	String[]tableHeader={"ID","Product Id","Product Name","Description","Member","Quantity","Date"};
	ITransactionService transService=null;
	IProductService productService=null;
    public ReportTransactionPanel() {
    	initServices();
        initComponents();
        initDatas();
    }
    
    private void initDatas(){
    	startdateTxtField.setText("");
    	endDateTxtField.setText("");
    	this.setTableData(transService.getAllTransactions());
    }
    private void initServices(){
    	try {
			transService=(TransactionService)ServiceManager.getService("Transaction");
			productService=(ProductService)ServiceManager.getService("Product");
		} catch (ServiceNotFoundException e) {
			e.printStackTrace();
		}
    }
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = ViewUtil.createUneditableTable();
        printBtn = ViewManager.createPrintButton();
        backBtn = ViewManager.createGoBackButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        startdateTxtField = new javax.swing.JTextField();
        endDateTxtField = new javax.swing.JTextField();
        searchBtn = new javax.swing.JButton();

        jScrollPane1.setViewportView(jTable1);
        
        jLabel1.setText("Start Date:");

        jLabel2.setText("End Date:");
        ClientMainCalendar startDateCalendar=ClientMainCalendar.getInstance();
        startDateCalendar.register(startdateTxtField);
        ClientMainCalendar endDateCalendar=ClientMainCalendar.getInstance();
        endDateCalendar.register(endDateTxtField);
       
        
        searchBtn.setText("Search");
        searchBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				searchExec();
			}
		});
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(104, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(96, 96, 96))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(31, 31, 31)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(startdateTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(endDateTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(46, 46, 46)
                            .addComponent(searchBtn)
                            .addGap(368, 368, 368)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(printBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(backBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(66, 66, 66))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(startdateTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(endDateTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(searchBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(19, 19, 19)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(printBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(backBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(19, Short.MAX_VALUE))
        );
    }                        


    private javax.swing.JButton printBtn;
    private javax.swing.JButton backBtn;
    private javax.swing.JButton searchBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField startdateTxtField;
    private javax.swing.JTextField endDateTxtField;
    private void searchExec(){
    	List<TransactionBean>transBeanList=transService.getTransactionsByTimePeriod(startdateTxtField.getText(), endDateTxtField.getText());
    	setTableData(transBeanList);
    }
    
    /**
     * Method name: setTableData <BR>
     * Description: Set Table Data <BR>
     * Remark: <BR>
     * @param transList  void<BR>
     */
    private void setTableData(List<TransactionBean> transList){
    	List<HashMap<String,String>>viewList=new ArrayList<HashMap<String,String>>();
    	for(TransactionBean transBean:transList){
    		List<ProductBean> productBeanList=productService.getProductByKey("id", transBean.getProductId());
    		ProductBean productBean=null;
    		if(productBeanList!=null&&productBeanList.size()>0){
    			productBean=productBeanList.get(0);
    		}
    		HashMap<String,String>map=new HashMap<String,String>();
    		map.put("ID", transBean.getId());
    		if(productBean!=null){
    			map.put("Product Id", productBean.getId());
        		map.put("Product Name", productBean.getName());
        		map.put("Description", productBean.getDescription());
    		}
    		else{
    			map.put("Product Id", "LOST");
        		map.put("Product Name", "LOST");
        		map.put("Description", "LOST");
    		}
    		map.put("Member", transBean.getMemberId());
    		map.put("Quantity", transBean.getQuantityPurchased());
    		map.put("Date", transBean.getDate());
    		viewList.add(map);
    	}
    	jTable1.setModel(ViewUtil.transferMapListToDTModel(StringUtil.transStringArr2List(tableHeader), viewList));
    }
}

