package dominio;
import java.util.ArrayList;

public class Municipio {
    private int habitantes_municipio;
    private String nombre_municipio;
    static ArrayList <Localidad> localidades = new ArrayList<>();
    public int contarHabitantesMunicipio(){
        this.habitantes_municipio = 0;
        for(Localidad localidad : localidades ){
            this.habitantes_municipio += localidad.getHabitantes_localidad();
        }
        return this.habitantes_municipio;
    }
    public String getNombre(){
        return this.nombre_municipio;
    }
    public void addLocalidad(Localidad local){
        localidades.add(local);
    }
    public String toString(){
        String result = "El municipio de " + this.nombre_municipio + " esta compuesto por: ";
        for(Localidad localidad : localidades) {
            result += (localidad.getNombre());
            if(localidades.indexOf(localidad) == localidades.size()-2){
                result += " y ";
            }
            else if(localidades.indexOf(localidad) == localidades.size()-1){
                ;
            }
            else{result += (", ");}
        } 
        result += " y tiene " + this.contarHabitantesMunicipio() + " habitantes";
        return result;
    } 
    public Municipio(String nombre, Localidad loc1,Localidad loc2){
        this.nombre_municipio = nombre;
        localidades.add(loc1);
        localidades.add(loc2);
        this.habitantes_municipio = contarHabitantesMunicipio();
    }
}