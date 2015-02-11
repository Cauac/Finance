package finance;

import javafx.scene.Scene;
import javafx.stage.Stage;

public class Finance extends javafx.application.Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Title");
        primaryStage.setScene(new Scene(ResourceLoader.getMainWindow()));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
