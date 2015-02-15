package finance;

import finance.controller.AccountController;
import finance.model.Account;
import finance.view.account.AccountBox;
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
//        AccountController accountWidget = ResourceLoader.getAccountWidget();
//        accountWidget.setAccount(account1);
        flowPane.getChildren().add(new AccountBox(account1));
//        AccountController accountWidget2 = ResourceLoader.getAccountWidget();
//        accountWidget2.setAccount(account2);
        AccountBox accountBox = new AccountBox(account2);
        accountBox.onRemoveAction(event -> flowPane.getChildren().remove(accountBox));
        flowPane.getChildren().add(accountBox);
    }
}
