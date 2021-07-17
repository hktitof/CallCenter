package FXML_Controlers;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import DB_Connection.DBConnection;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class Controller_Home_Agent implements Initializable{
	@FXML
    private Label label_username;
	@FXML
    private Label label_agent_id;

    @FXML
    private AnchorPane AnchorPane_Home_changed;
    public static AnchorPane static_AnchorPane_Home_changed=new AnchorPane();
    public static String static_agent_id;
    public static Label static_label_agent_id;
    @Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
    	static_label_agent_id=label_agent_id;
    	static_label_agent_id.setText(static_agent_id);
    	label_username.setText(static_username);
    	static_AnchorPane_Home_changed=AnchorPane_Home_changed;
	}
	public static String static_username;
    @FXML
    void Click_ON_Chat_En_ligne(MouseEvent event) {
    	
    	try {
			
    		static_AnchorPane_Home_changed.getChildren().clear();
    		static_AnchorPane_Home_changed.getChildren().add(FXMLLoader.load(getClass().getResource("/FXML/Chat_Agent_page_start_receiving.fxml")));
			} catch (Exception e) {
		// TODO: handle exception
			e.printStackTrace();
			}
    	
    }

}
