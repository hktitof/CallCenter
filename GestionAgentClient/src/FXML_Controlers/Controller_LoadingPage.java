package FXML_Controlers;



import java.net.URL;
import java.util.ResourceBundle;

import Transitions.FadeTransitionClass;
import application.Main;
import javafx.concurrent.Task;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.stage.WindowEvent;
import javafx.util.Duration;






public class Controller_LoadingPage extends Main implements Initializable{
	@FXML
    private AnchorPane AnchorPane;
	public static Label static_label_CountingLabel;
	@FXML
    private ProgressBar bar;
	
	@FXML
    private Label CountingLabel;
	
	
	


	public boolean finished=false;
	
	private Stage stage = new Stage();
	
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
		
	}
	
	
	
	
	
	
	@FXML
    void ClickOnLabelToClose(MouseEvent event) {
		((Stage)(((Label)event.getSource()).getScene().getWindow())).close();

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
			
			return 100;
			
		}
		@Override
		public boolean cancel(boolean mayInterruptIfRunning) {
			return super.cancel(mayInterruptIfRunning);
		}
		@Override
		protected void updateProgress(double workDone, double max) {
			if(workDone==100) {
				updateMessage(workDone+" %");
				super.updateProgress(workDone, max);
				try {
					Thread.sleep(500);
					updateMessage("Cliquer ici..");
					FadeTransitionClass trans = new FadeTransitionClass(200,CountingLabel);
					trans.run();
					super.updateProgress(workDone, max);
					ClickOnLabelToClose(null);
					closed();
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
	
	
	

	
	
	
}
