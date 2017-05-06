package presentacion.notificaciones;

public enum Notificaciones {
	
	ALTA_CORRECTO(0, "Se ha dado de alta con id "),
	BAJA_CORRECTO(0, "Se ha dado de baja con id "),
	MODIFICAR_CORRECTO(0, "Se ha modificado con id "),

	DOBLE_ALTA(-1, "El estado ya era activo."),
	DOBLE_BAJA(-1, "El estado ya era inactivo."),
	
	NO_EXISTE(-2, "El elemento no existe en la base de datos."),
	PABELLON_NO_EXISTE(-2, "El pabellon no existe."),
	ALTA_EXISTENTE(0, "Se ha procedido al alta manteniendo los datos anteriores."),
	
	DATOS_ERRONEOS(-3, "Los datos introducidos son erroneos."),
	PABELLON_LLENO(-4, "El pabellon esta lleno."),
	NR_CELDA_EXISTENTE(-5, "Se intenta asignar a una celda el numero de otra ya existente."),
	MODIFICAR_INCORRECTO(-6, "Error, se intenta transladar la celda de pabellon."),
	CELDAS_ACTIVAS(-7, "Hay celdas activas."),
	CELDA_CON_PRESOS (-8, "La celda que intentas dar de baja contiene presos."),
	CELDA_INEXISTENTE(-13, "La celda no existe."),
	
	PRESO_NO_EXISTENTE(-10, "No existe el preso asociado a ese id."),
	PRESO_DADO_DE_ALTA_OTROS_DATOS(-11, "El preso con ese DNI ya esta dado de alta con datos anteriores."),
	ERROR(-10000, "Error."),
	ASIGNACION_CORRECTA(0, "Se ha asignado la celda correctamente."),
	ASIGNACION_INCORRECTA(-1, "Se ha producido un error al realizar la asignacion."),
	ASIGNACION_INCORRECTA_CELDA_LLENA(-15,"Error, la celda ya esta llena."),
	FECHA_INCORRECTA(-1,"La fecha introducida no es valida."), 
	MISMO_DNI(-1, "Ya existe un preso con el mismo DNI."), 
	;
	
	private int num;
	private String mensaje;
	
	Notificaciones(int num, String mensaje){
		this.num = num;
		this.mensaje = mensaje;
	}
	
	public void setNum(int n){
		this.num = n;
	}
	
	public String getMensaje(){
		return this.mensaje;
	}
	
	public int getNum(){
		return this.num;
	}
}
