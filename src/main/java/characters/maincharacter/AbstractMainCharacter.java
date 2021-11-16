package characters.maincharacter;

import characters.AbstractCharacter;
import characters.Character;
import characters.maincharacter.baul.Baul;
import characters.maincharacter.interfaces.PrincipalCharacter;
import java.util.Random;

/**
 *Se creo una clase abstracta que contiene los atributos que se solicitan en
 *el enunciado de la tarea, es decir nivel,poder de ataque, defensa, puntos
 /** de vida y puntos de ataque */

public abstract class AbstractMainCharacter extends AbstractCharacter implements PrincipalCharacter, Character {
    private int attackPoints;
    private int attackPointsMax;
    private Random random;
    private Baul baul;


    public AbstractMainCharacter(int level, int power, int defence, int hitPoints, int hitPointMax, int attackPoints, int attackPointsMax) {
        super(level, power, defence, hitPoints, hitPointMax);
        this.attackPoints= attackPoints;
        this.attackPointsMax= attackPointsMax;
        random = new Random();
        baul = new Baul();

    }

    /**
     * Se creó un método que agrega
     * una cantidad de RedMushroom al Baul
     * @param value cantidad de RedMushroom
     */
    public void addRedMushroomToBaul(int value){
        this.getBaul().addAmountOfRedMushroom(value);
    }

    /**
     * Se creó un método que agrega una cantidad
     * de HoneySyrup al Baul del personaje
     * @param value cantidad de HoneySyrup
     */


    public void addHoneySyrupToBaul(int value){
        this.getBaul().addAmountOfHoneySyrup(value);
    }

    /**
     * Se creó el método que permite obtener la cantidad
     * de HoneySyrup que posee el personaje
     * @return HoneySyrup
     */
    public int getAmountOfHoneySyrup() {
       return this.getBaul().getAmountOfHoneySyrup();
    }

    /**
     * Se creó el método que permite obtener la cantidad
     * de RedMushroom que posee el personje
     * @return RedMushroom
     */

    public int getAmountOfRedMushroom() {return this.getBaul().getAmountOfRedMushroom();}
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

    public void levelUp(){
            double increaseHp= this.getHitPointMax()*0.15 + this.getHitPoints();
            this.setHitPoints((int) increaseHp);

            double increaseAttackpoints = this.getAttackPointsMax()*0.15 + this.getAttackPoints();
            this.setAttackPoints( (int)  increaseAttackpoints);

            double increasePower= this.getPower()*0.15 +this.getPower();
            this.setPower((int) increasePower );

            double increaseDefence= this.getDefence()*0.15+this.getDefence();
            this.setDefence((int) increaseDefence);

            this.setLevel(this.getLevel()+1); }




    @Override
    public void useItemRedMushroom() {
        this.getBaul().removeRedMushroom(1);
        double  power = this.getHitPoints()+getHitPointMax()*0.1;
        this.setHitPoints((int) power); }


    @Override
    public void useItemHoneySyrup() {
        this.getBaul().removeHoneySyrup(1);
        this.setAttackPoints(this.getAttackPoints()+3); }

    /**
     * Se creo el getter del la cantidad de puntos de ataque que puede tener
     *el personaje
     * @return puntos de ataque
     */

    public int getAttackPoints() {
        return attackPoints;
    }

    /**
     *Se creo el setter de la cantidad de puntos de ataque
     * @param attackPoints puntos de ataque
     */
    public void setAttackPoints(int attackPoints) { if (attackPoints>0) this.attackPoints= attackPoints; }

    /**
     * Se creo la cantidad de puntos de ataque máximo
     * @return puntos de ataque máximo
     */
    public int getAttackPointsMax() { return attackPointsMax; }

    /**
     * Se creó el setter de la cantidad de puntos de ataque máximo
     * @param attackPointsMax cantidad de puntos máximos
     */
    public void setAttackPointsMax(int attackPointsMax) { if (attackPointsMax>0) this.attackPointsMax = attackPointsMax;}

    /**
     * Se creó el método getter de Baul para poder obtener la
     * clase y ocupar sus respectivos métodos
     * @return Baul
     */
    public Baul getBaul() {
        return baul;
    }

    /**
     * Se creó el método setter de Baul el que permitira
     * asignar el mismo Baul para Marco y Luis
     * @param baul Baul
     */
    public void setBaul(Baul baul) {this.baul = baul;}


}


