package interfaz;
import dominio.*;
import java.util.*;

public class Interfaz 
{
    static ArrayList <Provincia> provincias= new ArrayList <>();
    public static ArrayList <Provincia> leer ()
    {
        Scanner sc = new Scanner (System.in);
        String nombre_provincia;
        do
        {
            System.out.print ("Introduzca el nombre de la provincia(enter para finalizar): ");
            nombre_provincia =sc.nextLine(); 
            if (nombre_provincia!="")
            {
                Provincia p = new Provincia(nombre_provincia);
                String nombre_localidad;
                String nombre_municipio;
                do
                {
                    System.out.print ("Introduzca el nombre del municipio (enter para finalizar): ");
                    nombre_municipio =sc.nextLine(); 
                    Municipio m =new Municipio(nombre_municipio);
                    p.addMunicipio (m); 
                    Localidad l;
                    do{
                        System.out.print ("Introduzca el nombre de la localidad  (enter para finalizar): ");
                        nombre_localidad =sc.nextLine();
                        System.out.println("Introduzca el numero de habitantes");
                        String input_habitantes = sc.nextLine();
                        int num_habitantes = 0;
                        if(input_habitantes != ""){
                            try {
                                num_habitantes = Integer.parseInt(input_habitantes);
                            } catch (Exception e) {
                                System.out.println("Valor introducido incorrecto");
                            }
                        }
                        l = new Localidad(nombre_localidad,num_habitantes);
                        m.addLocalidad(l);

                    }while(nombre_localidad != "");
                    provincias.add(p);
                }while(nombre_municipio != "");
            }//if (nombre_provincias!="")
        }
        while (nombre_provincia!="");
        sc.close();
        return provincias;
        }
        public static void insertarProvincia(){
            Scanner sc = new Scanner(System.in);
            System.out.println("Defina el nombre de la provincia: ");
            String nombre_provincia = sc.nextLine();
            if(nombre_provincia != ""){
                Provincia p = new Provincia(nombre_provincia);
                provincias.add(p);
            }
            else{
                System.out.println("Nombre no insertado.");
            }
            sc.close();
        }

        public static void insertarMunicipio(){
            Scanner sc  = new Scanner(System.in);
            System.out.println("A que provincia pertenece el municipio?");
            String nombre_prov = sc.nextLine();
            System.out.println("Nombre del municipio: ");
            String nombre_mun = sc.nextLine();
            Municipio m = new Municipio(nombre_mun);
            Provincia p = new Provincia(nombre_prov);
            int indice = provincias.indexOf(p);
            if(indice != -1){
                provincias.get(indice).addMunicipio(m);
            }
            else{
                System.out.println("La provincia no existe");
            }
            sc.close();
        }

        public static void insertarLocalidad(){
            Scanner sc = new Scanner(System.in);
            System.out.println("a que municipio quiere introducir la localidad? ");
            String nombre_loc = sc.nextLine();
            System.out.println("Nombre de la localidad: ");
            String nombre_mun = sc.nextLine();
            System.out.println("Numero de habitantes: ");
            String input_habitantes = sc.nextLine();
                int num_habitantes = 0;
                if(input_habitantes != ""){
                    try {
                        num_habitantes = Integer.parseInt(input_habitantes);
                    } catch (Exception e) {
                        System.out.println("Valor introducido incorrecto");
                    }
                }
            Localidad l = new Localidad(nombre_loc,num_habitantes);
            Municipio m = new Municipio(nombre_mun);
            for(Provincia p : provincias){
                for(Municipio m : p.)
            }
            sc.close();
        }
    }