package lesson6.battleUnitAll;

public class Spearman extends BattleUnit {
    public Spearman(int health, int attack){
        super(health,attack);
    }

    @Override
    public void attack(BattleUnit enemy) {
        enemy.health -= this.attackScore;
    }

    @Override
    public void say(String text) {
        System.out.println("Пикейшик сказал: " + text);
    }

    @Override
    public void sing(String song) {
        System.out.println("Пикейшик спел: " + song);

    }
}
