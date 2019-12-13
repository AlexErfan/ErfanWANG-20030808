package gameFlow;

import java.io.IOException;
import java.util.Set;

import characters.Ghost;
import characters.Pacman;
import javafx.animation.AnimationTimer;
import maze.BarObstacle;
import maze.Cookie;

public class Coalition {
	private static int score;
	private static int lifes;
	private static int cookiesEaten;
	private static Set<Cookie> cookieSet;
	private static Score scoreBoard;
	private AnimationTimer leftPacmanAnimation;
    private AnimationTimer rightPacmanAnimation;
    private AnimationTimer upPacmanAnimation;
    private AnimationTimer downPacmanAnimation;
	
	
	 /**
     * Checks if the Pacman touches cookies.
     * @param pacman
     * @param axis
     */
    private void checkCookieCoalition(Pacman pacman, String axis) {
        double pacmanCenterY = pacman.getCenterY();
        double pacmanCenterX = pacman.getCenterX();
        double pacmanLeftEdge = pacmanCenterX - pacman.getRadius();
        double pacmanRightEdge = pacmanCenterX + pacman.getRadius();
        double pacmanTopEdge = pacmanCenterY - pacman.getRadius();
        double pacmanBottomEdge = pacmanCenterY + pacman.getRadius();
        for (Cookie cookie:cookieSet)
			try {
				{
				    double cookieCenterX = cookie.getCenterX();
				    double cookieCenterY = cookie.getCenterY();
				    double cookieLeftEdge = cookieCenterX - cookie.getRadius();
				    double cookieRightEdge = cookieCenterX + cookie.getRadius();
				    double cookieTopEdge = cookieCenterY - cookie.getRadius();
				    double cookieBottomEdge = cookieCenterY + cookie.getRadius();
				    if (axis.equals("x")) {
				        // pacman goes right
				        if ((cookieCenterY >= pacmanTopEdge && cookieCenterY <= pacmanBottomEdge) && (pacmanRightEdge >= cookieLeftEdge && pacmanRightEdge <= cookieRightEdge)) {
				            if (cookie.isVisible()) {
				                this.score += cookie.getValue();
				                this.cookiesEaten++;
				            }
				            cookie.hide();
				        }
				        // pacman goes left
				        if ((cookieCenterY >= pacmanTopEdge && cookieCenterY <= pacmanBottomEdge) && (pacmanLeftEdge >= cookieLeftEdge && pacmanLeftEdge <= cookieRightEdge)) {
				            if (cookie.isVisible()) {
				                this.score += cookie.getValue();
				                this.cookiesEaten++;
				            }
				            cookie.hide();
				        }
				    } else {
				        // pacman goes up
				        if ((cookieCenterX >= pacmanLeftEdge && cookieCenterX <= pacmanRightEdge) && (pacmanBottomEdge >= cookieTopEdge && pacmanBottomEdge <= cookieBottomEdge)) {
				            if (cookie.isVisible()) {
				                this.score += cookie.getValue();
				                this.cookiesEaten++;
				            }
				            cookie.hide();
				        }
				        // pacman goes down
				        if ((cookieCenterX >= pacmanLeftEdge && cookieCenterX <= pacmanRightEdge) && (pacmanTopEdge <= cookieBottomEdge && pacmanTopEdge >= cookieTopEdge)) {
				            if (cookie.isVisible()) {
				                this.score += cookie.getValue();
				                this.cookiesEaten++;
				            }
				            cookie.hide();
				        }
				    }
				    this.scoreBoard.score.setText("Score: " + this.score);
				    if (this.cookiesEaten == this.cookieSet.size()) {
				    	this.cookiesEaten = 0;
				        this.endGame();
				    }
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    }

    /**
     * Checks if pacman is touching a ghost
     */
    public void checkGhostCoalition() {
        double pacmanCenterY = pacman.getCenterY();
        double pacmanCenterX = pacman.getCenterX();
        double pacmanLeftEdge = pacmanCenterX - pacman.getRadius();
        double pacmanRightEdge = pacmanCenterX + pacman.getRadius();
        double pacmanTopEdge = pacmanCenterY - pacman.getRadius();
        double pacmanBottomEdge = pacmanCenterY + pacman.getRadius();
        for (Ghost ghost : ghosts) {
            double ghostLeftEdge = ghost.getX();
            double ghostRightEdge = ghost.getX() + ghost.getWidth();
            double ghostTopEdge = ghost.getY();
            double ghostBottomEdge = ghost.getY() + ghost.getHeight();
            if ((pacmanLeftEdge <= ghostRightEdge && pacmanLeftEdge >= ghostLeftEdge) || (pacmanRightEdge >= ghostLeftEdge && pacmanRightEdge <= ghostRightEdge)) {
                if ((pacmanTopEdge <= ghostBottomEdge && pacmanTopEdge >= ghostTopEdge) || (pacmanBottomEdge >= ghostTopEdge && pacmanBottomEdge <= ghostBottomEdge)) {
                    try {
						lifeLost();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
                }
            }
        }
    }
    
    /**
     * Set one life less
     * @throws IOException 
     */
    private void lifeLost() throws IOException {
        this.leftPacmanAnimation.stop();
        this.rightPacmanAnimation.stop();
        this.upPacmanAnimation.stop();
        this.downPacmanAnimation.stop();
        for (Ghost ghost : ghosts) {
            ghost.getAnimation().stop();
        }
        this.pacman.setCenterX(2.5 * BarObstacle.THICKNESS);
        this.pacman.setCenterY(2.5 * BarObstacle.THICKNESS);
        lifes--;
        score -= 10;
        this.scoreBoard.lifes.setText("Lifes: " + this.lifes);
        this.scoreBoard.score.setText("Score: " + this.score);
        if (lifes == 0) {
            this.endGame();
        }
    }
}
