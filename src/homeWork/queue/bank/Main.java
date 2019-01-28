package homeWork.queue.bank;

public class Main {

    public static void main(String[] args) {
        Account user1 = new Account(1, 500);
        Account user2 = new Account(2, 600);
        new Transfer(user1, user2, 300).run();
    }
}
