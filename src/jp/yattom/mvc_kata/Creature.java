package jp.yattom.mvc_kata;

import java.util.Set;

public interface Creature {

    void startFighting(Set<Creature> opponents);

    Action takeEngagementAction();

    int getDamage();

    void reduceHP(int damage);

}
