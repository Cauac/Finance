package finance;

import finance.controller.AccountController;
import finance.model.Account;
import finance.view.account.AccountBox;
import finance.view.account.NewAccountBox;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.layout.FlowPane;

public class Pane1Controller {

    @FXML
    FlowPane flowPane;

    @FXML
    private void initialize() {
        Account account1 = new Account();
        account1.setTitle("Моя карточка");
        account1.setCurrency("BLR");
        account1.setType("карта");
        account1.setAmount(50d);
        Account account2 = new Account();
        account2.setTitle("Доллары");
        account2.setCurrency("$");
        account2.setType("наличные");
        account2.setAmount(560d);
        AccountBox accountBox = new AccountBox(account1);
        accountBox.setOnRemoveAction(event -> flowPane.getChildren().remove(accountBox));
        AccountBox accountBox2 = new AccountBox(account2);
        accountBox2.setOnRemoveAction(event -> flowPane.getChildren().remove(accountBox2));
        flowPane.getChildren().add(new NewAccountBox());
        flowPane.getChildren().add(accountBox);
        flowPane.getChildren().add(accountBox2);
    }
}
