package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.File;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("scene/startApp.fxml"));
        primaryStage.setTitle("QAPERFUTILS GUI");
        primaryStage.setScene(new Scene(root));
        primaryStage.getIcons().add(new Image(new File("src/sample/scene/img/background.png").toURI().toString()));
        primaryStage.setResizable(false);
        primaryStage.show();

    }


    public static void main(String[] args) {
        launch(args);
    }
}
