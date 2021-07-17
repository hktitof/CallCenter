package FXML_Controlers;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import Chat.HboxCellChat;
import Chat.Refreshing_listv_requests_agent;
import Chat.ShowConversationForAgent;
import DB_Connection.DBConnection;
import Chat.CallClass;
import Chat.HBoxCell;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Orientation;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;

public class Controller_Chat_Agent_Home implements Initializable{

    @FXML
    private AnchorPane AnchorPane_Home_Chat_agent;

    @FXML
    private ListView<HBox> listview_requests;

    @FXML
    private ListView<HBox> listview_conversation;

    @FXML
    private TextField textfield_input;

    @FXML
    private Button button_envoyer;
    
    @FXML
    private Label label_1;
    
    @FXML
    private Label label_2;

    @FXML
    private Label label_3;

    @FXML
    private Label label_4;

    @FXML
    private Label label_5;

    @FXML
    private Label label_6;

    @FXML
    private Label label_7;

    @FXML
    private Label label_8;

    @FXML
    private Label label_9;

    @FXML
    private Label label_10;

    @FXML
    private Label label_edit_1_id;

    @FXML
    private Label label_edit_2_username;

    @FXML
    private Label label_counring;

    @FXML
    private Label label_edit_3_email;

    @FXML
    private Label label_edit_4_prenom;

    @FXML
    private Label label_edit_5_nom;

    @FXML
    private Label label_edit_6_telephone;

    @FXML
    private Label label_edit_7_date_naiss;

    @FXML
    private Label label_edit_8_password;

    @FXML
    private Label label_edit_9_deniere_cnx;

    @FXML
    private Label label_welcoming;
    
    // static Label for editing by titof
    public static Label static_label1;
    public static Label static_label2;
    public static Label static_label3;
    public static Label static_label4;
    public static Label static_label5;
    public static Label static_label6;
    public static Label static_label7;
    public static Label static_label8;
    public static Label static_label9;
    public static Label static_label10;
    // target changed labels
    public static Label static_label_edit_1_id;
    public static Label static_label_edit_2_username;
    public static Label static_label_edit_3_email;
    public static Label static_label_edit_4_prenom;
    public static Label static_label_edit_5_nom;
    public static Label static_label_edit_6_telephone;
    public static Label static_label_edit_7_date_naiss;
    public static Label static_label_edit_8_password;
    public static Label static_label_label_edit_9_deniere_cnx;
    public static Label static_label_welcoming;
    // target listview_conversation, textfield and button
    public static ListView<HBox> static_listview_conversation;
    public static TextField static_textfield_input;
    public static Button static_button_envoyer;
    
    DBConnection con = new DBConnection();
    ObservableList<String> list ;
    public static Boolean static_stop_refreshig_list_requests;
    int count;
    public static Label static_label_counting_for_refresh_list_requests;
    
    public static ListView<HBox> static_listview_requests=new ListView<HBox>();
    @Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
    	static_equal_to_fixed_and_hide();
    	listview_requests_configuration();
	}
    public static void change_labe_countinr(String text) {
    	static_label_counting_for_refresh_list_requests.setText(text);
    }
    
    @FXML
    void Pressed_ON_back(MouseEvent event) throws IOException {
    	Controller_Home_Agent.static_AnchorPane_Home_changed.getChildren().clear();
    	Controller_Home_Agent.static_AnchorPane_Home_changed.getChildren().add(FXMLLoader.load(getClass().getResource("/FXML/Chat_Agent_page_start_receiving.fxml")));
    }
    @FXML
    void Pressed_On_Quitter_Button(MouseEvent event) {
    	static_stop_refreshig_list_requests=false;
    }
    void static_equal_to_fixed_and_hide() {
    	// set static changed labels
    	static_label_edit_1_id=label_edit_1_id;
    	static_label_edit_2_username=label_edit_2_username;
    	static_label_edit_3_email=label_edit_3_email;
    	static_label_edit_4_prenom=label_edit_4_prenom;
    	static_label_edit_5_nom=label_edit_5_nom;
    	static_label_edit_6_telephone=label_edit_6_telephone;
    	static_label_edit_7_date_naiss=label_edit_7_date_naiss;
    	static_label_edit_8_password=label_edit_8_password;
    	static_label_label_edit_9_deniere_cnx=label_edit_9_deniere_cnx;
    	static_label_welcoming=label_welcoming;
    	// set static fixed labels
    	static_label1=label_1;
        static_label2=label_2;
        static_label3=label_3;
        static_label4=label_4;
        static_label5=label_5;
        static_label6=label_6;
        static_label7=label_7;
        static_label8=label_8;
        static_label9=label_9;
        static_label10=label_10;
        //others labels
        static_label_counting_for_refresh_list_requests=label_counring;
    	static_listview_requests=listview_requests;
    	// set static listview_converation, textfield and button
    	static_listview_conversation=listview_conversation;
    	CallClass.listview=listview_conversation;
    	static_textfield_input=textfield_input;
    	static_button_envoyer=button_envoyer;
    	// hide conversation compnenets
    	static_label_edit_1_id.setVisible(false);
    	static_label_edit_2_username.setVisible(false);
    	static_label_edit_3_email.setVisible(false);
    	static_label_edit_4_prenom.setVisible(false);
    	static_label_edit_5_nom.setVisible(false);
    	static_label_edit_6_telephone.setVisible(false);
    	static_label_edit_7_date_naiss.setVisible(false);
    	static_label_edit_8_password.setVisible(false);
    	static_label_label_edit_9_deniere_cnx.setVisible(false);
    	static_label_welcoming.setVisible(false);
    	static_listview_conversation.setVisible(false);
    	static_textfield_input.setVisible(false);
    	static_button_envoyer.setVisible(false);
    	static_label1.setVisible(false);
        static_label2.setVisible(false);
        static_label3.setVisible(false);
        static_label4.setVisible(false);
        static_label5.setVisible(false);
        static_label6.setVisible(false);
        static_label7.setVisible(false);
        static_label8.setVisible(false);
        static_label9.setVisible(false);
        static_label10.setVisible(false);
    }
    void listview_requests_configuration() {
    	static_listview_requests.setOrientation(Orientation.VERTICAL);
    	static_listview_requests.getItems().clear();
    	try {
			list=DBConnection.get_all_online_id();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	count=0;
    	for (String id : list) {
			static_listview_requests.getItems().add(new HboxCellChat(list.get(count)));
			count++;
    	}
    	static_listview_requests.refresh();
    	static_stop_refreshig_list_requests=true;
    	ExecutorService executor = Executors.newFixedThreadPool(2);
    	executor.submit(new Refreshing_listv_requests_agent());
    }
    @FXML
    void Click_on_envoyer_button(MouseEvent event) throws NumberFormatException, SQLException {
    	if(textfield_input.getText().trim().isEmpty()) {
    		System.out.println("it's empty!");
    	}else {
    		
    		con.insert_msg_from_agent_to_db(textfield_input.getText().toString(),ShowConversationForAgent.Listview_cnv_id);
    		
    			CallClass.listview.getItems().add(new Chat.HBoxCell(textfield_input.getText(), false));
        		CallClass.listview.refresh();
        		CallClass.listview.scrollTo(CallClass.listview.getItems().size()-1);
        		CallClass.listview.refresh();
			
    		textfield_input.setText("");
    	}
    }
}
