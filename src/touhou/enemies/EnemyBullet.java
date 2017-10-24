package touhou.enemies;

import bases.GameObject;
import bases.Utils;
import bases.physics.BoxCollider;
import touhou.players.Player;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class EnemyBullet extends GameObject {

    final int SPEED = 2;
    BoxCollider boxCollider = new BoxCollider(10,10);

    public EnemyBullet(float xCoor, float yCoor){
        image = Utils.loadImage("assets/images/enemies/bullets/blue.png");
        position.set(xCoor,yCoor);
    }

    public void run(){
        this.boxCollider.position.set(position);
        if(Player.playerHit(this.boxCollider)){
            GameObject.gameOver = true;
            stop();
        }

        position.addUp(0,SPEED);
    }

}
