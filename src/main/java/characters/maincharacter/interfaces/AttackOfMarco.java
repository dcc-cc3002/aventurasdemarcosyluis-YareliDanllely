package characters.maincharacter.interfaces;

public interface AttackOfMarco {
    /**
     * Se creó el método ataque para marco con martillo
     * @param enemy enemigo
     */
    void attackWithHammer(AttackablebyMarco enemy);

    /**
     * Se creó el método ataque para marcos con salto
     * @param enemy enemigo
     */
    void attackWithJump(AttackablebyMarco enemy);
}
