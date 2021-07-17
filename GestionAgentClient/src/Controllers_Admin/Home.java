package Controllers_Admin;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class Home {
	@FXML
    private AnchorPane AnchorPane_changeable;
	@FXML
    void Pressed_ON_image_Agent(MouseEvent event) {
		try {
			
			AnchorPane_changeable.getChildren().clear();
			AnchorPane_changeable.getChildren().add(FXMLLoader.load(getClass().getResource("/FXML_Admin/Configuration_Agent.fxml")));
			AnchorPane_changeable.setLayoutX(0);
			AnchorPane_changeable.setLayoutY(0);
	
			} catch (Exception e) {
				e.printStackTrace();
			}

    }

}
