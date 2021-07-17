package Chat;

import java.sql.SQLException;
import java.util.concurrent.Callable;
import DB_Connection.DBConnection;
import FXML_Controlers.Controller_Chat_Agent_Home;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.scene.paint.Color;


public class Refreshing_listv_requests_agent implements Callable<Void>{
	int i,count;
	ObservableList<String> list;
	@Override
	public Void call() throws Exception {
		// TODO Auto-generated method stub
		while(Controller_Chat_Agent_Home.static_stop_refreshig_list_requests) {
			for (i = 10; i > 0; i--) {
				if(Controller_Chat_Agent_Home.static_stop_refreshig_list_requests) {
					edit_label("la liste sera actualise pendant "+i+" seconds");
					Thread.sleep(1000);
				}else {
					break;
				}
			}
			refresh_static_listview_requests();
			showing_notification_that_listview_is_refreshed_by_changing_label();
			System.out.println("listview requests is refreshed");
		}
		System.out.println("Refreshing listview requests is stopped");
		return null;

	}
	public void edit_label(String text) {
		Platform.runLater(new Runnable(){
			
			@Override
			public void run() {
				Controller_Chat_Agent_Home.static_label_counting_for_refresh_list_requests.setText(text);
			}
			});
	}
	public void refresh_static_listview_requests() {
		clear_listview_requests();
		System.out.println("listview requests is cleared");
		try {
			list=DBConnection.get_all_online_id();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	count=0;
    	for (String id : list) {
			add_items_to_listview_requests(list,count);
			count++;
    	}
    	last_steop_refresh_items_to_listview_requests();
    	
	}
	public void clear_listview_requests() {
		Platform.runLater(new Runnable(){
			@Override
			public void run() {
				Controller_Chat_Agent_Home.static_listview_requests.getItems().clear();
			}
			});
	}
	public void add_items_to_listview_requests(ObservableList<String> list,int count) {
		Platform.runLater(new Runnable(){
			@Override
			public void run() {
				Controller_Chat_Agent_Home.static_listview_requests.getItems().add(new HboxCellChat(list.get(count)));
			}
			});
	}
	public void last_steop_refresh_items_to_listview_requests() {
		Platform.runLater(new Runnable(){
			@Override
			public void run() {
				Controller_Chat_Agent_Home.static_listview_requests.refresh();
			}
			});
	}
	public void showing_notification_that_listview_is_refreshed_by_changing_label() throws InterruptedException {
		Platform.runLater(new Runnable(){
			@Override
			public void run() {
				Controller_Chat_Agent_Home.static_label_counting_for_refresh_list_requests.setTextFill(Color.RED);
				Controller_Chat_Agent_Home.static_label_counting_for_refresh_list_requests.setText("La liste est Bien Actualiser");
			}
			});
			Thread.sleep(3000);
			Platform.runLater(new Runnable(){
				@Override
				public void run() {
					Controller_Chat_Agent_Home.static_label_counting_for_refresh_list_requests.setTextFill(Color.BLACK);
				}
				});
			
		
	}
	


}
