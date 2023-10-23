package aplicacion;
import dominio.*;
public class Principal {
    public static void main(String[] args) {
        Localidad local1 = new Localidad("Valencia", 2);
        Localidad local2 = new Localidad("Castellon", 3);
        System.out.println(local1.toString());
        System.out.println(local2.toString());    
        Municipio madrid = new Municipio("Madrid");
        System.out.println(madrid.toString());
        Localidad local3 = new Localidad("Alicante", 9);
        madrid.addLocalidad(local3);
        System.out.println(madrid.toString());

    }
}
