package characters.visitors;

import characters.maincharacter.LuisMainCharacter;

/**
 * Se creo un visitor que permira visitar a luis
 */
public class IAmLuisVisitor extends Visitor {
    private boolean iAmLuis=false;


    @Override
    public void visitLuis(LuisMainCharacter luis){
        iAmLuis=true;
    }

    /**
     * Se creo un metodo para obtener el resultado de
     * iAmLuis
     * @return true or false
     */
    public boolean getResult(){
        return iAmLuis;
    }


}
