package jp.yattom.mvc_kata;

import java.util.Collection;

public interface CreatureMind {

	void notifyEncount(Collection<Creature> opponents);

    void notifyAttacking(Creature target, int i);

    void notifyHit(Creature actor, int i);

}
