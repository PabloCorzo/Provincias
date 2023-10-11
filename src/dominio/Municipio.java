package dominio;
public class Municipio {
    private int habitantes_municipio;
    private Localidad local1, local2:
    public Municipio( Localidad local1 ,Localidad local2){
        this.local1 = local1;
        this.local2 = local2;
        this.habitantes_municipio = local1.getHabitantes_localidad() + local2.getHabitantes_localidad();
    }

}