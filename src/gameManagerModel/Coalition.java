package gameManagerModel;

import java.io.IOException;

import gameManagerControl.GameManager;
import gameManagerView.GameView;
import ghostFactoryPattern.Ghost;

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

				    System.out.println("cheery location x : " + GameView.cherry.getCenterX() + " y: " + GameView.cherry.getCenterY());
//				    System.out.println("cheery location x : " + cookieCenterX + " y: " + cookieCenterY);
				    if (axis.equals("x")) {
				        // pacman goes right
				        if ((cookieCenterY >= pacmanTopEdge && cookieCenterY <= pacmanBottomEdge) && (pacmanRightEdge >= cookieLeftEdge && pacmanRightEdge <= cookieRightEdge)) {
				            if (cookie.isVisible()) {
				                GameManager.score += cookie.getValue();
				                GameManager.cookiesEaten++;
				                if((162.5 >= pacmanTopEdge && 162.5 <= pacmanBottomEdge) && (pacmanRightEdge >= 1150 && pacmanRightEdge <= 1175))
				                	GameManager.lifes ++;
				            }
				            cookie.hide();
				        }
				        // pacman goes left
				        if ((cookieCenterY >= pacmanTopEdge && cookieCenterY <= pacmanBottomEdge) && (pacmanLeftEdge >= cookieLeftEdge && pacmanLeftEdge <= cookieRightEdge)) {
				            if (cookie.isVisible()) {
				                GameManager.score += cookie.getValue();
				                GameManager.cookiesEaten++;
				                if((162.5 >= pacmanTopEdge && 162.5 <= pacmanBottomEdge) && (pacmanLeftEdge >= 1150 && pacmanLeftEdge <= 1175))
				                	GameManager.lifes ++;
				            }
				            cookie.hide();
				        }
				    } else {
				        // pacman goes up
				        if ((cookieCenterX >= pacmanLeftEdge && cookieCenterX <= pacmanRightEdge) && (pacmanBottomEdge >= cookieTopEdge && pacmanBottomEdge <= cookieBottomEdge)) {
				            if (cookie.isVisible()) {
				                GameManager.score += cookie.getValue();
				                GameManager.cookiesEaten++;
				                if((1162.5 >= pacmanLeftEdge && 1162.5 <= pacmanRightEdge) && (pacmanBottomEdge >= 150 && pacmanBottomEdge <= 175))
				                	GameManager.lifes ++;
				            }
				            cookie.hide();
				        }
				        // pacman goes down
				        if ((cookieCenterX >= pacmanLeftEdge && cookieCenterX <= pacmanRightEdge) && (pacmanTopEdge <= cookieBottomEdge && pacmanTopEdge >= cookieTopEdge)) {
				            if (cookie.isVisible()) {
				                GameManager.score += cookie.getValue();
				                GameManager.cookiesEaten++;
				                if((1162.5 >= pacmanLeftEdge && 1162.5 <= pacmanRightEdge) && (pacmanTopEdge <= 175 && pacmanTopEdge >= 150))
				                	GameManager.lifes ++;
				            }
				            cookie.hide();
				        }
				    }
				    GameView.scoreBoard.score.setText("Score: " + GameManager.score);
				    GameView.scoreBoard.lifes.setText("Lifes: " + GameManager.lifes);
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
