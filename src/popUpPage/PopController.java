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
	/**
	 * current round's scores and round number.
	 */
	@FXML private ListView<Integer> scores, rounds;
	
	/**
	 * The closePopUp button.
	 */
	@FXML private Button closePopUp;
	
	/**
	 * scoreList holds list of scores for all the rounds of games.
	 */
	private ObservableList<Integer> scoreList = FXCollections.observableArrayList();
	
	/**
	 * roundList holds list of rounds combined with the scores.
	 */
	private ObservableList<Integer> roundList = FXCollections.observableArrayList();
	
	/**
	 * A popUp page which will show all the history the players, with highest scores and rounds shown.
	 * @param records - the records which hold 'score, round' pair sorted in ascending order.
	 * @param popUp - the parent root wherethe scene will pop on.
	 */
	public void popUp(ObservableList<Record> records, Parent popUp){
		// extract scores and rounds in from records to scoreList and roundList respectively.
		for(Record record: records) {
			int scoreTemp = record.getScore();
			int roundTemp = record.getRound();
			scoreList.add(scoreTemp);
			roundList.add(roundTemp);
		}
		
		// set the scores and the list.
		scores.setItems(scoreList);
		rounds.setItems(roundList);
		
		// show the pop up interface
	    Stage popUpStage = new Stage();   
	    Scene pop = new Scene(popUp);
	    popUpStage.setScene(pop);
	    popUpStage.show();
	    
	}

	/**
	 * Controller for the popUp window, if 'close' button is hit, then the page will be closed.
	 * @param event - the registered event for the 
	 */
	public void closePopUp(ActionEvent event) {
		Stage popWindow = (Stage) ((Button) event.getSource()).getScene().getWindow();
		popWindow.close();
	}
}
