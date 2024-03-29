package ghostFactoryPattern;



import javafx.animation.AnimationTimer;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

import java.util.Random;

import gameManagerControl.GameManager;
import gameManagerModel.Coalition;
import gameManagerModel.Maze;
import gameManagerView.GameView;

/**
 * The class contains the corresponding ghost attributes.
 * @author alex
 *
 */
public class Ghost extends Rectangle implements Runnable{

    String direction;
    GameManager gameManager;
    Maze maze;
    AnimationTimer animation;
    Coalition coalition = new Coalition();
    int timesWalked;

    /**
     * Constructor the Ghost.
     * @param x - the location of ghost on X axis.
     * @param y - the location of ghost on Y axis.
     * @param ghostName - the desired ghost name (i.e. ghost1, ghost2, etc.)
     * @param maze - the maze generated by GameView.
     * @param gameManager - the gameMamager generated by GameManager.
     * @see GameManager
     * @see GameView
     */
    public Ghost(double x, double y, String ghostName, Maze maze, GameManager gameManager) {
        this.setX(x);
        this.setY(y);
        this.maze = maze;
        this.setHeight(50);
        this.setWidth(50);
        Image img = new Image(getClass().getResourceAsStream(ghostName));
        this.setFill(new ImagePattern(img));
        this.timesWalked = 0;
        this.direction = "down";
        this.createAnimation();
        this.gameManager = gameManager;
    }
    
    /**
     * Returns the random direction.
     * @param exclude1 - not choosing this direction
     * @param exclude2 - not choosing this direction
     * @return directions[rnd] - the random direction.
     */
    private String getRandomDirection(String exclude1, String exclude2) {
        String[] directions = {"left", "right", "up", "down"};
        int rnd = new Random().nextInt(directions.length);
        while (directions[rnd].equals(exclude1) || directions[rnd].equals(exclude2)) {
            rnd = new Random().nextInt(directions.length);
        }
        return directions[rnd];
    }

    /**
     * Gets the animation for the ghost
     * @return - animation of the ghost.
     * @see AnimationTimer
     */
    public AnimationTimer getAnimation() {
        return animation;
    }

    /**
     * Checks whether there is any path to go
     * @param direction - the direction which the ghost wants to go.
     */
    private void checkIftheresPathToGo(String direction) {
        double rightEdge, leftEdge, topEdge, bottomEdge;
        switch (direction) {
            case "down":
                leftEdge = getX() - 10;
                bottomEdge = getY() + getHeight() + 15;
                rightEdge = getX() + getWidth() + 10;
                if (!maze.hasObstacle(leftEdge, rightEdge, bottomEdge - 1, bottomEdge)) {
                    this.direction = direction;
                }
                break;
            case "up":
                leftEdge = getX() - 10;
                rightEdge = getX() + getWidth() + 10;
                topEdge = getY() - 15;
                if (!maze.hasObstacle(leftEdge, rightEdge, topEdge - 1, topEdge)) {
                    this.direction = direction;
                }
                break;
            case "left":
                leftEdge = getX() - 15;
                bottomEdge = getY() + getHeight() + 10;
                topEdge = getY() - 10;
                if (!maze.hasObstacle(leftEdge - 1, leftEdge, topEdge, bottomEdge)) {
                    this.direction = direction;
                }
                break;
            case "right":
                bottomEdge = getY() + getHeight() + 10;
                rightEdge = getX() + getWidth() + 15;
                topEdge = getY() - 10;
                if (!maze.hasObstacle(rightEdge - 1, rightEdge, topEdge, bottomEdge)) {
                    this.direction = direction;
                }
                break;
        }
    }

    /**
     * Random movement of the ghost.
     * @param whereToGo - desired location
     * @param whereToChangeTo - adjusted final location.
     * @param leftEdge - the left most edge location of the ghost.
     * @param topEdge - the top most edge location of the ghost.
     * @param rightEdge - the right most edge location of the ghost.
     * @param bottomEdge - the bottom most edge location of the ghost.
     * @param padding - the white padding between the ghost and the wall.
     */
    private void moveUntilYouCant(String whereToGo, String whereToChangeTo, double leftEdge, double topEdge, double rightEdge, double bottomEdge, double padding) {
    	double step = 5;
    	if (GameView.difficulty == "Medium")
    		step = 6;
    	else if (GameView.difficulty == "High")
    		step = 7;
        switch (whereToGo) {
            case "left":
                if (!maze.isTouching(leftEdge, topEdge, padding)) {
                	if (leftEdge <= 0) {
                		setX(1225);
                	}else {
                		setX(leftEdge - step);
                	}
                } else {
                    while (maze.isTouching(getX(), getY(), padding)) {
                        setX(getX() + 1);
                    }
                    direction = whereToChangeTo;
                }
                break;
            case "right":
                if (!maze.isTouching(rightEdge, topEdge, padding)) {
                	if (rightEdge >= 1225) {
                		setX(0);
                		setY(topEdge);
                	}else {
                		setX(leftEdge + step);                		
                	}
                		
                } else {
                    while (maze.isTouching(getX() + getWidth(), getY(), padding)) {
                        setX(getX() - 1);
                    }
                    direction = whereToChangeTo;
                }
                break;
            case "up":
                if (!maze.isTouching(leftEdge, topEdge, padding)) {
                	setY(topEdge - step);
                } else {
                    while (maze.isTouching(getX(), getY(), padding)) {
                        setY(getY() + 1);
                    }
                    direction = "left";
                }
                break;
            case "down":
                if (!maze.isTouching(leftEdge, bottomEdge, padding)) {
                	setY(topEdge + step);
                } else {
                    while (maze.isTouching(getX(), getY() + getHeight(), padding)) {
                        setY(getY() - 1);
                    }
                    direction = "right";
                }
                break;
        }

    }

    /**
     * Creates an animation of the ghost
     */
    public void createAnimation() {

        this.animation = new AnimationTimer()
        {
            public void handle(long currentNanoTime)
            {
            	coalition.checkGhostCoalition(gameManager);
                double leftEdge = getX();
                double topEdge = getY();
                double rightEdge = getX() + getWidth();
                double bottomEdge = getY() + getHeight();
                double padding = 12;
                timesWalked++;
                int walkAtLeast = 4;
                switch (direction) {
                    case "left":
                        moveUntilYouCant("left", "down", leftEdge, topEdge, rightEdge, bottomEdge, padding);
                        if (timesWalked > walkAtLeast) {
                            checkIftheresPathToGo(getRandomDirection("left", "right"));
                            timesWalked = 0;
                        }
                        break;
                    case "right":
                        moveUntilYouCant("right", "up", leftEdge, topEdge, rightEdge, bottomEdge, padding);
                        if (timesWalked > walkAtLeast) {
                            checkIftheresPathToGo(getRandomDirection("left", "right"));
                             timesWalked = 0;
                        }
                        break;
                    case "up":
                        moveUntilYouCant("up", "left", leftEdge, topEdge, rightEdge, bottomEdge, padding);
                        if (timesWalked > walkAtLeast) {
                            checkIftheresPathToGo(getRandomDirection("up", "down"));
                            timesWalked = 0;
                        }
                        break;
                    case "down":
                        moveUntilYouCant("down", "right", leftEdge, topEdge, rightEdge, bottomEdge, padding);
                        if (timesWalked > walkAtLeast) {
                            checkIftheresPathToGo(getRandomDirection("up", "down"));
                            timesWalked = 0;
                        }
                        break;
                }
            }
        };
    }

    @Override
    public void run() {
        this.animation.start();
    }
}
