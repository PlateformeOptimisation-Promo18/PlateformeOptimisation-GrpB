package main.utils;

import main.model.generic.InterfaceRandom;

/**
 * @author Robin LECORVAISIER
 *
 * Classe permetant de simuler un tirage aléatoire de int ou de double.
 * les methodes retourne un int ou un double suivant un ordre prédefini.
 * cet ordre peut être modifié.
 */
public class TestRandom implements InterfaceRandom {

    private double[] doubles = {0.1,0.2,0.3,0.4,0.5};
    private int[] ints = {1,2,3,4,5};

    private int countDouble = 0;
    private int countInt = 0;

    /**
     * définie la suite de double que nextDouble va retourner
     * @param doubles tableau de la suite de double
     */
    public void setDoubles(double[] doubles) {
        this.doubles = doubles;
    }

    /**
     * définie la suite de int que nextInt va retourner
     * @param ints tableau de la suite de int
     */
    public void setInts(int[] ints) {
        this.ints = ints;
    }

    /**
     * tirage du prochain int de la suite définie
     * @param i valeur max du int retournée (imposé par l'interface, n'est pas utilisé)
     * @return un le prochain int de la suite
     */
    @Override
    public int nextInt(int i) {
        int nextInt = ints[countInt];
        countInt++;

        if(countInt >= ints.length){
            countInt = 0;
        }
        return nextInt;
    }

    /**
     * tirage du prochain double de la suite définie
     * @return le prochain double de la suite définie
     */
    @Override
    public double nextDouble() {
        double nextDouble = doubles[countDouble];
        countDouble++;

        if(countDouble >= doubles.length){
            countDouble = 0;
        }
        return nextDouble;
    }
}
