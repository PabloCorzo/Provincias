package aplicacion;
import dominio.*;
public class Principal {
    public static void main(String[] args) {
        Localidad local1 = new Localidad("Orcasitas", 2);
        Localidad local2 = new Localidad("Vallecas", 3);
        Municipio madrid = new Municipio("Madrid", local1,local2);
        System.out.println(local1.toString());
        System.out.println(local2.toString());    
        System.out.println(madrid.toString());
    }
}
