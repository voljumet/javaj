
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.concurrent.Flow;

public class View extends JFrame {

    //    // Declaring the Java parentFrame
    static JFrame parentFrame = new JFrame("Towerdefence");

    // Declaring Jmenubar, Jmenu, and JmenuItem.
    JMenuBar menuBar;
    JMenu menu;
    JMenuItem menuNewGame, menuSave, menuExit;

    // label to display text
    static JLabel label1, label2;


    public View(){

        super("Making an internalFrame");

        // Adding parentFrame functionalities.
        parentFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        parentFrame.setLayout(new BorderLayout());
//        parentFrame.setSize(900,800);
        parentFrame.setTitle("Oil Platform Defence");
        parentFrame.setLocationRelativeTo(null);


        /* Creating the internalframe */

        // creating a new frame
        parentFrame = new JFrame("frame");
        parentFrame.setUndecorated(true);

        // setting layout of frame
        parentFrame.setLayout(new FlowLayout());

        // creating a internal frame, with borders and titlebar set to null
        JInternalFrame internalFrameButtons = new JInternalFrame(null, false, false, false, false);
        internalFrameButtons.putClientProperty("JInternalFrame.isPalette", Boolean.TRUE);
        internalFrameButtons.getRootPane().setWindowDecorationStyle(JRootPane.NONE);
        ((javax.swing.plaf.basic.BasicInternalFrameUI) internalFrameButtons.getUI()).setNorthPane(null);
        internalFrameButtons.setBorder(null);
        internalFrameButtons.setPreferredSize(new Dimension(180, 900));

        // creating game internal frame, with borders and titlebar set to null
        JInternalFrame internalFrameGame = new JInternalFrame(null, false, false, false, false);
        internalFrameGame.putClientProperty("JInternalFrame.isPalette", Boolean.TRUE);
        internalFrameGame.getRootPane().setWindowDecorationStyle(JRootPane.NONE);
        ((javax.swing.plaf.basic.BasicInternalFrameUI) internalFrameButtons.getUI()).setNorthPane(null);
//        internalFrameGame.setUI(null); // dersom du vil slette alt i internalframeGame
        internalFrameGame.setBorder(null);
        internalFrameGame.setPreferredSize(new Dimension(900, 900));

        /* End */

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
//        JButton leftButton = new JButton("Left button");
//        JButton rightButton = new JButton("Right button");


        /* InternalframeGame backgorund */
        // Adding background image
        ImageIcon imageIcon = new ImageIcon("Pictures/Background.png");
        Image image = imageIcon.getImage();
        Image newImg = image.getScaledInstance(900, 865, Image.SCALE_SMOOTH);
        imageIcon = new ImageIcon(newImg);

        JLabel background = new JLabel(imageIcon);
        rightPanel.add(background);

        // creating menu with bar and sub menu
        menuBar = new JMenuBar();
//        parentFrame.setJMenuBar(menuBar); // parentFrame to set our menubar to the parentFrame.

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
        menuSave = new JMenuItem("Save game");
        menu.add(menuSave);
        menu.addSeparator();
        menuExit = new JMenuItem("Exit Game");
        menu.add(menuExit);


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
        internalFrameButtons.add(leftPanel);
//        internalFrameButtons.setUndecorated();
        internalFrameGame.add(rightPanel);


        // adding internal frame to frame
        parentFrame.add(internalFrameButtons, BorderLayout.WEST);
        parentFrame.add(internalFrameGame, BorderLayout.EAST);


        // setting visibility internal frame
        internalFrameButtons.setVisible(true);
        internalFrameGame.setVisible(true);

        // parentFrame.setSize(400,400);
        parentFrame.setSize(1100,900);

        parentFrame.show();
        
        // Setting parentFrame visible/ not resizeable.
        parentFrame.setResizable(false);
        parentFrame.setVisible(true);

        // The popupframe to be visible after the parentFrame
        popFrame.setVisible(true);

    }
}

