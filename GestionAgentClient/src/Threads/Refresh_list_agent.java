package Threads;

import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.concurrent.Callable;

import Controllers_Admin.Module_list_agent;
import DB_Connection.DBConnection;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

public class Refresh_list_agent implements Callable<Void>{
	public static TableView<Module_list_agent> tableview;
	public static int count=0;
	public static Label label_counting;
	public static TextField textfield_recherche;
	private ObservableList<Module_list_agent> Obs_list;
	public static Boolean Refreshign_tablview_agent_list;
	@Override
	public Void call() throws Exception {
		count=1;
		Refreshign_tablview_agent_list=true;
		while(Refreshign_tablview_agent_list) {
			for (int i = 10; i >=1; i--) {
				edit_label_with_count(i);
				Thread.sleep(1000);
			}
			edit_tableview();
			
			edit_label_with_final_text();
			System.out.println("Tableview has been successfully updated");
		}
		System.out.println("Refreshing Agent tablview is stopped");
		return null;
	}
	
	public void edit_tableview() {
		Platform.runLater(new Runnable(){
			@Override
			public void run() {
				try {
					Obs_list=DBConnection.get_agent_info();
					tableview.setItems(Obs_list);
					tableview.refresh();
					filtering();
				} catch (FileNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			});
	}
	public void edit_label_with_count(int i) {
		Platform.runLater(new Runnable(){
			@Override
			public void run() {
				label_counting.setText("Tableau sera Actualiser pendant "+i+" seconds");
			}
			});
	}
	public void edit_label_with_final_text() throws InterruptedException {
		Platform.runLater(new Runnable(){
			@Override
			public void run() {
				label_counting.setTextFill(Color.web("#FF0000"));
				label_counting.setText("Tableau est bien Actualiser");
			}
			});
		Thread.sleep(3000);
		Platform.runLater(new Runnable(){
			@Override
			public void run() {
				label_counting.setTextFill(Color.web("#000000"));
//				filtering();
			}
			});
	}
	 public void filtering() {
			FilteredList<Module_list_agent> filteredData = new FilteredList<>(Obs_list, p -> true);

	        // 2. Set the filter Predicate whenever the filter changes.
			textfield_recherche.textProperty().addListener((observable, oldValue, newValue) -> {
	            filteredData.setPredicate(Module_list_agent -> {
	                // If filter text is empty, display all persons.
	                if (newValue == null || newValue.isEmpty()) {
	                    return true;
	                }

	                // Compare first name and last name field in your object with filter.
	                String lowerCaseFilter = newValue.toLowerCase();

	                if (String.valueOf(Module_list_agent.getUsername()).toLowerCase().contains(lowerCaseFilter)) {
	                    return true;
	                    // Filter matches first name.

	                } else if (String.valueOf(Module_list_agent.getId()).toLowerCase().contains(lowerCaseFilter)) {
	                    return true; // Filter matches last name.
	                }  else if (String.valueOf(Module_list_agent.getEmail()).toLowerCase().contains(lowerCaseFilter)) {
	                    return true; // Filter matches last name.
	                } 

	                return false; // Does not match.
	            });
	        });

	        // 3. Wrap the FilteredList in a SortedList. 
	        SortedList<Module_list_agent> sortedData = new SortedList<>(filteredData);

	        // 4. Bind the SortedList comparator to the TableView comparator.
	        sortedData.comparatorProperty().bind(tableview.comparatorProperty());
	        // 5. Add sorted (and filtered) data to the table.
	        tableview.setItems(sortedData);
	        tableview.refresh();
		}
}
