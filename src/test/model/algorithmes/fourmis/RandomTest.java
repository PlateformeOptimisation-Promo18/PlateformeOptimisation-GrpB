package test.model.algorithmes.fourmis;

import main.model.generic.InterfaceRandom;

public class RandomTest implements InterfaceRandom {
    int size = 5;

    public RandomTest(int size) {
        this.size = size;
    }

    @Override
    public int nextInt(int i) {
        return 0;
    }

    @Override
    public double nextDouble() {
        return 0;
    }
}
