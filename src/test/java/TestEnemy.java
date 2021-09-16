
import com.example.aventurasdemarcoyluis.Enemies;
import com.example.aventurasdemarcoyluis.EnemyType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
public class TestEnemy {

    private Enemies testGoomba;
    private Enemies testBoo;

    @BeforeEach
    public void setUp() {
        testGoomba= new Enemies(2,4,15,8, EnemyType.GOOMBA);
        testBoo = new Enemies(5,9,3,8, EnemyType.BOO);
    }

    @Test
    public void constructorTest(){
        assertEquals(EnemyType.BOO,testBoo.getType());
        assertEquals(EnemyType.GOOMBA,testGoomba.getType());
    }
}
