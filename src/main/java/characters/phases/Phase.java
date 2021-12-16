package characters.phases;

import characters.controller.GameController;
import characters.phases.exceptions.InvalidTransitionException;


/**
 * Se creo una clase llamada Phase que permitira realizar el
 * flujo de juego
 */
public class Phase {

    protected GameController controller;
    public boolean canIStart;
    public boolean enemyCanAttack;
    public boolean canIAttackPlayer;
    public boolean useItem;
    public boolean atacckEnemy;
    public boolean endTurn;
    public boolean attackFirstEnemy;
    public boolean attackThirdEnemy;
    public boolean attackSecondEnemy;
    public boolean attackFirstEnemyWithJump;
    public boolean attackFirstEnemyWithHammer;
    public boolean attackSecondEnemyWithJump;
    public boolean attackThirdEnemyWithHammer;
    public boolean attackThirdEnemyWithJump;
    public boolean attackSecondEnemyWithHammer;



    //Inicio

    /**
     * Se creo un metodo Star que permite empezar el juego
     * @throws InvalidTransitionException
     */
    public void start() throws InvalidTransitionException {
        if (!canIStart && !controller.getPlayer(controller.getTurn()).iAmEnemy()) {
            throw new InvalidTransitionException("You can´t start your turn");
        }
        if (!canIStart && controller.getPlayer(controller.getTurn()).iAmEnemy()){
            throw new InvalidTransitionException("You can't start your turn");

        }if (canIStart && !controller.getPlayer(controller.getTurn()).iAmEnemy()) {
            toWaitPhaseToStartPlayerTurn();
            controller.tryStartTurnPlayer();
        }

    }




    /**
     * Se creo un metodo que verifica si los personajes principales puede o no
     * avanzar
     * @throws InvalidTransitionException
     */
    public void starTurnOfPlayer() throws InvalidTransitionException {

        if (atacckEnemy){toWaitPhaseToChooseEnemyToAttack(); controller.playerChooseEnemy();}

        if (endTurn) {toEndTurnPhase();controller.tryToEndTurn();}

        else{ throw new InvalidTransitionException("You dont choose something");}
    }




    /**
     * Se creo un metodo que permite ver si se puede o no
     * elegir un enemigo
     * @throws InvalidTransitionException
     */
    public void chooseEnemy() throws InvalidTransitionException {
        if (attackFirstEnemy){
            toPlayerToChooseAttackForFirstEnemy();
            controller.playerChooseAttackForFirstEnemy(); }

        if (attackSecondEnemy){
            toPlayerToChooseAttackForSecondEnemy();
            controller.playerChooseAttackForSecondEnemy(); }

        if (attackThirdEnemy){
            toPlayerToChooseAttackForThirdEnemy();
            controller.playerChooseAttackForThirdEnemy(); }

        else{ throw new InvalidTransitionException("You don´t choose something");}
    }

    /**
     * Se creo un metodo que permite ver si se puede o no escoger un
     * ataque para el primer enemigo de la lista y que ademas permite
     * avanzar de fase
     * @throws InvalidTransitionException
     */
    public void chooseAttackForFirstEnemy() throws InvalidTransitionException{
        if (attackFirstEnemyWithJump){
            toAttackFirstEnemyWithJumpPhase();
            controller.attackFirstEnemyWithJump(); }

        if (attackFirstEnemyWithHammer){
            toAttackFirstEnemyWithHammerPhase();
            controller.attackFirstEnemyWithHammer();
        } else{
        throw new InvalidTransitionException("you cant attack");
        }
    }


    /**
     * Se creo un metodo que permite elegir un ataque para el segundo enemigo
     * ademas de cambiar de fase
     * @throws InvalidTransitionException
     */
    public void chooseAttackForSecondEnemy() throws InvalidTransitionException{
        if (attackSecondEnemyWithJump){
            toAttackSecondEnemyWithJumpPhase();
            controller.attackSecondEnemyWithJump(); }


        if (attackSecondEnemyWithHammer){
            toAttackSecondEnemyWithHammerPhase();
            controller.attackSecondEnemyWithHammer();
        } else{
            throw new InvalidTransitionException("you cant attack");
        }
    }

    /**
     * Se creo un metodo que permite elegir un ataque para el tercer enemigo
     * ademas de cambiar de fase
     * @throws InvalidTransitionException
     */
    public void chooseAttackForThirdEnemy() throws InvalidTransitionException{

        if (attackThirdEnemyWithJump){
            toAttackThirdEnemyWithJumpPhase();
            controller.attackThirdEnemyWithJump(); }

        if (attackThirdEnemyWithHammer){
            toAttackThirdEnemyWithHammerPhase();
            controller.attackThirdEnemyWithHammer();
        } else{
            throw new InvalidTransitionException("you cant attack");
        }
    }


    //Termino del turno

    /**
     * Se creo un termino de turno
     * @throws InvalidTransitionException
     */
    public void EndTurn() throws InvalidTransitionException {
        if (!endTurn){
            throw new InvalidTransitionException("Can´t end turn on"+toString()+".");
        }toEndTurnPhase();
          controller.tryToEndTurn();
    }

    //Expeciones de cambio entre fases

    /**
     * Se creo un metodo que permitira cambiar a la fase del nombre de este metodo
     * @throws InvalidTransitionException
     */
    public void toAttackThirdEnemyWithHammerPhase()  throws InvalidTransitionException {
        throw new InvalidTransitionException("You Can´t change from"+ this.toString()+" to AttackThirdEnemyWithHammerPhase");
    }
    /**
     *S e creo un metodo que permitira cambiar a la fase del nombre de este metodo
     * @throws InvalidTransitionException
     */
    public void toAttackThirdEnemyWithJumpPhase() throws InvalidTransitionException {
        throw new InvalidTransitionException("You Can´t change from"+ this.toString()+" to AttackThirdEnemyWithJumpPhase");
        }
    /**
     * Se creo un metodo que permitira cambiar a la fase del nombre de este metodo
     * @throws InvalidTransitionException
     */
    public void toAttackSecondEnemyWithHammerPhase()  throws InvalidTransitionException {
        throw new InvalidTransitionException("You Can´t change from"+ this.toString()+" to AttackSecondEnemyWithHammerPhase");
    }
    /**
     * Se creo un metodo que permitira cambiar a la fase del nombre de este metodo
     * @throws InvalidTransitionException
     */
    public void toAttackSecondEnemyWithJumpPhase()  throws InvalidTransitionException {
        throw new InvalidTransitionException("You Can´t change from"+ this.toString()+" to AttackSecondEnemyWithJumpPhase");
    }

    /**
     * Se creo un metodo que permitira cambiar a la fase del nombre de este metodo
     * @throws InvalidTransitionException
     */
    public void toStartPhase() throws InvalidTransitionException {
        throw new InvalidTransitionException("You Can´t change from"+ this.toString()+" to StartPhase");
    }
    /**
     * Se creo un metodo que permitira cambiar a la fase del nombre de este metodo
     * @throws InvalidTransitionException
     */
    public void toWaitPhaseToStartPlayerTurn() throws InvalidTransitionException {
        throw new InvalidTransitionException("You Can´t change from"+ this.toString()+" WaitPhaseToStartPlayerTurn");
    }

    /**
     * Se creo un metodo que permitira cambiar a la fase del nombre de este metodo
     * @throws InvalidTransitionException
     */
    public void toEndTurnPhase() throws InvalidTransitionException {
        throw new InvalidTransitionException("You cant change form"+this.toString()+"to EndTurnPhase");
    }
    /**
     * Se creo un metodo que permitira cambiar a la fase del nombre de este metodo
     * @throws InvalidTransitionException
     */
    public void toWaitPhaseToChooseEnemyToAttack() throws InvalidTransitionException {
        throw new InvalidTransitionException("You cant change form"+this.toString()+"WaitPhaseToChooseEnemyToAttack");
    }


    /**
     * Se creo un metodo que permitira cambiar a la fase del nombre de este metodo
     * @throws InvalidTransitionException
     */
    public void toPlayerToChooseAttackForFirstEnemy() throws InvalidTransitionException {
        throw new InvalidTransitionException("Can´t change from"+this.toString()+" PlayerToChooseAttackForFirstEnemy");
    }
    /**
     *Se creo un metodo que permitira cambiar a la fase del nombre de este metodo
     * @throws InvalidTransitionException
     */
    public void toPlayerToChooseAttackForSecondEnemy() throws InvalidTransitionException {
        throw new InvalidTransitionException("Can´t change from"+this.toString()+"to PlayerToChooseAttackForSecondEnemy");
    }
    /**
     *Se creo un metodo que permitira cambiar a la fase del nombre de este metodo
     * @throws InvalidTransitionException
     */
    public void toPlayerToChooseAttackForThirdEnemy() throws InvalidTransitionException {
        throw new InvalidTransitionException("Can´t change from"+this.toString()+"to PlayerToChooseAttackForThirdEnemy");
    }
    /**
     * Se creo un metodo que permitira cambiar a la fase del nombre de este metodo
     * @throws InvalidTransitionException
     */
    public void toAttackFirstEnemyWithJumpPhase() throws InvalidTransitionException {
        throw new InvalidTransitionException("Can´t change from"+this.toString()+"to AttackFirstEnemyWithJumpPhase");
    }
    /**
     * Se creo un metodo que permitira cambiar a la fase del nombre de este metodo
     * @throws InvalidTransitionException
     */
    public void toAttackFirstEnemyWithHammerPhase() throws InvalidTransitionException {
        throw new InvalidTransitionException("Can´t change from"+this.toString()+"to AttackFirstEnemyWithHammerPhase");
    }


    // Setters y Getters

    /**
     * Se creó un método que permite asignar un controlador a la fase
     * @param controller controlador
     */
    public void setController(GameController controller){ this.controller=controller; }

    /**
     * Se creó un método para cambiar de fase
     * @param phase fase
     */
    public void changePhase(Phase phase){ controller.setPhase(phase); }

    /**
     * Metodo que retorna el nombre de la fase
     * @return nombre de la fase
     */
    public String toString(){
        return "Phase";
    }

    /**
     * Se creo un metodo que permite settear la variable endTurn
     * @param endTurn enTurn
     */

    public void setEndTurn(boolean endTurn) {
        this.endTurn = endTurn;
    }

    /**
     * Se creo els etter de attackEnemy
     * @param atacckEnemy attackEnemy
     */
    public void setAtacckEnemy(boolean atacckEnemy) {
        this.atacckEnemy = atacckEnemy;
    }

    /**
     * Se creo el setter de attackFirsEnemy
     * @param attackFirstEnemy attack First enemy
     */

    public void setAttackFirstEnemy(boolean attackFirstEnemy) {
        this.attackFirstEnemy = attackFirstEnemy;
    }

    /**
     * Se creo el setter de attackFirstEnemyWithJump
     * @param attackFirstEnemyWithJump attackFirstEnemy
     */
    public void setAttackFirstEnemyWithJump(boolean attackFirstEnemyWithJump) { this.attackFirstEnemyWithJump = attackFirstEnemyWithJump; }

    /**
     * Se creo el setter para AttackThirdEnemy
     * @param attackThirdEnemy AttackThirdEnemy
     */
    public void setAttackThirdEnemy(boolean attackThirdEnemy) {
        this.attackThirdEnemy = attackThirdEnemy;
    }

    /**
     *  Se creo el setter para AttackThirdEnemy
     * @param attackSecondEnemy
     */
    public void setAttackSecondEnemy(boolean attackSecondEnemy) {
        this.attackSecondEnemy = attackSecondEnemy;
    }

    /**
     *  Se creo el setter para AttackThirdEnemy
     * @param canIStart
     */
    public void setCanIStart(boolean canIStart) {
        this.canIStart = canIStart;
    }

    /**
     *  Se creo el setter para AttackFirstEnemyWithHammer
     * @param attackFirstEnemyWithHammer AttackFirstEnemyWithHammer
     */
    public void setAttackFirstEnemyWithHammer(boolean attackFirstEnemyWithHammer) {
        this.attackFirstEnemyWithHammer = attackFirstEnemyWithHammer;
    }

    /**
     *  Se creo el setter para AttackSecondEnemyWithJump
     * @param attackSecondEnemyWithJump AttackSecondEnemyWithJump
     */
    public void setAttackSecondEnemyWithJump(boolean attackSecondEnemyWithJump) {
        this.attackSecondEnemyWithJump = attackSecondEnemyWithJump;
    }

    /**
     *  Se creo el setter para AttackThirdEnemyWithHammer
     * @param attackThirdEnemyWithHammer AttackThirdEnemyWithHammer
     */
    public void setAttackThirdEnemyWithHammer(boolean attackThirdEnemyWithHammer) {
        this.attackThirdEnemyWithHammer = attackThirdEnemyWithHammer;
    }

    /**
     *  Se creo el setter para AttackThirdEnemyWithJump
     * @param attackThirdEnemyWithJump AttackThirdEnemyWithJump
     */
    public void setAttackThirdEnemyWithJump(boolean attackThirdEnemyWithJump) {
        this.attackThirdEnemyWithJump = attackThirdEnemyWithJump;
    }

    /**
     *  Se creo el setter para AttackSecondEnemyWithHammer
     * @param attackSecondEnemyWithHammer AttackSecondEnemyWithHammer
     */
    public void setAttackSecondEnemyWithHammer(boolean attackSecondEnemyWithHammer) {
        this.attackSecondEnemyWithHammer = attackSecondEnemyWithHammer;
    }





}

