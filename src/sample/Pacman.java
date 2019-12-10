package sample;



import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Pacman extends Circle {

    public Pacman(double x, double y) {
        this.setCenterX(x);
        this.setCenterY(y);
//        Image img = new Image("pacman.png");
        this.setRadius(25);
        this.setFill(Color.YELLOW);
    }
}
