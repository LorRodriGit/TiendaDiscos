package modelo;

public class Usuarios {
	private int codigo;
	private String nombre,funcion;
	public Usuarios(int codigo, String nombre, String funcion) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.funcion = funcion;
	}
	public int getCodigo() {
		return codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public String getFuncion() {
		return funcion;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setFuncion(String funcion) {
		this.funcion = funcion;
	}
	
}
