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
        newAccountBox.setSaveAccountEventEventHandler(newEvent ->
        {
            AccountBox accountBox = new AccountBox(newEvent.getAccount());
            accountBox.setRemoveAccountHandler(removeEvent -> flowPane.getChildren().remove(accountBox));
            accountBox.setUpdateAccountHandler(updateEvent->{
            });
            flowPane.getChildren().add(0,accountBox);
        });

        flowPane.getChildren().add(newAccountBox);
    }
}
