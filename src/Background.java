import java.awt.*;

class Background extends View{
    Image img;

    public Background(){
        img = Toolkit.getDefaultToolkit().createImage("Pictures/Background.png");
    }
    public void paint(Graphics g){
        g.drawImage(img, 0, 0, null);
    }

//    Image img = Toolkit.getDefaultToolkit().createImage("Pictures/Background.png");

}
