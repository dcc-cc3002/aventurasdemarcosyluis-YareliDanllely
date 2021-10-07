package character;

import interfaces.AttackableByLuis;

/***
 * Se creo la clase Goombra que se exiente a la clase AbstractEnemy
 */

public class GoombaEnemyCharacter extends AbstractEnemyCharacter implements AttackableByLuis {

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

    /**
     * Se sobre escribió el método para calcular
     * el daño que produce marcos con salto
     * @param marco Marco
     */
    @Override
    public void calculateDamageFromMarcoWhitJump(MarcosMainCharacter marco) {
        marco.setAttackPoints(marco.getAttackPoints()-1);
        double damageFromJump = ( this.getHitPoints() - ( marco.getPower() * (marco.getLevel()) / this.getDefence() ) ); this.setHitPoints((int) damageFromJump);
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
     * Se sobre escribió el método
     * que calcula el daño que produce Luis con el
     * martillo
     * @param luis Luis
     */
    @Override
    public void calculateDamageFromLuisWhitHammer(LuisMainCharacter luis) {
        luis.setAttackPoints(luis.getAttackPoints() - 2);
        double damageFromHammer = this.getHitPoints() - (1.5 * luis.getPower() * (luis.getLevel()) / this.getDefence());
        this.setHitPoints((int) damageFromHammer);
    }

    /**
     * S creó el método que calcula el daño
     * que produce Luis con el ataque salto
     * @param luis Luis
     */
    @Override
    public void calculateDamageFromLuisWhitJump(LuisMainCharacter luis) {
        luis.setAttackPoints(luis.getAttackPoints()-1);
        double damageFromHammer = this.getHitPoints() - ( luis.getPower() * (luis.getLevel()) / this.getDefence());
        this.setHitPoints((int) damageFromHammer);
    }


    /**
     * Se creó un método que modifica los puntos de vida
     * a Goomba si Marco lo ataca con un martillo
     * @param marco Marco
     */

    public void receivesAttackFromMarcoWhitHammer(MarcosMainCharacter marco) {
        if (!marco.isiAmAlive() || !this.isiAmAlive() )  {this.setHitPoints( this.getHitPoints()+0);}
        else { if ( marco.roll()== 4) { this.setHitPoints(this.getHitPoints() + 0);}
               else { this.calculateDamageFromMarcoWhitHammer(marco);} }}


    /**
     * Se creó un método que cambia los puntos de vida
     * a Goomba si Marco lo ataca con Salto
     * @param marco Marco
     */

    public void receivesAttackFromMarcoWhitJump(MarcosMainCharacter marco) {
        if (!marco.isiAmAlive() || !this.isiAmAlive() )  {this.setHitPoints( this.getHitPoints()+0);}
        else { if ( marco.roll()== 4) { this.setHitPoints(this.getHitPoints() + 0); }
               else  { this.calculateDamageFromMarcoWhitJump(marco); } }}



    /**
     * Se creó un método que cambia los puntos de vida
     * a Goomba  si recibe un ataque de Luis con martillo,
     * @param luis Luis
     */

    @Override
    public void receivesAttackFromLuisWhitHammer(LuisMainCharacter luis) {
        if (!luis.isiAmAlive() || !this.isiAmAlive() )  {this.setHitPoints( this.getHitPoints()+0);}
        else{ if ( luis.roll() == 4) { this.setHitPoints(this.getHitPoints() + 0);}
              else { this.calculateDamageFromLuisWhitHammer(luis); } } }


    /**
     * Se creó un método que cambia los puntos de vida
     * a Goomba  si recibe
     * un ataque de Luis con Salto
     * @param luis Luis
     * Se evaluan los casos importantes
     */

    @Override
    public void receivesAttackFromLuisWhitJump (LuisMainCharacter luis){
        if (!luis.isiAmAlive() || !this.isiAmAlive() )  {this.setHitPoints( this.getHitPoints()+0);}
        else { if ( luis.roll() == 0 ) { this.setHitPoints( this.getHitPoints()+0); }
               else  { this.calculateDamageFromLuisWhitJump(luis); } }}

}





