package dominio;
import java.io.Serializable;
import java.util.ArrayList;

public class Provincia implements Serializable{
    private int habitantes_provincia;
    private String nombre_provincia;
    ArrayList <Municipio> municipios = new ArrayList<>();
    
    public int contarHabitantesProvincia(){
        this.habitantes_provincia = 0;
        for(Municipio municipio : municipios){
            this.habitantes_provincia += municipio.contarHabitantesMunicipio();
        }
        return this.habitantes_provincia;
    }
    public void addMunicipio(Municipio mun){
        municipios.add(mun);
    }
    public String toString(){
        String result = "La provincia de " + this.nombre_provincia + " esta compuesto por: ";
        for(Municipio municipio: municipios) {
            result += (municipio.getNombre());
            if(municipios.indexOf(municipio) == municipios.size() - 2){
                result += "y";
            }
            else if(municipios.indexOf(municipio) == municipios.size() - 1){
                ;
            }
            else{result += (", ");}
        } 
        result += " y tiene " + this.contarHabitantesProvincia() + " habitantes";
        return result;
    } 

    public ArrayList <Municipio> getMunicipios(){
        return this.municipios;
    }
    
    public Provincia(String nombre){
        this.nombre_provincia = nombre;
        this.habitantes_provincia = contarHabitantesProvincia();
    }
    
    public String getNombre(){
        return this.nombre_provincia;
    }
}

