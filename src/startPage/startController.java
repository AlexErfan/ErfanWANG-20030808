package startPage;


import java.io.IOException;

import gameManagerControl.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import setupPage.setupController;

public class startController {
	@FXML private Button start;
//	@FXML private ColorPicker wallColor, backgroundColor;
//	@FXML private ChoiceBox<String> level;
	
//	ObservableList<String> choices = FXCollections.observableArrayList("Low", "Medium", "High");;
//	public static Color wColor, bgColor;
//	public static String difficulty;
	
	public void changeSecene() {
		
		Stage theStage = new Stage();
		Group root = new Group();
		Scene theScene = new Scene( root );
		theScene.setFill(setupController.bgColor);
	    theStage.setScene(theScene );

	    Canvas canvas = new Canvas( 1225, 600 );
	    root.getChildren().add( canvas );
	    GameManager gameManager = new GameManager(root);
	    
	    gameManager.gameBoard.drawBoard(setupController.wColor, setupController.difficulty);
	         

	    theScene.addEventHandler(KeyEvent.KEY_PRESSED, event -> gameManager.movePacman(event));
	    theScene.addEventHandler(KeyEvent.KEY_RELEASED, event -> gameManager.stopPacman(event));
	    theScene.addEventHandler(KeyEvent.KEY_PRESSED, event -> gameManager.restartGame(event));

	    theStage.show();
	}
	
	public void goToSetup(ActionEvent event) throws IOException {
		Parent setting = FXMLLoader.load(getClass().getResource("../setupPage/setup.fxml"));
		Scene setupScene = new Scene(setting);
			
		// this line gets the stage information
		Stage setupWindow = (Stage) ((Button) event.getSource()).getScene().getWindow();
		setupWindow.setScene(setupScene);
		setupWindow.show();
	}
}
