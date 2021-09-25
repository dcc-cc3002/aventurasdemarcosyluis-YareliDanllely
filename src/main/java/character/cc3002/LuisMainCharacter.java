package character.cc3002;

/**
 * Se creo la clase asociada al personaje Luis la cual es hija de
 * la superclase AbstractMainCharacter
 */

public class LuisMainCharacter extends AbstractMainCharacter {


    /**
     * Se creo el constructor
     * @param level nivel
     * @param power poder
     * @param defence defensa
     * @param hitpoints puntos de vida
     * @param hitpointmax puntos de vida maximo
     * @param attackpoints puntos de ataque
     */
    public LuisMainCharacter(int level, int power, int defence, double hitpoints, int hitpointmax, int attackpoints) {
        super(level, power, defence, hitpoints, hitpointmax, attackpoints);
    }


    /**
     * Se sobreescribio la funcion que recibe un ataque de Boo
     * @param boo
     * Si no puede atacar no se realiza nada en caso contrario se calcula el daño que
     * recibe luis y se cambia los puntos de vida
     */

    @Override
    public void receivesAttackFromBoo(BooEnemyCharacter boo) {
        boo.canIattack();
        if (!boo.isIamalive()) { System.out.println("You cannot attack me"); }
        else { this.setHitpoints(this.getHitpoints()-( 0.75* boo.getPower()*(boo.getLevel())/this.getDefence())); }
    }

    /**
     * Se sobreescribe el metodo que refleja el ataque de Spiny
     * @param spiny
     * Si no puede atacar no se realiza nada en caso contrario se calcula el daño que
     * recibe luis y se cambia los puntos de vida
     */

    @Override
    public void receivesAttackFromSpiny(SpinyEnemycharacter spiny) {
        spiny.canIattack();
        if (!spiny.isIamalive()) { System.out.println("You cannot attack me"); }
        else { this.setHitpoints(this.getHitpoints()-(0.75* spiny.getPower()*(spiny.getLevel())/this.getDefence())); }
    }

    /**
     *Se sobreescribe el metodo que refleja el ataque de Gomba
     * @param Goomba
     * Si no puede atacar no se realiza nada en caso contrario se calcula el daño que
     * recibe luis y se cambia los puntos de vida
     */

    @Override
    public void receivesAttackFromGoomba(GoombaEnemyCharacter Goomba) {
        Goomba.canIattack();
        if (!Goomba.isIamalive()) { System.out.println("You cannot attack me"); }
        else { this.setHitpoints(this.getHitpoints()-(0.75* Goomba.getPower()*(Goomba.getLevel())/this.getDefence())); }
    }


}
