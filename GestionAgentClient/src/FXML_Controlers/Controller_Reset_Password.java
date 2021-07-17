package FXML_Controlers;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXTextField;

import Algorithms.Stage_Interface;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class Controller_Reset_Password implements Initializable {
	@FXML
    private Button round_red;

    @FXML
    private Label changed_label_1;

    @FXML
    private JFXTextField textfield;

    @FXML
    private Label changed_label_2;
    
    


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		detect_user_type();
		
	}
	
	public void detect_user_type() {
		if(Stage_Interface.type == "agent") {
			changed_label_1.setText("Pas de probleme! Tapper votre ID.");
			changed_label_2.setVisible(true);
			changed_label_1.setLayoutX(changed_label_1.getLayoutX()+6);
		}
	}
	
    
    

}
