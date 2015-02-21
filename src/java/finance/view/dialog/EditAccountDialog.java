package finance.view.dialog;

import finance.ApplicationProperties;
import finance.model.Account;
import finance.view.event.AccountEvent;
import javafx.collections.FXCollections;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.apache.commons.lang3.math.NumberUtils;


public class EditAccountDialog extends Stage {

    public final static double WIDTH = 300d;
    public final static double FIELD_HEIGHT = 40d;
    public final static Font FORM_FONT = new Font(18d);

    protected ChoiceBox<String> typeBox = new ChoiceBox<>();
    protected ChoiceBox<String> currencyBox = new ChoiceBox<>();
    protected TextField amountField = new TextField();
    protected TextField descriptionField = new TextField();

    protected Account account;
    protected EventHandler<AccountEvent> saveBtnHandler;

    public EditAccountDialog() {
        account = new Account();
        initStyle(StageStyle.UTILITY);
        setScene(new Scene(build()));
    }

    public EditAccountDialog(Account account) {
        this();
        populateFields(account);
    }

    protected Parent build() {
        VBox root = new VBox();
        root.setPrefWidth(WIDTH);
        root.setPrefHeight(450d);
        root.setPadding(new Insets(10d, 16d, 0d, 16d));

        Label descriptionLabel = new Label("Название");
        descriptionLabel.setFont(FORM_FONT);
        descriptionLabel.setPrefHeight(FIELD_HEIGHT);

        Label currencyLabel = new Label("Валюта");
        currencyLabel.setFont(FORM_FONT);
        currencyLabel.setPrefHeight(FIELD_HEIGHT);
        VBox.setMargin(currencyLabel, new Insets(10d, 0, 0, 0));

        Label typeLabel = new Label("Тип");
        typeLabel.setFont(FORM_FONT);
        typeLabel.setPrefHeight(FIELD_HEIGHT);
        VBox.setMargin(typeLabel, new Insets(10d, 0, 0, 0));

        Label amountLabel = new Label("Остаток на счету");
        amountLabel.setFont(FORM_FONT);
        amountLabel.setPrefHeight(FIELD_HEIGHT);
        VBox.setMargin(amountLabel, new Insets(10d, 0, 0, 0));

        descriptionField.setPrefWidth(WIDTH);
        descriptionField.setPrefHeight(FIELD_HEIGHT);
        descriptionField.setFont(FORM_FONT);

        currencyBox.setPrefWidth(WIDTH);
        currencyBox.setPrefHeight(FIELD_HEIGHT);
        currencyBox.setItems(FXCollections.observableArrayList(ApplicationProperties.getAccountCurrencies()));

        typeBox.setPrefWidth(WIDTH);
        typeBox.setPrefHeight(FIELD_HEIGHT);
        typeBox.setItems(FXCollections.observableArrayList(ApplicationProperties.getAccountTypes()));

        amountField.setPrefHeight(FIELD_HEIGHT);
        amountField.setPrefWidth(WIDTH);
        amountField.setFont(FORM_FONT);

        HBox buttons = new HBox(10);
        buttons.setAlignment(Pos.CENTER);

        Button saveBtn = new Button("Сохранить");
        saveBtn.setFont(FORM_FONT);
        saveBtn.setPrefWidth(150d);
        saveBtn.setOnAction(e -> {
            if (checkFields()) {
                if (saveBtnHandler != null) {
                    saveBtnHandler.handle(new AccountEvent(getAccount()));
                }
                this.close();
            }
        });

        Button cancelBtn = new Button("Отмена");
        cancelBtn.setFont(FORM_FONT);
        cancelBtn.setPrefWidth(150d);
        cancelBtn.setOnAction(e -> this.close());
        buttons.getChildren().addAll(saveBtn, cancelBtn);

        VBox.setMargin(buttons, new Insets(20d, 0, 0, 0));

        root.getChildren().addAll(descriptionLabel, descriptionField, currencyLabel, currencyBox, typeLabel, typeBox, amountLabel, amountField, buttons);
        return root;
    }

    protected void populateFields(Account account) {
        descriptionField.setText(account.getTitle());
        currencyBox.getSelectionModel().select(account.getCurrency());
        typeBox.getSelectionModel().select(account.getType());
        amountField.setText(account.getAmount().toString());
    }

    protected boolean checkFields() {
        return !descriptionField.getText().isEmpty() && !amountField.getText().isEmpty() && NumberUtils.isNumber(amountField.getText());
    }

    protected Account getAccount() {
        Account account = new Account();
        account.setTitle(descriptionField.getText());
        account.setCurrency(currencyBox.getValue());
        account.setType(typeBox.getValue());
        account.setAmount(Double.parseDouble(amountField.getText()));
        return account;
    }

    public void setOnSaveBtnHandler(EventHandler<AccountEvent> eventHandler) {
        this.saveBtnHandler = eventHandler;
    }
}
