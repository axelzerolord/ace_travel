package logic;

import java.sql.Date;

public class Guests {
	private int invitado_id;
	private String nombre;
	private String apellido;
	private String sexo;
	private Date Fecha_nacimiento;
	
	public Guests(int invitado_id, String nombre, String apellido, String sexo,
			Date fecha_nacimiento) {
		super();
		this.invitado_id = invitado_id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.sexo = sexo;
		Fecha_nacimiento = fecha_nacimiento;
	}

	public int getInvitado_id() {
		return invitado_id;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public String getSexo() {
		return sexo;
	}

	public Date getFecha_nacimiento() {
		return Fecha_nacimiento;
	}

	public void setInvitado_id(int invitado_id) {
		this.invitado_id = invitado_id;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public void setFecha_nacimiento(Date fecha_nacimiento) {
		Fecha_nacimiento = fecha_nacimiento;
	}

	
}
