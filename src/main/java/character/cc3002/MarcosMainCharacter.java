package character.cc3002;

/**
 * Se creo la clase asociada al personaje Marcos la cual es hija de
 * la superclase AbstractMainCharacter
 */

public class MarcosMainCharacter extends AbstractMainCharacter {

    /** Se creo el constructor de la clase heradando la creada en la clase madre*/
    public MarcosMainCharacter( int level, int power, int defence, double hitpoints, int hitpointmax, int attackpoints) {
        super(level, power, defence, hitpoints, hitpointmax, attackpoints);
    }

    /**
     * Se sobreescribio el metodo creado en la interfaz
     * que refleja lo que pasara si Boo ataca a Marco
     * @param boo
     * vemos si boo puede atacar, si no puede no se realiza nada y
     * si puede tampoco ya que no Boo no puede atacar a marcos
     */

    @Override
    public void receivesAttackFromBoo(BooEnemyCharacter boo) {
        boo.canIattack();
        if (!boo.isIamalive()) { System.out.println("You cannot attack me"); }
        System.out.println("You cannot attack me");
    }

    /**
     * Se sobreescribio el metodo creado en la interfaz
     * que refleja lo que pasara si Spiny ataca a Marco
     * @param spiny
     * Vemos si no puede atacar, en caso contrario se calcula
     * el daño y se cambia los puntos de vida de marcos
     */

    @Override
    public void receivesAttackFromSpiny(character.cc3002.SpinyEnemycharacter spiny) {
        spiny.canIattack();
        if (!spiny.isIamalive()) { System.out.println("You cannot attack me"); }
        else { this.setHitpoints(this.getHitpoints()-(0.75* spiny.getPower()*(spiny.getLevel())/this.getDefence())); }
    }

    /**
     * Se sobreescribio el metodo creado en la interfaz
     * que refleja lo que pasara si Goomba ataca a Marco
     * @param Goomba
     * Vemos si puede atacar,en caso contrario se calcula
     * el daño y se cambia los puntos de vida de marcos
     */

    @Override
    public void receivesAttackFromGoomba(GoombaEnemyCharacter Goomba) {
        Goomba.canIattack();
        if (!Goomba.isIamalive()) { System.out.println("You cannot attack me"); }
        else { this.setHitpoints(this.getHitpoints()-(0.75* Goomba.getPower()*(Goomba.getLevel())/this.getDefence())); }
    }
}

