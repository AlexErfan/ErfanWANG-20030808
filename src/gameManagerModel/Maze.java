package gameManagerModel;



import javafx.scene.Group;
import javafx.scene.paint.Color;

import java.util.HashSet;
import java.util.Set;

/**
 * The class contains the logical structure of maze and basic functions for detecting walls.
 */
public class Maze {

	/**
	 * The walls are stored in a Set.
	 * @see BarObstacle
	 */
    public Set<BarObstacle> obstacles;
    
    /**
     * Instantiate HashSet to hold all obastacles in the maze.
     */
    public Maze() {
        obstacles = new HashSet<>();
    }

    /**
     * Checks if point is touching obstacles
     * @param x - location on the X axis.
     * @param y - location on the Y axis.
     * @param padding - the padding between ghost and the wall.
     * @return True if point touched the obstacles, False vice versa.s
     */
    public Boolean isTouching(double x, double y, double padding) {
        for (BarObstacle barObstacle:obstacles) {
            if (
                x >= barObstacle.getX() - padding &&
                x <= barObstacle.getX() + padding + barObstacle.getWidth() &&
                y >= barObstacle.getY() - padding &&
                y <= barObstacle.getY() + padding + barObstacle.getHeight())
            {
                return true;
            }
        }
        return false;
    }

    /**
     * lets you know if there's an obstacle in the current coordinate
     * @param fromX - start point on X axis.
     * @param toX - end point on Y axis.
     * @param fromY - start point on X axis.
     * @param toY - end point on Y axis.
     * @return True is obstacle exists on current coordinate, False vice versa.
     */
    public Boolean hasObstacle(double fromX,  double toX, double fromY, double toY) {
        boolean isTouching = false;
        for (double i = fromX; i < toX; i++) {
            for (double j = fromY; j < toY; j++) {
                if (this.isTouching(i, j, 0)) isTouching = true;
            }
        }
        return isTouching;
    }

    /**
     * Draws the maze
     * @param root - the stage root.
     * @param color - the color set for the walls.
     * @see Color
     */
    public void CreateMaze(Group root, Color color) {
        //~~~~~~~~~~~~~~~~~~~~~~~~~ frame ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        // top
        this.obstacles.add(new BarObstacle(0, 0, "horizontal", 48, color));
        // bottom
        this.obstacles.add(new BarObstacle(0, 600, "horizontal", 48, color));
        // left
        this.obstacles.add(new BarObstacle(0, 0, "vertical", 11, color));
        this.obstacles.add(new BarObstacle(0, 350, "vertical", 11, color));
        // right
        this.obstacles.add(new BarObstacle(1225 - BarObstacle.THICKNESS, 0, "vertical", 11, color));
        this.obstacles.add(new BarObstacle(1225 - BarObstacle.THICKNESS, 350, "vertical", 11, color));

        //~~~~~~~~~~~~~~~~~~~~~~~~~ Islands ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        // obsTopLeft
        this.obstacles.add(new BarObstacle(12 * BarObstacle.THICKNESS, BarObstacle.THICKNESS, "vertical", 4, color));
        // obsTopRight
        this.obstacles.add(new BarObstacle(36 * BarObstacle.THICKNESS, BarObstacle.THICKNESS, "vertical", 4, color));
        // obsBottomLeft
        this.obstacles.add(new BarObstacle(12 * BarObstacle.THICKNESS, 600 - 4 * BarObstacle.THICKNESS, "vertical", 4, color));
        // obsBottomRight
        this.obstacles.add(new BarObstacle(36 * BarObstacle.THICKNESS, 600 - 4 * BarObstacle.THICKNESS, "vertical", 4, color));
        // obsTopMiddle
        this.obstacles.add(new BarObstacle(16 * BarObstacle.THICKNESS, 4 * BarObstacle.THICKNESS, "horizontal", 17, color));
        // obsBottomMiddle
        this.obstacles.add(new BarObstacle(16 * BarObstacle.THICKNESS, 600 - 4 * BarObstacle.THICKNESS, "horizontal", 17, color));
        // obsLMTop
        this.obstacles.add(new BarObstacle(8 * BarObstacle.THICKNESS, 8 * BarObstacle.THICKNESS, "horizontal", 5, color));
        // obsLMTop4
        this.obstacles.add(new BarObstacle(8 * BarObstacle.THICKNESS, 12 * BarObstacle.THICKNESS, "horizontal", 5, color));
        // obsLMBottom
        this.obstacles.add(new BarObstacle(8 * BarObstacle.THICKNESS, 16 * BarObstacle.THICKNESS, "horizontal", 5, color));
        // obsRMTop
        this.obstacles.add(new BarObstacle(36 * BarObstacle.THICKNESS, 8 * BarObstacle.THICKNESS, "horizontal", 5, color));
        // obsRMTop2
        this.obstacles.add(new BarObstacle(36 * BarObstacle.THICKNESS, 12 * BarObstacle.THICKNESS, "horizontal", 5, color));
        // obsRMBottom
        this.obstacles.add(new BarObstacle(36 * BarObstacle.THICKNESS, 16 * BarObstacle.THICKNESS, "horizontal", 5, color));
        // LobsLeftTop1
        this.obstacles.add(new BarObstacle(4 * BarObstacle.THICKNESS, 4 * BarObstacle.THICKNESS, "horizontal", 5, color));
        // LobsLeftTop2
        this.obstacles.add(new BarObstacle(4 * BarObstacle.THICKNESS, 5 * BarObstacle.THICKNESS, "vertical", 6, color));
        // LobsLeftBottom1
        this.obstacles.add(new BarObstacle(4 * BarObstacle.THICKNESS, 600 - 4 * BarObstacle.THICKNESS, "horizontal", 5, color));
        // LobsLeftBottom2
        this.obstacles.add(new BarObstacle(4 * BarObstacle.THICKNESS, 600 - 10 * BarObstacle.THICKNESS, "vertical", 6, color));
        // LobsRightTop1
        this.obstacles.add(new BarObstacle(40 * BarObstacle.THICKNESS, 4 * BarObstacle.THICKNESS, "horizontal", 5, color));
        // LobsRightTop2
        this.obstacles.add(new BarObstacle(44 * BarObstacle.THICKNESS, 5 * BarObstacle.THICKNESS, "vertical", 6, color));
        // LobsRightBottom1
        this.obstacles.add(new BarObstacle(40 * BarObstacle.THICKNESS, 600 - 4 * BarObstacle.THICKNESS, "horizontal", 5, color));
        // LobsRightBottom2
        this.obstacles.add(new BarObstacle(44 * BarObstacle.THICKNESS, 600 - 10 * BarObstacle.THICKNESS, "vertical", 6, color));
        // cageBottom
        this.obstacles.add(new BarObstacle(16 * BarObstacle.THICKNESS, 600 - 8 * BarObstacle.THICKNESS, "horizontal", 17, color));
        // cageRightV
        this.obstacles.add(new BarObstacle(32 * BarObstacle.THICKNESS, 600 - 16 * BarObstacle.THICKNESS, "vertical", 8, color));
        // cageLeftV
        this.obstacles.add(new BarObstacle(16 * BarObstacle.THICKNESS, 600 - 16 * BarObstacle.THICKNESS, "vertical", 8, color));
        // cateRightH
        this.obstacles.add(new BarObstacle(17 * BarObstacle.THICKNESS, 8 * BarObstacle.THICKNESS, "horizontal", 5, color));
        // cateLeftH
        this.obstacles.add(new BarObstacle(27 * BarObstacle.THICKNESS, 8 * BarObstacle.THICKNESS, "horizontal", 5, color));

        root.getChildren().addAll(obstacles);
    }
}
