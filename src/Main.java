
import com.cda.classe.CompteBancaire;
import java.util.ArrayList;
import java.util.List;


public class Main {

         public static void main(String[] args) throws Exception {

            CompteBancaire alex = new CompteBancaire("Alex", 1000);
            CompteBancaire clovis = new CompteBancaire("Clovis", 1000);
            CompteBancaire marco = new CompteBancaire("Marco", 1000);

            List<CompteBancaire> comptes = new ArrayList<>();
            comptes.add(alex);
            comptes.add(clovis);
            comptes.add(marco);

            alex.retirer(100);
            System.out.println();

            marco.transferer(clovis, 300);
            System.out.println();

            try {
                alex.retirer(1200);
            } catch (Exception e) {
                System.out.println("Erreur : " + e.getMessage());
            }

            System.out.println();
            System.out.println("Soldes finaux :");
            for (CompteBancaire compte : comptes) {
                System.out.println(compte.getNom() + " : " + compte.getSolde() + " €");
            }

    }


}
