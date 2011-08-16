package jp.yattom.mvc_kata;

public class Slime implements Creature {
    private CreatureMind mind = new DumbMind(this);
    private int hp;

    public Slime() {
        hp = 3;
    }
    
    @Override
    public Action takeEngagementAction() {
        return mind.requestActionInEncounter();
    }

    @Override
    public int getDamage() {
        return 2;
    }

    @Override
    public void reduceHP(int damage) {
        hp -= damage;
        if(hp < 0) {
            hp = 0;
        }
    }

    @Override
    public CreatureMind tell() {
        return mind;
    }

    @Override
    public boolean isAlive() {
        return hp > 0;
    }

    public int getHP() {
        return hp;
    }

}
