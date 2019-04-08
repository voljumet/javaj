
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class View extends JFrame {

//    Menu menu;
//    BackgroundImage backgroundImage;

    //    // Declaring the Java frame
    JFrame frame = new JFrame();
    // Declaring Jmenubar, Jmenu, and JmenuItem.
    JMenuBar menuBar;
    JMenu menu;
    JMenuItem menuNewGame, menuSave, menuExit;


    public View(){

//        menu = new Menu();
//        backgroundImage = new BackgroundImage();

        // Adding frame functionalities.
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.setSize(900,800);
        frame.setTitle("Oil Platform Defence");
        frame.setLocationRelativeTo(null);

        // Adding background image
        ImageIcon imageIcon = new ImageIcon("Pictures/Background.png");
        Image image = imageIcon.getImage();
        Image newImg = image.getScaledInstance(900, 800, Image.SCALE_SMOOTH);
        imageIcon = new ImageIcon(newImg);

        JLabel background = new JLabel(imageIcon);
        frame.add(background);


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



        //Defining new popup frame
        final JFrame popFrame;

        //Menu
        final JPopupMenu popupMenu;

        JMenuItem popupItem1;
        JMenuItem popupItem2;
        JMenuItem popupItem3;

        popupItem1 = new JMenuItem("New Game");
        popupItem2 = new JMenuItem("Save Game");
        popupItem3 = new JMenuItem("Exit");


        // Jpopupmenu
        popFrame = new JFrame();
        popupMenu = new JPopupMenu();

        popupMenu.add(popupItem1);
        popupMenu.add(popupItem2);
        popupMenu.add(popupItem3);


        popFrame.setBackground(Color.LIGHT_GRAY);
        popFrame.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                popupMenu.show(popFrame , e.getX(), e.getY());

            }
        });

        popFrame.add(popupMenu);
        popFrame.setSize(300,300);
        popFrame.setLayout(null);
        popFrame.setLocationRelativeTo(null);


        // Setting frame visible/ not resizeable.
        frame.setResizable(false);
        frame.setVisible(true);

        // The popupframe to be visible after the frame
        popFrame.setVisible(true);

    }
}

