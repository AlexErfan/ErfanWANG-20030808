package ghostFactoryPattern;

import gameManagerView.GameView;

public class GhostFactory {
	public GhostGenerator generate = new GhostGenerator(); 
	
	public Ghost getGhost(int ghostNumber) {
		Ghost ghost = null;
		switch (ghostNumber) {
			case 1:
				ghost = generate.produce(1);
				break;
			case 2:
				ghost = generate.produce(2);
				break;
			case 3:
				ghost = generate.produce(3);
				break;
			case 4:
				ghost = generate.produce(4);
				break;
		}
		return ghost;
	}
}
