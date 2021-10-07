package interfaces;

import character.LuisMainCharacter;
import character.MarcosMainCharacter;
/**
 * Se creo una interfaz que contiene los metodos de ataque de Luis
 * junto con el metodo que calcula el daño que produce
 */
public interface AttackableByLuis {

    void calculateDamageFromLuisWhitHammer( LuisMainCharacter luis);

    void calculateDamageFromLuisWhitJump( LuisMainCharacter luis);

    void  receivesAttackFromLuisWhitHammer( LuisMainCharacter luis );

    void  receivesAttackFromLuisWhitJump( LuisMainCharacter luis);

}
