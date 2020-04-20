package model.generic;

 /**
 * Cette classe doit être utilisée pour réaliser le paramétrage des algorithmes.
  * Elle sert également à l'IHM, pour savoir quels sont les paramètres à demander à l'utilisateur.
 */

public class Parametre {
    private Number value;
    private String name;

    public Parametre(String name){
        this.name = name;
    }

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
