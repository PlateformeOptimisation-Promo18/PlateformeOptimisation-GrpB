package main.model.algorithmes.spea2;

import main.model.algorithmes.Algorithme;
import main.model.generic.Parametre;
import main.model.problemes.Problem;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class SPEA2 extends Algorithme {

    private int taillePopulation;
    private int tailleArchive;
    private float probaMutation;
    private float probaMutationDesGenes;
    private float probaCroisement;
    private int nombreGeneration;
    private ArrayList<ArrayList<Integer>> listeDesPossibilite;

    @Override
    public void lancer(Problem probleme) {

    }

    @Override
    public List<Parametre> obtenirParametres() {
        return null;
    }

    @Override
    public List<Parametre> obtenirParametresParDefaut() {
        return null;
    }

    @Override
    public void parametrer(List<Parametre> saisieUtilisateur) {

    }

    @Override
    public void update(Observable observable, Object o) {

    }
}
