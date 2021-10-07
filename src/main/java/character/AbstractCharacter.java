package character;

import java.util.Random;

/**
 * Creamos una clase abstracta que contiene a todos los atributos basicos
 * que tendran tanto enemigos como personajes princiales
 */

public abstract class AbstractCharacter {
    private Random random;
    private int level;
    private int power;
    private int defence;
    private int hitPoints;
    private int hitPointMax;
    private boolean iAmAlive;

    /**
     *Creamos constructor
     * @param level nivel de vida
     * @param power poder
     * @param defence defensa
     * @param hitPoints puntos de vida
     * @param hitPointMax puntos de vida maximo
     */
    public AbstractCharacter(int level, int power, int defence, int hitPoints, int hitPointMax) {
        this.level = level;
        this.power = power;
        this.defence = defence;
        this.hitPoints= hitPoints;
        this.hitPointMax=hitPointMax;
        this.iAmAlive = true;
        random = new Random();
    }

    /**
     * Se creó una método que aplicara una semilla
     * a la instancia random
     * @param seed semilla
     */
    public void setSeed( int seed){
        random.setSeed(seed);
    }

    /**
     *Se devolvera el siguente valor int
     * pseudoaleatorio en un rango de [0-2]
     * @return valor aletorio
     */

    public int roll() {
      return random.nextInt(4);
    }

    /**
     * Se creo un metodo que permitira cambiar el estado imdead del personaje segun su numero de vida
     */

    public void canIattack() { if ( this.getHitPoints()==0 ) {this.setiAmAlive(false);} else {this.setiAmAlive(true);}}


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

    public int getHitPoints() {
        return hitPoints;
    }

    /**
     * Se creo el getter de la cantidad de vida del personaje
     * @return hitPointmax
     */

    public int getHitPointMax() {return hitPointMax;}


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

    public void setDefence(int defence) { this.defence = defence; }

    /**
     * Se creo el setter de la cantidad de puntos de vida que tiene el personaje
     * ademas se puso una restriccion para cuando se quiera asignar un valor negativo
     * se cambie este por cero
     * @param hitPoints puntos de vida
     */

    public void setHitPoints(int hitPoints) { if (hitPoints<0) { this.hitPoints=0; }
        else { this.hitPoints = hitPoints; }
    }


    /**
     * Se creo el setter de la cantidad de puntos de vida maxima
     *      * que puede tener el personaje
     * @param hitPointMax puntos de vida maximo
     */
    public void setHitPointMax(int hitPointMax) {this.hitPointMax = hitPointMax;}

    /**
     * Se creo el getter del atributo que refleja si el personaje esta muerto o no
     * @param iAmAlive estoy vivo?
     */
    public void setiAmAlive(boolean iAmAlive) { this.iAmAlive = iAmAlive; }

    /**
     * Se creo el getter del atributo que refleja si el personaje esta muerto o no
     * @return iAmAlive
     */

    public boolean isiAmAlive() { this.canIattack(); return iAmAlive; }


}

