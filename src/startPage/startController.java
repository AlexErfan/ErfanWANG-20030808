package startPage;


import java.io.IOException;

import gameManagerControl.*;
import gameManagerView.GameView;
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

public class startController {
	@FXML private Button start, setup, back;
	@FXML private ColorPicker wallColor, backgroundColor;
	
	private static Color wColor, bgColor;
	
	
	public void changeSecene() {
		
		Stage theStage = new Stage();
//		Stage theStage = (Stage) ((Button) e.getSource()).getScene().getWindow();
		Group root = new Group();
		Scene theScene = new Scene( root );
		theScene.setFill(bgColor);
	    theStage.setScene(theScene );

	    Canvas canvas = new Canvas( 1225, 600 );
	    root.getChildren().add( canvas );
	    GameManager gameManager = new GameManager(root);
	    
//	    System.out.println("color to all drawBoard: " + wColor);
	    gameManager.gameBoard.drawBoard(wColor);
	         

	    theScene.addEventHandler(KeyEvent.KEY_PRESSED, event -> gameManager.movePacman(event));
	    theScene.addEventHandler(KeyEvent.KEY_RELEASED, event -> gameManager.stopPacman(event));
	    theScene.addEventHandler(KeyEvent.KEY_PRESSED, event -> gameManager.restartGame(event));

	    theStage.show();
	}
	



	public void goToSetup(ActionEvent event) throws IOException {
		Parent setting = FXMLLoader.load(getClass().getResource("setup.fxml"));
		Scene setupScene = new Scene(setting);
			
		// this line gets the stage information
		Stage setupWindow = (Stage) ((Button) event.getSource()).getScene().getWindow();
		setupWindow.setScene(setupScene);
		setupWindow.show();
		System.out.println("goToSetup");
	}
	
	public void goBack(ActionEvent event) throws IOException {
		Parent start = FXMLLoader.load(getClass().getResource("start.fxml"));
		Scene startScene = new Scene(start);
			
		// this line gets the stage information
		Stage startWindow = (Stage) ((Button) event.getSource()).getScene().getWindow();
		startWindow.setScene(startScene);
		startWindow.show();
	}
	
	public void changeColor(ActionEvent event){
		// get the color picker's value for the wall color.
		wColor = wallColor.getValue();
	}
	
	public void changeBackground(ActionEvent event) {
		// get the color picker's value for the background.
		bgColor = backgroundColor.getValue(); 
	}
}
