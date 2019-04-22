package interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EtchedBorder;

import com.toedter.calendar.JDateChooser;

import logic.HabilidadBlanda;
import logic.Materia;

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

	private ArrayList<Materia> materiasSeleccionadas;

	private ArrayList<HabilidadBlanda> habilidadesSeleccionadas;

	private JButton registrar;
	
	private Interfaz interfaz;

	public PanelRegistro (Interfaz pInterfaz){

		setLayout(new BorderLayout());
		setVisible(true);
		setBackground(Color.WHITE);
		
		interfaz = pInterfaz;
		materiasSeleccionadas = new ArrayList<>();
		habilidadesSeleccionadas = new ArrayList<>();

		JPanel panel = new JPanel();
		JScrollPane scroll = new JScrollPane(panel, 
				ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,  
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		add(scroll, BorderLayout.CENTER);

		panel.setLayout(new GridBagLayout());
		panel.setBackground(Color.WHITE);
		panel.setPreferredSize(new Dimension(1200, 1000));
		GridBagConstraints constrains = new GridBagConstraints();

		JLabel nombre = new JLabel("Nombre:");
		constrains.gridx = 0;
		constrains.gridy = 0;
		constrains.gridwidth = 1;
		constrains.gridheight = 1;
		constrains.anchor = GridBagConstraints.WEST;
		panel.add(nombre, constrains);

		nombres = new JTextField();
		nombres.setPreferredSize(new Dimension(200, 20));
		constrains.gridx = 1;
		constrains.gridy = 0;
		constrains.gridwidth = 2;
		constrains.gridheight = 1;
		panel.add(nombres, constrains);

		JLabel apellido = new JLabel("Apellidos:");
		constrains.gridx = 0;
		constrains.gridy = 1;
		constrains.gridwidth = 1;
		constrains.gridheight = 1;
		panel.add(apellido, constrains);

		apellidos = new JTextField();
		apellidos.setPreferredSize(new Dimension(200, 20));
		constrains.gridx = 1;
		constrains.gridy = 1;
		constrains.gridwidth = 2;
		constrains.gridheight = 1;
		panel.add(apellidos, constrains);

		JLabel correo = new JLabel("Correo electrónico:");
		constrains.gridx = 0;
		constrains.gridy = 2;
		constrains.gridwidth = 1;
		constrains.gridheight = 1;
		panel.add(correo, constrains);

		email = new JTextField();
		email.setPreferredSize(new Dimension(200, 20));
		constrains.gridx = 1;
		constrains.gridy = 2;
		constrains.gridwidth = 2;
		constrains.gridheight = 1;
		panel.add(email, constrains);

		JLabel user = new JLabel("Nombre de usuario:");
		constrains.gridx = 0;
		constrains.gridy = 3;
		constrains.gridwidth = 1;
		constrains.gridheight = 1;
		panel.add(user, constrains);

		username = new JTextField();
		username.setPreferredSize(new Dimension(200, 20));
		constrains.gridx = 1;
		constrains.gridy = 3;
		constrains.gridwidth = 2;
		constrains.gridheight = 1;
		panel.add(username, constrains);

		JLabel contra = new JLabel("Contraseña:");
		constrains.gridx = 0;
		constrains.gridy = 4;
		constrains.gridwidth = 1;
		constrains.gridheight = 1;
		panel.add(contra, constrains);

		contrasenia = new JPasswordField(15);
		constrains.gridx = 1;
		constrains.gridy = 4;
		constrains.gridwidth = 2;
		constrains.gridheight = 1;
		panel.add(contrasenia, constrains);

		JLabel fecha = new JLabel("Fecha de nacimiento:");
		constrains.gridx = 0;
		constrains.gridy = 5;
		constrains.gridwidth = 1;
		constrains.gridheight = 1;
		panel.add(fecha, constrains);

		fechaNacimiento = new JDateChooser();
		fechaNacimiento.setPreferredSize(new Dimension(200, 20));
		constrains.gridx = 1;
		constrains.gridy = 5;
		constrains.gridwidth = 2;
		constrains.gridheight = 1;
		panel.add(fechaNacimiento, constrains);

		JLabel uni = new JLabel("Universidad:");
		constrains.gridx = 0;
		constrains.gridy = 6;
		constrains.gridwidth = 1;
		constrains.gridheight = 1;
		panel.add(uni, constrains);

		universidad = new JTextField("Universidad de los Andes");
		universidad.setPreferredSize(new Dimension(200, 20));
		universidad.setEditable(false);
		constrains.gridx = 1;
		constrains.gridy = 6;
		constrains.gridwidth = 2;
		constrains.gridheight = 1;
		panel.add(universidad, constrains);

		JLabel coment = new JLabel("Comentario:");
		constrains.gridx = 0;
		constrains.gridy = 7;
		constrains.gridwidth = 1;
		constrains.gridheight = 1;
		constrains.anchor = GridBagConstraints.NORTHWEST;
		panel.add(coment, constrains);

		comentario = new JTextArea("Ej: Me gusta el chocolate");
		comentario.setPreferredSize(new Dimension(700, 100));
		comentario.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
		constrains.gridx = 1;
		constrains.gridy = 7;
		constrains.gridwidth = 5;
		constrains.gridheight = 1;
		panel.add(comentario, constrains);

		JLabel coment1 = new JLabel(" ");
		constrains.gridx = 0;
		constrains.gridy = 8;
		constrains.gridwidth = 6;
		constrains.gridheight = 1;
		panel.add(coment1, constrains);

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

		JLabel coment18 = new JLabel("Materias:");
		constrains.gridx = 0;
		constrains.gridy = 9;
		constrains.gridwidth = 1;
		constrains.gridheight = 1;
		constrains.anchor = GridBagConstraints.NORTHWEST;
		panel.add(coment18, constrains);

		JLabel coment19 = new JLabel(" ");
		constrains.gridx = 0;
		constrains.gridy = 10;
		constrains.gridwidth = 6;
		constrains.gridheight = 1;
		panel.add(coment19, constrains);

		constrains.gridwidth = 1;
		for(int i = 0; i < materias.length; i++)
		{
			constrains.gridy = 11+i;
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
				panel.add(materias[i][j], constrains);
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
		constrains.gridy = 16;
		constrains.gridwidth = 6;
		constrains.gridheight = 1;
		panel.add(coment3, constrains);

		JLabel habilities = new JLabel("Habilidades:");
		constrains.gridx = 0;
		constrains.gridy = 17;
		constrains.gridwidth = 1;
		constrains.gridheight = 1;
		constrains.anchor = GridBagConstraints.NORTHWEST;
		panel.add(habilities, constrains);

		JLabel coment2 = new JLabel(" ");
		constrains.gridx = 0;
		constrains.gridy = 18;
		constrains.gridwidth = 6;
		constrains.gridheight = 1;
		panel.add(coment2, constrains);

		constrains.gridwidth = 1;
		for(int i = 0; i < habilidades.length; i++)
		{
			constrains.gridy = 19+i;
			for (int j = 0; j < habilidades[i].length; j++)
			{
				constrains.gridx = 0+j;
				habilidades[i][j] = new JButton(habilidadesBlandas.get(l));	
				habilidades[i][j].addActionListener(this);
				habilidades[i][j].setActionCommand(i+"-"+j+","+habilidadesBlandas.get(l));
				habilidades[i][j].setBackground(new Color(44, 40, 40));
				habilidades[i][j].setForeground(Color.WHITE);
				habilidades[i][j].setBorder(null);
				habilidades[i][j].setOpaque(true);
				habilidades[i][j].setPreferredSize(new Dimension(230, 60));
				panel.add(habilidades[i][j], constrains);
				l++;
			}
		}

		JLabel coment4 = new JLabel(" ");
		constrains.gridx = 0;
		constrains.gridy = 22;
		constrains.gridwidth = 6;
		constrains.gridheight = 1;
		panel.add(coment4, constrains);

		registrar = new JButton("Registrar");
		registrar.setActionCommand("REGISTRAR");
		registrar.addActionListener(this);
		registrar.setOpaque(true);
		registrar.setBorder(null);
		registrar.setBackground(new Color(59, 44, 133));
		registrar.setForeground(Color.WHITE);
		registrar.setPreferredSize(new Dimension(70, 40));
		constrains.gridx = 3;
		constrains.gridy = 23;
		constrains.gridwidth = 1;
		constrains.gridheight = 1;
		constrains.anchor = GridBagConstraints.LAST_LINE_END;
		panel.add(registrar, constrains);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("REGISTRAR"))
		{
			if(nombres.getText().isEmpty())
				JOptionPane.showMessageDialog(this, "Debe poner su nombre");
			else if(apellidos.getText().isEmpty())
				JOptionPane.showMessageDialog(this, "Debe poner sus apellidos");
			else if(email.getText().isEmpty())
				JOptionPane.showMessageDialog(this, "Debe poner un correo electrónico");
			else if(username.getText().isEmpty())
				JOptionPane.showMessageDialog(this, "Debe poner un nombre de usuario");
			else if(contrasenia.getPassword().length == 0)
				JOptionPane.showMessageDialog(this, "Debe poner una contraseña");
			else if(fechaNacimiento.getDate() == null)
				JOptionPane.showMessageDialog(this, "Debe poner seleccionar una fecha de nacimiento");
			else
			{
				char[] contra = contrasenia.getPassword();
				String contrasena = "";
				for(int k = 0; k < contra.length; k++)
				{
					contrasena += contra[k];
				}
				interfaz.registrarUsuario(nombres.getText(), apellidos.getText(), email.getText(), username.getText(), universidad.getText(), fechaNacimiento.getDate(), contrasena, comentario.getText(), materiasSeleccionadas, habilidadesSeleccionadas);
			}
		}
		else if(e.getActionCommand().contains(";"))
		{
			String comando = e.getActionCommand();
			String materia = comando.split(";")[1];
			String coordenadas = comando.split(";")[0];
			int i = Integer.parseInt(coordenadas.split("-")[0]);
			int j = Integer.parseInt(coordenadas.split("-")[1]);

			if(materias[i][j].getBackground().equals(new Color(44, 40, 40)))
			{
				materiasSeleccionadas.add(new Materia(materia));
				materias[i][j].setBackground(new Color(59, 44, 133));
			}

			else if(materias[i][j].getBackground().equals(new Color(59, 44, 133)))
			{
				materiasSeleccionadas.remove(new Materia(materia));
				materias[i][j].setBackground(new Color(44, 40, 40));
			}
		}

		else if(e.getActionCommand().contains(","))
		{
			String comando = e.getActionCommand();
			String habilidad = comando.split(",")[1];
			String coordenadas = comando.split(",")[0];
			int i = Integer.parseInt(coordenadas.split("-")[0]);
			int j = Integer.parseInt(coordenadas.split("-")[1]);

			if(habilidades[i][j].getBackground().equals(new Color(44, 40, 40)))
			{
				habilidadesSeleccionadas.add(new HabilidadBlanda(habilidad));
				habilidades[i][j].setBackground(new Color(59, 44, 133));
			}

			else if(habilidades[i][j].getBackground().equals(new Color(59, 44, 133)))
			{
				habilidadesSeleccionadas.remove(new HabilidadBlanda(habilidad));
				habilidades[i][j].setBackground(new Color(44, 40, 40));
			}
		}

	}

}