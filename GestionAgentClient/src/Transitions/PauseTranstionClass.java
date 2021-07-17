package Transitions;

import javafx.animation.PauseTransition;
import javafx.util.Duration;

public class PauseTranstionClass implements StrategyInterface{
	private StrategyInterface obj;
	private double duration_millis;
	PauseTransition p = new PauseTransition();
	public PauseTranstionClass(StrategyInterface obj,double duration_millis) {
		this.obj=obj;
		this.duration_millis=duration_millis;
	}
	
	
	public void run() {
		p = new PauseTransition(Duration.millis(duration_millis));
		p.setOnFinished(e -> this.obj.run());
        p.play();
		
	}

}
