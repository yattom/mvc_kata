package jp.yattom.mvc_kata;

public class PlayerCharacter extends AbstractCreature {

    public PlayerCharacter(UserInteraction ui) {
        super(10);
        setMind(ui);
    }

    @Override
    public int getDamage() {
        return 3;
    }
}
