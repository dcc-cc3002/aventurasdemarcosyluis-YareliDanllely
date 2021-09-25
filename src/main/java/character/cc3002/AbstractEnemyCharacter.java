package character.cc3002;

/**
 *Se creo una clase abstracta que contiene los atributos que se solicitan en
 *el enunciado de la tarea, es decir nivel,poder de ataque, defensa y puntos
 /** de vida*/

public abstract class AbstractEnemyCharacter extends character.cc3002.AbstractCharacter implements character.cc3002.IEnemyCharacter {

    /**
     * Se creo el constructor de la clase
     * @param level nivel
     * @param power poder
     * @param defence defensa
     * @param hitpoints puntos de vida
     * @param hitpointmax puntos de vida maxima
     */
    public AbstractEnemyCharacter(int level, int power, int defence, double hitpoints, int hitpointmax) {
        super(level, power, defence, hitpoints, hitpointmax);
    }

}