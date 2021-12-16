import characters.controller.GameController;
import characters.enemies.BooEnemyCharacter;
import characters.enemies.GoombaEnemyCharacter;
import characters.enemies.SpinyEnemycharacter;
import characters.maincharacter.LuisMainCharacter;
import characters.maincharacter.MarcosMainCharacter;
import characters.maincharacter.baul.Baul;
import characters.maincharacter.items.HoneySyrup;
import characters.maincharacter.items.RedMushroom;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CharacterTest {
    private LuisMainCharacter Luis;
    private MarcosMainCharacter Marco;
    private GoombaEnemyCharacter Goomba;
    private SpinyEnemycharacter Spiny;
    private BooEnemyCharacter Boo;
    private RedMushroom redMushroom;
    private HoneySyrup honeySyrup;
    private GameController gameController;


    @BeforeEach
    public void setUp() {
        Luis = new LuisMainCharacter(1, 15, 10, 7, 50, 10,30);
        Marco = new MarcosMainCharacter(2, 20, 15, 0, 50, 13,30);
        Goomba = new GoombaEnemyCharacter(5, 5, 30, 0, 50);
        Spiny = new SpinyEnemycharacter(8, 10, 15, 10, 50);
        Boo = new BooEnemyCharacter(1, 4, 70, 8, 50);
        redMushroom = new RedMushroom();
        honeySyrup = new HoneySyrup();
    }



    @Test
    public void testConstructorLuisMainCharacter() {
        Assertions.assertEquals(Luis.getHitPoints(), 7);
        Luis.setHitPoints(8);
        Assertions.assertEquals(Luis.getHitPoints(), 8);

        Assertions.assertEquals(Luis.getPower(), 15);
        Luis.setPower(8);
        Assertions.assertEquals(Luis.getPower(), 8);

        Assertions.assertEquals(Luis.getDefence(), 10);
        Luis.setDefence(12);
        Assertions.assertEquals(Luis.getDefence(), 12);

        Assertions.assertEquals(Luis.getHitPointMax(), 50);
        Luis.setHitPointMax(70);
        Assertions.assertEquals(Luis.getHitPointMax(), 70);

        Assertions.assertEquals(Luis.getAttackPoints(), 10);
        Luis.setAttackPoints(12);
        Assertions.assertEquals(Luis.getAttackPoints(), 12);

        Luis.canIattack();
        Assertions.assertTrue(Luis.isiAmAlive());

        Luis.setHitPoints(0);
        Luis.canIattack();
        Assertions.assertFalse(Luis.isiAmAlive());

        Assertions.assertEquals(Luis.getAttackPointsMax(),30);
        Luis.setAttackPoints(20);
        Assertions.assertEquals(Luis.getAttackPoints(),20);

    }



        @Test
        public void testSetSeedLuis(){

        Luis.setSeed(2);
        Assertions.assertEquals(Luis.roll(),2);

        Luis.setSeed(396);
        Assertions.assertEquals(Luis.roll(),3);

        Luis.setSeed(7632);
        Assertions.assertEquals(Luis.roll(),0);


    }


    @Test
    public void testConstructorMarcoMainCharacter() {
        Assertions.assertEquals(Marco.getHitPoints(), 0);
        Marco.setHitPoints(10);
        Assertions.assertEquals(Marco.getHitPoints(), 10);

        Assertions.assertEquals(Marco.getLevel(), 2);
        Marco.setLevel(4);
        Assertions.assertEquals(Marco.getLevel(), 4);

        Assertions.assertEquals(Marco.getPower(), 20);
        Marco.setPower(6);
        Assertions.assertEquals(Marco.getPower(), 6);

        Assertions.assertEquals(Marco.getDefence(), 15);
        Marco.setDefence(13);
        Assertions.assertEquals(Marco.getDefence(), 13);

        Assertions.assertEquals(Marco.getHitPointMax(), 50);
        Marco.setHitPointMax(20);
        Assertions.assertEquals(Marco.getHitPointMax(), 20);

        Assertions.assertEquals(Marco.getAttackPoints(), 13);
        Marco.setAttackPoints(15);
        Assertions.assertEquals(Marco.getAttackPoints(), 15);

        Assertions.assertTrue(Marco.isiAmAlive());

        Marco.setHitPoints(0);
        Marco.canIattack();
        Assertions.assertFalse(Marco.isiAmAlive());

        Assertions.assertEquals(30,Marco.getAttackPointsMax());
        Marco.setAttackPointsMax(20);
        Assertions.assertEquals(20,Marco.getAttackPointsMax());

    }



    @Test
    public void testSetSeedAndRollMarco(){

        Marco.setSeed(4321);
        Assertions.assertEquals(0,Marco.roll());

        Marco.setSeed(1);
        Assertions.assertEquals(2,Marco.roll());

        Marco.setSeed(5678);
        Assertions.assertEquals(3,Marco.roll());

        Marco.setSeed(43);
        Assertions.assertEquals(2,Marco.roll());

        Marco.setSeed(6559);
        Assertions.assertEquals(1,Marco.roll());

    }

    @Test
    public void testConstructorBooEnemyCharacter() {
        Assertions.assertEquals(Boo.getLevel(), 1);
        Boo.setLevel(5);
        Assertions.assertEquals(Boo.getLevel(), 5);

        Assertions.assertEquals(Boo.getPower(), 4);
        Boo.setPower(10);
        Assertions.assertEquals(Boo.getPower(), 10);

        Assertions.assertEquals(Boo.getHitPoints(), 8);
        Boo.setHitPoints(13);
        Assertions.assertEquals(Boo.getHitPoints(), 13);

        Assertions.assertEquals(Boo.getDefence(), 70);
        Boo.setDefence(20);
        Assertions.assertEquals(Boo.getDefence(), 20);

        Assertions.assertEquals(Boo.getHitPointMax(), 50);
        Boo.setHitPointMax(100);
        Assertions.assertEquals(Boo.getHitPointMax(), 100);

        Assertions.assertTrue(Boo.isiAmAlive());

        Boo.setHitPoints(0);
        Boo.canIattack();
        Assertions.assertFalse(Boo.isiAmAlive());}



    @Test
    public void testConstructorGoombaEnemyCharacter() {
        Assertions.assertEquals(Goomba.getLevel(), 5);
        Goomba.setLevel(12);
        Assertions.assertEquals(Goomba.getLevel(), 12);

        Assertions.assertEquals(Goomba.getPower(), 5);
        Goomba.setPower(10);
        Assertions.assertEquals(Goomba.getPower(), 10);

        Assertions.assertEquals(Goomba.getHitPoints(), 0);
        Goomba.setHitPoints(12);
        Assertions.assertEquals(Goomba.getHitPoints(), 12);

        Assertions.assertEquals(Goomba.getDefence(), 30);
        Goomba.setDefence(20);
        Assertions.assertEquals(Goomba.getDefence(), 20);

        Assertions.assertEquals(Goomba.getHitPointMax(), 50);
        Goomba.setHitPointMax(80);
        Assertions.assertTrue(Goomba.isiAmAlive());

        Goomba.setHitPoints(0);
        Goomba.canIattack();
        Assertions.assertFalse(Goomba.isiAmAlive());
    }

    @Test
    public void testConstructorSpinyEnemyCharacter() {
        Assertions.assertEquals(Spiny.getLevel(), 8);
        Spiny.setLevel(12);
        Assertions.assertEquals(Spiny.getLevel(), 12);

        Assertions.assertEquals(Spiny.getPower(), 10);
        Spiny.setPower(12);
        Assertions.assertEquals(Spiny.getPower(), 12);

        Assertions.assertEquals(Spiny.getHitPoints(), 10);
        Spiny.setHitPoints(14);
        Assertions.assertEquals(Spiny.getHitPoints(), 14);

        Assertions.assertEquals(Spiny.getDefence(), 15);
        Spiny.setDefence(23);
        Assertions.assertEquals(Spiny.getDefence(), 23);

        Assertions.assertEquals(Spiny.getHitPointMax(), 50);
        Spiny.setHitPointMax(90);
        Assertions.assertEquals(Spiny.getHitPointMax(), 90);

        Assertions.assertTrue(Spiny.isiAmAlive());

        Spiny.setHitPoints(0);
        Spiny.canIattack();
        Assertions.assertFalse(Spiny.isiAmAlive());

    }

    @Test
    public void testUseItemRedMushroom() {
        redMushroom.use(Luis);
        Assertions.assertEquals(Luis.getHitPoints(), 12);
        redMushroom.use(Marco);
        Assertions.assertEquals(Marco.getHitPoints(), 5);
    }

    @Test
    public void testHoneySyrupUse(){
        honeySyrup.use(Marco);
        Assertions.assertEquals(Marco.getAttackPoints(), 16);
        honeySyrup.use(Luis);
        Assertions.assertEquals(Luis.getAttackPoints(), 13);

    }

    @Test
    public void testUseItemHoneySyrup() {
        Luis.useItemHoneySyrup();
        Assertions.assertEquals(Luis.getAttackPoints(), 13);
        Marco.useItemHoneySyrup();
        Assertions.assertEquals(Marco.getAttackPoints(), 16);
    }

    @Test
    public void testCalculateDamageFromSpiny(){
      Marco.setHitPoints(10);
      Marco.calculateDamageFromSpiny(Spiny);
      Assertions.assertEquals(Marco.getHitPoints(),6);
      Luis.calculateDamageFromBoo(Boo);
      Assertions.assertEquals(Luis.getHitPoints(),6);

    }

    @Test
    public void testCalculateDamageFromGoomba() {
      Marco.setHitPoints(10);
      Marco.calculateDamageFromGoomba(Goomba);
      Assertions.assertEquals(Marco.getHitPoints(),8);

      Luis.calculateDamageFromBoo(Boo);
      Assertions.assertEquals(Luis.getHitPoints(),6);


    }

    @Test
    public void testCalculateDamageFromBoo() {
       Luis.calculateDamageFromBoo(Boo);
       Assertions.assertEquals(Luis.getHitPoints(),6);

    }
    @Test
    public void testCalculateDamageFromMarco() {
       Goomba.setHitPoints(21);
       Goomba.calculateDamageFromMarcoWithHammer(Marco);
       Assertions.assertEquals(Goomba.getHitPoints(),19);

       Spiny.calculateDamageFromMarcoWithJump(Marco);
       Assertions.assertEquals(Spiny.getHitPoints(),10);

       Boo.calculateDamageFromMarcoWithJump(Marco);
       Assertions.assertEquals(Boo.getHitPoints(),6);

    }
    @Test
    public void testCalculateDamageFromLuis(){
      Goomba.setHitPoints(21);
      Goomba.calculateDamageFromLuisWithJump(Luis);
      Assertions.assertEquals(Goomba.getHitPoints(),21);

      Spiny.calculateDamageFromLuisWithHammer(Luis);
      Assertions.assertEquals(Goomba.getHitPoints(),21);


    }
    @Test
    public void testAttackByBoo() {
        Boo.attack(Luis);
        Assertions.assertTrue(Boo.isiAmAlive());
        Assertions.assertEquals(Luis.getHitPoints(), 6);


    }

    @Test
    public void testAttackBySpiny() {
        Spiny.attack(Luis);
        Assertions.assertTrue(Spiny.isiAmAlive());
        Assertions.assertEquals(Luis.getHitPoints(), 1);

        Spiny.attack(Marco);
        Assertions.assertTrue(Spiny.isiAmAlive());
        Assertions.assertEquals(Marco.getHitPoints(), 0);

        Marco.setHitPoints(10);
        Spiny.attack(Marco);
        Assertions.assertTrue(Spiny.isiAmAlive());
        Assertions.assertEquals(Marco.getHitPoints(), 6);
    }

    @Test
    public void testreceivesAttackFromGoomba() {
        Luis.receivesAttackFromGoomba(Goomba);
        Assertions.assertFalse(Goomba.isiAmAlive());

        Goomba.setHitPoints(10);
        Luis.receivesAttackFromGoomba(Goomba);
        Assertions.assertTrue(Goomba.isiAmAlive());
        Assertions.assertEquals(Luis.getHitPoints(), 5);

    }


    @Test
    public void testAttackByLuisWhitJump() {
        Luis.setSeed(1);
        Luis.attackWithJump(Goomba);
        Assertions.assertEquals(Goomba.getHitPoints(), 0);
        Assertions.assertEquals(Luis.getAttackPoints(), 10);

        Luis.setSeed(3);
        Goomba.setHitPoints(20);
        Luis.attackWithJump(Goomba);
        Assertions.assertEquals(Goomba.getHitPoints(), 20);
        Assertions.assertEquals(Luis.getAttackPoints(), 9);

        Luis.setSeed(3);
        Goomba.setDefence(10);
        Luis.attackWithJump(Goomba);
        Assertions.assertEquals(Goomba.getHitPoints(), 19);
        Assertions.assertEquals(Luis.getAttackPoints(), 8);

        Luis.setSeed(2);
        Luis.attackWithJump(Goomba);
        Assertions.assertEquals(Spiny.getHitPoints(), 10);
        Assertions.assertEquals(Luis.getAttackPoints(), 7);
    }


    @Test
    public void testAttackFromByWhitHammer() {

        Luis.setSeed(1);
        Luis.attackWithHammer(Goomba);
        Assertions.assertEquals(Luis.getAttackPoints(), 10);
        Assertions.assertEquals(Goomba.getHitPoints(), 0);

        Luis.setSeed(3);
        Goomba.setHitPoints(20);
        Luis.attackWithHammer(Goomba);
        Assertions.assertEquals(Luis.getAttackPoints(), 8);
        Assertions.assertEquals(Goomba.getHitPoints(), 19);


        Luis.setSeed(8);
        Goomba.setDefence(10);
        Luis.attackWithHammer(Goomba);
        Assertions.assertEquals(Luis.getAttackPoints(), 6);
        Assertions.assertEquals(Goomba.getHitPoints(), 16);

        Luis.setSeed(7632);
        Luis.attackWithHammer(Spiny);
        Assertions.assertEquals(Luis.getAttackPoints(), 6);
        Assertions.assertEquals(Spiny.getHitPoints(), 10);
    }

    @Test
    public void testAttackByMarcoWhitHammer() {

        Marco.setSeed(7);
        Marco.attackWithHammer(Spiny);
        Assertions.assertEquals(Marco.getAttackPoints(),13);
        Assertions.assertEquals(Spiny.getHitPoints(),10);

        Marco.setSeed(1);
        Marco.setHitPoints(20);
        Marco.attackWithHammer(Spiny);
        Assertions.assertEquals(Marco.getAttackPoints(),11);
        Assertions.assertEquals(Spiny.getHitPoints(),6);


        Marco.setSeed(4321);
        Marco.attackWithHammer(Boo);
        Assertions.assertEquals(Marco.getAttackPoints(),11);
        Assertions.assertEquals(Boo.getHitPoints(),8);

        Marco.setSeed(8);
        Goomba.setHitPoints(10);
        Goomba.setDefence(10);
        Marco.attackWithHammer(Goomba);
        Assertions.assertEquals(Marco.getAttackPoints(),9);
        Assertions.assertEquals(Goomba.getHitPoints(),4);

    }


    @Test
    public void testAttackByMarcoWhitJump() {
        Marco.setSeed(1);
        Marco.attackWithJump(Spiny);
        Assertions.assertEquals(Marco.getAttackPoints(),13);
        Assertions.assertEquals(Spiny.getHitPoints(),10);

        Marco.setSeed(3);
        Marco.setHitPoints(20);
        Marco.attackWithJump(Spiny);
        Assertions.assertEquals(Marco.getAttackPoints(),12);
        Assertions.assertEquals(Spiny.getHitPoints(),10);


        Marco.setSeed(18);
        Goomba.setHitPoints(15);
        Goomba.setDefence(10);
        Marco.attackWithJump(Spiny);
        Assertions.assertEquals(Marco.getAttackPoints(),11);
        Assertions.assertEquals(Goomba.getHitPoints(),15);


        Marco.setSeed(4321);
        Marco.attackWithJump(Boo);
        Assertions.assertEquals(Marco.getAttackPoints(),11);
        Assertions.assertEquals(Boo.getHitPoints(),8);
    }

    @Test
    public void testBaul() {
        Baul sharedBaul = new Baul();
        Luis.setBaul(sharedBaul);
        Marco.setBaul(sharedBaul);

        Luis.addHoneySyrupToBaul(1);
        Assertions.assertEquals(Luis.getAmountOfHoneySyrup(),1);
        Marco.addHoneySyrupToBaul(5);
        Assertions.assertEquals(Marco.getAmountOfHoneySyrup(),6);

        Luis.getBaul().removeHoneySyrup(1);
        Assertions.assertEquals(Luis.getAmountOfHoneySyrup(),5);
        Marco.getBaul().removeHoneySyrup(1);
        Assertions.assertEquals(Marco.getAmountOfHoneySyrup(),4);

        Luis.addRedMushroomToBaul(1);
        Assertions.assertEquals(Luis.getAmountOfRedMushroom(),1);
        Marco.addRedMushroomToBaul(10);
        Assertions.assertEquals(Luis.getAmountOfRedMushroom(),11);

        Marco.useItemRedMushroom();
        Assertions.assertEquals(Luis.getAmountOfRedMushroom(),10);
    }

    @Test
    public void testLevelUp(){
        Marco.setHitPoints(2);
        Marco.levelUp();
        Assertions.assertEquals(3,Marco.getLevel());
        Assertions.assertEquals(23,Marco.getPower());
        Assertions.assertEquals(17,Marco.getDefence());
        Assertions.assertEquals(17,Marco.getAttackPoints());
        Assertions.assertEquals(9,Marco.getHitPoints());

        Luis.levelUp();
        Assertions.assertEquals(2,Luis.getLevel());
        Assertions.assertEquals(17,Luis.getPower());
        Assertions.assertEquals(11,Luis.getDefence());
        Assertions.assertEquals(14,Luis.getAttackPoints());
        Assertions.assertEquals(14,Luis.getHitPoints());
    }


    }























