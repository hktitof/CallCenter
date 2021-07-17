package Transitions;

import javafx.animation.TranslateTransition;
import javafx.scene.Node;
import javafx.util.Duration;

public class TranslateTransitionClass implements StrategyInterface {
	private Node node;
	private double Move_X;
	private double Move_Y;
	private String x_or_y;
	private double duration_millis;
	public TranslateTransitionClass(Node node, double Move_x, double duration_millis) {
		this.node=node;
		this.Move_X=Move_x;
		this.duration_millis=duration_millis;
	}
	public TranslateTransitionClass () {
		
	}
	
	
	public void run() {
		TranslateTransition translate = new TranslateTransition();  
        translate.setByX(this.Move_X);  
        translate.setDuration(Duration.millis(this.duration_millis));  
        translate.setNode(this.node);  
        translate.play();  
	}

}
