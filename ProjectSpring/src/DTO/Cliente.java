package DTO;

import java.util.Date;

public class Cliente {
	
	/*Cedula` varchar(15) NOT NULL,
	  `Nombres` varchar(30) NOT NULL,
	  `Apellidos` varchar(30) NOT NULL,
	  `Email` varchar(120) NOT NULL,
	  `UsuarioCrea` varchar(15) NOT NULL,
	  `FechaCreacion` date NOT NULL,
	  `UsuarioModifica` varchar(15) DEFAULT NULL,
	  `FechaModificacion` date DEFAULT NULL,
	  `Eliminado` tinyint(1) DEFAULT NULL,
	  `UsuarioElimina` varchar(15) DEFAULT NULL,
	  `FechaEliminacion` date DEFA*/
	
	private String cedula;
	private String nombres;
	private String apellidos;
	private String email;
	private Usuario usuarioCrea;
	private Date fechaCreacion;
	private Usuario usuarioModifica;
	private Date fechaModificacion;
	private Boolean eliminado;
	private Usuario usuarioElimina;
	private Date fechaEliminacion;
	
	public String getCedula() {
		return cedula;
	}
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Usuario getUsuarioCrea() {
		return usuarioCrea;
	}
	public void setUsuarioCrea(Usuario usuarioCrea) {
		this.usuarioCrea = usuarioCrea;
	}
	public Date getFechaCreacion() {
		return fechaCreacion;
	}
	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	public Usuario getUsuarioModifica() {
		return usuarioModifica;
	}
	public void setUsuarioModifica(Usuario usuarioModifica) {
		this.usuarioModifica = usuarioModifica;
	}
	public Date getFechaModificacion() {
		return fechaModificacion;
	}
	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}
	public Boolean getEliminado() {
		return eliminado;
	}
	public void setEliminado(Boolean eliminado) {
		this.eliminado = eliminado;
	}
	public Usuario getUsuarioElimina() {
		return usuarioElimina;
	}
	public void setUsuarioElimina(Usuario usuarioElimina) {
		this.usuarioElimina = usuarioElimina;
	}
	public Date getFechaEliminacion() {
		return fechaEliminacion;
	}
	public void setFechaEliminacion(Date fechaEliminacion) {
		this.fechaEliminacion = fechaEliminacion;
	}
	
	

}
