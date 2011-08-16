package jp.yattom.mvc_kata;

import static org.junit.Assert.*;

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
    public void “G‚ªŒ»‚ê‚é() {
        ui.notifyEncount("ƒXƒ‰ƒCƒ€");
        replay(ui);
        
        Encounter encounter = new Encounter();
        encounter.addParticipant(new Slime());
        encounter.addParticipant(pc);
        encounter.engage();
        verify(ui);
    }
}
