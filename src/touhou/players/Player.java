package touhou.players;

import bases.GameObject;
import bases.Utils;
import bases.Vector2D;

import java.awt.event.KeyEvent;

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
    final int RIGHT = 384;
    final int TOP = 0;
    final int BOTTOM = 552;

    public Player(){
        image = Utils.loadImage("assets/images/players/straight/0.png");
        position.x = 182;
        position.y = 500;
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

    Vector2D velocity = new Vector2D();

    private void move() {
        velocity.set(0,0);

        if(rightPressed ){
            velocity.x += SPEED;
        }
        if(leftPressed ){
            velocity.x -= SPEED;
        }
        if(upPressed){
            velocity.y -= SPEED;
        }
        if(downPressed){
            velocity.y += SPEED;
        }

        position.addUp(velocity);


        position.x = (int) Utils.clamp(position.x, LEFT, RIGHT);
        position.y = (int) Utils.clamp(position.y, TOP, BOTTOM);
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
            newSpell.position.set(this.position.add(0,-24));

            GameObject.add(newSpell);

            spellDisabled = true;
        }
    }

}
