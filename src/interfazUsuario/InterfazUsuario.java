package interfazUsuario;

import javax.swing.JFrame;

import logic.OtiumApp;
import panelesCompartidos.PanelOfertas;

public class InterfazUsuario extends JFrame 
{
	
	// -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

	private OtiumApp otium;
	
	// -----------------------------------------------------------------
    // Atributos de la interfaz
    // -----------------------------------------------------------------
	
	private PanelOfertas ofertasGenerales;
	
	// -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------
	
	public InterfazUsuario(OtiumApp pOtium)
	{
		otium = pOtium;
		System.out.println("Usuario");
		System.exit(1);
	}

	
	// -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------
	
	
	
}