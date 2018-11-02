package lesson6.battleUnitAll;

import lesson6.battleUnitAll.Knight;
import lesson6.battleUnitAll.Spearman;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Knight knight = new Knight(100,20);
        Spearman spearman = new Spearman(40,70);
        knight.attack(spearman);


        Doctor doctor = new Doctor(50,10);
        //doctor.attack(knight);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите название персонажа");
        String userChouse = scanner.nextLine();

        BattleUnitFactory unitFactory = new BattleUnitFactory();
        BattleUnit unit1 = unitFactory.create(userChouse);

        Fight fight = new Fight(unit1, spearman);
        fight.fight();

        System.out.println(fight.fightResut());
        System.out.println("AFTER FIGHT");
    }
}
