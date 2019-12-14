package ghostFactoryPattern;

import gameManagerControl.GameManager;
import gameManagerModel.BarObstacle;
import gameManagerView.GameView;

public class GhostGenerator implements GhostInterface{
	private Ghost ghost = null;

	@Override
	public Ghost produce(int ghostNumber) {
		// TODO Auto-generated method stub
		switch (ghostNumber){
			case 1:
				ghost = new Ghost(18.5 * BarObstacle.THICKNESS, 12.5 * BarObstacle.THICKNESS, "ghost1.png" , GameView.maze, GameView.gameManager);
				break;
			case 2:
				ghost = new Ghost(22.5 * BarObstacle.THICKNESS, 12.5 * BarObstacle.THICKNESS, "ghost2.png", GameView.maze, GameView.gameManager);
				break;
			case 3:
				ghost = new Ghost(28.5 * BarObstacle.THICKNESS, 12.5 * BarObstacle.THICKNESS, "ghost3.png", GameView.maze, GameView.gameManager);
				break;
			case 4:
				ghost = new Ghost(28.5 * BarObstacle.THICKNESS, 9.5 * BarObstacle.THICKNESS, "ghost4.png", GameView.maze, GameView.gameManager);
				break;			
			case 5:
				ghost = new Ghost(22.5 * BarObstacle.THICKNESS, 9.5 * BarObstacle.THICKNESS, "ghost5.png", GameView.maze, GameView.gameManager);
				break;
		}
		return ghost;
	}
}
