package jp.yattom.mvc_kata.rules;

import jp.yattom.mvc_kata.Creature;
import jp.yattom.mvc_kata.CreatureMind;

import org.junit.Before;
import org.junit.Test;

import static org.easymock.EasyMock.*;

public class AttackTest {
    Creature actor;
    CreatureMind actorMind;
    Creature target;
    CreatureMind targetMind;

    @Before
    public void setUp() {
        actor = createMock(Creature.class);
        actorMind = createMock(CreatureMind.class);
        target = createMock(Creature.class);
        targetMind = createMock(CreatureMind.class);
        expect(actor.tell()).andReturn(actorMind).anyTimes();
        expect(target.tell()).andReturn(targetMind).anyTimes();
    }

    @Test
    public void 普通に攻撃する() {
        int damage = 3;
        expect(actor.getDamage()).andReturn(damage);
        actorMind.notifyAttacking(target, damage);
        target.reduceHP(damage);
        targetMind.notifyHit(actor, damage);
        expect(target.isAlive()).andReturn(true);
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

    @Test
    public void 攻撃して倒す() {
        int damage = 30;
        expect(actor.getDamage()).andReturn(damage);
        actorMind.notifyAttacking(target, damage);
        actorMind.notifyKill(target);
        target.reduceHP(damage);
        expect(target.isAlive()).andReturn(false);
        targetMind.notifyHit(actor, damage);
        targetMind.notifyDead();
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
