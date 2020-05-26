package main.model.generic;

/**
 * Cette classe doit Ãªtre utilisée pour rÃ©aliser le paramÃ©trage des algorithmes.
 * Elle sert également Ã  l'IHM, pour savoir quels sont les paramÃ¨tres Ã  demander Ã  l'utilisateur.
 * un paramètre est une valeur numérique (classe Number) et un label (string) pour l'affichage
 * @author p.pitiot
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
