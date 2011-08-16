package jp.yattom.mvc_kata;

public class EncounterFactory {
    private PlayerCharacter pc;

    public EncounterFactory(PlayerCharacter pc) {
        this.pc = pc;
    }

    public Encounter create() {
        Encounter encounter = new Encounter();
        encounter.addParticipant(pc);
        encounter.addParticipant(new Slime());
        return encounter;
    }

}
