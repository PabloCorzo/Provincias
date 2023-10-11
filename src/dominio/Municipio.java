package dominio;
import java.util.ArrayList;

public class Municipio {
    private int habitantes_municipio;
    ArrayList <Localidad> localidades = new ArrayList<>();
    public int contarHabitantesMunicipio(){
        this.habitantes_municipio = 0;
        for(Localidad localidad : localidades ){
            this.habitantes_municipio += localidad.getHabitantes_localidad();
        }
        return this.habitantes_municipio;
    }
    public String toString(){
        ArrayList <String> nombres_localidades = new ArrayList<>();
        for(String nombre : nombres_localidades){
            nombres_localidades.add(nombre);
            System.out.println(nombre);
        }
    } 
}