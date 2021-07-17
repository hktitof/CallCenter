package FXML_Controlers;

import java.io.FileNotFoundException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import Client.Module_Reclamation_modifier;
import DB_Connection.DBConnection;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class Conroller_Reclamation_Modifier implements Initializable{

	@FXML
    private TableView<Module_Reclamation_modifier> tableview;

    @FXML
    private TableColumn<Module_Reclamation_modifier, Integer> col_id;

    @FXML
    private TableColumn<Module_Reclamation_modifier, String> col_sujet;

    @FXML
    private TableColumn<Module_Reclamation_modifier, ImageView> col_statut;

    @FXML
    private TextField textfield_sujet;

    @FXML
    private TextArea textarea_description;
    
    @FXML
    private AnchorPane AnchorPane;
    
    public static ObservableList<Module_Reclamation_modifier> obs_list_client_reclamation_ouvert;
    
    @Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
    	col_id.setCellValueFactory(new PropertyValueFactory<>("id"));
    	col_sujet.setCellValueFactory(new PropertyValueFactory<>("sujet"));
    	col_statut.setCellValueFactory(new PropertyValueFactory<>("imageview"));
    	try {
    		obs_list_client_reclamation_ouvert=DBConnection.get_reclmation_ouvert(Integer.parseInt(Controller_Home_Client.static_client_id.getText()));
			tableview.setItems(obs_list_client_reclamation_ouvert);
		} catch (FileNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	Platform.runLater(new Runnable(){
			@Override
			public void run() {
				AnchorPane.requestFocus();
			}
			});
		
	}
    @FXML
    void Clicked_ON_table(MouseEvent event) {
    	if (tableview.getSelectionModel().getSelectedItem() != null) {
    		Module_Reclamation_modifier selected_product = tableview.getSelectionModel().getSelectedItem();
    		for (Module_Reclamation_modifier obj : obs_list_client_reclamation_ouvert) {
				if(obj.getId()==selected_product.getId()) {
					textfield_sujet.setText(obj.getSujet());
					textarea_description.setText(obj.getDescription());
					
				}
			}
    		
    	}

    }

    @FXML
    void Pressed_ON_mise_a_jour(MouseEvent event) {

    }

}
