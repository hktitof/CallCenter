package Controllers_Admin;

import java.io.FileNotFoundException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import DB_Connection.DBConnection;
import Threads.Refresh_list_agent;
import javafx.application.Platform;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class Controllers_Admin_list implements Initializable{
	
	@FXML
    private TableView<Module_list_agent> tableview;

    @FXML
    private TableColumn<Module_list_agent, Integer> col_id;

    @FXML
    private TableColumn<Module_list_agent, String> col_username;

    @FXML
    private TableColumn<Module_list_agent, String> col_email;

    @FXML
    private TableColumn<Module_list_agent, String> col_password;

    @FXML
    private TableColumn<Module_list_agent, ImageView> col_statut;

    @FXML
    private TextField textfield_search;
    @FXML
    private AnchorPane AnchorPane;
    @FXML
    private Label label_count;
    
    @Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
    	col_id.setCellValueFactory(new PropertyValueFactory<>("id"));
    	col_username.setCellValueFactory(new PropertyValueFactory<>("username"));
    	col_email.setCellValueFactory(new PropertyValueFactory<>("email"));
    	col_password.setCellValueFactory(new PropertyValueFactory<>("password"));
    	col_statut.setMaxWidth(100);
    	col_statut.setCellValueFactory(new PropertyValueFactory<>("image_online_offline"));
    	try {
			tableview.setItems(DBConnection.get_agent_info());
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
    	Refresh_list_agent.tableview=tableview;
    	Refresh_list_agent.label_counting=label_count;
    	Refresh_list_agent.textfield_recherche=textfield_search;
    	if(Refresh_list_agent.count==0) {
    		ExecutorService executor = Executors.newFixedThreadPool(1);
    		executor.submit(new Refresh_list_agent());
    	}
	}
    @FXML
    void Pressed_ON_REfresh(MouseEvent event) {
    		try {
			
				AnchorPane.getChildren().clear();
				AnchorPane.getChildren().add(FXMLLoader.load(getClass().getResource("/FXML_Admin/Configuration_Agent_list.fxml")));
				AnchorPane.setLayoutX(0);
				AnchorPane.setLayoutY(0);
	
			} catch (Exception e) {
				e.printStackTrace();
			}

    }
    
    
}
