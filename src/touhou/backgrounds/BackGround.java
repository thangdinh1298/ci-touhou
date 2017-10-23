package touhou.backgrounds;

import bases.GameObject;
import bases.Utils;

import java.awt.*;
import java.awt.image.BufferedImage;

public class BackGround extends GameObject {
    public BackGround(){
        image  = Utils.loadImage("assets/images/background/0.png");
        this.position.set(0,0);
    }

    @Override
    public void render(Graphics g) {
        if(!gameOver){
            loadImage(g);
        }
        else {
            image = Utils.loadImage("assets/images/scenes/game-over-background.jpg");
            loadImage(g);
        }
    }
    public void loadImage(Graphics g){
        if(image != null){
            g.drawImage(
                    image,
                    (int) position.x ,
                    (int) position.y ,
                    null);
        }
    }
}
