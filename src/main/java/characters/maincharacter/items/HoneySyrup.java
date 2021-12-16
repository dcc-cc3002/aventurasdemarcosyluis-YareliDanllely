package characters.maincharacter.items;
import characters.maincharacter.interfaces.PrincipalCharacter;

/**
 * Se creo la clase HoneySyrup
 */
public class HoneySyrup implements Items{

    @Override
    public void use(PrincipalCharacter character) {
        character.useItemHoneySyrup();
    }
}
