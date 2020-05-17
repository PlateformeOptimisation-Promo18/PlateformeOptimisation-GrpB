package main.model.generic;

 /**
 * Cette classe doit être utilisée pour réaliser le paramétrage des algorithmes.
  * Elle sert également à l'IHM, pour savoir quels sont les paramètres à demander à l'utilisateur.
 **/

public class Parameter {
    private Number value;
    private String name;

    public Parameter(String name){
        this.name = name;
    }

    public Parameter(Number value, String name) {
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
