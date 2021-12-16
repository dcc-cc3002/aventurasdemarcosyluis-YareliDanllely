import characters.controller.GameController;
import characters.phases.exceptions.InvalidTransitionException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Random;

public class ExceptionTest {
    private GameController controller;
    private Random random;

    @BeforeEach
    public void setUp() {
        controller = new GameController();
        random = new Random();
        controller.createPlayers();
        controller.createEnemies(3, random);

    }

    @Test
    public void TestInvalidTransitionExeption() {
        Assertions.assertThrows(InvalidTransitionException.class, () -> controller.getPhase().EndTurn());
        Assertions.assertThrows(InvalidTransitionException.class, () -> controller.getPhase().starTurnOfPlayer());
        Assertions.assertThrows(InvalidTransitionException.class, () -> controller.getPhase().chooseEnemy());
        Assertions.assertThrows(InvalidTransitionException.class, ()-> controller.getPhase().chooseAttackForFirstEnemy());
        Assertions.assertThrows(InvalidTransitionException.class, ()-> controller.getPhase().chooseAttackForSecondEnemy());
        Assertions.assertThrows(InvalidTransitionException.class, ()-> controller.getPhase().chooseAttackForThirdEnemy());


        Assertions.assertThrows(InvalidTransitionException.class, ()-> controller.getPhase().toWaitPhaseToChooseEnemyToAttack());
        Assertions.assertThrows(InvalidTransitionException.class, ()-> controller.getPhase().toPlayerToChooseAttackForFirstEnemy());
        Assertions.assertThrows(InvalidTransitionException.class, ()-> controller.getPhase().toPlayerToChooseAttackForSecondEnemy());
        Assertions.assertThrows(InvalidTransitionException.class, ()-> controller.getPhase().toPlayerToChooseAttackForThirdEnemy());

        Assertions.assertThrows(InvalidTransitionException.class, ()-> controller.getPhase().toAttackFirstEnemyWithHammerPhase());
        Assertions.assertThrows(InvalidTransitionException.class, ()-> controller.getPhase().toAttackFirstEnemyWithJumpPhase());

        Assertions.assertThrows(InvalidTransitionException.class, ()-> controller.getPhase().toAttackSecondEnemyWithHammerPhase());
        Assertions.assertThrows(InvalidTransitionException.class, ()-> controller.getPhase().toAttackSecondEnemyWithJumpPhase());

        Assertions.assertThrows(InvalidTransitionException.class, ()-> controller.getPhase().toAttackThirdEnemyWithHammerPhase());
        Assertions.assertThrows(InvalidTransitionException.class, ()-> controller.getPhase().toAttackThirdEnemyWithJumpPhase());

        Assertions.assertThrows(InvalidTransitionException.class, ()-> controller.getPhase().toStartPhase());
        Assertions.assertThrows(InvalidTransitionException.class, ()-> controller.getPhase().toEndTurnPhase());






    }
}
