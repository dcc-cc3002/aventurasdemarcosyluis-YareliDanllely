package characters.phases.relatedtoplayer.attackplayer;

import characters.phases.EndTurnPhase;
import characters.phases.Phase;


/**
 * Fase de espera para empezar el turno del jugador
 */
public class WaitPhaseToStartPlayerTurn extends Phase {


    public WaitPhaseToStartPlayerTurn() {
        this.canIStart=false;
        this.enemyCanAttack=false;
        this.canIAttackPlayer=false;
        this.useItem=false;
        this.atacckEnemy=false;
        this.endTurn=false;

    }

    @Override
    public void toEndTurnPhase(){
        changePhase(new EndTurnPhase());
    }

    @Override
    public void toWaitPhaseToChooseEnemyToAttack()  {
        changePhase(new WaitPhaseToChooseEnemyToAttack());
    }



    @Override
    public String toString() {
        return "Wait Phase To Start Player Turn";
    }
}
