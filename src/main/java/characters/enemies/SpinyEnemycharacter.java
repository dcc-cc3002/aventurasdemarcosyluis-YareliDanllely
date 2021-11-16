package characters.enemies;

import characters.enemies.interfaces.AttackOfSpiny;
import characters.enemies.interfaces.AttackableBySpiny;
import characters.maincharacter.LuisMainCharacter;
import characters.maincharacter.MarcosMainCharacter;
import characters.maincharacter.interfaces.AttackableByLuis;
import characters.Character;

/**
 * Clase Spiny que contiene lo que puede hacer este personaje
 */

public class SpinyEnemycharacter extends AbstractEnemyCharacter implements AttackableByLuis, AttackOfSpiny {

    /**
     * Se creo el constructor de la clase
     *
     * @param level       nivel
     * @param power       poder
     * @param defence     defensa
     * @param hitPoints   puntos de vida
     * @param hitPointMax puntos de vida maximo
     */

    public SpinyEnemycharacter(int level, int power, int defence, int hitPoints, int hitPointMax) {
        super(level, power, defence, hitPoints, hitPointMax);

    }

    @Override
    public void calculateDamageFromMarcoWithJump(MarcosMainCharacter marco) {
        marco.setAttackPoints(marco.getAttackPoints()-1);
        double damageFromJump = this.getHitPoints() - (marco.getPower() * (marco.getLevel()) / marco.getDefence()); this.setHitPoints((int) damageFromJump);
    }


    @Override
    public void calculateDamageFromMarcoWithHammer(MarcosMainCharacter marco) {
        marco.setAttackPoints(marco.getAttackPoints()-2);
        double damageFromHammer = this.getHitPoints() - (1.5 * marco.getPower() * (marco.getLevel()) / this.getDefence()); this.setHitPoints((int) damageFromHammer);
    }

    @Override
    public void calculateDamageFromLuisWithHammer(LuisMainCharacter luis) {
        luis.setAttackPoints(luis.getAttackPoints() - 2);
        double damageFromHammer = this.getHitPoints() - (1.5 * luis.getPower() * (luis.getLevel()) / this.getDefence());
        this.setHitPoints((int) damageFromHammer);
    }

    @Override
    public void calculateDamageFromLuisWithJump(LuisMainCharacter luis) {
        luis.setAttackPoints(luis.getAttackPoints()-1);
        double damageFromHammer = this.getHitPoints() - ( luis.getPower() * (luis.getLevel()) / this.getDefence());
        this.setHitPoints((int) damageFromHammer);
    }


    public void receivesAttackFromMarcoWithHammer(MarcosMainCharacter marco) {
        if (!marco.isiAmAlive() || !this.isiAmAlive() )  {this.setHitPoints( this.getHitPoints()+0);}
        else { if ( marco.roll()== 0) { this.setHitPoints(this.getHitPoints() + 0);}
               else { this.calculateDamageFromMarcoWithHammer(marco);} }}


    public void receivesAttackFromMarcoWithJump(MarcosMainCharacter marco) {
        if (!marco.isiAmAlive() || !this.isiAmAlive() )  {this.setHitPoints( this.getHitPoints()+0);}
        else { if ( marco.roll()== 0) { this.setHitPoints(this.getHitPoints() + 0); }
               else { this.calculateDamageFromMarcoWithJump(marco); } }}


    @Override
    public void receivesAttackFromLuisWithHammer(LuisMainCharacter luis) {
        if (!luis.isiAmAlive()|| !this.isiAmAlive()) { this.setHitPoints( this.getHitPoints()+0 );}
        else { if (luis.roll()==0 ){this.setHitPoints(this.getHitPoints()+0);}
              else { this.calculateDamageFromLuisWithHammer(luis);}}
    }


    @Override
    public void receivesAttackFromLuisWithJump(LuisMainCharacter luis) {
        if (!luis.isiAmAlive()|| !this.isiAmAlive()) {this.setHitPoints(this.getHitPoints()+0);}
        else {if (luis.roll() == 0) {this.setHitPoints( this.getHitPoints()+0);}
              else { this.calculateDamageFromLuisWithJump(luis); } }


    }

    @Override
    public void attack(AttackableBySpiny enemy) {
        enemy.receivesAttackFromSpiny(this);

    }
}