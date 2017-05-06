package negocio.presos;

public class TransferEstancia {

	private String fecha_inicio;
	private String fecha_fin;
	private int id_celda;
	private int id_preso;
	
	
	
	public TransferEstancia(int id_celda, int id_preso, String fecha_inicio,String fecha_fin){
		this.id_celda=id_celda;
		this.id_preso=id_preso;
		this.fecha_inicio=fecha_inicio;
		this.fecha_fin=fecha_fin;	
	}
	
	public TransferEstancia(int id_preso, String fecha_fin){
		this.fecha_fin=fecha_fin;
		this.id_preso=id_preso;
	}

	public TransferEstancia(int id_celda, int id_preso, String fecha_inicio) {
		this.id_celda=id_celda;
		this.id_preso=id_preso;
		this.fecha_inicio=fecha_inicio;
	}
	public TransferEstancia(int id_celda, String fecha_inicio, String fecha_fin) {
		this.id_celda=id_celda;
		this.fecha_inicio = fecha_inicio;
		this.fecha_fin=fecha_fin;
	}

	public String getFecha_fin() {
		return fecha_fin;
	}
	public String getFecha_inicio() {
		return fecha_inicio;
	}
	public int getId_celda() {
		return id_celda;
	}
	public int getId_preso() {
		return id_preso;
	}
	public void setFecha_fin(String fecha_fin) {
		this.fecha_fin = fecha_fin;
	}
	public void setFecha_inicio(String fecha_inicio) {
		this.fecha_inicio = fecha_inicio;
	}
	public void setId_celda(int id_celda) {
		this.id_celda = id_celda;
	}
	public void setId_preso(int id_preso) {
		this.id_preso = id_preso;
	}
	
}
