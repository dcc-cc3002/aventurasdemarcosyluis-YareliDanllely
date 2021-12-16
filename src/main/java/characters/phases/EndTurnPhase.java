package characters.phases;

import characters.phases.exceptions.InvalidTransitionException;

/**
 * Fase que permite terminar el turno
 */
public class EndTurnPhase extends Phase{


    public EndTurnPhase() {
        this.canIStart=false;
        this.enemyCanAttack=false;
        this.canIAttackPlayer=false;
        this.useItem=false;
        this.atacckEnemy=false;
        this.endTurn=true;
    }

    @Override
    public void EndTurn() {
        toStartPhase();
    }

    @Override
    public void toStartPhase() {
        changePhase(new StartPhase());
    }

    @Override
    public String toString() {
        return "End Phase";
    }


}
