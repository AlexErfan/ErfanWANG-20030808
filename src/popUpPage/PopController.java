package popUpPage;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;


public class PopController {
	@FXML private ListView<Integer> scores, rounds;
	@FXML private Button closePopUp;
	
	private ObservableList<Integer> scoreList = FXCollections.observableArrayList();
	private ObservableList<Integer> roundList = FXCollections.observableArrayList();
	
	public void popUp(ObservableList<Record> records, Parent popUp){
		// extract scores and rounds in from records to scoreList and roundList respectively.
		for(Record record: records) {
//			System.out.println("Score(debug): " + record.getScore() + " Round: " + record.getRound());
			int scoreTemp = record.getScore();
			int roundTemp = record.getRound();
			scoreList.add(scoreTemp);
			roundList.add(roundTemp);
		}
		
		scores.setItems(scoreList);
		rounds.setItems(roundList);
		
		// show the pop up interface
	    Stage popUpStage = new Stage();   
	    Scene pop = new Scene(popUp);
	    popUpStage.setScene(pop);
	    popUpStage.show();
	    
	}

	public void closePopUp(ActionEvent event) {
		Stage popWindow = (Stage) ((Button) event.getSource()).getScene().getWindow();
		popWindow.close();
	}
}
