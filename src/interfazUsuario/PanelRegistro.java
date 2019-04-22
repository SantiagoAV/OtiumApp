package interfazUsuario;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

@SuppressWarnings("serial")
public class PanelRegistro extends JPanel implements ActionListener{

	private JTextField nombres;

	private JTextField apellidos;

	private JTextField email;

	private JTextField username;

	private JPasswordField contrasenia;

	private JDateChooser fechaNacimiento;

	private JTextField universidad;

	private JTextArea comentario;

	private JButton[][] materias;
	
	private JButton[][] habilidades;
	
	private ArrayList<String> materiasSeleccionadas;
	
	private ArrayList<String> habilidadesSeleccionadas;
	
	private JButton siguiente;
	
	private JButton registrar;

	public PanelRegistro (InterfazUsuario pInterfaz){

		setLayout(new GridBagLayout());
		setVisible(true);

		GridBagConstraints constrains = new GridBagConstraints();

		JLabel nombre = new JLabel("Nombre:");
		constrains.gridx = 0;
		constrains.gridy = 0;
		constrains.gridwidth = 1;
		constrains.gridheight = 1;
		constrains.anchor = GridBagConstraints.WEST;
		add(nombre, constrains);

		nombres = new JTextField();
		nombres.setPreferredSize(new Dimension(200, 20));
		constrains.gridx = 1;
		constrains.gridy = 0;
		constrains.gridwidth = 2;
		constrains.gridheight = 1;
		add(nombres, constrains);

		JLabel apellido = new JLabel("Apellidos:");
		constrains.gridx = 0;
		constrains.gridy = 1;
		constrains.gridwidth = 1;
		constrains.gridheight = 1;
		add(apellido, constrains);

		apellidos = new JTextField();
		apellidos.setPreferredSize(new Dimension(200, 20));
		constrains.gridx = 1;
		constrains.gridy = 1;
		constrains.gridwidth = 2;
		constrains.gridheight = 1;
		add(apellidos, constrains);

		JLabel correo = new JLabel("Correo electrónico:");
		constrains.gridx = 0;
		constrains.gridy = 2;
		constrains.gridwidth = 1;
		constrains.gridheight = 1;
		add(correo, constrains);

		email = new JTextField();
		email.setPreferredSize(new Dimension(200, 20));
		constrains.gridx = 1;
		constrains.gridy = 2;
		constrains.gridwidth = 2;
		constrains.gridheight = 1;
		add(email, constrains);

		JLabel user = new JLabel("Nombre de usuario:");
		constrains.gridx = 0;
		constrains.gridy = 3;
		constrains.gridwidth = 1;
		constrains.gridheight = 1;
		add(user, constrains);

		username = new JTextField();
		username.setPreferredSize(new Dimension(200, 20));
		constrains.gridx = 1;
		constrains.gridy = 3;
		constrains.gridwidth = 2;
		constrains.gridheight = 1;
		add(username, constrains);

		JLabel contra = new JLabel("Contraseña:");
		constrains.gridx = 0;
		constrains.gridy = 4;
		constrains.gridwidth = 1;
		constrains.gridheight = 1;
		add(contra, constrains);

		contrasenia = new JPasswordField(15);
		constrains.gridx = 1;
		constrains.gridy = 4;
		constrains.gridwidth = 2;
		constrains.gridheight = 1;
		add(contrasenia, constrains);

		JLabel fecha = new JLabel("Fecha de nacimiento:");
		constrains.gridx = 0;
		constrains.gridy = 5;
		constrains.gridwidth = 1;
		constrains.gridheight = 1;
		add(fecha, constrains);

		fechaNacimiento = new JDateChooser();
		fechaNacimiento.setPreferredSize(new Dimension(200, 20));
		constrains.gridx = 1;
		constrains.gridy = 5;
		constrains.gridwidth = 2;
		constrains.gridheight = 1;
		add(fechaNacimiento, constrains);

		JLabel uni = new JLabel("Universidad:");
		constrains.gridx = 0;
		constrains.gridy = 6;
		constrains.gridwidth = 1;
		constrains.gridheight = 1;
		add(uni, constrains);

		universidad = new JTextField("Universidad de los Andes");
		universidad.setPreferredSize(new Dimension(200, 20));
		universidad.setEditable(false);
		constrains.gridx = 1;
		constrains.gridy = 6;
		constrains.gridwidth = 2;
		constrains.gridheight = 1;
		add(universidad, constrains);

		JLabel coment = new JLabel("Comentario:");
		constrains.gridx = 0;
		constrains.gridy = 7;
		constrains.gridwidth = 1;
		constrains.gridheight = 1;
		constrains.anchor = GridBagConstraints.NORTHWEST;
		add(coment, constrains);

		comentario = new JTextArea("Ej: Me gusta el chocolate");
		comentario.setPreferredSize(new Dimension(800, 200));
		constrains.gridx = 1;
		constrains.gridy = 7;
		constrains.gridwidth = 5;
		constrains.gridheight = 1;
		add(comentario, constrains);

		JLabel coment1 = new JLabel(" ");
		constrains.gridx = 0;
		constrains.gridy = 8;
		constrains.gridwidth = 6;
		constrains.gridheight = 1;
		add(coment1, constrains);
		
		siguiente = new JButton("Siguiente");
		siguiente.setActionCommand("SIGUIENTE");
		siguiente.addActionListener(this);
		siguiente.setOpaque(true);
		siguiente.setBorder(null);
		siguiente.setBackground(new Color(59, 44, 133));
		siguiente.setForeground(Color.WHITE);
		siguiente.setPreferredSize(new Dimension(70, 40));
		constrains.gridx = 5;
		constrains.gridy = 9;
		constrains.gridwidth = 1;
		constrains.gridheight = 1;
		constrains.anchor = GridBagConstraints.LAST_LINE_END;
		add(siguiente, constrains);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("SIGUIENTE"))
		{
			if(nombres.getText().isEmpty())
				JOptionPane.showMessageDialog(this, "Debe poner su nombre");
			else if(apellidos.getText().isEmpty())
				JOptionPane.showMessageDialog(this, "Debe poner sus apellidos");
			else if(username.getText().isEmpty())
				JOptionPane.showMessageDialog(this, "Debe poner un nombre de usuario");
			else if(contrasenia.getPassword().length == 0)
				JOptionPane.showMessageDialog(this, "Debe poner una contraseña");
			else
				inicializarMaterias();
		}
		else if(e.getActionCommand().equals("REGISTRO"))
		{
			
		}

	}

	public void inicializarMaterias() {

		removeAll();
		repaint();
		
		ArrayList<String> materiasJson = new ArrayList<String>();
		materiasJson.add("Algorítmica y Programación I");
		materiasJson.add("Algorítmica y Programación II");
		materiasJson.add("Matemática Estructural");
		materiasJson.add("Lenguajes y Máquinas");
		materiasJson.add("Estructura de Datos");
		materiasJson.add("Fundamentos de Infraestructura Tecnológica");
		materiasJson.add("Sistemas Transaccionales");
		materiasJson.add("Infraestructura de Comunicaciones");
		materiasJson.add("Sistemas Empresariales");
		materiasJson.add("Programación con Tecnologías Web");
		materiasJson.add("Construcción de Aplicaciones Móviles");
		materiasJson.add("Modelado, Simulación y Optimización");
		materiasJson.add("Inteligencia de Negocios");
		materiasJson.add("Infraestructura Computacional");
		materiasJson.add("Arquitectura Empresarial");
		materiasJson.add("Arquitectura y Diseño de SW");
		materiasJson.add("TI en las Organizaciones");
		materiasJson.add("Diseño y Análisis de Algoritmos");
		materiasJson.add("Desarrollo de SW en Equipo");
		materiasJson.add("Diseño de Productos e Innovación en TI");

		materias = new JButton[5][4];
		int k = 0;
		GridBagConstraints constrains = new GridBagConstraints();
		
		JLabel coment = new JLabel("Materias:");
		constrains.gridx = 0;
		constrains.gridy = 0;
		constrains.gridwidth = 1;
		constrains.gridheight = 1;
		constrains.anchor = GridBagConstraints.NORTHWEST;
		add(coment, constrains);
		
		JLabel coment1 = new JLabel(" ");
		constrains.gridx = 0;
		constrains.gridy = 1;
		constrains.gridwidth = 6;
		constrains.gridheight = 1;
		add(coment1, constrains);
		
		constrains.gridwidth = 1;
		for(int i = 0; i < materias.length; i++)
		{
			constrains.gridy = 2+i;
			for (int j = 0; j < materias[i].length; j++)
			{
				constrains.gridx = 0+j;
				materias[i][j] = new JButton(materiasJson.get(k));	
				materias[i][j].addActionListener(this);
				materias[i][j].setActionCommand(i+"-"+j+";"+materiasJson.get(k));
				materias[i][j].setBackground(new Color(44, 40, 40));
				materias[i][j].setForeground(Color.WHITE);
				materias[i][j].setBorder(null);
				materias[i][j].setOpaque(true);
				materias[i][j].setPreferredSize(new Dimension(230, 60));
				add(materias[i][j], constrains);
				k++;
			}
		}
		
		ArrayList<String> habilidadesBlandas = new ArrayList<String>();
	    habilidadesBlandas.add("Escritura");
	    habilidadesBlandas.add("Comunicación");
	    habilidadesBlandas.add("Trabajo en equipo");
	    habilidadesBlandas.add("Paciencia");
	    habilidadesBlandas.add("Adaptabilidad");
	    habilidadesBlandas.add("Resolver problemas");
	    habilidadesBlandas.add("Creatividad");
	    habilidadesBlandas.add("Relaciones interpersonales");
	    
	    habilidades = new JButton[2][4];
		int l = 0;
		
		JLabel coment3 = new JLabel(" ");
		constrains.gridx = 0;
		constrains.gridy = 7;
		constrains.gridwidth = 6;
		constrains.gridheight = 1;
		add(coment3, constrains);
		
		JLabel habilities = new JLabel("Habilidades:");
		constrains.gridx = 0;
		constrains.gridy = 8;
		constrains.gridwidth = 1;
		constrains.gridheight = 1;
		constrains.anchor = GridBagConstraints.NORTHWEST;
		add(habilities, constrains);
		
		JLabel coment2 = new JLabel(" ");
		constrains.gridx = 0;
		constrains.gridy = 9;
		constrains.gridwidth = 6;
		constrains.gridheight = 1;
		add(coment2, constrains);
		
		constrains.gridwidth = 1;
		for(int i = 0; i < habilidades.length; i++)
		{
			constrains.gridy = 10+i;
			for (int j = 0; j < habilidades[i].length; j++)
			{
				constrains.gridx = 0+j;
				materias[i][j] = new JButton(habilidadesBlandas.get(l));	
				materias[i][j].addActionListener(this);
				materias[i][j].setActionCommand(i+"-"+j+";"+habilidadesBlandas.get(l));
				materias[i][j].setBackground(new Color(44, 40, 40));
				materias[i][j].setForeground(Color.WHITE);
				materias[i][j].setBorder(null);
				materias[i][j].setOpaque(true);
				materias[i][j].setPreferredSize(new Dimension(230, 60));
				add(materias[i][j], constrains);
				l++;
			}
		}
		
		JLabel coment4 = new JLabel(" ");
		constrains.gridx = 0;
		constrains.gridy = 13;
		constrains.gridwidth = 6;
		constrains.gridheight = 1;
		add(coment4, constrains);
		
		registrar = new JButton("Registrar");
		registrar.setActionCommand("REGISTRAR");
		registrar.addActionListener(this);
		registrar.setOpaque(true);
		registrar.setBorder(null);
		registrar.setBackground(new Color(59, 44, 133));
		registrar.setForeground(Color.WHITE);
		registrar.setPreferredSize(new Dimension(70, 40));
		constrains.gridx = 3;
		constrains.gridy = 14;
		constrains.gridwidth = 1;
		constrains.gridheight = 1;
		constrains.anchor = GridBagConstraints.LAST_LINE_END;
		add(registrar, constrains);

	}


}