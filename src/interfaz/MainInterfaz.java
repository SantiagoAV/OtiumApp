package interfaz;

import javax.swing.*;

import interfazUsuario.InterfazUsuario;
import interfazVisitante.InterfazVisitante;
import logic.OtiumApp;


/**
 * 
 * @author linkhl09
 */
public class MainInterfaz
{
	// -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

	private OtiumApp otium;
	
	// -----------------------------------------------------------------
    // Atributos de la interfaz
    // -----------------------------------------------------------------
	
	
	
	// -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------
	
	public MainInterfaz ()
	{
		int resp = JOptionPane.showConfirmDialog(
    			null, 
    			"                   Bienvenido a OtiumApp! \nEsperamos que todo sea de utilidad para usted.",
    			"¡Bienvenido!",
    			JOptionPane.OK_CANCEL_OPTION);
		if (resp == JOptionPane.CANCEL_OPTION)
		{
			JOptionPane.showMessageDialog(
					null, 
					"¡Esperamos verte pronto de nuevo!", 
					"Chao!",
					JOptionPane.DEFAULT_OPTION);
			System.exit(1);
		}
		
		resp = JOptionPane.showConfirmDialog(
    			null, 
    			"¿Desea iniciar sesión como visitante?",
    			"¡Bienvenido!",
    			JOptionPane.YES_NO_OPTION);
		
		otium = new OtiumApp();
		if(resp == JOptionPane.YES_OPTION)
		{
			
			InterfazVisitante visitante = new InterfazVisitante(otium);
			visitante.setVisible(true);
			
		}
		else if( resp == JOptionPane.NO_OPTION)
		{
			
			InterfazUsuario usuario = new InterfazUsuario(otium);
			usuario.setVisible(true); 
		}
		
		
	}
	// -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

	// -----------------------------------------------------------------
    // Main & Asociados.
    // -----------------------------------------------------------------
	
    /**
     * Este método ejecuta la aplicación, creando una nueva interfaz
     * @param args Parámetros de ejecución que no son usados
     */
    public static void main( String[] args )
    {    	
        MainInterfaz interfaz = new MainInterfaz( );
    }
}