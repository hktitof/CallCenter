package Algorithms;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils.Text;

import FXML_Controlers.Controller_Registration;
import FXML_Controlers.Controller_verfication_code;
import javafx.application.Platform;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

public class ClassForEmail extends Controller_verfication_code{
	private String email;
	private Button button;
	private Label label1;
	private Label label2;
	private Label label3_add_email;
	private Label label4;
	private TextField text1;
	private TextField text2;
	private TextField text3;
	private TextField text4;
	private TextField text5;
	// contents of Checking
	private ImageView image1_checking;
	private Label label1_checking;
	private Label labe2_checking_add_email;
	
	
	public ClassForEmail(String email) {
		this.button=Controller_verfication_code.button;
		this.label1=Controller_verfication_code.label1_verification_static;
		this.label2=Controller_verfication_code.label2_verification_static;
		this.label3_add_email=Controller_verfication_code.label3_verification_static_add_email;
		this.label4=Controller_verfication_code.label4_verification_static;
		this.text1=Controller_verfication_code.text1;
		this.text2=Controller_verfication_code.text2;
		this.text3=Controller_verfication_code.text3;
		this.text4=Controller_verfication_code.text4;
		this.text5=Controller_verfication_code.text5;
		this.email=email;
		// assignign values to checking attributes contents
		this.image1_checking=Controller_verfication_code.image1_checking_static;
		this.label1_checking=Controller_verfication_code.label1_checking_static;
		this.labe2_checking_add_email=Controller_verfication_code.label2_checking_add_email_static;
	}
	public void show_button() {
		this.button.setVisible(true);
		this.label1.setVisible(true);
		this.label2.setVisible(true);
		this.label3_add_email.setVisible(true);
		System.out.println("Before X is "+label3_add_email.getLayoutX());
		System.out.println("Before width is "+label3_add_email.getWidth());
		this.label4.setVisible(true);
		this.text1.setVisible(true);
		this.text2.setVisible(true);
		this.text3.setVisible(true);
		this.text4.setVisible(true);
		this.text5.setVisible(true);
		this.image1_checking.setVisible(false);
		this.label1_checking.setVisible(false);
		this.labe2_checking_add_email.setVisible(false);
		Platform.runLater(new Runnable(){
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				label3_add_email.setText(email);
				System.out.println("after X is "+label3_add_email.getLayoutX());
				System.out.println("After width is "+label3_add_email.getWidth());
			}
			// do your GUI stuff here
			});
		
	}
	public void show_all_compnents() {
		this.button.setVisible(true);
		this.label1.setVisible(true);
		this.label2.setVisible(true);
		this.label3_add_email.setVisible(true);
		System.out.println("Before X is "+label3_add_email.getLayoutX());
		System.out.println("Before width is "+label3_add_email.getWidth());
		this.label4.setVisible(true);
		this.text1.setVisible(true);
		this.text2.setVisible(true);
		this.text3.setVisible(true);
		this.text4.setVisible(true);
		this.text5.setVisible(true);
		this.image1_checking.setVisible(false);
		this.label1_checking.setVisible(false);
		this.labe2_checking_add_email.setVisible(false);
	}
	
	
}
