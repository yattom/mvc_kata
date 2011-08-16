package jp.yattom.mvc_kata;

import java.util.Set;

public class PlayerCharacter implements Creature {

    private UserInteraction ui;
    public PlayerCharacter(UserInteraction ui) {
        this.ui = ui;
    }

    @Override
    public void startFighting(Set<Creature> opponents) {
        ui.notifyEncount(opponents);
    }

}
