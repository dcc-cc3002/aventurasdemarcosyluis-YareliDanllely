package characters.enemies;

import characters.AbstractCharacter;
import characters.Character;
import characters.enemies.interfaces.Enemies;
import characters.maincharacter.interfaces.AttackablebyMarco;

/**
 *Se creo una clase abstracta que contiene los atributos que se solicitan en
 *el enunciado de la tarea, es decir nivel,poder de ataque, defensa y puntos
 /** de vida*/

public abstract class AbstractEnemyCharacter extends AbstractCharacter implements AttackablebyMarco, Enemies {

    /**
     * Se creo el constructor de la clase
     * @param level nivel
     * @param power poder
     * @param defence defensa
     * @param hitpPoints puntos de vida
     * @param hitPointMax puntos de vida maxima
     */
    public AbstractEnemyCharacter(int level, int power, int defence, int hitpPoints, int hitPointMax) {
        super(level, power, defence, hitpPoints, hitPointMax);
    }

    @Override
    public boolean iAmEnemy(){
        return true;

    }

}