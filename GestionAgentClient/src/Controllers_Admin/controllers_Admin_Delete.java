package Controllers_Admin;

import java.sql.SQLException;

import DB_Connection.DBConnection;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;
import tray.animations.AnimationType;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;

public class controllers_Admin_Delete {
	@FXML
    private TextField textfield_id;
	private AnimationType type;
    private TrayNotification tray = new TrayNotification();

    @FXML
    void Pressed_ON_Delete(MouseEvent event) throws NumberFormatException, SQLException {
    	if(DBConnection.get_agent_id(Integer.parseInt(textfield_id.getText().trim()))) {
        	DBConnection.delete_agent(Integer.parseInt(textfield_id.getText().trim()));
        	type = AnimationType.POPUP;
			tray.setAnimationType(type);
    		tray.setTitle("Sucess");
        	tray.setMessage("Agent id "+textfield_id.getText().trim()+" est supprimer");
        	tray.setNotificationType(NotificationType.SUCCESS);
        	tray.showAndDismiss(Duration.millis(3000));
        	textfield_id.setText("");
    	}else {
    		type = AnimationType.POPUP;
			tray.setAnimationType(type);
    		tray.setTitle("Verfication Id");
        	tray.setMessage("id "+textfield_id.getText().trim()+" n'exist pas");
        	tray.setNotificationType(NotificationType.ERROR);
        	tray.showAndDismiss(Duration.millis(3000));
    	}
    }

}
