package character.cc3002;

/**
 * Se creo una clase asociada a Boo, que es hija de la clase abstacta
 * de los Enemigo
 */

public class BooEnemyCharacter extends AbstractEnemyCharacter{

    /**
     * Se creo el constructor de Boo
     * @param level nivel
     * @param power poder
     * @param defence defensa
     * @param hitpoints puntos de vida
     * @param hitpointmax puntos de vida maximo
     */

    public BooEnemyCharacter(int level, int power, int defence, double hitpoints, int hitpointmax) {
        super(level, power, defence, hitpoints, hitpointmax);
    }


    /**
     * Se creo el metodo que recive un ataque de Marcos junto con el ataque que implementa
     * @param marco personaje
     * @param attack ataque
     * Se revisa si marco tiene  puntos de vida igual a cero, si es asi no puede atacar
     * En caso contrario se pregunta por el tipo de ataque que recibe, en este caso Boo no puede ser atacado
     * por martillo por lo que no se realiza nada. Por otro lado cuando es atacado por un salto, se calcula
     * el daño que se le inflinge
     */

    @Override
    public void receivesAttackFromMarcos(MarcosMainCharacter marco, MainCharacterAttack attack) {
        marco.canIattack();
        if (!marco.isIamalive()) { System.out.println("You cannot attack me"); }
        else{ if (attack.equals(MainCharacterAttack.Hammer)){ System.out.println("i avoided that"); }
              if (attack.equals(MainCharacterAttack.Jump)){ this.setHitpoints(this.getHitpoints()-(marco.getPower()*(marco.getLevel())/this.getDefence())); }}
    }

    /**
     * Se creo un metodo que recive un ataque de Luis junto con el ataque que implemento
     * @param luis luis
     * @param attack ataque
     * Se revisa si luis tiene  puntos de vida igual a cero, si es asi no puede atacar
     * Boo no puede ser atacado por luis asi que independiente del ataque no se realiza nada
     */


    @Override
    public void receivesAttackFromLuis(LuisMainCharacter luis, MainCharacterAttack attack) {
        luis.canIattack();
        if (!luis.isIamalive()) { System.out.println("You cannot attack me"); }
        else { System.out.println("You are dead you cannot attack"); }
    }
}
