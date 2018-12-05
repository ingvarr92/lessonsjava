package oct_nov.lesson6.battleUnitAll;

public class Doctor
        extends BattleUnit
        implements ISpeakerUnit{ // можно реализовать несколько интерфейсов через запятую
    public Doctor(int health, int attackScore) {
        super(health, attackScore);
    }

    @Override
    public void attack(BattleUnit unit) {
        unit.health +=attackScore;
    }


    @Override
    public void say(String text) {
        System.out.println(text);
    }

    @Override
    public void sing(String song) {
        System.out.println(song);

    }
}
