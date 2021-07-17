package Algorithms;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import FXML_Controlers.Controller_verfication_code;
import Mail.JavaMail2;
import javafx.application.Platform;

public class ClassForSendingAndShowingCodeField implements Callable<Void>{
		private String receiptient;
		public ClassForSendingAndShowingCodeField(String receiptient) {
			// TODO Auto-generated constructor stub
			this.receiptient=receiptient;
		}
		@Override
		public Void call() throws Exception {
			JavaMail2 obj = new JavaMail2(receiptient);
			ExecutorService executor = Executors.newFixedThreadPool(1);
			Future<Integer> future = executor.submit(obj);
			while (future.get() != 1) {
	
			}
			System.out.println("showing compnenets");
			Controller_verfication_code.image1_checking_static.setVisible(false);
			Controller_verfication_code.label1_checking_static.setVisible(false);
			Controller_verfication_code.label2_checking_add_email_static.setVisible(false);
			Controller_verfication_code.label1_verification_static.setVisible(true);
			Controller_verfication_code.label2_verification_static.setVisible(true);
			Controller_verfication_code.label3_verification_static_add_email.setVisible(true);
			Controller_verfication_code.label4_verification_static.setVisible(true);
			Controller_verfication_code.button.setVisible(true);
			Controller_verfication_code.text1.setVisible(true);
			Controller_verfication_code.text2.setVisible(true);
			Controller_verfication_code.text3.setVisible(true);
			Controller_verfication_code.text4.setVisible(true);
			Controller_verfication_code.text5.setVisible(true);
			
			Platform.runLater(new Runnable(){
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					Controller_verfication_code.label3_verification_static_add_email.setText(receiptient);
				}
				// do your GUI stuff here
				});
//			ClassForEmail obj1 = new ClassForEmail(receiptient);
//			obj1.show_button();
			return null;
		}

}
