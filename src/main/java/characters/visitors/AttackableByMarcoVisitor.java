package characters.visitors;
import characters.enemies.BooEnemyCharacter;
import characters.enemies.GoombaEnemyCharacter;
import characters.enemies.SpinyEnemycharacter;
import characters.maincharacter.interfaces.AttackableByLuis;
import characters.maincharacter.interfaces.AttackablebyMarco;

import java.util.ArrayList;
import java.util.List;

/**
 * Se creo un visitor para obtener los atables por marco
 */

public class AttackableByMarcoVisitor extends Visitor{
    private List<AttackablebyMarco> listAttackableByMarco = new ArrayList<>();


    @Override
    public void visitBoo(BooEnemyCharacter boo) {
        listAttackableByMarco.add(boo);

    }

    @Override
    public void visitGoomba(GoombaEnemyCharacter goomba) {
        listAttackableByMarco.add(goomba);
    }

    @Override
    public void visitSpiny(SpinyEnemycharacter spiny) {
        listAttackableByMarco.add(spiny);

    }

    /**
     * Se obtuvo el getter de la lista atacables por marco
     * @return lista de atacables por marco
     */
    public List<AttackablebyMarco> getResul(){
        return listAttackableByMarco;

    }
}
