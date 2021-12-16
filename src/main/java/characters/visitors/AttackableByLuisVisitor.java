package characters.visitors;

import characters.controller.GameController;
import characters.enemies.BooEnemyCharacter;
import characters.enemies.GoombaEnemyCharacter;
import characters.enemies.SpinyEnemycharacter;
import characters.maincharacter.interfaces.AttackableByLuis;

import java.util.ArrayList;
import java.util.List;

/**
 * Se creo una clase visitor para los atatcanle por luis
 */
public class AttackableByLuisVisitor extends Visitor{
    private List<AttackableByLuis> listAttackableByLuis = new ArrayList<>();

    @Override
    public void visitGoomba(GoombaEnemyCharacter goomba) {
        listAttackableByLuis.add(goomba);
    }

    @Override
    public void visitSpiny(SpinyEnemycharacter spiny) {
         listAttackableByLuis.add(spiny);

    }

    /**
     * Se creo un metodo que permite obtener una lista
     * con los atacables por luis
     * @return lista attacables por luis
     * */
    public List<AttackableByLuis> getResul(){
         return listAttackableByLuis;

    }
}
