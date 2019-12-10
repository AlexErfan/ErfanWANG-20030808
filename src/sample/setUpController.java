package sample;
import java.io.IOException;
import java.io.IOException;

import com.sun.corba.se.impl.orbutil.graph.Node;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.Window;


public class setUpController {
	@FXML
	Button back;
	@FXML 
	ColorPicker choice;
	
	public void goBack(ActionEvent event) throws IOException {
		Parent start = FXMLLoader.load(getClass().getResource("start.fxml"));
		Scene startScene = new Scene(start);
			
		// this line gets the stage information
		Stage startWindow = (Stage) ((Button) event.getSource()).getScene().getWindow();
		startWindow.setScene(startScene);
		startWindow.show();
		
		// get the color pikcker's value for the wall color.
		Color value = choice.getValue();
		System.out.println("color is" + value);
	}
}
