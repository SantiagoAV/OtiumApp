package interfaz;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Date;

import logic.HabilidadBlanda;
import logic.Materia;
import logic.Oferta;
import logic.OtiumApp;

/**
 * 
 * @author linkhl09 and mjocampov
 */
@SuppressWarnings("serial")
public class Interfaz extends JFrame
{
	// -----------------------------------------------------------------
	// Atributos
	// -----------------------------------------------------------------

	private OtiumApp logic;

	private int pagActual;

	// -----------------------------------------------------------------
	// Atributos de la interfaz
	// -----------------------------------------------------------------

	private JScrollPane ofertasGenerales;

	private JPanel panelOfertasGenerales;

	private JPanel panelOfertasMatch;

	private PanelRegistro registro;

	private PanelIniciarSesion iniciarSesion;

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
		home = new PanelHomePage();
		historial = new ArrayList<JPanel>();
		pagActual = 0;


		// Construye la forma.
		setSize(new Dimension(1125,1000));
		getContentPane( ).setLayout( new BorderLayout( ) );
		setResizable( false );
		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		setTitle("Otium App");
		setBackground(Color.WHITE);


		navBar = new NavBar(this);
		add(navBar, BorderLayout.NORTH);

		home = new PanelHomePage();
		//Iniciar con la homepage y agregarla a la lista de historial.
		historial.add(home);
		add(home, BorderLayout.CENTER);

		//        inicializarPanelOfertasGenerales(); 
		//        ofertasGenerales = new JScrollPane(panelOfertasGenerales, 
		//        			ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,  
		//        			ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		//        add(ofertasGenerales, BorderLayout.CENTER);
		//        
	}
	// -----------------------------------------------------------------
	// Métodos
	// -----------------------------------------------------------------

	private void inicializarPanelOfertasGenerales()
	{
		panelOfertasGenerales = new JPanel();
		panelOfertasGenerales.setLayout(new GridBagLayout());
		int y = 0;
		GridBagConstraints gbc = new GridBagConstraints(0,y,1,1,0,0,GridBagConstraints.LINE_START, 1, new Insets( 5, 5, 5, 5 ),0,0);

		for(Oferta of : logic.darOfertas())
		{
			panelOfertasGenerales.add(new PanelOferta(of, this), gbc);
			y++;
			gbc = new GridBagConstraints(0,y,1,1,0,0,GridBagConstraints.LINE_START, 1, new Insets( 5, 5, 5, 5 ),0,0);
		}
	}

	private void inicializarPanelOfertasUsuario()
	{
		panelOfertasMatch = new JPanel();
		panelOfertasMatch.setLayout(new GridBagLayout());
		int y = 0;
		GridBagConstraints gbc = new GridBagConstraints(0,y,1,1,0,0,GridBagConstraints.LINE_START, 1, new Insets( 5, 5, 5, 5 ),0,0);

		for(Oferta of : logic.calcularMatch())
		{
			panelOfertasMatch.add(new PanelOferta(of, this), gbc);
			y++;
			gbc = new GridBagConstraints(0,y,1,1,0,0,GridBagConstraints.LINE_START, 1, new Insets( 5, 5, 5, 5 ),0,0);
		}
	}

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
		remove(historial.remove(historial.size()-1));
		historial.add(home);
		pagActual++;

		//TODO Repaint de la homepage, no recuerdo como hacerlo.
		home = new PanelHomePage();
		//Iniciar con la homepage y agregarla a la lista de historial.
		historial.add(home);
		add(home, BorderLayout.CENTER);
	}

	public void nextPage() 
	{

		// TODO Hacer el next page.
	}

	public void previousPage() 
	{


		//TODO Repaint, no recuerdo como hacerlo.
	}

	public void mostrarDetail(Oferta of) 
	{
		historial = (ArrayList<JPanel>) historial.subList(0, pagActual);
		PanelOfertaDetail detail = new PanelOfertaDetail(of);
		historial.add(detail);
		pagActual = historial.indexOf(detail);
		//TODO Repaint, no recuerdo como hacerlo.
	}

	public void registrar() {

		remove(historial.remove(historial.size()-1));

		registro = new PanelRegistro(this);
		//Iniciar con la homepage y agregarla a la lista de historial.
		historial.add(registro);
		add(registro, BorderLayout.CENTER);


		repaint();		
	}

	public void iniciarSesion() {

		remove(historial.remove(historial.size()-1));

		iniciarSesion = new PanelIniciarSesion(this);
		//Iniciar con la homepage y agregarla a la lista de historial.
		historial.add(iniciarSesion);
		add(iniciarSesion, BorderLayout.CENTER);


		repaint();		
	}

	public void inicioSesion(String username, String contrasenia) {
		boolean inicio = logic.iniciarSesion(username, contrasenia);

		if(inicio)
		{
			remove(iniciarSesion);

			inicializarPanelOfertasUsuario(); 
			ofertasGenerales = new JScrollPane(panelOfertasMatch, 
					ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,  
					ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
			add(ofertasGenerales, BorderLayout.CENTER);

			repaint();
		}
		else
		{
			JOptionPane.showMessageDialog(this, "El usuario o la contraseña no son válidos");
		}
	}

	public void registrarUsuario(String pNombre, String pApellido, String pEmail, String pUserName, String pUniversidad, Date pFechaNac, String pContra, String pComentario, ArrayList<Materia> materias, ArrayList<HabilidadBlanda> habilidades ) {
		logic.crearUsuario(pNombre, pApellido, pEmail, pUserName, pUniversidad, pFechaNac, pContra, pComentario, materias, habilidades);

		remove(registro);

		inicializarPanelOfertasUsuario(); 
		ofertasGenerales = new JScrollPane(panelOfertasMatch, 
				ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,  
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		add(ofertasGenerales, BorderLayout.CENTER);

		repaint();
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