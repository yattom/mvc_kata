package jp.yattom.mvc_kata;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Encounter {
    private Set<Creature> participants;
    private Queue<Creature> actorQueue;

    public Encounter() {
        participants = new HashSet<Creature>();
    }

    public void addParticipant(Creature creature) {
        participants.add(creature);
    }

    public void engage() {
        actorQueue = new LinkedList<Creature>();
        for(Creature c : participants) {
            Set<Creature> opponents = new HashSet<Creature>(participants);
            opponents.remove(c);
            c.tell().notifyEncount(opponents);
            actorQueue.add(c);
        }
    }
    
    public void takeTurn() {
        if(isConcluded()) {
            return;
        }
        Creature actor = actorQueue.remove();
        takeTurnFor(actor);
        if(actor.isAlive()) {
            actorQueue.add(actor);
        }
    }

    public void takeTurnFor(Creature actor) {
        Action action = actor.takeEngagementAction();
        action.execute();
    }

    public boolean isConcluded() {
        int aliveCount = 0;
        for(Creature c : participants) {
            if(c.isAlive()) {
                aliveCount++;
            }
        }
        return aliveCount <= 1;
    }
}
