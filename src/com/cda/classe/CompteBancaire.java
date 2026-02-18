package com.cda.classe;

import java.util.UUID;

public class CompteBancaire {
    private String nom;
    private double solde;
    private String numeroCompte;

    public CompteBancaire(String nom, double solde) throws Exception {
        this.nom = nom;
        this.solde = solde;
        this.numeroCompte = UUID.randomUUID().toString();
    }

    public String getNom() {
        return nom;
    }

    public double getSolde() {
        return solde;
    }

    public String getNumeroCompte() {
        return numeroCompte;
    }

    public void deposer(double montant) throws Exception {
        if (montant <= 0) {
            throw new Exception("Montant invalide : " + montant + " € (négatif ou zéro)");
        }
        solde += montant;
        System.out.println("Titulaire : " + nom + " a déposé " + montant + " €");
        System.out.println("Nouveau solde : " + solde + " €");
    }

    public void retirer(double montant) throws Exception {
        if (montant <= 0) {
            throw new Exception("Montant de retrait invalide : " + montant + " € (négatif ou zéro)");
        }
        if (solde - montant < 0) {
            throw new Exception("Retrait refusé : " + montant + " € (solde insuffisant : " + solde + " €)");
        }
        solde -= montant;
        System.out.println("Titulaire : " + nom + " a retiré " + montant + " €");
        System.out.println("Nouveau solde : " + solde + " €");
    }

    public void transferer(CompteBancaire destinataire, double montant) throws Exception {
        if (destinataire == null) {
            throw new Exception("Destinataire invalide (null)");
        }
        if (montant <= 0) {
            throw new Exception("Montant de virement invalide : " + montant + " € (négatif ou zéro)");
        }

        System.out.println("Virement de : " + this.nom + " à : " + destinataire.nom + " de : " + montant + " €");

        this.retirer(montant);
        destinataire.deposer(montant);
    }

    public void afficherEtat() {
        System.out.println("Compte : " + numeroCompte);
        System.out.println("Titulaire : " + nom);
        System.out.println("Solde : " + solde + " €");
    }
}
