package interfaz;

import java.awt.*;
import java.awt.event.*;

import java.text.DecimalFormat;

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

	private Interfaz interfaz;

	private Oferta oferta;

	// -----------------------------------------------------------------
	// Atributos de la interfaz
	// -----------------------------------------------------------------

	private JLabel titulo;

	private JLabel salario;

	private JButton detail;

	// -----------------------------------------------------------------
	// Constructores
	// -----------------------------------------------------------------

	public PanelOferta ( Oferta of, Interfaz pInterfaz)
	{
		interfaz = pInterfaz;
		setLayout(new GridBagLayout());
		oferta = of;

		GridBagConstraints gbc = new GridBagConstraints(0,0,1,2,0,0,GridBagConstraints.PAGE_START, GridBagConstraints.NONE, new Insets( 5, 5, 5, 5 ),0,0);
		add(new JLabel(new ImageIcon("./data/pageImgs/portafolio(80).png")), gbc);
		
		gbc = new GridBagConstraints(1,0,2,1,0,0,GridBagConstraints.PAGE_START, GridBagConstraints.NONE, new Insets( 5, 5, 5, 5 ),0,0);
		titulo = new JLabel(oferta.getTitulo());
		titulo.setFont(new Font( titulo.getFont().getFontName(), Font.PLAIN, 20 ));
		add(titulo, gbc);
		
		// Let's write how this shit works.
		// grid x,y = position on the matrix
		// gridwidth, gridheight= number of columns or rows that the component will use.
		// ipadx, ipady = "Specifies the internal padding: how much to add to the size of the component." Ni ideaaaa
		// insets = external padding.
		// anchor = where should the component be placed? (you have to use constants).
		// 
		// FIRST_LINE_START		PAGE_START		FIRST_LINE_END
		// LINE_START			CENTER			LINE_END
		// LAST_LINE_START		PAGE_END		LAST_LINE_END
		// 
		// weightx, weighty = 
		//(gridx, gridy, gridwidth, gridheight, weightx, weighty, anchor, fill, insets, ipadx, ipady)

		gbc = new GridBagConstraints(1,1,1,1,0,0,GridBagConstraints.PAGE_START, GridBagConstraints.NONE, new Insets( 5, 5, 5, 5 ),0,0);
		add(new JLabel("Salario:"), gbc);
		
		gbc = new GridBagConstraints(2,1,1,1,0,0,GridBagConstraints.PAGE_START, GridBagConstraints.NONE, new Insets( 5, 5, 5, 5 ),0,0);
		DecimalFormat format = new DecimalFormat("$###,###.##");
		salario = new JLabel(format.format(oferta.getSalario()));
		add(salario, gbc);

		//TODO poner un colocito chevere al boton detail u.u
		gbc = new GridBagConstraints(3,0,1,2,0,0,GridBagConstraints.CENTER, 1, new Insets( 5, 5, 5, 5 ),0,0);
		detail = new JButton("Más información");
		detail.addActionListener(this);
		detail.setActionCommand(DETAIL);
		add(detail, gbc);
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