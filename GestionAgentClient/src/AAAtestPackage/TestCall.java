package AAAtestPackage;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;

import Chat.Msg_object_for_agent;
import DB_Connection.DBConnection;
import javafx.collections.ObservableList;

public class TestCall implements Callable<Void>{
	private int listview_last_msg;
	private List<Msg_object_for_agent> normal_list=new ArrayList<Msg_object_for_agent>();
	private ObservableList<Msg_object_for_agent> list;
	@Override
	public Void call() throws Exception {
		listview_last_msg=0;
		System.out.println("getting msg for 99");
		System.out.println("and here too");
		while(true) {
//			if(DBConnection.get_last_msg_in_cnv(99)>0) {
//				System.out.println("its' greater");
//			}
//			Thread.sleep(2000);
//			if(DBConnection.get_last_msg_in_cnv(99)>listview_last_msg) {
//				System.out.println("enterd to this");
//				list=DBConnection.get_all_msg_for_agent(99, listview_last_msg+1);
//				listview_last_msg=list.get(list.size()-1).GetMsg_id();
//				for (Msg_object_for_agent obj : list) {
//					System.out.println("client msg : "+obj.GetMsg());
//				}
//			}else {
//				System.out.println("entered to this");
//			}
			Thread.sleep(3000);
		}
	}

}
