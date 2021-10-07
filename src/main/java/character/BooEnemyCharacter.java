package character;

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
     * @param hitPoints puntos de vida
     * @param hitPointMax puntos de vida maximo
     */

    public BooEnemyCharacter(int level, int power, int defence, int hitPoints, int hitPointMax) {
        super(level, power, defence, hitPoints, hitPointMax);
    }


    /**
     * Se sobre escribió el método para calcular
     * el daño que produce marcos con salto
     * @param marco Marco
     */
    @Override
    public void calculateDamageFromMarcoWhitJump(MarcosMainCharacter marco) {
        marco.setAttackPoints(marco.getAttackPoints() - 1);
        double damageFromJump = this.getHitPoints() - (marco.getPower() * (marco.getLevel()) / marco.getDefence()); this.setHitPoints((int) damageFromJump);
    }

    /**
     * Se sobre escribió el método para calcular el
     * daño que produce marcos con
     * martillo
     * @param marco Marco
     */
    @Override
    public void calculateDamageFromMarcoWhitHammer(MarcosMainCharacter marco) {
        marco.setAttackPoints(marco.getAttackPoints() - 2);
        double damageFromHammer = this.getHitPoints() - (1.5 * marco.getPower() * (marco.getLevel()) / this.getDefence()); this.setHitPoints((int) damageFromHammer);
    }


    /**
     * Se sobre escribió que modifica los
     * puntos de vida cuando marcos
     * lo ataca con un martillo
     * @param marco Marco
     */

    @Override
    public void receivesAttackFromMarcoWhitHammer(MarcosMainCharacter marco) {
        if (!marco.isiAmAlive() || !this.isiAmAlive() )  {this.setHitPoints( this.getHitPoints()+0);}
        else { if ( marco.roll() == 0) { this.setHitPoints( this.getHitPoints()+0); }
               else { ; this.calculateDamageFromMarcoWhitHammer(marco); } } }

    /**
     * Se sobre escribió  que modifica los
     * puntos de vida cuando marcos
     * ataca con Salto
     * @param marco Marco
     */
    @Override
    public void receivesAttackFromMarcoWhitJump(MarcosMainCharacter marco){
        if (!marco.isiAmAlive() || !this.isiAmAlive() )  {this.setHitPoints( this.getHitPoints()+0);}
        else{ if ( marco.roll() == 0) { this.setHitPoints( this.getHitPoints()+0); }
              else { this.calculateDamageFromMarcoWhitJump(marco); } } }
}

