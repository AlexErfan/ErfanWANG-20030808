package characters;

import java.util.Set;

import javafx.scene.paint.Color;
import maze.BarObstacle;

public class ghostGenerator {
	private static Set<Ghost> ghosts;
	
	public static Set<Ghost> getGhosts() {
		return ghosts;
	}
	
	/**
    * Generates the ghosts for the pacman!
    */
    public void generateGhosts() {
        this.ghosts.add(new Ghost(18.5 * BarObstacle.THICKNESS, 12.5 * BarObstacle.THICKNESS, Color.DEEPPINK, maze, this));
        this.ghosts.add(new Ghost(22.5 * BarObstacle.THICKNESS, 12.5 * BarObstacle.THICKNESS, Color.GREENYELLOW, maze, this));
        this.ghosts.add(new Ghost(28.5 * BarObstacle.THICKNESS, 12.5 * BarObstacle.THICKNESS, Color.BLACK, maze, this));
        this.ghosts.add(new Ghost(28.5 * BarObstacle.THICKNESS, 9.5 * BarObstacle.THICKNESS, Color.SPRINGGREEN, maze, this));
    }

	
    

}
