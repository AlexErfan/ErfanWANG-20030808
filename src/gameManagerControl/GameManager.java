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

/**
 * The class GameManager holds the controller of the game pacman.
 * @author alex
 *
 */
public class GameManager {
	
	/**
	 * Store the stage information.
	 */
	public static Group root;
	
	/**
	 * Store the movement timer for pacman.
	 */
    private AnimationTimer leftPacmanAnimation;
    private AnimationTimer rightPacmanAnimation;
    private AnimationTimer upPacmanAnimation;
    private AnimationTimer downPacmanAnimation;
    
    /**
     * Store the gameBoard info of current game.
     */
    public GameView gameBoard = new GameView(this);
    
    /**
     * Store the lifes for each round.
     */
    public static int lifes;
    /**
     * Store the score for each round.
     */
    public static int score;
    /**
     * Indicate whether the game is finished or not.
     */
    private boolean gameEnded;
    /**
     * Indicate how many cookies are eaten.
     */
    public static int cookiesEaten;
    
    /**
     * Store how many rounds players have played.
     */
    private int round;
    /**
     * Store 'scores' and 'rounds' pair.
     */
    public ObservableList<Record> scorePopUp = FXCollections.observableArrayList();

    /**
     * Constructor for GamaManager
     * @param root - the stage info from root.
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
     * Set one life less and ten score less when Pacman is caught by a Ghost.
     * <p>
     * If lifes is set to zero, endGame() method will be call.
     *  
     */
    public void lifeLost(){
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
     * Ends the game, stop all movement for pacman and ghost. Prompt text to wait for keyboard ESC input.
     * <p>
     * Calls out a score board indicating players history records from high to low.
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
     * Restart the game.
     * @param event - event registered to monitor keyEvent. 
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
     * Moves the pacman, when direction keys were hit on the keyboard, pacman makes move.
     * <p>
     * Corresponding animation will be called.
     *  
     * @param event - event registered to monitor keyEvent.
     * @see Pacman
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
     * @param event - event registered to monitor keyEvent.
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

    
    /**
     * Getters for the static filed group
     * @return root - a root contains all the information of a stage.
     * @see Group
     */
	public static Group getRoot() {
		return root;
	}

}
