package main.model.generic;

import java.util.Observable;

public class StopRequis extends Observable {
    private boolean stop;

    public void setStopRequired(){
        setStop(true);
        notifyObservers();
    }

    public void setStop(boolean stop) {
        this.stop = stop;
    }

    public boolean isStop() {
        return stop;
    }
}
