package characters.maincharacter.interfaces;

import characters.maincharacter.LuisMainCharacter;

/**
 * Se creo una interfaz que contiene los metodos de ataque de Luis
 * junto con el metodo que calcula el daño que produce
 */
public interface AttackableByLuis {

    /**
     * Se sobre escribio el metodo
     * que calcula el daño que produce Luis
     * con martillo
     * @param luis Luis
     */

    void calculateDamageFromLuisWithHammer( LuisMainCharacter luis);

    /**
     * Se sobre escribio el metodo
     * que calcula el daño que produce Luis con salto
     * @param luis Luis
     */

    void calculateDamageFromLuisWithJump( LuisMainCharacter luis);

    /**
     * Se creó un método que modifica los puntos
     * de vida a Spiny  si recibe
     * un ataque de Luis con martillo
     * @param luis Luis
     */


    void  receivesAttackFromLuisWithHammer( LuisMainCharacter luis );
    /**
     * Se creó un método que ue modifica los puntos
     * de vida a Spiny  si recibe
     * un ataque de Luis con Salto
     * @param luis Luis
     */

    void  receivesAttackFromLuisWithJump( LuisMainCharacter luis);

}
