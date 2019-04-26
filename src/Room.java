//public class Room {
//    public int worldWidth = 13;//antall blokker i bredden
//    public int worldHeight = 12; //antall blokker i høyden
//    public int blockSize = 52; //størrelsen på hver firkant av mappet
//
//    public Block[][] block;
//
//    public Room() {
//        define();
//    }
//
//    public void define(){
//        block = new Block[worldHeight][worldWidth];
//
//        for (int y = 0; y <block.length; y++) {
//            for (int x = 0; x < block[0].length; x++) {
//                block[y][x] = new Block((Screen.myWidth/2) - ((worldWidth*blockSize)/2)+(x*blockSize), y*blockSize, blockSize,blockSize, 0,-1);
//
//            }
//        }
//    }
//
//}
