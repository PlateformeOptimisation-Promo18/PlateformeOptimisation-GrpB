package main.application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.ScatterChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import main.model.generic.StopRequired;

public class ControllerSimulation extends BorderPane {
	private Pane view;
	StopRequired arretUtilisateur = new StopRequired();
	
	private int nbGraph;
	
	@FXML
	private ToggleGroup groupNb;
	
	@FXML
	private ToggleGroup groupType;
	
	@FXML
	private RadioButton button1;
	@FXML
	private RadioButton button2;
	
	@FXML
	private VBox radioButtonGroupNb;
	
	@FXML
	private VBox radioButtonGroupType;
	
	@FXML
	private BorderPane borderPaneMain;
	
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
	private void initialize() {
		nbGraph = 1;
		
		// Group
		ToggleGroup groupNb = new ToggleGroup();
		
		RadioButton button1 = new RadioButton("Un graph");
		button1.setUserData(1);
		button1.setToggleGroup(groupNb);
		button1.setSelected(true);
		
		RadioButton button2 = new RadioButton("Deux graph");
		button2.setUserData(2);
		button2.setToggleGroup(groupNb);
		
		groupNb.selectedToggleProperty().addListener((obserableValue, old_toggle, new_toggle) -> {
		    if (groupNb.getSelectedToggle() != null) {
		    	System.out.println(groupNb.getSelectedToggle().getUserData().toString());
		    	nbGraph = (int) groupNb.getSelectedToggle().getUserData();
		    	afficherGraph();
		    }
		});
		
		radioButtonGroupNb.getChildren().add(button1);
		radioButtonGroupNb.getChildren().add(button2);
		
		afficherGraph();
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
	
	private void afficherGraph() {
		HBox hbox = new HBox();
		
		
		final NumberAxis xAxisGraph1 = new NumberAxis(0, 10, 1);
		final NumberAxis yAxisGraph1 = new NumberAxis(0, 500, 100);
		
		final ScatterChart<Number,Number> scGraph1 = new ScatterChart<Number,Number>(xAxisGraph1,yAxisGraph1);
		xAxisGraph1.setLabel("Coût");
		yAxisGraph1.setLabel("Durée");
		scGraph1.setTitle("Graphique 1");
		
		XYChart.Series series1 = new XYChart.Series();
		series1.setName("Solutions");
		series1.getData().add(new XYChart.Data(4.2, 193.2));
		series1.getData().add(new XYChart.Data(2.8, 33.6));
		series1.getData().add(new XYChart.Data(6.2, 24.8));
		series1.getData().add(new XYChart.Data(1, 14));
		series1.getData().add(new XYChart.Data(1.2, 26.4));
		series1.getData().add(new XYChart.Data(4.4, 114.4));
		series1.getData().add(new XYChart.Data(8.5, 323));
		series1.getData().add(new XYChart.Data(6.9, 289.8));
		series1.getData().add(new XYChart.Data(9.9, 287.1));
		series1.getData().add(new XYChart.Data(0.9, 10));
		series1.getData().add(new XYChart.Data(3.2, 150.8));
		series1.getData().add(new XYChart.Data(4.8, 20.8));
		series1.getData().add(new XYChart.Data(7.3, 42.3));
		series1.getData().add(new XYChart.Data(1.8, 81.4));
		series1.getData().add(new XYChart.Data(7.3, 110.3));
		series1.getData().add(new XYChart.Data(2.7, 41.2));
		
		scGraph1.getData().addAll(series1);
		hbox.getChildren().add(scGraph1);
		
		if (nbGraph == 2) {
			final NumberAxis xAxisGraph2 = new NumberAxis(0, 10, 1);
			final NumberAxis yAxisGraph2 = new NumberAxis(0, 500, 100);
			
			final ScatterChart<Number,Number> scGraph2 = new ScatterChart<Number,Number>(xAxisGraph2,yAxisGraph2);
			scGraph2.setTitle("Graphique 2");
			xAxisGraph2.setLabel("Coût");
			yAxisGraph2.setLabel("Durée");
			
			XYChart.Series series2 = new XYChart.Series();
			series2.setName("Solutions");
			series2.getData().add(new XYChart.Data(4.2, 193.2));
			series2.getData().add(new XYChart.Data(2.8, 33.6));
			series2.getData().add(new XYChart.Data(6.2, 24.8));
			series2.getData().add(new XYChart.Data(1, 14));
			series2.getData().add(new XYChart.Data(1.2, 26.4));
			series2.getData().add(new XYChart.Data(4.4, 114.4));
			series2.getData().add(new XYChart.Data(8.5, 323));
			series2.getData().add(new XYChart.Data(6.9, 289.8));
			series2.getData().add(new XYChart.Data(9.9, 287.1));
			series2.getData().add(new XYChart.Data(0.9, 10));
			series2.getData().add(new XYChart.Data(3.2, 150.8));
			series2.getData().add(new XYChart.Data(4.8, 20.8));
			series2.getData().add(new XYChart.Data(7.3, 42.3));
			series2.getData().add(new XYChart.Data(1.8, 81.4));
			series2.getData().add(new XYChart.Data(7.3, 110.3));
			series2.getData().add(new XYChart.Data(2.7, 41.2));
			
			scGraph2.getData().addAll(series2);
			
			hbox.getChildren().add(scGraph2);
		}
		
		
		borderPaneMain.setCenter(hbox);
	}
}
