package interfaz;

import java.awt.*;
import java.text.DecimalFormat;

import javax.swing.*;
import javax.swing.border.TitledBorder;

import logic.Empresa;
import logic.Oferta;

public class PanelOfertaDetail extends JPanel
{
	// -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------
		
	
	// -----------------------------------------------------------------
    // Atributos de la interfaz
    // -----------------------------------------------------------------
	
	
	//TODO poner ruta del maletin
	private final static JLabel imgMaletin = new JLabel(new ImageIcon("./data/pageImgs/portafolio(80).png"));
	
	//TODO poner ruta de la imagen de la empresa.
	private final static JLabel imgEmpresa = new JLabel(new ImageIcon("./data/pageImgs/empresa(250).png"));
	
	private JLabel titulo;
	
	private JLabel salario;
	
	private JTextArea descripcion;
	
	private JLabel jornada;
	
	private JTextArea requerimientos;
	
	private JLabel nombreEmpresa;
	
	private JLabel direccionEmpresa;
	
	private JLabel correoEmpresa;
	
	
	// -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------
	
	public PanelOfertaDetail(Oferta of)
	{
		//Panel con la información de la empresa.
		setBackground(Color.WHITE);
		JPanel east = new JPanel();
		east.setBackground(Color.WHITE);
		east.setLayout(new GridBagLayout());
		east.setBorder(BorderFactory.createLineBorder(Color.black));
		
		GridBagConstraints gbc = new GridBagConstraints(0,0,2,1,1,0,GridBagConstraints.PAGE_START, GridBagConstraints.NONE, new Insets( 5, 5, 5, 5 ),0,0);
		//Posición de la imagen		
		east.add(imgEmpresa, gbc);
		Empresa emp = of.getEmpresa();
		
		gbc = new GridBagConstraints(0,1,2,1,0,0,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets( 5, 5, 5, 5 ),0,0);
		nombreEmpresa = new JLabel(emp.getNombre());
		nombreEmpresa.setHorizontalAlignment(JLabel.CENTER);
		nombreEmpresa.setFont(new Font( nombreEmpresa.getFont().getFontName(), Font.PLAIN, 16 ));
		east.add(nombreEmpresa, gbc);
		
		gbc = new GridBagConstraints(0,2,1,1,0,0,GridBagConstraints.LINE_START, GridBagConstraints.NONE, new Insets( 5, 5, 5, 5 ),0,0);
		east.add(new JLabel("Dirección:"), gbc);
		direccionEmpresa = new JLabel(emp.getUbicacion());
		gbc = new GridBagConstraints(1, 2, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets( 5, 5, 5, 5 ),0,0);
		east.add(direccionEmpresa, gbc);
		
		
		gbc = new GridBagConstraints(0,3,1,1,0,0,GridBagConstraints.LINE_START, GridBagConstraints.NONE, new Insets( 5, 5, 5, 5 ),0,0);
		east.add(new JLabel("Correo:"), gbc);
		correoEmpresa = new JLabel(emp.getEmail(), JLabel.CENTER);
		gbc = new GridBagConstraints(1,3,1,1,0,0,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets( 5, 5, 5, 5 ),0,0);
		east.add(correoEmpresa, gbc);
		
		gbc = new GridBagConstraints(0,4,1,1,0,0,GridBagConstraints.LINE_START, GridBagConstraints.NONE, new Insets( 5, 5, 5, 5 ),0,0);
		east.add(new JLabel("Teléfono:"), gbc);
		gbc = new GridBagConstraints(1,4,1,1,0,0,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets( 5, 5, 5, 5 ),0,0);
		east.add(new JLabel("No disponible."), gbc);

				
		//Panel con la información de la oferta
		JPanel west = new JPanel();
		west.setBackground(Color.WHITE);
		west.setLayout(new GridBagLayout());
		
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
		
		gbc = new GridBagConstraints(0,0,1,1,0,0,GridBagConstraints.PAGE_START, GridBagConstraints.NONE, new Insets( 5, 5, 5, 5 ),0,0);
		west.add(imgMaletin,gbc);
		gbc = new GridBagConstraints(1,0,1,1,0,0,GridBagConstraints.PAGE_START, GridBagConstraints.NONE, new Insets( 5, 5, 5, 5 ),0,0);
		titulo = new JLabel(of.getTitulo());
		titulo.setFont(new Font( titulo.getFont().getFontName(), Font.PLAIN, 20 ));
		titulo.setHorizontalAlignment(SwingConstants.LEFT);
		west.add(titulo, gbc);
		
		gbc = new GridBagConstraints(0,1,2,1,0,0,GridBagConstraints.PAGE_START, GridBagConstraints.NONE, new Insets( 5, 5, 5, 5 ),0,0);
		descripcion = new JTextArea(of.getDescripcion());
		descripcion.setEditable(false);
		descripcion.setMaximumSize(new Dimension(500, 100));
		west.add(descripcion, gbc);
		
		gbc = new GridBagConstraints(0,2,1,1,0,0,GridBagConstraints.PAGE_START, GridBagConstraints.NONE, new Insets( 5, 5, 5, 5 ),0,0);
		west.add(new JLabel("Jornada:"), gbc);
		jornada = new JLabel(of.getJornada());
		gbc = new GridBagConstraints(1,2,1,1,0,0,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets( 5, 5, 5, 5 ),0,0);
		west.add(jornada, gbc);
		
		gbc = new GridBagConstraints(0,3,1,1,0,0,GridBagConstraints.PAGE_START, GridBagConstraints.NONE, new Insets( 5, 5, 5, 5 ),0,0);
		west.add(new JLabel("Salario:"), gbc);
		DecimalFormat format = new DecimalFormat("$###,###.##");
		salario = new JLabel(format.format(of.getSalario()));
		gbc = new GridBagConstraints(1,3,1,1,0,0,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets( 5, 5, 5, 5 ),0,0);
		west.add(salario, gbc);
		
		
		gbc = new GridBagConstraints(0,4,1,1,0,0,GridBagConstraints.PAGE_START, GridBagConstraints.NONE, new Insets( 5, 5, 5, 5 ),0,0);
		west.add(new JLabel("Requerimientos:"),gbc);
		requerimientos = new JTextArea(of.getRequerimiento());
		gbc = new GridBagConstraints(1,4,1,1,0,0,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets( 5, 5, 5, 5 ),0,0);
		west.add(requerimientos, gbc);
		
		
		setLayout(new BorderLayout());
		add(east, BorderLayout.EAST);
		JScrollPane scrollable=new JScrollPane(west, 
				   ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,  
				   ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		add(scrollable, BorderLayout.WEST);
	}
	
	// -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------
	
	
	
}
