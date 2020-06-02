package main.application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 * Controlleur de démarrage
 * @author Fiona Issart
 *
 */


public class ControllerDem
{
    @FXML
    private Button DemButton;

    @FXML
    private void DemButtonClick(ActionEvent evt) throws Exception
    {

        Stage stage;
        Parent root = FXMLLoader.load(getClass().getResource("Principal.fxml"));

        stage = (Stage) DemButton.getScene().getWindow();


        Scene scene = new Scene(root,800,800);
        stage.getIcons().setAll(new Image(getClass().getResource("Optimisation.png").toExternalForm()));
        stage.setScene(scene);
        stage.show();

    }
}