package homeWork.queue.bank;

public class Transfer implements Runnable {
    Account src;
    Account dst;
    Account obj1, obj2;
    double money;

    Transfer(Account src, Account dst, double money) {
        this.src = src;
        this.dst = dst;
        this.money = money;
    }

    @Override
    public void run() {
        if (src.getId() < dst.getId()) {
            obj1 = src;
            obj2 = dst;
        } else {
            obj2 = src;
            obj1 = dst;
        }

        synchronized (obj1) {
            synchronized (obj2) {
                double amountSrc = src.getMoney();
                double amountDst = dst.getMoney();
                if (amountSrc - money < 0) {
                    System.out.println("Не хватает денег на счету");
                    System.out.println("На счете:" + src.getMoney());
                    return;
                }else{
                    amountSrc -= money;
                }
                amountDst += money;

                dst.setMoney(amountDst);
                src.setMoney(amountSrc);

                System.out.println("Перевод успешно произведен");
                System.out.println("На счету отправителя: " + src.getMoney());
                System.out.println("На счету получателя: " + dst.getMoney());
            }
        }
    }
}
