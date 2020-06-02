package main.application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
 * Controlleur de consultation
 * @author Fiona Issart
 *
 */
public class ControllerConsultation
{

    @FXML
    private Button butUpload;

    @FXML
    private LineChart<Number, Number>  visualisationChart;

    @FXML
    private void buttonTelClick (ActionEvent evt) throws Exception
    {

        Parent root = FXMLLoader.load(getClass().getResource("Consultation.fxml"));
        // Name axes
        visualisationChart.getXAxis().setLabel("Hypervolume");
        visualisationChart.getYAxis().setLabel("Time");
        visualisationChart.setTitle("Visualisation");

        // Definion des series
        XYChart.Series series = new XYChart.Series();

        FileChooser fc = new FileChooser() ;
        fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt"));
        File selectedFile = fc.showOpenDialog(null) ;

        try
        {

            if ( selectedFile != null)
            {
                FileReader filereader = new FileReader(selectedFile.getPath());
                BufferedReader bufferedreader = new BufferedReader(filereader);

                String ligne;
                int compteur = 0;

                while ((ligne = bufferedreader.readLine()) != null)
                {
                    if (compteur > 0)
                    {
                        series.getData().add(new XYChart.Data(Double.parseDouble(ligne.substring(14,21)),Double.parseDouble(ligne.substring(0,13)) ));

                    }

                    compteur++;
                }
                visualisationChart.getData().add(series);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @FXML
    public void initialize ()
    {

        Image uploadImage=new Image(getClass().getResource("Telecharger.png").toExternalForm());
        ImageView imageView=new ImageView(uploadImage);
        imageView.setFitHeight(30);
        imageView.setFitWidth(30);
        butUpload.setGraphic(imageView);

    }
}
