package finance;

import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;


public class MainController {

    @FXML
    Pane mainPane;

    @FXML
    protected void showPane1() {
        mainPane.getChildren().clear();
        Parent pane = ResourceLoader.getPane1();
        mainPane.getChildren().add(pane);
        AnchorPane.setTopAnchor(pane,0d);
        AnchorPane.setLeftAnchor(pane,0d);
        AnchorPane.setRightAnchor(pane,0d);
        AnchorPane.setBottomAnchor(pane,0d);
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
