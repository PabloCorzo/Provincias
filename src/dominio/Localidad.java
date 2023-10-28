package dominio;
import java.io.Serializable;

public class Localidad implements Serializable{
	private String nombre;
	private int habitantes_localidad;
	public Localidad(String nombre,int habitantes_localidad){
		this.nombre = nombre;
		this.habitantes_localidad = habitantes_localidad;
	}
	public void setNombre(String nombre){
		this.nombre = nombre;
	}
	public void setHabitantes_localidad(int habitantes_localidad){
		this.habitantes_localidad = habitantes_localidad;
	}
	public String getNombre(){
		return this.nombre;
	}
	public int getHabitantes_localidad(){
		return this.habitantes_localidad;
	}
	public String toString(){
		String result =  ("La localidad " + this.nombre + " tiene " + this.habitantes_localidad + " habitantes");
		return result;
	}
}
