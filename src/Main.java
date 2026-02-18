import com.cda.classe.Vehicule;

import java.util.ArrayList;



public class Main {


    public static void main(String[] args) {

        ArrayList<Vehicule> motos = new ArrayList<Vehicule>();
        ArrayList<Vehicule> voitures = new ArrayList<Vehicule>();

        Vehicule moto1 = new Vehicule("Honda CBX400F", 2, 190);
        Vehicule moto2 = new Vehicule("Kawasaki Z400FX", 2, 178);
        Vehicule moto3 = new Vehicule("Yamaha XJ400", 2, 192);
        Vehicule moto4 = new Vehicule("Suzuki GSX400F", 2, 189);

        motos.add(moto1);
        motos.add(moto2);
        motos.add(moto3);
        motos.add(moto4);

        Vehicule voiture1 = new Vehicule("Toyota Supra MK4", 4, 310);
        Vehicule voiture2 = new Vehicule("Mazda RX-7", 4, 298);
        Vehicule voiture3 = new Vehicule("Nissan Skyline GT-R", 4, 282);
        Vehicule voiture4 = new Vehicule("Toyota AE86 Trueno", 4, 279);

        voitures.add(voiture1);
        voitures.add(voiture2);
        voitures.add(voiture3);
        voitures.add(voiture4);

        for(Vehicule moto: motos){
            System.out.print("Le véhicule :" + moto.getNom() + " est de type" + moto.detect());
        }
        for(Vehicule voiture: voitures){
            System.out.print("Le véhicule :" + voiture.getNom() + " est de type" + voiture.detect());
        }
        for(Vehicule moto: motos){
            moto.boost();
            System.out.print("Le véhicule :" + moto.getNom() + " a désormais une vitesse de " + moto.getVitesse());
        }
        for(Vehicule voiture: voitures){
            voiture.boost();
            System.out.print("Le véhicule :" + voiture.getNom() + " a désormais une vitesse de " + voiture.getVitesse());
        }

        System.out.println(moto1.plusRapide(voiture3));
    }
}
