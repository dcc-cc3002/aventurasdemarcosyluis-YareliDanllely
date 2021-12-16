package characters.visitors;

import characters.maincharacter.LuisMainCharacter;
import characters.maincharacter.MarcosMainCharacter;

/**
 * Se creo un visitor para visitar a marcos
 */
public class IAmMarcosVisitor extends Visitor {
    private Boolean iAmMarcos=false;


    @Override
    public void visitMarco(MarcosMainCharacter marco){
        iAmMarcos=true;
    }

    /**
     * Se creo un metodo para obtener el valor de iAmMarcos
     * @return true or false
     */

    public boolean getResult(){
        return iAmMarcos;
    }



}
