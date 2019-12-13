package gamaManageControl;

import gameManagerModel.Ghost;
import gameManagerModel.PacmanMovement;
import gameManagerView.Game;
import javafx.animation.AnimationTimer;
import javafx.scene.input.KeyEvent;

public class PacmanControl {

	 public static PacmanMovement movement = new PacmanMovement();
	 public static AnimationTimer rightPacmanAnimation = movement.createAnimation("right");
	 public static AnimationTimer upPacmanAnimation = movement.createAnimation("up");
	 public static AnimationTimer downPacmanAnimation = movement.createAnimation("down");
	 public static AnimationTimer leftPacmanAnimation = movement.createAnimation("left");;
	 
	 /**
     * Moves the pacman
     * @param event
     */
	 public void movePacman(KeyEvent event) {
		 for (Ghost ghost : Game.ghosts) {
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
		 }
	 }
    
    /**
     * Stops the pacman
     * @param event
     */
    public void stopPacman(KeyEvent event) {
        switch(event.getCode()) {
            case RIGHT:
            	System.out.println("pac man stopped");
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
        }
    }
}
