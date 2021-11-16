package characters.enemies.interfaces;

import characters.enemies.GoombaEnemyCharacter;

public interface AttackableByGoomba {

    /**
     * Se creó un método que calcula el daño
     * provocado por Goomba
     * @param Goomba Goomba
     */

    void calculateDamageFromGoomba(GoombaEnemyCharacter Goomba);

    /**
     * Se sobreescribio el metodo creado en la interfaz
     * que refleja lo que pasara si Goomba ataca a Marco
     * @param Goomba
     */

    void receivesAttackFromGoomba(GoombaEnemyCharacter Goomba);



}
