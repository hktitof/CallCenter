package Algorithms;

import java.io.IOException;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Screen;
import javafx.stage.Stage;


public class Stage_Interface {
	private String path;
	private int height;
	private int width;
	private Stage primaryStage=new Stage();
	public static String type;
	
	public Stage_Interface () {
		
	}
	public Stage_Interface(String path, int height, int width) {
		this.path=path;
		this.height=height;
		this.width=width;
	}
	
	
	
	public void show_interface() throws IOException {

    	Parent root = FXMLLoader.load(getClass().getResource("/FXML/"+path+".fxml"));
		Scene scene = new Scene(root,this.height,this.width);
		scene.setFill(Color.TRANSPARENT);
		
		primaryStage.setScene(scene);
//		primaryStage.initStyle(StageStyle.TRANSPARENT);
		primaryStage.show();
		Rectangle2D primScreenBounds = Screen.getPrimary().getVisualBounds();
        primaryStage.setX((primScreenBounds.getWidth() - primaryStage.getWidth()) / 2);
        primaryStage.setY((primScreenBounds.getHeight() - primaryStage.getHeight()) / 2);
        primaryStage.show();
		
	}

}
