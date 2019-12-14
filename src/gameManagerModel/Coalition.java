package gameManagerModel;

import java.io.IOException;

import gameManagerControl.GameManager;
import gameManagerView.GameView;

public class Coalition {
	 /**
     * Checks if the GameView.pacman touches cookies.
     * @param pacman
     * @param axis
     */
    public void checkCookieCoalition(Pacman pacman, String axis, GameManager gameManager) {
        double pacmanCenterY = pacman.getCenterY();
        double pacmanCenterX = pacman.getCenterX();
        double pacmanLeftEdge = pacmanCenterX - pacman.getRadius();
        double pacmanRightEdge = pacmanCenterX + pacman.getRadius();
        double pacmanTopEdge = pacmanCenterY - pacman.getRadius();
        double pacmanBottomEdge = pacmanCenterY + pacman.getRadius();
        for (Cookie cookie:GameView.cookieSet)
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
				                GameManager.score += cookie.getValue();
				                GameManager.cookiesEaten++;
				            }
				            cookie.hide();
				        }
				        // pacman goes left
				        if ((cookieCenterY >= pacmanTopEdge && cookieCenterY <= pacmanBottomEdge) && (pacmanLeftEdge >= cookieLeftEdge && pacmanLeftEdge <= cookieRightEdge)) {
				            if (cookie.isVisible()) {
				                GameManager.score += cookie.getValue();
				                GameManager.cookiesEaten++;
				            }
				            cookie.hide();
				        }
				    } else {
				        // pacman goes up
				        if ((cookieCenterX >= pacmanLeftEdge && cookieCenterX <= pacmanRightEdge) && (pacmanBottomEdge >= cookieTopEdge && pacmanBottomEdge <= cookieBottomEdge)) {
				            if (cookie.isVisible()) {
				                GameManager.score += cookie.getValue();
				                GameManager.cookiesEaten++;
				            }
				            cookie.hide();
				        }
				        // pacman goes down
				        if ((cookieCenterX >= pacmanLeftEdge && cookieCenterX <= pacmanRightEdge) && (pacmanTopEdge <= cookieBottomEdge && pacmanTopEdge >= cookieTopEdge)) {
				            if (cookie.isVisible()) {
				                GameManager.score += cookie.getValue();
				                GameManager.cookiesEaten++;
				            }
				            cookie.hide();
				        }
				    }
				    GameView.scoreBoard.score.setText("Score: " + GameManager.score);
				    if (GameManager.cookiesEaten == GameView.cookieSet.size()) {
				    	GameManager.cookiesEaten = 0;
				        gameManager.endGame();
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
    public void checkGhostCoalition(GameManager gameManager) {
        double pacmanCenterY = GameView.pacman.getCenterY();
        double pacmanCenterX = GameView.pacman.getCenterX();
        double pacmanLeftEdge = pacmanCenterX - GameView.pacman.getRadius();
        double pacmanRightEdge = pacmanCenterX + GameView.pacman.getRadius();
        double pacmanTopEdge = pacmanCenterY - GameView.pacman.getRadius();
        double pacmanBottomEdge = pacmanCenterY + GameView.pacman.getRadius();
        for (Ghost ghost : GameView.ghosts) {
            double ghostLeftEdge = ghost.getX();
            double ghostRightEdge = ghost.getX() + ghost.getWidth();
            double ghostTopEdge = ghost.getY();
            double ghostBottomEdge = ghost.getY() + ghost.getHeight();
            if ((pacmanLeftEdge <= ghostRightEdge && pacmanLeftEdge >= ghostLeftEdge) || (pacmanRightEdge >= ghostLeftEdge && pacmanRightEdge <= ghostRightEdge)) {
                if ((pacmanTopEdge <= ghostBottomEdge && pacmanTopEdge >= ghostTopEdge) || (pacmanBottomEdge >= ghostTopEdge && pacmanBottomEdge <= ghostBottomEdge)) {
                    try {
						gameManager.lifeLost();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
                }
            }
        }
    }
}
