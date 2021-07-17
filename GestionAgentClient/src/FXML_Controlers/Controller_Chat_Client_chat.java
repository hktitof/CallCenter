package FXML_Controlers;



import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import Chat.Client_checking_cnv_with_val_and_page_is_open;
import DB_Connection.DBConnection;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

public class Controller_Chat_Client_chat implements Initializable{
	@FXML
    private Label label_cnv_effectue;
	@FXML
    private Button button_demander;
	public static Boolean static_chat_client_page_open_verification;
	
	@Override
	public void initialize(URL location, ResourceBundle resources){
		// TODO Auto-generated method stub
		static_chat_client_page_open_verification=true;
			try {
				if(DBConnection.verification_client_cnv_current_status(Integer.parseInt(Controller_Home_Client.static_client_id.getText()))) {
					label_cnv_effectue.setVisible(true);
					button_demander.setDisable(true);
				}else {
					label_cnv_effectue.setVisible(false);
					button_demander.setDisable(false);
				}
			} catch (NumberFormatException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}
	@FXML
    void Clicked_On_demande(MouseEvent event) throws SQLException {
		DBConnection.Set_client_cnv_status_to_true(Integer.parseInt(Controller_Home_Client.static_client_id.getText()));
		ExecutorService executor=Executors.newFixedThreadPool(1);
		executor.submit(new Client_checking_cnv_with_val_and_page_is_open());
		label_cnv_effectue.setVisible(true);
		button_demander.setDisable(true);
    }

	
   
    
    
   

}
