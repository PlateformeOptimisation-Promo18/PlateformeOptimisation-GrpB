package main.application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import main.model.generic.CombinatorialMultiObjectiveOptimizationAlgorithm;
import main.model.generic.InterfaceRandom;

/**
 * Controlleur principal
 * @author Corentin Pontal
 *
 */
public class Controller {
	
	@FXML
	private BorderPane paneCentral;
	
	@FXML
	private void initialize() {
		ControllerSimulation customControl = new ControllerSimulation();
		Pane view = customControl.getPaneControllerSimulation();
		paneCentral.setCenter(view);
	}
	
	@FXML
	private void actionRetour(ActionEvent Evt) {
		System.out.println("Le clic fonctionne bien");
	}
	
	@FXML
	private void actionSuivant(ActionEvent Evt) {
		System.out.println("Le clic fonctionne bien");
	}
	
}
