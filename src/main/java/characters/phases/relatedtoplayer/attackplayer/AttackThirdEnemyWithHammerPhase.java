package characters.phases.relatedtoplayer.attackplayer;

import characters.phases.Phase;
import characters.phases.StartPhase;

/**
 * Fase que permite atacar al tercer enemigo con hammer
 */

public class AttackThirdEnemyWithHammerPhase extends Phase {
    public AttackThirdEnemyWithHammerPhase() {
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
        return "Attack Third Enemy With Hammer Phase";
    }
}