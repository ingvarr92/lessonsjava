package oct_nov.lesson6.battleUnitAll;

public class Fight {
    private BattleUnit unit1;
    private BattleUnit unit2;


    public Fight (BattleUnit unit1, Spearman unit2){
        this.unit1=unit1;
        this.unit2=unit2;
    }

    public void fight(){
        while (unit1.isAlife()){
            unit1.attack(unit2);
            if (unit2.isAlife()){
                unit2.attack(unit1);
            }
        }
    }

    public void fight(Doctor doctor){
        while (unit1.isAlife()){
            unit1.attack(unit2);
            if (unit2.isAlife()){
                unit2.attack(unit1);
            }
        }
    }

    public String fightResut(){
        return "Health unit1 = " + unit1.health + " Health unit2 = " + unit2.health;

    }
}
