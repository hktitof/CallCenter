package Chat;

import java.util.concurrent.Callable;

import FXML_Controlers.Controller_Chat_Agent_Home;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;

public class Refreshing_Class_2 extends Controller_Chat_Agent_Home implements Callable<Void>{
	int i,count;
	ObservableList<String> list ;
	@Override
	public Void call() throws Exception {
		// TODO Auto-generated method stub
		while(Controller_Chat_Agent_Home.static_stop_refreshig_list_requests) {
			for (i = 1; i < 11; i++) {
				Controller_Chat_Agent_Home.change_labe_countinr(i+" seconds");
				Thread.sleep(1000);
			}
			System.out.println("listview requests is refreshed");
		}
		System.out.println("Refreshing listview requests is stopped");
		return null;
	}

}
