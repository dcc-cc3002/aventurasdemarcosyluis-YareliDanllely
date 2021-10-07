package interfaces;

import character.LuisMainCharacter;
import character.MarcosMainCharacter;

public interface AttackableByLuis {

    void calculateDamageFromLuisWhitHammer( LuisMainCharacter luis);

    void calculateDamageFromLuisWhitJump( LuisMainCharacter luis);

    void  receivesAttackFromLuisWhitHammer( LuisMainCharacter luis );

    void  receivesAttackFromLuisWhitJump( LuisMainCharacter luis);

}
