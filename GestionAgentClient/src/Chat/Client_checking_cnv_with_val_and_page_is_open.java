package Chat;

import java.io.IOException;
import java.util.concurrent.Callable;

import Algorithms.Stage_Interface;
import DB_Connection.DBConnection;
import FXML_Controlers.Controller_Chat_Client_chat;
import FXML_Controlers.Controller_Home_Client;
import javafx.application.Platform;

public class Client_checking_cnv_with_val_and_page_is_open implements Callable<Void>{

	@Override
	public Void call() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("the target client id is : "+Controller_Home_Client.static_client_id.getText());
		while(true) {
			if(Controller_Chat_Client_chat.static_chat_client_page_open_verification) {
				if(!DBConnection.get_Cnv_with_of_client_value(Integer.parseInt(Controller_Home_Client.static_client_id.getText()))) {
					Thread.sleep(3000);
				}else {
					open_chat_room();
					break;
				}
			}else {
				System.out.println("Application is closed from msg from thread checking value");
				break;
			}
		}
		return null;
	}
	
	public void open_chat_room() {
		Platform.runLater(new Runnable(){
			@Override
			public void run() {
				// here do your GUI edit only for example
				// label.setText("Hello world");
				Stage_Interface stage_obj = new Stage_Interface("Chat_Client_Cnv", 500, 600);
		    	try {
					stage_obj.show_interface();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			});
	}

}
