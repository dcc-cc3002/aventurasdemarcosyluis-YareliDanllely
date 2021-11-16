package characters.controller;
import characters.enemies.BooEnemyCharacter;
import characters.enemies.GoombaEnemyCharacter;
import characters.enemies.SpinyEnemycharacter;
import characters.maincharacter.LuisMainCharacter;
import characters.maincharacter.MarcosMainCharacter;
import characters.maincharacter.baul.Baul;
import characters.Character;
import characters.maincharacter.interfaces.PrincipalCharacter;
import characters.maincharacter.items.Items;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *  Se creó el controlador que permitira controlar el modelo
 *  del juego, el cual contiene una lista de jugadores, un Baul y una variable
 *  turno
 */

public class GameController {
    private ArrayList<Character> listOfPlayers;
    private Baul baul;
    private int turn;

    /**
     * Se creo el constructor del controlador
     */
    public GameController() { listOfPlayers = new ArrayList<>(); }

    /**
     * Se creó un método que crea los personajes principales, los cuales al inciar
     * el juego tiene un valores en sus atributos fijos, luego se agregaron a la
     * lista de jugadores
     */
    public void createPlayers() {
        MarcosMainCharacter marco = new MarcosMainCharacter(1, 10, 5, 20, 50, 10, 10);
        LuisMainCharacter luis = new LuisMainCharacter(1, 10, 3, 20, 50, 10, 10);
        createBaul(marco, luis);
        listOfPlayers.add(marco);
        listOfPlayers.add(luis);
    }

    /**
     * Se creó un método para obtener la lista de jugadores
     * @return lista de jugadores
     */
    public List<Character> getListOfPlayers() {
        return listOfPlayers;
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
        }
        if (selector == 1) {
            BooEnemyCharacter boo = new BooEnemyCharacter(1, 7, 3, 10, 10);
            listOfPlayers.add(boo);
        }
        if (selector == 2) {
            SpinyEnemycharacter spiny = new SpinyEnemycharacter(1, 7, 3, 10, 10);
            listOfPlayers.add(spiny);
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
     * Se creó un método que permite obtener el jugador
     * segun el turno del juego
     * @param turn turno
     * @return Character
     */
    public Character shiftCharacter ( int turn){
        if (turn == 0) {
                return listOfPlayers.get(0);
            }
        if (turn == 1) {
                return listOfPlayers.get(1);
            }
        if (turn == 2) {
                return listOfPlayers.get(2);
            }
        if (turn == 3) {
                return listOfPlayers.get(3);
            }
        if (turn == 4) {
                return listOfPlayers.get(4);
            }
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
        public void setTurn ( int turn){
            this.turn = turn;
        }


    }











