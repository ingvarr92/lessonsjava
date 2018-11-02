package lesson6.battleUnitAll;

abstract public class BattleUnit implements ISpeakerUnit {
//    private int health;
////    private int attackScore;

    protected int health;
    protected int attackScore;

    public void setHealth(int health) {
        this.health = health;
    }

    public void setAttackScore(int attackScore) {
        this.attackScore = attackScore;
    }

    public int getHealth() {
        return health;
    }

    public int getAttackScore() {
        return attackScore;
    }

    public BattleUnit(int health, int attackScore){
        this.health = health;
        this.attackScore = attackScore;
    }

    public boolean isAlife (){
        return health > 0;

    }

    abstract public void attack (BattleUnit enemy);

}
