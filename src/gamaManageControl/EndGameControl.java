package gamaManageControl;

import java.io.IOException;
import java.util.Collections;

import gameManagerModel.BarObstacle;
import gameManagerModel.Ghost;
import gameManagerModel.PacmanMovement;
import gameManagerView.Game;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import popUpPage.PopController;
import popUpPage.Record;
import sample.GameManager;

public class EndGameControl {
	private boolean gameEnded = false;
	private int round = 0;
    public ObservableList<Record> scorePopUp = FXCollections.observableArrayList();
	/**
     * Set one life less
     * @throws IOException 
     */
    public void lifeLost() throws IOException {
        PacmanControl.leftPacmanAnimation.stop();
        PacmanControl.rightPacmanAnimation.stop();
        PacmanControl.upPacmanAnimation.stop();
        PacmanControl.downPacmanAnimation.stop();
        for (Ghost ghost : Game.ghosts) {
            ghost.getAnimation().stop();
        }
        Game.pacman.setCenterX(2.5 * BarObstacle.THICKNESS);
        Game.pacman.setCenterY(2.5 * BarObstacle.THICKNESS);
        Game.lifes --;
        Game.score -= 10;
        Game.scoreBoard.lifes.setText("Lifes: " + Game.lifes);
        Game.scoreBoard.score.setText("Score: " + Game.score);
        if (Game.lifes == 0) {
            this.endGame();
        }
    }

    /**
     * Ends the game
     * @throws IOException 
     */
    public void endGame(){
        this.gameEnded = true;
        GameManager.getRoot().getChildren().remove(Game.pacman);
        for (Ghost ghost : Game.ghosts) {
            GameManager.getRoot().getChildren().remove(ghost);
        }
        javafx.scene.text.Text endGame = new javafx.scene.text.Text("Game Over, press ESC to restart");
        endGame.setX(BarObstacle.THICKNESS * 3);
        endGame.setY(BarObstacle.THICKNESS * 28);
        endGame.setFont(Font.font("Arial", 40));
        endGame.setFill(Color.ROYALBLUE);
        GameManager.getRoot().getChildren().remove(Game.scoreBoard.score);
        GameManager.getRoot().getChildren().remove(Game.scoreBoard.lifes);
        GameManager.getRoot().getChildren().add(endGame);
        
        //add scores and rounds into the scorePopUp and sort the array list.
        round ++;
        Record temp = new Record(Game.score, round);
//        System.out.println("Record is not empty: " + temp.getScore());
        scorePopUp.add(temp);
        
        // sort the array in descending order.
        Collections.sort(scorePopUp, Collections.reverseOrder());
        
        // DEBUG use
        for(Record record: scorePopUp) {
        	System.out.println("Score: " + record.getScore() + " Round: " + record.getRound());
        }
        
        // call out the controller method.
        Parent popUp = null;
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../popUpPage/scoreBoard.fxml"));
        try {
			popUp = (Parent) loader.load();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        PopController pop = loader.getController();
     
        pop.popUp(scorePopUp, popUp);
    }

    /**
     * Restart the game
     * @param event
     */
    public void restartGame(KeyEvent event) {
    	Game game = new Game();
        if (event.getCode() == KeyCode.ESCAPE && gameEnded) {
            GameManager.getRoot().getChildren().clear();
            Game.cookieSet.clear();
            Game.ghosts.clear();
            game.drawBoard(Game.color);
            Game.pacman.setCenterX(2.5 * BarObstacle.THICKNESS);
            Game.pacman.setCenterY(2.5 * BarObstacle.THICKNESS);
            Game.lifes = 3;
            Game.score = 0;;
            PacmanMovement.setCookiesEaten(0);
            gameEnded = false;
        }
    }
}
