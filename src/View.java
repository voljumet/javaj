
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.concurrent.Flow;

public class View extends JFrame {
    

    // Declaring Jmenubar, Jmenu, and JmenuItem.
    JMenuBar menuBar;
    JMenu menu;
    JMenuItem menuNewGame, menuSave, menuExit;

    // label to display text
    static JLabel label1, label2;



    public View(){


        // Adding parentFrame functionalities.
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout(0,0));

        this.setTitle("Oil Platform Defence");
        this.setLocationRelativeTo(null);


        /* Creating the internalframe */
//        parentFrame.setUndecorated(true);


        // creating a label to display text
        label1 = new JLabel();
        label2 = new JLabel();

        // creating a panel
        JPanel leftPanel = new JPanel();
        JPanel rightPanel = new JPanel();

        // adding label and button
        leftPanel.add(label1);
//        leftPanel.add(leftButton);

        // panel2
        rightPanel.add(label2);
//        rightPanel.add(rightButton);


        // creating buttons
        JButton newButton = new JButton("New Game");
        JButton saveButton = new JButton("Save Game");
        JButton exitButton = new JButton("Exit Game");

        //Adding the buttons to the left panel
        leftPanel.add(newButton);
        leftPanel.add(saveButton);
        leftPanel.add(exitButton);


        /* InternalframeGame backgorund */
        // Adding background image
        ImageIcon imageIcon = new ImageIcon("Pictures/Background.png");
        Image image = imageIcon.getImage();
        Image newImg = image.getScaledInstance(900, 900, Image.SCALE_SMOOTH);
        imageIcon = new ImageIcon(newImg);

        JLabel background = new JLabel(imageIcon);
        rightPanel.add(background);

//        // creating menu with bar and sub menu
//        menuBar = new JMenuBar();
////        parentFrame.setJMenuBar(menuBar); // parentFrame to set our menubar to the parentFrame.
//
//        // menu naming, and functionality
//        menu = new JMenu("Game");
//        menu.setMnemonic(KeyEvent.VK_A);
//        menu.getAccessibleContext().setAccessibleDescription("menuPackage.Menu description"); // menu to be accessible ...
//
//        // Adding menu to the menuBar
//        menuBar.add(menu);
//
//        // Adding menuitems in the submenu
//        menuNewGame = new JMenuItem("New Game");
//        menu.add(menuNewGame);
//        menu.addSeparator();
//        menuSave = new JMenuItem("Save game");
//        menu.add(menuSave);
//        menu.addSeparator();
//        menuExit = new JMenuItem("Exit Game");
//        menu.add(menuExit);


        //Defining new popup parentFrame
        final JFrame popFrame;

        //Menu
        final JPopupMenu popupMenu;

        JMenuItem popupItem1;
        JMenuItem popupItem2;
        JMenuItem popupItem3;

        popupItem1 = new JMenuItem("New Game");
        popupItem2 = new JMenuItem("Save Game");
        popupItem3 = new JMenuItem("Exit");


        /*JpopupMenu*/
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

        /* JpopupMenu */


        // adding panel to internal frame

        this.setBackground(Color.white);
        rightPanel.setSize(900,900);
        rightPanel.setBackground(Color.cyan);
        leftPanel.setBackground(Color.red);
        this.add(leftPanel, BorderLayout.WEST);
        this.add(rightPanel, BorderLayout.EAST);


        // parentFrame.setSize(400,400);
        this.setSize(1200,900);

        this.show();
        
        // Setting parentFrame visible/ not resizeable.
        this.setResizable(false);
        this.setVisible(true);

        // The popupframe to be visible after the parentFrame
//        popFrame.setVisible(true);

    }
}

/*=================================================================================*/



/*=================================================================================*/
