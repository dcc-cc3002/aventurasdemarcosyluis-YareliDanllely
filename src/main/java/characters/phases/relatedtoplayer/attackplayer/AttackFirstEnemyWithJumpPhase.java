package characters.phases.relatedtoplayer.attackplayer;

import characters.phases.EndTurnPhase;
import characters.phases.Phase;
import characters.phases.StartPhase;
import characters.phases.exceptions.InvalidTransitionException;

/**
 * Fase que permite acatar al pimer enemgio con salto
 */

public class AttackFirstEnemyWithJumpPhase extends Phase {

    public AttackFirstEnemyWithJumpPhase() {
        canIStart=false;
        enemyCanAttack=false;
        canIAttackPlayer=false;
        useItem=false;
        atacckEnemy=false;
        endTurn=true;
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
       changePhase(new EndTurnPhase());
    }

    @Override
    public String toString() {
       return "Attack First Enemy With Jump Phase";
    }
}
