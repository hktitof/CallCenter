package DB_Connection;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.print.attribute.DateTimeSyntax;
import javax.swing.ImageIcon;

import com.sun.javafx.tk.Toolkit;
import com.sun.org.apache.xpath.internal.operations.Bool;

import Admin_Classes.agent_get_user_email_password_class;
import Chat.GetMsgFor_listview_agent;
import Chat.Msg_object_for_agent;
import Client.Module_Reclamation_modifier;
import Controllers_Admin.Module_list_agent;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;
import tray.animations.AnimationType;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;

public class DBConnection {
	private static final String USERNAME = "root";
	private static final String PASSWORD = "";
	private static final String HOST = "127.0.0.1";
	private static final int PORT = 3306;
	private static final String DB_NAME = "agentclient";
	public static TrayNotification tray = new TrayNotification();
	public static AnimationType type;
	public static String sql;
	public static PreparedStatement stat ;
	public static ResultSet rs ;
	public static java.util.List<String> list=new ArrayList<String>();
	public static ObservableList<String> list_id=FXCollections.observableList(list);
	public static String[] client_info= new String[8];
	public static String id_agent=null;
	public static String id_client=null;
	public static Boolean client_cnv_current_boolean;
	public static int var_for_verification;
	public static Boolean client_Conv_with_boolean;
	public static int last_msg_agent;
	public static int agent_Last_cnv_id;
	public static LinkedHashMap<Integer, Msg_object_for_agent> linkedHashmap = new LinkedHashMap<Integer, Msg_object_for_agent>();
	public static java.util.List<Msg_object_for_agent> normal_list_for_msg_ageent= new ArrayList<Msg_object_for_agent>();
	public static ObservableList<Msg_object_for_agent> msg_list_for_agent=FXCollections.observableList(normal_list_for_msg_ageent);	
	public static int var_for_test;
	public static int last_id_msg;
	public static int cnv_id_client;
	public static int var_for_test_client;
	public static java.util.List<Msg_object_for_agent> normal_list_for_msg_client= new ArrayList<Msg_object_for_agent>();
	public static ObservableList<Msg_object_for_agent> msg_list_for_client=FXCollections.observableList(normal_list_for_msg_client);	
	public static java.util.List<Module_list_agent> normal_list_agent = new ArrayList<Module_list_agent>();
	public static ObservableList<Module_list_agent> obs_list_agent=FXCollections.observableList(normal_list_agent);
	public static agent_get_user_email_password_class agent_info_obj=new agent_get_user_email_password_class();
	public static java.util.List<Module_Reclamation_modifier> normal_list_client_reclamation_ouvert = new ArrayList<Module_Reclamation_modifier>();
	public static ObservableList<Module_Reclamation_modifier> obs_list_client_reclamation_ouvert=FXCollections.observableList(normal_list_client_reclamation_ouvert);
	public static Connection connect() throws SQLException {
		try {
			Connection conn = DriverManager.getConnection("jdbc:mysql://" + HOST +":"+ PORT +"/"+DB_NAME, USERNAME, PASSWORD);
			return conn;
			
		} catch (SQLException e) {
			
			return null;
			
		}
	}
	
	public static Boolean Check_Conection() throws SQLException {
		if(connect()==null) {
			type = AnimationType.POPUP;
			tray.setAnimationType(type);
    		tray.setTitle("Oops");
        	tray.setMessage("connexion échoue");
        	tray.setNotificationType(NotificationType.ERROR);
        	tray.showAndDismiss(Duration.millis(3000));
			return false;
		}
		connect().close();
		return true;
	}
	public static Boolean Client_login(String username,String password) throws SQLException {
		if(Check_Conection()) {
			sql = "SELECT username,password FROM users_client WHERE username=? and password=?";
			stat=connect().prepareStatement(sql);
			stat.setString(1, username);
			stat.setString(2, password);
			rs=stat.executeQuery();
			String var_username=null,var_password=null;
			while(rs.next()) {
				var_username=rs.getString(1);
				var_password=rs.getString(2);
			}
			if(var_password==null || var_username==null) {
				return false;
			}else {
				return true;
			}
		}
		return false;
	}
	public static String get_agent_id(String username) throws SQLException {
		id_agent=null;
		if(Check_Conection()) {
			sql = "SELECT id from users_agent where username=?";
			stat=connect().prepareStatement(sql);
			stat.setString(1, username);
			rs=stat.executeQuery();
			while(rs.next()) {
				id_agent=rs.getString(1);
			}
			list_id=FXCollections.observableList(list);
			return id_agent;
		}
		return id_agent;
	}
	public static Boolean Agent_login(String username,String password) throws SQLException {
		if(Check_Conection()) {
			sql = "SELECT username,password FROM users_agent WHERE username=? and password=?";
			stat=connect().prepareStatement(sql);
			stat.setString(1, username);
			stat.setString(2, password);
			rs=stat.executeQuery();
			String var_username=null,var_password=null;
			while(rs.next()) {
				var_username=rs.getString(1);
				var_password=rs.getString(2);
			}
			if(var_password==null || var_username==null) {
				connect().close();
				return false;
			}else {
				connect().close();
				return true;
			}
		}
		connect().close();
		return false;
	}
	
	public static ObservableList<String>  get_all_online_id() throws SQLException{
		list_id.clear();
		if(Check_Conection()) {
			sql = "SELECT id from users_client where Cnv_status!=0 and Conv_with=0";
			stat=connect().prepareStatement(sql);
			rs=stat.executeQuery();
			while(rs.next()) {
				list.add(String.valueOf(rs.getInt(1)));
			}
			list_id=FXCollections.observableList(list);
			connect().close();
			return list_id;
		}
		connect().close();
		return list_id;
		
	}
	public static void change_value_Conv_with_for_client_status(String id) throws SQLException {
		if(Check_Conection()) {
			sql = "update users_client set Conv_with=1 where id=?";
			stat=connect().prepareStatement(sql);
			stat.setString(1, id);;
			stat.executeUpdate();
			connect().close();
			System.out.println("the value Conv_with for client id : "+id+" is changed to true so agent will open the conversation and cline will get a notifcation");
		}
		
	}
	public static String[] get_user_information_for_agent(String passed_id) throws SQLException {
		if(Check_Conection()) {
			sql = "SELECT username,email,prenom,nom,phone_num,d_birth,password,last_log FROM users_client WHERE id=?";
			stat=connect().prepareStatement(sql);
			stat.setString(1, passed_id);
			rs=stat.executeQuery();
			String username=null,email=null,prenom=null
					,nom=null,telephone=null,date_naiss=null,
					motPass=null,derniere_cnx=null;
			while(rs.next()) {
				username=rs.getString(1);
				email=rs.getString(2);
				prenom=rs.getString(3);
				nom=rs.getString(4);
				telephone=rs.getString(5);
				date_naiss=rs.getString(6);
				motPass=rs.getString(7);
				derniere_cnx=rs.getString(8);
			}
			if(username!=null && email!=null && prenom!=null && nom!=null && 
					telephone!=null && date_naiss!=null && motPass!=null && derniere_cnx!=null ) {
				client_info[0]=username;
				client_info[1]=email;
				client_info[2]=prenom;
				client_info[3]=nom;
				client_info[4]=telephone;
				client_info[5]=date_naiss;
				client_info[6]=motPass;
				client_info[7]=derniere_cnx;
				connect().close();
				return client_info;
			}else {
				type = AnimationType.POPUP;
				tray.setAnimationType(type);
	    		tray.setTitle("Récupération échoue");
	        	tray.setMessage("un Champ ou plusieurs de client est null");
	        	tray.setNotificationType(NotificationType.ERROR);
	        	tray.showAndDismiss(Duration.millis(4000));
			}
		}
		for (int i = 0; i < client_info.length; i++) {
			client_info[i]=null;
		}
		connect().close();
		return client_info;
	}
	public static void Create_conv(String id_client, String id_agent) throws SQLException {
		if(Check_Conection()) {
			sql = "INSERT INTO cnv(client_id,agent_id,dt_opened) VALUES (?, ?,Null)";
			stat=connect().prepareStatement(sql);
			stat.setInt(1, Integer.valueOf(id_client));
			stat.setInt(2, Integer.valueOf(id_agent));
			int i = stat.executeUpdate();
			if (i==0) {
				System.out.println(" Creation cnv on DB Operation is failed");
				connect().close();
			}else {
				connect().close();
				System.out.println("Conversation is succefully created on DB for client "+id_client+" and agent "+id_agent);
			}
			
		}
	}
	public static void Set_client_cnv_status_to_true(int id) throws SQLException {
		if(Check_Conection()) {
			sql = "update users_client set Cnv_status=1 where id=?";
			stat=connect().prepareStatement(sql);
			stat.setInt(1, id);;
			stat.executeUpdate();
			connect().close();
			System.out.println("Client id "+id+" cnv statut is set to true");
		}
	}
	public static String get_id_client(String username) throws SQLException {
		if(Check_Conection()) {
			sql = "SELECT id from users_client where username=?";
			stat=connect().prepareStatement(sql);
			stat.setString(1, username);
			rs=stat.executeQuery();
			while(rs.next()) {
				id_client=rs.getString(1);
			}
			connect().close();
			return id_client;
		}
		connect().close();
		return id_client;
		
	}
	public static Boolean verification_client_cnv_current_status(int id) throws SQLException {
		client_cnv_current_boolean=false;
		if(Check_Conection()) {
			sql="select Cnv_status from users_client where id=?";
			stat=connect().prepareStatement(sql);
			stat.setInt(1, id);
			rs=stat.executeQuery();
			while(rs.next()) {
				client_cnv_current_boolean=rs.getBoolean(1);
			}
			connect().close();
			return client_cnv_current_boolean;
		}
		connect().close();
		return client_cnv_current_boolean;
	}
	public static Boolean get_Cnv_with_of_client_value(int id) throws SQLException {
		client_Conv_with_boolean=false;
		System.out.println("entered to here sql cnv_with_of_client");
		if(Check_Conection()) {
			sql="select Conv_with from users_client where id=?";
			stat=connect().prepareStatement(sql);
			stat.setInt(1, id);
			rs=stat.executeQuery();
			while(rs.next()) {
				client_Conv_with_boolean=rs.getBoolean(1);
			}
			System.out.println("the value of cnv With of client is "+client_Conv_with_boolean);
			connect().close();
			return client_Conv_with_boolean;
		}
		connect().close();
		return client_Conv_with_boolean;
	}
	public static int get_Cnv_id_of_agent_value(int id) throws SQLException {
		System.out.println("Preparing to get agent_Last_cnv");
		if(Check_Conection()) {
			sql="select Last_cnv from users_agent where id=?";
			stat=connect().prepareStatement(sql);
			stat.setInt(1, id);
			rs=stat.executeQuery();
			while(rs.next()) {
				agent_Last_cnv_id=rs.getInt(1);
			}
			System.out.println("the value of cnv_id of agent is "+agent_Last_cnv_id);
			connect().close();
			return agent_Last_cnv_id;
		}
		connect().close();
		return agent_Last_cnv_id;
	}
	public ObservableList<Msg_object_for_agent> get_all_msg_for_agent(int cnv,int id_msg) throws SQLException {
		System.out.println("Preparing to get rows from msg for cnv_id "+cnv);
		normal_list_for_msg_ageent.clear();
		msg_list_for_agent.clear();
		if(Check_Conection()) {
			sql="select msg_seq,content,from_client_is0_or_agent1 from msg where cnv_id=? and msg_seq>=? and from_client_is0_or_agent1=0";
			stat=connect().prepareStatement(sql);
			stat.setInt(1, cnv);
			stat.setInt(2, id_msg);
			rs=stat.executeQuery();
			while(rs.next()) {
				normal_list_for_msg_ageent.add(new Msg_object_for_agent(rs.getInt(1), rs.getString(2)));
			}
			connect().close();
			System.out.println("he is here");
			msg_list_for_agent=FXCollections.observableList(normal_list_for_msg_ageent);
			return msg_list_for_agent;
		}
		return msg_list_for_agent;
	}
	public int get_last_msg_in_cnv(int cnv) throws SQLException {
		System.out.println("getting last msg for cnv id : "+cnv);
		var_for_test=0;
		if(Check_Conection()) {
			sql="SELECT msg_seq FROM msg WHERE msg_seq=(SELECT max(msg_seq) FROM msg where cnv_id=?) and cnv_id=?";
			stat=connect().prepareStatement(sql);
			stat.setInt(1, cnv);
			stat.setInt(2, cnv);
			rs=stat.executeQuery();
			while(rs.next()) {
				var_for_test=rs.getInt(1);
			}
		}
		return var_for_test;
	}
	public int get_last_msg_in_cnv_for_agent(int cnv) throws SQLException {
		var_for_test=0;
		if(Check_Conection()) {
			sql="SELECT msg_seq FROM msg WHERE msg_seq=(SELECT max(msg_seq) FROM msg where cnv_id=?) and cnv_id=? and from_client_is0_or_agent1=0";
			stat=connect().prepareStatement(sql);
			stat.setInt(1, cnv);
			stat.setInt(2, cnv);
			rs=stat.executeQuery();
			while(rs.next()) {
				var_for_test=rs.getInt(1);
			}
		}
		connect().close();
		return var_for_test;
	}
	public void insert_msg_from_agent_to_db(String msg,int cnv_id) throws NumberFormatException, SQLException {
		if(Check_Conection()) {
			sql = "INSERT INTO msg(cnv_id,content,from_client_is0_or_agent1) values(?,?,1)";
			stat=connect().prepareStatement(sql);
			stat.setInt(1, cnv_id);
			stat.setString(2, msg);
			stat.executeUpdate();
			connect().close();
		}
		
	}
	public int get_cnv_id_for_client(int client_id) throws SQLException {
		cnv_id_client=0;
		if(Check_Conection()) {
			sql="SELECT cnv_current from users_client where id=?";
			stat=connect().prepareStatement(sql);
			stat.setInt(1, client_id);
			rs=stat.executeQuery();
			while(rs.next()) {
				cnv_id_client=rs.getInt(1);
			}
		}
		connect().close();
		return cnv_id_client;
	}
	
	public void insert_msg_from_client_to_db(String msg,int cnv_id) throws NumberFormatException, SQLException {
		if(Check_Conection()) {
			sql = "INSERT INTO msg(cnv_id,content,from_client_is0_or_agent1) values(?,?,0)";
			stat=connect().prepareStatement(sql);
			stat.setInt(1, cnv_id);
			stat.setString(2, msg);
			stat.executeUpdate();
			connect().close();
		}
		
	}
	public int get_last_msg_in_cnv_for_client(int cnv) throws SQLException {
		var_for_test_client=0;
		if(Check_Conection()) {
			sql="SELECT msg_seq FROM msg WHERE msg_seq=(SELECT max(msg_seq) FROM msg where cnv_id=?) and cnv_id=? and from_client_is0_or_agent1=1";
			stat=connect().prepareStatement(sql);
			stat.setInt(1, cnv);
			stat.setInt(2, cnv);
			rs=stat.executeQuery();
			while(rs.next()) {
				var_for_test_client=rs.getInt(1);
			}
		}
		connect().close();
		return var_for_test_client;
	}
	public ObservableList<Msg_object_for_agent> get_all_msg_for_client(int cnv,int id_msg) throws SQLException {
//		System.out.println("Preparing to get rows from msg for cnv_id "+cnv);
		normal_list_for_msg_client.clear();
		msg_list_for_client.clear();
		if(Check_Conection()) {
			sql="select msg_seq,content,from_client_is0_or_agent1 from msg where cnv_id=? and msg_seq>=? and from_client_is0_or_agent1=1";
			stat=connect().prepareStatement(sql);
			stat.setInt(1, cnv);
			stat.setInt(2, id_msg);
			rs=stat.executeQuery();
			while(rs.next()) {
				normal_list_for_msg_client.add(new Msg_object_for_agent(rs.getInt(1), rs.getString(2)));
			}
			connect().close();
			System.out.println("he is here");
			msg_list_for_client=FXCollections.observableList(normal_list_for_msg_client);
			return msg_list_for_client;
		}
		return msg_list_for_client;
	}
	/// REgistration client
	public static String verify_email_of_client(String email) throws SQLException {
		String get_email="";
		if(Check_Conection()) {
			sql="SELECT email FROM users_client WHERE email=?";
			stat=connect().prepareStatement(sql);
			stat.setString(1, email);
			rs=stat.executeQuery();
			int resultat=0;
			while(rs.next()) {
				get_email=rs.getString(1);
			}
		}
		return get_email;
	}
	public static String verify_username_of_client(String username) throws SQLException {
		String get_username="";
		if(Check_Conection()) {
			sql="SELECT username FROM users_client WHERE username=?";
			stat=connect().prepareStatement(sql);
			stat.setString(1, username);
			rs=stat.executeQuery();
			while(rs.next()) {
				get_username=rs.getString(1);
			}
		}
		return get_username;
	}
	public static void add_new_user(String username,String email,String prenom, String nom, String phone_num, String d_birth, String password) throws NumberFormatException, SQLException {
		if(Check_Conection()) {
			sql = "INSERT INTO users_client(username,email,prenom,nom,phone_num,d_birth,password) VALUES (?,?,?,?,?,?,?)";
			stat=connect().prepareStatement(sql);
			stat.setString(1, username);
			stat.setString(2, email);
			stat.setString(3, prenom);
			stat.setString(4, nom);
			stat.setString(5, phone_num);
			stat.setString(6, d_birth);
			stat.setString(7, password);
			int i = stat.executeUpdate();
			if (i==0) {
				System.out.println("Error Client is not Inserted");
				connect().close();
			}else {
				connect().close();
				System.out.println("Client usernmae \""+username+"\" is Inserted succefully to DB");
			}
			
		}
	}
	
	public static void Update_last_login_Client(String username) throws SQLException {
		if(Check_Conection()) {
			sql = "update users_client set last_log=? where username=?";
			stat=connect().prepareStatement(sql);
			stat.setString(2, username);
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
		    Date date = new Date();   
			stat.setString(1, formatter.format(date));
			stat.setString(2, username);
			stat.executeUpdate();
			connect().close();
			System.out.println("last login is updated for client username "+username);
		}
	}
	
	public static Boolean login_admin(String username,String password) throws SQLException {
		if(Check_Conection()) {
			sql = "SELECT username,password FROM admin WHERE username=? and password=?";
			stat=connect().prepareStatement(sql);
			stat.setString(1, username);
			stat.setString(2, password);
			rs=stat.executeQuery();
			String var_username=null,var_password=null;
			while(rs.next()) {
				var_username=rs.getString(1);
				var_password=rs.getString(2);
			}
			if(var_password==null || var_username==null) {
				return false;
			}else {
				return true;
			}
		}
		return false;
	}
	
	public static ObservableList<Module_list_agent> get_agent_info() throws FileNotFoundException, SQLException{
		normal_list_agent.clear();
		obs_list_agent.clear();
		if(Check_Conection()) {
			sql="select id,username,email,password,Conv_status from users_agent";
			stat=connect().prepareStatement(sql);
			rs=stat.executeQuery();
			while(rs.next()) {
				if(rs.getBoolean(5)) {
					Image image = new Image("/images/Online icon.png");
					ImageView imageview = new ImageView(image);
					imageview.setFitWidth(60);
					imageview.setFitHeight(20);
					normal_list_agent.add(new Module_list_agent(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), imageview));
				}else {
//					Image image = new Image(new FileInputStream("/DB_Connection/Offline.png"));
					Image image = new Image("/images/Offline.png");
					ImageView imageview = new ImageView(image);
					imageview.setFitWidth(60);
					imageview.setFitHeight(20);
					normal_list_agent.add(new Module_list_agent(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), imageview));
				}
				
			}
			connect().close();
			System.out.println("Agent info has been successfully loaded");
			obs_list_agent=FXCollections.observableList(normal_list_agent);
			return obs_list_agent;
		}
		return obs_list_agent;
	}
	public static void Set_agent_status_to_online(String username) throws SQLException {
		if(Check_Conection()) {
			sql = "update users_agent set Conv_status=1 where username=?";
			stat=connect().prepareStatement(sql);
			stat.setString(1, username);
			stat.executeUpdate();
			connect().close();
			System.out.println("last login is updated for client username "+username);
		}
	}
	public static void add_agent_to_DB(String username,String email,String password) throws NumberFormatException, SQLException {
		if(Check_Conection()) {
			sql = "INSERT INTO users_agent(username,email,password) VALUES (?, ?,?)";
			stat=connect().prepareStatement(sql);
			stat.setString(1, username);
			stat.setString(2, email);
			stat.setString(3, password);
			int i = stat.executeUpdate();
			if (i==0) {
				System.out.println("adding the agent to DB is failed");
				connect().close();
			}else {
				connect().close();
				System.out.println("Agent "+username+" is Successfully added to DB");
			}
			
		}
	}
	public static Boolean get_agent_email(String email) throws SQLException {
		if(Check_Conection()) {
			sql="SELECT email FROM users_agent WHERE email=?";
			stat=connect().prepareStatement(sql);
			stat.setString(1, email);
			rs=stat.executeQuery();
			while(rs.next()) {
				if(rs.getString(1).equals(email)) {
					return true;
				}else {
					return false;
				}
			}
		}
		return false;
	}
	public static Boolean get_agent_username(String username) throws SQLException {
		if(Check_Conection()) {
			sql="SELECT username FROM users_agent WHERE username=?";
			stat=connect().prepareStatement(sql);
			stat.setString(1, username);
			rs=stat.executeQuery();
			while(rs.next()) {
				if(rs.getString(1).equals(username)) {
					return true;
				}else {
					return false;
				}
			}
		}
		return false;
	}
	public static Boolean get_agent_id(int id) throws SQLException {
		if(Check_Conection()) {
			sql="SELECT id FROM users_agent WHERE id=?";
			stat=connect().prepareStatement(sql);
			stat.setInt(1, id);
			rs=stat.executeQuery();
			while(rs.next()) {
				if(rs.getInt(1)==id) {
					return true;
				}else {
					return false;
				}
			}
		}
		return false;
	}
	public static agent_get_user_email_password_class get_username_email_password(int id) throws SQLException {
		if(Check_Conection()) {
			sql="select username,email,password from users_agent where id=?";
			stat=connect().prepareStatement(sql);
			stat.setInt(1, id);
			rs=stat.executeQuery();
			while(rs.next()) {
				agent_info_obj.setUsername(rs.getString(1));
				agent_info_obj.setEmail(rs.getString(2));
				agent_info_obj.setPassword(rs.getString(3));
			}
			
		}
		return agent_info_obj;
	}
	public static void update_agent_username_email_password(String username,String email,String password,int id) throws SQLException {
		if(Check_Conection()) {
			sql = "update users_agent set username=?,email=?,password=? where id=?";
			stat=connect().prepareStatement(sql);
			stat.setInt(4, id);
			stat.setString(1, username);
			stat.setString(2, email);
			stat.setString(3, password);
			stat.executeUpdate();
			connect().close();
			System.out.println("agent "+id+" info is successfully updated");
		}
		
	}
	public static void delete_agent(int id) throws SQLException {
		if(Check_Conection()) {
			sql = "delete from users_agent where id=?";
			stat=connect().prepareStatement(sql);
			stat.setInt(1, id);
			stat.executeUpdate();
			connect().close();
			System.out.println("agent "+id+" is Deleted");
		}
		
	}
	public static void add_reclamation(String sujet,String description, int id_client) throws NumberFormatException, SQLException {
		if(Check_Conection()) {
			sql = "INSERT INTO reclamation(sujet,description,id_client) VALUES (?, ?,?)";
			stat=connect().prepareStatement(sql);
			stat.setString(1, sujet);
			stat.setString(2, description);
			stat.setInt(3, id_client);
			int i = stat.executeUpdate();
			if (i==0) {
				System.out.println("adding the Client reclamation to DB is failed");
				connect().close();
				type = AnimationType.POPUP;
				tray.setAnimationType(type);
	    		tray.setTitle("Notification Reclamamtion");
	        	tray.setMessage("echec de reclamation");
	        	tray.setNotificationType(NotificationType.ERROR);
	        	tray.showAndDismiss(Duration.millis(3000));
			}else {
				connect().close();
				System.out.println("Client reclamation "+id_client+" is Successfully added to DB");
				type = AnimationType.POPUP;
				tray.setAnimationType(type);
	    		tray.setTitle("Notification Reclamation");
	        	tray.setMessage("Reclamamtion est ete bine effectue");
	        	tray.setNotificationType(NotificationType.SUCCESS);
	        	tray.showAndDismiss(Duration.millis(3000));
			}
			
		}
	}
	
	public static ObservableList<Module_Reclamation_modifier> get_reclmation_ouvert(int id_client) throws FileNotFoundException, SQLException{
		normal_list_client_reclamation_ouvert.clear();
		obs_list_client_reclamation_ouvert.clear();
		if(Check_Conection()) {
			sql="select id,sujet,description from reclamation where id=? and statut='ouvert'";
			stat=connect().prepareStatement(sql);
			stat.setInt(1, id_client);
			rs=stat.executeQuery();
			while(rs.next()) {
				
					Image image = new Image("/images/ouvert icon.png");
					ImageView imageview = new ImageView(image);
					imageview.setFitWidth(90);
					imageview.setFitHeight(20);
					normal_list_client_reclamation_ouvert.add(new Module_Reclamation_modifier(rs.getInt(1),rs.getString(2),rs.getString(3),imageview));

			}
			connect().close();
			System.out.println("Reclamation info has been loaded successfully");
			obs_list_client_reclamation_ouvert=FXCollections.observableList(normal_list_client_reclamation_ouvert);
			return obs_list_client_reclamation_ouvert;
		}
		return obs_list_client_reclamation_ouvert;
	}
	
}
