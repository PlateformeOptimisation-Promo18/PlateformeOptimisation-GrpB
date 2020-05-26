package main.application;

import javafx.fxml.FXML;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import main.model.generic.CombinatorialMultiObjectiveOptimizationAlgorithm;
import main.model.generic.InterfaceRandom;

public class Controller {
	
	@FXML
	private BorderPane paneCentral;
	
	@FXML
	private void initialize() {
		ControllerSimulation customControl = new ControllerSimulation();
		Pane view = customControl.getPaneControllerSimulation();
		paneCentral.setCenter(view);
	}
	
}
