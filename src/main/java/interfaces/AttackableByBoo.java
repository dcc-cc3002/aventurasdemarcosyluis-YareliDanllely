package interfaces;

import character.BooEnemyCharacter;

public interface AttackableByBoo {

   void calculateDamageFromBoo(BooEnemyCharacter Boo);

   void receivesAttackFromBoo(BooEnemyCharacter boo);

}
