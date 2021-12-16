package characters.enemies.interfaces;

import characters.visitors.Visitor;

public interface Enemies {

    /**
     * Se creo un aceptar un visitor
     * @param visitor
     */
    void acceptVisitor(Visitor visitor);

    /**
     * Se creo el getter del poder del personaje
     * @return devolviendo dicho valor
     */
    int getHitPoints();





}
