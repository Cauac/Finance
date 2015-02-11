package finance;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;


public class MainController {

    @FXML
    Pane mainPane;

    @FXML
    Label labelPane1;

    @FXML
    protected void showPane1() {
        mainPane.getChildren().add(ResourceLoader.getPane1());
    }

}
