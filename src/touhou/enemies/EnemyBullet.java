package touhou.enemies;

import bases.GameObject;
import bases.Utils;
import bases.physics.BoxCollider;
import bases.physics.Deactivated;
import touhou.backgrounds.BackGround;
import touhou.players.Player;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class EnemyBullet extends GameObject implements Deactivated {

    final int SPEED = 2;
    BoxCollider boxCollider = new BoxCollider(10,10);

    public EnemyBullet(){
        image = Utils.loadImage("assets/images/enemies/bullets/blue.png");
    }

    public void run(){
        this.boxCollider.position.set(position);
        Player player = GameObject.collideWith(this.boxCollider, Player.class);
        if(player!=null){
            Player.isActive = false;
            GameObject.gameOver = true;
            stop();
        }

        position.addUp(0,SPEED);
        deactivate();
    }

    @Override
    public void deactivate() {
        if(this.position.y - this.image.getHeight()/2 > 800){
            this.isActive = false;
        }
    }
}
