package interfaz;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

import logic.Oferta;
import logic.OtiumApp;

/**
 * 
 * @author linkhl09 and mj.ocampov
 */
public class Interfaz extends JFrame
{
	// -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

	private OtiumApp logic;
	
	// -----------------------------------------------------------------
    // Atributos de la interfaz
    // -----------------------------------------------------------------
	
	private PanelOfertas ofertasGenerales;
	
	private NavBar navBar;
	
	private PanelHomePage home;
	
	private ArrayList<JPanel> historial;
	
	// -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------
	
	public Interfaz ()
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
		
		// Inicializo paneles principales.
		logic = new OtiumApp();
		ofertasGenerales = new PanelOfertas(logic.darOfertas(), this);
		home = new PanelHomePage();
		historial = new ArrayList<JPanel>();
		
		
		// Construye la forma.
		setSize(new Dimension(1125,1000));
		getContentPane( ).setLayout( new BorderLayout( ) );
		setResizable( false );
		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		setTitle("Otium App");
		
		
		navBar = new NavBar(this);
        add(navBar, BorderLayout.NORTH);
        
        //Iniciar con la homepage
        add(home, BorderLayout.CENTER);
		
	}
	// -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

	/**
	 * Método más importante y no se como hacerlo :D
	 */
	public void actualizar()
	{
		
		
		
		//Pensé que la navegación sería bueno tenerla como una página web, soooo
		//Lo mejor sería poder devolvernos como en estados de la aplicación y así
		//Como cuando uno de vuelve una página cuando se metió a lo que no era,
		//no se si me hago entender. Bueno el caso, hay que hacer eso.
		//Pero para eso es necesario actualizar TODO el JFrame, lo cual no tengo
		//Idea de como hacer jejeje.
		//Les dejo para que piensen.
		
		
	}

	public void home() 
	{
		//Redirigir a la home page.
		
		
	}

	public void nextPage() 
	{
		// TODO Hacer el next page.		
	}

	public void previousPage() 
	{
		// TODO Hacer el previous page.		
	}

	public void mostrarDetail(Oferta of) 
	{
				
	}
	
	// -----------------------------------------------------------------
    // Main & Asociados.
    // -----------------------------------------------------------------
	
    /**
     * Este método ejecuta la aplicación, creando una nueva interfaz
     * @param args Parámetros de ejecución que no son usados
     */
    public static void main( String[] args )
    {    	
        Interfaz interfaz = new Interfaz( );
        interfaz.setVisible(true); 
    }
}