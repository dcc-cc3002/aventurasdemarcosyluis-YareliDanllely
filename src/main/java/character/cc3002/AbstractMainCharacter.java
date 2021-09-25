package character.cc3002;

/**
 *Se creo una clase abstracta que contiene los atributos que se solicitan en
 *el enunciado de la tarea, es decir nivel,poder de ataque, defensa, puntos
 /** de vida y puntos de ataque */

public abstract class AbstractMainCharacter extends character.cc3002.AbstractCharacter implements character.cc3002.IMainCharacter {
    private int attackpoints;

    public AbstractMainCharacter(int level, int power, int defence, double hitpoints, int hitpointmax, int attackpoints) {
        super(level, power, defence, hitpoints, hitpointmax);
        this.attackpoints= attackpoints; }


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

    public void takeItemRedMushroom() { this.setHitpoints(this.getHitpoints()+getHitpointmax()*0.1); }

    /**
     * Se creo el metodo que refleja cuando el personaje toma un item
     * HoneySyrup y cambia la cantidad de puntos de ataque del personaje
     * sumadole 3
     */

    public void takeItemHoneySyrup() { this.setAttackpoints(this.getAttackpoints()+3); }


    /**
     * Se creo el getter del la cantidad de puntos de ataque que puede tener
     *el personaje
     * @return puntos de ataque
     */

    public int getAttackpoints() {
        return attackpoints;
    }

    /**
     *
     * @param attackpoints puntos de ataque
     */
    public void setAttackpoints(int attackpoints) { this.attackpoints= attackpoints; }

}

