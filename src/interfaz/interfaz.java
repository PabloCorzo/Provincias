package interfaz;
import dominio.*;
import java.util.*;
import java.io.Serializable;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Interfaz implements Serializable
{
    //contactos y libreta.getcontactos() son diferentes
    public  ArrayList <Provincia> provincias= new ArrayList <>();
    public Interfaz(){
    ObjectInputStream obj;
    File file = new File("provincias.txt");
    try{
        obj = new ObjectInputStream(new FileInputStream(file));
        provincias = (ArrayList<Provincia>)obj.readObject();
        obj.close();
        System.out.println("leido");
    } catch(Exception e){
        System.out.println("no leido");
        provincias = new ArrayList<>();
    };
}

    public  ArrayList <Provincia> leer ()

    {
        Scanner sc = new Scanner (System.in);
        String nombre_provincia;
        boolean keepgoing_p = true;
        do
        {
            System.out.print ("Introduzca el nombre de la provincia(enter para finalizar): ");
            nombre_provincia =sc.nextLine(); 
            if(nombre_provincia.equalsIgnoreCase("")){System.out.println("Lectura terminada.");break;}
            if (nombre_provincia!="")
            {
                Provincia p = new Provincia(nombre_provincia);
                String nombre_localidad;
                String nombre_municipio;
                boolean keepgoing_m = true;
                do
                {
                    System.out.print ("Introduzca el nombre del municipio (enter para finalizar): ");
                    nombre_municipio =sc.nextLine();
                    if(nombre_municipio.equalsIgnoreCase("")){break;}
                    Municipio m =new Municipio(nombre_municipio);
                    p.addMunicipio (m); 
                    Localidad l;
                    boolean keepgoing_l = true;
                    do{
                        System.out.print ("Introduzca el nombre de la localidad  (enter para finalizar): ");
                        nombre_localidad =sc.nextLine();
                        if(nombre_localidad.equalsIgnoreCase("")){
                            break;
                        }
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

                    }while(keepgoing_l);
                    provincias.add(p);
                }while(keepgoing_m);
            }
        }
        while (keepgoing_p);
        return provincias;
        }
        public  void insertarProvincia(String peticion){
            String [] split = peticion.split(" ");
            String nombre_provincia = split[1];
            System.out.println(nombre_provincia);
            if(nombre_provincia != ""){
                Provincia p = new Provincia(nombre_provincia);
                provincias.add(p);
            }
            else{
                System.out.println("Nombre no insertado.");
            }
        }

        public  void insertarMunicipio(String peticion){
            String [] split = peticion.split(" ");
            String nombre_prov = split[1];
            String nombre_mun = split[2];
            Municipio m = new Municipio(nombre_mun);
            Provincia p2 = new Provincia("");
            for(Provincia p : provincias){
                if(p.getNombre().equalsIgnoreCase(nombre_prov)){
                     p2 = p;
                }
            }
            int indice = provincias.indexOf(p2);
            if(indice != -1){
                provincias.get(indice).addMunicipio(m);
            }
            else{
                System.out.println(split[2]);
                System.out.println("La provincia no existe");
            }
        }

        public  void insertarLocalidad(String peticion){
            String[] split = peticion.split(" ");
            String nombre_loc = split[2];
            String nombre_mun = split[1];
            String input_habitantes = split[3];
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
            boolean existe = false;
            for(Provincia p : provincias){
                for(Municipio n : p.getMunicipios()){
                    if(n.getNombre().equalsIgnoreCase(nombre_mun)){
                        existe = true;
                        m = n;
                    }
                }
            }
            if(existe){
                m.getLocalidades().add(l);
            }
            else{System.out.println("No se encontro el municipio.");}
        }
        public  void help(){
            System.out.println("Los metodos son:\n \"salir\" para salir \n \"input\" para lectura inicial de datos \n \"help\" para ayuda \n \"mostrar\" para mostrar localidades, municipios y provincias \n \"addlocalidad\" + municipio + nombre + habitantes \n  \"addmunicipio\" + provincia + nombre \n \"addprovincia\" + nombre ");
        }
        
        public  void mostrar(){   
            System.out.println("funciona");
            // System.out.println(provincias);
            for(Provincia p : provincias){
                System.out.println(p.toString());
                for(Municipio m : p.getMunicipios()){
                    System.out.println(m.toString());
                    for(Localidad l : m.getLocalidades()){
                        System.out.println(l.toString());
                    }
                }
            }
        }
        public  String leerPeticion(Scanner sc){
            String peticion = sc.nextLine();
            return peticion;
        }
        public  boolean procesarPeticion(String orden){
            String[] p = orden.split(" ");
            if(orden.equalsIgnoreCase("salir")){
                ObjectOutputStream obj;
                File file = new File("provincias.txt");
                try{
                    obj = new ObjectOutputStream(new FileOutputStream(file));
                    obj.writeObject(provincias);
                    obj.close();
                    System.out.println("Guardado");
                } catch(Exception e){
                System.out.println("Error al guardar");
                System.out.println(e);
                };

                return false;
            }
            else if(orden.equalsIgnoreCase("help")){
                ;
            }
            else if(orden.equalsIgnoreCase("mostrar")){
                ;
            }
            else if(p.length != 2 &&  orden.equalsIgnoreCase("salir") == false && orden.equalsIgnoreCase("help") == false  && orden.equalsIgnoreCase("mostrar")){
                System.out.println("Instruccion incorrecta");               
            }
            else if(orden.equalsIgnoreCase("addlocalidad")){
                ;
            }
            else if (orden.equalsIgnoreCase("addmunicipio")){
                ;
            }
            else if(orden.equalsIgnoreCase("addprovincia")){
                ;
            }
            return true;
        }
    public  void choiceMaker(String orden){
        String [] split = orden.split(" ");
        if(split[0].equalsIgnoreCase("input")){
            leer();
        }
        if(split[0].equalsIgnoreCase("mostrar")){
            mostrar();
        }
        if(split[0].equalsIgnoreCase("help")){
            help();
        }
        if(split[0].equalsIgnoreCase("addlocalidad")){
            insertarLocalidad(orden);
        }
        if(split[0].equalsIgnoreCase("addmunicipio")){
            insertarMunicipio(orden);
        }
        if(split[0].equalsIgnoreCase("addprovincia")){
            insertarProvincia(orden);
        }
    }
    public  void prompt(){
        System.out.println("Que desea hacer?");
    }
    }