import character.cc3002.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CharacterTest {
    private LuisMainCharacter Luis;
    private MarcosMainCharacter Marco;
    private GoombaEnemyCharacter Goomba;
    private SpinyEnemycharacter Spiny;
    private BooEnemyCharacter Boo;


    @BeforeEach
    public void setUp() {
        Luis = new LuisMainCharacter( 1, 15, 10, 7, 50,10);
        Marco = new MarcosMainCharacter(2, 20, 15 ,0, 50, 13 );
        Goomba = new GoombaEnemyCharacter(5,5,30,0,50);
        Spiny = new SpinyEnemycharacter(8,10,15,10,50);
        Boo = new BooEnemyCharacter(1,4,70,8,50);}


    @Test
    public void testConstructorLuisMainCharacter() {
        Assertions.assertEquals(Luis.getHitpoints(),7);
        Luis.setHitpoints(8);
        Assertions.assertEquals(Luis.getHitpoints(),8);

        Assertions.assertEquals(Luis.getPower(), 15);
        Luis.setPower(8);
        Assertions.assertEquals(Luis.getPower(),8);

        Assertions.assertEquals(Luis.getDefence(), 10);
        Luis.setDefence(12);
        Assertions.assertEquals(Luis.getDefence(),12);

        Assertions.assertEquals(Luis.getHitpointmax(),50);
        Luis.setHitpointmax(70);
        Assertions.assertEquals(Luis.getHitpointmax(),70);

        Assertions.assertEquals(Luis.getAttackpoints(), 10);
        Luis.setAttackpoints(12);
        Assertions.assertEquals(Luis.getAttackpoints(), 12);

        Luis.canIattack();
        Assertions.assertTrue(Luis.isIamalive());

        Luis.setHitpoints(0);
        Luis.canIattack();
        Assertions.assertFalse(Luis.isIamalive());

    }




    @Test
    public void testConstructorMarcoMainCharacter() {
        Assertions.assertEquals(Marco.getHitpoints(), 0);
        Marco.setHitpoints(10);
        Assertions.assertEquals(Marco.getHitpoints(), 10);

        Assertions.assertEquals(Marco.getLevel(), 2);
        Marco.setLevel(4);
        Assertions.assertEquals(Marco.getLevel(), 4);

        Assertions.assertEquals(Marco.getPower(), 20);
        Marco.setPower(6);
        Assertions.assertEquals(Marco.getPower(), 6);

        Assertions.assertEquals(Marco.getDefence(), 15);
        Marco.setDefence(13);
        Assertions.assertEquals(Marco.getDefence(), 13);

        Assertions.assertEquals(Marco.getHitpointmax(), 50);
        Marco.setHitpointmax(20);
        Assertions.assertEquals(Marco.getHitpointmax(), 20);

        Assertions.assertEquals(Marco.getAttackpoints(), 13);
        Marco.setAttackpoints(15);
        Assertions.assertEquals(Marco.getAttackpoints(), 15);

        Assertions.assertTrue(Marco.isIamalive());

        Marco.setHitpoints(0);
        Marco.canIattack();
        Assertions.assertFalse(Marco.isIamalive());
    }

    @Test
    public void testConstructorBooEnemyCharacter() {
        Assertions.assertEquals(Boo.getLevel(), 1);
        Boo.setLevel(5);
        Assertions.assertEquals(Boo.getLevel(), 5);

        Assertions.assertEquals(Boo.getPower(), 4);
        Boo.setPower(10);
        Assertions.assertEquals(Boo.getPower(), 10);

        Assertions.assertEquals(Boo.getHitpoints(), 8);
        Boo.setHitpoints(13);
        Assertions.assertEquals(Boo.getHitpoints(), 13);

        Assertions.assertEquals(Boo.getDefence(), 70);
        Boo.setDefence(20);
        Assertions.assertEquals(Boo.getDefence(), 20);

        Assertions.assertEquals(Boo.getHitpointmax(), 50);
        Boo.setHitpointmax(100);
        Assertions.assertEquals(Boo.getHitpointmax(), 100);

        Assertions.assertTrue(Boo.isIamalive());

        Boo.setHitpoints(0);
        Boo.canIattack();
        Assertions.assertFalse(Boo.isIamalive());

    }

    @Test
    public void testConstructorGoombaEnemyCharacter() {
        Assertions.assertEquals(Goomba.getLevel(), 5);
        Goomba.setLevel(12);
        Assertions.assertEquals(Goomba.getLevel(), 12);

        Assertions.assertEquals(Goomba.getPower(), 5);
        Goomba.setPower(10);
        Assertions.assertEquals(Goomba.getPower(), 10);

        Assertions.assertEquals(Goomba.getHitpoints(), 0);
        Goomba.setHitpoints(12);
        Assertions.assertEquals(Goomba.getHitpoints(), 12);

        Assertions.assertEquals(Goomba.getDefence(), 30);
        Goomba.setDefence(20);
        Assertions.assertEquals(Goomba.getDefence(), 20);

        Assertions.assertEquals(Goomba.getHitpointmax(), 50);
        Goomba.setHitpointmax(80);
        Assertions.assertEquals(Goomba.getHitpointmax(), 80);

        Assertions.assertTrue(Goomba.isIamalive());

        Goomba.setHitpoints(0);
        Goomba.canIattack();
        Assertions.assertFalse(Goomba.isIamalive());
    }

    @Test
    public void testConstructorSpinyEnemyCharacter() {
        Assertions.assertEquals(Spiny.getLevel(), 8);
        Spiny.setLevel(12);
        Assertions.assertEquals(Spiny.getLevel(), 12);

        Assertions.assertEquals(Spiny.getPower(), 10);
        Spiny.setPower(12);
        Assertions.assertEquals(Spiny.getPower(), 12);

        Assertions.assertEquals(Spiny.getHitpoints(), 10);
        Spiny.setHitpoints(14);
        Assertions.assertEquals(Spiny.getHitpoints(), 14);

        Assertions.assertEquals(Spiny.getDefence(), 15);
        Spiny.setDefence(23);
        Assertions.assertEquals(Spiny.getDefence(), 23);

        Assertions.assertEquals(Spiny.getHitpointmax(), 50);
        Spiny.setHitpointmax(90);
        Assertions.assertEquals(Spiny.getHitpointmax(), 90);

        Assertions.assertTrue(Spiny.isIamalive());

        Spiny.setHitpoints(0);
        Spiny.canIattack();
        Assertions.assertFalse(Spiny.isIamalive());

    }

    @Test
    public void testtakeItemStar() {
        Luis.takeItemStar();
        Assertions.assertEquals(Luis.getHitpoints(), 7);
        Marco.takeItemStar();
        Assertions.assertEquals(Marco.getHitpoints(), 0);
    }

    @Test
    public void testtakeItemRedMushroom() {
        Luis.takeItemRedMushroom();
        Assertions.assertEquals(Luis.getHitpoints(), 12);
        Marco.takeItemRedMushroom();
        Assertions.assertEquals(Marco.getHitpoints(), 5);
    }

    @Test
    public void testtakeItemHoneySyrup() {
        Luis.takeItemHoneySyrup();
        Assertions.assertEquals(Luis.getAttackpoints(), 13);
        Marco.takeItemHoneySyrup();
        Assertions.assertEquals(Marco.getAttackpoints(), 16);
    }

    @Test
    public void testreceivesAttackFromBoo() {
        Luis.receivesAttackFromBoo(Boo);
        Assertions.assertTrue(Boo.isIamalive());
        Assertions.assertEquals(Luis.getHitpoints(), 6.7);

        Marco.receivesAttackFromBoo(Boo);
        Assertions.assertTrue(Boo.isIamalive());
        Assertions.assertEquals(Marco.getHitpoints(), 0);

        Marco.setHitpoints(10);
        Marco.receivesAttackFromBoo(Boo);
        Assertions.assertTrue(Boo.isIamalive());
        Assertions.assertEquals(Marco.getHitpoints(), 10);

    }

    @Test
    public void testreceivesAttackFromSpiny() {
        Luis.receivesAttackFromSpiny(Spiny);
        Assertions.assertTrue(Spiny.isIamalive());
        Assertions.assertEquals(Luis.getHitpoints(), 1);

        Marco.receivesAttackFromSpiny(Spiny);
        Assertions.assertTrue(Spiny.isIamalive());
        Assertions.assertEquals(Marco.getHitpoints(), 0);

        Marco.setHitpoints(10);
        Marco.receivesAttackFromSpiny(Spiny);
        Assertions.assertTrue(Spiny.isIamalive());
        Assertions.assertEquals(Marco.getHitpoints(), 6);
    }

    @Test
    public void testreceivesAttackFromGoomba() {
        Luis.receivesAttackFromGoomba(Goomba);
        Assertions.assertFalse(Goomba.isIamalive());
        Goomba.setHitpoints(10);
        Luis.receivesAttackFromGoomba(Goomba);
        Assertions.assertTrue(Goomba.isIamalive());
        Assertions.assertEquals( Luis.getHitpoints(), 5.125);

    }



    @Test
    public void testreceivesAttackFromLuis() {
        Goomba.receivesAttackFromLuis(Luis,MainCharacterAttack.Jump);
        Assertions.assertTrue(Luis.isIamalive());
        Luis.setHitpoints(0);
        Goomba.receivesAttackFromLuis(Luis,MainCharacterAttack.Jump);
        Assertions.assertFalse(Luis.isIamalive());

        Luis.setHitpoints(7);
        Spiny.receivesAttackFromLuis(Luis,MainCharacterAttack.Jump);
        Assertions.assertTrue(Luis.isIamalive());
        Luis.setHitpoints(0);
        Spiny.receivesAttackFromLuis(Luis,MainCharacterAttack.Jump);
        Assertions.assertFalse(Luis.isIamalive());

        Luis.setHitpoints(7);
        Boo.receivesAttackFromLuis(Luis,MainCharacterAttack.Jump);
        Assertions.assertTrue(Luis.isIamalive());
        Luis.setHitpoints(0);
        Boo.receivesAttackFromLuis(Luis,MainCharacterAttack.Jump);
        Assertions.assertFalse(Luis.isIamalive());





    }


    @Test
    public void testreceivesAttackFromMarco() {

        Goomba.receivesAttackFromMarcos(Marco,MainCharacterAttack.Jump);
        Assertions.assertFalse(Marco.isIamalive());
        Marco.setHitpoints(10);
        Goomba.receivesAttackFromMarcos(Marco,MainCharacterAttack.Jump);
        Assertions.assertTrue(Marco.isIamalive());

        Marco.setHitpoints(0);
        Spiny.receivesAttackFromMarcos(Marco,MainCharacterAttack.Jump);
        Assertions.assertFalse(Marco.isIamalive());
        Marco.setHitpoints(10);
        Spiny.receivesAttackFromMarcos(Marco,MainCharacterAttack.Jump);
        Assertions.assertTrue(Marco.isIamalive());

        Marco.setHitpoints(0);
        Boo.receivesAttackFromMarcos(Marco,MainCharacterAttack.Jump);
        Assertions.assertFalse(Marco.isIamalive());
        Marco.setHitpoints(19);
        Boo.receivesAttackFromMarcos(Marco,MainCharacterAttack.Jump);
        Assertions.assertTrue(Marco.isIamalive());

    }

}


