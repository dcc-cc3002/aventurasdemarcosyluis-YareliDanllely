package characters.maincharacter.baul;
import characters.maincharacter.items.HoneySyrup;
import characters.maincharacter.items.Items;
import characters.maincharacter.items.RedMushroom;

import java.util.HashMap;

/**
 * Se creó un Baul que puede almacenar, eliminar
 * y agregar items
 */
public class Baul {
    private HashMap Baul;
    private RedMushroom redMushroom;
    private HoneySyrup honeySyrup;


    public Baul() {
        redMushroom = new RedMushroom();
        honeySyrup = new HoneySyrup();
        Baul = new HashMap<Items, Integer>();
        Baul.put(redMushroom,0);
        Baul.put(honeySyrup,0);
    }

    /**
     * Se creó un método que obtiene la cantidad
     * de HoneySyrup presentes en el Baul
     * @return Cantidad de HoneySyrup
     */
    public int getAmountOfHoneySyrup(){
        return (int) Baul.get(honeySyrup);
    }

    /**
     * Se creó un método que obtiene la cantidad
     * de RedMushroom presentes en el Baul
     * @return Cantidad de RedMushroom
     */
    public int getAmountOfRedMushroom(){
        return (int) Baul.get(redMushroom);
    }

    /**
     * Se creó un método que agregara cantidades
     * de RedMushroom
     * @param value cantidad
     */
    public void addAmountOfRedMushroom(int value){
        int amount = (int) Baul.get(redMushroom);
        Baul.put(redMushroom,amount+value);
    }

    /**
     * Se creó un método que agregara cantidades
     * de HoneySyrup
     * @param value cantidad
     */
    public void addAmountOfHoneySyrup(int value){
        int amount = (int) Baul.get(honeySyrup);
        Baul.put(honeySyrup ,amount+value);
    }

    /**
     * Se creó un método que eliminara cantidades
     * de RedMushroom
     * @param value cantidad
     */

    public void removeRedMushroom(int value){
        int amount = (int) Baul.get(redMushroom);
        if (amount - value > 0) { Baul.put(redMushroom, amount - value);}
        else { Baul.put(redMushroom,0);}

    }

    /**
     * Se creó un método que eliminara canitdades
     * de HoneySyrup
     * @param value cantidad
     */

    public void removeHoneySyrup(int value){
        int amount = (int) Baul.get(honeySyrup);
        if (amount - value > 0) { Baul.put(honeySyrup, amount - value);}
        else { Baul.put(honeySyrup,0);}
    }





}
