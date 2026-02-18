package com.cda.classe;
import com.cda.classe.Des;


public class Gobelet {
    private final Des d1;
    private final Des d2;
    private final Des d3;
    private int total;

    public Gobelet() {
        this(new Des(6), new Des(6), new Des(6));
    }

    public Gobelet(Des d1, Des d2, Des d3) {
        this.d1 = d1;
        this.d2 = d2;
        this.d3 = d3;
        this.total = 0;
    }

    public int getTotal() {
        return total;
    }

    public int lancerEtSommer() {
        d1.lancer();
        d2.lancer();
        d3.lancer();
        total = d1.getScore() + d2.getScore() + d3.getScore();
        return total;
    }
}
