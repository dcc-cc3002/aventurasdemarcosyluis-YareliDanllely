package com.example.aventurasdemarcoyluis;


import java.util.List;

/**
 * Class that represent a Player in the game
 *
 *  @author SB
 */
public class Players {
    private int atk;
    private int def;
    private int hp;
    private int fp;
    private int lvl=1;
    public List<Items> armamento;

    /**
     * Creates a new player
     * @param ATK attack points
     * @param DEF defense points
     * @param HP  heal points
     * @param FP  fight points
     * @param LVL level of the Unit
     *
     */
    public Players(int ATK, int DEF, int HP, int FP, int LVL ){
        atk=ATK;
        def=DEF;
        hp=HP;
        fp=FP;
        lvl=LVL;
    }


    public void addAItem(Items a){
        armamento.add(a);
    }







}
