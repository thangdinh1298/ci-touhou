package touhou.enemies;

import bases.GameObject;
import bases.Utils;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class EnemyBullet extends GameObject {

    final int SPEED = 2;

    public EnemyBullet(float xCoor, float yCoor){
        image = Utils.loadImage("assets/images/enemies/bullets/blue.png");
        position.set(xCoor,yCoor);
    }

    public void run(){
        position.y += SPEED;
    }

}
