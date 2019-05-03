import java.awt.*;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.Vector;

public class Ammo {




    /**
     * Making bullets
     * Ideas - Use point2D to get the distance
     */

    public Shape bulletLine = null; // shape of bullet
    public boolean bulletCollision = false; // boolean to check if bullet hits or not!
    public int bulletCount = 0; // count for the amount of bullets shot
    public float bulletSpeed = 10; // speed of the bullet shot from Tower


    Vector xVector; // x Vector
    Vector yVector; // y Vector
    Vector targetSpot; // spot of the target


    float enemyPosX; // floating enemy x position
    float enemyPosY; // floating enemy y position

    public float bulletRange;

    Vector TowerPos = new Vector(); // vector for tower
    Vector EnemyPos = new Vector(); // vector for Enemy
    ArrayList<Ammo>bullets = new ArrayList<>();

    float towerAttackRadius;


    public void Bullets(){

    }

    class Bullet{
        float bullStartX = 0;
        float bullStartY = 0;

    }

    public double towerAttackRadius(Point2D point2Dt){
        return towerAttackRadius;
    }
}
