package jp.yattom.mvc_kata;

import java.util.Collection;
import java.util.List;

public interface UserInteraction {

    void notifyEncount(Collection<Creature> opponents);

    Action requestActionInEncounter();

}
