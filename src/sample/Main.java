package sample;



import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage theStage) throws Exception{
        theStage.setTitle( "Welcome!" );
        
        
        FXMLLoader startPaneLoader = new FXMLLoader(getClass().getResource("../startPage/start.fxml"));
        Parent start = startPaneLoader.load();
        
        
        Scene startScene = new Scene(start);
        
        
        theStage.setScene(startScene);
        
        theStage.show();
        
       
    }


    public static void main(String[] args) {
        launch(args);
        
    }
}