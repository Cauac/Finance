package finance.view.account;

import finance.model.Account;
import finance.view.dialog.ConfirmDialog;
import finance.view.dialog.EditAccountDialog;
import finance.view.event.AccountEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class AccountBox extends VBox {

    private EventHandler<AccountEvent> updateAccountHandler;
    private EventHandler<AccountEvent> removeAccountHandler;

    public AccountBox(Account account) {
        setPrefWidth(220d);
        setPrefHeight(220d);
        setStyle("-fx-border-color: black;");
        setPadding(new Insets(5d, 16d, 0d, 16d));

        Label title = new Label(account.getTitle());
        title.setPrefWidth(220d);
        title.setPrefHeight(20d);
        title.setAlignment(Pos.CENTER);
        title.setFont(new Font(18d));
        VBox.setMargin(title, new Insets(0d, 0d, 20d, 0d));

        Label amountLabel = new Label("Остаток:");
        amountLabel.setFont(new Font(16));

        Label amount = new Label(account.getAmount() + " " + account.getCurrency());
        amount.setFont(new Font(12));
        VBox.setMargin(amount, new Insets(5d, 0d, 0d, 0d));

        Label typeLabel = new Label("Тип:");
        typeLabel.setFont(new Font(16));
        VBox.setMargin(typeLabel, new Insets(10d, 0d, 0d, 0d));

        Label type = new Label(account.getType());
        type.setFont(new Font(12));
        VBox.setMargin(type, new Insets(5d, 0d, 0d, 0d));

        Button editBtn = new Button("Изменить");
        editBtn.setPrefWidth(110d);
        editBtn.setPrefHeight(40d);
        editBtn.setOnAction(e -> {
            EditAccountDialog dialog = new EditAccountDialog(account);
            dialog.setOnSaveBtnHandler(event -> {
                Account changedAccount = event.getAccount();
                title.setText(changedAccount.getTitle());
                amount.setText(changedAccount.getAmount() + " " + changedAccount.getCurrency());
                type.setText(changedAccount.getType());
                if (updateAccountHandler != null) {
                    updateAccountHandler.handle(event);
                }
            });
            dialog.showAndWait();
        });

        Button removeBtn = new Button("Удалить");
        removeBtn.setPrefWidth(110d);
        removeBtn.setPrefHeight(40d);
        removeBtn.setOnAction(e -> {
            ConfirmDialog dialog = new ConfirmDialog("Удалить", "Вы уверены что хотите удалить аккаунт?");
            dialog.setModal(getScene().getWindow());
            dialog.showAndWait();
            if (dialog.isOKClicked() && removeAccountHandler != null) {
                removeAccountHandler.handle(new AccountEvent(account));
            }
        });

        HBox buttons = new HBox(5d);
        buttons.getChildren().addAll(editBtn, removeBtn);
        VBox.setMargin(buttons, new Insets(15d, 0d, 0d, 0d));

        getChildren().addAll(title, amountLabel, amount, typeLabel, type, buttons);
    }

    public void setUpdateAccountHandler(EventHandler<AccountEvent> updateAccountHandler) {
        this.updateAccountHandler = updateAccountHandler;
    }

    public void setRemoveAccountHandler(EventHandler<AccountEvent> removeAccountHandler) {
        this.removeAccountHandler = removeAccountHandler;
    }
}
