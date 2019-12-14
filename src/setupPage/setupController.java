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

/**
 * The setupController class which loads the setup in response to the key stroke.
 * @author alex
 *
 */
public class setupController {
	@FXML private Button setup, back;
	@FXML private ColorPicker wallColor, backgroundColor;
	@FXML private ChoiceBox<String> level;
	
	/**
	 * A list which holds the difficulty levels: low, medium and high.
	 */
	ObservableList<String> choices = FXCollections.observableArrayList("Low", "Medium", "High");;
	public static Color wColor, bgColor;
	public static String difficulty;
	
	/**
	 * The initializer which initialize the difficulty level in the choiceBox.
	 */
	@FXML private void initialize() {
		level.setValue("Low");
		level.setItems(choices);
	}
	
	/**
	 * The goBack button handler which goes back to the startup page.
	 * @param event - the key event registered for the mouse click event.
	 * @throws IOException - exception is thrown when the startup.fxml page is not loaded. 
	 */
	public void goBack(ActionEvent event) throws IOException {
		setupController.difficulty = level.getValue().toString();
		
		Parent start = FXMLLoader.load(getClass().getResource("../startPage/start.fxml"));
		Scene startScene = new Scene(start);
			
		// this line gets the stage information
		Stage startWindow = (Stage) ((Button) event.getSource()).getScene().getWindow();
		startWindow.setScene(startScene);
		startWindow.show();
	}
	
	/**
	 * The handler which change the color set of the wall when color picker is picked.
	 * @param event - the registered event for changeColor
	 */
	public void changeColor(ActionEvent event){
		// get the color picker's value for the wall color.
		setupController.wColor = wallColor.getValue();
	}
	
	/**
	 * The handler which change the color background of the background when background color picker is picked.
	 * @param event - the registered event for the changeBackground
	 */
	public void changeBackground(ActionEvent event) {
		// get the color picker's value for the background.
		setupController.bgColor = backgroundColor.getValue(); 
	}
}
