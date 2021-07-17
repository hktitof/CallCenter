package AAAtestPackage;

import java.sql.SQLException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import DB_Connection.DBConnection;
import application.Main;
import javafx.application.Application;
import javafx.stage.Stage;
import sun.security.krb5.internal.APOptions;

public class TestMain{

//	@Override
//	public void start(Stage primaryStage) throws Exception {
////		System.out.println("the result of last msg of cnv id 99 is "+DBConnection.get_last_msg_in_cnv(99));
////		while(true) {
////			if(DBConnection.get_last_msg_in_cnv(99)>0) {
////				System.out.println("its' greater");
////			}
////			Thread.sleep(2000);
////		}
////		int var=DBConnection.get_last_msg_in_cnv_for_agent(99);
////		System.out.println("last msg id of cnv 99 is "+var);
////		ExecutorService executor=Executors.newFixedThreadPool(2);
////		executor.submit(new AnotherTestCall());
////		executor.shutdown();
////		while(true) {
////			if(DBConnection.get_last_msg_in_cnv(99)>0) {
////				System.out.println("it's greater than zero");
////			}
//////			if(DBConnection.get_last_msg_in_cnv(99)>listview_last_msg) {
//////				System.out.println("enterd to this");
//////				list=DBConnection.get_all_msg_for_agent(99, listview_last_msg+1);
//////				listview_last_msg=list.get(list.size()-1).GetMsg_id();
//////				for (Msg_object_for_agent obj : list) {
//////					System.out.println("client msg : "+obj.GetMsg());
//////				}
//////			}else {
//////				System.out.println("entered to this");
//////			}
////			Thread.sleep(3000);
////		}
//		
//	}
	public static void main(String[] args) {
		ExecutorService executor=Executors.newFixedThreadPool(2);
		executor.submit(new AnotherTestCall());
		executor.shutdown();
	}
	

}
