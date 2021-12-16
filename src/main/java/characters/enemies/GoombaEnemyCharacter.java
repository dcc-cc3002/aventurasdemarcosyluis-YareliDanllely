package characters.enemies;

import characters.enemies.interfaces.AttackOfGoomba;
import characters.enemies.interfaces.AttackableByGoomba;
import characters.maincharacter.LuisMainCharacter;
import characters.maincharacter.MarcosMainCharacter;
import characters.maincharacter.interfaces.AttackableByLuis;
import characters.Character;
import characters.visitors.Visitor;

/***
 * Se creo la clase Goombra que se exiente a la clase AbstractEnemy
 */

public class GoombaEnemyCharacter extends AbstractEnemyCharacter implements AttackableByLuis, AttackOfGoomba {

    /**
     * Se crea el constructor
     *
     * @param level       nivel
     * @param power       poder
     * @param defence     defensa
     * @param hitpoints   puntos de vida
     * @param hitpointmax puntos de vida maxima
     */

    public GoombaEnemyCharacter(int level, int power, int defence, int hitpoints, int hitpointmax) {
        super(level, power, defence, hitpoints, hitpointmax);
    }

    @Override
    public void attack(AttackableByGoomba enemy) {
        enemy.receivesAttackFromGoomba(this);
    }


    @Override
    public void calculateDamageFromMarcoWithJump(MarcosMainCharacter marco) {
        marco.setAttackPoints(marco.getAttackPoints()-1);
        double damageFromJump = ( this.getHitPoints() - ( marco.getPower() * (marco.getLevel()) / this.getDefence() ) ); this.setHitPoints((int) damageFromJump);
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
        else { if ( marco.roll()== 4) { this.setHitPoints(this.getHitPoints() + 0);}
               else { this.calculateDamageFromMarcoWithHammer(marco);} }}



    public void receivesAttackFromMarcoWithJump(MarcosMainCharacter marco) {
        if (!marco.isiAmAlive() || !this.isiAmAlive() )  {this.setHitPoints( this.getHitPoints()+0);}
        else { if ( marco.roll()== 4) { this.setHitPoints(this.getHitPoints() + 0); }
               else  { this.calculateDamageFromMarcoWithJump(marco); } }}



    @Override
    public void receivesAttackFromLuisWithHammer(LuisMainCharacter luis) {
        if (!luis.isiAmAlive() || !this.isiAmAlive() )  {this.setHitPoints( this.getHitPoints()+0);}
        else{ if ( luis.roll() == 4) { this.setHitPoints(this.getHitPoints() + 0);}
              else { this.calculateDamageFromLuisWithHammer(luis); } } }



    @Override
    public void receivesAttackFromLuisWithJump (LuisMainCharacter luis){
        if (!luis.isiAmAlive() || !this.isiAmAlive() )  {this.setHitPoints( this.getHitPoints()+0);}
        else { if ( luis.roll() == 0 ) { this.setHitPoints( this.getHitPoints()+0); }
               else  { this.calculateDamageFromLuisWithJump(luis); } }}


    @Override
    public void acceptVisitor(Visitor visitor) {
        visitor.visitGoomba(this);

    }
}





