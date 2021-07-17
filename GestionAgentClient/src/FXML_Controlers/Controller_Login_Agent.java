package FXML_Controlers;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;

import Algorithms.Stage_Interface;
import DB_Connection.DBConnection;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;
import tray.animations.AnimationType;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;

public class Controller_Login_Agent implements Initializable{
	@FXML
	    private JFXTextField textfield_username;

	    @FXML
	    private JFXTextField textfield_password;

	    @FXML
	    private JFXCheckBox checkbox;

	    @FXML
	    private JFXPasswordField Password;
	    
	    private AnimationType type;
	    private TrayNotification tray = new TrayNotification();
	    private Stage_Interface stage_obj = new Stage_Interface();
    @Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
    	checkbox.setFocusTraversable(false);
    	textfield_username.requestFocus();
	}
    @FXML
    void ClickOnEnter(ActionEvent event) throws SQLException, IOException {
    	agentt_login();
    	
    }
    
    @FXML
    void Show_password(ActionEvent event) {
    	if(Password.isVisible()) {
    		textfield_password.setVisible(true);
    		Password.setVisible(false);
    		textfield_password.setText(Password.getText());
    		
    	}else {
    		Password.setVisible(true);
    		textfield_password.setVisible(false);
    		Password.setText(textfield_password.getText());
    	}
    }
    
    @FXML
    void Reset_Password(MouseEvent event) throws IOException {
    	Stage_Interface.type="agent";
    	stage_obj = new Stage_Interface("Reset_Password", 350, 400);
    	stage_obj.show_interface();

    }
    void agentt_login() throws SQLException, IOException {
    	if(checkbox.isSelected()) {
    		agent_checking_information(textfield_username.getText().trim(), textfield_password.getText());
    	}else {
    		agent_checking_information(textfield_username.getText().trim(), Password.getText());
    	}
    }
    void agent_checking_information(String username,String password) throws SQLException, IOException {
    	if(DBConnection.Agent_login(username, password)) {
    		Controller_Home_Agent.static_agent_id=DBConnection.get_agent_id(username);
    		System.out.println("Agnet is logged in, msg from Controller_Login_Agent");
    		Controller_Home_Agent.static_username=username;
    		stage_obj = new Stage_Interface("Home_Agent", 1256, 600);
	    	stage_obj.show_interface();
    	}else {
    		type = AnimationType.POPUP;
			tray.setAnimationType(type);
    		tray.setTitle("Login échoue");
        	tray.setMessage("Nom d'utilisateur ou Mot de passe est incorrect");
        	tray.setNotificationType(NotificationType.ERROR);
        	tray.showAndDismiss(Duration.millis(3000));
    	}
    }
    @FXML
    void Pressed_REeleased_On_textfield_username(KeyEvent event) {
    	if(event.getCode()==KeyCode.TAB) {
    		if(checkbox.isSelected()) {
        		textfield_password.requestFocus();
        	}else {
        		Password.requestFocus();
        	}
    	}
    }
    
    @FXML
    void Pressed_ON_Password(KeyEvent event) throws SQLException, IOException {
    	if(event.getCode()==KeyCode.ENTER) {
    		agentt_login();
    		Password.requestFocus();
    	}
    }

    @FXML
    void Pressed_On_text_Password(KeyEvent event) throws SQLException, IOException {
    	if(event.getCode()==KeyCode.ENTER) {
    		agentt_login();
    		textfield_password.requestFocus();
    	}
    }

}
