package jp.yattom.mvc_kata;

import java.util.HashSet;
import java.util.Set;

public class Encounter {
    private Set<Creature> participants;

    public Encounter() {
        participants = new HashSet<Creature>();
    }

    public void addParticipant(Creature creature) {
        participants.add(creature);
    }

    public void engage() {
        for(Creature c : participants) {
            Set<Creature> opponents = new HashSet<Creature>(participants);
            opponents.remove(c);
            c.startFighting(opponents);
        }
    }

}
