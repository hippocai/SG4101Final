import java.io.FileNotFoundException;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import com.ft9.dao.DAOer;
import com.ft9.service.ServiceManager;
import com.ft9.view.ViewManager;
import com.ft9.view.frame.LoginDiagram;


public class Main {
	public static void main(String[] args) {
		 try {  
			 initWork();
			 LoginDiagram.showLoginDiagram();
          }catch(FileNotFoundException fe){
        	 fe.printStackTrace();
        	  JOptionPane.showMessageDialog(null, fe.getMessage(), "File Error", JOptionPane.ERROR_MESSAGE);
          }catch (Exception e) {  
        	  JOptionPane.showMessageDialog(null, e.getMessage(), "Fatal Error", JOptionPane.ERROR_MESSAGE);
        	  e.printStackTrace();
          }  
		
	}
	
	public static void initWork() throws FileNotFoundException,Exception{
		DAOer.initDao();
		ServiceManager.init();
		ViewManager.initViews();
		System.setProperty("Quaqua.design","Lion");
		UIManager.setLookAndFeel("ch.randelshofer.quaqua.QuaquaLookAndFeel");
	}

}
