package com.ft9.view.panel;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JLabel;
import javax.swing.JTextField;

import com.ft9.annotation.Menu;
import com.ft9.service.IPaymentService;
import com.ft9.service.ServiceManager;
import com.ft9.service.ServiceNotFoundException;
import com.ft9.service.impl.PaymentService;
import com.ft9.view.ViewManager;

/**
*
* @author apple
*/
@Menu(name = "Checkout", fatherName = "Payment")
public class PaymentPanel extends javax.swing.JPanel implements KeyListener {

   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private IPaymentService payService=null;
/**
    * Creates new form PaymentPanel
 * @throws ServiceNotFoundException 
    */
   public PaymentPanel() throws ServiceNotFoundException {
	   payService=(PaymentService)ServiceManager.getService("Payment");
       initComponents();
   }

   /**
    * This method is called from within the constructor to initialize the form.
    * WARNING: Do NOT modify this code. The content of this method is always
    * regenerated by the Form Editor.
    */
   @SuppressWarnings("unchecked")
   // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
   private void initComponents() {

       jScrollPane1 = new javax.swing.JScrollPane();
       memberInfoTable = new javax.swing.JTable();
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
       goToHomeBtn = ViewManager.createGoHomeButton();
       payBtn = new javax.swing.JButton();

       memberInfoTable.setModel(new javax.swing.table.DefaultTableModel(
           new Object [][] {},
           new String [] {
               "Param","Value"
           }
       ));
       jScrollPane1.setViewportView(memberInfoTable);

       transPanel.setModel(new javax.swing.table.DefaultTableModel(
           new Object [][] {
               {null, null, null, null},
               {null, null, null, null},
               {null, null, null, null},
               {null, null, null, null}
           },
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
       cashTxtField.setText("0");
       cashTxtField.setEnabled(false);
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
       barcodeTxtField.setText("Barcode No.");
       barcodeTxtField.addKeyListener(this);
       quantityTxtField.setText("1");
       quantityTxtField.addKeyListener(this);
       clearBtn.setText("Clear");
     //  goToHomeBtn.setText("MainMenu");

       payBtn.setText("Pay");

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
   }// </editor-fold>                        


   // Variables declaration - do not modify                     
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
   // End of variables declaration                   

	public void keyReleased(KeyEvent arg0) {
		// TODO 自动生成的方法存根
		if(arg0.getKeyCode()==KeyEvent.VK_ENTER){
			if(arg0.getSource()==memberIdTxtField){
				memberSearchExec();
			}else if(arg0.getSource()==loyalUseTxtField){
				calcLoyalPoint();
			}
		}
	}
	
	private void memberSearchExec(){
		System.out.println("MemberSearch");
		barcodeTxtField.grabFocus();
		
	}
	private void calcLoyalPoint(){
		loyalUseTxtField.transferFocus();
	}
	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO 自动生成的方法存根
		
	}
	
	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO 自动生成的方法存根
		
	}
	
}
