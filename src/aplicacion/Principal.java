package aplicacion;
import interfaz.Interfaz;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        String peticion;
        Scanner sc = new Scanner(System.in);
        Interfaz.help();
        do {
            Interfaz.prompt();
            peticion = Interfaz.leerPeticion(sc);
            System.out.println("Peticion: " + peticion);
            Interfaz.choiceMaker(peticion);
        }while(Interfaz.procesarPeticion(peticion));
        sc.close();
    }
}
