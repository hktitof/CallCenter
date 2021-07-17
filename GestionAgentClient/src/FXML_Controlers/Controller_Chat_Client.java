package FXML_Controlers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class Controller_Chat_Client implements Initializable{
	@FXML
    private AnchorPane AnchorPane_Chat_changed;
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		AnchorPane_Chat_changed.getChildren().clear();
		try {
			AnchorPane_Chat_changed.getChildren().add(FXMLLoader.load(getClass().getResource("/FXML/Chat_Client_chat.fxml")));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@FXML
    void click_on_Chat_en_ligne(MouseEvent event) throws IOException {
		AnchorPane_Chat_changed.getChildren().clear();
		AnchorPane_Chat_changed.getChildren().add(FXMLLoader.load(getClass().getResource("/FXML/Chat_Client_chat.fxml")));

    }
	@FXML
    void Pressed_On_Home_icon(MouseEvent event) throws IOException {
		AnchorPane_Chat_changed.getChildren().clear();
		AnchorPane_Chat_changed.getChildren().add(FXMLLoader.load(getClass().getResource("/FXML/Chat_Client_chat.fxml")));
    }

}
