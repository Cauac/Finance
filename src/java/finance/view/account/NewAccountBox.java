package finance.view.account;

import finance.view.dialog.EditAccountDialog;
import finance.view.event.AccountEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class NewAccountBox extends VBox {

    public NewAccountBox() {
        setAlignment(Pos.TOP_CENTER);
        setPrefWidth(220d);
        setPrefHeight(220d);
        setStyle("-fx-border-color: #727272; -fx-border-style: dashed;");

        ImageView imageView = new ImageView();
        imageView.setFitWidth(180);
        imageView.setFitHeight(180);
        imageView.setImage(new Image("images/ic_add_box_white_48dp.png"));

        Label add = new Label("Добавить");
        add.setFont(new Font(18));

        getChildren().addAll(imageView, add);
    }

    public void setSaveAccountEventEventHandler(EventHandler<AccountEvent> handler) {
        setOnMouseReleased(e -> {
            EditAccountDialog dialog = new EditAccountDialog();
            dialog.setOnSaveBtnHandler(handler);
            dialog.showAndWait();
        });
    }
}
