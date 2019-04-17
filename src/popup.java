import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class popup {

    public popup(){


        //Defining new popup parentFrame
        JFrame popFrame;

        //Menu
        final JPopupMenu popupMenu;

        View view = new View();


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
                popupMenu.show(popFrame, e.getX(), e.getY());

            }
        });


        popFrame.add(popupMenu);
        popFrame.setSize(300,300);
        popFrame.setLayout(null);
        popFrame.setLocationRelativeTo(null);

        /* JpopupMenu */


//        // The popupframe to be visible after the parentFrame
        popFrame.setVisible(true);
    }
}