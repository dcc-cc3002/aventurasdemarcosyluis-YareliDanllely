package characters.phases.relatedtoplayer.attackplayer;

import characters.phases.Phase;
import characters.phases.exceptions.InvalidTransitionException;
import characters.phases.relatedtoplayer.attackplayer.AttackThirdEnemyWithHammerPhase;
import characters.phases.relatedtoplayer.attackplayer.AttackThirdEnemyWithJumpPhase;

/**
 * Fase de espera que permite elegit el ataque para el tercer enemigo
 *
 */

public class WaitPhasePlayerChooseAttackForThirdEnemy extends Phase {
    public WaitPhasePlayerChooseAttackForThirdEnemy() {
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
    public void toAttackThirdEnemyWithHammerPhase() throws InvalidTransitionException {
        changePhase( new AttackThirdEnemyWithHammerPhase());
    }

    @Override
    public void toAttackThirdEnemyWithJumpPhase() throws InvalidTransitionException {
        changePhase( new AttackThirdEnemyWithJumpPhase());
    }

    @Override
    public String toString() {
        return "Wait Phase Player Choose Attack For Third Enemy";
    }
}
