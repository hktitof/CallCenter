package Controllers_Admin;

import java.net.URL;
import java.util.ResourceBundle;

import Threads.Refresh_list_agent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class Controllers_Admin_Agent_Home implements Initializable{
	

	@FXML
    private AnchorPane AnchorPane1_change;

    @FXML
    private AnchorPane AnchorPane2_change;
    
    @Override
	public void initialize(URL location, ResourceBundle resources) {
    	
    	try {
			
    		AnchorPane2_change.getChildren().clear();
    		AnchorPane2_change.getChildren().add(FXMLLoader.load(getClass().getResource("/FXML_Admin/Configuration_Agent_list.fxml")));
    		AnchorPane2_change.setLayoutX(200);
    		AnchorPane2_change.setLayoutY(0);
	
			} catch (Exception e) {
				e.printStackTrace();
			}
		
	}
    
    @FXML
    void Pressed_ON_La_liste(MouseEvent event) {
		try {
		    		AnchorPane2_change.getChildren().clear();
		    		AnchorPane2_change.getChildren().add(FXMLLoader.load(getClass().getResource("/FXML_Admin/Configuration_Agent_list.fxml")));
		    		AnchorPane2_change.setLayoutX(200);
		    		AnchorPane2_change.setLayoutY(0);
			
					} catch (Exception e) {
						e.printStackTrace();
					}
		    }
    
    @FXML
    void Clicked_ON_label(MouseEvent event) {
    	try {
    		AnchorPane2_change.getChildren().clear();
    		AnchorPane2_change.getChildren().add(FXMLLoader.load(getClass().getResource("/FXML_Admin/Configuration_Agent_list.fxml")));
    		AnchorPane2_change.setLayoutX(200);
    		AnchorPane2_change.setLayoutY(0);
	
			} catch (Exception e) {
				e.printStackTrace();
			}
    
    }
    
    @FXML
    void Clicked_ON_label_ajouter(MouseEvent event) {
    	try {
    		AnchorPane2_change.getChildren().clear();
    		AnchorPane2_change.getChildren().add(FXMLLoader.load(getClass().getResource("/FXML_Admin/Configuration_Agent_ajouter.fxml")));
    		AnchorPane2_change.setLayoutX(200);
    		AnchorPane2_change.setLayoutY(0);
	
			} catch (Exception e) {
				e.printStackTrace();
			}
    }
    @FXML
    void Clicked_ON_Modifier(MouseEvent event) {
    	try {
    		AnchorPane2_change.getChildren().clear();
    		AnchorPane2_change.getChildren().add(FXMLLoader.load(getClass().getResource("/FXML_Admin/Configuration_Agent_Modifier.fxml")));
    		AnchorPane2_change.setLayoutX(200);
    		AnchorPane2_change.setLayoutY(0);
	
			} catch (Exception e) {
				e.printStackTrace();
			}
    }
    @FXML
    void Clicked_on_Supprimer(MouseEvent event) {
    	try {
    		AnchorPane2_change.getChildren().clear();
    		AnchorPane2_change.getChildren().add(FXMLLoader.load(getClass().getResource("/FXML_Admin/Configuration_AGent_Supprimer.fxml")));
    		AnchorPane2_change.setLayoutX(200);
    		AnchorPane2_change.setLayoutY(0);
	
			} catch (Exception e) {
				e.printStackTrace();
			}
    }
    
}
