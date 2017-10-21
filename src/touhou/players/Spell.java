package touhou.players;

import bases.GameObject;
import bases.Utils;
import bases.physics.BoxCollider;
import touhou.enemies.Boss;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Spell extends GameObject {

    final int SPEED = 10;
    public BoxCollider boxCollider;

    public Spell(){
        image = Utils.loadImage("assets/images/player-bullets/a/0.png");
        boxCollider = new BoxCollider(20,20);
    }
    public void run(){
        position.y -= SPEED;
        boxCollider.position.set(this.position);
        Boss boss = GameObject.collideWith(this.boxCollider);
        if(boss != null){
            System.out.println("Hit");
            boss.getHit();
            this.isActive = false;
        }
    }

}
