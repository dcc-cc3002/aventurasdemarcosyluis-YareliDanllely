package characters.maincharacter.interfaces;

public interface AttackOfLuis {

     /**
      * Se crea un método de ataque para luis con martillo
      * @param enemy enemigo
      */
     void attackWithHammer(AttackableByLuis enemy);

     /**
      * Se crea un método de ataque para luis con salto
      * @param enemy enemigo
      */
     void attackWithJump(AttackableByLuis enemy);
}
