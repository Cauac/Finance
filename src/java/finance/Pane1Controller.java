package finance;

import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.layout.FlowPane;

public class Pane1Controller {

    @FXML
    FlowPane flowPane;

    @FXML
    private void initialize() {
        Parent accountWidget = ResourceLoader.getAccountWidget();
        flowPane.getChildren().add(accountWidget);
    }
}
