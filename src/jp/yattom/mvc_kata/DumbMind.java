package jp.yattom.mvc_kata;

import java.util.Collection;

public class DumbMind implements CreatureMind {

    private Collection<Creature> opponents;
    private Creature actor;
    
    public DumbMind(Creature actor) {
        this.actor = actor;
    }

    @Override
    public void notifyEncount(Collection<Creature> opponents) {
        this.opponents = opponents;
    }

    @Override
    public void notifyAttacking(Creature target, int damage) {
        // TODO Auto-generated method stub

    }

    @Override
    public void notifyHit(Creature actor, int damage) {
        // TODO Auto-generated method stub

    }

    @Override
    public void notifyKill(Creature target) {
        // TODO Auto-generated method stub

    }

    @Override
    public void notifyDead() {
        // TODO Auto-generated method stub

    }

    @Override
    public Action requestActionInEncounter() {
        return new AttackAction(actor, opponents.iterator().next());
    }

}
