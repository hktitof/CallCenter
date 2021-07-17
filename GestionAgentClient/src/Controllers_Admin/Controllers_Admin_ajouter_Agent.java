package Controllers_Admin;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import DB_Connection.DBConnection;
import Threads.Refresh_list_agent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;
import tray.animations.AnimationType;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;
public class Controllers_Admin_ajouter_Agent implements Initializable{
	@FXML
    private TextField textfield_username;

    @FXML
    private TextField textfield_email;

    @FXML
    private TextField textfield_password;
    
    private AnimationType type;
    private TrayNotification tray = new TrayNotification();
    @Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		Refresh_list_agent.Refreshign_tablview_agent_list=false;
		
	}
    @FXML
    void Pressed_On_ajouter(MouseEvent event) throws SQLException {
    	if(textfield_username.getText().trim().isEmpty()||textfield_email.getText().trim().isEmpty()||textfield_password.getText().isEmpty()) {
    		type = AnimationType.POPUP;
			tray.setAnimationType(type);
    		tray.setTitle("Verification des champs");
        	tray.setMessage("un champ ou plusieurs est vide");
        	tray.setNotificationType(NotificationType.WARNING);
        	tray.showAndDismiss(Duration.millis(3000));
    	}else {
    		System.out.println("it's not empty");
    		if(DBConnection.get_agent_email(textfield_email.getText())) {
    			System.out.println("agent email already exist");
    			type = AnimationType.POPUP;
    			tray.setAnimationType(type);
        		tray.setTitle("Verification d'email");
            	tray.setMessage("veuillez changer l'adresse email");
            	tray.setNotificationType(NotificationType.ERROR);
            	tray.showAndDismiss(Duration.millis(3000));
    		}else {
    			if(DBConnection.get_agent_username(textfield_username.getText())) {
        			type = AnimationType.POPUP;
        			tray.setAnimationType(type);
            		tray.setTitle("verfication username");
                	tray.setMessage("veuillez changer le nom d'utilisateur.");
                	tray.setNotificationType(NotificationType.ERROR);
                	tray.showAndDismiss(Duration.millis(3000));
        		}else {
        				DBConnection.add_agent_to_DB(textfield_username.getText(), textfield_email.getText(), textfield_password.getText());
        				type = AnimationType.POPUP;
            			tray.setAnimationType(type);
                		tray.setTitle("sucess");
                    	tray.setMessage("nouveeau agent est bien ajouter a DB");
                    	tray.setNotificationType(NotificationType.SUCCESS);
                    	tray.showAndDismiss(Duration.millis(3000));
                    	textfield_email.setText("");
                    	textfield_username.setText("");
                    	textfield_password.setText("");
        		}
    		}
    	}

    }

}
