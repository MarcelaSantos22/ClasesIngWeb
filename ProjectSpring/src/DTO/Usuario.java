package DTO;

public class Usuario {
	/*
	`Login` varchar(15) NOT NULL,
	  `Nombres` varchar(45) NOT NULL,
	  `Apellidos` varchar(45) NOT NULL,
	  `Contrasena` varchar(125) NOT NULL,
	  `Rol` varchar(12) NOT NULL,*/
	
	private String login;
	private String nombres;
	private String apellidos;
	private String contrasena;
	private Rol rol;
	
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
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
	public String getContrasena() {
		return contrasena;
	}
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	public Rol getRol() {
		return rol;
	}
	public void setRol(Rol rol) {
		this.rol = rol;
	}

}
