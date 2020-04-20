package model.generic;

public class Parametre {
    private Number value;
    private String name;

    public Parametre(Number value, String name) {
        this.value = value;
        this.name = name;
    }

    public Number getValue() {
        return value;
    }
    public String getName() {
        return name;
    }

    public void setValue(Number value) {
        this.value = value;
    }

}
