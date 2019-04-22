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

	private boolean agregado;
	
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

		inicializarPanelOfertasGenerales(); 
		ofertasGenerales = new JScrollPane(panelOfertasGenerales, 
		        			ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,  
		        			ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		agregado = false;
		        
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

	private void inicializarPanelOfertasUsuario(String usuario)
	{
		panelOfertasMatch = new JPanel();
		panelOfertasMatch.setLayout(new GridBagLayout());
		int y = 0;
		GridBagConstraints gbc = new GridBagConstraints(0,y,1,1,0,0,GridBagConstraints.LINE_START, 1, new Insets( 5, 5, 5, 5 ),0,0);

		for(Oferta of : logic.calcularMatch(usuario))
		{
			panelOfertasMatch.add(new PanelOferta(of, this), gbc);
			y++;
			gbc = new GridBagConstraints(0,y,1,1,0,0,GridBagConstraints.LINE_START, 1, new Insets( 5, 5, 5, 5 ),0,0);
		}
	}

	public void showHome() 
	{
		historial = new ArrayList<JPanel>( historial.subList(0, pagActual+1));
		if(historial.get(pagActual).equals(panelOfertasGenerales))
			ofertasGenerales.setVisible(false);
		else
			historial.get(pagActual).setVisible(false);
		historial.add(home);
		pagActual++;

		add(home, BorderLayout.CENTER);
		home.setVisible(true);
		repaint();
		revalidate();
	}

	public void nextPage() 
	{
		if(pagActual < historial.size()-1)
		{
			if(historial.get(pagActual).equals(panelOfertasGenerales))
				ofertasGenerales.setVisible(false);
			else
				historial.get(pagActual).setVisible(false);
			
			pagActual ++;
			
			if(historial.get(pagActual).equals(panelOfertasGenerales))
				ofertasGenerales.setVisible(true);
			else
				historial.get(pagActual).setVisible(true);
		}
		
		repaint();
		revalidate();
	}

 	public void previousPage() 
	{
		if(pagActual > 0)
		{
			if(historial.get(pagActual).equals(panelOfertasGenerales))
				ofertasGenerales.setVisible(false);
			else
				historial.get(pagActual).setVisible(false);
			
			pagActual--;
			
			if(historial.get(pagActual).equals(panelOfertasGenerales))
				ofertasGenerales.setVisible(true);
			else
				historial.get(pagActual).setVisible(true);
		}
		
		repaint();
		revalidate();
	}

	public void showAllOfertas() 
	{
		historial = new ArrayList<JPanel>( historial.subList(0, pagActual+1));
		historial.get(pagActual).setVisible(false);
		historial.add(panelOfertasGenerales);
		pagActual++;
		
		if(!agregado)
		{
			add(ofertasGenerales, BorderLayout.CENTER);
			agregado =true;
		}
		
		
		ofertasGenerales.setVisible(true);
		repaint();
		revalidate();	
	}
	
	public void showDetail(Oferta of) 
	{
		historial = new ArrayList<JPanel>( historial.subList(0, pagActual+1));
		
		if(historial.get(pagActual).equals(panelOfertasGenerales))
			ofertasGenerales.setVisible(false);
		else
			historial.get(pagActual).setVisible(false);
		
		PanelOfertaDetail detail = new PanelOfertaDetail(of);
		historial.add(detail);		
		pagActual ++;
		detail.setVisible(true);
		add(detail, BorderLayout.CENTER);
		
		revalidate();
		repaint();		
	}

	public void showRegistrar()
	{
		historial = new ArrayList<JPanel>( historial.subList(0, pagActual+1));

		if(historial.get(pagActual).equals(panelOfertasGenerales))
			ofertasGenerales.setVisible(false);
		else
			historial.get(pagActual).setVisible(false);

		registro = new PanelRegistro(this);
		historial.add(registro);
		pagActual ++;
		add(registro, BorderLayout.CENTER);
		registro.setVisible(true);
		
		repaint();
		revalidate();
	}

	public void showIniciarSesion() 
	{
		historial = new ArrayList<JPanel>( historial.subList(0, pagActual+1));

		if(historial.get(pagActual).equals(panelOfertasGenerales))
			ofertasGenerales.setVisible(false);
		else
			historial.get(pagActual).setVisible(false);
		
		iniciarSesion = new PanelIniciarSesion(this);
		historial.add(iniciarSesion);
		pagActual ++;
		add(iniciarSesion, BorderLayout.CENTER);
		iniciarSesion.setVisible(true);
		
		repaint();
		revalidate();
	}
	
	public void showOfertasUsuario(String pUserName)
	{
		inicializarPanelOfertasUsuario(pUserName); 
		ofertasGenerales = new JScrollPane(panelOfertasMatch, 
				ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,  
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		add(ofertasGenerales, BorderLayout.CENTER);
	}

	public void inicioSesion(String username, String contrasenia) {
		boolean inicio = logic.iniciarSesion(username, contrasenia);

		if(inicio)
		{
			remove(iniciarSesion);

			showOfertasUsuario(username);

			repaint();
			revalidate();
		}
		else
		{
			JOptionPane.showMessageDialog(this, "El usuario o la contraseña no son válidos");
		}
	}

	public void registrarUsuario(String pNombre, String pApellido, String pEmail, String pUserName, String pUniversidad, Date pFechaNac, String pContra, String pComentario, ArrayList<Materia> materias, ArrayList<HabilidadBlanda> habilidades ) {
		logic.crearUsuario(pNombre, pApellido, pEmail, pUserName, pUniversidad, pFechaNac, pContra, pComentario, materias, habilidades);

		remove(registro);

		showOfertasUsuario(pUserName);		
		navBar.actualizar();

		repaint();
		revalidate();
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