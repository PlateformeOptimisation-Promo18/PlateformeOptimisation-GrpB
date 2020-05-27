package main.utils;

import main.model.generic.InterfaceRandom;

public class testRandom implements InterfaceRandom {

    private double[] doubles = {0.1,0.2,0.3,0.4,0.5};
    private int[] ints = {1,2,3,4,5};

    private int countDouble = 0;
    private int countInt = 0;

    public void setDoubles(double[] doubles) {
        this.doubles = doubles;
    }

    public void setInts(int[] ints) {
        this.ints = ints;
    }

    @Override
    public int nextInt(int i) {
        int nextInt = ints[countInt];
        countInt++;

        if(countInt >= ints.length){
            countInt = 0;
        }
        return nextInt;
    }

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
