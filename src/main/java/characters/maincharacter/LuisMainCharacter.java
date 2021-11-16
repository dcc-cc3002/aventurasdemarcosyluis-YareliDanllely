package characters.maincharacter;

import characters.enemies.BooEnemyCharacter;
import characters.enemies.GoombaEnemyCharacter;
import characters.enemies.SpinyEnemycharacter;
import characters.enemies.interfaces.AttackableByBoo;
import characters.enemies.interfaces.AttackableByGoomba;
import characters.enemies.interfaces.AttackableBySpiny;
import characters.maincharacter.interfaces.AttackableByLuis;
import characters.maincharacter.interfaces.AttackOfLuis;
import characters.Character;

/**
 * Se creo la clase asociada al personaje Luis la cual es hija de
 * la superclase AbstractMainCharacter
 */

public class
LuisMainCharacter
        extends AbstractMainCharacter
        implements AttackableByGoomba,AttackableBySpiny,AttackableByBoo, AttackOfLuis {

    /**
     * Se creo el constructor
     * @param level nivel
     * @param power poder
     * @param defence defensa
     * @param hitPoints puntos de vida
     * @param hitPointMax puntos de vida maximo
     * @param attackPoints puntos de ataque
     */
    public LuisMainCharacter(int level, int power, int defence, int hitPoints, int hitPointMax, int attackPoints, int attackPointsMax) {
        super(level, power, defence, hitPoints, hitPointMax, attackPoints, attackPointsMax);
    }

    @Override
    public void calculateDamageFromBoo(BooEnemyCharacter Boo) {
        double damage =  this.getHitPoints()-( 0.75* Boo.getPower()*(Boo.getLevel())/this.getDefence());
        this.setHitPoints((int) damage);
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

    @Override
    public void receivesAttackFromBoo(BooEnemyCharacter boo) {
        boo.canIattack();
        if (!boo.isiAmAlive() || !this.isiAmAlive() ) { this.setHitPoints(this.getHitPoints() + 0); }
        else { this.calculateDamageFromBoo(boo);}
    }

    @Override
    public void receivesAttackFromSpiny(SpinyEnemycharacter spiny) {
        if (!spiny.isiAmAlive() || !this.isiAmAlive() ) { this.setHitPoints(this.getHitPoints() + 0); }
        else { this.calculateDamageFromSpiny(spiny);}
    }

    @Override
    public void receivesAttackFromGoomba(GoombaEnemyCharacter Goomba) {
        if (!Goomba.isiAmAlive() || !this.isiAmAlive() ) {this.setHitPoints(this.getHitPoints() + 0); }
        else { this.calculateDamageFromGoomba(Goomba); }
    }

    @Override
    public void attackWithHammer(AttackableByLuis enemy) { enemy.receivesAttackFromLuisWithHammer(this);
    }

    @Override
    public void attackWithJump(AttackableByLuis enemy) {
        enemy.receivesAttackFromLuisWithJump(this);
    }


}



