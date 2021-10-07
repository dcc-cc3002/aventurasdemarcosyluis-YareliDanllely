package interfaces;

import character.GoombaEnemyCharacter;
import character.SpinyEnemycharacter;

/**
 * Se creo una interface con metodos para los personaje
 * principales relacionado con el ataque que pueden recibir
 * de los enemigos Boo, Spiny, Goomba. Metodos que van a
 * variar dependiento del personaje principal
 */

public interface IMainCharacter {

    void calculateDamageFromSpiny(SpinyEnemycharacter Spiny);

    void calculateDamageFromGoomba(GoombaEnemyCharacter Goomba);

    void receivesAttackFromSpiny(SpinyEnemycharacter Spiny);

    void receivesAttackFromGoomba(GoombaEnemyCharacter Goomba);




}
