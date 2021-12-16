package characters.phases.relatedtoenemy;

import characters.phases.Phase;

/**
 * Se creo una fase para empezar el turno de enemigo, no pude terminarla:c
 */
public class EnemyStartTurnPhase extends Phase {

    public EnemyStartTurnPhase(){
        this.canIStart=true;
        this.enemyCanAttack=false;
        this.canIAttackPlayer=false;
        this.useItem=false;
        this.atacckEnemy=false;
        this.endTurn=false;
    }



    @Override
    public String toString() {
        return "Enemy Start Turn Phase";
    }
}
