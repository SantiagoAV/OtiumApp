package formulario;

public class Empresa 
{
	/**
	 * 
	 */
	private String nombre;
	
	/**
	 * 
	 */
	private String ubicacion;
	
	/**
	 * 
	 */
	private String email;
	
	/**
	 * 
	 */
	public Empresa(String pNombre, String pUbicacion, String pEmail)
	{
		nombre = pNombre;
		ubicacion = pUbicacion;
		email = pEmail;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getNombre() {
		return nombre;
	}
	
	/**
	 * 
	 * @param nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * 
	 * @return
	 */
	public String getUbicacion() {
		return ubicacion;
	}

	/**
	 * 
	 * @param ubicacionxc
	 */
	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
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
	
	
	
}

