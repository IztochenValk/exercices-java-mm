package com.cda.classe;

public class Vehicule {
    private String nom;
    private int nbRoue;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getNbRoue() {
        return nbRoue;
    }

    public void setNbRoue(int nbRoue) {
        this.nbRoue = nbRoue;
    }

    public int getVitesse() {
        return vitesse;
    }

    public void setVitesse(int vitesse) {
        this.vitesse = vitesse;
    }

    private int vitesse;

    public Vehicule() {
    }
    public Vehicule(String nom, int nbRoue, int vitesse) {
        this.nom = nom;
        this.nbRoue = nbRoue;
        this.vitesse = vitesse;
    }

    public void boost(){
        this.vitesse += 50;
    }

    public String detect(){
        if(this.nbRoue == 4){
            return "voiture";
        }
        else if (this.nbRoue == 2){
            return "moto";
        }
        else{
            return "autre";
        }
    }

    public String plusRapide(Vehicule targetVehicule){
        Vehicule faster = this.getVitesse() > targetVehicule.getVitesse()? this : targetVehicule;
        return "Le véhicule le plus rapide est: " + faster.getNom() + " avec une vitesse de pointe de " + faster.getVitesse();
    }

}
