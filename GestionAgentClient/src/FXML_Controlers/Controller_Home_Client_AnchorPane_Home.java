package FXML_Controlers;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class Controller_Home_Client_AnchorPane_Home {
	@FXML
    private AnchorPane AnchorPane_Home_changed;

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

}
