package character.cc3002;

public class SpinyEnemycharacter extends AbstractEnemyCharacter {

    /**
     * Se creo el constructor de la clase
     * @param level nivel
     * @param power poder
     * @param defence defensa
     * @param hitpoints puntos de vida
     * @param hitpointmax puntos de vida maximo
     */

    public SpinyEnemycharacter(int level, int power, int defence, double hitpoints, int hitpointmax) {
        super(level, power, defence, hitpoints, hitpointmax);
    }

    /**
     * Se crep un metodo que recibe el ataque de Marcos junto con el tipo de ataque que implementa
     * @param marco
     * @param attack
     * Se ve si marcos puede atacar, si no puede no se realiza nada
     * en caso contrario si el ataque es por un martillo se cambia la cantidad de puntos de vida que tiene
     * con el daño que se inflinge, en el caso de ser atacado por un salto no recibe daño pero si luis
     */

    @Override
    public void receivesAttackFromMarcos(MarcosMainCharacter marco, character.cc3002.MainCharacterAttack attack) {
        marco.canIattack();
        if (!marco.isIamalive()) { System.out.println("You cannot attack me"); }
        else { if (attack.equals(character.cc3002.MainCharacterAttack.Hammer)) { this.setHitpoints(this.getHitpoints() - (1.5 * marco.getPower() * (marco.getLevel()) / this.getDefence())); }
               if (attack.equals(character.cc3002.MainCharacterAttack.Jump)) { marco.setHitpoints(marco.getHitpoints() - marco.getHitpointmax() * 0.1); } }
    }

    /**
     * Se creo un metodo que recibe un ataque de luis junto con el tipo de ataque que implementa
     * @param luis personaje
     * @param attack ataque
     * Se ve si luis puede o no atacar, en caso de que no pueda no se realiza nada
     * por otro lado se cambia el daño que se le inflige por el ataque y si es un ataque del tipo salto se
     * luis recibe daño
     */

    @Override
    public void receivesAttackFromLuis(character.cc3002.LuisMainCharacter luis, MainCharacterAttack attack) {
        luis.canIattack();
        if (!luis.isIamalive()) { System.out.println("You cannot attack me"); }
        else { if (attack.equals(character.cc3002.MainCharacterAttack.Hammer)) { this.setHitpoints(this.getHitpoints() - (1.5 * luis.getPower() * (luis.getLevel()) / this.getDefence())); }
               if (attack.equals(character.cc3002.MainCharacterAttack.Jump)) { luis.setHitpoints(luis.getHitpoints() - (luis.getHitpointmax() * 0.1)); } }
    }
}