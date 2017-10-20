package touhou;

import bases.GameObject;
import bases.Utils;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Spell extends GameObject {

    final int SPEED = 10;

    public Spell(){
        image = Utils.loadImage("assets/images/player-bullets/a/0.png");
    }
    public void run(){
        y -= SPEED;
    }

}
