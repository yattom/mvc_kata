package jp.yattom.mvc_kata;

import static org.junit.Assert.*;

import java.util.HashSet;

import static org.easymock.EasyMock.*;
import org.junit.Before;
import org.junit.Test;

public class EncounterTest {
    private UserInteraction ui;
    private PlayerCharacter pc;

    @Before
    public void setUp() {
        ui = createMock(UserInteraction.class);
        pc = new PlayerCharacter(ui);
    }

    @Test
    public void 敵が現れる() {
        Creature opponent = new Slime();
        HashSet<Creature> expectedOpponents = new HashSet<Creature>();
        expectedOpponents.add(opponent);
        ui.notifyEncount(eq(expectedOpponents));
        replay(ui);

        Encounter encounter = new Encounter();
        encounter.addParticipant(opponent);
        encounter.addParticipant(pc);
        encounter.engage();
        verify(ui);
    }
}
