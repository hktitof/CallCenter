package FXML_Controlers;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import DB_Connection.DBConnection;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;
import tray.animations.AnimationType;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;

public class Controller_verfication_code implements Initializable{
	

	@FXML
    private AnchorPane AnchorPane_Changeable;

    @FXML
    private ImageView image_1_checking;

    @FXML
    private Label label_1_checking;

    @FXML
    private Label label_2_checking_add_email;

    @FXML
    private Label label_1_verification;

    @FXML
    private Label label_2_verification;

    @FXML
    private Label label_3_add_email;

    @FXML
    private TextField textfield_1;

    @FXML
    private TextField textfield_2;

    @FXML
    private TextField textfield_3;

    @FXML
    private TextField textfield_4;

    @FXML
    private TextField textfield_5;

    @FXML
    private Label label_4_verification;
    
    //successfully registration page compnents
    @FXML
    private ImageView image_green;
    @FXML
    private Label label_sucess;
    @FXML
    private Label label_felicitation;
    @FXML
    private Button Button_Continue;
    @FXML
    private ImageView image_icon_felicitation;

    @FXML
    private Button round_red;
    public static String email;
    public static Button button;
    public static Label label1_verification_static;
    public static Label label2_verification_static;
    public static Label label3_verification_static_add_email;
    public static TextField text1;
    public static TextField text2;
    public static TextField text3;
    public static TextField text4;
    public static TextField text5;
    public static Label label4_verification_static;
    // Checking contoents 
    public static ImageView image1_checking_static;
    public static Label label1_checking_static;
    public static Label label2_checking_add_email_static;
    
    
    private AnimationType type;
    private TrayNotification tray = new TrayNotification();
    
    @Override
	public void initialize(URL location, ResourceBundle resources) {
    	label_2_checking_add_email.setText(email);
    	label1_verification_static=this.label_1_verification;
    	label2_verification_static=this.label_2_verification;
    	label3_verification_static_add_email=this.label_3_add_email;
    	text1=this.textfield_1;
    	text2=this.textfield_2;
    	text3=this.textfield_3;
    	text4=this.textfield_4;
    	text5=this.textfield_5;
    	label4_verification_static=this.label_4_verification;
    	button=this.round_red;
    	// assigning chekcing contents to static contents
    	image1_checking_static=image_1_checking;
    	label1_checking_static=label_1_checking;
    	label2_checking_add_email_static=label_2_checking_add_email;
	}
    
    @FXML
    void text1_Realeased(KeyEvent event) {
    	if(event.getCode() != KeyCode.BACK_SPACE) {
    		if(event.getText().matches("[0-9]")) {
        		text2.requestFocus();
        	}else {
        		text1.setText("");
        		text1.setStyle("-fx-focus-color: red;");
        	}
    	}
    }

    @FXML
    void text1_inputPressed(KeyEvent event) {
    	if(event.getText().matches("[0-9]")) {
    		text1.setText(event.getText());
    		text1.setStyle("-fx-focus-color: blue;");
    	}else {
    		text1.setStyle("-fx-focus-color: red;");
    	}
    }

    @FXML
    void text2_Realeased(KeyEvent event) {
    	if(event.getCode() != KeyCode.BACK_SPACE) {
    		if(event.getText().matches("[0-9]")) {
        		text3.requestFocus();
        	}else {
        		text2.setText("");
        		text2.setStyle("-fx-focus-color: red;");
        	}	
    	}
    }

    @FXML
    void text2_inputPressed(KeyEvent event) {
    	if(event.getCode() == KeyCode.BACK_SPACE && text2.getText().isEmpty()) {
    		text1.requestFocus();
    	}else if(event.getCode() == KeyCode.BACK_SPACE) {
    		text2.setText("");
    		
    	}else if(event.getText().matches("[0-9]")) {
    		text2.setText(event.getText());
    		text2.setStyle("-fx-focus-color: blue;");
    	}else {
    		text2.setStyle("-fx-focus-color: red;");
    	}
    }

    @FXML
    void text3_Realeased(KeyEvent event) {
    	if(event.getCode() != KeyCode.BACK_SPACE) {
    		 if(event.getText().matches("[0-9]")) {
    	    		text4.requestFocus();
    	    	}else {
    	    		text3.setText("");
    	    		text3.setStyle("-fx-focus-color: red;");
    	    	}
    	}
    }

    @FXML
    void text3_inputPressed(KeyEvent event) {
    	if(event.getCode() == KeyCode.BACK_SPACE && text3.getText().isEmpty()) {
    		text2.requestFocus();
    	}else if(event.getCode() == KeyCode.BACK_SPACE) {
    		text3.setText("");
    	}else if(event.getText().matches("[0-9]")) {
    		text3.setText(event.getText());
    		text3.setStyle("-fx-focus-color: blue;");
    	}else {
    		text3.setStyle("-fx-focus-color: red;");
    	}
    }

    @FXML
    void text4_Realeased(KeyEvent event) {
    	if(event.getCode() != KeyCode.BACK_SPACE) {
    		if(event.getText().matches("[0-9]")) {
        		text5.requestFocus();
        	}else{
        		text4.setText("");
        		text4.setStyle("-fx-focus-color: red;");
        	}	
    	}
    }

    @FXML
    void text4_inputPressed(KeyEvent event) {
    	if(event.getCode() == KeyCode.BACK_SPACE && text4.getText().isEmpty()) {
    		text3.requestFocus();
    	}else if(event.getCode() == KeyCode.BACK_SPACE) {
    		text4.setText("");
    		
    	}else if(event.getText().matches("[0-9]")) {
    		text4.setText(event.getText());
    		text4.setStyle("-fx-focus-color: blue;");
    	}else {
    		text4.setStyle("-fx-focus-color: red;");
    	}
    }

    @FXML
    void text5_Realeased(KeyEvent event) throws NumberFormatException, SQLException {
    	if(event.getText().matches("[0-9]")) {
    		if(!(textfield_1.getText().isEmpty()||textfield_2.getText().isEmpty()||textfield_3.getText().isEmpty()||textfield_4.getText().isEmpty()
    				||textfield_5.getText().isEmpty())) {
    			if(Integer.parseInt(String.valueOf(textfield_1.getText().charAt(0))+String.valueOf(textfield_2.getText().charAt(0))
    			+String.valueOf(textfield_3.getText().charAt(0))+String.valueOf(textfield_4.getText().charAt(0))
    				+String.valueOf(textfield_5.getText().charAt(0)))==Controller_Registration.verfication_code) {
    				
    				System.out.println("it's the same, succefully");
    				DBConnection.add_new_user(Controller_Registration.Client.getUsername(), 
    											Controller_Registration.Client.getEmail(), 
    											Controller_Registration.Client.getPrenom(), 
    											Controller_Registration.Client.getNom(), 
    											Controller_Registration.Client.getPhone_num(), 
    											Controller_Registration.Client.getDate_birth(), 
    											Controller_Registration.Client.getPassword());
    				Controller_verfication_code.label1_verification_static.setVisible(false);
    				Controller_verfication_code.label2_verification_static.setVisible(false);
    				Controller_verfication_code.label3_verification_static_add_email.setVisible(false);
    				Controller_verfication_code.label4_verification_static.setVisible(false);
    				Controller_verfication_code.button.setVisible(false);
    				Controller_verfication_code.text1.setVisible(false);
    				Controller_verfication_code.text2.setVisible(false);
    				Controller_verfication_code.text3.setVisible(false);
    				Controller_verfication_code.text4.setVisible(false);
    				Controller_verfication_code.text5.setVisible(false);
    				label_sucess.setVisible(true);;
    			    label_felicitation.setVisible(true);
    			    Button_Continue.setVisible(true);;
    			    image_green.setVisible(true);
    			    image_icon_felicitation.setVisible(true);
    			    
    			}else {
    				type = AnimationType.POPUP;
        			tray.setAnimationType(type);
            		tray.setTitle("Verfication du code");
                	tray.setMessage("Code de verification est Incorrect");
                	tray.setNotificationType(NotificationType.ERROR);
                	tray.showAndDismiss(Duration.millis(500));
    			}
    		}
//    		if(Controller_Registration.verfication_code==Integer.parseInt(textfield_1.getText()+
//    				textfield_2.getText()+textfield_3.getText()+textfield_4.getText()+textfield_5.getText())) {
//    			System.out.println("Succeful Registration");
//    		}else {
//    			System.out.println("Verificatoin code is incorect");
//    		}
    		text5.setStyle("-fx-focus-color: blue;");
    	}else {
    		text5.setText("");
    		text5.setStyle("-fx-focus-color: red;");
    	}
    }
    
    @FXML
    void Pressed_On_Continue(MouseEvent event) {
    	
    	try {
			
    		AnchorPane_Changeable.getChildren().clear();
    		AnchorPane_Changeable.getChildren().add(FXMLLoader.load(getClass().getResource("/FXML/Login_Client_Page.fxml")));
    		AnchorPane_Changeable.setLayoutX(0);
    		AnchorPane_Changeable.setLayoutY(0);
	
			} catch (Exception e) {
		// TODO: handle exception
			}
		
		
    	
    	
    }
    @FXML
    void Pressed_ON_Verifier_Button(MouseEvent event) {
    	if(!(textfield_1.getText().isEmpty()||textfield_2.getText().isEmpty()||textfield_3.getText().isEmpty()||textfield_4.getText().isEmpty()
				||textfield_5.getText().isEmpty())) {
			if(Integer.parseInt(String.valueOf(textfield_1.getText().charAt(0))+String.valueOf(textfield_2.getText().charAt(0))
			+String.valueOf(textfield_3.getText().charAt(0))+String.valueOf(textfield_4.getText().charAt(0))
				+String.valueOf(textfield_5.getText().charAt(0)))==Controller_Registration.verfication_code) {
				System.out.println("Clicked on button verify and code de verification is correct");
			}else {
				type = AnimationType.POPUP;
    			tray.setAnimationType(type);
        		tray.setTitle("Verfication du code");
            	tray.setMessage("Code de verification est Incorrect");
            	tray.setNotificationType(NotificationType.ERROR);
            	tray.showAndDismiss(Duration.millis(500));
			}
		}
    }
    @FXML
    void text5_inputPressed(KeyEvent event) {
    	if(event.getCode() == KeyCode.BACK_SPACE && text5.getText().isEmpty()) {
    		text4.requestFocus();
    	}else if(event.getCode() == KeyCode.BACK_SPACE) {
    		text5.setText("");
    	}else if(event.getText().matches("[0-9]")) {
    		text5.setText(event.getText());
    		text5.setStyle("-fx-focus-color: blue;");
    	}else {
    		text5.setStyle("-fx-focus-color: red;");
    	}
    }
}
