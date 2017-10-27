package touhou.enemies;

import bases.GameObject;
import bases.physics.BoxCollider;
import touhou.players.Player;

public class PlayerDamage {
    public void run(Boss owner){
        BoxCollider boxCollider = owner.getBoxCollider();
        Player player = GameObject.collideWith(boxCollider, Player.class);
        if(player!=null){
            Player.isActive = false;
            GameObject.gameOver = true;
            GameObject.stop();
        }
    }
}
