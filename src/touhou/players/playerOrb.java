package touhou.players;

import bases.GameObject;
import bases.Utils;
import bases.Vector2D;
import bases.physics.BoxCollider;
import bases.physics.PhysicsBody;

public class playerOrb extends GameObject implements PhysicsBody {
    BoxCollider boxCollider ;
    public boolean isActive ;
    public static Vector2D playerPosition;
    float distance;
    PlayerOrbShoot orb = new PlayerOrbShoot();


    public playerOrb(float distance){
        boxCollider = new BoxCollider(20,20);
        image = Utils.loadImage("assets/images/sphere/0.png");
        isActive = true;
        this.distance = distance;
    }
    public void run(){
        this.position.set(playerPosition.x + distance, playerPosition.y);
        this.boxCollider.position.set(this.position);
        System.out.println("hello");
        orb.shoot(this);
    }

    @Override
    public BoxCollider getBoxCollider() {
        return boxCollider;
    }
}
