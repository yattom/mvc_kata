package jp.yattom.mvc_kata;

import static org.easymock.EasyMock.*;

import java.util.Collection;
import java.util.HashSet;

import org.junit.Before;
import org.junit.Test;

public class EncounterTest {
    private UserInteraction ui;
    private PlayerCharacter pc;
    private Creature foe;

    @Before
    public void setUp() {
        ui = createMock(UserInteraction.class);
        pc = new PlayerCharacter(ui);
        foe = new Slime();
    }

    @Test
    public void 敵が現れる() {
        HashSet<Creature> expectedFoes = new HashSet<Creature>();
        expectedFoes.add(foe);
        ui.notifyEncount(eq(expectedFoes));
        replay(ui);

        Encounter encounter = new Encounter();
        encounter.addParticipant(pc);
        encounter.addParticipant(foe);
        encounter.engage();
        verify(ui);
    }

    @SuppressWarnings("unchecked")
    @Test
    public void プレイヤーが攻撃する() {
        ui.notifyEncount(anyObject(Collection.class));
        AttackAction attack = createMock(AttackAction.class);
        attack.execute();
        expect(ui.requestActionInEncounter()).andReturn(attack);
        replay(ui);
        replay(attack);

        Encounter encounter = new Encounter();
        encounter.addParticipant(pc);
        encounter.addParticipant(foe);
        encounter.engage();
        encounter.takeTurnFor(pc);
        verify(ui);
        verify(attack);
    }

    @SuppressWarnings("unchecked")
    @Test
    public void モンスターが反撃する() {
        ui.notifyEncount(anyObject(Collection.class));
        ui.notifyHit(foe, 2);
        replay(ui);

        Encounter encounter = new Encounter();
        encounter.addParticipant(pc);
        encounter.addParticipant(foe);
        encounter.engage();
        encounter.takeTurnFor(foe);
        verify(ui);
    }
}
