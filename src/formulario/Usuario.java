package formulario;

import java.util.Date;

public class Usuario
{
	
	/**
	 * 
	 */
	private String username;
	
	/**
	 * 
	 */
	private String nombres;
	
	/**
	 * 
	 */
	private String apellidos;
	
	/**
	 * 
	 */
	private String email;
	
	/**
	 * 
	 */
	private String universidad;
	
	/**
	 * 
	 */
	private Date fechaNacimiento;
	
	/**
	 * 
	 */
	private String contrasenia;
	
	/**
	 * 
	 */
	private Formulario formulario;
	
	/**
	 * 
	 */
	public Usuario(String pUserName, String pNombres, String pApellidos, String pEmail, String pUniversidad, Date pFechaNac, String pContra, Formulario pForm)
	{
		username = pUserName;
		nombres = pNombres;
		apellidos = pApellidos;
		email = pEmail;
		universidad = pUniversidad;
		fechaNacimiento =pFechaNac;
		contrasenia = pContra;
		formulario = pForm;
			
	}

	/**
	 * 
	 * @return
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * 
	 * @param username
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * 
	 * @return
	 */
	public String getNombres() {
		return nombres;
	}

	/**
	 * 
	 * @param nombres
	 */
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	/**
	 * 
	 * @param apellidos
	 */
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	/**
	 * 
	 * @return
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * 
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * 
	 * @return
	 */
	public String getUniversidad() {
		return universidad;
	}

	/**
	 * 
	 * @param universidad
	 */
	public void setUniversidad(String universidad) {
		this.universidad = universidad;
	}

	/**
	 * 
	 * @return
	 */
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	/**
	 * 
	 * @param fechaNacimiento
	 */
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	/**
	 * 
	 * @return
	 */
	public String getContrasenia() {
		return contrasenia;
	}

	/**
	 * 
	 * @param contrasenia
	 */
	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}
	
	/**
	 * 
	 * @return
	 */

	public Formulario getFormulario() {
		return formulario;
	}

	/**
	 * 
	 * @param formulario
	 */
	public void setFormulario(Formulario formulario) {
		this.formulario = formulario;
	}
	
	

}
