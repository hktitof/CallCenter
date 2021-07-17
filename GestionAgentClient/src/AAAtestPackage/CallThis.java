package AAAtestPackage;

import java.util.concurrent.Callable;

import Chat.HboxAgentCnv;
import Chat.Msg_object_for_agent;
import Chat.ShowConversationForAgent;
import DB_Connection.DBConnection;
import FXML_Controlers.Controller_Chat_Agent_Home;
import FXML_Controlers.Controller_Chat_Client_chat;
import application.Main;
import javafx.application.Platform;
import javafx.collections.ObservableList;

public class CallThis implements Callable<Void>{
	public static ObservableList<Msg_object_for_agent> msg_list_for_agent;	
	private DBConnection DbConnection = new DBConnection();
	@Override
	public Void call() throws Exception {
		while(true) {
			if(DbConnection.get_last_msg_in_cnv(ShowConversationForAgent.Listview_cnv_id)==0) {
				System.out.println("there is no msg inserted yet in this cnv "+ShowConversationForAgent.Listview_cnv_id);
			}else if(DbConnection.get_last_msg_in_cnv(ShowConversationForAgent.Listview_cnv_id)>ShowConversationForAgent.listview_las_msg_loaded) {
				System.out.println("List of new msg are : ");
				msg_list_for_agent=DbConnection.get_all_msg_for_agent(ShowConversationForAgent.Listview_cnv_id,ShowConversationForAgent.listview_las_msg_loaded+1);
				DBConnection.msg_list_for_agent.clear();
				DBConnection.normal_list_for_msg_ageent.clear();
				ShowConversationForAgent.listview_las_msg_loaded=msg_list_for_agent.get(msg_list_for_agent.size()-1).GetMsg_id();
				for (Msg_object_for_agent obj : msg_list_for_agent) {
					System.out.println("the meessage of client is : "+obj.GetMsg());
				}
			}else {
				System.out.println("no new msg Found for cnv "+ShowConversationForAgent.Listview_cnv_id);
			}
			Thread.sleep(3000);
		}
	}
	
	public void Set_Text_in_Listview_of_agent(String text) {
		Platform.runLater(new Runnable(){
			@Override
			public void run() {
				Controller_Chat_Agent_Home.static_listview_conversation.getItems().add(new HboxAgentCnv(text));
				Controller_Chat_Agent_Home.static_listview_conversation.refresh();
			}
			});
	}

}
