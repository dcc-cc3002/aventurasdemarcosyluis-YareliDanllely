package characters.enemies.interfaces;

import characters.enemies.SpinyEnemycharacter;

public interface AttackableBySpiny {

    /**
     * Se creo un método que calcula el daño
     * provocado por Spiny
     * @param Spiny Spiny
     */

    void calculateDamageFromSpiny(SpinyEnemycharacter Spiny);

    /**
     * Se sobreescribio el metodo creado en la interfaz
     * que refleja lo que pasara si Spiny ataca a Marco
     * @param Spiny spiny
     */


    void receivesAttackFromSpiny(SpinyEnemycharacter Spiny);
}
