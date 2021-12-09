package mx.com.sgah.capadatos.domain;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="movimiento")
public class Movimiento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_movimiento")
	private Long idMovimiento;
	
	private String fecha;
	
	private Float monto;
	
	private String descripcion; 
	
	@Column(name = "tipo_movimiento")
	private String tipoMovimiento;
	
	private String asignacion;
	
	public Movimiento() {
		
	}
	
	public Movimiento(long idMovimiento) {
		this.idMovimiento = idMovimiento;
	}

	public Movimiento(String fecha, Float monto, String descripcion, String tipoMovimiento, String asignacion) {
		this.fecha = fecha;
		this.monto = monto;
		this.descripcion = descripcion;
		this.tipoMovimiento = tipoMovimiento;
		this.asignacion = asignacion;
	}

	public Movimiento(Long idMovimiento, String fecha, Float monto, String descripcion, String tipoMovimiento,
			String asignacion) {
		this.idMovimiento = idMovimiento;
		this.fecha = fecha;
		this.monto = monto;
		this.descripcion = descripcion;
		this.tipoMovimiento = tipoMovimiento;
		this.asignacion = asignacion;
	}

	public Long getIdMovimiento() {
		return idMovimiento;
	}

	public void setIdMovimiento(Long idMovimiento) {
		this.idMovimiento = idMovimiento;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public Float getMonto() {
		return monto;
	}

	public void setMonto(Float monto) {
		this.monto = monto;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getTipoMovimiento() {
		return tipoMovimiento;
	}

	public void setTipoMovimiento(String tipoMovimiento) {
		this.tipoMovimiento = tipoMovimiento;
	}

	public String getAsignacion() {
		return asignacion;
	}

	public void setAsignacion(String asignacion) {
		this.asignacion = asignacion;
	}

	@Override
	public String toString() {
		return "Movimiento [idMovimiento=" + idMovimiento + ", fecha=" + fecha + ", monto=" + monto + ", descripcion="
				+ descripcion + ", tipoMovimiento=" + tipoMovimiento + ", asignacion=" + asignacion + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(idMovimiento);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Movimiento other = (Movimiento) obj;
		return Objects.equals(idMovimiento, other.idMovimiento);
	}
	
	
	
	
	
}
