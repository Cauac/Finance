package finance.view.dialog;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.stage.StageStyle;

public class ConfirmDialog extends AbstractDialog {

    public static final Image image = new Image(ConfirmDialog.class.getResourceAsStream("images/ic_info_white_48dp.png"));
    public static final Font font = new Font(18);

    private boolean isOKClicked;

    public ConfirmDialog(String title, String message) {
        setTitle(title);
        initStyle(StageStyle.UTILITY);
        setScene(new Scene(build(message)));
    }

    protected Parent build(String message) {
        AnchorPane root = new AnchorPane();
        root.setMinWidth(550d);
        root.setMinHeight(200d);
        root.setStyle("-fx-background-color: darkgrey");

        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(72);
        imageView.setFitHeight(72);
        AnchorPane.setLeftAnchor(imageView, 20d);
        AnchorPane.setTopAnchor(imageView, 20d);

        Label messageLabel = new Label(message);
        messageLabel.setFont(font);
        AnchorPane.setLeftAnchor(messageLabel, 108d);
        AnchorPane.setTopAnchor(messageLabel, 20d);
        AnchorPane.setRightAnchor(messageLabel, 50d);

        Button ok = new Button("OK");
        ok.setPrefWidth(100d);
        ok.setFont(font);
        ok.setOnAction(a -> {
            isOKClicked = true;
            this.close();
        });
        AnchorPane.setRightAnchor(ok, 136d);
        AnchorPane.setBottomAnchor(ok, 20d);

        Button cancel = new Button("Отмена");
        cancel.setPrefWidth(100d);
        cancel.setFont(font);
        cancel.setOnAction(a -> this.close());
        AnchorPane.setRightAnchor(cancel, 20d);
        AnchorPane.setBottomAnchor(cancel, 20d);

        root.getChildren().addAll(imageView, messageLabel, ok, cancel);
        return root;
    }

    public boolean isOKClicked() {
        return isOKClicked;
    }
}
