package character;

import interfaces.AttackableByLuis;

/**
 * Clase Spiny que contiene lo que puede hacer este personaje
 */

public class SpinyEnemycharacter extends AbstractEnemyCharacter implements AttackableByLuis {

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


    /**
     * Se sobre escribió el método para calcular
     * el daño que produce marcos con salto
     * @param marco Marco
     */
    @Override
    public void calculateDamageFromMarcoWhitJump(MarcosMainCharacter marco) {
        marco.setAttackPoints(marco.getAttackPoints()-1);
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
        marco.setAttackPoints(marco.getAttackPoints()-2);
        double damageFromHammer = this.getHitPoints() - (1.5 * marco.getPower() * (marco.getLevel()) / this.getDefence()); this.setHitPoints((int) damageFromHammer);
    }

    /**
     * Se sobre escribio el metodo
     * que calcula el daño que produce Luis
     * con martillo
     * @param luis Luis
     */
    @Override
    public void calculateDamageFromLuisWhitHammer(LuisMainCharacter luis) {
        luis.setAttackPoints(luis.getAttackPoints() - 2);
        double damageFromHammer = this.getHitPoints() - (1.5 * luis.getPower() * (luis.getLevel()) / this.getDefence());
        this.setHitPoints((int) damageFromHammer);
    }

    /**
     * Se sobre escribio el metodo
     * que calcula el daño que produce Luis con salto
     * @param luis Luis
     */
    @Override
    public void calculateDamageFromLuisWhitJump(LuisMainCharacter luis) {
        luis.setAttackPoints(luis.getAttackPoints()-1);
        double damageFromHammer = this.getHitPoints() - ( luis.getPower() * (luis.getLevel()) / this.getDefence());
        this.setHitPoints((int) damageFromHammer);
    }


    /**
     * Se creó un método quecambialos puntos
     * de vida a Spiny si Marco
     * lo ataca con un martillo
     * @param marco Marco
     */

    public void receivesAttackFromMarcoWhitHammer(MarcosMainCharacter marco) {
        if (!marco.isiAmAlive() || !this.isiAmAlive() )  {this.setHitPoints( this.getHitPoints()+0);}
        else { if ( marco.roll()== 0) { this.setHitPoints(this.getHitPoints() + 0);}
               else { this.calculateDamageFromMarcoWhitHammer(marco);} }}


    /**
     * Se creó un método que modifica los puntos
     * de vida a Spiny si Marco lo ataca con Salto
     * @param marco Marco
     */

    public void receivesAttackFromMarcoWhitJump(MarcosMainCharacter marco) {
        if (!marco.isiAmAlive() || !this.isiAmAlive() )  {this.setHitPoints( this.getHitPoints()+0);}
        else { if ( marco.roll()== 0) { this.setHitPoints(this.getHitPoints() + 0); }
               else { this.calculateDamageFromMarcoWhitJump(marco); } }}



    /**
     * Se creó un método que modifica los puntos
     * de vida a Spiny  si recibe
     * un ataque de Luis con martillo
     * @param luis Luis
     */

    @Override
    public void receivesAttackFromLuisWhitHammer(LuisMainCharacter luis) {
        if (!luis.isiAmAlive() || !this.isiAmAlive() )  {this.setHitPoints( this.getHitPoints()+0);}
        else{ if ( luis.roll() == 0) { this.setHitPoints(this.getHitPoints() + 0);}
              else { this.calculateDamageFromLuisWhitHammer(luis); } } }


    /**
     * Se creó un método que ue modifica los puntos
     * de vida a Spiny  si recibe
     * un ataque de Luis con Salto
     * @param luis Luis
     */

    @Override
    public void receivesAttackFromLuisWhitJump (LuisMainCharacter luis){
        if (!luis.isiAmAlive() || !this.isiAmAlive() )  {this.setHitPoints( this.getHitPoints()+0);}
        else { if ( luis.roll() == 0 ) { this.setHitPoints( this.getHitPoints()+0); }
               else { this.calculateDamageFromLuisWhitJump(luis); } }}



}