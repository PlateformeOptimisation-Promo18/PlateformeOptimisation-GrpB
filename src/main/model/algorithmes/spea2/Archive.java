package main.model.algorithmes.spea2;

/*
 @autor : Simon Marquès
 @create : 09/05/2020
 @update : 31/05/2020
 @version : 1.0
*/

public class Archive extends Population {

    public Archive(int isArchiveSize){

        this.taille = isArchiveSize;
    }

    public void updateArchive(Population population, int iArchiveSize, Problem pb) {

    }

    private List<Individual> getSet(){

        return set;
    }

    private void miseAjourDistancePop(Problem pb, Population populationTemp) {
        set.add(populationTemp);
    }

    public void enleveDoublons(){
        int compteur;
        int i;
        for(compteur=0;compteur<set.size();compteur++){
            elementList = set.get(compteur);
            for(i=0;i<set.size();i++){
                if( elementList == set.get(+1)){
                    set.remove(i);
                }
            }
            i=0;
        }
    }

    public void selection(Population population, InterfaceRandom generator, int iPopSize, int iNumkVoisin) {
        int compteur;
        for(compteur=0;compteur<taille;compteur++){
            if(this == null){
                this = population;
            }

        }
    }

    public Population selectionParents(int nombreParent){
        Population popParents = new Population(nombreParent);
        int compteur;
        for(int compteur = 0 ; compteur < this.getIndividualSet().size() ; compteur++) {
            populationParent.add(this.getIndividual(i));
        }
        return populationParent;
    }

    public void SelectionArchive(Population population){
        for(int i = 0 ; i < this.set.size() ; i ++) {
            if(this.set.isEmpty()) {
                this.set.set(i, population.getIndividual(i));
            }

        }
    }
}
