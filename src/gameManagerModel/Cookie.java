package gameManagerModel;



import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

/**
 * The class Cookie extends Circle which uses the methods inherited to draw cookies on map.
 * @author alex
 *
 */
public class Cookie extends Circle {
	
	/**
	 * The value for each cookie, if cookie is ate, then score increases 5.
	 */
    private int value;

    /**
     * Constructor for Cookie.
     * @param x - the center location for cookie on X axis.
     * @param y - the center location for cookie on Y axis.
     */
    public Cookie(double x, double y) {
        this.value = 5;
        this.setCenterX(x);
        this.setCenterY(y);
        this.setRadius(12.5);
        this.setFill(Color.SADDLEBROWN);
    }
    
    /**
     * Getter for private filed value.
     * @return value - the value.
     */
    public int getValue() {
        return value;
    }

    /**
     * Set cookie to invisible.
     */
    public void hide() {
        this.setVisible(false);
    }

    /**
     * Set cookie visible.
     */
    public void show() {
        this.setVisible(true);
    }

}