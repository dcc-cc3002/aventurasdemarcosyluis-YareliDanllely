import characters.controller.GameController;
import characters.enemies.BooEnemyCharacter;
import characters.enemies.GoombaEnemyCharacter;
import characters.enemies.SpinyEnemycharacter;
import characters.maincharacter.LuisMainCharacter;
import characters.maincharacter.MarcosMainCharacter;
import characters.phases.Phase;
import characters.phases.relatedtoenemy.EnemyStartTurnPhase;
import characters.phases.exceptions.InvalidTransitionException;
import characters.phases.relatedtoplayer.attackplayer.*;
import characters.visitors.IAmLuisVisitor;
import characters.visitors.IAmMarcosVisitor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Random;

public class PhasesTest {
    private GameController controller;
    private MarcosMainCharacter marco;
    private LuisMainCharacter luis;
    private GoombaEnemyCharacter goomba;
    private SpinyEnemycharacter spiny;
    private BooEnemyCharacter boo;
    private Random random;
    private Random randomTwo;
    private Random randomThree;
    private Phase phase;
    private EnemyStartTurnPhase enemyTurnPhase;
    private InvalidTransitionException invalidTransitionException;

    private IAmLuisVisitor iAmLuisVisitor;
    private IAmMarcosVisitor iAmMarcosVisitor;

    private characters.phases.relatedtoplayer.attackplayer.AttackFirstEnemyWithJumpPhase AttackFirstEnemyWithJumpPhase;
    private characters.phases.relatedtoplayer.attackplayer.AttackFirstEnemyWithHammerPhase AttackFirstEnemyWithHammerPhase;

    private AttackSecondEnemyWithHammer attackSecondEnemyWithHammer;
    private AttackSecondEnemyWithJumpPhase attackSecondEnemyWithJumpPhase;

    private AttackThirdEnemyWithJumpPhase attackThirdEnemyWithJumpPhase;
    private AttackThirdEnemyWithHammerPhase attackThirdEnemyWithHammerPhase;

    private WaitPhasePlayerChooseAttackForSecondEnemy WaitPhasePlayerChooseAttackForSecondEnemy;
    private WaitPhasePlayerChooseAttackForThirdEnemy waitPhasePlayerChooseAttackForThirdEnemy;
    private WaitPhasePlayerChooseAttackForFirstEnemy WaitPhasePlayerChooseAttackForFirstEnemy;

    private EnemyStartTurnPhase enemyStartTurnPhase;


    @BeforeEach
    public void setUp() {
        controller = new GameController();
        marco = new MarcosMainCharacter(2, 20, 15, 0, 50, 13, 30);
        luis = new LuisMainCharacter(1, 15, 10, 7, 50, 10, 30);
        goomba = new GoombaEnemyCharacter(5, 5, 30, 0, 50);
        spiny = new SpinyEnemycharacter(8, 10, 15, 10, 50);
        boo = new BooEnemyCharacter(1, 4, 70, 8, 50);
        random = new Random();
        randomTwo = new Random();
        randomThree = new Random();
        phase = new Phase();
        WaitPhasePlayerChooseAttackForFirstEnemy = new WaitPhasePlayerChooseAttackForFirstEnemy();
        WaitPhasePlayerChooseAttackForSecondEnemy = new WaitPhasePlayerChooseAttackForSecondEnemy();
        waitPhasePlayerChooseAttackForThirdEnemy = new WaitPhasePlayerChooseAttackForThirdEnemy();

        AttackFirstEnemyWithHammerPhase = new AttackFirstEnemyWithHammerPhase();
        AttackFirstEnemyWithJumpPhase = new AttackFirstEnemyWithJumpPhase();

        attackSecondEnemyWithHammer = new AttackSecondEnemyWithHammer();
        attackSecondEnemyWithJumpPhase = new AttackSecondEnemyWithJumpPhase();

        attackThirdEnemyWithHammerPhase= new AttackThirdEnemyWithHammerPhase();
        attackThirdEnemyWithJumpPhase = new AttackThirdEnemyWithJumpPhase();

        iAmLuisVisitor = new IAmLuisVisitor();
        iAmMarcosVisitor = new IAmMarcosVisitor();

        enemyStartTurnPhase = new EnemyStartTurnPhase();



    }

    @Test
    public void TestTryStartTurn() {
        controller.createPlayers();
        controller.createEnemies(3, random);
        Assertions.assertEquals("Start Phase", controller.getNameOfActualPhase());
        controller.tryStartTurn();
        Assertions.assertEquals("Wait Phase To Start Player Turn", controller.getNameOfActualPhase());

    }

    // Test Visitor

    @Test
    public void TestOfVisitor() {
        marco.acceptVisitor(iAmMarcosVisitor);
        Assertions.assertEquals(iAmMarcosVisitor.getResult(), true);
        luis.acceptVisitor(iAmLuisVisitor);
        Assertions.assertEquals(iAmLuisVisitor.getResult(), true);

    }


    //Test FLujo del juego


    //Inicio personajes princiapales

    @Test
    public void TestChooseUseItemInTurnOfPrincipalCharacter(){
        controller.createPlayers();
        controller.createEnemies(3, random);
        Assertions.assertEquals("Start Phase", controller.getNameOfActualPhase());
        controller.tryStartTurn();
        Assertions.assertEquals("Wait Phase To Start Player Turn", controller.getNameOfActualPhase());


    }

    @Test
    public void TestChoosePassInTurnOfPrincipalCharacter() {
        controller.createPlayers();
        controller.createEnemies(3, random);
        Assertions.assertEquals("Start Phase", controller.getNameOfActualPhase());
        controller.tryStartTurn();
        Assertions.assertEquals("Wait Phase To Start Player Turn", controller.getNameOfActualPhase());
    }

    @Test
    public void TestChooseAttackForFirstPlayer() {
        controller.createPlayers();
        controller.createEnemies(3, random);
        Assertions.assertEquals("Start Phase", controller.getNameOfActualPhase());
        controller.tryStartTurn();
        Assertions.assertEquals("Wait Phase To Start Player Turn", controller.getNameOfActualPhase());
        controller.getPhase().setAtacckEnemy(true);
        controller.tryStartTurnPlayer();
        Assertions.assertEquals("Wait Phase To Choose Enemy To Attack", controller.getNameOfActualPhase());
        controller.getPhase().setAttackFirstEnemy(true);
        controller.playerChooseEnemy();
        Assertions.assertEquals("Player To Choose Attack For First Enemy", controller.getNameOfActualPhase());

    }

    @Test
    public void TestChooseAttackSecondPlayer() {
        controller.createPlayers();
        controller.createEnemies(3, random);
        Assertions.assertEquals("Start Phase", controller.getNameOfActualPhase());
        controller.tryStartTurn();
        Assertions.assertEquals("Wait Phase To Start Player Turn", controller.getNameOfActualPhase());
        controller.getPhase().setAtacckEnemy(true);
        controller.tryStartTurnPlayer();
        Assertions.assertEquals("Wait Phase To Choose Enemy To Attack", controller.getNameOfActualPhase());
        controller.getPhase().setAttackSecondEnemy(true);
        controller.playerChooseEnemy();
        Assertions.assertEquals("Wait Phase Player Choose Attack For Second Enemy", controller.getNameOfActualPhase());
    }

    @Test
    public void testChooseAttackThirdPlayer() {
        controller.createPlayers();
        controller.createEnemies(3, random);
        Assertions.assertEquals("Start Phase", controller.getNameOfActualPhase());
        controller.tryStartTurn();
        Assertions.assertEquals("Wait Phase To Start Player Turn", controller.getNameOfActualPhase());
        controller.getPhase().setAtacckEnemy(true);
        controller.tryStartTurnPlayer();
        Assertions.assertEquals("Wait Phase To Choose Enemy To Attack", controller.getNameOfActualPhase());
        controller.getPhase().setAttackThirdEnemy(true);
        controller.playerChooseEnemy();
        Assertions.assertEquals("Wait Phase Player Choose Attack For Third Enemy", controller.getNameOfActualPhase());

    }


    @Test
    public void TestAttackFirstEnemy() {
        controller.createPlayers();
        controller.createEnemies(3, random);
        controller.setPhase(WaitPhasePlayerChooseAttackForFirstEnemy);
        WaitPhasePlayerChooseAttackForFirstEnemy.setAttackFirstEnemyWithJump(true);
        controller.playerChooseAttackForFirstEnemy();

    }

    @Test
    public void TestAttackFirstEnemy2() {
        controller.createPlayers();
        controller.createEnemies(3, random);
        controller.setPhase(WaitPhasePlayerChooseAttackForFirstEnemy);
        WaitPhasePlayerChooseAttackForFirstEnemy.setAttackFirstEnemyWithHammer(true);
        controller.playerChooseAttackForFirstEnemy();
        Assertions.assertEquals("Attack First Enemy With Hammer Phase", controller.getNameOfActualPhase());

    }



    @Test
    public void TestAttackSecondEnemy() {
        controller.createPlayers();
        controller.createEnemies(3, random);
        controller.setPhase(WaitPhasePlayerChooseAttackForSecondEnemy);
        WaitPhasePlayerChooseAttackForSecondEnemy.setAttackSecondEnemyWithJump(true);
        controller.playerChooseAttackForSecondEnemy();
        Assertions.assertEquals("Attack Second Enemy With Jump Phase", controller.getNameOfActualPhase());

    }


    @Test
    public void TestAttackThirdEnemy() {
        controller.createPlayers();
        controller.createEnemies(3, random);
        controller.setPhase(waitPhasePlayerChooseAttackForThirdEnemy);
        waitPhasePlayerChooseAttackForThirdEnemy.setAttackThirdEnemyWithJump(true);
        controller.playerChooseAttackForThirdEnemy();
        Assertions.assertEquals("Attack Third Enemy With Jump Phase", controller.getNameOfActualPhase());

    }

    @Test
    public void TestAttackThirdEnemy2() {
        controller.createPlayers();
        controller.createEnemies(3, random);
        controller.setPhase(waitPhasePlayerChooseAttackForThirdEnemy);
        waitPhasePlayerChooseAttackForThirdEnemy.setAttackThirdEnemyWithHammer(true);
        controller.playerChooseAttackForThirdEnemy();
        Assertions.assertEquals("Attack Third Enemy With Hammer Phase", controller.getNameOfActualPhase());

    }

    @Test
    public void TestAttackFirstEnemyWithJumpForMarco() {
        controller.createPlayers();
        random = new Random(1);
        controller.createEnemiesStructure(random);
        randomTwo = new Random(556);
        controller.createEnemiesStructure(randomTwo);
        randomThree = new Random(435);
        controller.createEnemiesStructure(randomThree);


        controller.setPhase(AttackFirstEnemyWithJumpPhase);
        controller.getPhase().setEndTurn(true);
        controller.setTurn(0);
        Assertions.assertEquals(controller.getPlayer(0).getClass(), marco.getClass());
        Assertions.assertEquals(controller.getPlayer(controller.getTurn()).getHitPoints(), 20);
        Assertions.assertEquals(controller.getEnemies(0).getClass(), goomba.getClass());
        Assertions.assertEquals(controller.getEnemies(0).getHitPoints(), 10);
        controller.attackFirstEnemyWithJump();
        Assertions.assertEquals(controller.getEnemies(0).getHitPoints(), 7);
        Assertions.assertEquals("Start Phase",controller.getNameOfActualPhase());





    }
    @Test
    public void TestAttackFirstEnemyWithJumpForlLuis() {
        controller.createPlayers();
        random = new Random(1);
        controller.createEnemiesStructure(random);
        randomTwo = new Random(556);
        controller.createEnemiesStructure(randomTwo);
        randomThree = new Random(435);
        controller.createEnemiesStructure(randomThree);


        controller.setPhase(AttackFirstEnemyWithJumpPhase);
        controller.getPhase().setEndTurn(true);
        controller.setTurn(0);
        Assertions.assertEquals(controller.getPlayer(1).getClass(), luis.getClass());
        Assertions.assertEquals(controller.getPlayer(controller.getTurn()).getHitPoints(), 20);
        Assertions.assertEquals(controller.getEnemies(0).getClass(), goomba.getClass());
        Assertions.assertEquals(controller.getEnemies(0).getHitPoints(), 10);
        controller.attackFirstEnemyWithJump();
        Assertions.assertEquals(controller.getEnemies(0).getHitPoints(), 7);
        Assertions.assertEquals("Start Phase",controller.getNameOfActualPhase());



    }

    @Test
    public void TestAttackFirstEnemyWithHammerForMarcos() {
        controller.createPlayers();
        random = new Random(1);
        controller.createEnemiesStructure(random);
        randomTwo = new Random(556);
        controller.createEnemiesStructure(randomTwo);
        randomThree = new Random(435);
        controller.createEnemiesStructure(randomThree);
        Assertions.assertEquals(controller.getPlayer(0).getClass(),marco.getClass());
        Assertions.assertEquals(controller.getPlayer(1).getClass(),luis.getClass());


        controller.setPhase(AttackFirstEnemyWithHammerPhase);
        controller.getPhase().setEndTurn(true);
        controller.setTurn(0);
        Assertions.assertEquals(controller.getPlayer(0).getClass(), marco.getClass());
        Assertions.assertEquals(controller.getPlayer(controller.getTurn()).getHitPoints(), 20);
        Assertions.assertEquals(controller.getEnemies(0).getClass(), goomba.getClass());
        Assertions.assertEquals(controller.getEnemies(0).getHitPoints(), 10);
        controller.attackFirstEnemyWithHammer();
        Assertions.assertEquals(controller.getEnemies(0).getHitPoints(), 10);
        Assertions.assertEquals("Start Phase",controller.getNameOfActualPhase());


    }
    @Test
    public void TestAttackFirstEnemyWithHammerForLuis() {
        controller.createPlayers();
        random = new Random(1);
        controller.createEnemiesStructure(random);
        randomTwo = new Random(556);
        controller.createEnemiesStructure(randomTwo);
        randomThree = new Random(435);
        controller.createEnemiesStructure(randomThree);
        Assertions.assertEquals(controller.getPlayer(0).getClass(),marco.getClass());
        Assertions.assertEquals(controller.getPlayer(1).getClass(),luis.getClass());


        controller.setPhase(AttackFirstEnemyWithHammerPhase);
        controller.getPhase().setEndTurn(true);
        controller.setTurn(1);
        Assertions.assertEquals(controller.getPlayer(1).getClass(), luis.getClass());
        Assertions.assertEquals(controller.getPlayer(controller.getTurn()).getHitPoints(), 20);
        Assertions.assertEquals(controller.getEnemies(0).getClass(), goomba.getClass());
        Assertions.assertEquals(controller.getEnemies(0).getHitPoints(), 10);
        controller.attackFirstEnemyWithHammer();
        Assertions.assertEquals(controller.getEnemies(0).getHitPoints(), 10);
        Assertions.assertEquals("Start Phase",controller.getNameOfActualPhase());


    }

    @Test
    public void TestAttackSecondEnemyWithJump() {
        controller.createPlayers();
        random = new Random(1);
        controller.createEnemiesStructure(random);
        randomTwo = new Random(556);
        controller.createEnemiesStructure(randomTwo);
        randomThree = new Random(435);
        controller.createEnemiesStructure(randomThree);


        controller.setPhase(attackSecondEnemyWithJumpPhase);
        controller.getPhase().setEndTurn(true);
        controller.setTurn(0);
        Assertions.assertEquals(controller.getPlayer(0).getClass(), marco.getClass());
        Assertions.assertEquals(controller.getPlayer(controller.getTurn()).getHitPoints(), 20);
        Assertions.assertEquals(controller.getEnemies(0).getClass(), goomba.getClass());
        Assertions.assertEquals(controller.getEnemies(0).getHitPoints(), 10);
        controller.attackSecondEnemyWithJump();
        Assertions.assertEquals(controller.getEnemies(0).getHitPoints(), 10);
        Assertions.assertEquals("Start Phase",controller.getNameOfActualPhase());

    }

    @Test
    public void TestAttackSecondEnemyWithJumpForLuis() {
        controller.createPlayers();
        random = new Random(1);
        controller.createEnemiesStructure(random);
        randomTwo = new Random(556);
        controller.createEnemiesStructure(randomTwo);
        randomThree = new Random(435);
        controller.createEnemiesStructure(randomThree);


        controller.setPhase(attackSecondEnemyWithJumpPhase);
        controller.getPhase().setEndTurn(true);
        controller.setTurn(0);
        Assertions.assertEquals(controller.getPlayer(1).getClass(), luis.getClass());
        Assertions.assertEquals(controller.getPlayer(controller.getTurn()).getHitPoints(), 20);
        Assertions.assertEquals(controller.getEnemies(0).getClass(), goomba.getClass());
        Assertions.assertEquals(controller.getEnemies(0).getHitPoints(), 10);
        controller.attackSecondEnemyWithJump();
        Assertions.assertEquals(controller.getEnemies(0).getHitPoints(), 10);
        Assertions.assertEquals("Start Phase",controller.getNameOfActualPhase());




    }

    @Test
    public void TestAttackSecondEnemyWithHammer() {

        controller.createPlayers();
        random = new Random(1);
        controller.createEnemiesStructure(random);
        randomTwo = new Random(556);
        controller.createEnemiesStructure(randomTwo);
        randomThree = new Random(435);
        controller.createEnemiesStructure(randomThree);
        Assertions.assertEquals(controller.getPlayer(0).getClass(),marco.getClass());
        Assertions.assertEquals(controller.getPlayer(1).getClass(),luis.getClass());


        controller.setPhase(attackSecondEnemyWithHammer);
        controller.getPhase().setEndTurn(true);
        controller.setTurn(0);
        Assertions.assertEquals(controller.getPlayer(0).getClass(), marco.getClass());
        Assertions.assertEquals(controller.getPlayer(controller.getTurn()).getHitPoints(), 20);
        Assertions.assertEquals(controller.getEnemies(0).getClass(), goomba.getClass());
        Assertions.assertEquals(controller.getEnemies(0).getHitPoints(), 10);
        controller.attackSecondEnemyWithHammer();
        Assertions.assertEquals(controller.getEnemies(0).getHitPoints(), 10);
        Assertions.assertEquals("Start Phase",controller.getNameOfActualPhase());




    }

    @Test
    public void TestAttackSecondEnemyWithHammer2() {

        controller.createPlayers();
        random = new Random(1);
        controller.createEnemiesStructure(random);
        randomTwo = new Random(556);
        controller.createEnemiesStructure(randomTwo);
        randomThree = new Random(435);
        controller.createEnemiesStructure(randomThree);
        Assertions.assertEquals(controller.getPlayer(0).getClass(),marco.getClass());
        Assertions.assertEquals(controller.getPlayer(1).getClass(),luis.getClass());


        controller.setPhase(attackSecondEnemyWithHammer);
        controller.getPhase().setEndTurn(true);
        controller.setTurn(0);
        Assertions.assertEquals(controller.getPlayer(1).getClass(), luis.getClass());
        Assertions.assertEquals(controller.getPlayer(controller.getTurn()).getHitPoints(), 20);
        Assertions.assertEquals(controller.getEnemies(0).getClass(), goomba.getClass());
        Assertions.assertEquals(controller.getEnemies(0).getHitPoints(), 10);
        controller.attackSecondEnemyWithHammer();
        Assertions.assertEquals(controller.getEnemies(0).getHitPoints(), 10);
        Assertions.assertEquals("Start Phase",controller.getNameOfActualPhase());




    }


    @Test
    public void TestAttackThirdEnemyWithJump() {
        controller.createPlayers();
        random = new Random(1);
        controller.createEnemiesStructure(random);
        randomTwo = new Random(556);
        controller.createEnemiesStructure(randomTwo);
        randomThree = new Random(435);
        controller.createEnemiesStructure(randomThree);


        controller.setPhase(attackThirdEnemyWithJumpPhase);
        controller.getPhase().setEndTurn(true);
        controller.setTurn(0);
        Assertions.assertEquals(controller.getPlayer(0).getClass(), marco.getClass());
        Assertions.assertEquals(controller.getPlayer(controller.getTurn()).getHitPoints(), 20);
        Assertions.assertEquals(controller.getEnemies(0).getClass(), goomba.getClass());
        Assertions.assertEquals(controller.getEnemies(0).getHitPoints(), 10);
        controller.attackThirdEnemyWithJump();
        Assertions.assertEquals(controller.getEnemies(0).getHitPoints(), 10);
        Assertions.assertEquals("Start Phase",controller.getNameOfActualPhase());


    }


    @Test
    public void TestAttackThirdEnemyWithHammer() {

        controller.createPlayers();
        random = new Random(1);
        controller.createEnemiesStructure(random);
        randomTwo = new Random(556);
        controller.createEnemiesStructure(randomTwo);
        randomThree = new Random(435);
        controller.createEnemiesStructure(randomThree);
        Assertions.assertEquals(controller.getPlayer(0).getClass(),marco.getClass());
        Assertions.assertEquals(controller.getPlayer(1).getClass(),luis.getClass());


        controller.setPhase(attackThirdEnemyWithHammerPhase);
        controller.getPhase().setEndTurn(true);
        controller.setTurn(0);
        Assertions.assertEquals(controller.getPlayer(0).getClass(), marco.getClass());
        Assertions.assertEquals(controller.getPlayer(controller.getTurn()).getHitPoints(), 20);
        Assertions.assertEquals(controller.getEnemies(0).getClass(), goomba.getClass());
        Assertions.assertEquals(controller.getEnemies(0).getHitPoints(), 10);
        controller.attackThirdEnemyWithHammer();
        Assertions.assertEquals(controller.getEnemies(0).getHitPoints(), 10);
        Assertions.assertEquals("Start Phase",controller.getNameOfActualPhase());



    }




}













