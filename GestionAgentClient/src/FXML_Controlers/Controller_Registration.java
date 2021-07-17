package FXML_Controlers;

import java.net.URL;
import java.time.LocalDate;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import com.sun.jmx.snmp.tasks.Task;

import Algorithms.ClassForEmail;
import Algorithms.ClassForSendingAndShowingCodeField;
import Client_package.Client_Class;
import DB_Connection.DBConnection;
import Mail.HTMLcode;
import Mail.JavaMail;
import Mail.JavaMail2;
import Mail.Mythread;
import Mail.Task1;
import Transitions.PauseTranstionClass;
import Transitions.StrategyInterface;
import Transitions.TranslateTransitionClass;
import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;
import tray.animations.AnimationType;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;


public class Controller_Registration implements Initializable{
	
	

	@FXML
    private AnchorPane AnchorPane_Changeable;

    @FXML
    private Label Label_Prenom;

    @FXML
    private JFXTextField textfield_Prenom;

    @FXML
    private Label Lable_Nom;

    @FXML
    private JFXTextField textfield_Nom;

    @FXML
    private Label Label_naissance;

    @FXML
    private JFXDatePicker DatePicker_naissance;

    @FXML
    private Label Label_telephone;

    @FXML
    private JFXTextField textfield_telephone;

    @FXML
    private Button Back_button;

    @FXML
    private Button Next_button;

    @FXML
    private Label Label_utilisateur;

    @FXML
    private JFXTextField textfield_Nom_do_utilisateur;

    @FXML
    private Label Label_email;

    @FXML
    private JFXTextField textfield_email;

    @FXML
    private Label Label_mot_de_passe;

    @FXML
    private JFXPasswordField textfield_mot_de_passe;

    @FXML
    private Label Label_verfificatioin;

    @FXML
    private JFXPasswordField textfield_verification;
    
    private AnimationType type;
    private TrayNotification tray = new TrayNotification();
    
    StrategyInterface trans ;
    private int retour;
    public static int verfication_code;
    public static String email;
    public static Client_Class Client=new Client_Class();
    @Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
    	this.retour++;
    	Label_utilisateur.setVisible(true);
    	textfield_Nom_do_utilisateur.setVisible(true);
    	Label_email.setVisible(true);
    	textfield_email.setVisible(true);
    	Label_mot_de_passe.setVisible(true);
    	textfield_mot_de_passe.setVisible(true);
    	Label_verfificatioin.setVisible(true);
    	textfield_verification.setVisible(true);
    	Label_utilisateur.setLayoutX(350);
    	textfield_Nom_do_utilisateur.setLayoutX(350);
    	Label_email.setLayoutX(350);
    	textfield_email.setLayoutX(350);
    	Label_mot_de_passe.setLayoutX(350);
    	textfield_mot_de_passe.setLayoutX(350);
    	Label_verfificatioin.setLayoutX(350);
    	textfield_verification.setLayoutX(350);
		
	}

    @FXML
    void Click_On_Retour(ActionEvent event) {
    	switch(retour) {
    		case 1:
    			try {
        			
        			AnchorPane_Changeable.getChildren().clear();
        			AnchorPane_Changeable.getChildren().add(FXMLLoader.load(getClass().getResource("/FXML/Login_Client_Page.fxml")));
        			AnchorPane_Changeable.setLayoutX(0);
        			AnchorPane_Changeable.setLayoutY(0);
        	
        			} catch (Exception e) {
        				e.printStackTrace();
        			}
    		break;
    		case 2:
    			Move_page2_to_right();
    			this.retour--;
    			
    		break;
    	}
    	
    	
    	
    	
    	}
    
    @FXML
    void Suivant_Click(ActionEvent event) throws Exception {
    	if(this.retour==2) {
    		Verification_fields_and_sending_verification_code();
    	}else {
    		this.retour++; // give value +1 to know that we passed to another page so retour equal 2 means page 2
        	trans= new TranslateTransitionClass(Label_Prenom, -300, 1200);
        	trans.run();
        	trans= new TranslateTransitionClass(textfield_Prenom, -300, 1200);
        	trans.run();
        	trans= new TranslateTransitionClass(Lable_Nom, -300, 1200);
        	trans= new PauseTranstionClass(trans, 200);
        	trans.run();
        	trans= new TranslateTransitionClass(textfield_Nom, -300, 1200);
        	trans= new PauseTranstionClass(trans, 200);
        	trans.run();
        	trans= new TranslateTransitionClass(Label_telephone, -300, 1200);
        	trans= new PauseTranstionClass(trans, 400);
        	trans.run();
        	trans= new TranslateTransitionClass(textfield_telephone, -300, 1200);
        	trans= new PauseTranstionClass(trans, 400);
        	trans.run();
        	trans= new TranslateTransitionClass(Label_naissance, -300, 1200);
        	trans= new PauseTranstionClass(trans, 600);
        	trans.run();
        	trans= new TranslateTransitionClass(DatePicker_naissance, -300, 1200);
        	trans= new PauseTranstionClass(trans, 600);
        	trans.run();
        	PauseTransition p = new PauseTransition(Duration.millis(1000));
    		p.setOnFinished(e -> this.Showing_Next());
            p.play();
    	}
    	
    	 
  
    	// Do the Pause Transition Okaaaaaaaaaay ???

    }
    public void Verification_fields_and_sending_verification_code() throws Exception {
    	
    	if(textfield_Prenom.getText().trim().isEmpty()||textfield_Nom.getText().trim().isEmpty()||textfield_telephone.getText().trim().isEmpty()
    			||textfield_Nom_do_utilisateur.getText().trim().isEmpty()||textfield_mot_de_passe.getText().isEmpty()
    			||textfield_verification.getText().isEmpty()||textfield_email.getText().trim().isEmpty()
    			|| DatePicker_naissance.getValue()==null) { 		
    		type = AnimationType.POPUP;
			tray.setAnimationType(type);
    		tray.setTitle("vérification des champs");
        	tray.setMessage("un champ ou plusieurs est vide");
        	tray.setNotificationType(NotificationType.WARNING);
        	tray.showAndDismiss(Duration.millis(2000));
    		
    	}else {
    		//verfication email et nom de utilisazteur
    		if(DBConnection.verify_email_of_client(textfield_email.getText().trim()).equals("")) {
    			if(DBConnection.verify_username_of_client(textfield_Nom_do_utilisateur.getText().trim()).equals("")) {
        			if(!(textfield_mot_de_passe.getText().equals(textfield_verification.getText()))) {
        				System.out.println("not the same");
        			}else {
        				verfication_code=(int)Math.floor(Math.random()*(99999-10000+1)+10000);
        				Client.setUsername(textfield_Nom_do_utilisateur.getText().trim());
        				Client.setEmail(textfield_email.getText().trim());
        				Client.setNom(textfield_Nom.getText().trim());
        				Client.setPrenom(textfield_Prenom.getText().trim());
        				Client.setPassword(textfield_mot_de_passe.getText());
        				Client.setPhone_num(textfield_telephone.getText());
        				Client.setDate_birth(DatePicker_naissance.getValue().toString());
        				
        				
        				try {
        	    			Controller_verfication_code.email=textfield_email.getText().trim();
        	    			AnchorPane_Changeable.getChildren().clear();
        	    			AnchorPane_Changeable.getChildren().add(FXMLLoader.load(getClass().getResource("/FXML/Verification_Page.fxml")));
        	    			AnchorPane_Changeable.setLayoutX(0);
        	    			AnchorPane_Changeable.setLayoutY(0);
        	    			email=textfield_email.getText().trim();
        	    			ClassForSendingAndShowingCodeField obj = new ClassForSendingAndShowingCodeField(email);
        	    			ExecutorService executor = Executors.newFixedThreadPool(1);
        	    			executor.submit(obj);
        	    			} catch (Exception e) {
        	    				e.printStackTrace();
        	    			}
        			}
        		}else {
        			type = AnimationType.POPUP;
        			tray.setAnimationType(type);
            		tray.setTitle("vérification nom de Utilisateur ");
                	tray.setMessage("nom de Utilisateur est exist, veuillez changer nom de Utilisateur");
                	tray.setNotificationType(NotificationType.WARNING);
                	tray.showAndDismiss(Duration.millis(2000));
        		}
    		}else {
    			type = AnimationType.POPUP;
    			tray.setAnimationType(type);
        		tray.setTitle("vérification adresse email");
            	tray.setMessage("email est exist, veuillez changer adresse email");
            	tray.setNotificationType(NotificationType.WARNING);
            	tray.showAndDismiss(Duration.millis(2000));
    		}
    		

    	}
    }
    
    public void Showing_Next() {
    	
    	trans= new TranslateTransitionClass(textfield_verification, -288, 1100);
    	trans.run();
    	trans= new TranslateTransitionClass(Label_verfificatioin, -288, 1100);
    	trans.run();
    	trans= new TranslateTransitionClass(textfield_mot_de_passe, -288, 1100);
    	trans= new PauseTranstionClass(trans, 200);
    	trans.run();
    	trans= new TranslateTransitionClass(Label_mot_de_passe, -288, 1100);
    	trans= new PauseTranstionClass(trans, 200);
    	trans.run();
    	trans= new TranslateTransitionClass(textfield_email, -288, 1100);
    	trans= new PauseTranstionClass(trans, 400);
    	trans.run();
    	trans= new TranslateTransitionClass(Label_email, -288, 1100);
    	trans= new PauseTranstionClass(trans, 400);
    	trans.run();
    	trans= new TranslateTransitionClass(textfield_Nom_do_utilisateur, -288, 1100);
    	trans= new PauseTranstionClass(trans, 600);
    	trans.run();
    	trans= new TranslateTransitionClass(Label_utilisateur, -288, 1100);
    	trans= new PauseTranstionClass(trans, 600);
    	trans.run();
    	
    }
    public void Move_page2_to_right() {
    	trans= new TranslateTransitionClass(Label_utilisateur, 288, 1100);
    	trans.run();
    	trans= new TranslateTransitionClass(textfield_Nom_do_utilisateur, 288, 1100);
    	trans.run();
    	trans= new TranslateTransitionClass(Label_email, 288, 1100);
    	trans= new PauseTranstionClass(trans, 400);
    	trans.run();
    	trans= new TranslateTransitionClass(textfield_email, 288, 1100);
    	trans= new PauseTranstionClass(trans, 400);
    	trans.run();
    	trans= new TranslateTransitionClass(Label_mot_de_passe, 288, 1100);
    	trans= new PauseTranstionClass(trans, 600);
    	trans.run();
    	trans= new TranslateTransitionClass(textfield_mot_de_passe, 288, 1100);
    	trans= new PauseTranstionClass(trans, 600);
    	trans.run();
    	trans= new TranslateTransitionClass(Label_verfificatioin, 288, 1100);
    	trans= new PauseTranstionClass(trans, 800);
    	trans.run();
    	trans= new TranslateTransitionClass(textfield_verification, 288, 1100);
    	trans= new PauseTranstionClass(trans, 800);
    	trans.run();
    	PauseTransition p = new PauseTransition(Duration.millis(1000));
		p.setOnFinished(e -> this.Move_Page1_to_right());
        p.play();
    	
    }
    public void Move_Page1_to_right() {
    	trans= new TranslateTransitionClass(DatePicker_naissance, 300, 1200);
    	trans.run();
    	trans= new TranslateTransitionClass(Label_naissance, 300, 1200);
    	trans.run();
    	trans= new TranslateTransitionClass(textfield_telephone, 300, 1200);
    	trans= new PauseTranstionClass(trans, 400);
    	trans.run();
    	trans= new TranslateTransitionClass(Label_telephone, 300, 1200);
    	trans= new PauseTranstionClass(trans, 400);
    	trans.run();
    	trans= new TranslateTransitionClass(textfield_Nom, 300, 1200);
    	trans= new PauseTranstionClass(trans, 600);
    	trans.run();
    	trans= new TranslateTransitionClass(Lable_Nom, 300, 1200);
    	trans= new PauseTranstionClass(trans, 600);
    	trans.run();
    	trans= new TranslateTransitionClass(textfield_Prenom, 300, 1200);
    	trans= new PauseTranstionClass(trans, 800);
    	trans.run();
    	trans= new TranslateTransitionClass(Label_Prenom, 300, 1200);
    	trans= new PauseTranstionClass(trans, 800);
    	trans.run();
    }

    }
	


