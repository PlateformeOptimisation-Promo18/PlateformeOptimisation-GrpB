package model.visualisations;

import javafx.scene.chart.Chart;
import model.generic.Solution;
import model.algorithmes.Algorithme;
import model.problemes.TypeDeProbleme;

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
