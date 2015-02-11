package finance;

import javafx.fxml.FXML;
import javafx.scene.layout.Pane;


public class MainController {

    @FXML
    Pane mainPane;

    @FXML
    protected void showPane1() {
        mainPane.getChildren().clear();
        mainPane.getChildren().add(ResourceLoader.getPane1());
    }

    @FXML
    protected void showPane2() {
        mainPane.getChildren().clear();
        mainPane.getChildren().add(ResourceLoader.getPane2());
    }
    @FXML
    protected void showPane3() {
        mainPane.getChildren().clear();
        mainPane.getChildren().add(ResourceLoader.getPane3());
    }
    @FXML
    protected void showPane4() {
        mainPane.getChildren().clear();
        mainPane.getChildren().add(ResourceLoader.getPane4());
    }
}
