package mx.com.sgah.actions;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;

import mx.com.sgah.capadatos.domain.Movimiento;
import mx.com.sgah.capaservicio.MovimientoServiceI;
import mx.com.sgah.utileria.Fecha;

public class MovimientoAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private static final String ASIGNACION_SPEND = "spend";
	private static final String ASIGNACION_BORROW = "borrow";
	private static final String ASIGNACION_KEEP = "keep";
	private static final String ASIGNACION_FREE = "free";
	
	private List<Movimiento> listaMovimientos;
	private float totalSpend;
	private float totalBorrow;
	private float totalFree;
	private float totalKeep;
	private float total;
	private float montoAnterior;
	private Movimiento movimiento;
	private List<String> categorias;
	private Map<String, String> asignaciones;
	

	@Autowired
	MovimientoServiceI movimientoService;
	
	@Action(value="/mostrarDatos", results= {
			@Result(name="success", location="/WEB-INF/content/movimientos.jsp")})
	public String initExecute() {
		listaMovimientos = this.movimientoService.listarMovimiento();
		String asignacion = "";
		Map<String, String> asignaciones = new HashMap<>();
		
		for(Movimiento objMovimiento : listaMovimientos) {
			asignacion = objMovimiento.getAsignacion();

			if( (ASIGNACION_KEEP).equals(asignacion) ) {
				this.totalKeep += objMovimiento.getMonto();
			} else if( (ASIGNACION_FREE).equals(asignacion) ) {
				this.totalFree += objMovimiento.getMonto();
			} else if( (ASIGNACION_BORROW).equals(asignacion) ) {
				this.totalBorrow += objMovimiento.getMonto();
			} else if( (ASIGNACION_SPEND).equals(asignacion) ) {
				this.totalSpend += convertirMontoPositivo(objMovimiento.getMonto());
			}
		}
		
		calcularTotales();
		asignaciones.put("", "Seleccione una opción");
		asignaciones.put("keep", "Keep");
		asignaciones.put("free", "Free");
		this.setAsignaciones(asignaciones);
		
		return "success";
	}

	@Action(value="/agregarMovimiento", results= {
			@Result(name="agregadoExitoso", location="mostrarDatos",  type="redirectAction")})
	public String agregarMovimiento() {
		if(this.movimiento.getTipoMovimiento() == null) {
			if(this.movimiento.getAsignacion().equals("keep") || this.movimiento.getAsignacion().equals("free")) {
				this.movimiento.setTipoMovimiento("ahorro");
			} else {			
				this.movimiento.setTipoMovimiento("gasto");
			}			
		}
		
		this.movimiento.setFecha(Fecha.getCurrentDate());	
		this.movimientoService.agregarMovimiento(this.movimiento);
		return "agregadoExitoso";
	}
	
	@Action(value="modificarMovimiento", results= {
			@Result(name="modificadoExitoso", location="mostrarDatos", type="redirectAction")})
	public String modificarMovimiento() {
		Movimiento objMovimiento = new Movimiento(movimiento.getFecha(), movimiento.getMonto(), movimiento.getDescripcion(), "ahorro", "free");
		float montoNuevo = montoAnterior - movimiento.getMonto();
		this.movimiento.setMonto(montoNuevo);
		
		this.movimientoService.actualizarMovimiento(this.movimiento);
		
		this.movimientoService.agregarMovimiento(objMovimiento);
 
		return "modificadoExitoso";
	}
	
	@Action(value="bucarMovimiento", results= {
			@Result(name="busquedaExitos", location="mostrarDatos", type="redirectAction")})
	public String buscarMovimientoPorId() {
		this.movimientoService.encontrarPorId(movimiento);
		
		return "busquedaExitosa";
	}
	
	
	private float convertirMontoPositivo(float monto) {
		float nuevoMonto = monto;
		float operandoNegativo = -1.0f;
		
		if (monto < 0) {
			nuevoMonto = operandoNegativo * monto;
		}
		return nuevoMonto;
	}

	private void calcularTotales() {
		this.totalKeep = this.totalKeep - this.totalBorrow;
		this.totalFree = this.totalFree + this.totalBorrow - this.totalSpend;
		this.total = this.totalFree + this.totalKeep;
	}
	
	public List<Movimiento> getListaMovimientos() {
		return listaMovimientos;
	}

	public void setListaMovimientos(List<Movimiento> listaMovimientos) {
		this.listaMovimientos = listaMovimientos;
	}

	public float getTotalSpend() {
		return totalSpend;
	}

	public void setTotalSpend(float totalSpend) {
		this.totalSpend = totalSpend;
	}

	public float getTotalBorrow() {
		return totalBorrow;
	}

	public void setTotalBorrow(float totalBorrow) {
		this.totalBorrow = totalBorrow;
	}

	public float getTotalFree() {
		return totalFree;
	}

	public void setTotalFree(float totalFree) {
		this.totalFree = totalFree;
	}

	public float getTotalKeep() {
		return totalKeep;
	}

	public void setTotalKeep(float totalKeep) {
		this.totalKeep = totalKeep;
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}

	public Movimiento getMovimiento() {
		return movimiento;
	}

	public void setMovimiento(Movimiento movimiento) {
		this.movimiento = movimiento;
	}

	public float getMontoAnterior() {
		return montoAnterior;
	}

	public void setMontoAnterior(float montoAnterior) {
		this.montoAnterior = montoAnterior;
	}

	public List<String> getCategorias() {
		return categorias;
	}

	public void setCategorias(List<String> categorias) {
		this.categorias = categorias;
	}

	public Map<String, String> getAsignaciones() {
		return asignaciones;
	}

	public void setAsignaciones(Map<String, String> asignaciones) {
		this.asignaciones = asignaciones;
	}	
}
