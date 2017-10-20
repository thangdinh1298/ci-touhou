package touhou;

import bases.GameObject;
import bases.Utils;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Player extends GameObject {


    boolean rightPressed;
    boolean leftPressed;
    boolean downPressed;
    boolean upPressed;
    boolean xPressed;

    boolean spellDisabled = false;
    final int COOLDOWNTIME = 10; // frames


    final int SPEED = 5;
    final int LEFT = 0;
    final int RIGHT = 352;
    final int TOP = 0;
    final int BOTTOM = 500;

    public Player(){
        image = Utils.loadImage("assets/images/players/straight/0.png");
        x = 182;
        y = 500;
    }

    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_RIGHT){
            rightPressed = true;
        }
        if(e.getKeyCode() == KeyEvent.VK_LEFT){
            leftPressed = true;
        }
        if(e.getKeyCode() == KeyEvent.VK_UP){
            upPressed = true;
        }
        if(e.getKeyCode() == KeyEvent.VK_DOWN){
            downPressed = true;
        }
        if(e.getKeyCode() == KeyEvent.VK_X){
            xPressed = true;
        }

    }

    public void keyReleased(KeyEvent e) {

        if(e.getKeyCode() == KeyEvent.VK_RIGHT){
            rightPressed = false;
        }
        if(e.getKeyCode() == KeyEvent.VK_LEFT){
            leftPressed = false;
        }
        if(e.getKeyCode() == KeyEvent.VK_UP){
            upPressed = false;
        }
        if(e.getKeyCode() == KeyEvent.VK_DOWN){
            downPressed = false;
        }
        if(e.getKeyCode() == KeyEvent.VK_X){
            xPressed = false;
        }
    }

    public void run(){

        move();
        shoot();
    }

    private void move() {
        int vx = 0;
        int vy = 0;

        if(rightPressed ){
            vx += SPEED;
        }
        if(leftPressed ){
            vx -= SPEED;
        }
        if(upPressed){
            vy -= SPEED;
        }
        if(downPressed){
            vy += SPEED;
        }

        x = x + vx;
        y = y + vy;

        x = (int) Utils.clamp(x, LEFT, RIGHT);
        y = (int) Utils.clamp(y, TOP, BOTTOM);
    }

    int coolDownCount = 0;
    public void shoot(){
        if(spellDisabled){
            coolDownCount++;
            if(coolDownCount >= COOLDOWNTIME){
                spellDisabled = false;
                coolDownCount = 0;
            }
            return;
        }

        if (xPressed) {
            Spell newSpell = new Spell();
            newSpell.x = x;
            newSpell.y = y;

            GameObject.add(newSpell);

            spellDisabled = true;
        }
    }

}
