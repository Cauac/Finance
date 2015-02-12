package finance;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

import java.io.IOException;

public class ResourceLoader {

    private static Parent mainWindow = null;
    private static Parent pane1 = null;
    private static Parent pane2 = null;
    private static Parent pane3 = null;
    private static Parent pane4 = null;

    public static Parent getMainWindow() {
        if (mainWindow == null) {
            try {
                mainWindow = FXMLLoader.load(ResourceLoader.class.getResource("/fxml/main.fxml"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return mainWindow;
    }

    public static Parent getPane1() {
        if (pane1 == null) {
            try {
                pane1 = FXMLLoader.load(ResourceLoader.class.getResource("/fxml/pane1.fxml"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return pane1;
    }

    public static Parent getPane2() {
        if (pane2 == null) {
            try {
                pane2 = FXMLLoader.load(ResourceLoader.class.getResource("/fxml/pane2.fxml"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return pane2;
    }

    public static Parent getPane3() {
        if (pane3 == null) {
            try {
                pane3 = FXMLLoader.load(ResourceLoader.class.getResource("/fxml/pane3.fxml"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return pane3;
    }

    public static Parent getPane4() {
        if (pane4 == null) {
            try {
                pane4 = FXMLLoader.load(ResourceLoader.class.getResource("/fxml/pane4.fxml"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return pane4;
    }

    public static Parent getAccountWidget(){
        Parent widget=null;
        try {
            widget= FXMLLoader.load(ResourceLoader.class.getResource("/fxml/account.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return widget;
    }
}
