import java.io.IOException;
import javax.swing.*;


public class Enemies extends GraphicalElement {
        public  Enemies() throws IOException {
                posY = 400;
                posX = 400;
                height = 100;
                width = 100;
                i = new ImageIcon("Pictures/Icons/Iconse-02.png");
                image = i.getImage();


        }
}


