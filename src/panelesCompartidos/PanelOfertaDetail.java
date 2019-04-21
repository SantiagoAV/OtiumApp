package panelesCompartidos;

import java.awt.*;
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
	private final static JLabel imgMaletin = new JLabel(new ImageIcon("./data/pageImgs/NOMBREIMG"));
	
	//TODO poner ruta de la imagen de la empresa.
	private final static JLabel imgEmpresa = new JLabel(new ImageIcon("./data/pageImgs/NOMBREIMG"));
	
	private JLabel titulo;
	
	private JLabel salario;
	
	private JTextArea descripcion;
	
	private JLabel jornada;
	
	private JLabel requerimiento;
	
	private JLabel nombreEmpresa;
	
	private JLabel direccionEmpresa;
	
	private JLabel correoEmpresa;
	
	
	// -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------
	
	public PanelOfertaDetail(Oferta of)
	{
		//Panel con la información de la empresa.
		JPanel east = new JPanel();
		east.setLayout(new GridLayout(9, 1));
		east.setBorder(BorderFactory.createLineBorder(Color.black));
		
		
		east.add(imgEmpresa);
		Empresa emp = of.getEmpresa();
		
		nombreEmpresa = new JLabel(emp.getNombre());
		nombreEmpresa.setHorizontalAlignment(JLabel.CENTER);
		east.add(nombreEmpresa);
		
		JPanel aux = new JPanel(new GridLayout(1,2));
		aux.add(new JLabel("Dirección: ", JLabel.CENTER));
		direccionEmpresa = new JLabel(emp.getUbicacion(), JLabel.CENTER);
		aux.add(direccionEmpresa);
		east.add(aux);
		
		aux = new JPanel(new GridLayout(1,2));
		aux.add(new JLabel("Correo: ", JLabel.CENTER));
		correoEmpresa = new JLabel(emp.getEmail(), JLabel.CENTER);
		aux.add(correoEmpresa);
		east.add(aux);
		
		aux = new JPanel(new GridLayout(1,2));
		aux.add(new JLabel("Teléfono: ", JLabel.CENTER));
		aux.add(new JLabel("No disponible."));
		east.add(aux);
		east.add(new JLabel());
		east.add(new JLabel());
		east.add(new JLabel());
		east.add(new JLabel());
		
		
		
		//Panel con la información de la oferta
		JPanel west = new JPanel();
		west.setLayout(new GridLayout(7, 1));
		
		aux = new JPanel(new GridLayout(1,2));
		aux.add(imgMaletin);
		titulo = new JLabel(of.getTitulo());
		titulo.setFont(new Font( titulo.getFont().getFontName(), Font.PLAIN, 20 ));
		titulo.setHorizontalAlignment(SwingConstants.LEFT);
		aux.add(titulo);
		west.add(aux);
		
		descripcion = new JTextArea(of.getDescripcion());
		descripcion.setEditable(false);
		west.add(descripcion);
		
		aux = new JPanel(new GridLayout(1,2));
		aux.add(new JLabel("Jornada:"));
		jornada = new JLabel(of.getJornada());
		aux.add(jornada);
		west.add(aux);
		
		aux = new JPanel(new GridLayout(1,2));
		aux.add(new JLabel("Salario:"));
		salario = new JLabel(""+ of.getSalario());
		aux.add(salario);
		west.add(aux);
		
		aux = new JPanel(new GridLayout(1,2));
		aux.add(new JLabel("Requerimientos:"));
		requerimiento = new JLabel(of.getRequerimiento());
		aux.add(requerimiento);
		west.add(aux);
		
		setLayout(new BorderLayout());
		add(east, BorderLayout.EAST);
		add(west, BorderLayout.WEST);
	}
	
	// -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------
	
	
	
}
