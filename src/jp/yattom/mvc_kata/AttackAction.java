package jp.yattom.mvc_kata;

import jp.yattom.mvc_kata.rules.Attack;

public class AttackAction implements Action {
    private Creature target;
    private Creature actor;

    public AttackAction(Creature actor, Creature target) {
        this.actor = actor;
        this.target = target;
    }
    
    @Override
    public boolean equals(Object o) {
        if(!(o instanceof AttackAction)) {
            return false;
        }
        AttackAction oa = (AttackAction)o;
        return actor.equals(oa.actor) && target.equals(oa.target);
    }

    public void execute() {
        Attack.execute(actor, target);
    }
}
