package com.cda.classe;
import com.cda.classe.Joueur;

public class Partie {
    private Joueur j1;
    private Joueur j2;
    private int nbrTour;
    private int scoreJ1;
    private int scoreJ2;

    public Partie(Joueur j1, Joueur j2, int nbrTour) {
        this.j1 = j1;
        this.j2 = j2;
        this.nbrTour = nbrTour;
        this.scoreJ1 = 0;
        this.scoreJ2 = 0;
    }

    public Joueur getJ1() {
        return j1;
    }

    public void setJ1(Joueur j1) {
        this.j1 = j1;
    }

    public Joueur getJ2() {
        return j2;
    }

    public void setJ2(Joueur j2) {
        this.j2 = j2;
    }

    public int getNbrTour() {
        return nbrTour;
    }

    public void setNbrTour(int nbrTour) {
        this.nbrTour = nbrTour;
    }

    public int getScoreJ1() {
        return scoreJ1;
    }

    public void setScoreJ1(int scoreJ1) {
        this.scoreJ1 = scoreJ1;
    }

    public int getScoreJ2() {
        return scoreJ2;
    }

    public void setScoreJ2(int scoreJ2) {
        this.scoreJ2 = scoreJ2;
    }

    public void lancerPartie() {
        for (int i = 0; i < this.nbrTour; i++) {
            j1.lancerDes();
            j2.lancerDes();

            if (j1.getValeurLance() > j2.getValeurLance()) {
                scoreJ1 += 2;
            } else if (j1.getValeurLance() < j2.getValeurLance()) {
                scoreJ2 += 2;
            } else {
                scoreJ1 += 1;
                scoreJ2 += 1;
            }
        }

        if (scoreJ1 > scoreJ2) {
            System.out.println("Le gagnant est : " + j1.getNom() + " avec : " + scoreJ1 + " pts");
        } else if (scoreJ1 < scoreJ2) {
            System.out.println("Le gagnant est : " + j2.getNom() + " avec : " + scoreJ2 + " pts");
        } else {
            System.out.println("Egalité des 2 joueurs avec : " + scoreJ2 + " pts");
        }

        scoreJ1 = 0;
        scoreJ2 = 0;
    }
}
