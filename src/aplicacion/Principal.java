package aplicacion;
import interfaz.Interfaz;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        String peticion;
        Interfaz i = new Interfaz();
        Scanner sc = new Scanner(System.in);
        i.help();
        do {
            i.prompt();
            peticion = i.leerPeticion(sc);
            System.out.println("Peticion: " + peticion);
            i.choiceMaker(peticion);
        }while(i.procesarPeticion(peticion));
        sc.close();
    }
}
