package lesson5.battleUnitAll;

public class Knight extends BattleUnit{ // наследуется все кроме приватных

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

}
