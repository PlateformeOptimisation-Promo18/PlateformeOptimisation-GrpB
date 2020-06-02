package main.application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Tab;

import java.io.IOException;

/**
 * Controlleur principal
 * @author Fiona Issart
 *
 */

public class ControllerPrincipal
{

    @FXML
    private Tab fenOptimisation;

    @FXML
    private Tab fenComparaison;

    @FXML
    private Tab fenConsultation;

    @FXML
    public void initialize ()
    {
        try
        {
            //Corentin :fenOptimisation.setContent(FXMLLoader.load(getClass().getResource("Optimisation.fxml")));
            //Ruben: fenComparaison.setContent(FXMLLoader.load(getClass().getResource("Comparaison.fxml")));
            fenConsultation.setContent(FXMLLoader.load(getClass().getResource("Consultation.fxml")));

        }
        catch(IOException iex)
        {
            System.out.println("Incapable de télécharger OptimisationTab");
        }

    }



}
