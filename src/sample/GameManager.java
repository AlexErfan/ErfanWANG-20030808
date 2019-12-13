package sample;



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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import gameManagerModel.BarObstacle;
import gameManagerModel.Cookie;
import gameManagerModel.Ghost;
import gameManagerModel.Maze;
import gameManagerModel.Pacman;
import gameManagerModel.Score;

public class GameManager {

    private static Group root;
//    private Set<Cookie> cookieSet;
//    private Set<Ghost> ghosts;
//    private AnimationTimer leftPacmanAnimation;
//    private AnimationTimer rightPacmanAnimation;
//    private AnimationTimer upPacmanAnimation;
//    private AnimationTimer downPacmanAnimation;
//    private Maze maze;
//    private int lifes;
//    private int score;
//    private Score scoreBoard;
//    private boolean gameEnded;
    private int cookiesEaten;
    
//    private Color color;
//    private int round;
//    public ObservableList<Record> scorePopUp = FXCollections.observableArrayList();

    /**
     * Constructor
     */
    public GameManager(Group root) {
    	
        this.root = root;
//        this.maze = new Maze();
//        this.pacman = new Pacman(2.5 * BarObstacle.THICKNESS, 2.5 * BarObstacle.THICKNESS);
//        this.cookieSet = new HashSet<>();
//        this.ghosts = new HashSet<>();
//        this.leftPacmanAnimation = this.createAnimation("left");
//        this.rightPacmanAnimation = this.createAnimation("right");
//        this.upPacmanAnimation = this.createAnimation("up");
//        this.downPacmanAnimation = this.createAnimation("down");
//        this.lifes = 3;
//        this.score = 0;
//        this.cookiesEaten = 0;
    }

//    /**
//     * Set one life less
//     * @throws IOException 
//     */
//    private void lifeLost() throws IOException {
//        this.leftPacmanAnimation.stop();
//        this.rightPacmanAnimation.stop();
//        this.upPacmanAnimation.stop();
//        this.downPacmanAnimation.stop();
//        for (Ghost ghost : ghosts) {
//            ghost.getAnimation().stop();
//        }
//        this.pacman.setCenterX(2.5 * BarObstacle.THICKNESS);
//        this.pacman.setCenterY(2.5 * BarObstacle.THICKNESS);
//        lifes--;
//        score -= 10;
//        this.scoreBoard.lifes.setText("Lifes: " + this.lifes);
//        this.scoreBoard.score.setText("Score: " + this.score);
//        if (lifes == 0) {
//            this.endGame();
//        }
//    }
//
//    /**
//     * Ends the game
//     * @throws IOException 
//     */
//    private void endGame(){
//        this.gameEnded = true;
//        getRoot().getChildren().remove(pacman);
//        for (Ghost ghost : ghosts) {
//            getRoot().getChildren().remove(ghost);
//        }
//        javafx.scene.text.Text endGame = new javafx.scene.text.Text("Game Over, press ESC to restart");
//        endGame.setX(BarObstacle.THICKNESS * 3);
//        endGame.setY(BarObstacle.THICKNESS * 28);
//        endGame.setFont(Font.font("Arial", 40));
//        endGame.setFill(Color.ROYALBLUE);
//        getRoot().getChildren().remove(this.scoreBoard.score);
//        getRoot().getChildren().remove(this.scoreBoard.lifes);
//        getRoot().getChildren().add(endGame);
//        
//        //add scores and rounds into the scorePopUp and sort the array list.
//        round ++;
//        Record temp = new Record(score, round);
////        System.out.println("Record is not empty: " + temp.getScore());
//        scorePopUp.add(temp);
//        
//        // sort the array in descending order.
//        Collections.sort(scorePopUp, Collections.reverseOrder());
//        
//        // DEBUG use
//        for(Record record: scorePopUp) {
//        	System.out.println("Score: " + record.getScore() + " Round: " + record.getRound());
//        }
//        
//        // call out the controller method.
//        Parent popUp = null;
//        FXMLLoader loader = new FXMLLoader(getClass().getResource("../popUpPage/scoreBoard.fxml"));
//        try {
//			popUp = (Parent) loader.load();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//        PopController pop = loader.getController();
//     
//        pop.popUp(scorePopUp, popUp);
//    }
//
//    /**
//     * Restart the game
//     * @param event
//     */
//    public void restartGame(KeyEvent event) {
//        if (event.getCode() == KeyCode.ESCAPE && gameEnded) {
//            getRoot().getChildren().clear();
//            this.cookieSet.clear();
//            this.ghosts.clear();
//            this.drawBoard(color);
//            this.pacman.setCenterX(2.5 * BarObstacle.THICKNESS);
//            this.pacman.setCenterY(2.5 * BarObstacle.THICKNESS);
//            this.lifes = 3;
//            this.score = 0;
//            this.cookiesEaten = 0;
//            gameEnded = false;
//        }
//    }

	public static Group getRoot() {
		// TODO Auto-generated method stub
		return root;
	}

//    /**
//     * Draws the board of the game with the cookies and the Pacman
//     * @param color - color of the wall.
//     */
//    public void drawBoard(Color wColor) {
//    	if (wColor == null)
//    		this.color = Color.CADETBLUE;
//    	else
//    		this.color = wColor;
//        this.maze.CreateMaze(root, this.color);
//        
//        // 1st line
//        Integer skip[] = {5, 17};
//        for (int i = 0; i < 23; i++) {
//            if (!Arrays.asList(skip).contains(i)) {
//                Cookie cookie = new Cookie(((2*i) + 2.5) * BarObstacle.THICKNESS, 2.5 * BarObstacle.THICKNESS);
//                this.cookieSet.add(cookie);
//                root.getChildren().add(cookie);
//            }
//        }
//
//        // 2nd line
//        skip = new Integer[]{1, 2, 3, 5, 7, 8, 9, 10, 11, 12, 13, 14, 15, 17, 19, 20, 21};
//        for (int i = 0; i < 23; i++) {
//            if (!Arrays.asList(skip).contains(i)) {
//                Cookie cookie = new Cookie(((2*i) + 2.5) * BarObstacle.THICKNESS, 4.5 * BarObstacle.THICKNESS);
//                this.cookieSet.add(cookie);
//                root.getChildren().add(cookie);
//            }
//        }
//
//        // 3rd line
//        skip = new Integer[]{1, 21};
//        for (int i = 0; i < 23; i++) {
//            if (!Arrays.asList(skip).contains(i)) {
//                Cookie cookie = new Cookie(((2*i) + 2.5) * BarObstacle.THICKNESS, 6.5 * BarObstacle.THICKNESS);
//                this.cookieSet.add(cookie);
//                root.getChildren().add(cookie);
//            }
//        }
//
//        // 4th line
//        skip = new Integer[]{1, 3, 4, 5, 7, 8, 9, 10, 11, 12, 13, 14, 15, 17, 18, 19, 21};
//        for (int i = 0; i < 23; i++) {
//            if (!Arrays.asList(skip).contains(i)) {
//                Cookie cookie = new Cookie(((2 * i) + 2.5) * BarObstacle.THICKNESS, 8.5 * BarObstacle.THICKNESS);
//                this.cookieSet.add(cookie);
//                root.getChildren().add(cookie);
//            }
//        }
//
//        // 5th line
//        skip = new Integer[]{1, 7, 8, 9, 10, 11, 12, 13, 14, 15, 21};
//        for (int i = 0; i < 23; i++) {
//            if (!Arrays.asList(skip).contains(i)) {
//                Cookie cookie = new Cookie(((2*i) + 2.5) * BarObstacle.THICKNESS, 10.5 * BarObstacle.THICKNESS);
//                this.cookieSet.add(cookie);
//                root.getChildren().add(cookie);
//            }
//        }
//
//        // 6th line
//        skip = new Integer[]{3, 4, 5, 7, 8, 9, 10, 11, 12, 13, 14, 15, 17, 18, 19};
//        for (int i = 0; i < 23; i++) {
//            if (!Arrays.asList(skip).contains(i)) {
//                Cookie cookie = new Cookie(((2*i) + 2.5) * BarObstacle.THICKNESS, 12.5 * BarObstacle.THICKNESS);
//                this.cookieSet.add(cookie);
//                root.getChildren().add(cookie);
//            }
//        }
//
//        // 7th line
//        skip = new Integer[]{1, 7, 8, 9, 10, 11, 12, 13, 14, 15, 21};
//        for (int i = 0; i < 23; i++) {
//            if (!Arrays.asList(skip).contains(i)) {
//                Cookie cookie = new Cookie(((2 * i) + 2.5) * BarObstacle.THICKNESS, 14.5 * BarObstacle.THICKNESS);
//                this.cookieSet.add(cookie);
//                root.getChildren().add(cookie);
//            }
//        }
//
//        // 8th line
//        skip = new Integer[]{1, 3, 4, 5, 7, 8, 9, 10, 11, 12, 13, 14, 15, 17, 18, 19, 21};
//        for (int i = 0; i < 23; i++) {
//            if (!Arrays.asList(skip).contains(i)) {
//                Cookie cookie = new Cookie(((2 * i) + 2.5) * BarObstacle.THICKNESS, 16.5 * BarObstacle.THICKNESS);
//                this.cookieSet.add(cookie);
//                root.getChildren().add(cookie);
//            }
//        }
//
//        // 9th line
//        skip = new Integer[]{1, 21};
//        for (int i = 0; i < 23; i++) {
//            if (!Arrays.asList(skip).contains(i)) {
//                Cookie cookie = new Cookie(((2 * i) + 2.5) * BarObstacle.THICKNESS, 18.5 * BarObstacle.THICKNESS);
//                this.cookieSet.add(cookie);
//                root.getChildren().add(cookie);
//            }
//        }
//
//        // 10th line
//        skip = new Integer[]{1, 2, 3, 5, 7, 8, 9, 10, 11, 12, 13, 14, 15, 17, 19, 20, 21};
//        for (int i = 0; i < 23; i++) {
//            if (!Arrays.asList(skip).contains(i)) {
//                Cookie cookie = new Cookie(((2*i) + 2.5) * BarObstacle.THICKNESS, 20.5 * BarObstacle.THICKNESS);
//                this.cookieSet.add(cookie);
//                root.getChildren().add(cookie);
//            }
//        }
//
//        // 11th line
//        skip = new Integer[]{5, 17};
//        for (int i = 0; i < 23; i++) {
//            if (!Arrays.asList(skip).contains(i)) {
//                Cookie cookie = new Cookie(((2 * i) + 2.5) * BarObstacle.THICKNESS, 22.5 * BarObstacle.THICKNESS);
//                this.cookieSet.add(cookie);
//                root.getChildren().add(cookie);
//            }
//        }
//        root.getChildren().add(this.pacman);
//        this.generateGhosts();
//        root.getChildren().addAll(this.ghosts);
//        this.scoreBoard = new Score(root);
//    }
//
//    /**
//     * Generates the ghosts for the pacman!
//     */
//    public void generateGhosts() {
//        this.ghosts.add(new Ghost(18.5 * BarObstacle.THICKNESS, 12.5 * BarObstacle.THICKNESS, Color.DEEPPINK, maze, this));
//        this.ghosts.add(new Ghost(22.5 * BarObstacle.THICKNESS, 12.5 * BarObstacle.THICKNESS, Color.GREENYELLOW, maze, this));
//        this.ghosts.add(new Ghost(28.5 * BarObstacle.THICKNESS, 12.5 * BarObstacle.THICKNESS, Color.BLACK, maze, this));
//        this.ghosts.add(new Ghost(28.5 * BarObstacle.THICKNESS, 9.5 * BarObstacle.THICKNESS, Color.SPRINGGREEN, maze, this));
//    }

//    /**
//     * Moves the pacman
//     * @param event
//     */
//    public void movePacman(KeyEvent event) {
//    	for (Ghost ghost : ghostGenerator.getGhosts()) {
//            ghost.run();
//        }
//        switch(event.getCode()) {
//            case RIGHT:
//                this.rightPacmanAnimation.start();
//                break;
//            case LEFT:
//                this.leftPacmanAnimation.start();
//                break;
//            case UP:
//                this.upPacmanAnimation.start();
//                break;
//            case DOWN:
//                this.downPacmanAnimation.start();
//                break;
//        }
//    }

//    /**
//     * Stops the pacman
//     * @param event
//     */
//    public void stopPacman(KeyEvent event) {
//        switch(event.getCode()) {
//            case RIGHT:
//                this.rightPacmanAnimation.stop();
//                break;
//            case LEFT:
//                this.leftPacmanAnimation.stop();
//                break;
//            case UP:
//                this.upPacmanAnimation.stop();
//                break;
//            case DOWN:
//                this.downPacmanAnimation.stop();
//                break;
//        }
//    }

//    /**
//     * Creates an animation of the movement.
//     * @param direction
//     * @return
//     */
//    private AnimationTimer createAnimation(String direction) {
//        double step = 5;
//        return new AnimationTimer()
//        {
//            public void handle(long currentNanoTime)
//            {
//            switch (direction) {
//                case "left":
//                    if (!maze.isTouching(pacman.getCenterX() - pacman.getRadius(), pacman.getCenterY(), 15)) {
//                    	// pacman reaches the left hole.
//                    	if(pacman.getCenterX() <= 0)
//                    		pacman.setCenterX(1225); // put it to the right most of the map
//                    	else
//                    		pacman.setCenterX(pacman.getCenterX() - step);
//                        checkCookieCoalition(pacman, "x");
//                        checkGhostCoalition();
//                    }
//                    break;
//                case "right":
//                    if (!maze.isTouching(pacman.getCenterX() + pacman.getRadius(), pacman.getCenterY(), 15)) {
//                    	// pacman reaches the right hole
//                    	if(pacman.getCenterX() >= 1225)
//                    		pacman.setCenterX(0);
//                    	else
//                    		pacman.setCenterX(pacman.getCenterX() + step);
//                        checkCookieCoalition(pacman, "x");
//                        checkGhostCoalition();
//                    }
//                    break;
//                case "up":
//                    if (!maze.isTouching(pacman.getCenterX(), pacman.getCenterY() - pacman.getRadius(), 15)) {
//                        pacman.setCenterY(pacman.getCenterY() - step);
//                        checkCookieCoalition(pacman, "y");
//                        checkGhostCoalition();
//                    }
//                    break;
//                case "down":
//                   if (!maze.isTouching(pacman.getCenterX(), pacman.getCenterY() + pacman.getRadius(), 15)) {
//                       pacman.setCenterY(pacman.getCenterY() + step);
//                       checkCookieCoalition(pacman, "y");
//                       checkGhostCoalition();
//                   }
//                   break;
//            }
//            }
//        };
//    }
//
//    /**
//     * Checks if the Pacman touches cookies.
//     * @param pacman
//     * @param axis
//     */
//    private void checkCookieCoalition(Pacman pacman, String axis) {
//        double pacmanCenterY = pacman.getCenterY();
//        double pacmanCenterX = pacman.getCenterX();
//        double pacmanLeftEdge = pacmanCenterX - pacman.getRadius();
//        double pacmanRightEdge = pacmanCenterX + pacman.getRadius();
//        double pacmanTopEdge = pacmanCenterY - pacman.getRadius();
//        double pacmanBottomEdge = pacmanCenterY + pacman.getRadius();
//        for (Cookie cookie:cookieSet)
//			try {
//				{
//				    double cookieCenterX = cookie.getCenterX();
//				    double cookieCenterY = cookie.getCenterY();
//				    double cookieLeftEdge = cookieCenterX - cookie.getRadius();
//				    double cookieRightEdge = cookieCenterX + cookie.getRadius();
//				    double cookieTopEdge = cookieCenterY - cookie.getRadius();
//				    double cookieBottomEdge = cookieCenterY + cookie.getRadius();
//				    if (axis.equals("x")) {
//				        // pacman goes right
//				        if ((cookieCenterY >= pacmanTopEdge && cookieCenterY <= pacmanBottomEdge) && (pacmanRightEdge >= cookieLeftEdge && pacmanRightEdge <= cookieRightEdge)) {
//				            if (cookie.isVisible()) {
//				                this.score += cookie.getValue();
//				                this.cookiesEaten++;
//				            }
//				            cookie.hide();
//				        }
//				        // pacman goes left
//				        if ((cookieCenterY >= pacmanTopEdge && cookieCenterY <= pacmanBottomEdge) && (pacmanLeftEdge >= cookieLeftEdge && pacmanLeftEdge <= cookieRightEdge)) {
//				            if (cookie.isVisible()) {
//				                this.score += cookie.getValue();
//				                this.cookiesEaten++;
//				            }
//				            cookie.hide();
//				        }
//				    } else {
//				        // pacman goes up
//				        if ((cookieCenterX >= pacmanLeftEdge && cookieCenterX <= pacmanRightEdge) && (pacmanBottomEdge >= cookieTopEdge && pacmanBottomEdge <= cookieBottomEdge)) {
//				            if (cookie.isVisible()) {
//				                this.score += cookie.getValue();
//				                this.cookiesEaten++;
//				            }
//				            cookie.hide();
//				        }
//				        // pacman goes down
//				        if ((cookieCenterX >= pacmanLeftEdge && cookieCenterX <= pacmanRightEdge) && (pacmanTopEdge <= cookieBottomEdge && pacmanTopEdge >= cookieTopEdge)) {
//				            if (cookie.isVisible()) {
//				                this.score += cookie.getValue();
//				                this.cookiesEaten++;
//				            }
//				            cookie.hide();
//				        }
//				    }
//				    this.scoreBoard.score.setText("Score: " + this.score);
//				    if (this.cookiesEaten == this.cookieSet.size()) {
//				    	this.cookiesEaten = 0;
//				        this.endGame();
//				    }
//				}
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//    }
//
//    /**
//     * Checks if pacman is touching a ghost
//     */
//    public void checkGhostCoalition() {
//        double pacmanCenterY = pacman.getCenterY();
//        double pacmanCenterX = pacman.getCenterX();
//        double pacmanLeftEdge = pacmanCenterX - pacman.getRadius();
//        double pacmanRightEdge = pacmanCenterX + pacman.getRadius();
//        double pacmanTopEdge = pacmanCenterY - pacman.getRadius();
//        double pacmanBottomEdge = pacmanCenterY + pacman.getRadius();
//        for (Ghost ghost : ghosts) {
//            double ghostLeftEdge = ghost.getX();
//            double ghostRightEdge = ghost.getX() + ghost.getWidth();
//            double ghostTopEdge = ghost.getY();
//            double ghostBottomEdge = ghost.getY() + ghost.getHeight();
//            if ((pacmanLeftEdge <= ghostRightEdge && pacmanLeftEdge >= ghostLeftEdge) || (pacmanRightEdge >= ghostLeftEdge && pacmanRightEdge <= ghostRightEdge)) {
//                if ((pacmanTopEdge <= ghostBottomEdge && pacmanTopEdge >= ghostTopEdge) || (pacmanBottomEdge >= ghostTopEdge && pacmanBottomEdge <= ghostBottomEdge)) {
//                    try {
//						lifeLost();
//					} catch (IOException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//                }
//            }
//        }
//    }
//
//	public static Group getRoot() {
//		return root;
//	}

}
