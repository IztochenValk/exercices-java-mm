
import com.cda.classe.Joueur;
import com.cda.classe.Partie;


public class Main {

    public static void main(String[] args) {
        Joueur j1 = new Joueur("Homer Simpson");
        Joueur j2 = new Joueur("Ned Flanders");

        Partie partie = new Partie(j1, j2, 5);
        partie.lancerPartie();

    }
}
