package character;

import interfaces.AttackableByBoo;

/**
 * Se creo la clase asociada al personaje Luis la cual es hija de
 * la superclase AbstractMainCharacter
 */

public class LuisMainCharacter extends AbstractMainCharacter implements AttackableByBoo {


    /**
     * Se creo el constructor
     * @param level nivel
     * @param power poder
     * @param defence defensa
     * @param hitPoints puntos de vida
     * @param hitPointMax puntos de vida maximo
     * @param attackPoints puntos de ataque
     */
    public LuisMainCharacter(int level, int power, int defence, int hitPoints, int hitPointMax, int attackPoints) {
        super(level, power, defence, hitPoints, hitPointMax, attackPoints);
    }

    /**
     * Se creó una método que calcula el daño
     * provocado por Boo
     * @param Boo
     */
    @Override
    public void calculateDamageFromBoo(BooEnemyCharacter Boo) {
        double damage =  this.getHitPoints()-( 0.75* Boo.getPower()*(Boo.getLevel())/this.getDefence());
        this.setHitPoints((int) damage);
    }

    /**
     * Se creo un método que calcula el daño
     * provocado por Spiny
     * @param Spiny Spiny
     */
    @Override
    public void calculateDamageFromSpiny(SpinyEnemycharacter Spiny) {
        double damage = this.getHitPoints()-(0.75* Spiny.getPower()*(Spiny.getLevel())/this.getDefence());
        this.setHitPoints((int) damage);
    }

    /**
     * Se creó un método que calcula el daño
     * provocado por Goomba
     * @param Goomba Goomba
     */

    @Override
    public void calculateDamageFromGoomba(GoombaEnemyCharacter Goomba) {
        double damage = this.getHitPoints()-(0.75* Goomba.getPower()*(Goomba.getLevel())/this.getDefence());
        this.setHitPoints((int) damage);
    }

    /**
     * Se sobreescribio la método que recibe un ataque de Boo
     * @param boo Boo
     */



    @Override
    public void receivesAttackFromBoo(BooEnemyCharacter boo) {
        boo.canIattack();
        if (!boo.isiAmAlive() || !this.isiAmAlive() ) { this.setHitPoints(this.getHitPoints() + 0); }
        else { this.calculateDamageFromBoo(boo);}
    }

    /**
     * Se sobreescribe el método que refleja el ataque de Spiny
     * @param spiny Spiny
     */

    @Override
    public void receivesAttackFromSpiny(SpinyEnemycharacter spiny) {
        if (!spiny.isiAmAlive() || !this.isiAmAlive() ) { this.setHitPoints(this.getHitPoints() + 0); }
        else { this.calculateDamageFromSpiny(spiny);}
    }

    /**
     *Se sobreescribe el método que refleja el ataque de Gomba
     * @param Goomba Goomba
     */

    @Override
    public void receivesAttackFromGoomba(GoombaEnemyCharacter Goomba) {
        if (!Goomba.isiAmAlive() || !this.isiAmAlive() ) {this.setHitPoints(this.getHitPoints() + 0); }
        else { this.calculateDamageFromGoomba(Goomba); }
    }


}
