/**
 *
 * @author Daniel Orejuela Liu
 */
import java.util.HashMap;
import javafx.application.Application;
import javafx.event.EventType;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;



public class MainApp extends Application{
         //MainApp.java launches the app and sets up the main scene.

    /**
     * @param args the command line arguments
     */
       public static void main(String[] args) {
        launch(args);
    }
     
    
    @Override
    public void start(Stage primaryStage) {
        
        primaryStage.setTitle("Typing Tutor - JavaFX Assignment");

        Pane root = new Pane();
        
        GridPane keyboardGrid = new GridPane();
        root.getChildren().add(keyboardGrid);
        HashMap<String, Button> keyboardMap =  TypingController.DisplayOntoRootPane(keyboardGrid);
        
        Scene scene = new Scene(root, 800, 600);
        scene.setOnKeyPressed((KeyEvent event) -> {
            KeyCode pressedKey = event.getCode();
            String keyStr = pressedKey.toString();
            Button keyboardButton = keyboardMap.get(keyStr);
            if (keyboardButton == null) {
                return;
            }
            keyboardButton.setStyle("-fx-background-color: #ff0000;");
        });
        scene.setOnKeyReleased((KeyEvent event) -> {
            KeyCode pressedKey = event.getCode();
            String keyStr = pressedKey.toString();
            Button keyboardButton = keyboardMap.get(keyStr);
            if (keyboardButton == null) {
                return;
            }
            keyboardButton.setStyle("");
        });
        primaryStage.setScene(scene);
        primaryStage.show();
        
        
       
    }
}
