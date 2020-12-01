package application;


import java.net.URL;
import java.util.ResourceBundle;

import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.stage.Stage;
import javafx.stage.Window;






public class Controller_LoadingPage implements Initializable{
	@FXML
    private AnchorPane AnchorPane;
	public static Label static_label_CountingLabel;
	@FXML
    private ProgressBar bar;
	@FXML private javafx.scene.control.Label CountingLabel;
	


	public boolean finished=false;
	
	
	@Override
	public void initialize(URL location, ResourceBundle arg1) {
		AnchorPane.setBackground(Background.EMPTY);
		static_label_CountingLabel=CountingLabel;
		finished=true;
		Dowork task = new Dowork();
		bar.progressProperty().bind(task.progressProperty());
		static_label_CountingLabel.textProperty().bind(task.messageProperty());
		new Thread(task).start();	
	
	}
	
	public void closed() {
		Stage stage = (Stage) CountingLabel.getScene().getWindow();
		  // do what you have to do
		  stage.close();
	}
	
	
	class Dowork extends Task<Integer> {
		private boolean finished=false;
		
		public boolean isFinished() {
			return finished;
		}
		public void setFinished(boolean finished) {
			this.finished = finished;
		}
		@Override
		protected Integer call() throws Exception {
			for (int i =0; i<100; i++) {
				updateProgress(i+1, 100);
				Thread.sleep(50);
				if(i==99) {
					Thread.sleep(1000);
				}
				if(isCancelled()) {
					return i;
				}
				
			}
			finished=true;
			Thread.sleep(500);
			System.out.println("Click here to open..");
			Stage stage = (Stage) bar.getScene().getWindow();
			  // do what you have to do
			  stage.close();
			return 100;
			
		}
		@Override
		public boolean cancel(boolean mayInterruptIfRunning) {
			return super.cancel(mayInterruptIfRunning);
		}
		@Override
		protected void updateProgress(double workDone, double max) {
			//System.out.println(percentStringList[0]);
			if(workDone==100) {
				updateMessage(workDone+" %");
				super.updateProgress(workDone, max);
				try {
					Thread.sleep(500);
					updateMessage("Click here..");
					super.updateProgress(workDone, max);
					Stage stage = (Stage) bar.getScene().getWindow();
					  // do what you have to do
					  stage.close();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else {
				updateMessage(workDone+" %");
				super.updateProgress(workDone, max);	
			}
			
		}
	}
	
	public boolean isFinishe() {
		return finished;
	}
	

	
	
	
}
