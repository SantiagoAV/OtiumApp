package interfazVisitante;

import javax.swing.*;

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
	
	// -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------
		
	private InterfazVisitante interfaz;
	
	// -----------------------------------------------------------------
    // Atributos de la interfaz
    // -----------------------------------------------------------------
	
	//TODO poner ruta de la nutria u.u
	private final static JLabel imgNutria = new JLabel(new ImageIcon("./data/pageImgs/NOMBREIMG"));
	
	private JButton back;
	
	private JButton foward;
	
	private JButton home;
	
	private JTextField proximamenteBarraBusqueda;
	
	// -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------
	
	
	public NavBar (InterfazVisitante pInterfaz)
	{
		interfaz = pInterfaz;
		setLayout(new GridLayout(1,8));
		setSize(new Dimension(1000,100));
		
		add(imgNutria);
		
		back = new JButton(new ImageIcon("./data/pageImgs/back.JPG"));
		back.setActionCommand(BACK);
		back.addActionListener( this );
		add(back);
		
		foward = new JButton(new ImageIcon("./data/pageImgs/foward.JPG"));
		foward.setActionCommand(FOWARD);
		foward.addActionListener(this);
		add(foward);
		
		home = new JButton(new ImageIcon("./data/pageImgs/home.JPG"));
		home.setActionCommand(HOME);
		home.addActionListener(this);
		add(home);
		
		proximamenteBarraBusqueda = new JTextField("Próximamente barra de busqueda");
		proximamenteBarraBusqueda.setEditable(false);
		proximamenteBarraBusqueda.setSize(new Dimension(200,100));
		add(proximamenteBarraBusqueda);
		add(new JLabel());
		add(new JLabel());
		add(new JLabel());
		add(new JLabel());
		add(new JLabel());
		add(new JLabel());
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
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(this, e.getMessage(), "¡Vaya!", JOptionPane.INFORMATION_MESSAGE);
		}
		
	}
}
