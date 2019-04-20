package formulario;

import java.util.ArrayList;

public class Formulario {
	
	/**
	 * 
	 */
	private String comentario;
	
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
	public Formulario(String pComentario)
	{
		comentario = pComentario;
		materias = new ArrayList<Materia>();
		habilidades = new ArrayList<HabilidadBlanda>();
	}
	
	/**
	 * 
	 * @return
	 */
	public String getComentario() {
		return comentario;
	}

	/**
	 * 
	 * @param comentario
	 */
	public void setComentario(String comentario) {
		this.comentario = comentario;
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
