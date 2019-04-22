package interfaz;

import java.awt.Dimension;
import java.awt.GridBagLayout;

import javax.swing.*;

@SuppressWarnings("serial")
public class PanelHomePage extends JPanel
{
	
	public PanelHomePage () {
				
		JScrollPane panel = new JScrollPane();
		panel.setSize(new Dimension(1000, 800));
		
		JLabel lb1 = new JLabel("¿Quiénes somos?");
		JLabel lb2 = new JLabel("En OtiumJobs queremos ayudar a los estudiantes de los último semestres");
		JLabel lb3 = new JLabel("y recién egresados a conocer ofertas laborales en su carrera");
		JLabel lb4 = new JLabel("ofreciéndoles sugerencias para decidir a que trabajos aplicar y como");
		JLabel lb5 = new JLabel("pueden mejorar su perfil para conseguir el trabajo.");
		JLabel lb6 = new JLabel("Si aún no sabes en que trabajar, nosotros te ayudaremos con");
		JLabel lb7 = new JLabel("con nuestra tecnología que relaciona tus intereses personales y");
		JLabel lb8 = new JLabel("laborales con ofertas de trabajo que cumplen esas características.");
		
		panel.setViewportView(lb1);
		panel.setViewportView(lb2);
		panel.setViewportView(lb3);
		panel.setViewportView(lb4);
		panel.setViewportView(lb5);
		panel.setViewportView(lb6);
		panel.setViewportView(lb7);
		panel.setViewportView(lb8);
		
		add(panel);
		
	}
	
	
}
