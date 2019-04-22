
package interfazUsuario;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import interfaz.Interfaz;

/**
 * Esta es la clase donde está definido el menú de la aplicación
 */
public class BarraMenu extends JMenuBar implements ActionListener
{
    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
     * Es el comando de la opción Iniciar Juego
     */
    private static final String INICIAR_JUEGO = "IniciarJuego";

    /**
     * Es el comando de la opción Salir
     */
    private static final String SALIR = "salir";

    /**
     * Es el comando de la opción 1
     */
    private static final String OPCION_1 = "Opcion1";

    /**
     * Es el comando de la opción 2
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
     * Es el menú Inicio del juego
     */
    private JMenu menuInicio;

    /**
     * Es la opción Iniciar Juego del menú Inicio
     */
    private JMenuItem itemIniciarJuego;

    /**
     * Es la opción Salir del menú Inicio
     */
    private JMenuItem itemSalir;


    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Construye el menú para la aplicación de Batalla Naval
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
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Ejecuta una acción según la opción del menú que haya sido seleccionada
     * @param evento El evento de click en una opción
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
