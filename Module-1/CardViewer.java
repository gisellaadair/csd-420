import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.*;

public class CardViewer extends Application {

    private final int NUM_CARDS = 4;
    private final int TOTAL_CARDS = 52;
    private ImageView[] cardViews = new ImageView[NUM_CARDS];

    @Override
    public void start(Stage primaryStage) {

        HBox cardBox = new HBox(10);
        cardBox.setAlignment(Pos.CENTER);

        for (int i = 0; i < NUM_CARDS; i++) {
            cardViews[i] = new ImageView();
            cardViews[i].setFitWidth(100);
            cardViews[i].setPreserveRatio(true);
            cardBox.getChildren().add(cardViews[i]);
        }

        displayRandomCards();

        //Lambda expressions
        Button refreshButton = new Button("Refresh");
        refreshButton.setOnAction(e -> displayRandomCards());

        VBox root = new VBox(15, cardBox, refreshButton);
        root.setAlignment(Pos.CENTER);

        Scene scene = new Scene(root, 500, 300);
        primaryStage.setTitle("Random Card Viewer");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void displayRandomCards() {
        List<Integer> deck = new ArrayList<>();

        for (int i = 1; i <= TOTAL_CARDS; i++) {
            deck.add(i);
        }

        Collections.shuffle(deck);

        // Pick the four cards
        for (int i = 0; i < NUM_CARDS; i++) {
            int cardNumber = deck.get(i);

            String imagePath = "file:cards/" + cardNumber + ".png";
            Image image = new Image(imagePath);

            cardViews[i].setImage(image);
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}