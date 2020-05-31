package test.model.algorithmes.tabou;

import main.model.generic.InterfaceRandom;

public class MockRandom implements InterfaceRandom {

    private static int iNbCall = -1;
    private static int[] iTabInt = { 0, 1, 0, 1, 2, 0, 1, 1, 2, 2, 3, 3, 0 };

    @Override
    public int nextInt(int i) {
        iNbCall++;
        return iTabInt[iNbCall % iTabInt.length];
    }
}
