package FXML_Controlers;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import com.sun.media.jfxmediaimpl.platform.Platform;

import Algorithms.Stage_Interface;
import DB_Connection.DBConnection;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.stage.WindowEvent;
import javafx.util.Duration;
import tray.animations.AnimationType;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;

public class Controller_Login_Client2 implements Initializable{
	
	@FXML
    private AnchorPane AnchorPane_Changeable;

    @FXML
    private Button Enter_button;

    @FXML
    private Button Quitter_button;

    @FXML
    private JFXTextField textfield_1;

    @FXML
    private JFXTextField textfield_2;

    @FXML
    private Label Forgot_Label;

    @FXML
    private Label Register_Label;
    @FXML
    private JFXPasswordField Password;
    @FXML
    private JFXCheckBox checkBox;
    private AnimationType type;
    private TrayNotification tray = new TrayNotification();
    private Stage_Interface stage_obj = new Stage_Interface();
    @Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
    	checkBox.setFocusTraversable(false);
    	textfield_1.requestFocus();
	}
    @FXML
    void Show_Password(ActionEvent event) {
    	if(Password.isVisible()) {
    		textfield_2.setVisible(true);
    		Password.setVisible(false);
    		textfield_2.setText(Password.getText());
    		
    	}else {
    		Password.setVisible(true);    		textfield_2.setVisible(false);
    		Password.setText(textfield_2.getText());
    	}

    }
    
    @FXML
    void pressed_mouse(MouseEvent event) throws IOException {
    	Stage_Interface.type="client";
    	stage_obj = new Stage_Interface("Reset_Password", 350, 400);
    	stage_obj.show_interface();
    	
    }
    
    @FXML
    void Click_ON_Register(MouseEvent event) {
    	try {
			
    		AnchorPane_Changeable.getChildren().clear();
    		AnchorPane_Changeable.getChildren().add(FXMLLoader.load(getClass().getResource("/FXML/Registration_Page.fxml")));
    		AnchorPane_Changeable.setLayoutX(0);
    		AnchorPane_Changeable.setLayoutY(0);
	
			} catch (Exception e) {
		// TODO: handle exception
			e.printStackTrace();
			}
    	}
    @FXML
    void Click_on_Enter(ActionEvent event) throws Exception {

    	if(checkBox.isSelected()) {
    		client_login(textfield_1.getText().trim(), textfield_2.getText());
    	}else {
    		client_login(textfield_1.getText(), Password.getText());
    	}
    	((Stage)(((Button)event.getSource()).getScene().getWindow())).close(); 
    }
    @FXML
    void Pressed_ON_Password(KeyEvent event) throws SQLException, IOException {
    	if(event.getCode() == KeyCode.ENTER) {
    		if(checkBox.isSelected()) {
        		client_login(textfield_1.getText().trim(), textfield_2.getText());
        	}else {
        		client_login(textfield_1.getText(), Password.getText());
        		
        	}
    		((Stage)(((TextField)event.getSource()).getScene().getWindow())).close(); 
    	}
    	
    }
    
    void client_login(String username,String password) throws SQLException, IOException {
    	if(DBConnection.Client_login(username, password)) {
    		System.out.println("Client account is found, msg from controller_login_clinet2");
    		Controller_Home_Client.static_username=username;
    		Controller_Home_Client.static_client_id_string=username;
    		DBConnection.Update_last_login_Client(username);
    		Stage primaryStage=new Stage();
    		Parent root = FXMLLoader.load(getClass().getResource("/FXML/Home_Client.fxml"));
    		Scene scene = new Scene(root,1256,600);
    		scene.setFill(Color.TRANSPARENT);
    		primaryStage.setScene(scene);
//    		primaryStage.initStyle(StageStyle.TRANSPARENT);
    		primaryStage.show();
    		Rectangle2D primScreenBounds = Screen.getPrimary().getVisualBounds();
            primaryStage.setX((primScreenBounds.getWidth() - primaryStage.getWidth()) / 2);
            primaryStage.setY((primScreenBounds.getHeight() - primaryStage.getHeight()) / 2);
            primaryStage.show();
            primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
				
				@Override
				public void handle(WindowEvent event) {
					// TODO Auto-generated method stub
					Controller_Chat_Client_chat.static_chat_client_page_open_verification=false;
					System.out.println("the program is closed");
					javafx.application.Platform.exit();
				     System.exit(0);
				}
			});
            
//    		stage_obj = new Stage_Interface("Home_Client", 1256, 600);
//	    	stage_obj.show_interface();
	    	
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
    void Pressed_ON_textfield1(KeyEvent event) {
    	if(event.getCode() == KeyCode.TAB) {
    		System.out.println("pressed tab");
        	if(checkBox.isSelected()) {
        		textfield_2.requestFocus();
        	}else {
        		Password.requestFocus();
        	}
    	}

    }


}
