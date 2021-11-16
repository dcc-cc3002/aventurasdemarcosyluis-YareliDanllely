package characters.maincharacter.interfaces;

import characters.maincharacter.MarcosMainCharacter;

/**
 * Se creó una interfaz que contiene los métodos asociados a los ataqye de marco con salto y martillo,
 * ademas del el daño que produce cada ataque
 */
public interface AttackablebyMarco {

    /**
     * Se sobre escribió el método para calcular
     * el daño que produce marcos con salto
     * @param marco Marco
     */

    void calculateDamageFromMarcoWithJump(MarcosMainCharacter marco);

    /**
     * Se sobre escribió el método para calcular el
     * daño que produce marcos con
     * martillo
     * @param marco Marco
     */

    void calculateDamageFromMarcoWithHammer(MarcosMainCharacter marco);

    /**
     * Se sobre escribió que modifica los
     * puntos de vida cuando marcos
     * lo ataca con un martillo
     * @param marco Marco
     */
    void receivesAttackFromMarcoWithJump(MarcosMainCharacter marco);

    /**
     * Se sobre escribió  que modifica los
     * puntos de vida cuando marcos
     * ataca con Salto
     * @param marco Marco
     */

    void receivesAttackFromMarcoWithHammer(MarcosMainCharacter marco);


}
