package main.model.visualisations;

import javafx.scene.chart.Chart;
import main.model.algorithmes.Algorithme;
import main.model.problemes.TypeDeProbleme;
import main.model.generic.Solution;

import java.util.HashMap;
import java.util.List;

public abstract class Visualisation {
    private HashMap<Algorithme, TypeDeProbleme> visualisationCompatible; //Permet de savoir quels couples Algorithme/Problème peuvent accéder à cette visualisation.
    private Chart graph;
    private List<Solution> listeDeSolutions;

    abstract public void visualiser();
    abstract public void definirEchelle(int x, int y);
    abstract public void mettreAJour();
    abstract public int[] obtenirParametresParDefaut();
}
