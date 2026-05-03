import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class StyledCircles extends Application {

    @Override
    public void start(Stage primaryStage) {

        Circle c1 = new Circle(50);
        c1.getStyleClass().add("whiteFillBlackStroke");

        Circle c2 = new Circle(50);
        c2.getStyleClass().add("whiteFillBlackStroke");

        Circle c3 = new Circle(50);
        c3.setId("redCircle");
        
        Circle c4 = new Circle(50);
        c4.setId("greenCircle");

        HBox box = new HBox(20, c1, c2, c3, c4);

        Scene scene = new Scene(box, 500, 150);
        scene.getStylesheets().add("mystyle.css");

        primaryStage.setTitle("Module 7 Programming Assignment");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
