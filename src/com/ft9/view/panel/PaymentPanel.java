package com.ft9.view.panel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.ft9.annotation.Menu;
import com.ft9.bean.DiscountBean;
import com.ft9.bean.MemberBean;
import com.ft9.bean.ProductBean;
import com.ft9.bean.TransactionBean;
import com.ft9.common.RedeemConfig;
import com.ft9.common.Session;
import com.ft9.service.IPaymentService;
import com.ft9.service.ServiceManager;
import com.ft9.service.ServiceNotFoundException;
import com.ft9.service.impl.PaymentService;
import com.ft9.util.StringUtil;
import com.ft9.util.TimeUtil;
import com.ft9.util.ViewUtil;
import com.ft9.view.ViewManager;
import com.ft9.view.panel.subFunctionPanel.PrintPanel;
import com.icon.IconManager;


/**
 * class name:PaymentPanel <BR>
 * class description: Make Payment Panel <BR>
 * Remark: <BR>
 * @version 1.00
 * @author Cai Yicheng
 */

//Set The JTree Name
/**
 * class name:PaymentPanel <BR>
 * class description: please write your description <BR>
 * Remark: <BR>
 * @version 1.00 2016Äê4ÔÂ2ÈÕ
 * @author Guo Qi
 */
@Menu(name = "Checkout", fatherName = "Payment")
public class PaymentPanel extends javax.swing.JPanel implements KeyListener, FocusListener ,PropertyChangeListener{

   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String[] MemberTableHeader=new String [] {"Param","Value"};
	String[] TransactionTableHeader=new String [] {"Name", "Quantity", "Price", "Total Price"};
	List<TransactionBean> transList=new ArrayList<TransactionBean>();
	private IPaymentService payService=null;
	private MemberBean memberBean=null;
	private DiscountBean discountBean=null;
	double cash=0;
/**
    * Creates new form PaymentPanel
 * @throws ServiceNotFoundException 
    */
   public PaymentPanel() throws ServiceNotFoundException {
	   payService=(PaymentService)ServiceManager.getService("Payment");
       initComponents();
   }

   /**
 * Method name: initComponents <BR>
 * Description: Init Components In The Payment Panel<BR>
 * Remark: <BR>  void<BR>
 */
   private void initComponents() {

       jScrollPane1 = new javax.swing.JScrollPane();
       memberInfoTable = ViewUtil.createUneditableTable();
       memberInfoTable.getTableHeader().setVisible(false);
       jScrollPane2 = new javax.swing.JScrollPane();
       transPanel = new javax.swing.JTable();
       discountTxtField = new JTextField();
       totalTxtField = new JTextField();
       actualTxtField = new JTextField();
       loyalUseTxtField = new JTextField();
       cashTxtField = new JTextField();
       jLabel1 = new javax.swing.JLabel();
       jLabel2 = new javax.swing.JLabel();
       jLabel3 = new javax.swing.JLabel();
       jLabel4 = new javax.swing.JLabel();
       jLabel5 = new javax.swing.JLabel();
       memberIdTxtField = new javax.swing.JTextField();
       barcodeTxtField = new javax.swing.JTextField();
       quantityTxtField = new javax.swing.JTextField();
       clearBtn = new javax.swing.JButton();
       clearBtn.setIcon(IconManager.getIcon("clear"));
       clearBtn.addActionListener(new ActionListener() {
		
		/**
		 * @Override
		 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent) <BR>
		 * Method name: actionPerformed <BR>
		 * Description: Clear Button Pressed <BR>
		 * Remark: <BR>
		 * @param arg0  <BR>
		*/
		@Override
		public void actionPerformed(ActionEvent arg0) {
			try {
				ViewManager.refreshCurrentPanel();
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}
	});
       goToHomeBtn = ViewManager.createGoHomeButton();
       payBtn = new javax.swing.JButton();

       memberInfoTable.setModel(new javax.swing.table.DefaultTableModel(
           new Object [][] {},
           new String [] {
               "Param","Value"
           }
       ));
       jScrollPane1.setViewportView(memberInfoTable);
       this.addPropertyChangeListener("Refresh", this);
       transPanel.setModel(new javax.swing.table.DefaultTableModel(
           new Object [][] {},
           new String [] {
               "Name", "Quantity", "Price", "Total Price"
           }
       ));
       jScrollPane2.setViewportView(transPanel);

       discountTxtField.setText("0");
       discountTxtField.setEnabled(false);
       totalTxtField.setText("0");
       totalTxtField.setEnabled(false);
       actualTxtField.setText("0");
       actualTxtField.setEnabled(false);
       loyalUseTxtField.setText("0");
       loyalUseTxtField.addKeyListener(this);
       loyalUseTxtField.addFocusListener(this);
       loyalUseTxtField.setEnabled(false);
       cashTxtField.setText("0");
       cashTxtField.setEnabled(false);
       cashTxtField.addKeyListener(this);
       cashTxtField.addFocusListener(this);
       jLabel1.setText("Discount");
       
       jLabel1.setHorizontalAlignment(JLabel.CENTER);
       
       jLabel2.setText("Total Price");
       
       jLabel2.setHorizontalAlignment(JLabel.CENTER);

       jLabel3.setText("Actual Price");

       jLabel3.setHorizontalAlignment(JLabel.CENTER);
       
       jLabel4.setText("Loyalty Points used");
       
       jLabel4.setHorizontalAlignment(JLabel.CENTER);

       jLabel5.setText("Cash");
       
       jLabel5.setHorizontalAlignment(JLabel.CENTER);
       
       memberIdTxtField.setText("Student/Staff ID");
       memberIdTxtField.addKeyListener(this);
       memberIdTxtField.addFocusListener(this);
       
       barcodeTxtField.setText("Product No.");
       barcodeTxtField.addKeyListener(this);
       barcodeTxtField.setEnabled(false);
       barcodeTxtField.addFocusListener(this);
       quantityTxtField.setText("1");
       quantityTxtField.addKeyListener(this);
       quantityTxtField.setEnabled(false);

       payBtn.setText("Pay");
       payBtn.addActionListener(new ActionListener() {
		
		/**
		 * @Override
		 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent) <BR>
		 * Method name: actionPerformed <BR>
		 * Description: Pay Button Execute <BR>
		 * Remark: <BR>
		 * @param e  <BR>
		*/
		@Override
		public void actionPerformed(ActionEvent e) {
			payExec();
			
		}
	});

       javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
       this.setLayout(layout);
       layout.setHorizontalGroup(
           layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
           .addGroup(layout.createSequentialGroup()
               .addGap(76, 76, 76)
               .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                   .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 671, javax.swing.GroupLayout.PREFERRED_SIZE)
                   .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                       .addComponent(memberIdTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                       .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                       .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 403, javax.swing.GroupLayout.PREFERRED_SIZE))
                   .addGroup(layout.createSequentialGroup()
                       .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                           .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE)
                           .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                           .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                           .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                           .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                       .addGap(46, 46, 46)
                       .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                           .addComponent(discountTxtField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                           .addComponent(totalTxtField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                           .addComponent(actualTxtField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                           .addComponent(loyalUseTxtField, javax.swing.GroupLayout.DEFAULT_SIZE, 315, Short.MAX_VALUE)
                           .addComponent(cashTxtField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                   .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                       .addComponent(barcodeTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, 461, javax.swing.GroupLayout.PREFERRED_SIZE)
                       .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                       .addComponent(quantityTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)))
               .addContainerGap(80, Short.MAX_VALUE))
           .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
               .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
               .addComponent(payBtn)
               .addGap(293, 293, 293)
               .addComponent(goToHomeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
               .addGap(18, 18, 18)
               .addComponent(clearBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
               .addGap(42, 42, 42))
       );
       layout.setVerticalGroup(
           layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
           .addGroup(layout.createSequentialGroup()
               .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                   .addGroup(layout.createSequentialGroup()
                       .addGap(20, 20, 20)
                       .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                   .addGroup(layout.createSequentialGroup()
                       .addGap(40, 40, 40)
                       .addComponent(memberIdTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
               .addGap(26, 26, 26)
               .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                   .addComponent(barcodeTxtField, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                   .addComponent(quantityTxtField))
               .addGap(31, 31, 31)
               .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
               .addGap(18, 18, 18)
               .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                   .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                   .addComponent(discountTxtField, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE))
               .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
               .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                   .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                   .addComponent(totalTxtField, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE))
               .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
               .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                   .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                   .addComponent(actualTxtField, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE))
               .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
               .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                   .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                   .addComponent(loyalUseTxtField, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE))
               .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
               .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                   .addComponent(cashTxtField, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                   .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
               .addGap(18, 18, 18)
               .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                   .addGroup(layout.createSequentialGroup()
                       .addGap(0, 20, Short.MAX_VALUE)
                       .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                           .addComponent(clearBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                           .addComponent(goToHomeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                   .addGroup(layout.createSequentialGroup()
                       .addComponent(payBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                       .addGap(0, 0, Short.MAX_VALUE))))
       );
   }                        


   private javax.swing.JButton clearBtn;
   private javax.swing.JButton goToHomeBtn;
   private javax.swing.JButton payBtn;
   private javax.swing.JLabel jLabel1;
   private javax.swing.JLabel jLabel2;
   private javax.swing.JLabel jLabel3;
   private javax.swing.JLabel jLabel4;
   private javax.swing.JLabel jLabel5;
   private javax.swing.JScrollPane jScrollPane1;
   private javax.swing.JScrollPane jScrollPane2;
   private javax.swing.JTable memberInfoTable;
   private javax.swing.JTable transPanel;
   private javax.swing.JTextField memberIdTxtField;
   private javax.swing.JTextField barcodeTxtField;
   private javax.swing.JTextField quantityTxtField;
   private JTextField discountTxtField;
   private JTextField totalTxtField;
   private JTextField actualTxtField;
   private JTextField loyalUseTxtField;
   private JTextField cashTxtField;

	/**
	 * @Override
	 * @see java.awt.event.KeyListener#keyReleased(java.awt.event.KeyEvent) <BR>
	 * Method name: keyReleased <BR>
	 * Description: Judge Which Button Is Pressed <BR>
	 * Remark: <BR>
	 * @param arg0  <BR>
	*/
	public void keyReleased(KeyEvent arg0) {
		if(arg0.getKeyCode()==KeyEvent.VK_ENTER){
			if(arg0.getSource()==memberIdTxtField){
				try {
					memberSearchExec();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}else if(arg0.getSource()==loyalUseTxtField){
				calcLoyalPoint();
			}else if(arg0.getSource()==barcodeTxtField){
				addPurchaseExec();
			}else if(arg0.getSource()==quantityTxtField){
				addPurchaseExec();
				barcodeTxtField.grabFocus();
			}else if(arg0.getSource()==cashTxtField){
				checkCash();
				payBtn.grabFocus();
			}
		}
	}
	
	private boolean checkCash(){
		if(cashTxtField.getText().equals("")||!ViewUtil.isJTextNumberical(cashTxtField)){
			JOptionPane.showMessageDialog(null, "The Cash Is Invalid", "Error", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		double receivedCash=Float.parseFloat(cashTxtField.getText());
		if(receivedCash>=cash){
			return true;
		}else{
			cashTxtField.setText(cash+"");
			JOptionPane.showMessageDialog(null, "The Cash is not enough", "Error", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		
	}
	/**
	 * Method name: payExec <BR>
	 * Description: Pay Execute <BR>
	 * Remark: <BR>  void<BR>
	 */
	private void payExec(){
		String receivedCash="";
		if(transList.size()==0){
			JOptionPane.showMessageDialog(null, "Nothing in the list", "Error", JOptionPane.ERROR_MESSAGE);
			return;
		}

		if(!this.checkLoyalPoint()){
			loyalUseTxtField.setText("0");
			JOptionPane.showMessageDialog(null, "No Enough Point", "Error", JOptionPane.ERROR_MESSAGE);
			return;
		}
		if(!this.checkCash()){
			cashTxtField.setText(cash+"");
			//JOptionPane.showMessageDialog(null, "The Cash is not enough", "Error", JOptionPane.ERROR_MESSAGE);
			return;
		}else{
			receivedCash=cashTxtField.getText();
		}
		reCalcPrice();

		//double cash=Float.parseFloat(cashTxtField.getText());
		double actualPrice=Float.parseFloat(actualTxtField.getText());
		double totalPrice=Float.parseFloat(totalTxtField.getText());

		if(memberBean!=PaymentService.nonMember){
			if(memberBean.getLoyaltyPoint().equals("-1")){
				memberBean.setLoyaltyPoint("0");
			}
			int redeem=Integer.parseInt(loyalUseTxtField.getText());
			int currentloyPoint=Integer.parseInt(memberBean.getLoyaltyPoint());
			currentloyPoint=currentloyPoint-redeem+RedeemConfig.intdoolar2Redeem((int)cash);
			memberBean.setLoyaltyPoint(currentloyPoint+"");
			payService.updateMemberInfo(memberBean);
		}
		payService.addTransactionInfo(transList);
		List<HashMap<String,String>> viewList=new ArrayList<HashMap<String,String>>();
		for(TransactionBean transBean:transList){
			HashMap<String,String>viewMap=new HashMap<String,String>();
			ProductBean productBean=payService.getProductBeanById(transBean.getProductId());
			int quantityAvailable=str2Int(productBean.getQuantityAvailable());
			viewMap.put("Name", productBean.getName());
			viewMap.put("Quantity", transBean.getQuantityPurchased());
			viewMap.put("Unit Price", productBean.getPrice());
			double singlePrice=Float.parseFloat(productBean.getPrice());
			int purchaseNum=str2Int(transBean.getQuantityPurchased());
			viewMap.put("Total", (singlePrice*purchaseNum)+"");
			productBean.setQuantityAvailable((quantityAvailable-purchaseNum)+"");
			payService.updateProduct(productBean);
			viewList.add(viewMap);
		}
		
		Entry<String,String>addInfo=new AbstractMap.SimpleEntry<String,String>("Store Keeper:",Session.getSession("UserName"));
		HashMap<String,String>viewMap=new HashMap<String,String>();
		viewMap.put("Name", "In Total");
		viewMap.put("Total",totalPrice+"");
		viewList.add(viewMap);
		viewMap=new HashMap<String,String>();
		viewMap.put("Name", "Discount");
		viewMap.put("Total",discountTxtField.getText());
		viewList.add(viewMap);
		viewMap=new HashMap<String,String>();
		viewMap.put("Name", "Actual");
		viewMap.put("Total",actualPrice+"");
		viewList.add(viewMap);
		viewMap=new HashMap<String,String>();
		viewMap.put("Name", "Redeem");
		viewMap.put("Quantity", loyalUseTxtField.getText());
		viewMap.put("Total","-"+RedeemConfig.redeem2Dollar(str2Int(loyalUseTxtField.getText())));
		viewList.add(viewMap);
		viewMap=new HashMap<String,String>();
		viewMap.put("Name", "Cash");
		viewMap.put("Total",cash+"");
		viewList.add(viewMap);
		viewMap=new HashMap<String,String>();
		viewMap.put("Name", "Received");
		viewMap.put("Total",receivedCash);
		viewList.add(viewMap);
		viewMap=new HashMap<String,String>();
		viewMap.put("Name", "Change");
		viewMap.put("Total",(Float.parseFloat(receivedCash)-cash)+"");
		viewList.add(viewMap);
		String[] receiptTableHeader=new String [] {"Name", "Quantity", "Unit Price", "Total"};
		ViewManager.goToSubFunctionScreen(new PrintPanel(StringUtil.transStringArr2List(receiptTableHeader),viewList,addInfo));
		
	}
	
	/**
	 * Method name: addPurchaseExec <BR>
	 * Description: Add Purchase Execute <BR>
	 * Remark: <BR>  void<BR>
	 */
	private void addPurchaseExec(){
		if(memberBean==null){
			JOptionPane.showMessageDialog(null, "Please Enter ID First", "Error", JOptionPane.ERROR_MESSAGE);
			return;
		}
		String productId=barcodeTxtField.getText();
		
		
		ProductBean productBean=payService.getProductBeanById(productId);
		if(productBean==null){
			JOptionPane.showMessageDialog(null, "Product Id Error", "Error", JOptionPane.ERROR_MESSAGE);
			return;
		}
		int quantityPurchased=str2Int(quantityTxtField.getText());
		int quantityRemained=str2Int(productBean.getQuantityAvailable());
		if(quantityRemained<quantityPurchased){
			JOptionPane.showMessageDialog(null, "No Enough Products In The Store", "Error", JOptionPane.ERROR_MESSAGE);
			return;
		}
		TransactionBean transBean=searchTransListByProductId(productBean.getId());
		if(transBean==null){
			transBean=new TransactionBean();
			transBean.setDate(TimeUtil.GetCurrentTime().toString("Y-M-D"));
			transBean.setId(generateTransId()+"");
			transBean.setMemberId(memberBean.getId());
			transBean.setProductId(productBean.getId());
			transBean.setQuantityPurchased(quantityTxtField.getText());
			if(this.str2Int(productBean.getQuantityAvailable())-str2Int(quantityTxtField.getText())<this.str2Int(productBean.getReorderQuantity())){
				this.alertLowStorage(productBean.getName(),(this.str2Int(productBean.getQuantityAvailable())-str2Int(quantityTxtField.getText()))+"", productBean.getReorderQuantity());
			}
			transList.add(transBean);
		}else{
			String currentQuantity=transBean.getQuantityPurchased();
			String newQuantity=(str2Int(currentQuantity)+str2Int(quantityTxtField.getText()))+"";
			transBean.setQuantityPurchased(newQuantity);
		}
		refreshTransactionTable();
		reCalcPrice();
		
	}
	
	/**
	 * Method name: reCalcPrice <BR>
	 * Description: Calculate Total Price <BR>
	 * Remark: <BR>  void<BR>
	 */
	private void reCalcPrice(){
		double totalPriceSum=0;
		for(TransactionBean transBean:transList){

			ProductBean productBean=payService.getProductBeanById(transBean.getProductId());

			double singlePrice=Float.parseFloat(productBean.getPrice());
			double purchaseNum=str2Int(transBean.getQuantityPurchased());
			double totalPrice=singlePrice*purchaseNum;
			totalPriceSum+=totalPrice;
		}
		totalTxtField.setText(totalPriceSum+"");
		String discountStr=discountTxtField.getText();
		discountStr=discountStr.substring(0, discountStr.length()-1);
		double actualPrice=totalPriceSum*(1-(double)str2Int(discountStr)/100.0);
		actualTxtField.setText(actualPrice+"");
		cash=actualPrice-RedeemConfig.redeem2Dollar(str2Int(loyalUseTxtField.getText()));
		cashTxtField.setText(cash+"");
		
	}
	
	/**
	 * Method name: refreshTransactionTable <BR>
	 * Description: Refresh Transaction Table <BR>
	 * Remark: <BR>  void<BR>
	 */
	private void refreshTransactionTable(){
		List<HashMap<String,String>> viewList=new ArrayList<HashMap<String,String>>();
		for(TransactionBean transBean:transList){
			HashMap<String,String>viewMap=new HashMap<String,String>();
			ProductBean productBean=payService.getProductBeanById(transBean.getProductId());
			viewMap.put("Name", productBean.getName());
			viewMap.put("Quantity", transBean.getQuantityPurchased());
			viewMap.put("Price", productBean.getPrice());
			double singlePrice=Float.parseFloat(productBean.getPrice());
			double purchaseNum=str2Int(transBean.getQuantityPurchased());
			viewMap.put("Total Price", (singlePrice*purchaseNum)+"");
			viewList.add(viewMap);
		}
		transPanel.setModel(ViewUtil.transferMapListToDTModel(StringUtil.transStringArr2List(TransactionTableHeader), viewList));
	}
	
	/**
	 * Method name: searchTransListByProductId <BR>
	 * Description: Search Transaction List By Product ID <BR>
	 * Remark: <BR>
	 * @param productId
	 * @return  TransactionBean<BR>
	 */
	private TransactionBean searchTransListByProductId(String productId){
		for(TransactionBean transBean:transList){
			String transProductId=transBean.getProductId();
			if(transProductId.equals(productId)){
				return transBean;
			}
		}
		return null;
	}
	
	/**
	 * Method name: generateTransId <BR>
	 * Description: Get Auto-Increased Transaction ID <BR>
	 * Remark: <BR>
	 * @return  int<BR>
	 */
	private int generateTransId(){
		int currentMaxId=0;
		if(transList.size()==0){
			return payService.getMaxTransId();
		}
		for(TransactionBean transBean:transList){
			String id=transBean.getId();
			if(this.str2Int(id)>currentMaxId){
				currentMaxId=Integer.parseInt(id);
			}
		}
		return currentMaxId+1;
	}
	
	/**
	 * Method name: alertLowStorage <BR>
	 * Description: Check If The Product Is Lower Than Threshold <BR>
	 * Remark: <BR>
	 * @param productName
	 * @param currentQuantity
	 * @param threshold  void<BR>
	 */
	private void alertLowStorage(String productName,String currentQuantity,String threshold){
		JOptionPane.showMessageDialog(null, "The Product:"+productName+" is  lower than threshold,Current storage:"+currentQuantity+" threshold:"+threshold, "Low Storage", JOptionPane.OK_OPTION);
	}
	
	/**
	 * Method name: memberSearchExec <BR>
	 * Description: Member Search Execute <BR>
	 * Remark: <BR>
	 * @throws NumberFormatException
	 * @throws IllegalArgumentException
	 * @throws Exception  void<BR>
	 */
	private void memberSearchExec() throws NumberFormatException, IllegalArgumentException, Exception{
		String memberId=memberIdTxtField.getText();
		if(payService.isMember(memberId)){
			memberBean=payService.getMemberById(memberId);
			loyalUseTxtField.setEnabled(true);
		}else{
			memberBean=PaymentService.nonMember;
			loyalUseTxtField.setText("0");
		}
		discountBean=payService.getBestDiscountByMemberBean(memberBean);
		List<HashMap<String,String>>paramList=new ArrayList<HashMap<String,String>>();
		HashMap<String,String>map=new HashMap<String,String>();
		map.put("Param", "Member Name:");
		map.put("Value", memberBean.getName());
		paramList.add(map);
		map=new HashMap<String,String>();
		map.put("Param", "Member ID:");
		map.put("Value", memberBean.getId());
		paramList.add(map);
		map=new HashMap<String,String>();
		map.put("Param", "Loyalty Point:");
		map.put("Value", memberBean.getLoyaltyPoint());
		paramList.add(map);
		map=new HashMap<String,String>();
		map.put("Param", "Discount Available");
		if(discountBean==null){
			map.put("Value", "None");
			discountTxtField.setText("0%");
		}else{
			map.put("Value", discountBean.getDescription());
			discountTxtField.setText(discountBean.getDiscountPercentage()+"%");
		}
		
		paramList.add(map);
		
		memberInfoTable.setModel(ViewUtil.transferMapListToDTModel(StringUtil.transStringArr2List(MemberTableHeader), paramList));
		memberIdTxtField.setEnabled(false);
		barcodeTxtField.setEnabled(true);
		quantityTxtField.setEnabled(true);
		cashTxtField.setEnabled(true);
		barcodeTxtField.grabFocus();
		
	}
	
	/**
	 * Method name: str2Int <BR>
	 * Description: Transfer String To Integer <BR>
	 * Remark: <BR>
	 * @param str
	 * @return  int<BR>
	 */
	private int str2Int(String str){
		return Integer.parseInt(str);
	}
	
	/**
	 * Method name: calcLoyalPoint <BR>
	 * Description: Calculate LoyalPoint <BR>
	 * Remark: <BR>  void<BR>
	 */
	private void calcLoyalPoint(){
		
		if(!this.checkLoyalPoint()){
			loyalUseTxtField.setText("0");
			JOptionPane.showMessageDialog(null, "No Enough Point", "Error", JOptionPane.ERROR_MESSAGE);
			return;
		}
		reCalcPrice();
		loyalUseTxtField.transferFocus();
	}
	
	/**
	 * Method name: checkLoyalPoint <BR>
	 * Description: Check LoyalPoint <BR>
	 * Remark: <BR>
	 * @return  boolean<BR>
	 */
	private boolean checkLoyalPoint(){
		int lp=str2Int(memberBean.getLoyaltyPoint());
		return (payService.isNewMember(memberBean.getId())&&lp==-1)||(str2Int(loyalUseTxtField.getText())<=lp);
	}
	
	@Override
	public void keyTyped(KeyEvent arg0) {
	}
	
	@Override
	public void keyPressed(KeyEvent arg0) {
	}

	/**
	 * @Override
	 * @see java.awt.event.FocusListener#focusGained(java.awt.event.FocusEvent) <BR>
	 * Method name: focusGained <BR>
	 * Description: Initialization <BR>
	 * Remark: <BR>
	 * @param arg0  <BR>
	*/
	@Override
	public void focusGained(FocusEvent arg0) {
		if(arg0.getSource()==loyalUseTxtField&&loyalUseTxtField.getText().equals("0")){
			loyalUseTxtField.setText("");
		}else if(arg0.getSource()==memberIdTxtField){
				memberIdTxtField.setText("");
		}else if(arg0.getSource()==barcodeTxtField){
			barcodeTxtField.setText("");
		}else if(arg0.getSource()==cashTxtField){
			cashTxtField.setText("");
		}
		
	}

	/**
	 * @Override
	 * @see java.awt.event.FocusListener#focusLost(java.awt.event.FocusEvent) <BR>
	 * Method name: focusLost <BR>
	 * Description: Initialization <BR>
	 * Remark: <BR>
	 * @param arg0  <BR>
	*/
	@Override
	public void focusLost(FocusEvent arg0) {
		if(arg0.getSource()==loyalUseTxtField){
			if(loyalUseTxtField.getText().equals("")){
				loyalUseTxtField.setText("0");
			}
			calcLoyalPoint();
		}else if(arg0.getSource()==memberIdTxtField){
			if(memberIdTxtField.getText().equals("")){
				memberIdTxtField.setText("Student/Staff ID");
			}
		}else if(arg0.getSource()==barcodeTxtField){
			if(barcodeTxtField.getText().equals("")){
				barcodeTxtField.setText("Product No.");
			}
		}else if(arg0.getSource()==cashTxtField){
			if(cashTxtField.getText().equals("")||!ViewUtil.isJTextDecimal(cashTxtField)){
				cashTxtField.setText(cash+"");
			}else{
				checkCash();
			}
		}
		
	}

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
		try {
			ViewManager.refreshCurrentPanel();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		
	}


	
}
