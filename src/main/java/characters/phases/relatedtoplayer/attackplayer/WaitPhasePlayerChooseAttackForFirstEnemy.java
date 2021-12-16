package characters.phases.relatedtoplayer.attackplayer;

import characters.phases.Phase;
import characters.phases.relatedtoplayer.attackplayer.AttackFirstEnemyWithHammerPhase;
import characters.phases.relatedtoplayer.attackplayer.AttackFirstEnemyWithJumpPhase;

/**
 * Fase que permite elegir el ataque para el tercer enemigo
 */

public class WaitPhasePlayerChooseAttackForFirstEnemy extends Phase {

    public WaitPhasePlayerChooseAttackForFirstEnemy() {
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
    public String toString() {
        return "Player To Choose Attack For First Enemy";
    }

    @Override
    public void toAttackFirstEnemyWithJumpPhase()  {
        changePhase(new AttackFirstEnemyWithJumpPhase());

    }

    @Override
    public void toAttackFirstEnemyWithHammerPhase() {
        changePhase(new AttackFirstEnemyWithHammerPhase());

    }


}


