package characters.phases.relatedtoplayer.attackplayer;

import characters.phases.Phase;
import characters.phases.StartPhase;
import characters.phases.exceptions.InvalidTransitionException;

/**
 * Fase que permite acatar el primer enemigo con hammer
 */

public class AttackFirstEnemyWithHammerPhase extends Phase {

    public AttackFirstEnemyWithHammerPhase() {
        canIStart=false;
        enemyCanAttack=false;
        canIAttackPlayer=false;
        useItem=false;
        atacckEnemy=false;
        endTurn=false;
        attackFirstEnemy=false;
        attackThirdEnemy=false;
        attackSecondEnemy= false;
        attackFirstEnemyWithJump=false;
        attackFirstEnemyWithHammer=false;
        attackSecondEnemyWithJump=false;
        attackThirdEnemyWithHammer=false;
        attackThirdEnemyWithJump=false;
        attackSecondEnemyWithHammer=false;}



    @Override
    public void toEndTurnPhase()  {
        changePhase(new StartPhase());
    }

    @Override
    public String toString() {
        return "Attack First Enemy With Hammer Phase";
    }
}