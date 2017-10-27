package touhou.players;

import bases.GameObject;
import bases.Utils;
import bases.Vector2D;
import bases.physics.BoxCollider;
import bases.physics.PhysicsBody;
import touhou.inputs.InputManager;

import java.awt.event.KeyEvent;

public class Player extends GameObject implements PhysicsBody {

    public static boolean isActive;

    PlayerCastSpell playerCastSpell;


    final int SPEED = 5;
    final int LEFT = 0;
    final int RIGHT = 384;
    final int TOP = 0;
    final int BOTTOM = 552;


    public static BoxCollider boxCollider = new BoxCollider(10,10);

    public Player(){
        image = Utils.loadImage("assets/images/players/straight/0.png");
        position.x = 182;
        position.y = 500;
        boxCollider.position.set(this.position);
        isActive = true;

        playerCastSpell = new PlayerCastSpell();
    }



    public void run(){
        move();
        playerCastSpell.run(this);
    }

    Vector2D velocity = new Vector2D();

    private void move() {
        velocity.set(0,0);

        InputManager inputManager = InputManager.instance;

        if(inputManager.rightPressed){
            velocity.x += SPEED;
        }
        if(inputManager.leftPressed ){
            velocity.x -= SPEED;
        }
        if(inputManager.upPressed){
            velocity.y -= SPEED;
        }
        if(inputManager.downPressed){
            velocity.y += SPEED;
        }

        position.addUp(velocity);

        boxCollider.position.set(this.position);
        position.x = (int) Utils.clamp(position.x, LEFT, RIGHT);
        position.y = (int) Utils.clamp(position.y, TOP, BOTTOM);
    }



//    public static boolean playerHit(BoxCollider boxCollider){
//        if(Player.boxCollider.collideWith(boxCollider)){
//            Player.isActive = false;
//            return true;
//        }
//        return false;
//    }

    @Override
    public BoxCollider getBoxCollider() {
        return boxCollider;
    }
}
