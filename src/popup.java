//import javax.management.remote.JMXConnectionNotification;
//import javax.swing.*;
//import javax.swing.border.EmptyBorder;
//import java.awt.*;
//import java.awt.event.*;
//
//public class popup {
//
//
//    public popup(){
//
//
//        /*JpopupMenu*/
//
//        //Defining new popup parentFrame
//        final Frame popFrame = new JFrame();;
//        //Menu
//        final JPopupMenu popupMenu = new JPopupMenu();
//
//
//        JPanel buttonpanel = new JPanel();
//        BoxLayout boxLayout = new BoxLayout(buttonpanel, BoxLayout.Y_AXIS);
//        buttonpanel.setLayout(boxLayout);
//        buttonpanel.setBorder(new EmptyBorder(new Insets(100,100,100,100)));
//
//
//
//        JButton newG = new JButton("New game");
//        newG.setMnemonic(KeyEvent.VK_P);
//        newG.getAccessibleContext().setAccessibleDescription("New game");
//        newG.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                JOptionPane.showMessageDialog(popFrame, "New game clicked!");
//            }
//        });
//        popupMenu.add(newG);
//
//
//        JButton contin = new JButton("Continue");
//        newG.setMnemonic(KeyEvent.VK_P);
//        newG.getAccessibleContext().setAccessibleDescription("Continue");
//        contin.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                JOptionPane.showMessageDialog(popFrame, "continue clicked!");
//            }
//        });
//        popupMenu.add(contin);
//
//
//        JButton save = new JButton("Save game");
//        newG.setMnemonic(KeyEvent.VK_P);
//        newG.getAccessibleContext().setAccessibleDescription("Save game");
//        save.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                JOptionPane.showMessageDialog(popFrame, "Save game clicked!");
//            }
//        });
//        popupMenu.add(save);
//
//
//        JButton hScore = new JButton("High score");
//        newG.setMnemonic(KeyEvent.VK_P);
//        newG.getAccessibleContext().setAccessibleDescription("High score");
//        hScore.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                JOptionPane.showMessageDialog(popFrame, "high score clicked!");
//            }
//        });
//        popupMenu.add(hScore);
//
//
//        JButton exit = new JButton("Exit");
//        newG.setMnemonic(KeyEvent.VK_P);
//        newG.getAccessibleContext().setAccessibleDescription("Exit");
//        exit.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                JOptionPane.showMessageDialog(popFrame, "exit clicked!");
//            }
//        });
//        popupMenu.add(exit);
//
//
////        popFrame.addMouseListener(new MouseAdapter() {
////
////            @Override
////            public void mouseClicked(MouseEvent e) {
////
////                    super.mouseClicked(e);
////                    popupMenu.show(popFrame, e.getX(), e.getY());
////
////
////            }
////
////        });
//
//
//
////        buttonpanel.add(popupMenu);
//
//        popFrame.setSize(300,300);
//        popFrame.setLocationRelativeTo(null);
//        popFrame.setUndecorated(true);
//
//
////        // The popupframe to be visible after the parentFrame in class View
////        popFrame.show();
//        popFrame.setVisible(true);
//    }
//
//}
//

