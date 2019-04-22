package interfazUsuario;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;

import interfazVisitante.NavBar;
import javafx.scene.layout.Border;
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
	
	private PanelRegistro registroUsuario;
	
	private NavBar navBar;
	
	// -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------
	
	public InterfazUsuario(OtiumApp pOtium)
	{
		otium = pOtium;
		System.out.println("Usuario");
		setLayout(new BorderLayout());
		setSize(new Dimension(1000, 1000));
		setResizable(false);
		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        setTitle("Usuario");
        
        navBar = new NavBar(this);
        add(navBar, BorderLayout.NORTH);
        
        registroUsuario = new PanelRegistro(this);
        add(registroUsuario, BorderLayout.CENTER);
	}

	
	// -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------
	
	
	
}
