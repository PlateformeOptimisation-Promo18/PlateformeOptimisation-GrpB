package main.application;


import java.io.IOException;
import javafx.fxml.Initializable;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.ArrayList;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;


public class ControllerComparaison implements Initializable{
    @FXML
    private LineChart<Number, Number> graphHV ;
    @FXML
    private Button buttomAccueil;
    @FXML
    private Button buttonParametres;
    @FXML
    private Button buttomStop;

    /**
     * Clique event boutton Accueil
     * @param evt
     */
    @FXML
    private void actionAccueil(ActionEvent evt){
        System.out.println("action de retour");
    }

    /**
     * Clique event boutton Stop
     * @param evt
     */
    @FXML
    private void actionStop(ActionEvent evt){

        System.out.println("action close");
    }

    /**
     * Méthode pour afficher une fenetre modal pour le téléchargement des fichiers
     * @param evt
     * @throws IOException
     */
    @FXML
    private void actionParametres(ActionEvent evt) throws IOException {
        System.out.println("action modal");
        Stage stage2 = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("UploadPb.fxml"));
        stage2.setScene(new Scene(root));
        stage2.setTitle("Parametrage comparaison");
        stage2.initModality(Modality.APPLICATION_MODAL);
        stage2.initOwner(((Parent)evt.getSource()).getScene().getWindow() );
        stage2.show();
    }

    /**
     * Permet de generer automatiquement le contenu du graph à l'aide des fichiers de solutions téléchargés
     * Cf :
     * https://docs.oracle.com/javafx/2/charts/line-chart.htm
     * https://docs.oracle.com/javase/8/javafx/api/javafx/scene/chart/LineChart.html
     * @param Solution1
     * @param nomSol1      Nom solution 1
     * @param Solution2
     * @param nomSol2      Nom solution 2
     */
    public void generateGraph(ArrayList<double[]> Solution1,ArrayList<double[]> Solution2, String nomSol1  , String nomSol2) {
        // Definion des axes
        NumberAxis axis;

        // On configure les axes
        axis=(NumberAxis) graphHV.getXAxis();
        axis.setAutoRanging(false);
        // valeur de l'hypervolum min des deux solutions
        axis.setLowerBound(Solution1.get(0)[0] <= Solution2.get(0)[0]?Solution1.get(0)[0]:Solution2.get(0)[0]);

        // Valeur de l'hypervolum max des deux solutions
        axis.setUpperBound(Solution1.get(Solution1.size()-1)[0] <= Solution2.get(Solution2.size()-1)[0]?Solution1.get(Solution1.size()-1)[0]:Solution2.get(Solution2.size()-1)[0]);

        // On nomme les axes
        graphHV.getXAxis().setLabel("Hypervolum");
        graphHV.getYAxis().setLabel("Time");

        // Creation du chart
        graphHV.setTitle("Comparaison des Solutions ");

        // Definition des series qui seront affichées
        XYChart.Series<Number, Number> series1 = new XYChart.Series<Number, Number>();
        series1.setName(nomSol1);
        XYChart.Series<Number, Number> series2 = new XYChart.Series<Number, Number>();
        series2.setName(nomSol2);

        // Boucles for each pour ajouter des données du graph aux series
        for (double[] point : Solution1) {
            series1.getData().add(new XYChart.Data<Number, Number>(point[0], point[1]));
        }
        for (double[] point : Solution2)
            series2.getData().add(new XYChart.Data<Number, Number>(point[0], point[1]));

        // On ajoute les séries au graph
        graphHV.getData().addAll(series1,series2);

    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}


