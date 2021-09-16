package com.example.aventurasdemarcoyluis;

import java.util.Objects;

public class Enemies {
    private int atk;
    private int def;
    private int hp;
    private int lvl=1;
    private EnemyType type;

    /**
     * Creates a new Enemy
     * @param ATK attack points
     * @param DEF defense points
     * @param HP  heal points
     * @param LVL level of the Unit
     *
     */
    public Enemies(int ATK, int DEF, int HP, int LVL, EnemyType t ){
        atk=ATK;
        def=DEF;
        hp=HP;
        lvl=LVL;
        type=t;
    }

    public int getAtk() {
        return atk;
    }

    public void setAtk(int atk) {
        this.atk = atk;
    }

    public int getDef() {
        return def;
    }

    public void setDef(int def) {
        this.def = def;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }



    public int getLvl() {
        return lvl;
    }

    public void setLvl(int lvl) {
        this.lvl = lvl;
    }

    public EnemyType getType() {
        return type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Enemies)) return false;
        Enemies enemies = (Enemies) o;
        return atk == enemies.atk && def == enemies.def && hp == enemies.hp && lvl == enemies.lvl;
    }


}
