package lesson23.homeWork.bank;

public class Account {
    private int accId;
    private static int accIdCount=0;
    private int userId;
    private int amount;

    public Account(int userId, int amount) {
        this.userId = userId;
        this.amount = amount;
        this.accId = accIdCount++;
    }

    public int getAccId() {
        return accId;
    }

    public int getUserId() {
        return userId;
    }

    public int getAmound() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
