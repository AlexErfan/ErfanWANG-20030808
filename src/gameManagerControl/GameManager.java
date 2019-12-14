package gameManagerControl;



import javafx.animation.AnimationTimer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import popUpPage.Record;
import popUpPage.PopController;
import java.io.IOException;
import java.util.Collections;
import gameManagerModel.BarObstacle;
import gameManagerModel.Pacman;
import gameManagerView.GameView;
import ghostFactoryPattern.Ghost;

public class GameManager {

	public static Group root;
    private AnimationTimer leftPacmanAnimation;
    private AnimationTimer rightPacmanAnimation;
    private AnimationTimer upPacmanAnimation;
    private AnimationTimer downPacmanAnimation;
    public GameView gameBoard = new GameView(this);
    public static int lifes;
    public static int score;
    private boolean gameEnded;
    public static int cookiesEaten;
    private int round;
    public ObservableList<Record> scorePopUp = FXCollections.observableArrayList();

    /**
     * Constructor
     */
    public GameManager(Group root) {
    	
        GameManager.root = root;
        this.leftPacmanAnimation = Pacman.createAnimation("left", this);
        this.rightPacmanAnimation = Pacman.createAnimation("right", this);
        this.upPacmanAnimation = Pacman.createAnimation("up", this);
        this.downPacmanAnimation = Pacman.createAnimation("down", this);
        GameManager.lifes = 3;
        GameManager.score = 0;
    }

    /**
     * Set one life less
     * @throws IOException 
     */
    public void lifeLost() throws IOException {
        this.leftPacmanAnimation.stop();
        this.rightPacmanAnimation.stop();
        this.upPacmanAnimation.stop();
        this.downPacmanAnimation.stop();
        for (Ghost ghost : GameView.ghosts) {
            ghost.getAnimation().stop();
        }
        GameView.pacman.setCenterX(2.5 * BarObstacle.THICKNESS);
        GameView.pacman.setCenterY(2.5 * BarObstacle.THICKNESS);
        lifes--;
        score -= 10;
        GameView.scoreBoard.lifes.setText("Lifes: " + GameManager.lifes);
        GameView.scoreBoard.score.setText("Score: " + GameManager.score);
        if (lifes == 0) {
            this.endGame();
        }
    }

    /**
     * Ends the game
     * @throws IOException 
     */
    public void endGame(){
        this.gameEnded = true;
        getRoot().getChildren().remove(GameView.pacman);
        for (Ghost ghost : GameView.ghosts) {
            getRoot().getChildren().remove(ghost);
        }
        javafx.scene.text.Text endGame = new javafx.scene.text.Text("Game Over, press ESC to restart");
        endGame.setX(BarObstacle.THICKNESS * 3);
        endGame.setY(BarObstacle.THICKNESS * 28);
        endGame.setFont(Font.font("Arial", 40));
        endGame.setFill(Color.ROYALBLUE);
        getRoot().getChildren().remove(GameView.scoreBoard.score);
        getRoot().getChildren().remove(GameView.scoreBoard.lifes);
        getRoot().getChildren().add(endGame);
        
        //add scores and rounds into the scorePopUp and sort the array list.
        round ++;
        Record temp = new Record(score, round);
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
        if (event.getCode() == KeyCode.ESCAPE && gameEnded) {
            getRoot().getChildren().clear();
            GameView.cookieSet.clear();
            GameView.ghosts.clear();
            gameBoard.drawBoard(GameView.color, GameView.difficulty);
            GameView.pacman.setCenterX(2.5 * BarObstacle.THICKNESS);
            GameView.pacman.setCenterY(2.5 * BarObstacle.THICKNESS);
            GameManager.lifes = 3;
            GameManager.score = 0;
            GameManager.cookiesEaten = 0;
            gameEnded = false;
        }
    }

    /**
     * Moves the pacman
     * @param event
     */
    public void movePacman(KeyEvent event) {
    	for (Ghost ghost : GameView.ghosts) {
            ghost.run();
        }
        switch(event.getCode()) {
            case RIGHT:
                this.rightPacmanAnimation.start();
                break;
            case LEFT:
                this.leftPacmanAnimation.start();
                break;
            case UP:
                this.upPacmanAnimation.start();
                break;
            case DOWN:
                this.downPacmanAnimation.start();
                break;
		default:
			break;
        }
    }

    /**
     * Stops the pacman
     * @param event
     */
    public void stopPacman(KeyEvent event) {
        switch(event.getCode()) {
            case RIGHT:
                this.rightPacmanAnimation.stop();
                break;
            case LEFT:
                this.leftPacmanAnimation.stop();
                break;
            case UP:
                this.upPacmanAnimation.stop();
                break;
            case DOWN:
                this.downPacmanAnimation.stop();
                break;
		default:
			break;
        }
    }


	public static Group getRoot() {
		return root;
	}

}
