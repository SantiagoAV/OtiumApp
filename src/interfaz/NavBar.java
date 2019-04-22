package interfaz;

import javax.swing.*;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.*;

public class NavBar extends JPanel implements ActionListener 
{
	// -----------------------------------------------------------------
    // Constantes botones
    // -----------------------------------------------------------------
	
	private final static String BACK = "BACK";

	private final static String FOWARD = "FOWARD";
	
	private final static String HOME = "HOME";
	
	private final static String INICIAR_SESION = "INIICIAR_SESION";
	
	private final static String RESGISTRAR = "REGISTRAR";
	
	// -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------
		
	private Interfaz interfaz;
	
	// -----------------------------------------------------------------
    // Atributos de la interfaz
    // -----------------------------------------------------------------
	
	private JButton back;
	
	private JButton foward;
	
	private JButton home;
	
	private JButton iniciarSesion;
	
	private JButton registrar;
	
	private JTextField proximamenteBarraBusqueda;
	
	// -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

	public NavBar(Interfaz pInterfaz) 
	{
		interfaz = pInterfaz;
		setLayout(new GridLayout(1,7));
		setSize(new Dimension(1000,100));
		setBackground(new Color(44, 40, 40));
		
		home = new JButton(new ImageIcon("./data/pageImgs/icon.png"));
		home.setActionCommand(HOME);
		home.addActionListener(this);
		home.setOpaque(true);
		home.setBorder(null);
		home.setBackground(new Color(44, 40, 40));
		home.setSize(new Dimension(80, 80));
		add(home);
		
		back = new JButton(new ImageIcon("./data/pageImgs/back.JPG"));
		back.setActionCommand(BACK);
		back.addActionListener( this );
		back.setOpaque(true);
		back.setBorder(null);
		back.setBackground(new Color(44, 40, 40));
		back.setSize(new Dimension(50, 50));
		add(back);
		
		foward = new JButton(new ImageIcon("./data/pageImgs/foward.JPG"));
		foward.setActionCommand(FOWARD);
		foward.addActionListener(this);
		foward.setOpaque(true);
		foward.setBorder(null);
		foward.setBackground(new Color(44, 40, 40));
		foward.setSize(new Dimension(50, 50));
		add(foward);

		proximamenteBarraBusqueda = new JTextField("Próximamente barra de busqueda");
		proximamenteBarraBusqueda.setEditable(false);
		proximamenteBarraBusqueda.setSize(new Dimension(200,100));
		proximamenteBarraBusqueda.setBackground(new Color(44, 40, 40));
		proximamenteBarraBusqueda.setBorder(null);
		proximamenteBarraBusqueda.setOpaque(true);
		proximamenteBarraBusqueda.setForeground(Color.WHITE);
		add(proximamenteBarraBusqueda);
		add(new JLabel());
		
		iniciarSesion = new JButton("Iniciar sesión");
		iniciarSesion.setActionCommand(INICIAR_SESION);
		iniciarSesion.addActionListener(this);
		iniciarSesion.setOpaque(true);
		iniciarSesion.setBorder(null);
		iniciarSesion.setBackground(new Color(44, 40, 40));
		iniciarSesion.setForeground(Color.WHITE);
		add(iniciarSesion);
		
		registrar = new JButton("Registrarse");
		registrar.setActionCommand(RESGISTRAR);
		registrar.addActionListener(this);
		registrar.setOpaque(true);
		registrar.setBorder(null);
		registrar.setBackground(new Color(44, 40, 40));
		registrar.setForeground(Color.WHITE);
		add(registrar);
	}
	
	// -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------
	
	@Override
	public void actionPerformed(ActionEvent pEvent) 
	{
		try
		{
			if(pEvent.getActionCommand().equals(BACK))
				interfaz.previousPage();
			else if(pEvent.getActionCommand().equals(FOWARD))
				interfaz.nextPage();
			else if(pEvent.getActionCommand().equals(HOME))
				interfaz.home();
			else if(pEvent.getActionCommand().equals(INICIAR_SESION))
				interfaz.actualizar();//TODO Cambio de panel por el de inicio de sesión
			else if(pEvent.getActionCommand().equals(RESGISTRAR))
				interfaz.actualizar();//TODO Cambio de panel por el de registro
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(this, e.getMessage(), "¡Vaya!", JOptionPane.INFORMATION_MESSAGE);
		}
		
	}
}
