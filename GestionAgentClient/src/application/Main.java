package application;
	

import java.io.IOException;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;




public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("/application/LoadingPage.fxml"));
			Scene scene = new Scene(root,600,200);
			scene.setFill(Color.TRANSPARENT);
			primaryStage.setScene(scene);
			primaryStage.initStyle(StageStyle.TRANSPARENT);
			primaryStage.show();
			Rectangle2D primScreenBounds = Screen.getPrimary().getVisualBounds();
	        primaryStage.setX((primScreenBounds.getWidth() - primaryStage.getWidth()) / 2);
	        primaryStage.setY((primScreenBounds.getHeight() - primaryStage.getHeight()) / 2);
	        primaryStage.show();
	        
	        
	        
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	
}
