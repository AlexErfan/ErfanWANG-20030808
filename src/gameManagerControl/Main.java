package gameManagerControl;



import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage theStage) throws Exception{
        theStage.setTitle( "Welcome!" );
        
        
        FXMLLoader startPageLoader = new FXMLLoader(getClass().getResource("../startPage/start.fxml"));
        Parent start = startPageLoader.load();
        
        
        Scene startScene = new Scene(start);
        
        
        theStage.setScene(startScene);
        
        theStage.show();
        
       
    }


    public static void main(String[] args) {
        launch(args);
        
    }
}