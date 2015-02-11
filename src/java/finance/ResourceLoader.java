package finance;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

import java.io.IOException;

public class ResourceLoader {

    public static Parent getMainWindow() {
        Parent window = null;
        try {
            window = FXMLLoader.load(ResourceLoader.class.getResource("/fxml/main.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return window;
    }

    public static Parent getPane1() {
        Parent window = null;
        try {
            window = FXMLLoader.load(ResourceLoader.class.getResource("/fxml/pane1.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return window;
    }
}
