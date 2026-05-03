import static org.junit.Assert.*;
import org.junit.Test;
import javafx.scene.Scene;
import javafx.scene.shape.Circle;

public class StyleTest {

    @Test
    public void testCircleStyles() {
        Circle c1 = new Circle(50);
        c1.getStyleClass().add("whiteFillBlackStroke");

        Circle c2 = new Circle(50);
        c2.setId("redCircle");

        Scene scene = new Scene(c1);
        scene.getStylesheets().add("mystyle.css");

        // Ensure class is applied
        assertTrue(c1.getStyleClass().contains("whiteFillBlackStroke"));

        assertEquals("redCircle", c2.getId());

        assertFalse(scene.getStylesheets().isEmpty());
    }
}
