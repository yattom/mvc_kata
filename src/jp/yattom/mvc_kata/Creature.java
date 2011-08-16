package jp.yattom.mvc_kata;

public interface Creature {

    Action takeEngagementAction();

    int getDamage();

    void reduceHP(int damage);

    CreatureMind tell();

    boolean isAlive();

}
