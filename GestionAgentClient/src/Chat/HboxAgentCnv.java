package Chat;

import java.util.Date;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

import javafx.scene.layout.StackPane;

public class HboxAgentCnv extends HBox{
	private StackPane stackpane_msg;
	private Label label_msg;
	private Date date=new Date();
	javafx.scene.text.Text text = new javafx.scene.text.Text();
	
	public HboxAgentCnv(String text) {
		stackpane_msg.setMaxWidth(280d);
		this.label_msg.setText(text);
		label_msg.setWrapText(true);
		this.text.setText(label_msg.getText());
		this.text.setFont(label_msg.getFont());
		stackpane_msg.getChildren().addAll(label_msg);
        this.getChildren().add(stackpane_msg);
        this.setAlignment(Pos.CENTER_LEFT);
    	this.label_msg.setText("Client : "+label_msg.getText()+"\n"+date.getHours()+":"+date.getMinutes());
    	this.label_msg.setTextFill(javafx.scene.paint.Color.RED);
	}

}
