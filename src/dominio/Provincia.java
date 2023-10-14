package dominio;
import java.util.ArrayList;

public class Provincia {
    private int habitantes_provincia;
    private String nombre_provincia;
    static ArrayList <Municipio> municipios = new ArrayList<>();
    
    public int contarHabitantesProvincia(){
        this.habitantes_provincia = 0;
        for(Municipio municipio : municipios){
            this.habitantes_provincia += municipio.contarHabitantesMunicipio();
        }
        return this.habitantes_provincia;
    }
    public String toString(){
        String result = "El municipio de " + this.nombre_provincia + " esta compuesto por: ";
        for(Municipio municipio: municipios) {
            result += (municipio.getNombre());
            result += (", ");
        } 
        result += " y tiene " + this.contarHabitantesProvincia() + " habitantes";
        return result;
    } 
    public Provincia(String nombre, Municipio mun1, Municipio mun2){
        this.nombre_provincia = nombre;
        municipios.add(mun1);
        municipios.add(mun2);
        this.habitantes_provincia = contarHabitantesProvincia();
    }
    public static void main(String[] args) {
    }
}

