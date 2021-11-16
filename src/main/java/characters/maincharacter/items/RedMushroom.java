package characters.maincharacter.items;

import characters.maincharacter.baul.Baul;
import characters.maincharacter.interfaces.PrincipalCharacter;

public class RedMushroom implements Items {

    public RedMushroom() {
    }

    @Override
    public void use(PrincipalCharacter character) {
        character.useItemRedMushroom();

    }

}
