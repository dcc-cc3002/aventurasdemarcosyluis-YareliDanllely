import characters.Character;
import characters.controller.GameController;
import characters.enemies.BooEnemyCharacter;
import characters.enemies.GoombaEnemyCharacter;
import characters.enemies.SpinyEnemycharacter;
import characters.maincharacter.LuisMainCharacter;
import characters.maincharacter.MarcosMainCharacter;
import characters.maincharacter.interfaces.PrincipalCharacter;
import characters.maincharacter.items.RedMushroom;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Random;

public class GameControllerTest {
    private GameController controller;
    private MarcosMainCharacter marco;
    private LuisMainCharacter luis;
    private GoombaEnemyCharacter goomba;
    private SpinyEnemycharacter spiny;
    private BooEnemyCharacter boo;
    private Random random;
    private Random randomTwo;
    private Random randomThree;
    private RedMushroom redMushroom;


    @BeforeEach
    public void setUp(){
        controller = new GameController();
        marco = new MarcosMainCharacter(2, 20, 15, 0, 50, 13,30);
        luis = new LuisMainCharacter(1, 15, 10, 7, 50, 10,30);
        goomba = new GoombaEnemyCharacter(5, 5, 30, 0, 50);
        spiny = new SpinyEnemycharacter(8, 10, 15, 10, 50);
        boo = new BooEnemyCharacter(1, 4, 70, 8, 50);
        redMushroom = new RedMushroom();


    }

    @Test
    public void testCreatePlayers(){
        controller.createPlayers();
        Assertions.assertEquals(controller.getPlayer(0).getClass(),marco.getClass());
        Assertions.assertEquals(controller.getPlayer(0).getLevel(),1);
        Assertions.assertEquals(controller.getPlayer(0).getHitPoints(),20);

        Assertions.assertEquals(controller.getPlayer(1).getClass(),luis.getClass());
        Assertions.assertEquals(controller.getPlayer(1).getLevel(),1);
        Assertions.assertEquals(controller.getPlayer(1).getHitPoints(),20);
    }

    @Test
    public void testCreateEnemies(){
        random = new Random(1445);
        controller.createPlayers();
        controller.createEnemiesStructure(random);
        Assertions.assertEquals(controller.getPlayer(2).getClass(),goomba.getClass());}

    @Test
    public void testCreateEnemies2(){
        randomTwo = new Random(565);
        controller.createPlayers();
        controller.createEnemiesStructure(randomTwo);
        Assertions.assertEquals(controller.getPlayer(2).getClass(),spiny.getClass());

    }

    @Test
    public void testCreateEnemies3(){
        randomThree = new Random(143);
        controller.createPlayers();
        controller.createEnemiesStructure(randomThree);
        Assertions.assertEquals(controller.getPlayer(2).getClass(),boo.getClass());}



    @Test
    public void testRemoveKoCharacter(){
        random = new Random();
        controller.createPlayers();
        controller.createEnemies(3,random);
        controller.getListOfPlayers().get(0).setHitPoints(0);
        Assertions.assertEquals(controller.getPlayer(0).getClass(),marco.getClass());
        controller.removeKoCharacter();
        Assertions.assertNotEquals(controller.getPlayer(0).getClass(),marco.getClass());
    }

    @Test
    public void testUseItemOfBaul(){
        random = new Random();
        controller.createPlayers();
        controller.createEnemies(3,random);
        controller.playerUseItemOfBaul( redMushroom, (PrincipalCharacter) controller.getPlayer(0));
        Assertions.assertEquals(2,controller.getItemsOfBaul().get(1));


    }

    @Test
    public void testTurn(){
        controller.createPlayers();
        random = new Random(1);
        controller.createEnemiesStructure(random);
        randomTwo = new Random(556);
        controller.createEnemiesStructure(randomTwo);
        randomThree = new Random(435);
        controller.createEnemiesStructure(randomThree);
        controller.setTurn(1);
        Assertions.assertEquals(controller.shiftCharacter(controller.getTurn()).getClass(), luis.getClass());
        controller.setTurn(0);
        Assertions.assertEquals(controller.shiftCharacter(controller.getTurn()).getClass(),marco.getClass());
        controller.setTurn(2);
        Assertions.assertEquals(controller.shiftCharacter(controller.getTurn()).getClass(),goomba.getClass());
        controller.setTurn(3);
        Assertions.assertEquals(controller.shiftCharacter(controller.getTurn()).getClass(),spiny.getClass());
        controller.setTurn(4);
        Assertions.assertEquals(controller.shiftCharacter(controller.getTurn()).getClass(),boo.getClass());

    }
    @Test
    public void testShiftNextCharacter(){
        controller.createPlayers();
        random = new Random(1);
        controller.createEnemiesStructure(random);
        randomTwo = new Random(556);
        controller.createEnemiesStructure(randomTwo);
        randomThree = new Random(435);
        controller.createEnemiesStructure(randomThree);
        controller.setTurn(0);
        Assertions.assertEquals(controller.shiftNextCharacter().getClass(),luis.getClass());
    }

    @Test
    public void TestEndTurn(){
        controller.createPlayers();
        random = new Random(1);
        controller.createEnemiesStructure(random);
        randomTwo = new Random(556);
        controller.createEnemiesStructure(randomTwo);
        randomThree = new Random(435);
        controller.createEnemiesStructure(randomThree);
        controller.setTurn(2);
        Assertions.assertEquals(controller.shiftCharacter(controller.getTurn()).getClass(),goomba.getClass());
        Assertions.assertEquals(controller.shiftNextCharacter().getClass(),spiny.getClass());
        controller.endTurn();
        Assertions.assertEquals(controller.shiftCharacter(controller.getTurn()).getClass(),spiny.getClass() );
    }

    @Test
    public void TestThePrincipalCharacterWon(){
        controller.createPlayers();
        Assertions.assertEquals(controller.thePrincipalCharacterWon(marco,luis),true);
        random = new Random(1);
        controller.createEnemiesStructure(random);
        randomTwo = new Random(556);
        controller.createEnemiesStructure(randomTwo);
        randomThree = new Random(435);
        controller.createEnemiesStructure(randomThree);
        Assertions.assertEquals(controller.thePrincipalCharacterWon(marco,luis),false);
        controller.getPlayer(0).setHitPoints(0);
        controller.getPlayer(1).setHitPoints(0);
        controller.removeKoCharacter();
        Assertions.assertEquals(controller.thePrincipalCharacterWon(marco,luis),false);

    }





}

