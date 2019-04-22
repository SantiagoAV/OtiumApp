package interfaz;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

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
		
	//private InterfazVisitante interfaz;
	
	private Oferta oferta;
	
	// -----------------------------------------------------------------
    // Atributos de la interfaz
    // -----------------------------------------------------------------

	private final static JLabel imgMaletin = new JLabel(new ImageIcon("./data/pageImgs/portafolio.png"));
	private JLabel titulo;
	
	private JLabel salario;
	
	private JButton detail;
	
	// -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------
	
	public PanelOferta ( Oferta of, JFrame pInterfaz)
	{
		oferta = of;
		titulo = new JLabel(of.getTitulo());
		JPanel aux = new JPanel(new GridLayout(1,4));
		aux.add(imgMaletin);
		aux.add(titulo);
		
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
		//if(e.getActionCommand().equals(DETAIL))
			//interfaz.mostrarDetail(oferta);		
	}
	
}