package jp.yattom.mvc_kata.rules;

import jp.yattom.mvc_kata.Creature;

import org.junit.Test;

import static org.easymock.EasyMock.*;

public class AttackTest {
    @Test
    public void 普通に攻撃する() {
        Creature actor = createMock(Creature.class);
        expect(actor.getDamage()).andReturn(3);
        Creature target = createMock(Creature.class);
        target.reduceHP(3);
        replay(actor);
        replay(target);
        
        Attack.execute(actor, target);
        verify(actor);
        verify(target);
    }
}
