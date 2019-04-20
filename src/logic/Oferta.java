package logic;

import java.util.ArrayList;

public class Oferta 
{
	/**
	 * 
	 */
	private String titulo;
	
	/**
	 * 
	 */
	private double salario;
	
	/**
	 * 
	 */
	private String descripcion;
	
	/**
	 * 
	 */
	private  String ubicacion;
	
	/**
	 * 
	 */
	private Empresa empresa;
	
	/**
	 * 
	 */
	private String jornada;
	
	/**
	 * 
	 */
	private String requerimiento;
	
	
	/**
	 * 
	 */
	private ArrayList<Materia> materias;
	
	/**
	 * 
	 */
	private ArrayList<HabilidadBlanda> habilidades;
	
	/**
	 * 
	 */
	public Oferta(String pTitulo, double pSalario, String pDescripcion, String pUbicacion, Empresa pEmpresa, String pJornada, String pRequerimiento)
	{
		titulo = pTitulo;
		salario = pSalario;
		descripcion = pDescripcion;
		ubicacion = pUbicacion;
		empresa = pEmpresa;
		jornada = pJornada;
		requerimiento = pRequerimiento;
		materias = new ArrayList<Materia>();
		habilidades = new ArrayList<HabilidadBlanda>();
	}

	/**
	 * 
	 * @return
	 */
	public String getTitulo() {
		return titulo;
	}

	/**
	 * 
	 * @return
	 */
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	/**
	 * 
	 * @return
	 */
	public double getSalario() {
		return salario;
	}

	/**
	 * 
	 * @return
	 */
	public void setSalario(double salario) {
		this.salario = salario;
	}

	/**
	 * 
	 * @return
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * 
	 * @return
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
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
	 * @return
	 */
	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}
	
	/**
	 * 
	 * @return
	 */
	public Empresa getEmpresa() {
		return empresa;
	}

	/**
	 * 
	 * @return
	 */
	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	/**
	 * 
	 * @return
	 */
	public String getJornada() {
		return jornada;
	}

	/**
	 * 
	 * @return
	 */
	public void setJornada(String jornada) {
		this.jornada = jornada;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getRequerimiento() {
		return requerimiento;
	}

	/**
	 * 
	 * @param requerimiento
	 */
	public void setRequerimiento(String requerimiento) {
		this.requerimiento = requerimiento;
	}

	/**
	 * 
	 * @return
	 */
	public ArrayList<Materia> getMaterias() {
		return materias;
	}

	/**
	 * 
	 * @param materias
	 */
	public void setMaterias(ArrayList<Materia> materias) {
		this.materias = materias;
	}
	
	/**
	 * 
	 * @return
	 */
	public ArrayList<HabilidadBlanda> getHabilidades() {
		return habilidades;
	}

	/**
	 * 
	 * @param habilidades
	 */
	public void setHabilidades(ArrayList<HabilidadBlanda> habilidades) {
		this.habilidades = habilidades;
	}
	
	
}
