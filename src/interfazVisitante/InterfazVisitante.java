package interfazVisitante;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;

import logic.Oferta;
import logic.OtiumApp;
import panelesCompartidos.*;

public class InterfazVisitante extends JFrame
{
	// -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

	private OtiumApp logic;
	
	// -----------------------------------------------------------------
    // Atributos de la interfaz
    // -----------------------------------------------------------------
	
	private PanelOfertas ofertas;
	
	private NavBar navBar;
	
	private PanelHomePage panelHomePage;
	
	// -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------
	
	/**
	 * 
	 * @param pOtium
	 */
	public InterfazVisitante(OtiumApp pOtium)
	{
		logic = pOtium;
		panelHomePage = new PanelHomePage();
		System.out.println("visitante");
		// Construye la forma
		setSize(new Dimension(1000,1000));
        getContentPane( ).setLayout( new BorderLayout( ) );
        setResizable( true );
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        setTitle("Visitante");
        
        navBar = new NavBar(this);
        add(navBar, BorderLayout.NORTH);
        add(panelHomePage, BorderLayout.CENTER);
        PanelOfertaDetail ofDetailPrueba = new PanelOfertaDetail(logic.darOfertas().get(0));
        add(ofDetailPrueba, BorderLayout.CENTER);
	}

	// -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------
	
	
	/**
	 * M�todo m�s importante y no se como hacerlo :D
	 */
	public void actualizar()
	{
		//Pens� que la navegaci�n ser�a bueno tenerla como una p�gina web, soooo
		//Lo mejor ser�a poder devolvernos como en estados de la aplicaci�n y as�
		//Como cuando uno de vuelve una p�gina cuando se meti� a lo que no era,
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
}