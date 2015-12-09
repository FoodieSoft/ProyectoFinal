package Dominio;

public class Receta {
	private String nombre;
	private int tipo;
	private double cantidad1;
	private double cantidad2;
	private double cantidad3;
	private double cantidad4;
	private double cantidad5;
	private double cantidad6;
	private String ingrediente1;
	private String ingrediente2;
	private String ingrediente3;
	private String ingrediente4;
	private String ingrediente5;
	private String ingrediente6;
	private String descripcion;

	public Receta(String nombre, int tipo, double cantidad1, double cantidad2, double cantidad3, double cantidad4,
			double cantidad5, double cantidad6, String ingrediente1, String ingrediente2, String ingrediente3,
			String ingrediente4, String ingrediente5, String ingrediente6, String descripcion) {

		this.nombre = nombre;
		this.tipo = tipo;
		this.cantidad1 = cantidad1;
		this.cantidad2 = cantidad2;
		this.cantidad3 = cantidad3;
		this.cantidad4 = cantidad4;
		this.cantidad5 = cantidad5;
		this.cantidad6 = cantidad6;
		this.ingrediente1 = ingrediente1;
		this.ingrediente2 = ingrediente2;
		this.ingrediente3 = ingrediente3;
		this.ingrediente4 = ingrediente4;
		this.ingrediente5 = ingrediente5;
		this.ingrediente6 = ingrediente6;
		this.descripcion = descripcion;
	}

	public Receta() {

		this.nombre = null;
		this.tipo = 0;
		this.cantidad1 = 0;
		this.cantidad2 = 0;
		this.cantidad3 = 0;
		this.cantidad4 = 0;
		this.cantidad5 = 0;
		this.cantidad6 = 0;
		this.ingrediente1 = null;
		this.ingrediente2 = null;
		this.ingrediente3 = null;
		this.ingrediente4 = null;
		this.ingrediente5 = null;
		this.ingrediente6 = null;
		this.descripcion = null;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public double getCantidad1() {
		return cantidad1;
	}

	public void setCantidad1(double cantidad1) {
		this.cantidad1 = cantidad1;
	}

	public double getCantidad2() {
		return cantidad2;
	}

	public void setCantidad2(double cantidad2) {
		this.cantidad2 = cantidad2;
	}

	public double getCantidad3() {
		return cantidad3;
	}

	public void setCantidad3(double cantidad3) {
		this.cantidad3 = cantidad3;
	}

	public double getCantidad4() {
		return cantidad4;
	}

	public void setCantidad4(double cantidad4) {
		this.cantidad4 = cantidad4;
	}

	public double getCantidad5() {
		return cantidad5;
	}

	public void setCantidad5(double cantidad5) {
		this.cantidad5 = cantidad5;
	}

	public double getCantidad6() {
		return cantidad6;
	}

	public void setCantidad6(double cantidad6) {
		this.cantidad6 = cantidad6;
	}

	public String getIngrediente1() {
		return ingrediente1;
	}

	public void setIngrediente1(String ingrediente1) {
		this.ingrediente1 = ingrediente1;
	}

	public String getIngrediente2() {
		return ingrediente2;
	}

	public void setIngrediente2(String ingrediente2) {
		this.ingrediente2 = ingrediente2;
	}

	public String getIngrediente3() {
		return ingrediente3;
	}

	public void setIngrediente3(String ingrediente3) {
		this.ingrediente3 = ingrediente3;
	}

	public String getIngrediente4() {
		return ingrediente4;
	}

	public void setIngrediente4(String ingrediente4) {
		this.ingrediente4 = ingrediente4;
	}

	public String getIngrediente5() {
		return ingrediente5;
	}

	public void setIngrediente5(String ingrediente5) {
		this.ingrediente5 = ingrediente5;
	}

	public String getIngrediente6() {
		return ingrediente6;
	}

	public void setIngrediente6(String ingrediente6) {
		this.ingrediente6 = ingrediente6;
	}

	@Override
	public String toString() {
		return "RECETA: " + nombre + ". \n\nINGREDIENTES--" + cantidad1 + " " + ingrediente1 + ", " + cantidad2 + " "
				+ ingrediente2 + ", " + cantidad3 + ", " + ingrediente3 + ",\n" + cantidad4 + " " + ingrediente4 + ", "
				+ cantidad5 + " " + ingrediente5 + ", " + cantidad6 + " " + ingrediente6 + "\nREALIZACION-- "
				+ descripcion;
	}

}
