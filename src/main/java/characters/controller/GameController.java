package characters.controller;
import characters.enemies.BooEnemyCharacter;
import characters.enemies.GoombaEnemyCharacter;
import characters.enemies.SpinyEnemycharacter;
import characters.enemies.interfaces.Enemies;
import characters.maincharacter.LuisMainCharacter;
import characters.maincharacter.MarcosMainCharacter;
import characters.maincharacter.baul.Baul;
import characters.Character;
import characters.maincharacter.interfaces.AttackableByLuis;
import characters.maincharacter.interfaces.AttackablebyMarco;
import characters.maincharacter.interfaces.PrincipalCharacter;
import characters.maincharacter.items.HoneySyrup;
import characters.maincharacter.items.Items;
import characters.maincharacter.items.RedMushroom;
import characters.phases.Phase;
import characters.phases.StartPhase;
import characters.phases.exceptions.InvalidTransitionException;
import characters.visitors.AttackableByLuisVisitor;
import characters.visitors.AttackableByMarcoVisitor;
import characters.visitors.IAmLuisVisitor;
import characters.visitors.IAmMarcosVisitor;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *  Se creó el controlador que permitira controlar el modelo
 *  del juego, el cual contiene una lista de jugadores, un Baul y una variable
 *  turno
 */

public class GameController {
    private MarcosMainCharacter marco;
    private LuisMainCharacter luis;
    private ArrayList<Character> listOfPlayers;
    private ArrayList<PrincipalCharacter> listOfPrincipalCharacter;
    private ArrayList<Enemies> lisOfEnemies;
    private IAmMarcosVisitor iAmMarcosVisitor;
    private AttackableByLuisVisitor attackableByLuisVisitor;
    private AttackableByMarcoVisitor attackableByMarcoVisitor;
    private IAmLuisVisitor iAmLuisVisitor;
    private RedMushroom redMushroom;
    private HoneySyrup honeySyrup;
    private Baul baul;
    private Phase phase;
    private int turn=0;

    public GameController() {
        setPhase(new StartPhase());
        listOfPlayers = new ArrayList<>();
        listOfPrincipalCharacter= new ArrayList<>();
        lisOfEnemies = new ArrayList<>();
        attackableByLuisVisitor = new AttackableByLuisVisitor();
        attackableByMarcoVisitor = new AttackableByMarcoVisitor();
        iAmMarcosVisitor = new IAmMarcosVisitor();
        iAmLuisVisitor = new IAmLuisVisitor();
        redMushroom = new RedMushroom();
        honeySyrup = new HoneySyrup();

    }


    /**
     * Se creó un método que crea los personajes principales, los cuales al inciar
     * el juego tiene un valores en sus atributos fijos, luego se agregaron a la
     * lista de jugadores
     */
    public void createPlayers() {
        marco = new MarcosMainCharacter(1, 10, 5, 20, 50, 10, 10);
        luis = new LuisMainCharacter(1, 10, 3, 20, 50, 10, 10);
        createBaul(marco, luis);
        listOfPlayers.add(marco);
        listOfPrincipalCharacter.add(marco);
        listOfPlayers.add(luis);
        listOfPrincipalCharacter.add(luis);
    }

    /**
     * Se creó un método para obtener la lista de jugadores
     * @return lista de jugadores
     */
    public List<Character> getListOfPlayers() {
        return listOfPlayers;
    }

    /**
     * Se creó un método para obtener la lista de enemigos
     * @return lista de enemigos
     */
    public List<Enemies> getListOfEnemies() {
        return lisOfEnemies;
    }


    /**
     * Se creó un metodo que retorna los jugadores, segun el su posición
     * en la lista
     * @param value valor de la lista
     * @return Character
     */
    public Character getPlayer(int value) {
        return this.getListOfPlayers().get(value);
    }

    /**
     * Se creo un metodo que permite obtener un enemigo
     * de la lista de enemigos
     * @param value valor
     * @return Enemy
     */

    public Enemies getEnemies(int value) {
        return this.getListOfEnemies().get(value);
    }

    /**
     * Se creo el método que crea solo un enemigo aleatoremente, recibe una variable
     * random que permite generarlo aleatorio pero tambien permite saber que personaje
     * creara plantandole una semilla
     * @param random variable random
     */
    public void createEnemiesStructure(Random random) {
        int selector = random.nextInt(3);
        if (selector == 0) {
            GoombaEnemyCharacter goomba = new GoombaEnemyCharacter(1, 7, 3, 10, 10);
            listOfPlayers.add(goomba);
            lisOfEnemies.add(goomba);
        }
        if (selector == 1) {
            BooEnemyCharacter boo = new BooEnemyCharacter(1, 7, 3, 10, 10);
            listOfPlayers.add(boo);
            lisOfEnemies.add(boo);
        }
        if (selector == 2) {
            SpinyEnemycharacter spiny = new SpinyEnemycharacter(1, 7, 3, 10, 10);
            listOfPlayers.add(spiny);
            lisOfEnemies.add(spiny);
        }
    }

    /**
     * Se creó un método que permite crear los tres enemigos solicitados
     * de manera aleatoria
     * @param amountOfEnemies cantidad de enemigos
     * @param random variable random
     */
    public void createEnemies(int amountOfEnemies, Random random) {
        for (int i = 0; i < amountOfEnemies; i++) {
            createEnemiesStructure(random);

        }
    }

    /**
     * Se creó un método que permite crear el Baul y le agrega los
     * items a este
     * @param marco Marco
     * @param luis Luis
     */
    public void createBaul(MarcosMainCharacter marco, LuisMainCharacter luis) {
        baul = new Baul();
        baul.addAmountOfRedMushroom(3);
        baul.addAmountOfHoneySyrup(3);
        marco.setBaul(baul);
        luis.setBaul(baul);
    }

    /**
     * Se creo un método que permite a los personajes principales utilizar los items
     * que poseen
     * @param items
     * @param player
     */
    public void playerUseItemOfBaul(Items items, PrincipalCharacter player) {
        items.use(player);
    }

    /**
     * Se creó un método que permite obtener la cantidad
     * de items del baul por medio de una lista
     * @return lista de items
     */
    public List getItemsOfBaul() {
        List<Integer> amountOfItems = new ArrayList<Integer>();
        int amountOfHoneySyrup = baul.getAmountOfHoneySyrup();
        amountOfItems.add(amountOfHoneySyrup);
        int amountOfRedmushroom = baul.getAmountOfRedMushroom();
        amountOfItems.add(amountOfRedmushroom);
        return amountOfItems;
    }

    /**
     * Se creó un método que permite remover un personaje
     * cuando este esta KO
     */
    public void removeKoCharacter() {
        for (int i = 0; i < listOfPlayers.size(); i++) {
            Character characterKo = listOfPlayers.get(i);
            if (characterKo.getHitPoints() == 0) {
                listOfPlayers.remove(characterKo);
            }
        }
    }

    /**
     * Se creó un metodo que permite saber si los personajes
     * principales ganaron o no, segun si estan vivos o no
     * @param marco Marco
     * @param luis Luis
     * @return True or False
     */

    public Boolean thePrincipalCharacterWon(MarcosMainCharacter marco, LuisMainCharacter luis) {
        if (listOfPlayers.get(0).getClass() != marco.getClass() && listOfPlayers.get(1).getClass() != luis.getClass()) {return false;}
        if (listOfPlayers.get(0).getClass().equals(luis)){
            if (listOfPlayers.size()>1){ return false;}
            else{ return true; } }
        else { if (listOfPlayers.size() > 2) { return false; }
               if (listOfPlayers.size() == 2) { return true; } }
        return null;
    }


    /**
     * Se creó un método que permite obtener el jugador
     * segun el turno del juego
     * @param turn turno
     * @return Character
     */
    public Character shiftCharacter (int turn){
        for (int i = 0; i < listOfPlayers.size(); i++) {
            if (i==turn){ return listOfPlayers.get(i);}}

        return null;
    }

    /**
     * Se creó un método que permite obtener el turno del siguente
     * personaje
     * @return turno del siguente personaje
     */
        public Character shiftNextCharacter () {
            int nextTurn = this.getTurn() + 1;
            return shiftCharacter(nextTurn);
        }

    /**
     * Se creó un método que permite terminar
     * el turno actual y pasar al siguente
     */
    public void endTurn(){
            setTurn(getTurn()+1);

     }

    /**
     * Se creó el getter de la variable Turn
     * @return turn
     */
        public int getTurn () {
            return turn;
        }

    /**
     * Se creó el setter de la variable Turn
     * @param turn
     */
        public void setTurn (int turn){
            this.turn = turn;
        }

    /**
     * Se creo el setter que permitira cambiar la phase en la cual esta
     * el controlador
     * @param phase fase
     */
    public void setPhase(Phase phase) {
        this.phase = phase;
        phase.setController(this);
    }

    /**
     * Se creo el metodo que devuelve el nombre
     * de la fase en la cual esta el juego
     * @return nombre de la fase
     */
    public String getNameOfActualPhase() {
        return phase.toString();
    }

    /**
     * Se creo un metodo que permite obtener la fase actual
     * @return
     */

    public Phase getPhase() {
        return phase;
    }

    //Solución al problema de castear


    /**
     * Se busco a los personajes atacables por luis dentro
     * de la lista de enemigos
     * @return lista de enemigos atacables por luis
     */
    public List<AttackableByLuis> getAttackableByLuis(){
        for (Enemies enemies : lisOfEnemies){
            enemies.acceptVisitor(attackableByLuisVisitor);
        }
        return attackableByLuisVisitor.getResul();
    }

    /**
     * Se busco a los personajes atacables por marco dentro de la lista
     * enemigos
     * @return lista de enemigos atacables por marco
     */
    public List<AttackablebyMarco> getAttackableByMarcos(){
        for (Enemies enemies : lisOfEnemies){
            enemies.acceptVisitor(attackableByMarcoVisitor);
        }
        return attackableByMarcoVisitor.getResul();
    }




    //Transiciones del juego

    /**
     * Se creo un metodo que empezara los turnos
     */
    public void tryStartTurn(){
        try {
            phase.start();
        } catch (InvalidTransitionException e){ e.printStackTrace();}
    }



    /**
     * Se creo un metodo para empezar el turno de
     * jugador
     */
    public void tryStartTurnPlayer(){
            try{
                phase.starTurnOfPlayer();
            } catch (InvalidTransitionException e) {

                e.printStackTrace();}
        }


    /**
     * Se creo un metodo para tratar de acabar el turno
     */
    public void tryToEndTurn() {
        this.endTurn();
        try{
            phase.EndTurn();
    } catch (InvalidTransitionException e){
            e.printStackTrace();
        }}


    /**
     * Se creo un metodo que permite
     * elegir un enemigo para atacar
     */
    public void playerChooseEnemy() {
        try {
            phase.chooseEnemy();
        }catch (InvalidTransitionException e){
            e.printStackTrace();
        } }

    /**
     * Se creo un metodo que permite ecoger
     * un ataque para el primer enemigo de la lista
     */
    public void playerChooseAttackForFirstEnemy() {
      try{
          phase.chooseAttackForFirstEnemy();
      } catch (InvalidTransitionException e)
      {e.printStackTrace();}
    }

    /**
     Se creo un metodo que permite ecoger
     * un ataque para el segundo enemigo de la lista
     */
    public void playerChooseAttackForSecondEnemy() {
        try{
            phase.chooseAttackForSecondEnemy();
        } catch (InvalidTransitionException e)
        {e.printStackTrace();}
    }

    /**
     Se creo un metodo que permite ecoger
     * un ataque para el tercer enemigo de la lista
     */

    public void playerChooseAttackForThirdEnemy() {
        try{
            phase. chooseAttackForThirdEnemy();
        } catch (InvalidTransitionException e)
        {e.printStackTrace();}
    }


    //Ataque a primer enemigo
    /**
     * Se creo un metodo que permite implemetar los visitor
     * en el personaje del turno para ver que player es
     */
    public void seeWhatCharacterIs(){
        getPlayer(turn).acceptVisitor(iAmLuisVisitor);
        getPlayer(turn).acceptVisitor(iAmMarcosVisitor);
    }

    /**
     * Se genero el ataque para el primer enemigo de la lista con
     * salto
     */
    public void attackFirstEnemyWithJump(){
        seeWhatCharacterIs();

        if (iAmLuisVisitor.getResult()){
            int valueInListToLuis= getAttackableByLuis().indexOf(getEnemies(0));
            luis.attackWithJump(getAttackableByLuis().get(valueInListToLuis));
              removeKoCharacter();
              try{
                  phase.EndTurn();
              } catch (InvalidTransitionException e)
              {e.printStackTrace(); }}

        if (iAmMarcosVisitor.getResult()){
             int valueInListToMarco= getAttackableByMarcos().indexOf(getEnemies(0));
                 marco.attackWithJump(getAttackableByMarcos().get(valueInListToMarco));
                 removeKoCharacter();
                 try{ phase.EndTurn();
                 } catch (InvalidTransitionException e)
                 {e.printStackTrace();}}

        }


    /**
     * Se genero el ataque para el primer enemigo de la lista con
     * Hammer
     */
    public void attackFirstEnemyWithHammer(){
        seeWhatCharacterIs();
        if (iAmLuisVisitor.getResult()){
            int valueInListToLuis= getAttackableByLuis().indexOf(getEnemies(1));
            luis.attackWithJump(getAttackableByLuis().get(valueInListToLuis));
            removeKoCharacter();
            try{ phase.EndTurn();
            } catch (InvalidTransitionException e)
            {e.printStackTrace(); }}

        if (iAmMarcosVisitor.getResult()){
            int valueInListToMarco= getAttackableByMarcos().indexOf(getEnemies(1));
            marco.attackWithJump(getAttackableByMarcos().get(valueInListToMarco));
            removeKoCharacter();
            try{ phase.EndTurn();
            } catch (InvalidTransitionException e)
            {e.printStackTrace();}
            }
        }


    //Ataque segundo enemigo

    /**
     * Se genero el ataque para el segund enemigo de la lista con
     * hammer
     */
    public void attackSecondEnemyWithHammer() {
        seeWhatCharacterIs();
        if (iAmLuisVisitor.getResult()){
            int valueInListToLuis= getAttackableByLuis().indexOf(getEnemies(1));
            luis.attackWithJump(getAttackableByLuis().get(valueInListToLuis));
            removeKoCharacter();
            try{ phase.EndTurn();
            } catch (InvalidTransitionException e)
            {e.printStackTrace(); }}

        if (iAmMarcosVisitor.getResult()){
            int valueInListToMarco= getAttackableByMarcos().indexOf(getEnemies(1));
            marco.attackWithJump(getAttackableByMarcos().get(valueInListToMarco));
            removeKoCharacter();
            try{ phase.EndTurn();
            } catch (InvalidTransitionException e)
            {e.printStackTrace();}
            }
        }


    /**
     * Se genero el ataque para el segund enemigo de la lista con
     * salto
     */

    public void attackSecondEnemyWithJump() {
            seeWhatCharacterIs();
            if (iAmLuisVisitor.getResult()){
                int valueInListToLuis= getAttackableByLuis().indexOf(getEnemies(1));
                luis.attackWithJump(getAttackableByLuis().get(valueInListToLuis));
                removeKoCharacter();
                try{ phase.EndTurn();
                } catch (InvalidTransitionException e)
                {e.printStackTrace(); } }

            if (iAmMarcosVisitor.getResult()){
                int valueInListToMarco= getAttackableByMarcos().indexOf(getEnemies(1));
                marco.attackWithJump(getAttackableByMarcos().get(valueInListToMarco));
                removeKoCharacter();
                try{ phase.EndTurn();
                } catch (InvalidTransitionException e)
                {e.printStackTrace();} }
            }



//Attaque Tercer Enemigo

    /**
     * Se genero el ataque para el tercer enemigo de la lista con
     * salto
     */
    public void attackThirdEnemyWithJump() {
        seeWhatCharacterIs();
        if (iAmLuisVisitor.getResult()){
            int valueInListToLuis= getAttackableByLuis().indexOf(getEnemies(2));
            luis.attackWithJump(getAttackableByLuis().get(valueInListToLuis));
            removeKoCharacter();
            try{ phase.EndTurn();
            } catch (InvalidTransitionException e)
            {e.printStackTrace(); }}

            if (iAmMarcosVisitor.getResult()){
                int valueInListToMarco= getAttackableByMarcos().indexOf(getEnemies(2));
                marco.attackWithJump(getAttackableByMarcos().get(valueInListToMarco));
                removeKoCharacter();
                try{ phase.EndTurn();
                } catch (InvalidTransitionException e)
                {e.printStackTrace();}
            }
        }

    /**
     * Se genero el ataque para el tercer enemigo de la lista con
     * hammer
     */
    public void attackThirdEnemyWithHammer() {
        seeWhatCharacterIs();
        if (iAmLuisVisitor.getResult()){
            int valueInListToLuis= getAttackableByLuis().indexOf(getEnemies(2));
            luis.attackWithJump(getAttackableByLuis().get(valueInListToLuis));
            removeKoCharacter();
            try{ phase.EndTurn();
            } catch (InvalidTransitionException e)
            {e.printStackTrace(); }}

            if (iAmMarcosVisitor.getResult()){
                int valueInListToMarco= getAttackableByMarcos().indexOf(getEnemies(2));
                marco.attackWithJump(getAttackableByMarcos().get(valueInListToMarco));
                removeKoCharacter();
                try{ phase.EndTurn();
                } catch (InvalidTransitionException e)
                {e.printStackTrace();}
            }
        }


}
















