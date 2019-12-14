package gameManagerView;


import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import gameManagerControl.GameManager;
import gameManagerModel.BarObstacle;
import gameManagerModel.Cookie;
import gameManagerModel.Maze;
import gameManagerModel.Pacman;
import gameManagerModel.Score;
import ghostFactoryPattern.Ghost;
import ghostFactoryPattern.GhostFactory;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;

public class GameView {
	 public static Pacman pacman;
	 public static Set<Cookie> cookieSet;
	 public static Set<Ghost> ghosts;
	 public static Maze maze;
	 public static Score scoreBoard;	    
	 public static Color color;
	 public static GameManager gameManager;
	 public static Cookie cherry;
	 public static String difficulty;
	 /**
	  * Constructor
	  */
	 public GameView(GameManager gameManager) {
		 GameView.maze = new Maze();
		 GameView.pacman = Pacman.getInstance();
		 GameView.cookieSet = new HashSet<>();
		 GameView.ghosts = new HashSet<>();
		 GameView.gameManager = gameManager;
	  }
	 
	
	/**
     * Draws the board of the game with the cookies and the Pacman
     * @param color - color of the wall.
     */
    public void drawBoard(Color wColor, String difficulty) {
    	if (wColor == null)
    		GameView.color = Color.CADETBLUE;
    	else
    		GameView.color = wColor;
    	GameView.difficulty = difficulty;
        GameView.maze.CreateMaze(GameManager.root, GameView.color);
        
        // 1st line
        Integer skip[] = {5, 17};
        for (int i = 0; i < 23; i++) {
            if (!Arrays.asList(skip).contains(i)) {
                Cookie cookie = new Cookie(((2*i) + 2.5) * BarObstacle.THICKNESS, 2.5 * BarObstacle.THICKNESS);
                GameView.cookieSet.add(cookie);
                GameManager.root.getChildren().add(cookie);
            }
        }

        // 2nd line
        skip = new Integer[]{1, 2, 3, 5, 7, 8, 9, 10, 11, 12, 13, 14, 15, 17, 19, 20, 21};
        for (int i = 0; i < 23; i++) {
            if (!Arrays.asList(skip).contains(i)) {
                Cookie cookie = new Cookie(((2*i) + 2.5) * BarObstacle.THICKNESS, 4.5 * BarObstacle.THICKNESS);
                GameView.cookieSet.add(cookie);
                GameManager.root.getChildren().add(cookie);
            }
        }

        // 3rd line
        skip = new Integer[]{1, 21};
        for (int i = 0; i < 23; i++) {
            if (!Arrays.asList(skip).contains(i)) {
                Cookie cookie = new Cookie(((2*i) + 2.5) * BarObstacle.THICKNESS, 6.5 * BarObstacle.THICKNESS);
                if(i == 22) {
                	Image img = new Image(getClass().getResourceAsStream("cherry.jpeg"));
                	cookie.setFill(new ImagePattern(img));
                	cherry = cookie;
                }
                GameView.cookieSet.add(cookie);
                GameManager.root.getChildren().add(cookie);
            }
        }

        // 4th line
        skip = new Integer[]{1, 3, 4, 5, 7, 8, 9, 10, 11, 12, 13, 14, 15, 17, 18, 19, 21};
        for (int i = 0; i < 23; i++) {
            if (!Arrays.asList(skip).contains(i)) {
                Cookie cookie = new Cookie(((2 * i) + 2.5) * BarObstacle.THICKNESS, 8.5 * BarObstacle.THICKNESS);
                GameView.cookieSet.add(cookie);
                GameManager.root.getChildren().add(cookie);
            }
        }

        // 5th line
        skip = new Integer[]{1, 7, 8, 9, 10, 11, 12, 13, 14, 15, 21};
        for (int i = 0; i < 23; i++) {
            if (!Arrays.asList(skip).contains(i)) {
                Cookie cookie = new Cookie(((2*i) + 2.5) * BarObstacle.THICKNESS, 10.5 * BarObstacle.THICKNESS);
                GameView.cookieSet.add(cookie);
                GameManager.root.getChildren().add(cookie);
            }
        }

        // 6th line
        skip = new Integer[]{3, 4, 5, 7, 8, 9, 10, 11, 12, 13, 14, 15, 17, 18, 19};
        for (int i = 0; i < 23; i++) {
            if (!Arrays.asList(skip).contains(i)) {
                Cookie cookie = new Cookie(((2*i) + 2.5) * BarObstacle.THICKNESS, 12.5 * BarObstacle.THICKNESS);
                GameView.cookieSet.add(cookie);
                GameManager.root.getChildren().add(cookie);
            }
        }

        // 7th line
        skip = new Integer[]{1, 7, 8, 9, 10, 11, 12, 13, 14, 15, 21};
        for (int i = 0; i < 23; i++) {
            if (!Arrays.asList(skip).contains(i)) {
                Cookie cookie = new Cookie(((2 * i) + 2.5) * BarObstacle.THICKNESS, 14.5 * BarObstacle.THICKNESS);
                GameView.cookieSet.add(cookie);
                GameManager.root.getChildren().add(cookie);
            }
        }

        // 8th line
        skip = new Integer[]{1, 3, 4, 5, 7, 8, 9, 10, 11, 12, 13, 14, 15, 17, 18, 19, 21};
        for (int i = 0; i < 23; i++) {
            if (!Arrays.asList(skip).contains(i)) {
                Cookie cookie = new Cookie(((2 * i) + 2.5) * BarObstacle.THICKNESS, 16.5 * BarObstacle.THICKNESS);
                GameView.cookieSet.add(cookie);
                GameManager.root.getChildren().add(cookie);
            }
        }

        // 9th line
        skip = new Integer[]{1, 21};
        for (int i = 0; i < 23; i++) {
            if (!Arrays.asList(skip).contains(i)) {
                Cookie cookie = new Cookie(((2 * i) + 2.5) * BarObstacle.THICKNESS, 18.5 * BarObstacle.THICKNESS);
                GameView.cookieSet.add(cookie);
                GameManager.root.getChildren().add(cookie);
            }
        }

        // 10th line
        skip = new Integer[]{1, 2, 3, 5, 7, 8, 9, 10, 11, 12, 13, 14, 15, 17, 19, 20, 21};
        for (int i = 0; i < 23; i++) {
            if (!Arrays.asList(skip).contains(i)) {
                Cookie cookie = new Cookie(((2*i) + 2.5) * BarObstacle.THICKNESS, 20.5 * BarObstacle.THICKNESS);
                GameView.cookieSet.add(cookie);
                GameManager.root.getChildren().add(cookie);
            }
        }

        // 11th line
        skip = new Integer[]{5, 17};
        for (int i = 0; i < 23; i++) {
            if (!Arrays.asList(skip).contains(i)) {
                Cookie cookie = new Cookie(((2 * i) + 2.5) * BarObstacle.THICKNESS, 22.5 * BarObstacle.THICKNESS);
                GameView.cookieSet.add(cookie);
                GameManager.root.getChildren().add(cookie);
            }
        }
        GameManager.root.getChildren().add(GameView.pacman);
        generateGhosts(difficulty);
        GameManager.root.getChildren().addAll(GameView.ghosts);
        GameView.scoreBoard = new Score(GameManager.root);
    }

    /**
     * Generates the ghosts for the pacman!
     */
    public void generateGhosts(String difficulty) {
    	GhostFactory factory = new GhostFactory();
        GameView.ghosts.add(factory.getGhost(1));
        GameView.ghosts.add(factory.getGhost(2));
        GameView.ghosts.add(factory.getGhost(3));
        GameView.ghosts.add(factory.getGhost(4));
        if(difficulty == "Medium" || difficulty == "High")
        	GameView.ghosts.add(factory.getGhost(5));
    }
}
