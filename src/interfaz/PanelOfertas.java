package interfaz;

import java.util.ArrayList;

import javax.swing.*;

import interfazVisitante.InterfazVisitante;
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
	
	public PanelOfertas(ArrayList<Oferta> ofertas, JFrame pInterfaz )
	{
		// Inicializo los Panel Oferta a mostrar y los voy agregando.
		for(Oferta of : ofertas)
		{
			PanelOferta nuevaOferta = new PanelOferta(of, pInterfaz);
			add(nuevaOferta);
		}
		
		
	}
	
	// -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------
	
	
	
}
