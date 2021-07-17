package application;

import java.io.IOException;

import Algorithms.Stage_Interface;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Run_Admin extends Application{
	
	public static void main(String[] args) throws IOException {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		Stage_Interface stage_obj = new Stage_Interface("Login_Admin", 350, 500);
    	stage_obj.show_interface();
	}

}
