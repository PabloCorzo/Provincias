package dominio;
import java.util.ArrayList;

public class Provincia {
    private int habitantes_provincia;
    ArrayList <Municipio> municipios = new ArrayList<>();
    
    public int contarHabitantesProvincia(){
        this.habitantes_provincia = 0;
        for(Municipio municipio : municipios){
            this.habitantes_provincia += municipio.contarHabitantesMunicipio();
        }
        return this.habitantes_provincia;
    }
}
