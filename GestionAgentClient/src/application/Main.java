package application;
	

import java.io.IOException;
import java.sql.SQLException;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import AAAtestPackage.CallThis;
import AAAtestPackage.TestCall;
import Algorithms.Stage_Interface;
import Chat.Msg_object_for_agent;
import DB_Connection.DBConnection;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;




public class Main extends Application {
	
	
	public static int listview_var;
	private int listview_last_msg;
	private ObservableList<Msg_object_for_agent> list;
	@Override
	public void start(Stage primaryStage) {
		
//		Set<Thread> threads = Thread.getAllStackTraces().keySet();
//		 
//		for (Thread t : threads) {
//		    String name = t.getName();
//		    Thread.State state = t.getState();
//		    int priority = t.getPriority();
//		    String type = t.isDaemon() ? "Daemon" : "Normal";
//		    System.out.printf("%-20s \t %s \t %d \t %s\n", name, state, priority, type);
//		}
//		ExecutorService executor = Executors.newFixedThreadPool(1);
//		executor.submit(new TestCall());
		Boolean test = true;
//		
		try {
			if(test) {
				
		        Stage_Interface stage_obj = new Stage_Interface("Login_Client", 700, 500);
//		        Stage_Interface stage_obj = new Stage_Interface("Verification_Page", 700, 500);
				stage_obj.show_interface();
		    	
		    	
				
			}
			else {
				Parent root = FXMLLoader.load(getClass().getResource("/FXML/Registration_Page.fxml"));
				Scene scene = new Scene(root,600,200);
				scene.setFill(Color.TRANSPARENT);
				
				primaryStage.setScene(scene);
				primaryStage.initStyle(StageStyle.TRANSPARENT);
				primaryStage.show();
				Rectangle2D primScreenBounds = Screen.getPrimary().getVisualBounds();
		        primaryStage.setX((primScreenBounds.getWidth() - primaryStage.getWidth()) / 2);
		        primaryStage.setY((primScreenBounds.getHeight() - primaryStage.getHeight()) / 2);
		        primaryStage.show();
			}
			
	        
	        
	        
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	
}
