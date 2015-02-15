package finance.controller;

import finance.view.dialog.ConfirmDialog;
import finance.model.Account;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Label;

public class AccountController {

    @FXML
    Label title;

    private Parent view;
    private Account account;

    @FXML
    public void removeBtn() {

    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
        title.setText(account.getTitle());
    }

    public Parent getView() {
        return view;
    }

    public void setView(Parent view) {
        this.view = view;
    }
}
