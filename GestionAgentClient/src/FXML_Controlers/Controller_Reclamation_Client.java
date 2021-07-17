package FXML_Controlers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class Controller_Reclamation_Client implements Initializable{

	@FXML
	    private AnchorPane AnchorPane_Chat_changed;
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		AnchorPane_Chat_changed.getChildren().clear();
		try {
			AnchorPane_Chat_changed.getChildren().add(FXMLLoader.load(getClass().getResource("/FXML/Reclamation_Ajouter.fxml")));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	 @FXML
	    void Pressed_ON_Ajouter(MouseEvent event) {
	    	AnchorPane_Chat_changed.getChildren().clear();
			try {
				AnchorPane_Chat_changed.getChildren().add(FXMLLoader.load(getClass().getResource("/FXML/Reclamation_Ajouter.fxml")));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	    }
	    
	    @FXML
	    void Pressed_ON_Modifier(MouseEvent event) {
	    	AnchorPane_Chat_changed.getChildren().clear();
			try {
				AnchorPane_Chat_changed.getChildren().add(FXMLLoader.load(getClass().getResource("/FXML/Reclamation_Modifier.fxml")));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }

}
