package oct_nov.lesson6.battleUnitAll;

public class Knight extends BattleUnit implements ISpeakerUnit { // наследуется все кроме приватных

    public Knight(int health, int attackScore){
        super(health,attackScore); // super - вызов метода родителя
    }

    private void addHealth(){
        if (this.health > 1 ){
            this.health +=5;

        }

    }
    @Override
    public void  attack (BattleUnit enemy){
        enemy.health -= this.attackScore;
        addHealth();
    }

    @Override
    public void say(String text) {
        System.out.println("Рыцарь сказал: " + text);
    }

    @Override
    public void sing(String song) {
        System.out.println("Рыцарь спел: " + song);

    }
}
