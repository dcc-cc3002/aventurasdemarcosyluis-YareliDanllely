package character.cc3002;

/**
 * Creamos una clase abstracta que contiene a todos los atributos basicos
 * que tendran tanto enemigos como personajes princiales
 */

public abstract class AbstractCharacter {
    private int level;
    private int power;
    private int defence;
    private double hitpoints;
    private int hitpointmax;
    private boolean iamalive;

    /**
     *Creamos constructor
     * @param level nivel de vida
     * @param power poder
     * @param defence defensa
     * @param hitpoints puntos de vida
     * @param hitpointmax puntos de vida maximo
     */
    public AbstractCharacter(int level, int power, int defence, double hitpoints, int hitpointmax) {
        this.level = level;
        this.power = power;
        this.defence = defence;
        this.hitpoints = hitpoints;
        this.hitpointmax = hitpointmax;
        this.iamalive = true;}

    /**
     * Se creo un metodo que permitira cambiar el estado imdead del personaje segun su numero de vida
     */
    public void canIattack() { if ( this.getHitpoints()==0 ) {this.setIamalive(false);} else {this.setIamalive(true);}}


    /**
     * Se creo el getter de el atributo nivel
     * @return devolviendo dicho valor
     */

    public int getLevel() {
        return level;
    }
    /**
     * Se creo el getter del poder del personaje
     * @return devolviendo dicho valor
     */
    public int getPower() {
        return power;
    }
    /**
     * Se creo el getter del poder del personaje
     * @return devolviendo dicho valor
     */

    public int getDefence() {
        return defence;
    }
    /**
     * Se creo el getter del poder del personaje
     * @return devolviendo dicho valor
     */

    public double getHitpoints() {
        return hitpoints;
    }

    /**
     * Se creo el getter de la cantidad de vida del personaje
     * @return hitpointmax
     */

    public int getHitpointmax() {
        return hitpointmax;
    }


    /**
     * Se greo el setter del nivel de vida del personaje
     * @param level nivel
     */

    public void setLevel(int level) {this.level = level;}

    /**
     * Se creo el setter de la cantidad de poder del personaje
     * @param power poder
     */

    public void setPower(int power) {
        this.power = power;
    }

    /**
     * Se creo el setter de la cantidad de defensa que tiene el personaje
     * @param defence defensa
     */

    public void setDefence(int defence) {
        this.defence = defence;
    }

    /**
     * Se creo el setter de la cantidad de puntos de vida que tiene el personaje
     * ademas se puso una restriccion para cuando se quiera asignar un valor negativo
     * se cambie este por cero
     * @param hitpoints puntos de vida
     */

    public void setHitpoints(double hitpoints) { if (hitpoints<0) { this.hitpoints=0; }
        else { this.hitpoints = hitpoints; }
    }

    /**
     * Se creo el setter de la cantidad de puntos de vida maxima
     *      * que puede tener el personaje
     * @param hitpointmax puntos de vida maximo
     */
    public void setHitpointmax(int hitpointmax) {
        this.hitpointmax = hitpointmax;
    }

    /**
     * Se creo el getter del atributo que refleja si el personaje esta muerto o no
     * @param iamalive estoy vivo?
     */
    public void setIamalive(boolean iamalive) { this.iamalive = iamalive; }

    /**
     * Se creo el getter del atributo que refleja si el personaje esta muerto o no
     * @return iamalive
     */

    public boolean isIamalive() { return iamalive; }
}

