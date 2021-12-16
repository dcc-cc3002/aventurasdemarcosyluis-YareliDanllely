package characters;

import characters.visitors.IAmMarcosVisitor;
import characters.visitors.Visitor;

public interface Character {

    /**
     * Se creo el getter del atributo que refleja si el personaje esta muerto o no
     * @return iAmAlive
     */
    boolean isiAmAlive();

    /**
     * Se creo el getter de el atributo nivel
     * @return devolviendo dicho valor
     */
    int getLevel();

    /**
     * Se creo el getter del poder del personaje
     * @return devolviendo dicho valor
     */
    int getPower();

    /**
     * Se creo el getter del poder del personaje
     * @return devolviendo dicho valor
     */
    int getDefence();

    /**
     * Se creo el getter del poder del personaje
     * @return devolviendo dicho valor
     */
    int getHitPoints();


    /**
     * Se creo el getter de la cantidad de vida del personaje
     * @return hitPointmax
     */
    int getHitPointMax();


    /**
     * Se creo el setter de la cantidad de puntos de vida que tiene el personaje
     * ademas se puso una restriccion para cuando se quiera asignar un valor negativo
     * se cambie este por cero
     * @param hitPoints puntos de vida
     */

    void setHitPoints(int hitPoints);

    /**
     * Permite saber si el personame es enemigo o no
     * @return verdadero o falso
     */
    boolean iAmEnemy();

    /**
     * Se creo un aceptar un visitor
     * @param visitor
     */
    void acceptVisitor(Visitor visitor);


}
