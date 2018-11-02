package lesson6.battleUnitAll;

import java.util.Scanner;

public class BattleUnitFactory {
    public BattleUnit create (String userChouse) {


        if (userChouse.equals("knight")) {
            return new lesson6.battleUnitAll.Knight(100, 20);
        }  if (userChouse.equals("spman")) {
            return new lesson6.battleUnitAll.Spearman(70, 40);
        }
            return new Doctor(50, 10);
        }

    }

