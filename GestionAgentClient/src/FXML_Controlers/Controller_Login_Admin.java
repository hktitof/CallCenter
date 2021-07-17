package FXML_Controlers;

import java.io.IOException;
import java.sql.SQLException;

import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;

import Algorithms.Stage_Interface;
import DB_Connection.DBConnection;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;
import tray.animations.AnimationType;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;

public class Controller_Login_Admin {
	@FXML
    private JFXTextField textfield1;
	
	@FXML
    private JFXTextField textfield_2;

    @FXML
    private JFXPasswordField Password;
    @FXML
    private JFXCheckBox checkbox;
    
    private AnimationType type;
    private TrayNotification tray = new TrayNotification();
    
    @FXML
    void show_password(ActionEvent event) {
    	if(Password.isVisible()) {
    		textfield_2.setVisible(true);
    		Password.setVisible(false);
    		textfield_2.setText(Password.getText());
    		
    	}else {
    		Password.setVisible(true);
    		textfield_2.setVisible(false);
    		Password.setText(textfield_2.getText());
    	}
    }
    @FXML
    void Pressed_ON_Enter(MouseEvent event) throws SQLException, IOException {
    	if(checkbox.isSelected()) {
    		if(DBConnection.login_admin(textfield1.getText(), textfield_2.getText())) {
    			System.out.println("Admin succefully loged in");
    			((Stage)(((Button)event.getSource()).getScene().getWindow())).close(); 
				Stage primaryStage=new Stage();
	    		Parent root = FXMLLoader.load(getClass().getResource("/FXML_Admin/Home_Admin.fxml"));
	    		Scene scene = new Scene(root,900,500);
	    		scene.setFill(Color.TRANSPARENT);
	    		primaryStage.setScene(scene);
//	    		primaryStage.initStyle(StageStyle.TRANSPARENT);
	    		primaryStage.show();
    		}else {
    			show_error_login();
    		}
    	}else {
    		if(DBConnection.login_admin(textfield1.getText(), Password.getText())) {
    			System.out.println("Admin succefully logged in");
    			((Stage)(((Button)event.getSource()).getScene().getWindow())).close(); 
    			Stage primaryStage=new Stage();
	    		Parent root = FXMLLoader.load(getClass().getResource("/FXML_Admin/Home_Admin.fxml"));
	    		Scene scene = new Scene(root,900,500);
	    		scene.setFill(Color.TRANSPARENT);
	    		primaryStage.setScene(scene);
//	    		primaryStage.initStyle(StageStyle.TRANSPARENT);
	    		primaryStage.show();
    		}else {
    			show_error_login();
    		}
    	}

    }
	void show_error_login() {
		type = AnimationType.POPUP;
		tray.setAnimationType(type);
		tray.setTitle("Login échoue");
    	tray.setMessage("Nom d'utilisateur ou Mot de passe est incorrect");
    	tray.setNotificationType(NotificationType.ERROR);
    	tray.showAndDismiss(Duration.millis(3000));
	}
	

}
