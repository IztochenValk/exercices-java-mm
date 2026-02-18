package com.cda.classe;
import com.cda.classe.Des;

public class Joueur {
    private String nom;
    private int valeurLance;
    private Des des;

    public Joueur(String nom) {
        this(nom, new Des(6));
    }

    public Joueur(String nom, Des des) {
        this.nom = nom;
        this.des = des;
        this.valeurLance = 0;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getValeurLance() {
        return valeurLance;
    }

    public void setValeurLance(int valeurLance) {
        this.valeurLance = valeurLance;
    }

    public Des getDes() {
        return des;
    }

    public void setDes(Des des) {
        this.des = des;
    }

    public void lancerDes() {
        this.des.lancer();
        this.valeurLance = this.des.getScore();
    }
}
