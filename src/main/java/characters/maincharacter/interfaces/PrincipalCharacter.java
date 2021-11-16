package characters.maincharacter.interfaces;

import characters.maincharacter.items.Items;

/**
 * Se creó una interfaz que contenga los metodos que
 * utilizaran los personajes principales
 * para calcular lo que sucede cuando utilizan Items
 */
public interface PrincipalCharacter {


     /**
      * Se creo el metodo que refleja cuando el personaje toma un item
      * HoneySyrup y cambia la cantidad de puntos de ataque del personaje
      * sumadole 3
      */
     void useItemHoneySyrup();

     /**
      * Se creó el método que refleja lo que sucede cuando
      * el personaje toma el item RedMushroon y modifica la cantidad
      * de hitpoints
      */

     void useItemRedMushroom();


}
