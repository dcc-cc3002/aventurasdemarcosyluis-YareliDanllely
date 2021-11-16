package characters.maincharacter;

import characters.enemies.GoombaEnemyCharacter;
import characters.enemies.SpinyEnemycharacter;
import characters.enemies.interfaces.AttackableByGoomba;
import characters.enemies.interfaces.AttackableBySpiny;
import characters.maincharacter.interfaces.AttackablebyMarco;
import characters.maincharacter.interfaces.AttackOfMarco;


/**
 * Se creo la clase asociada al personaje Marcos la cual es hija de
 * la superclase AbstractMainCharacter
 */

public class MarcosMainCharacter extends AbstractMainCharacter implements AttackOfMarco, AttackableBySpiny, AttackableByGoomba {

    /** Se creo el constructor de la clase heradando la creada en la clase madre*/
    public MarcosMainCharacter( int level, int power, int defence, int hitPoints, int hitPointMax, int attackpoints, int attackPointsMax) {
        super(level, power, defence, hitPoints, hitPointMax, attackpoints, attackPointsMax);
    }


    @Override
    public void calculateDamageFromSpiny(SpinyEnemycharacter Spiny) {
        double damage = this.getHitPoints()-(0.75* Spiny.getPower()*(Spiny.getLevel())/this.getDefence());
        this.setHitPoints((int) damage);
    }

    @Override
    public void calculateDamageFromGoomba(GoombaEnemyCharacter Goomba) {
        double damage = this.getHitPoints()-(0.75* Goomba.getPower()*(Goomba.getLevel())/this.getDefence());
        this.setHitPoints((int) damage);
    }


    public void receivesAttackFromSpiny(SpinyEnemycharacter spiny) {
        if (!spiny.isiAmAlive() || !this.isiAmAlive() ) { this.setHitPoints(this.getHitPoints() + 0); }
        else { calculateDamageFromSpiny(spiny); }
    }


    @Override
    public void receivesAttackFromGoomba(GoombaEnemyCharacter Goomba) {
        if (!Goomba.isiAmAlive() || !this.isiAmAlive() ) { this.setHitPoints(this.getHitPoints() + 0);}
        else { calculateDamageFromGoomba(Goomba); }
    }

    @Override
    public void attackWithHammer(AttackablebyMarco enemy) { enemy.receivesAttackFromMarcoWithHammer(this);}

    @Override
    public void attackWithJump(AttackablebyMarco enemy) { enemy.receivesAttackFromMarcoWithJump(this);}

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }


}

