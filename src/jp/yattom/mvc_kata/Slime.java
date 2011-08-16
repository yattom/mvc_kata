package jp.yattom.mvc_kata;

public class Slime implements Creature {
    private CreatureMind mind = new DumbMind();

    @Override
    public Action takeEngagementAction() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int getDamage() {
        return 2;
    }

    @Override
    public void reduceHP(int damage) {
        // TODO Auto-generated method stub

    }

    @Override
    public CreatureMind tell() {
        return mind;
    }

}
