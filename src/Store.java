import java.awt.*;

public class Store extends ContSetup {
    public static int shopHeight = 4;
    public static int buttonSize = 45;
    public static int cellSpace = 2;
    public static int itemIn = 4;
    public static int[] buttonID = {0, 0, 0, 0, 0};

    public Rectangle[] button = new Rectangle[shopHeight];

    public Store() {
        define();
    }

    public void click(){

    }

    public void define(){
        for (int i = 0; i < button.length; i++) {
            button[i] = new Rectangle(850,5 + ((buttonSize+cellSpace)*i),buttonSize,buttonSize);
        }
    }



    public void draw(Graphics g){
        for (int i = 0; i < button.length; i++) {

            mse = View.getMousePosition();

            if (mse != null && button[i].contains(mse)){

                g.setColor(new Color(255,255,255,80));
                g.fillRect(button[i].x,button[i].y,button[i].width,button[i].height);
            }
//            if (Controller.drawFPS){
            g.drawImage(Controller.tileset[0],button[i].x,button[i].y,button[i].width,button[i].height,null);
            g.drawImage(Controller.tileset_1[0],button[i].x + itemIn,button[i].y+ itemIn, button[i].width-(itemIn*2), button[i].height-(itemIn*2),null);
        }

    }

}
