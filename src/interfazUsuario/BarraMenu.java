
package interfazUsuario;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import interfaz.Interfaz;

/**
 * Esta es la clase donde est� definido el men� de la aplicaci�n
 */
public class BarraMenu extends JMenuBar implements ActionListener
{
    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
     * Es el comando de la opci�n Iniciar Juego
     */
    private static final String INICIAR_JUEGO = "IniciarJuego";

    /**
     * Es el comando de la opci�n Salir
     */
    private static final String SALIR = "salir";

    /**
     * Es el comando de la opci�n 1
     */
    private static final String OPCION_1 = "Opcion1";

    /**
     * Es el comando de la opci�n 2
     */
    private static final String OPCION_2 = "Opcion2";

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Es una referencia a la clase principal de la interfaz del cliente
     */
    private InterfazUsuario principal;

    // -----------------------------------------------------------------
    // Atributos de la Interfaz
    // -----------------------------------------------------------------

    /**
     * Es el men� Inicio del juego
     */
    private JMenu menuInicio;

    /**
     * Es la opci�n Iniciar Juego del men� Inicio
     */
    private JMenuItem itemIniciarJuego;

    /**
     * Es la opci�n Salir del men� Inicio
     */
    private JMenuItem itemSalir;


    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Construye el men� para la aplicaci�n de Batalla Naval
     * @param ventanaPrincipal Es una referencia a la ventana principal del cliente
     */
    public BarraMenu( InterfazUsuario ventanaPrincipal )
    {
        principal = ventanaPrincipal;

        menuInicio = new JMenu( "Inicio" );
        add( menuInicio );

        itemIniciarJuego = new JMenuItem( "Iniciar Juego" );
        itemIniciarJuego.setActionCommand( INICIAR_JUEGO );
        itemIniciarJuego.addActionListener( this );
        menuInicio.add( itemIniciarJuego );

        itemSalir = new JMenuItem( "Salir" );
        itemSalir.setActionCommand( SALIR );
        itemSalir.addActionListener( this );
        menuInicio.add( itemSalir );
        
        
    }

    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------

    /**
     * Ejecuta una acci�n seg�n la opci�n del men� que haya sido seleccionada
     * @param evento El evento de click en una opci�n
     */
    public void actionPerformed( ActionEvent evento )
    {
        String comando = evento.getActionCommand( );

        if( SALIR.equals( comando ) )
        {
            principal.dispose( );
        }
        
    }

}
