package main.application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import main.model.generic.StopRequired;
import main.model.generic.StopRequis;

public class ControllerSimulation extends BorderPane {
	private Pane view;
	StopRequired arretUtilisateur = new StopRequired();
	
	/**
	 * @return Objet Pane étant la racine du fichier fxml de l'interface de simulation
	 * @author Corentin Pontal
	 */
	public Pane getPaneControllerSimulation() {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("InterfaceSimulation.fxml"));
			view = fxmlLoader.load();
		} catch (IOException exception) {
			throw new RuntimeException(exception);
		}
		return view;
	}
	
	@FXML
	private void handleClic(ActionEvent Evt) {
		System.out.println("Le clic fonctionne bien");
	}
	
	/**
	 * Action du bouton d'arret de l'algo
	 * @param Evt
	 * @author Corentin Pontal
	 */
	@FXML
	private void arreterAlgo(ActionEvent Evt) {
		if (!arretUtilisateur.isStop()) {
			arretUtilisateur.setStopRequired();
			System.out.println("L'algorithme vient d'être arreté");
		} else {
			System.out.println("Algorithme déja arreté");
		}
		
	}
}
