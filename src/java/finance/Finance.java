package finance;

import javafx.scene.Scene;
import javafx.stage.Stage;

public class Finance extends javafx.application.Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Title");
        primaryStage.setScene(new Scene(ResourceLoader.getMainWindow()));
        primaryStage.show();
        primaryStage.setMinHeight(600);
        primaryStage.setMinWidth(900);
    }


    public static void main(String[] args) {
        launch(args);
    }
}
