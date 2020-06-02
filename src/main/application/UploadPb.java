package main.application;


import java.io.File;
import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.FileChooser;

public class UploadPb {
    String filePath1,filePath2;
    ArrayList<double[]> solution1,solution2 ;
    String nomPb1 = "", nomPb2 = "" ;
    @FXML
    private Button btnFichier1;
    @FXML
    private Label labelfichier1;
    @FXML
    private Button btnFichier2;
    @FXML

    private Label labelfichier2;
    @FXML
    private  Button btnCompare;
    @FXML private  Button btnClose;

    /**
     * Lancement de la comparaison et fermeture du modal
     * @param evt
     */
    @FXML
    private void startComparaison(ActionEvent evt){

        System.out.println("Debut de la comparaison");
        // recupération des solutions
        solution1 = importResultFiles(filePath1);
        solution2 = importResultFiles(filePath2);

        /* Envoyer les solutions à la fenetre principale et Fermeture du modal en liberant les ressources
        de lecture et du buffer.
         */
        /*btnClose.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                btnClose.close();
            }
        });*/
    }

    /**
     * Méthode pour extraire le contenu du fichier passé en entrée
     * @param filePath      chemin vers le fichier a traiter
     * @return              renvoi les solutions extraites du fichier
     */
    private ArrayList<double[]> importResultFiles(String filePath){
        ArrayList<double[]> solution = new ArrayList<double[]>();
        //verifier si les fichiers sont pour le meme probleme
        //Ouvrir le fichier et le lire


        return solution;
    }
    /**
     * Téléchargement du fichier 1
     * Cf : https://docs.oracle.com/javase/8/javafx/api/javafx/stage/FileChooser.html
     * @param evt
     */
    @FXML
    private void uploadFichier(ActionEvent evt){
        try {
            // Ouvertur fenetre de dialogue (fenetre pour rechercher fichier) avec filter
            //Cf Oracle https://docs.oracle.com/javase/8/javafx/api/javafx/stage/FileChooser.html
            FileChooser fichierResult1 = new FileChooser();
            FileChooser.ExtensionFilter extensionFilter = new FileChooser.ExtensionFilter("Text File (*.txt)", "*.txt");
            fichierResult1.getExtensionFilters().add(extensionFilter);
            File selectedFile = fichierResult1.showOpenDialog(null);
            System.out.println("fichier 1 en Téléchargement");


            if ( selectedFile != null) {
                filePath1 = selectedFile.getAbsolutePath();
                nomPb1 = selectedFile.getName();
                labelfichier1.setText("fichier 1 :\n"+nomPb1+" téléchargé");
            }else{
                //System.out.println("Erreur lors du téléchargement du fichier1");
                //pb affiche message à resoudre (position)
                labelfichier1.setText("Erreur lors du téléchargement du fichier1");
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * Télechargement du fichier 2
     * @param evt
     */
    @FXML
    private void uploadFichier2(ActionEvent evt){

        try {
            FileChooser fichierResult2 = new FileChooser();
            FileChooser.ExtensionFilter extensionFilter = new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
            fichierResult2.getExtensionFilters().add(extensionFilter);

            File selectedFile = fichierResult2.showOpenDialog(null) ;
            System.out.println("fichier 2 en Téléchargement");
            if ( selectedFile != null) {
                filePath2 = selectedFile.getAbsolutePath();
                nomPb2 = selectedFile.getName();
                labelfichier2.setText("fichier 2:\n"+nomPb2+" téléchargé");
            } else{
                labelfichier2.setText("Erreur lors du téléchargement du fichier 2");
                //System.out.println("Erreur lors du téléchargement du fichier 2");
            }

        }catch (Exception e){
            e.printStackTrace();
        }

    }

}
