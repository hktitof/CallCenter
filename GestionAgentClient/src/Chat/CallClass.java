package Chat;

import java.util.concurrent.Callable;

import DB_Connection.DBConnection;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;

public class CallClass implements Callable<Void>{
	private DBConnection con = new DBConnection();
	public static int cnv_last_msg;
	public static int cnv_id;
	public ObservableList<Msg_object_for_agent> list;
	public static ListView<HBox> listview;
	@Override
	public Void call() throws Exception {
		
		// TODO Auto-generated method stub
		
			cnv_last_msg=0;
			while(true) {
				if(con.get_last_msg_in_cnv_for_agent(cnv_id)==0) {
					System.out.println("there is no new msg to show");
				} else if(con.get_last_msg_in_cnv_for_agent(cnv_id)>cnv_last_msg) {
					list=con.get_all_msg_for_agent(cnv_id, cnv_last_msg+1);
					cnv_last_msg=list.get(list.size()-1).GetMsg_id();
					for (Msg_object_for_agent obj : list) {
						edit_listview(obj.GetMsg());
						Thread.sleep(10);
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
				listview.getItems().add(new HBoxCell(text, true));
				listview.refresh();
				listview.scrollTo(listview.getItems().size()-1);
				listview.refresh();
			}
			});
	}

}
