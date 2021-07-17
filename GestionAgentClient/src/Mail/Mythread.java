package Mail;

import FXML_Controlers.Controller_Registration;

public class Mythread extends javafx.concurrent.Task<Void>{

	@Override
	protected Void call() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Verfifying the value of send is Started");
		while(!JavaMail.send) {
			
		}
		System.out.println("JavaMail is done");
		return null;
	}
	
	
	
	

}
