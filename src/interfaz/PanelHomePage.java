package interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.*;

@SuppressWarnings("serial")
public class PanelHomePage extends JPanel
{
	
	public PanelHomePage () {
				
		setPreferredSize(new Dimension(1125, 800));
		setBackground(Color.WHITE);
		setLayout(new BorderLayout());
		
		JPanel panel = new JPanel();

		panel.setLayout(new GridBagLayout());
		panel.setBackground(Color.WHITE);
		panel.setPreferredSize(new Dimension(1125, 1000));
		panel.setBorder(null);
		panel.setOpaque(true);
		GridBagConstraints constrains = new GridBagConstraints();
		
		JLabel lb2 = new JLabel();
		Icon logo = new ImageIcon("./data/pageImgs/logo2.png");
		lb2.setIcon(logo);
		lb2.setPreferredSize(new Dimension(400, 250));
		constrains.gridx = 0;
		constrains.gridy = 0;
		constrains.gridwidth = 2;
		constrains.gridheight = 2;
		constrains.anchor = GridBagConstraints.PAGE_START;
		panel.add(lb2, constrains);
		
		JLabel lb1 = new JLabel("¿QUIÉNES SOMOS?");
		lb1.setFont(new Font("Arial", Font.PLAIN, 36));
		constrains.gridx = 3;
		constrains.gridy = 0;
		constrains.gridwidth = 4;
		constrains.gridheight = 1;
		constrains.anchor = GridBagConstraints.CENTER;
		panel.add(lb1, constrains);
		
		String somos = "En OtiumJobs queremos ayudar a los estudiantes de los último semestres";
		somos += " y recién egresados a conocer \nofertas laborales en su carrera";
		somos += " ofreciéndoles sugerencias para decidir a que trabajos aplicar y como";
		somos += "\npueden mejorar su perfil para conseguir el trabajo.";
		somos += "\nSi aún no sabes en que trabajar, nosotros te ayudaremos con";
		somos += " con nuestra tecnología que relaciona tus \nintereses personales y";
		somos += " laborales con ofertas de trabajo que cumplen esas características.";
		JTextArea ta1 = new JTextArea(somos);
		ta1.setFont(new Font("Arial", Font.PLAIN, 12));
		constrains.gridy = 1;
		constrains.gridwidth = 4;
		constrains.anchor= GridBagConstraints.CENTER;
		panel.add(ta1, constrains);
		
		JLabel relleno = new JLabel();
		relleno.setPreferredSize(new Dimension(1000, 50));
		constrains.gridx = 0;
		constrains.gridy = 2;
		constrains.gridwidth = 6;
		constrains.gridheight = 1;
		panel.add(relleno, constrains);
		
		JLabel lb3 = new JLabel("PERSONALIZACIÓN");
		constrains.gridx = 0;
		constrains.gridy = 3;
		constrains.gridwidth = 2;
		constrains.gridheight = 1;
		constrains.anchor = GridBagConstraints.CENTER;
		panel.add(lb3, constrains);
		
		JLabel lb4 = new JLabel("SUGERENCIAS");
		constrains.gridx = 2;
		constrains.gridy = 3;
		constrains.gridwidth = 2;
		constrains.gridheight = 1;
		constrains.anchor = GridBagConstraints.CENTER;
		panel.add(lb4, constrains);
		
		JLabel lb5 = new JLabel("PREFERENCIAS");
		constrains.gridx = 4;
		constrains.gridy = 3;
		constrains.gridwidth = 2;
		constrains.gridheight = 1;
		constrains.anchor = GridBagConstraints.CENTER;
		panel.add(lb5, constrains);
		
		JTextArea lb6 = new JTextArea("Ofertas laborales escogidas de acuerdo a tu perfil personal e \nintereses laborales");
		constrains.gridx = 0;
		constrains.gridy = 4;
		constrains.gridwidth = 2;
		constrains.gridheight = 1;
		constrains.anchor = GridBagConstraints.CENTER;
		panel.add(lb6, constrains);
		
		JTextArea lb7 = new JTextArea("De acuerdo a lo que te gusta, te damos sugerencias \nde habilidades que pueden complementar tu perfil");
		constrains.gridx = 2;
		constrains.gridy = 4;
		constrains.gridwidth = 2;
		constrains.gridheight = 1;
		constrains.anchor = GridBagConstraints.CENTER;
		panel.add(lb7, constrains);
		
		JTextArea lb8 = new JTextArea("Puedes filtrar las ofertas laborales que te presentamos \nde acuerdo a tus preferencias personales");
		constrains.gridx = 4;
		constrains.gridy = 4;
		constrains.gridwidth = 2;
		constrains.gridheight = 1;
		constrains.anchor = GridBagConstraints.CENTER;
		panel.add(lb8, constrains);
		
		JLabel relleno2 = new JLabel();
		relleno2.setPreferredSize(new Dimension(1000, 50));
		constrains.gridx = 0;
		constrains.gridy = 5;
		constrains.gridwidth = 6;
		constrains.gridheight = 1;
		panel.add(relleno2, constrains);
		
		JLabel lb9 = new JLabel("Imagen Linked Data");
		constrains.gridx = 0;
		constrains.gridy = 6;
		constrains.gridwidth = 3;
		constrains.gridheight = 1;
		constrains.anchor = GridBagConstraints.CENTER;
		panel.add(lb9, constrains);
		
		JLabel lb10 = new JLabel("Datos Enlazados");
		constrains.gridx = 0;
		constrains.gridy = 7;
		constrains.gridwidth = 3;
		constrains.gridheight = 1;
		constrains.anchor = GridBagConstraints.CENTER;
		panel.add(lb10, constrains);
		
		JTextArea lb11 = new JTextArea("Queremos relacionar los perfiles del usuario con posible ofertas laborales mediante grafos.");
		constrains.gridx = 0;
		constrains.gridy = 8;
		constrains.gridwidth = 3;
		constrains.gridheight = 1;
		constrains.anchor = GridBagConstraints.CENTER;
		panel.add(lb11, constrains);
		
		JLabel lb12 = new JLabel("Imagen Machine Learning");
		constrains.gridx = 3;
		constrains.gridy = 6;
		constrains.gridwidth = 3;
		constrains.gridheight = 1;
		constrains.anchor = GridBagConstraints.CENTER;
		panel.add(lb12, constrains);
		
		JLabel lb13 = new JLabel("Algoritmos de sugerencia");
		constrains.gridx = 3;
		constrains.gridy = 7;
		constrains.gridwidth = 3;
		constrains.gridheight = 1;
		constrains.anchor = GridBagConstraints.CENTER;
		panel.add(lb13, constrains);
		
		JTextArea lb14 = new JTextArea("Queremos hacer la sugerencia de habilidades mediante algoritmos que faciliten \nrelacionar el perfil del usuario con su carrera y las habilidades requeridas en el \nmercado laboral");
		constrains.gridx = 3;
		constrains.gridy = 8;
		constrains.gridwidth = 3;
		constrains.gridheight = 1;
		constrains.anchor = GridBagConstraints.CENTER;
		panel.add(lb14, constrains);
		
		add(panel, BorderLayout.CENTER);
		
	}
	
	
}
