package character.cc3002;


/**
 * Se creo una interfaz que con metodos que solo implementaran las clases enemigo
 */
public interface IEnemyCharacter {

     void receivesAttackFromMarcos(character.cc3002.MarcosMainCharacter marco , MainCharacterAttack attack);

     void receivesAttackFromLuis(character.cc3002.LuisMainCharacter luis, MainCharacterAttack attack);
}
