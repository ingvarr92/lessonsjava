package lesson23.homeWork.bank;

public class Bank {
    public void transfer (Account src, Account dst, int money){

        Account obj1;
        Account obj2;

        // определить правильный порядок блокировки, во избежании взаимной блокировки

        // надо проверить меньший id и блокировать его

        if (src.getAccId()< dst.getAccId()){
            obj1 = src;
            obj2 = dst;
        } else{
            obj1 = dst;
            obj2 = src;
        }

        synchronized (obj1){
            synchronized (obj2) {
                    // реализация
                obj1.setAmount(obj1.getAmound() - money);
                obj2.setAmount(obj2.getAmound() + money);
            }
        }
    }

}
