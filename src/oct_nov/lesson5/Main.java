package oct_nov.lesson5;

import oct_nov.lesson5.battleUnitAll.Knight;
import oct_nov.lesson5.battleUnitAll.Spearman;

public class Main {
    public static void main(String[] args) {
        Knight knight = new Knight(100,20);
        Spearman spearman = new Spearman(40,70);
        knight.attack(spearman);

    }
}
