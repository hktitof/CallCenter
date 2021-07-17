package Client;

import javafx.scene.image.ImageView;

public class Module_Reclamation_modifier {
	private Integer id;
	private String sujet;
	private String description;
	private ImageView imageview;
	public Module_Reclamation_modifier(Integer id, String sujet, String description, ImageView imageview) {
		super();
		this.id = id;
		this.sujet = sujet;
		this.description = description;
		this.imageview = imageview;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getSujet() {
		return sujet;
	}
	public void setSujet(String sujet) {
		this.sujet = sujet;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public ImageView getImageview() {
		return imageview;
	}
	public void setImageview(ImageView imageview) {
		this.imageview = imageview;
	}

}
