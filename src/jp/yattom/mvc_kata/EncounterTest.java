package jp.yattom.mvc_kata;

import static org.easymock.EasyMock.*;

import java.util.Collection;
import java.util.HashSet;

import org.junit.Before;
import org.junit.Test;

public class EncounterTest {
    private UserInteraction ui;
    private PlayerCharacter pc;
    private Creature opponent;

    @Before
    public void setUp() {
        ui = createMock(UserInteraction.class);
        pc = new PlayerCharacter(ui);
        opponent = new Slime();
    }

    @Test
    public void 敵が現れる() {
        HashSet<Creature> expectedOpponents = new HashSet<Creature>();
        expectedOpponents.add(opponent);
        ui.notifyEncount(eq(expectedOpponents));
        replay(ui);

        Encounter encounter = new Encounter();
        encounter.addParticipant(pc);
        encounter.addParticipant(opponent);
        encounter.engage();
        verify(ui);
    }

    @SuppressWarnings("unchecked")
    @Test
    public void プレイヤーが攻撃する() {
        ui.notifyEncount(anyObject(Collection.class));
        AttackAction expectedAction = new AttackAction(pc, opponent);
        expect(ui.requestActionInEncounter()).andReturn(expectedAction);
        replay(ui);

        Encounter encounter = new Encounter();
        encounter.addParticipant(pc);
        encounter.addParticipant(opponent);
        encounter.engage();
        encounter.takeTurnFor(pc);
        verify(ui);
    }
}
