package sample;

import java.io.IOException;
import java.util.ArrayList;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;


public class popController {
	@FXML private ListView<Integer> scores, rounds;
	@FXML private Button closePopUp;
	
	private ObservableList<Integer> scoreList;
	private ObservableList<Integer> roundList;
	
	public void popUp(ArrayList<Record> records){
		// extract scores and rounds in from records to scoreList and roundList respectively.
		for(Record record: records) {
//			System.out.println("Score(debug): " + record.getScore() + " Round: " + record.getRound());
			scoreList.add(record.getScore());
			roundList.add(record.getRound());
		}
		
		// Put items on to the list view.
		scores.setItems(scoreList);
	    rounds.setItems(roundList);
		
		// show the pop up interface
	    Stage popUpStage = new Stage();
	    Parent popUp = null;
		try {
			popUp = FXMLLoader.load(getClass().getResource("scoreBoard.fxml"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	    Scene pop = new Scene(popUp);
	    popUpStage.setScene(pop);
	    popUpStage.show();
	}

	public void closePopUp(ActionEvent event) {
		Stage popWindow = (Stage) ((Button) event.getSource()).getScene().getWindow();
		popWindow.close();
	}
}
