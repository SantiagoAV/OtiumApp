package panelesCompartidos;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import interfazVisitante.InterfazVisitante;
import logic.Oferta;

public class PanelOferta extends JPanel implements ActionListener
{
	// -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------
	
	private final static String DETAIL = "DETAIL";
	
	// -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------
		
	private InterfazVisitante interfaz;
	
	private Oferta oferta;
	
	// -----------------------------------------------------------------
    // Atributos de la interfaz
    // -----------------------------------------------------------------

	private final static JLabel imgMaletin = new JLabel(new ImageIcon("./data/pageImgs/portafolio.png"));
	
	//TODO poner ruta del like
	private final static JLabel imgLike = new JLabel(new ImageIcon("./data/pageImgs/NOMBREIMG"));
	
	//TODO poner ruta del dislike
	private final static JLabel imgDislike = new JLabel(new ImageIcon("./data/pageImgs/NOMBREIMG"));
	
	private JLabel titulo;
	
	private JLabel salario;
	
	private JButton detail;
	
	// -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------
	
	public PanelOferta ( Oferta of, InterfazVisitante pInterfaz)
	{
		interfaz = pInterfaz;
		oferta = of;
		titulo = new JLabel(of.getTitulo());
		JPanel aux = new JPanel(new GridLayout(1,4));
		aux.add(imgMaletin);
		aux.add(titulo);
		aux.add(imgLike);
		aux.add(imgDislike);
		
		setLayout(new GridLayout(2, 1));
		add(aux);
		JPanel aux2 = new JPanel(new GridLayout(1,2));
		aux2.add(new JLabel("Salario: "));
		salario = new JLabel(of.getSalario()+"");
		aux2.add(salario);
		
		detail = new JButton("Más información");
		detail.addActionListener(this);
		detail.setActionCommand(DETAIL);
		aux.add(detail);
		add(aux);
	}
	
	// -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getActionCommand().equals(DETAIL))
			interfaz.mostrarDetail(oferta);		
	}
	
}