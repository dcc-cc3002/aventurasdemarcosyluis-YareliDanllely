package characters.visitors;

import characters.enemies.BooEnemyCharacter;
import characters.enemies.GoombaEnemyCharacter;
import characters.enemies.SpinyEnemycharacter;
import characters.maincharacter.LuisMainCharacter;
import characters.maincharacter.MarcosMainCharacter;

/**
 * Se creo la clase visitor
 */
public class Visitor {

    /**
     * Se creó un metodo que visita a Marco
     * @param marco Marco
     */
    public void visitMarco(MarcosMainCharacter marco){}

    /**
     * Se creo el visitor de luis, el cual al recibir un
     * luis cambia el valor de iAmLuis a verdadero
     * @param luis luis
     */

    public void visitLuis(LuisMainCharacter luis){}


    /**
     * Se creo el visitor de Boo
     * @param boo boo
     */
    public void visitBoo(BooEnemyCharacter boo){}

    /**
     * Se creo el visitor de Goomba
     */
    public void visitGoomba(GoombaEnemyCharacter goomba){}

    /**
     * Se creo el visitor de Spiny
     */

    public void visitSpiny(SpinyEnemycharacter spiny){}

}
