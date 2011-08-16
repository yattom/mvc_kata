package jp.yattom.mvc_kata;

public class Slime extends AbstractCreature {

    public Slime() {
        super(3);
        setMind(new DumbMind(this));
    }

    @Override
    public int getDamage() {
        return 2;
    }

    @Override
    public String getName() {
        return "スライム";
    }
}
