package Chat;

import java.util.Date;

import com.sun.prism.paint.Color;
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils.Text;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;

public class HBoxCell  extends HBox{
	Label label_msg = new Label();
	StackPane stackpane_msg = new StackPane();
	Rectangle rectangle = new Rectangle();
	Label label_time=new Label();
	String type_user;
	Date date = new Date();
	HBox vbox_msg = new HBox();
	HBox vbox_time = new HBox();
	StackPane stackpane_time = new StackPane();
	javafx.scene.text.Text text = new javafx.scene.text.Text();
	public HBoxCell(String text,boolean a){
		stackpane_msg.setMaxWidth(280d);
		stackpane_time.setMaxWidth(280d);
		this.label_msg.setText(text);
		label_msg.setWrapText(true);
		this.text.setText(label_msg.getText());
		this.text.setFont(label_msg.getFont());
		stackpane_msg.getChildren().addAll(label_msg);
        this.getChildren().add(stackpane_msg);
        if(a) {
        	this.setAlignment(Pos.CENTER_LEFT);
        	this.label_msg.setText("Client : "+label_msg.getText()+"\n"+date.getHours()+":"+date.getMinutes());
        	this.label_msg.setTextFill(javafx.scene.paint.Color.RED);
        }else {
        	this.setAlignment(Pos.CENTER_RIGHT);
        	this.label_msg.setTextFill(javafx.scene.paint.Color.BLACK);
        	this.label_msg.setText("You : "+label_msg.getText()+"\n"+date.getHours()+":"+date.getMinutes());
        }
	}
}
