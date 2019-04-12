import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;


public class View extends JFrame{


    JMenuBar menuBar;
    JMenu menu;
    JMenuItem menuNewGame, menuSave, menuExit;
    public JPanel background;

//    // Declaring the Java frame
//    JFrame frame = new JFrame();

    public View(){
        // Adding frame functionalities.
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        this.setSize(900,900);
        this.setTitle("Oil Platform Defence");
        this.setLocationRelativeTo(null);

        // creating menu with bar and sub menu
        menuBar = new JMenuBar();
        this.setJMenuBar(menuBar); // frame to set our menubar to the frame.

        // menu naming, and functionality
        menu = new JMenu("Game");
        menu.setMnemonic(KeyEvent.VK_A);
        menu.getAccessibleContext().setAccessibleDescription("menuPackage.Menu description"); // menu to be accessible ...

        // Adding menu to the menuBar
        menuBar.add(menu);

        // Adding menuitems in the submenu
        menuNewGame = new JMenuItem("New Game");
        menu.add(menuNewGame);
        menu.addSeparator();
        menuExit = new JMenuItem("Exit Game");
        menu.add(menuExit);

        background = new JPanel();
        this.add(background);

        // Setting frame visible/ not resizeable.

        this.setResizable(false);
        this.setVisible(true);

        menu = new JMenu();


    }
}

