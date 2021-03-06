package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    private final ControllerFX controller = new ControllerFX();

    @Override
    public void start(Stage primaryStage) throws Exception {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/sample.fxml"));
            primaryStage.setTitle("University");
            primaryStage.setScene(new Scene(root, 1000, 600));
            primaryStage.show();
            controller.setStage(primaryStage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void stop() throws Exception {
        controller.stopController();
        System.exit(0);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
