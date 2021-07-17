package Chat;

import java.util.concurrent.Callable;

import DB_Connection.DBConnection;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;

public class Call_test_For_Client implements Callable<Void>{
	public static int cnv_last_msg;
	public static int cnv_id;
	public static ListView<HBox> listView;
	public ObservableList<Msg_object_for_agent> obs_list;
	DBConnection con = new DBConnection();
	@Override
	public Void call() throws Exception {
		// TODO Auto-generated method stub
		cnv_last_msg=0;
		while(true) {
			if(con.get_last_msg_in_cnv_for_client(cnv_id)==cnv_last_msg) {
				System.out.println("no new mesg from agent to show for client");
			}else if(con.get_last_msg_in_cnv_for_client(cnv_id)>cnv_last_msg){
				obs_list=con.get_all_msg_for_client(cnv_id, cnv_last_msg+1);
				cnv_last_msg=obs_list.get(obs_list.size()-1).GetMsg_id();
				for (Msg_object_for_agent obj : obs_list) {
					edit_listview(obj.GetMsg());
				}
			}
			Thread.sleep(3000);
		}
	}
	
	public void edit_listview(String text) {
		Platform.runLater(new Runnable(){
			@Override
			public void run() {
				// here do your GUI edit only for example
				// label.setText("Hello world");
				listView.getItems().add(new HBoxCell_for_client(text, true));
				listView.refresh();
				listView.scrollTo(listView.getItems().size()-1);
				listView.refresh();
			}
			});
	}

}
