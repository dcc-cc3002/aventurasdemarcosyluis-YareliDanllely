package character;

/**
 * Se creo la clase asociada al personaje Marcos la cual es hija de
 * la superclase AbstractMainCharacter
 */

public class MarcosMainCharacter extends AbstractMainCharacter {

    /** Se creo el constructor de la clase heradando la creada en la clase madre*/
    public MarcosMainCharacter( int level, int power, int defence, int hitPoints, int hitPointMax, int attackpoints) {
        super(level, power, defence, hitPoints, hitPointMax, attackpoints);
    }

    /**
     * Se creó un método que cañciña el
     * daño que realiza Spiny
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
     * Se sobreescribio el metodo creado en la interfaz
     * que refleja lo que pasara si Spiny ataca a Marco
     * @param spiny
     */


    public void receivesAttackFromSpiny(SpinyEnemycharacter spiny) {
        if (!spiny.isiAmAlive() || !this.isiAmAlive() ) { this.setHitPoints(this.getHitPoints() + 0); }
        else { calculateDamageFromSpiny(spiny); }
    }

    /**
     * Se sobreescribio el metodo creado en la interfaz
     * que refleja lo que pasara si Goomba ataca a Marco
     * @param Goomba
     */

    @Override
    public void receivesAttackFromGoomba(GoombaEnemyCharacter Goomba) {
        if (!Goomba.isiAmAlive() || !this.isiAmAlive() ) { this.setHitPoints(this.getHitPoints() + 0);}
        else { calculateDamageFromGoomba(Goomba); }
    }

}

