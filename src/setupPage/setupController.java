package setupPage;

import java.io.IOException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ColorPicker;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class setupController {
	@FXML private Button setup, back;
	@FXML private ColorPicker wallColor, backgroundColor;
	@FXML private ChoiceBox<String> level;
	
	ObservableList<String> choices = FXCollections.observableArrayList("Low", "Medium", "High");;
	public static Color wColor, bgColor;
	public static String difficulty;
	
	@FXML private void initialize() {
		level.setValue("Low");
		level.setItems(choices);
	}
	
	public void goBack(ActionEvent event) throws IOException {
		setupController.difficulty = level.getValue().toString();
		
		Parent start = FXMLLoader.load(getClass().getResource("../startPage/start.fxml"));
		Scene startScene = new Scene(start);
			
		// this line gets the stage information
		Stage startWindow = (Stage) ((Button) event.getSource()).getScene().getWindow();
		startWindow.setScene(startScene);
		startWindow.show();
	}
	
	public void changeColor(ActionEvent event){
		// get the color picker's value for the wall color.
		setupController.wColor = wallColor.getValue();
	}
	
	public void changeBackground(ActionEvent event) {
		// get the color picker's value for the background.
		setupController.bgColor = backgroundColor.getValue(); 
	}
}
