package Controllers_Admin;

import javafx.scene.image.ImageView;

public class Module_list_agent {
	private int id;
	private String username;
	private String email;
	private String password;
	private ImageView image_online_offline;
	public Module_list_agent(int id, String username, String email, String password, ImageView image_online_offline) {
		super();
		this.id = id;
		this.username = username;
		this.email = email;
		this.password = password;
		this.image_online_offline = image_online_offline;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public ImageView getImage_online_offline() {
		return image_online_offline;
	}
	public void setImage_online_offline(ImageView image_online_offline) {
		this.image_online_offline = image_online_offline;
	}
	
	
}
