package sample;

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
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import javafx.stage.Window;

public class startController {
	@FXML
	private Button start, setup;
	
	public void changeSecene(ActionEvent e) {
		
		Stage theStage = new Stage();
//		Stage theStage = (Stage) ((Button) e.getSource()).getScene().getWindow();
		Group root = new Group();
		Scene theScene = new Scene( root );
	    theStage.setScene(theScene );

	    Canvas canvas = new Canvas( 1225, 600 );
	    root.getChildren().add( canvas );
	    GameManager gameManager = new GameManager(root);

	    gameManager.drawBoard();
	         

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
	
	
	
}
