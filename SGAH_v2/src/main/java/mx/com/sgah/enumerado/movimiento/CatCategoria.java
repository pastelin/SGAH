package mx.com.sgah.enumerado.movimiento;

public enum CatCategoria {

	SELECCIONAR_OPCION(1),
	FREE(2), 
	SPEND(3), 
	KEEP(4),
	BORROW(5),
	ROPA(6),
	CALZADO(7),
	PASAJE(8),
	COMIDA(9),
	ELECTRONICOS(10),
	GASTOS_CASA(11),
	HIGIENE_PERSONAL(12),
	DESPENSA(13),
	MEDICAMENTOS(14),
	OTROS(15),
	TODOS(19);
	
	private int id;
	
	private CatCategoria(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}
}
