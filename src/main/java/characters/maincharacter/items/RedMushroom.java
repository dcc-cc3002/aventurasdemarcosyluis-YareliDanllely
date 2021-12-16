package characters.maincharacter.items;
import characters.maincharacter.interfaces.PrincipalCharacter;

/**
 * Se creo la clase RedMushroom
 */
public class RedMushroom implements Items {

    public RedMushroom() {
    }

    @Override
    public void use(PrincipalCharacter character) {
        character.useItemRedMushroom();

    }

}
