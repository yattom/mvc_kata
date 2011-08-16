package jp.yattom.mvc_kata;

public class AbstractCreature implements Creature {
    private CreatureMind mind;
    private int hp;

    public AbstractCreature(int hp) {
        this.hp = hp;
    }

    @Override
    public Action takeEngagementAction() {
        return tell().requestActionInEncounter();
    }

    @Override
    public int getDamage() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public void reduceHP(int damage) {
        hp -= damage;
        if (hp < 0) {
            hp = 0;
        }
    }

    @Override
    public CreatureMind tell() {
        return mind;
    }
    
    protected void setMind(CreatureMind mind) {
        this.mind = mind;
    }

    @Override
    public boolean isAlive() {
        return hp > 0;
    }

    public int getHP() {
        return hp;
    }

}
