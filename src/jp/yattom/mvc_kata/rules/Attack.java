package jp.yattom.mvc_kata.rules;

import jp.yattom.mvc_kata.Creature;

public class Attack {

    public static void execute(Creature actor, Creature target) {
        int damage = actor.getDamage();
        target.reduceHP(damage);
        actor.tell().notifyAttacking(target, damage);
        target.tell().notifyHit(actor, damage);
    }
}
