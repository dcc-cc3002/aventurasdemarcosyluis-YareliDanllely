package interfaces;

import character.BooEnemyCharacter;
import character.MarcosMainCharacter;

/**
 * Se creó una interfaz que contiene los métodos asociados a los ataqye de marco con salto y martillo,
 * ademas del el daño que produce cada ataque
 */
public interface AttackablebyMarco {

    void calculateDamageFromMarcoWhitJump(MarcosMainCharacter marco);

    void calculateDamageFromMarcoWhitHammer(MarcosMainCharacter marco);

    void receivesAttackFromMarcoWhitJump(MarcosMainCharacter marco);

    void receivesAttackFromMarcoWhitHammer(MarcosMainCharacter marco);


}
