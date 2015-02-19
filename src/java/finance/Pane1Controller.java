package finance;

import finance.view.account.AccountBox;
import finance.view.account.NewAccountBox;
import javafx.fxml.FXML;
import javafx.scene.layout.FlowPane;

public class Pane1Controller {

    @FXML
    FlowPane flowPane;

    @FXML
    private void initialize() {

        NewAccountBox newAccountBox = new NewAccountBox();
        newAccountBox.setSaveAccountEventEventHandler(e ->
        {
            flowPane.getChildren().add(new AccountBox(e.getAccount()));
        });

        flowPane.getChildren().add(newAccountBox);
    }
}
