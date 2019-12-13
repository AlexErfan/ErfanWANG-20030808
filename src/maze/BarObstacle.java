package maze;



import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class BarObstacle extends Rectangle {

    public static double THICKNESS = 25;
   
    /**
     *
     * @param x
     * @param y
     * @param orientation - horizontal or vertical
     * @param length - the length of the bar (1 == 100px)
     * @param color - the color of the wall
     */
    public BarObstacle(double x, double y, String orientation, double length, Color color) {
        this.setX(x);
        this.setY(y);
        if (orientation.equals("horizontal")) {
            this.setHeight(BarObstacle.THICKNESS);
            this.setWidth(length * BarObstacle.THICKNESS);
        } else {
            this.setHeight(length * BarObstacle.THICKNESS);
            this.setWidth(BarObstacle.THICKNESS);
        }
        this.setFill(color);
        this.setStrokeWidth(3);
    }
    
}
