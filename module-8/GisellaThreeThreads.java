import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.util.Random;

public class GisellaThreeThreads extends Application {

    // Minimum 10,000 characters per thread
    private static final int COUNT = 10000;

    private TextArea textArea = new TextArea();

    @Override
    public void start(Stage primaryStage) {

        textArea.setWrapText(true);
        textArea.setEditable(false);

        BorderPane pane = new BorderPane();
        pane.setCenter(textArea);

        Scene scene = new Scene(pane, 700, 500);

        primaryStage.setTitle("Three Threads Output");
        primaryStage.setScene(scene);
        primaryStage.show();

        // Start threads
        Thread lettersThread = new Thread(new LetterTask());
        Thread numbersThread = new Thread(new NumberTask());
        Thread symbolsThread = new Thread(new SymbolTask());

        lettersThread.start();
        numbersThread.start();
        symbolsThread.start();
    }

    // Thread 1 - Random letters
    class LetterTask implements Runnable {

        @Override
        public void run() {

            Random random = new Random();

            for (int i = 0; i < COUNT; i++) {

                char letter = (char) ('a' + random.nextInt(26));

                Platform.runLater(() ->
                        textArea.appendText(String.valueOf(letter)));

                sleepThread();
            }
        }
    }

    // Thread 2 - Random numbers
    class NumberTask implements Runnable {

        @Override
        public void run() {

            Random random = new Random();

            for (int i = 0; i < COUNT; i++) {

                char number = (char) ('0' + random.nextInt(10));

                Platform.runLater(() ->
                        textArea.appendText(String.valueOf(number)));

                sleepThread();
            }
        }
    }

    // Thread 3 - Random symbols
    class SymbolTask implements Runnable {

        private final char[] symbols =
                {'!', '@', '#', '$', '%', '&', '*', '^'};

        @Override
        public void run() {

            Random random = new Random();

            for (int i = 0; i < COUNT; i++) {

                char symbol = symbols[random.nextInt(symbols.length)];

                Platform.runLater(() ->
                        textArea.appendText(String.valueOf(symbol)));

                sleepThread();
            }
        }
    }

    // Small pause so threads mix output together
    private void sleepThread() {

        try {
            Thread.sleep(1);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}