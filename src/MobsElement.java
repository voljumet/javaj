import javax.swing.*;

public class MobsElement extends GraphicalElement {

        int mobSize;
        int mobArmySize;
        int mobNumber;

        public MobsElement() {

                mobSize = 45;
                height = mobSize;
                width = mobSize;
                description = "MobsElement";
                i = new ImageIcon("Pictures/Icons/Iconse-01.png");
                image = i.getImage();
        }
}


