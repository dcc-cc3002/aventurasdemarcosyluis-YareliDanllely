package interfaces;

import character.BooEnemyCharacter;

/**
 * Se creo una interfaz que contiene los metodos de ataque de Boo
 * junto con el metodo que calcula el daño que produce
 */
public interface AttackableByBoo {

   void calculateDamageFromBoo(BooEnemyCharacter Boo);

   void receivesAttackFromBoo(BooEnemyCharacter boo);

}
