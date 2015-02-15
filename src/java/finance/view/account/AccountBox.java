package finance.view.account;

import finance.model.Account;
import finance.view.dialog.ConfirmDialog;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

import java.awt.*;

public class AccountBox extends VBox {
    Button removeBtn = new Button("Удалить");

    public AccountBox(Account account) {
        setPrefWidth(220d);
        setPrefHeight(220d);
        setStyle("-fx-border-radius: 6; -fx-border-color: black;");
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

        removeBtn.setPrefWidth(110d);
        removeBtn.setPrefHeight(40d);

        HBox buttons = new HBox(5d);
        buttons.getChildren().addAll(editBtn, removeBtn);
        VBox.setMargin(buttons, new Insets(25d, 0d, 0d, 0d));

        getChildren().addAll(title, amountLabel, amount, typeLabel, type, buttons);
    }

    public void onRemoveAction(EventHandler handler) {
        removeBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                ConfirmDialog dialog = new ConfirmDialog("Удалить", "Вы уверены что хотите удалить аккаунт?");
                dialog.setModal(getScene().getWindow());
                dialog.showAndWait();
                if (dialog.isOKClicked()) {
                    handler.handle(event);
                }
            }
        });

    }
}
