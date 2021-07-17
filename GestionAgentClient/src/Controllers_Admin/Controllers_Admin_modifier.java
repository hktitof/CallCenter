package Controllers_Admin;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import Admin_Classes.agent_get_user_email_password_class;
import DB_Connection.DBConnection;
import Threads.Refresh_list_agent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;
import tray.animations.AnimationType;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;

public class Controllers_Admin_modifier implements Initializable{
	@FXML
    private TextField textfield_search;

    @FXML
    private TextField textfield_username;

    @FXML
    private TextField textfield_email;

    @FXML
    private TextField textfield_password;
    @FXML
    private Button button_update;
    
    private AnimationType type;
    private TrayNotification tray = new TrayNotification();
    private agent_get_user_email_password_class agent_info_obj;
    @Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
    	Refresh_list_agent.Refreshign_tablview_agent_list=false;
	}
    @FXML
    void Pressed_ON_udpate(MouseEvent event) throws NumberFormatException, SQLException {
    	if(textfield_username.getText().trim().isEmpty()||textfield_email.getText().trim().isEmpty()||textfield_password.getText().isEmpty()||textfield_search.getText().trim().isEmpty()) {
    		type = AnimationType.POPUP;
			tray.setAnimationType(type);
    		tray.setTitle("Verfication des champs");
        	tray.setMessage("un champ ou plusieurs est vide");
        	tray.setNotificationType(NotificationType.WARNING);
        	tray.showAndDismiss(Duration.millis(2000));
    	}else {
    		DBConnection.update_agent_username_email_password(textfield_username.getText().trim(), textfield_email.getText().trim(),
    				textfield_password.getText(), Integer.parseInt(textfield_search.getText()));
    		type = AnimationType.POPUP;
			tray.setAnimationType(type);
    		tray.setTitle("Sucess");
        	tray.setMessage("les information d'Agent "+textfield_search.getText().trim()+" est mise a jour");
        	tray.setNotificationType(NotificationType.SUCCESS);
        	tray.showAndDismiss(Duration.millis(1000));
        	textfield_username.setDisable(true);
        	textfield_email.setDisable(true);
        	textfield_password.setDisable(true);
        	button_update.setDisable(true);
        	textfield_search.setText("");
        	textfield_username.setText("");
        	textfield_password.setText("");
        	textfield_email.setText("");
    	}
    }

    @FXML
    void Pressed_on_cherche(MouseEvent event) throws NumberFormatException, SQLException {	
    	if(DBConnection.get_agent_id(Integer.parseInt(textfield_search.getText().trim()))) {
        	agent_info_obj=DBConnection.get_username_email_password(Integer.parseInt(textfield_search.getText().trim()));
        	textfield_username.setDisable(false);
        	textfield_email.setDisable(false);
        	textfield_password.setDisable(false);
        	button_update.setDisable(false);
        	textfield_username.setText(agent_info_obj.getUsername());
        	textfield_email.setText(agent_info_obj.getEmail());
        	textfield_password.setText(agent_info_obj.getPassword());
        	
        	
    	}else {
    		type = AnimationType.POPUP;
			tray.setAnimationType(type);
    		tray.setTitle("Verfication Id");
        	tray.setMessage("id "+textfield_search.getText().trim()+" n'exist pas");
        	tray.setNotificationType(NotificationType.ERROR);
        	tray.showAndDismiss(Duration.millis(3000));
    	}
    }

}
