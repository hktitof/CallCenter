package FXML_Controlers;

import java.io.IOException;
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

public class Controller_Home_Client implements Initializable {
	@FXML
    private AnchorPane AnchorPane_Home_changed;
	@FXML
    private Label label_username;
	 @FXML
	private Label label_client_id;
	public static Label static_label_username;
	public static String static_username=null;
	public static Label static_client_id;
	public static String static_client_id_string;
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		static_label_username=label_username;
		static_label_username.setText(static_username);
		static_client_id=label_client_id;
		try {
			static_client_id.setText(DBConnection.get_id_client(static_client_id_string));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@FXML
    void Click_ON_Chat_En_ligne(MouseEvent event) throws IOException {
		AnchorPane_Home_changed.getChildren().clear();
		AnchorPane_Home_changed.getChildren().add(FXMLLoader.load(getClass().getResource("/FXML/Chat_Client.fxml")));

    }
	@FXML
    void Pressed_On_Reclamation(MouseEvent event) throws IOException {
		AnchorPane_Home_changed.getChildren().clear();
		AnchorPane_Home_changed.getChildren().add(FXMLLoader.load(getClass().getResource("/FXML/Client_Reclamation.fxml")));

    }
	@FXML
    void Pressed_On_Home_icon(MouseEvent event) throws IOException {
		AnchorPane_Home_changed.getChildren().clear();
		AnchorPane_Home_changed.getChildren().add(FXMLLoader.load(getClass().getResource("/FXML/Home_Client_AnchorPane_Home.fxml")));
    }


}
