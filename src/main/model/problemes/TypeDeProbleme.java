package main.model.problemes;

import main.model.algorithmes.Algorithme;

import java.util.List;

/**
 * Dans notre cas nous n'avons qu'un type de problème, mais cette classe sert à généraliser les problèmes.
 */

public abstract class TypeDeProbleme {
    private String nom;
    private List<Algorithme> algoCompatibles; //Permet de savoir quels algorithmes on peut lancer avec ce type de problème.
}
