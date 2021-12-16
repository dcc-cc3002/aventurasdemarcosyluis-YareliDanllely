package characters.enemies;

import characters.enemies.interfaces.AttackOfBoo;
import characters.enemies.interfaces.AttackableByBoo;
import characters.maincharacter.MarcosMainCharacter;
import characters.Character;
import characters.visitors.AttackableByLuisVisitor;
import characters.visitors.Visitor;

/**
 * Se creo una clase asociada a Boo, que es hija de la clase abstacta
 * de los Enemigo
 */

public class BooEnemyCharacter extends AbstractEnemyCharacter implements AttackOfBoo  {


    /**
     * Se creo el constructor de Boo
     * @param level nivel
     * @param power poder
     * @param defence defensa
     * @param hitPoints puntos de vida
     * @param hitPointMax puntos de vida maximo
     */

    public BooEnemyCharacter(int level, int power, int defence, int hitPoints, int hitPointMax) {
        super(level, power, defence, hitPoints, hitPointMax);
    }


    @Override
    public void attack(AttackableByBoo enemy) {
        enemy.receivesAttackFromBoo(this);
    }



    @Override
    public void calculateDamageFromMarcoWithJump(MarcosMainCharacter marco) {
        marco.setAttackPoints(marco.getAttackPoints() - 1);
        double damageFromJump = this.getHitPoints() - (marco.getPower() * (marco.getLevel()) / marco.getDefence()); this.setHitPoints((int) damageFromJump);
        this.setHitPoints((int) damageFromJump);
    }

    @Override
    public void calculateDamageFromMarcoWithHammer(MarcosMainCharacter marco) {
        marco.setAttackPoints(marco.getAttackPoints() - 2); // Como Boo no puede ser atacado por martillo solo
        //se le restan los puntos a marcos por utilizar este ataque

    }


    @Override
    public void receivesAttackFromMarcoWithHammer(MarcosMainCharacter marco) {
        if (!marco.isiAmAlive() || !this.isiAmAlive() )  {this.setHitPoints( this.getHitPoints()+0);}
        else { if ( marco.roll() == 0) { this.setHitPoints( this.getHitPoints()+0); } // Valor 0 que representa el 25% de probabilidad de fallar
               else { this.calculateDamageFromMarcoWithHammer(marco); } } }


    @Override
    public void receivesAttackFromMarcoWithJump(MarcosMainCharacter marco){
        if (!marco.isiAmAlive() || !this.isiAmAlive() )  {this.setHitPoints( this.getHitPoints()+0);}
        else{ if ( marco.roll() == 0) { this.setHitPoints( this.getHitPoints()+0); }
              else { this.calculateDamageFromMarcoWithJump(marco); } } }


    @Override
    public void acceptVisitor(Visitor visitor) {
        visitor.visitBoo(this);

    }
}

