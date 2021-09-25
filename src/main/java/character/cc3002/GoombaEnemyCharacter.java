package character.cc3002;

/***
 * Se creo la clase Goombra que se exiente a la clase AbstractEnemy
 */

public class GoombaEnemyCharacter extends AbstractEnemyCharacter{

    /**
     * Se crea el constructor
     * @param level nivel
     * @param power poder
     * @param defence defensa
     * @param hitpoints puntos de vida
     * @param hitpointmax puntos de vida maxima
     */

    public GoombaEnemyCharacter(int level, int power, int defence, int hitpoints, int hitpointmax) {
        super(level, power, defence, hitpoints, hitpointmax);
    }

    /**
     * Se crea un metodo que recibe ataque de marcos
     * @param marco personaje
     * @param attack ataque
     * vemos si marcos puede atacar, en caso de que no pueda no se realiza nada. Por el contrario
     * se calcula el daño que se la inflige segun el tipo de ataque y se cambia.
     */
    @Override
    public void receivesAttackFromMarcos(MarcosMainCharacter marco, MainCharacterAttack attack) {
        marco.canIattack();
        if (!marco.isIamalive()) { System.out.println("You cannot attack me"); }
        else{
            if (attack.equals(MainCharacterAttack.Hammer)){ this.setHitpoints( this.getHitpoints() - (1.5 * (marco.getPower()) * (marco.getLevel()) / this.getDefence())); }}
           if (attack.equals(MainCharacterAttack.Jump)){ this.setHitpoints( this.getHitpoints() - ( marco.getPower() * (marco.getLevel()) / this.getDefence())); }
    }

    /**
     * Se crea un metodo que recibe ataque de luis
     * @param luis personaje
     * @param attack ataque
     * vemos si luis puede atacar , en caso de que no pueda no se realiza nada. Por el contrario
     * se calcula el daño que se la inflige segun el tipo de ataque y se cambia.
     */


    @Override
    public void receivesAttackFromLuis(LuisMainCharacter luis, MainCharacterAttack attack) {
        luis.canIattack();
        if (!luis.isIamalive()) {System.out.println("You cannot attack me");}
        else {
            if (attack.equals(MainCharacterAttack.Hammer)){ this.setHitpoints(this.getHitpoints()-(1.5*luis.getPower()*(luis.getLevel())/this.getDefence())); }}
            if (attack.equals(MainCharacterAttack.Jump)){  this.setHitpoints(this.getHitpoints()-(luis.getLevel()*luis.getPower()/this.getDefence()));}  }}







