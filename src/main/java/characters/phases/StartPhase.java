package characters.phases;

import characters.phases.relatedtoenemy.EnemyStartTurnPhase;
import characters.phases.relatedtoplayer.attackplayer.WaitPhaseToStartPlayerTurn;

/**
 * Fase que permite empezar el turno
 */
public class StartPhase extends Phase{

    public StartPhase(){
    this.canIStart=true;
    this.enemyCanAttack=false;
    this.canIAttackPlayer=false;
    this.useItem=false;
    this.atacckEnemy=false;
    this.endTurn=false;}


    @Override
    public void toWaitPhaseToStartPlayerTurn() {
        changePhase(new WaitPhaseToStartPlayerTurn());
    }



    @Override
    public String toString() {return "Start Phase";}









}
