package touhou.players;


import bases.GameObject;
import bases.Vector2D;
import touhou.inputs.InputManager;

public class PlayerCastSpell {


    int coolDownCount = 0;
    boolean spellDisabled = false;
    final int COOLDOWNTIME = 10;
    public void run(Player owner){
        if(spellDisabled){
            coolDownCount++;
            if(coolDownCount >= COOLDOWNTIME){
                spellDisabled = false;
                coolDownCount = 0;
            }
            return;
        }

        if (InputManager.instance.xPressed) {
            Spell newSpell = GameObject.recycle(Spell.class);
            newSpell.position.set(owner.position.x,owner.position.y -24);
            spellDisabled = true;
        }

    }
}
