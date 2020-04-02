package model.algorithmes.spea2;

import model.algorithmes.Algorithme;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SPEA2 extends Algorithme {

    private int taillePopulation;
    private int tailleArchive;
    private float probaMutation;
    private float probaMutationDesGenes;
    private float probaCroisement;
    private int nombreGeneration;
    private ArrayList<ArrayList<Integer>> listeDesPossibilite;












    @Override
    public void lancer() {

    }

    @Override
    public List<String> obtenirParametres() {
        return null;
    }

    @Override
    public HashMap<String, String> obtenirParametresParDefaut() {
        return null;
    }

    @Override
    public void parametrer(HashMap<String, String> saisiUtilisateur) {

    }

    @Override
    public void arreter() {

    }
}
