package characters;

import java.util.Random;

/**
 * Creamos una clase abstracta que contiene a todos los atributos basicos
 * que tendran tanto enemigos como personajes princiales
 */

public abstract class AbstractCharacter implements Character {
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
     * Se creo un metodo que permitira cambiar el estado iAmDead del personaje segun su numero de vida
     */
    public void canIattack() { if ( this.getHitPoints()==0 ) {this.setiAmAlive(false);} else {this.setiAmAlive(true);}}


    /**
     * Se creo el getter de el atributo nivel
     * @return devolviendo dicho valor
     */
    @Override
    public int getLevel() {
        return level;
    }

    @Override
    public int getPower() { return power; }

    @Override
    public int getDefence() {
        return defence;
    }

    @Override
    public int getHitPoints() { return hitPoints; }

    @Override
    public int getHitPointMax() {return hitPointMax;}


    /**
     * Se greo el setter del nivel de vida del personaje
     * @param level nivel
     */

    public void setLevel(int level) {
        this.level = level;


    }

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

    @Override
    public void setHitPoints(int hitPoints) { if (hitPoints<0) { this.hitPoints=0; }
        else { this.hitPoints = hitPoints; }
    }

    /**
     * Se creo el setter de la cantidad de puntos de vida maxima
     *      * que puede tener el personaje
     * @param hitPointMax puntos de vida maximo
     */
    public void setHitPointMax(int hitPointMax) { if (hitPointMax>0) {this.hitPointMax = hitPointMax;}}

    /**
     * Se creo el getter del atributo que refleja si el personaje esta muerto o no
     * @param iAmAlive estoy vivo?
     */
    public void setiAmAlive(boolean iAmAlive) { this.iAmAlive = iAmAlive; }


    @Override
    public boolean isiAmAlive() { this.canIattack(); return iAmAlive; }





}

