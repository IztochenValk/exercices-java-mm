package com.cda.classe;
import java.util.concurrent.ThreadLocalRandom;

public class Des {
    private int nbrFace;
    private int score;

    public Des() {
        this(6);
    }

    public Des(int nbrFace) {
        this.nbrFace = nbrFace;
        this.score = 0;
    }

    public int getNbrFace() {
        return nbrFace;
    }

    public void setNbrFace(int nbrFace) {
        this.nbrFace = nbrFace;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void lancer() {
        this.score = ThreadLocalRandom.current().nextInt(1, this.nbrFace + 1);
    }
}
