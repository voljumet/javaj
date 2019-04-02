package menuPackage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class Menu extends JFrame{

//    // Declaring the Java frame
    JFrame frame = new JFrame();

    // Declaring Jmenubar, Jmenu, and JmenuItem.
    JMenuBar menuBar;
    JMenu menu;
    JMenuItem menuNewGame, menuSave, menuExit;

    public Menu(){

        // Adding frame functionalities.
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.setSize(900,800);
        frame.setTitle("Oil Platform Defence");
        frame.setLocationRelativeTo(null);


        // creating menu with bar and sub menu
        menuBar = new JMenuBar();
        frame.setJMenuBar(menuBar); // frame to set our menubar to the frame.

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

        // Adding background image
        ImageIcon imageIcon = new ImageIcon("Pictures/Background.png");
        Image image = imageIcon.getImage();
        Image newimg = image.getScaledInstance(900, 800, Image.SCALE_SMOOTH);
        imageIcon = new ImageIcon(newimg);

        JLabel background = new JLabel(imageIcon);
        frame.add(background);


        // Setting frame visible/ not resizeable.
        frame.setResizable(false);
        frame.setVisible(true);

    }
}
