package characters.phases.relatedtoplayer.attackplayer;
import characters.phases.Phase;
import characters.phases.relatedtoplayer.attackplayer.AttackSecondEnemyWithHammer;
import characters.phases.relatedtoplayer.attackplayer.AttackSecondEnemyWithJumpPhase;

/**
 * Fase de espera que permite escoger el ataque para el segundo enemigo
 */
public class WaitPhasePlayerChooseAttackForSecondEnemy extends Phase {

    public WaitPhasePlayerChooseAttackForSecondEnemy() {
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
    public void toAttackSecondEnemyWithHammerPhase()  {
        changePhase( new AttackSecondEnemyWithHammer());

    }

    @Override
    public void toAttackSecondEnemyWithJumpPhase() {
        changePhase(new AttackSecondEnemyWithJumpPhase());

    }

    @Override
    public String toString() {
        return "Wait Phase Player Choose Attack For Second Enemy";
    }
}
