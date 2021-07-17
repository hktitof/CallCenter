package Chat;

import java.sql.SQLException;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import DB_Connection.DBConnection;
import FXML_Controlers.Controller_Chat_Agent_Home;
import FXML_Controlers.Controller_Home_Agent;
import FXML_Controlers.Controller_Home_Client;
import javafx.application.Platform;

public class ShowConversationForAgent implements Callable<Void>{
	public static String static_id;
	public static String static_agent_id;
	public static int Listview_cnv_id;
	public static int listview_las_msg_loaded;
	@Override
	public Void call() throws Exception {
		// TODO Auto-generated method stub
		DBConnection.change_value_Conv_with_for_client_status(static_id);
		System.out.println("Conversation will be created for client id "+static_id+" agent id "+Controller_Home_Agent.static_label_agent_id.getText());
		DBConnection.Create_conv(static_id, static_agent_id);
		show(static_id);
		listview_las_msg_loaded=0;
		Listview_cnv_id=DBConnection.get_Cnv_id_of_agent_value(Integer.parseInt(static_agent_id));
		CallClass.cnv_id=Listview_cnv_id;
		Set_listview_conversation_id(Listview_cnv_id);
		ExecutorService executor=Executors.newFixedThreadPool(3);
		executor.submit(new CallClass());
//		ExecutorService executor=Executors.newFixedThreadPool(1);
//		executor.submit(new GetMsgFor_listview_agent());
		return null;
	}
	public String[] client_info= new String[8];
	public void show(String id) throws SQLException {
		//create conversation in database
		unhide();
		get_information(id);
	}
	public void unhide() {
		Platform.runLater(new Runnable(){
			@Override
			public void run() {
				Controller_Chat_Agent_Home.static_label_edit_1_id.setVisible(true);
				Controller_Chat_Agent_Home.static_label_edit_2_username.setVisible(true);
				Controller_Chat_Agent_Home.static_label_edit_3_email.setVisible(true);
				Controller_Chat_Agent_Home.static_label_edit_4_prenom.setVisible(true);
				Controller_Chat_Agent_Home.static_label_edit_5_nom.setVisible(true);
				Controller_Chat_Agent_Home.static_label_edit_6_telephone.setVisible(true);
				Controller_Chat_Agent_Home.static_label_edit_7_date_naiss.setVisible(true);
				Controller_Chat_Agent_Home.static_label_edit_8_password.setVisible(true);
				Controller_Chat_Agent_Home.static_label_label_edit_9_deniere_cnx.setVisible(true);
				Controller_Chat_Agent_Home.static_label_welcoming.setVisible(true);
				Controller_Chat_Agent_Home.static_listview_conversation.setVisible(true);
				Controller_Chat_Agent_Home.static_textfield_input.setVisible(true);
				Controller_Chat_Agent_Home.static_button_envoyer.setVisible(true);
				Controller_Chat_Agent_Home.static_label1.setVisible(true);
				Controller_Chat_Agent_Home.static_label2.setVisible(true);
				Controller_Chat_Agent_Home.static_label3.setVisible(true);
				Controller_Chat_Agent_Home.static_label4.setVisible(true);
				Controller_Chat_Agent_Home.static_label5.setVisible(true);
				Controller_Chat_Agent_Home.static_label6.setVisible(true);
				Controller_Chat_Agent_Home.static_label7.setVisible(true);
				Controller_Chat_Agent_Home.static_label8.setVisible(true);
				Controller_Chat_Agent_Home.static_label9.setVisible(true);
				Controller_Chat_Agent_Home.static_label10.setVisible(true);
			}
			});
		
	}
	public void get_information(String id) throws SQLException {
		client_info=DBConnection.get_user_information_for_agent(id);
		if(client_info[0]!=null) {
			client_info[6]=client_info[6].substring(0, 4);
			Platform.runLater(new Runnable(){
				@Override
				public void run() {
					Controller_Chat_Agent_Home.static_label_edit_1_id.setText(id);
					Controller_Chat_Agent_Home.static_label_edit_2_username.setText(client_info[0]);
					Controller_Chat_Agent_Home.static_label_edit_3_email.setText(client_info[1]);
					Controller_Chat_Agent_Home.static_label_edit_4_prenom.setText(client_info[2]);
					Controller_Chat_Agent_Home.static_label_edit_5_nom.setText(client_info[3]);
					Controller_Chat_Agent_Home.static_label_edit_6_telephone.setText(client_info[4]);
					Controller_Chat_Agent_Home.static_label_edit_7_date_naiss.setText(client_info[5]);
					Controller_Chat_Agent_Home.static_label_edit_8_password.setText("Premier 4 charcters sont "+client_info[6]);
					Controller_Chat_Agent_Home.static_label_label_edit_9_deniere_cnx.setText(client_info[7]);
					Controller_Chat_Agent_Home.static_label_welcoming.setText(id);
				}
				});
		}
	}
	public void Set_listview_conversation_id(int this_id) {
		Platform.runLater(new Runnable(){
			@Override
			public void run() {
				Controller_Chat_Agent_Home.static_label_welcoming.setText("Conversation id : "+String.valueOf(this_id));
			}
			});
	}
	
}
