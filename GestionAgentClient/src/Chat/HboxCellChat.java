package Chat;

import java.sql.SQLException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import DB_Connection.DBConnection;
import FXML_Controlers.Controller_Home_Agent;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;

public class HboxCellChat extends HBox{
	Label label_id = new Label();
	Button button = new Button("Accepter");
	Pane pane = new Pane();
	public HboxCellChat(String id) {
		label_id.setText("client id : "+id);
		button.setOnAction(new EventHandler<ActionEvent>() {
		    @Override public void handle(ActionEvent e) {
		    	System.out.println("Clicked on Accept for Client "+id);
		    	ShowConversationForAgent.static_id=id;
		    	ShowConversationForAgent.static_agent_id=Controller_Home_Agent.static_label_agent_id.getText();
				ExecutorService executor= Executors.newFixedThreadPool(2);
				executor.submit(new ShowConversationForAgent());
				
				
		    }
		});
		this.getChildren().addAll(label_id,pane,button);
		this.setHgrow(pane, Priority.ALWAYS);
	}
}
