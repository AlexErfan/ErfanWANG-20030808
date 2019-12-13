package gameManagerModel;

import java.io.IOException;

import gamaManageControl.EndGameControl;
import gameManagerView.Game;
import javafx.animation.AnimationTimer;
import javafx.scene.Group;

public class PacmanMovement {
	private static int cookiesEaten = 0;
	EndGameControl gameControl = new EndGameControl();
	
	 public static int getCookiesEaten() {
		return cookiesEaten;
	}

	public static void setCookiesEaten(int cookiesEaten) {
		PacmanMovement.cookiesEaten = cookiesEaten;
	}

	/**
     * Creates an animation of the movement.
     * @param direction
     * @return
     */
    public AnimationTimer createAnimation(String direction) {
        double step = 5;
        return new AnimationTimer()
        {
            public void handle(long currentNanoTime)
            {
            switch (direction) {
                case "left":
                    if (!Game.maze.isTouching(Game.pacman.getCenterX() - Game.pacman.getRadius(), Game.pacman.getCenterY(), 15)) {
                    	// pacman reaches the left hole.
//                    	System.out.println("hit left");
                    	if(Game.pacman.getCenterX() <= 0)
                    		Game.pacman.setCenterX(1225); // put it to the right most of the map
                    	else
                    		Game.pacman.setCenterX(Game.pacman.getCenterX() - step);
                        checkCookieCoalition(Game.pacman, "x");
                        checkGhostCoalition();
                    }
                    break;
                case "right":
                    if (!Game.maze.isTouching(Game.pacman.getCenterX() + Game.pacman.getRadius(), Game.pacman.getCenterY(), 15)) {
                    	// pacman reaches the right hole
//                    	System.out.println("hit right");
                    	if(Game.pacman.getCenterX() >= 1225)
                    		Game.pacman.setCenterX(0);
                    	else {
                    		System.out.println("did it go right? " + (Game.pacman.getCenterX() + step));
                    		Game.pacman.setCenterX(30);
                    	}
                    		
                        checkCookieCoalition(Game.pacman, "x");
                        checkGhostCoalition();
                    }
                    break;
                case "up":
                    if (!Game.maze.isTouching(Game.pacman.getCenterX(), Game.pacman.getCenterY() - Game.pacman.getRadius(), 15)) {
                        Game.pacman.setCenterY(Game.pacman.getCenterY() - step);
                        checkCookieCoalition(Game.pacman, "y");
                        checkGhostCoalition();
                    }
                    break;
                case "down":
                   if (!Game.maze.isTouching(Game.pacman.getCenterX(), Game.pacman.getCenterY() + Game.pacman.getRadius(), 15)) {
                       Game.pacman.setCenterY(Game.pacman.getCenterY() + step);
                       checkCookieCoalition(Game.pacman, "y");
                       checkGhostCoalition();
                   }
                   break;
            }
            }
        };
    }

    /**
     * Checks if the Pacman touches cookies.
     * @param pacman
     * @param axis
     */
    private void checkCookieCoalition(Pacman pacman, String axis) {
        double pacmanCenterY = Game.pacman.getCenterY();
        double pacmanCenterX = Game.pacman.getCenterX();
        double pacmanLeftEdge = pacmanCenterX - Game.pacman.getRadius();
        double pacmanRightEdge = pacmanCenterX + Game.pacman.getRadius();
        double pacmanTopEdge = pacmanCenterY - Game.pacman.getRadius();
        double pacmanBottomEdge = pacmanCenterY + Game.pacman.getRadius();
        for (Cookie cookie:Game.cookieSet)
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
				                Game.score += cookie.getValue();
				                this.cookiesEaten++;
				            }
				            cookie.hide();
				        }
				        // pacman goes left
				        if ((cookieCenterY >= pacmanTopEdge && cookieCenterY <= pacmanBottomEdge) && (pacmanLeftEdge >= cookieLeftEdge && pacmanLeftEdge <= cookieRightEdge)) {
				            if (cookie.isVisible()) {
				            	Game.score += cookie.getValue();
				                this.cookiesEaten++;
				            }
				            cookie.hide();
				        }
				    } else {
				        // pacman goes up
				        if ((cookieCenterX >= pacmanLeftEdge && cookieCenterX <= pacmanRightEdge) && (pacmanBottomEdge >= cookieTopEdge && pacmanBottomEdge <= cookieBottomEdge)) {
				            if (cookie.isVisible()) {
				            	Game.score += cookie.getValue();
				                this.cookiesEaten++;
				            }
				            cookie.hide();
				        }
				        // pacman goes down
				        if ((cookieCenterX >= pacmanLeftEdge && cookieCenterX <= pacmanRightEdge) && (pacmanTopEdge <= cookieBottomEdge && pacmanTopEdge >= cookieTopEdge)) {
				            if (cookie.isVisible()) {
				            	Game.score += cookie.getValue();
				                this.cookiesEaten++;
				            }
				            cookie.hide();
				        }
				    }
				    Game.scoreBoard.score.setText("Score: " + Game.score);
				    if (this.cookiesEaten == Game.cookieSet.size()) {
				    	this.cookiesEaten = 0;
				        gameControl.endGame();
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
        double pacmanCenterY = Game.pacman.getCenterY();
        double pacmanCenterX = Game.pacman.getCenterX();
        double pacmanLeftEdge = pacmanCenterX - Game.pacman.getRadius();
        double pacmanRightEdge = pacmanCenterX + Game.pacman.getRadius();
        double pacmanTopEdge = pacmanCenterY - Game.pacman.getRadius();
        double pacmanBottomEdge = pacmanCenterY + Game.pacman.getRadius();
//        System.out.println("out of loop");
        for (Ghost ghost : Game.ghosts) {
        	System.out.println("inside the loop");
            double ghostLeftEdge = ghost.getX();
            double ghostRightEdge = ghost.getX() + ghost.getWidth();
            double ghostTopEdge = ghost.getY();
            double ghostBottomEdge = ghost.getY() + ghost.getHeight();
            if ((pacmanLeftEdge <= ghostRightEdge && pacmanLeftEdge >= ghostLeftEdge) || (pacmanRightEdge >= ghostLeftEdge && pacmanRightEdge <= ghostRightEdge)) {
                if ((pacmanTopEdge <= ghostBottomEdge && pacmanTopEdge >= ghostTopEdge) || (pacmanBottomEdge >= ghostTopEdge && pacmanBottomEdge <= ghostBottomEdge)) {
                    try {
                    	System.out.println("ghost touches pacman");
						gameControl.lifeLost();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
                }
            }
        }
    }
}
