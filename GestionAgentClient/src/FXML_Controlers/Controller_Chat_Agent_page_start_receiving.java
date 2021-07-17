package FXML_Controlers;

import java.sql.SQLException;

import DB_Connection.DBConnection;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.input.MouseEvent;

public class Controller_Chat_Agent_page_start_receiving {
	@FXML
    private AnchorPane AnchorPane_Changeable;
	@FXML
    void Pressed_On_demarrer(MouseEvent event) throws SQLException {
		try {
			
    		AnchorPane_Changeable.getChildren().clear();
    		AnchorPane_Changeable.getChildren().add(FXMLLoader.load(getClass().getResource("/FXML/Chat_Agent_Home.fxml")));
    		AnchorPane_Changeable.setLayoutX(0);
    		AnchorPane_Changeable.setLayoutY(0);
    		Controller_Chat_Agent_Home.static_stop_refreshig_list_requests=true;
	
			} catch (Exception e) {
		// TODO: handle exception
			e.printStackTrace();
			}
		DBConnection.Set_agent_status_to_online(Controller_Home_Agent.static_username);
		
    }

}
