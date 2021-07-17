package Transitions;

import javafx.animation.FadeTransition;
import javafx.scene.control.Label;
import javafx.util.Duration;

public class FadeTransitionClass implements RunInterface{
	
	FadeTransition trans = new FadeTransition();
	FadeTransition trans1 = new FadeTransition();
	public FadeTransitionClass (double millis_secons, Label label) {
		trans1 = new FadeTransition(Duration.millis(millis_secons),label);
	}
	public FadeTransitionClass () {
		
	}
	@Override
	public void run() {
		trans = trans1;
    	trans.setFromValue(1);
        trans.setToValue(0);
        trans.setCycleCount(FadeTransition.INDEFINITE);                                                                       
//        trans.setCycleCount(4);
        trans.setAutoReverse(true);
        trans.play();
		
	}
	

}