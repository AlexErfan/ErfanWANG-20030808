package gameFlow;

import javafx.animation.AnimationTimer;

public class PacmanAnimation {
	 /**
     * Creates an animation of the movement.
     * @param direction
     * @return
     */
    private AnimationTimer createAnimation(String direction) {
        double step = 5;
        return new AnimationTimer()
        {
            public void handle(long currentNanoTime)
            {
            switch (direction) {
                case "left":
                    if (!maze.isTouching(pacman.getCenterX() - pacman.getRadius(), pacman.getCenterY(), 15)) {
                    	// pacman reaches the left hole.
                    	if(pacman.getCenterX() <= 0)
                    		pacman.setCenterX(1225); // put it to the right most of the map
                    	else
                    		pacman.setCenterX(pacman.getCenterX() - step);
                        checkCookieCoalition(pacman, "x");
                        checkGhostCoalition();
                    }
                    break;
                case "right":
                    if (!maze.isTouching(pacman.getCenterX() + pacman.getRadius(), pacman.getCenterY(), 15)) {
                    	// pacman reaches the right hole
                    	if(pacman.getCenterX() >= 1225)
                    		pacman.setCenterX(0);
                    	else
                    		pacman.setCenterX(pacman.getCenterX() + step);
                        checkCookieCoalition(pacman, "x");
                        checkGhostCoalition();
                    }
                    break;
                case "up":
                    if (!maze.isTouching(pacman.getCenterX(), pacman.getCenterY() - pacman.getRadius(), 15)) {
                        pacman.setCenterY(pacman.getCenterY() - step);
                        checkCookieCoalition(pacman, "y");
                        checkGhostCoalition();
                    }
                    break;
                case "down":
                   if (!maze.isTouching(pacman.getCenterX(), pacman.getCenterY() + pacman.getRadius(), 15)) {
                       pacman.setCenterY(pacman.getCenterY() + step);
                       checkCookieCoalition(pacman, "y");
                       checkGhostCoalition();
                   }
                   break;
            }
            }
        };
    }
}
