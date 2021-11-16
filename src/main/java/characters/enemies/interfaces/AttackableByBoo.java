package characters.enemies.interfaces;

import characters.enemies.BooEnemyCharacter;

/**
 * Se creo una interfaz que contiene los metodos de ataque de Boo
 * junto con el metodo que calcula el daño que produce
 */
public interface AttackableByBoo {


   /**
    * Se creó una método que calcula el daño
    * provocado por Boo
    * @param Boo
    */
   void calculateDamageFromBoo(BooEnemyCharacter Boo);

   /**
    * Se sobreescribio la método que recibe un ataque de Boo
    * @param boo Boo
    */

   void receivesAttackFromBoo(BooEnemyCharacter boo);

}
