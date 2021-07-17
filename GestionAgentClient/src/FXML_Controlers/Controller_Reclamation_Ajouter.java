package FXML_Controlers;

import java.sql.SQLException;

import DB_Connection.DBConnection;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class Controller_Reclamation_Ajouter {
	@FXML
    private AnchorPane AnchorPane_Chat_changed;
	@FXML
    private TextField textfield_sujet;

    @FXML
    private TextArea textarea_description;

    @FXML
    void Pressed_ON_ajouter(MouseEvent event) throws NumberFormatException, SQLException {
    	DBConnection.add_reclamation(textfield_sujet.getText(), textarea_description.getText(), Integer.parseInt(Controller_Home_Client.static_client_id.getText()));
    	textfield_sujet.setText("");
    	textarea_description.setText("");
    }


   

}
