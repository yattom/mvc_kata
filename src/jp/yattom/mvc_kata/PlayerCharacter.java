package jp.yattom.mvc_kata;

public class PlayerCharacter implements Creature {

    private UserInteraction ui;

    public PlayerCharacter(UserInteraction ui) {
        this.ui = ui;
    }

    @Override
    public Action takeEngagementAction() {
        return ui.requestActionInEncounter();
    }

    @Override
    public int getDamage() {
        return 3;
    }

    @Override
    public void reduceHP(int damage) {
        // TODO Auto-generated method stub
    }

    @Override
    public CreatureMind tell() {
        return ui;
    }

    @Override
    public boolean isAlive() {
        // TODO Auto-generated method stub
        return true;
    }

}
