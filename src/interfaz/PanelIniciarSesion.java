package interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class PanelIniciarSesion extends JPanel implements ActionListener{

	private JTextField username;

	private JPasswordField contrasenia;

	private JButton iniciarSesion;

	private Interfaz interfaz;

	public PanelIniciarSesion(Interfaz pInterfaz) {

		setLayout(new GridBagLayout());
		setVisible(true);
		setBackground(Color.WHITE);

		interfaz = pInterfaz;
		GridBagConstraints constrains = new GridBagConstraints();

		JLabel user = new JLabel("Nombre de usuario:");
		constrains.gridx = 0;
		constrains.gridy = 0;
		constrains.gridwidth = 1;
		constrains.gridheight = 1;
		add(user, constrains);

		username = new JTextField();
		username.setPreferredSize(new Dimension(200, 20));
		constrains.gridx = 1;
		constrains.gridy = 0;
		constrains.gridwidth = 2;
		constrains.gridheight = 1;
		add(username, constrains);

		JLabel contra = new JLabel("Contraseña:");
		constrains.gridx = 0;
		constrains.gridy = 1;
		constrains.gridwidth = 1;
		constrains.gridheight = 1;
		add(contra, constrains);

		contrasenia = new JPasswordField(15);
		constrains.gridx = 1;
		constrains.gridy = 1;
		constrains.gridwidth = 2;
		constrains.gridheight = 1;
		add(contrasenia, constrains);

		iniciarSesion = new JButton("Iniciar Sesión");
		iniciarSesion.setActionCommand("INICIAR");
		iniciarSesion.addActionListener(this);
		iniciarSesion.setOpaque(true);
		iniciarSesion.setBorder(null);
		iniciarSesion.setBackground(new Color(59, 44, 133));
		iniciarSesion.setForeground(Color.WHITE);
		iniciarSesion.setPreferredSize(new Dimension(100, 40));
		constrains.gridx = 1;
		constrains.gridy = 2;
		constrains.gridwidth = 1;
		constrains.gridheight = 1;
		constrains.anchor = GridBagConstraints.LAST_LINE_END;
		add(iniciarSesion, constrains);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("INICIAR"))
		{
			if(username.getText().isEmpty())
				JOptionPane.showMessageDialog(this, "Debe poner un usuario");
			else if(contrasenia.getPassword().length == 0)
				JOptionPane.showMessageDialog(this, "Debe poner una contraseña");
			else
			{
				char[] contra = contrasenia.getPassword();
				String contrasena = "";
				for(int k = 0; k < contra.length; k++)
				{
					contrasena += contra[k];
				}
				interfaz.inicioSesion(username.getText(), contrasena);
			}
		}
	}

}
