package FXML_Controlers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;

import Algorithms.Stage_Interface;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class Controller_Login_Client implements Initializable{
	@FXML
    public AnchorPane AnchorPane_Chnageable;
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		try {
			
			AnchorPane_Chnageable.getChildren().clear();
			AnchorPane_Chnageable.getChildren().add(FXMLLoader.load(getClass().getResource("/FXML/Login_Client_Page.fxml")));
			AnchorPane_Chnageable.setLayoutX(355);
			AnchorPane_Chnageable.setLayoutY(0);
	
			} catch (Exception e) {
		// TODO: handle exception
			}
		
		}

	

}
