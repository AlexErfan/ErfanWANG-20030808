package gameManagerModel;



import gameManagerControl.GameManager;
import gameManagerView.GameView;
import javafx.animation.AnimationTimer;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;

public class Pacman extends Circle {
	private static Pacman pacman = new Pacman(2.5 * BarObstacle.THICKNESS, 2.5 * BarObstacle.THICKNESS);
	
	/* Singleton design for the pacman.*/
    private Pacman(double x, double y) {
        this.setCenterX(x);
        this.setCenterY(y);
        Image img = new Image(getClass().getResourceAsStream("pacman.png"));
        this.setRadius(25);
        this.setFill(new ImagePattern(img));
    }
    
    public static Pacman getInstance(){
        return pacman;
     }

    
    /**
     * Creates an animation of the movement.
     * @param direction
     * @return
     */
    public static AnimationTimer createAnimation(String direction, GameManager gameManager) {
    	Coalition coalition = new Coalition();
        double step = 5;
        return new AnimationTimer()
        {
            public void handle(long currentNanoTime)
            {
            switch (direction) {
                case "left":
                    if (!GameView.maze.isTouching(GameView.pacman.getCenterX() - GameView.pacman.getRadius(), GameView.pacman.getCenterY(), 15)) {
                    	// GameView.pacman reaches the left hole.
                    	if(GameView.pacman.getCenterX() <= 0) {
                    		GameView.pacman.setRotate(180);
                    		GameView.pacman.setCenterX(1225); // put it to the right most of the map
                    	}else {
                    		GameView.pacman.setRotate(180);
                    		GameView.pacman.setCenterX(GameView.pacman.getCenterX() - step);
                    	}
                    		
                        coalition.checkCookieCoalition(GameView.pacman, "x", gameManager);
                        coalition.checkGhostCoalition(gameManager);
                    }
                    break;
                case "right":
                    if (!GameView.maze.isTouching(GameView.pacman.getCenterX() + GameView.pacman.getRadius(), GameView.pacman.getCenterY(), 15)) {
                    	// GameView.pacman reaches the right hole
                    	if(GameView.pacman.getCenterX() >= 1225) {
                    		GameView.pacman.setRotate(0);
                    		GameView.pacman.setCenterX(0);
                    	}else {
                    		GameView.pacman.setRotate(0);
                    		GameView.pacman.setCenterX(GameView.pacman.getCenterX() + step);
                    	}
                        coalition.checkCookieCoalition(GameView.pacman, "x", gameManager);
                        coalition.checkGhostCoalition(gameManager);
                    }
                    break;
                case "up":
                    if (!GameView.maze.isTouching(GameView.pacman.getCenterX(), GameView.pacman.getCenterY() - GameView.pacman.getRadius(), 15)) {
                    	GameView.pacman.setRotate(270);
                        GameView.pacman.setCenterY(GameView.pacman.getCenterY() - step);
                        coalition.checkCookieCoalition(GameView.pacman, "y", gameManager);
                        coalition.checkGhostCoalition(gameManager);
                    }
                    break;
                case "down":
                   if (!GameView.maze.isTouching(GameView.pacman.getCenterX(), GameView.pacman.getCenterY() + GameView.pacman.getRadius(), 15)) {
                	   GameView.pacman.setRotate(90);
                       GameView.pacman.setCenterY(GameView.pacman.getCenterY() + step);
                       coalition.checkCookieCoalition(GameView.pacman, "y", gameManager);
                       coalition.checkGhostCoalition(gameManager);
                   }
                   break;
            }
            }
        };
    }
}
