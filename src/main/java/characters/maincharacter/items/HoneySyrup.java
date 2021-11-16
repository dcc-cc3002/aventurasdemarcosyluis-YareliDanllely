package characters.maincharacter.items;
import characters.maincharacter.interfaces.PrincipalCharacter;

public class HoneySyrup implements Items{

    @Override
    public void use(PrincipalCharacter character) {
        character.useItemHoneySyrup();
    }
}
