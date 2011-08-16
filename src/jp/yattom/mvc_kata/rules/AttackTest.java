package jp.yattom.mvc_kata.rules;

import jp.yattom.mvc_kata.Creature;
import jp.yattom.mvc_kata.CreatureMind;

import org.junit.Test;

import static org.easymock.EasyMock.*;

public class AttackTest {
    @Test
    public void 普通に攻撃する() {
        Creature actor = createMock(Creature.class);
        CreatureMind actorMind = createMock(CreatureMind.class);
        Creature target = createMock(Creature.class);
        CreatureMind targetMind = createMock(CreatureMind.class);

        expect(actor.tell()).andReturn(actorMind);
        expect(actor.getDamage()).andReturn(3);
        actorMind.notifyAttacking(target, 3);
        expect(target.tell()).andReturn(targetMind);
        target.reduceHP(3);
        targetMind.notifyHit(actor, 3);
        replay(actor);
        replay(actorMind);
        replay(target);
        replay(targetMind);
        
        Attack.execute(actor, target);
        verify(actor);
        verify(actorMind);
        verify(target);
        verify(targetMind);
    }
}
