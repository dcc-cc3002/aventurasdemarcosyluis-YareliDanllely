package character.cc3002;

/**
 * Se creo una interface con metodos para los personaje
 * principales relacionado con el ataque que pueden recibir
 * de los enemigos Boo, Spiny, Goomba. Metodos que van a
 * variar dependiento del personaje principal
 */

public interface IMainCharacter {

    void receivesAttackFromBoo(BooEnemyCharacter Boo);

    void receivesAttackFromSpiny(SpinyEnemycharacter Spiny);

    void receivesAttackFromGoomba(GoombaEnemyCharacter Goomba);




}
