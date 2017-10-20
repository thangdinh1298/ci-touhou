package touhou;

import bases.Utils;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class EnemyBullet {
    int x = Boss.x + 17 ;
    int y = Boss.y + 50;
    BufferedImage image;

    final int SPEED = 2;

    public EnemyBullet(){
        image = Utils.loadImage("assets/images/enemies/bullets/blue.png");
    }
    public static void createBullet(ArrayList<EnemyBullet> enemyBullets){
        EnemyBullet bullet = new EnemyBullet();
        enemyBullets.add(bullet);
    }

    public void run(){
        y += SPEED;
    }
    public void render(Graphics g){
        g.drawImage(image, x,y, null);
    }
}
