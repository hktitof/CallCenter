package FXML_Controlers;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import Chat.Call_test_For_Client;
import Chat.HBoxCell_for_client;
import DB_Connection.DBConnection;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;

public class Controller_Chat_Client_Cnv implements Initializable{
	@FXML
    private ListView<HBox> listview_cnv;

    @FXML
    private Label label_id_cnv;

    @FXML
    private TextField textfield_input;
    DBConnection con = new DBConnection();
    int cnv_id;
    public static ListView<HBox> static_listview_cnv;
    public static Label static_label_id_cnv;
    @Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
    	static_listview_cnv=listview_cnv;
    	static_label_id_cnv=label_id_cnv;
    	Call_test_For_Client.listView=listview_cnv;
    	listview_cnv.setFocusTraversable(false);
		textfield_input.requestFocus();
		try {
			cnv_id=con.get_cnv_id_for_client(Integer.parseInt(Controller_Home_Client.static_client_id.getText()));
			Call_test_For_Client.cnv_id=cnv_id;
		} catch (NumberFormatException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		label_id_cnv.setText("Conversation Id : "+cnv_id);
		System.out.println("Hello --------------------- test");
		ExecutorService executor = Executors.newFixedThreadPool(1);
		executor.submit(new Call_test_For_Client());
		System.out.println("Hello --------------------- test to this");
	}
    int get_id() throws NumberFormatException, SQLException {
    	return con.get_cnv_id_for_client(Integer.parseInt(Controller_Home_Client.static_client_id_string));
    }
    @FXML
    void Pressed_ON_enboyer(MouseEvent event) throws NumberFormatException, SQLException {
    	if(!textfield_input.getText().trim().isEmpty()) {
    		con.insert_msg_from_client_to_db(textfield_input.getText(), cnv_id);
    		static_listview_cnv.getItems().add(new HBoxCell_for_client(textfield_input.getText(), false));
    		static_listview_cnv.refresh();
    		static_listview_cnv.scrollTo(static_listview_cnv.getItems().size()-1);
    		static_listview_cnv.refresh();
    		textfield_input.setText("");;
    	}
    }
}
