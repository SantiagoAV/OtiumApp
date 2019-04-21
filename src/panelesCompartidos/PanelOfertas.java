package panelesCompartidos;

import java.util.ArrayList;

import javax.swing.*;
import logic.Oferta;

public class PanelOfertas extends JScrollPane
{
	// -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------
		
	
	// -----------------------------------------------------------------
    // Atributos de la interfaz
    // -----------------------------------------------------------------
	
	
	
	// -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------
	
	public PanelOfertas(ArrayList<Oferta> ofertas)
	{
		// Inicializo los Panel Oferta a mostrar y los voy agregando.
		for(Oferta of : ofertas)
		{
			PanelOferta nuevaOferta = new PanelOferta(of);
			add(nuevaOferta);
		}
		
		
	}
	
	// -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------
	
	
	
}
