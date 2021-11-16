package characters.maincharacter.items;

import characters.maincharacter.interfaces.PrincipalCharacter;

/**
 * Se creó una interfaz que permitirá8 relacion
 * los item con los personajes principales8
 */
public interface Items {

    /**
     * S creó un método use que permitira
     * utilizar los items
     * @param character personaje
     */
    void use(PrincipalCharacter character);
}
