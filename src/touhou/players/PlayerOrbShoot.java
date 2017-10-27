package touhou.players;

import bases.GameObject;
import touhou.inputs.InputManager;

public class PlayerOrbShoot {
    int coolDownCount = 0;
    boolean spellDisabled = false;
    final int COOLDOWNTIME = 10;
    public void shoot(playerOrb owner){
        if(spellDisabled){
            coolDownCount++;
            if(coolDownCount >= COOLDOWNTIME){
                spellDisabled = false;
                coolDownCount = 0;
            }
            return;
        }
        if(InputManager.instance.xPressed){
            Spell newSpell = GameObject.recycle(Spell.class);
            newSpell.position.set(owner.position);
            spellDisabled = true;
        }
    }
}
