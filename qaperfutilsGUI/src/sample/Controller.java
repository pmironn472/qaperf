package sample;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class Controller {

    @FXML
    Button loadQaperfutils, backButton, pteOneButton, pteTwoButton;


    public void loadQaperfutilScene() {

    }

    public void backScene() {
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("scene/startApp.fxml")));

            Stage window = (Stage) backButton.getScene().getWindow();
            window.setScene(new Scene(root));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void pteOneScene(){
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("scene/pteOneScene.fxml")));

            Stage window = (Stage) pteOneButton.getScene().getWindow();
            window.setScene(new Scene(root));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void pteTwoScene(){
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("scene/pteTwoScene.fxml")));

            Stage window = (Stage) pteTwoButton.getScene().getWindow();
            window.setScene(new Scene(root));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}