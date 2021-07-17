package FXML_Controlers;

import Transitions.FadeTransitionClass;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;


public class test {
	@FXML
    private Label test_label;
	
	FadeTransitionClass trans = new FadeTransitionClass();
	
	
	@FXML
    void do_it(ActionEvent event) {
		trans = new FadeTransitionClass(1000, test_label);
		trans.run();
    }

    @FXML
    void stop_it(ActionEvent event) {

    }
	
	
	

}
