package character;

import interfaces.IMainCharacter;

/**
 *Se creo una clase abstracta que contiene los atributos que se solicitan en
 *el enunciado de la tarea, es decir nivel,poder de ataque, defensa, puntos
 /** de vida y puntos de ataque */

public abstract class AbstractMainCharacter extends AbstractCharacter implements IMainCharacter {
    private int attackPoints;

    public AbstractMainCharacter(int level, int power, int defence, int hitPoints, int hitPointMax, int attackPoints) {
        super(level, power, defence, hitPoints, hitPointMax);
        this.attackPoints= attackPoints; }


    /**
     * Se creo el metodo que refleja cuando el personaje toma item star
     * y como en este caso el personaje entra en estado invencible se
     * implemento un print de tal expresion
     */

    public void takeItemStar() { System.out.println( "You entered an invisible stated"); }

    /**
     * Se creo el metdod que refleja cuando el personaje toma un item
     * RedMushroom y como se indico cambia la cantidad de puntos de vida,
     * en este caso se le agrega el 10% de la cantidad total
     */

    public void takeItemRedMushroom() { double  power = this.getHitPoints()+getHitPointMax()*0.1;
        this.setHitPoints((int) power); }

    /**
     * Se creo el metodo que refleja cuando el personaje toma un item
     * HoneySyrup y cambia la cantidad de puntos de ataque del personaje
     * sumadole 3
     */

    public void takeItemHoneySyrup() { this.setAttackPoints(this.getAttackPoints()+3); }


    /**
     * Se creo el getter del la cantidad de puntos de ataque que puede tener
     *el personaje
     * @return puntos de ataque
     */

    public int getAttackPoints() {
        return attackPoints;
    }

    /**
     *
     * @param attackPoints puntos de ataque
     */
    public void setAttackPoints(int attackPoints) { this.attackPoints= attackPoints; }

}

