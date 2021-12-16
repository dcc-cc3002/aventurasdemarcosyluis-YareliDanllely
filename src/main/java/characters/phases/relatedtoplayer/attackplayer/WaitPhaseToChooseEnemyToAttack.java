package characters.phases.relatedtoplayer.attackplayer;

import characters.phases.Phase;
import characters.phases.exceptions.InvalidTransitionException;
import characters.phases.relatedtoplayer.attackplayer.WaitPhasePlayerChooseAttackForFirstEnemy;
import characters.phases.relatedtoplayer.attackplayer.WaitPhasePlayerChooseAttackForSecondEnemy;
import characters.phases.relatedtoplayer.attackplayer.WaitPhasePlayerChooseAttackForThirdEnemy;

/**
 * Fase de esoera oara elegir ataque el eenemigo cual atacar
 */

public class WaitPhaseToChooseEnemyToAttack extends Phase {


    public WaitPhaseToChooseEnemyToAttack() {
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
    public void start() throws InvalidTransitionException {
        super.start();
    }

    @Override
    public void toPlayerToChooseAttackForFirstEnemy()  {
     changePhase(new WaitPhasePlayerChooseAttackForFirstEnemy());
    }

    @Override
    public void toPlayerToChooseAttackForSecondEnemy() {
     changePhase(new WaitPhasePlayerChooseAttackForSecondEnemy());
    }

    @Override
    public void toPlayerToChooseAttackForThirdEnemy() { changePhase(new WaitPhasePlayerChooseAttackForThirdEnemy());}


    @Override
    public String toString() {
        return "Wait Phase To Choose Enemy To Attack";
    }
}
