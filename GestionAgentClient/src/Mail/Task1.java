package Mail;

import FXML_Controlers.Controller_Registration;
import FXML_Controlers.Controller_verfication_code;
import javafx.concurrent.Task;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;




public class Task1 extends Task<Void>	{
	private ImageView image;
	private Label label;
	private Label label1;
	private Label label2;
	private Label label3;
	private Label label4;
	private TextField text1;
	private TextField text2;
	private TextField text3;
	private TextField text4;
	private TextField text5;
	private Button button;
	
	@Override
	public Void call() throws Exception  {
		while(JavaMail.send==false) {
			
		}
		System.out.println("checking is finished the value is "+JavaMail.send);
		this.button.setVisible(true);
		return null;
		
		
	}
	
	
	
	
	public Task1(Button button) {
		super();
//		this.image = image;
//		this.label = label;
//		this.label1 = label1;
//		this.label2 = label2;
//		this.label3 = label3;
//		this.label4 = label4;
//		this.text1 = text1;
//		this.text2 = text2;
//		this.text3 = text3;
//		this.text4 = text4;
//		this.text5 = text5;
		this.button = button;
	}

	

	
	
}
